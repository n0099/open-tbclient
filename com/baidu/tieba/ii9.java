package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ii9 extends bj5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbEditorData.ThreadData a;
    public aj5 b;
    public boolean c;
    public boolean d;

    /* loaded from: classes6.dex */
    public class a implements aj5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hi9 a;
        public final /* synthetic */ ii9 b;

        public a(ii9 ii9Var, hi9 hi9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ii9Var, hi9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ii9Var;
            this.a = hi9Var;
        }

        @Override // com.baidu.tieba.aj5
        public void B(zi5 zi5Var) {
            hi9 hi9Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, zi5Var) != null) || (hi9Var = this.a) == null || hi9Var.b() == null || zi5Var == null) {
                return;
            }
            if (this.b.b != null) {
                this.b.b.B(zi5Var);
            }
            int i = zi5Var.a;
            if (i != 32) {
                if (i != 36) {
                    if (i == 43 && !zx5.c(this.a.getContext().getPageContext(), true, false)) {
                        HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(this.a.getContext().getActivity(), 25004, HotSelectActivityConfig.FROM_PB);
                        if (this.b.a != null) {
                            hotSelectActivityConfig.setForumExtra(wg.g(this.b.a.getForumId(), 0L), this.b.a.getFirstDir(), this.b.a.getSecondDir());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
                        return;
                    }
                    return;
                } else if (!this.b.h(this.a.getContext().getPageContext(), 11040)) {
                    return;
                } else {
                    this.a.f();
                    return;
                }
            }
            this.a.b().D(new zi5(1, 11, null));
        }
    }

    public ii9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = false;
        this.d = false;
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.d = z;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.c = z;
        }
    }

    public void k(aj5 aj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aj5Var) == null) {
            this.b = aj5Var;
        }
    }

    public void l(PbEditorData.ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, threadData) == null) {
            this.a = threadData;
        }
    }

    @Override // com.baidu.tieba.bj5
    public dj5 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(true);
            editorTools.setBarMaxLauCount(5);
            if (this.c) {
                editorTools.setBarLauncherType(2);
            } else if (this.d) {
                editorTools.setBarLauncherType(5);
            } else {
                editorTools.setBarLauncherType(3);
            }
            editorTools.setBackgroundColorId(0);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.G(true);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.F(true);
            return new hi9(editorTools);
        }
        return (dj5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.bj5
    public void c(dj5 dj5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dj5Var) != null) || !(dj5Var instanceof hi9)) {
            return;
        }
        EditorTools b = dj5Var.b();
        a aVar = new a(this, (hi9) dj5Var);
        b.setActionListener(16, aVar);
        b.setActionListener(14, aVar);
        b.setActionListener(15, aVar);
        b.setActionListener(24, aVar);
        b.setActionListener(3, aVar);
        b.setActionListener(10, aVar);
        b.setActionListener(11, aVar);
        b.setActionListener(36, aVar);
        b.setActionListener(32, aVar);
        b.setActionListener(43, aVar);
        b.setActionListener(45, aVar);
        b.setActionListener(77, aVar);
    }

    @Override // com.baidu.tieba.bj5
    public void d(dj5 dj5Var) {
        String str;
        CustomResponsedMessage runTask;
        lj5 lj5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dj5Var) == null) {
            EditorTools b = dj5Var.b();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            if (!this.c) {
                arrayList.add(10);
                b.d(new wj5(b.getContext(), 1));
            }
            if (!this.d) {
                arrayList.add(6);
                arrayList.add(9);
                PbEditorData.ThreadData threadData = this.a;
                if (threadData != null) {
                    str = threadData.getForumName();
                } else {
                    str = "";
                }
                if (sea.a() && wba.a(str, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, b.getContext()), lj5.class)) != null && (lj5Var = (lj5) runTask.getData()) != null) {
                    lj5Var.l = 2;
                    b.d(lj5Var);
                }
                b.d(new nj5(b.getContext(), 4));
                if (!this.c) {
                    CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, b.getContext()), lj5.class);
                    if (runTask2 != null && runTask2.getData() != null) {
                        lj5 lj5Var2 = (lj5) runTask2.getData();
                        lj5Var2.l = 6;
                        b.d(lj5Var2);
                    }
                    CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, b.getContext()), lj5.class);
                    if (runTask3 != null && runTask3.getData() != null) {
                        lj5 lj5Var3 = (lj5) runTask3.getData();
                        lj5Var3.l = 7;
                        b.d(lj5Var3);
                    }
                }
                if (!"PbChosenActivity".equals(b.getContext().getClass().getSimpleName()) && !this.c) {
                    b.d(new uj5(b.getContext(), 5));
                }
            }
            if (!this.c && !this.d) {
                arrayList.add(8);
            }
            b.h(arrayList);
            lj5 p = b.p(5);
            if (p != null) {
                p.l = 3;
                if (this.c || this.d) {
                    p.e(false);
                }
            }
            b.f();
            if (this.c || this.d) {
                b.D(new zi5(35, 5, Boolean.FALSE));
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
