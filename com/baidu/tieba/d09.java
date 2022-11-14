package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d09 extends m65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* loaded from: classes3.dex */
    public interface b {
        void a(String str);
    }

    /* loaded from: classes3.dex */
    public class a implements l65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c09 a;
        public final /* synthetic */ d09 b;

        public a(d09 d09Var, c09 c09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d09Var, c09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = d09Var;
            this.a = c09Var;
        }

        @Override // com.baidu.tieba.l65
        public void B(k65 k65Var) {
            c09 c09Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, k65Var) != null) || (c09Var = this.a) == null || c09Var.b() == null || k65Var == null) {
                return;
            }
            int i = k65Var.a;
            if (i != 4) {
                if (i != 7) {
                    if (i == 8) {
                        this.a.z();
                        if (!this.b.h(this.a.getContext(), 25066)) {
                            return;
                        }
                        this.a.p();
                        if (this.b.a != null) {
                            this.b.a.a(this.a.m());
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.a.getContext().showToast((int) R.string.obfuscated_res_0x7f0f0d61);
                return;
            }
            this.a.v((String) k65Var.c);
        }
    }

    public d09() {
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

    @Override // com.baidu.tieba.m65
    public o65 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setHideBigEmotion(true);
            editorTools.setBarLauncherType(4);
            editorTools.setBackgroundColorId(R.color.CAM_X0207);
            return new c09(editorTools);
        }
        return (o65) invokeL.objValue;
    }

    @Override // com.baidu.tieba.m65
    public void c(o65 o65Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o65Var) != null) || !(o65Var instanceof c09)) {
            return;
        }
        EditorTools b2 = o65Var.b();
        a aVar = new a(this, (c09) o65Var);
        b2.setActionListener(4, aVar);
        b2.setActionListener(7, aVar);
        b2.setActionListener(8, aVar);
    }

    @Override // com.baidu.tieba.m65
    public void d(o65 o65Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, o65Var) != null) || o65Var == null) {
            return;
        }
        EditorTools b2 = o65Var.b();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        b2.h(arrayList);
        v65 n = b2.n(5);
        if (n != null) {
            n.e(false);
            n.d = 0;
        }
        b2.d(new e09(b2.getContext()));
        b2.f();
        b2.A(new k65(35, 5, Boolean.FALSE));
        b2.o();
    }

    public o65 g(Context context, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, bVar)) == null) {
            this.a = bVar;
            return super.a(context);
        }
        return (o65) invokeLL.objValue;
    }

    public final boolean h(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, tbPageContext, i)) == null) {
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
