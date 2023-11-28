package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbNewEditorTool;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class fh5 extends ge5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;
    public boolean c;

    /* loaded from: classes5.dex */
    public class a implements fe5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eh5 a;
        public final /* synthetic */ EditorTools b;
        public final /* synthetic */ fh5 c;

        public a(fh5 fh5Var, eh5 eh5Var, EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fh5Var, eh5Var, editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fh5Var;
            this.a = eh5Var;
            this.b = editorTools;
        }

        @Override // com.baidu.tieba.fe5
        public void U(ee5 ee5Var) {
            re5 u;
            se5 se5Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, ee5Var) != null) || ee5Var == null) {
                return;
            }
            int i = ee5Var.a;
            if (i != 4) {
                if (i != 16) {
                    if (i != 77) {
                        if (i != 7) {
                            if (i != 8) {
                                if (i != 10) {
                                    if (i == 11) {
                                        this.a.h0(null);
                                        EditorTools editorTools = this.b;
                                        if (editorTools != null && (u = editorTools.u(6)) != null && (se5Var = u.m) != null) {
                                            se5Var.U(new ee5(52, 0, null));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                Object obj = ee5Var.c;
                                if (obj instanceof VoiceData.VoiceModel) {
                                    this.a.h0((VoiceData.VoiceModel) obj);
                                    this.a.x(null);
                                    return;
                                }
                                return;
                            } else if (!this.c.h(this.a.u(), 11001)) {
                                return;
                            } else {
                                this.a.J();
                                TiebaStatic.log(TbadkCoreStatisticKey.SUBPB_CLICK_SEND);
                                return;
                            }
                        }
                        this.a.u().showToast((int) R.string.over_limit_tip);
                        this.c.a = true;
                        return;
                    }
                    this.a.y();
                    return;
                }
                if (this.c.a) {
                    this.a.u().showToast((int) R.string.over_limit_tip);
                }
                if (!this.c.h(this.a.u(), 11025)) {
                    return;
                }
                AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.u().getPageActivity(), 12005, true);
                if (this.a.w() != null) {
                    atListActivityConfig.setSelectedAtList(this.a.w().x());
                }
                EditorTools editorTools2 = this.b;
                if (editorTools2 != null) {
                    atListActivityConfig.setFromTid(editorTools2.getTid());
                    atListActivityConfig.setFromFid(String.valueOf(this.b.getFid()));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                EditorTools editorTools3 = this.b;
                if (editorTools3 != null) {
                    statisticItem.addParam("tid", editorTools3.getTid());
                    statisticItem.addParam("fid", this.b.getFid());
                }
                TiebaStatic.log(statisticItem);
                return;
            }
            Object obj2 = ee5Var.c;
            if (obj2 instanceof gh5) {
                this.a.d0((gh5) obj2);
                this.a.c0(((gh5) ee5Var.c).c);
            } else if (obj2 instanceof String) {
                this.a.W((String) obj2);
            } else if (obj2 instanceof SpanGroupManager) {
                this.a.W(obj2.toString());
                this.a.c0((SpanGroupManager) ee5Var.c);
            }
            this.c.a = false;
        }
    }

    public fh5(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.c = false;
        this.c = z;
    }

    @Override // com.baidu.tieba.ge5
    public ie5 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(true);
            int i = 5;
            editorTools.setBarMaxLauCount(5);
            editorTools.setBackgroundColorId(0);
            if (!this.c) {
                i = 2;
            }
            editorTools.setBarLauncherType(i);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.N(false);
            eh5 eh5Var = new eh5(editorTools);
            eh5Var.s = this.c;
            return eh5Var;
        }
        return (ie5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ge5
    public void c(ie5 ie5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ie5Var) != null) || ie5Var == null) {
            return;
        }
        EditorTools a2 = ie5Var.a();
        a aVar = new a(this, (eh5) ie5Var, a2);
        a2.setActionListener(4, aVar);
        a2.setActionListener(7, aVar);
        a2.setActionListener(16, aVar);
        a2.setActionListener(8, aVar);
        a2.setActionListener(10, aVar);
        a2.setActionListener(11, aVar);
        a2.setActionListener(77, aVar);
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.b = str;
        }
    }

    @Override // com.baidu.tieba.ge5
    public void d(ie5 ie5Var) {
        CustomResponsedMessage runTask;
        re5 re5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ie5Var) == null) {
            EditorTools a2 = ie5Var.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            a2.k(arrayList);
            re5 u = a2.u(5);
            if (u != null) {
                u.f(false);
                u.g(false);
                u.l = 1;
            }
            if (!this.c) {
                if (kya.a() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), re5.class)) != null && (re5Var = (re5) runTask.getData()) != null) {
                    re5Var.l = 2;
                    a2.f(re5Var);
                }
                a2.f(new te5(a2.getContext(), 4));
            }
            PbNewEditorTool pbNewEditorTool = new PbNewEditorTool(a2.getContext(), this.c, false, 12005);
            if (!rd.isEmpty(this.b)) {
                pbNewEditorTool.p(this.b);
            }
            pbNewEditorTool.o(PbNewEditorTool.InputShowType.REPLY_FLOOR);
            a2.f(pbNewEditorTool);
            a2.h();
            a2.K(new ee5(35, 5, Boolean.FALSE));
            a2.y();
            if (jh5.isOn()) {
                a2.K(new ee5(76, 27, Long.valueOf(a2.getFid())));
            }
        }
    }

    public final boolean h(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, tbPageContext, i)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                return true;
            }
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return invokeLI.booleanValue;
    }
}
