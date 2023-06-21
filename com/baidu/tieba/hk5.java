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
/* loaded from: classes6.dex */
public class hk5 extends ai5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;
    public boolean c;

    /* loaded from: classes6.dex */
    public class a implements zh5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gk5 a;
        public final /* synthetic */ EditorTools b;
        public final /* synthetic */ hk5 c;

        public a(hk5 hk5Var, gk5 gk5Var, EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk5Var, gk5Var, editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = hk5Var;
            this.a = gk5Var;
            this.b = editorTools;
        }

        @Override // com.baidu.tieba.zh5
        public void C(yh5 yh5Var) {
            ki5 p;
            li5 li5Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, yh5Var) != null) || yh5Var == null) {
                return;
            }
            int i = yh5Var.a;
            if (i != 4) {
                if (i != 16) {
                    if (i != 77) {
                        if (i != 7) {
                            if (i != 8) {
                                if (i != 10) {
                                    if (i == 11) {
                                        this.a.f0(null);
                                        EditorTools editorTools = this.b;
                                        if (editorTools != null && (p = editorTools.p(6)) != null && (li5Var = p.m) != null) {
                                            li5Var.C(new yh5(52, 0, null));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                Object obj = yh5Var.c;
                                if (obj instanceof VoiceData.VoiceModel) {
                                    this.a.f0((VoiceData.VoiceModel) obj);
                                    this.a.w(null);
                                    return;
                                }
                                return;
                            } else if (!this.c.h(this.a.getContext(), 11001)) {
                                return;
                            } else {
                                this.a.H();
                                TiebaStatic.log(TbadkCoreStatisticKey.SUBPB_CLICK_SEND);
                                return;
                            }
                        }
                        this.a.getContext().showToast((int) R.string.over_limit_tip);
                        this.c.a = true;
                        return;
                    }
                    this.a.x();
                    return;
                }
                if (this.c.a) {
                    this.a.getContext().showToast((int) R.string.over_limit_tip);
                }
                if (!this.c.h(this.a.getContext(), 11025)) {
                    return;
                }
                AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.getContext().getPageActivity(), 12005, true);
                if (this.a.v() != null) {
                    atListActivityConfig.setSelectedAtList(this.a.v().w());
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
            Object obj2 = yh5Var.c;
            if (obj2 instanceof ik5) {
                this.a.b0((ik5) obj2);
                this.a.a0(((ik5) yh5Var.c).c);
            } else if (obj2 instanceof String) {
                this.a.U((String) obj2);
            } else if (obj2 instanceof SpanGroupManager) {
                this.a.U(obj2.toString());
                this.a.a0((SpanGroupManager) yh5Var.c);
            }
            this.c.a = false;
        }
    }

    public hk5(boolean z) {
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

    @Override // com.baidu.tieba.ai5
    public ci5 b(Context context) {
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
            editorTools.F(false);
            gk5 gk5Var = new gk5(editorTools);
            gk5Var.s = this.c;
            return gk5Var;
        }
        return (ci5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ai5
    public void c(ci5 ci5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ci5Var) != null) || ci5Var == null) {
            return;
        }
        EditorTools b = ci5Var.b();
        a aVar = new a(this, (gk5) ci5Var, b);
        b.setActionListener(4, aVar);
        b.setActionListener(7, aVar);
        b.setActionListener(16, aVar);
        b.setActionListener(8, aVar);
        b.setActionListener(10, aVar);
        b.setActionListener(11, aVar);
        b.setActionListener(77, aVar);
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.b = str;
        }
    }

    @Override // com.baidu.tieba.ai5
    public void d(ci5 ci5Var) {
        CustomResponsedMessage runTask;
        ki5 ki5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ci5Var) == null) {
            EditorTools b = ci5Var.b();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            b.h(arrayList);
            ki5 p = b.p(5);
            if (p != null) {
                p.e(false);
                p.f(false);
                p.l = 1;
            }
            if (!this.c) {
                if (v1a.a() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, b.getContext()), ki5.class)) != null && (ki5Var = (ki5) runTask.getData()) != null) {
                    ki5Var.l = 2;
                    b.d(ki5Var);
                }
                b.d(new mi5(b.getContext(), 4));
            }
            PbNewEditorTool pbNewEditorTool = new PbNewEditorTool(b.getContext(), this.c, false, 12005);
            if (!vi.isEmpty(this.b)) {
                pbNewEditorTool.n(this.b);
            }
            pbNewEditorTool.m(PbNewEditorTool.InputShowType.REPLY_FLOOR);
            b.d(pbNewEditorTool);
            b.f();
            b.C(new yh5(35, 5, Boolean.FALSE));
            b.s();
            if (lk5.isOn()) {
                b.C(new yh5(76, 27, Long.valueOf(b.getFid())));
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
