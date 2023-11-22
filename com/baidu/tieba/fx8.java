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
import com.baidu.tbadk.editortools.meme.list.MemeData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.pb.bot.BotEntranceManager;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class fx8 extends vg5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean L;
    public String M;
    public String N;
    public String O;
    public boolean P;
    public String Q;
    public int R;
    public PermissionJudgePolicy S;

    /* loaded from: classes6.dex */
    public class a implements zd5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fx8 a;

        public a(fx8 fx8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fx8Var;
        }

        @Override // com.baidu.tieba.zd5
        public void S(yd5 yd5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, yd5Var) == null) {
                Object obj = yd5Var.c;
                if ((obj instanceof m85) && EmotionGroupType.isSendAsPic(((m85) obj).g())) {
                    if (this.a.S == null) {
                        this.a.S = new PermissionJudgePolicy();
                    }
                    this.a.S.clearRequestPermissionList();
                    this.a.S.appendRequestPermission(this.a.m.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.S.startRequestPermission(this.a.m.getPageActivity())) {
                        return;
                    }
                    this.a.g((m85) yd5Var.c);
                    this.a.z(false, null);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fx8(EditorTools editorTools) {
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

    @Override // com.baidu.tieba.vg5
    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (this.L) {
                yqa.t(this.M, this);
            } else {
                yqa.r(str, this);
            }
        }
    }

    @Override // com.baidu.tieba.vg5
    public void A() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str2 = this.c;
            ForumData forumData = this.j;
            if (forumData != null) {
                str = String.valueOf(forumData.getId());
            } else {
                str = "";
            }
            ee5.e(str2, str);
        }
    }

    @Override // com.baidu.tieba.vg5
    public void K(String str, WriteData writeData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, writeData) == null) {
            if (this.g.e0() == null) {
                this.g.setWriteData(x0());
            }
            if (this.g.e0() == null) {
                return;
            }
            this.g.e0().setIsBJHPost(this.t);
            this.g.e0().setBotConfig(BotEntranceManager.h().i());
            this.g.e0().setWriteImagesInfo(this.b);
            NewWriteModel newWriteModel = this.g;
            if (this.b.size() > 0) {
                z = true;
            } else {
                z = false;
            }
            newWriteModel.k0(z);
            if (str == null) {
                this.g.e0().setContent(this.c);
            }
            VoiceData.VoiceModel voiceModel = this.e;
            if (voiceModel != null) {
                if (voiceModel.getId() != null) {
                    this.g.e0().setVoice(this.e.getId());
                    this.g.e0().setVoiceDuringTime(this.e.getDuration());
                } else {
                    this.g.e0().setVoice(null);
                    this.g.e0().setVoiceDuringTime(-1);
                }
            } else {
                this.g.e0().setVoice(null);
                this.g.e0().setVoiceDuringTime(-1);
            }
            if (!this.g.c0()) {
                this.m.showToast(R.string.write_img_limit);
                return;
            }
            rg5 rg5Var = this.w;
            if (rg5Var != null && rg5Var.a()) {
                return;
            }
            this.g.e0().onPostDataParse(this.d);
            if (!this.g.p0()) {
            }
        }
    }

    @Override // com.baidu.tieba.vg5
    public void R(String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            WriteData e0 = this.g.e0();
            if (e0 == null) {
                if (this.L) {
                    i = 2;
                } else {
                    i = 1;
                }
                e0 = new WriteData(i);
                e0.setThreadId(str);
                e0.setWriteImagesInfo(this.b);
            }
            e0.onSaveDrafDataParse(this.d);
            if (!qd.isEmpty(this.O)) {
                e0.setFromForumId(this.O);
            }
            e0.setContent(this.c);
            e0.setVoiceModel(this.e);
            if (this.L) {
                e0.setReplyId(this.N);
                e0.setThreadId(this.M);
                yqa.E(this.M, e0);
                return;
            }
            yqa.C(str, e0);
        }
    }

    public WriteData x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            WriteData writeData = new WriteData();
            if (this.j != null) {
                if (this.x && !this.L) {
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
            if (!this.L) {
                writeData.setType(1);
                if (this.P) {
                    writeData.setSpriteMemeQuery(this.Q);
                    writeData.setSpriteMemeId(String.valueOf(this.R));
                }
            } else {
                writeData.setType(2);
                writeData.setFloor(this.M);
                writeData.setFloorNum(0);
                writeData.setReplyId(this.N);
                writeData.setRepostId(this.M);
            }
            return writeData;
        }
        return (WriteData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vg5
    public void z(boolean z, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048581, this, z, postWriteCallBackData) == null) {
            PbEditorData pbEditorData = new PbEditorData();
            pbEditorData.setEditorType(this.L ? 1 : 0);
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
            threadData.setPostId(this.M);
            threadData.setThreadId(this.l);
            threadData.isBJH = this.t;
            pbEditorData.setThreadData(threadData);
            pbEditorData.setDisableVoiceMessage(this.n);
            pbEditorData.setOpenVoiceRecordButton(z);
            MemeData memeData = this.D;
            if (memeData != null) {
                pbEditorData.setMemeQuery(memeData.getRequestQuery());
                pbEditorData.setMemeId((int) this.D.getId());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.m.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
        }
    }
}
