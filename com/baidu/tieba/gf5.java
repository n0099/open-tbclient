package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbNewEditorTool;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class gf5 extends if5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements dd5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hf5 a;
        public final /* synthetic */ EditorTools b;
        public final /* synthetic */ gf5 c;

        public a(gf5 gf5Var, hf5 hf5Var, EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gf5Var, hf5Var, editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gf5Var;
            this.a = hf5Var;
            this.b = editorTools;
        }

        @Override // com.baidu.tieba.dd5
        public void O(cd5 cd5Var) {
            hf5 hf5Var;
            int size;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, cd5Var) != null) || (hf5Var = this.a) == null || hf5Var.a() == null || cd5Var == null) {
                return;
            }
            int i = cd5Var.a;
            if (i != 4) {
                if (i != 5) {
                    if (i != 7) {
                        if (i != 8) {
                            if (i != 14) {
                                if (i == 15) {
                                    int intValue = ((Integer) cd5Var.c).intValue();
                                    if (this.a.w() != null && this.a.w().getChosedFiles() != null && (size = this.a.w().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.a.q().getPageActivity(), CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, this.a.w(), intValue)));
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            if (this.a.w() != null) {
                                this.a.w().setMaxImagesAllowed(1);
                            }
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.a.q().getPageActivity(), this.a.w().toJsonString(), true, true);
                            if (!StringUtils.isNull(this.c.m(), true)) {
                                albumActivityConfig.getIntent().putExtra("from", this.c.m());
                            }
                            if (this.c.l() != null && !StringUtils.isNull(this.c.l().getId(), true)) {
                                albumActivityConfig.getIntent().putExtra("forum_id", this.c.l().getId());
                            }
                            albumActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                            BdUtilHelper.hideSoftKeyPad(this.a.q().getPageActivity(), this.a.q().getPageActivity().getCurrentFocus());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                            return;
                        } else if (!this.c.k(this.a.q(), 11001)) {
                            return;
                        } else {
                            this.a.I(null, null);
                            return;
                        }
                    }
                    this.a.q().showToast(R.string.over_limit_tip);
                    return;
                } else if (!this.b.x()) {
                    TiebaStatic.eventStat(this.b.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
                    return;
                } else {
                    return;
                }
            }
            this.a.g0(cd5Var.c.toString());
        }
    }

    public gf5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, this, tbPageContext, i)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                return true;
            }
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return invokeLI.booleanValue;
    }

    @Override // com.baidu.tieba.if5, com.baidu.tieba.ed5
    public gd5 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(true);
            editorTools.setBarMaxLauCount(5);
            editorTools.setBarLauncherType(5);
            editorTools.setBackgroundColorId(0);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0201);
            editorTools.G(false);
            editorTools.setMoreButtonAtEnd(true);
            hf5 hf5Var = new hf5(editorTools);
            hf5Var.d0(n());
            hf5Var.t = true;
            return hf5Var;
        }
        return (gd5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.if5, com.baidu.tieba.ed5
    public void c(gd5 gd5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gd5Var) != null) || !(gd5Var instanceof hf5)) {
            return;
        }
        EditorTools a2 = gd5Var.a();
        a aVar = new a(this, (hf5) gd5Var, a2);
        a2.setActionListener(5, aVar);
        a2.setActionListener(4, aVar);
        a2.setActionListener(7, aVar);
        a2.setActionListener(14, aVar);
        a2.setActionListener(15, aVar);
        a2.setActionListener(8, aVar);
        a2.setActionListener(32, aVar);
        a2.setActionListener(45, aVar);
    }

    @Override // com.baidu.tieba.if5, com.baidu.tieba.ed5
    public void d(gd5 gd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gd5Var) == null) {
            EditorTools a2 = gd5Var.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            a2.d(new zd5(a2.getContext(), 1));
            a2.d(new PbNewEditorTool(a2.getContext(), true, false, 12004));
            a2.h(arrayList);
            od5 p = a2.p(5);
            if (p != null) {
                p.l = 2;
                p.f(false);
            }
            a2.f();
            a2.D(new cd5(35, 5, Boolean.FALSE));
        }
    }
}
