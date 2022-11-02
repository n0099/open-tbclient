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
/* loaded from: classes3.dex */
public class c08 extends g65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbEditorData.ThreadData a;
    public f65 b;
    public boolean c;
    public boolean d;

    /* loaded from: classes3.dex */
    public class a implements f65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b08 a;
        public final /* synthetic */ c08 b;

        public a(c08 c08Var, b08 b08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c08Var, b08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c08Var;
            this.a = b08Var;
        }

        @Override // com.baidu.tieba.f65
        public void B(e65 e65Var) {
            b08 b08Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, e65Var) != null) || (b08Var = this.a) == null || b08Var.b() == null || e65Var == null) {
                return;
            }
            if (this.b.b != null) {
                this.b.b.B(e65Var);
            }
            int i = e65Var.a;
            if (i != 32) {
                if (i != 36) {
                    if (i == 43 && !ki5.c(this.a.getContext().getPageContext(), true, false)) {
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
            this.a.b().A(new e65(1, 11, null));
        }
    }

    public c08() {
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

    public void k(f65 f65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, f65Var) == null) {
            this.b = f65Var;
        }
    }

    public void l(PbEditorData.ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, threadData) == null) {
            this.a = threadData;
        }
    }

    @Override // com.baidu.tieba.g65
    public i65 b(Context context) {
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
            editorTools.D(true);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.C(true);
            return new b08(editorTools);
        }
        return (i65) invokeL.objValue;
    }

    @Override // com.baidu.tieba.g65
    public void c(i65 i65Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i65Var) != null) || !(i65Var instanceof b08)) {
            return;
        }
        EditorTools b = i65Var.b();
        a aVar = new a(this, (b08) i65Var);
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
    }

    @Override // com.baidu.tieba.g65
    public void d(i65 i65Var) {
        String str;
        CustomResponsedMessage runTask;
        p65 p65Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, i65Var) == null) {
            EditorTools b = i65Var.b();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            if (!this.c) {
                arrayList.add(10);
                b.d(new a75(b.getContext(), 1));
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
                if (tq8.a() && yn8.a(str, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, b.getContext()), p65.class)) != null && (p65Var = (p65) runTask.getData()) != null) {
                    p65Var.l = 2;
                    b.d(p65Var);
                }
                b.d(new r65(b.getContext(), 4));
                if (!this.c) {
                    CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, b.getContext()), p65.class);
                    if (runTask2 != null && runTask2.getData() != null) {
                        p65 p65Var2 = (p65) runTask2.getData();
                        p65Var2.l = 6;
                        b.d(p65Var2);
                    }
                    CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, b.getContext()), p65.class);
                    if (runTask3 != null && runTask3.getData() != null) {
                        p65 p65Var3 = (p65) runTask3.getData();
                        p65Var3.l = 7;
                        b.d(p65Var3);
                    }
                }
                if (!"PbChosenActivity".equals(b.getContext().getClass().getSimpleName()) && !this.c) {
                    b.d(new y65(b.getContext(), 5));
                }
            }
            if (!this.c && !this.d) {
                arrayList.add(8);
            }
            b.h(arrayList);
            p65 n = b.n(5);
            if (n != null) {
                n.l = 3;
                if (this.c || this.d) {
                    n.e(false);
                }
            }
            b.f();
            if (this.c || this.d) {
                b.A(new e65(35, 5, Boolean.FALSE));
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
