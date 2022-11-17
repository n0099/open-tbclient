package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fh7 extends n85 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean F;
    public String G;
    public String H;
    public String I;
    public PermissionJudgePolicy J;

    /* loaded from: classes4.dex */
    public class a implements m65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fh7 a;

        public a(fh7 fh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fh7Var;
        }

        @Override // com.baidu.tieba.m65
        public void B(l65 l65Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, l65Var) == null) {
                Object obj = l65Var.c;
                if ((obj instanceof f25) && EmotionGroupType.isSendAsPic(((f25) obj).getType())) {
                    if (this.a.J == null) {
                        this.a.J = new PermissionJudgePolicy();
                    }
                    this.a.J.clearRequestPermissionList();
                    this.a.J.appendRequestPermission(this.a.m.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.J.startRequestPermission(this.a.m.getPageActivity())) {
                        return;
                    }
                    this.a.f((f25) l65Var.c);
                    this.a.w(false, null);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fh7(EditorTools editorTools) {
        super(editorTools);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {editorTools};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((EditorTools) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        editorTools.setActionListener(24, new a(this));
    }

    @Override // com.baidu.tieba.n85
    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (this.F) {
                po8.q(this.G, this);
            } else {
                po8.o(str, this);
            }
        }
    }

    @Override // com.baidu.tieba.n85
    public void G(String str, WriteData writeData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, writeData) == null) {
            if (this.g.S() == null) {
                this.g.setWriteData(s0());
            }
            if (this.g.S() == null) {
                return;
            }
            this.g.setSpanGroupManager(this.d);
            this.g.S().setIsBJHPost(this.t);
            this.g.S().setWriteImagesInfo(this.b);
            NewWriteModel newWriteModel = this.g;
            if (this.b.size() > 0) {
                z = true;
            } else {
                z = false;
            }
            newWriteModel.Z(z);
            if (str == null) {
                this.g.S().setContent(this.c);
            }
            VoiceData.VoiceModel voiceModel = this.e;
            if (voiceModel != null) {
                if (voiceModel.getId() != null) {
                    this.g.S().setVoice(this.e.getId());
                    this.g.S().setVoiceDuringTime(this.e.duration);
                } else {
                    this.g.S().setVoice(null);
                    this.g.S().setVoiceDuringTime(-1);
                }
            } else {
                this.g.S().setVoice(null);
                this.g.S().setVoiceDuringTime(-1);
            }
            if (!this.g.Q()) {
                this.m.showToast(R.string.obfuscated_res_0x7f0f1634);
                return;
            }
            k85 k85Var = this.w;
            if ((k85Var == null || !k85Var.a()) && !this.g.e0()) {
            }
        }
    }

    @Override // com.baidu.tieba.n85
    public void N(String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            WriteData S = this.g.S();
            if (S == null) {
                if (this.F) {
                    i = 2;
                } else {
                    i = 1;
                }
                S = new WriteData(i);
                S.setThreadId(str);
                S.setWriteImagesInfo(this.b);
            }
            if (!xi.isEmpty(this.I)) {
                S.setFromForumId(this.I);
            }
            S.setContent(this.c);
            S.setVoiceModel(this.e);
            if (this.F) {
                S.setReplyId(this.H);
                S.setThreadId(this.G);
                po8.A(this.G, S);
                return;
            }
            po8.y(str, S);
        }
    }

    public WriteData s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WriteData writeData = new WriteData();
            if (this.j != null) {
                if (this.x && !this.F) {
                    writeData.setCanNoForum(true);
                    writeData.setVForumId(this.j.getId());
                    writeData.setVForumName(this.j.getName());
                    writeData.setForumId("0");
                    writeData.setForumName("");
                } else {
                    writeData.setCanNoForum(false);
                    writeData.setVForumId("");
                    writeData.setVForumName("");
                    writeData.setForumId(this.j.getId());
                    writeData.setForumName(this.j.getName());
                }
            }
            writeData.setThreadId(this.l);
            if (!this.F) {
                writeData.setType(1);
            } else {
                writeData.setType(2);
                writeData.setFloor(this.G);
                writeData.setFloorNum(0);
                writeData.setReplyId(this.H);
                writeData.setRepostId(this.G);
            }
            return writeData;
        }
        return (WriteData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.n85
    public void w(boolean z, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, postWriteCallBackData) == null) {
            PbEditorData pbEditorData = new PbEditorData();
            pbEditorData.setEditorType(this.F ? 1 : 0);
            pbEditorData.setContent(this.c);
            pbEditorData.setWriteImagesInfo(this.b);
            pbEditorData.setVoiceModel(this.e);
            PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
            ForumData forumData = this.j;
            if (forumData != null) {
                threadData.setForumId(forumData.getId());
                threadData.setForumName(this.j.getName());
                threadData.setFirstDir(this.j.getFirst_class());
                threadData.setSecondDir(this.j.getSecond_class());
            }
            threadData.setAuthorId(this.q);
            threadData.setAuthorName(this.o);
            threadData.setAuthorNameShow(this.p);
            threadData.setPostId(this.G);
            threadData.setThreadId(this.l);
            threadData.isBJH = this.t;
            pbEditorData.setThreadData(threadData);
            pbEditorData.setDisableVoiceMessage(this.n);
            pbEditorData.setOpenVoiceRecordButton(z);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.m.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
        }
    }
}
