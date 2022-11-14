package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.wo8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a89 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements wo8.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorTools a;

        public a(EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editorTools;
        }

        @Override // com.baidu.tieba.wo8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A(new k65(2, 12, null));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements wo8.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorTools a;

        public b(EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editorTools;
        }

        @Override // com.baidu.tieba.wo8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A(new k65(2, 12, null));
            }
        }
    }

    public static z59 a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new z59(tbPageContext);
        }
        return (z59) invokeL.objValue;
    }

    public static b69 b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new b69(tbPageContext);
        }
        return (b69) invokeL.objValue;
    }

    public static d69 d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new d69(tbPageContext);
        }
        return (d69) invokeL.objValue;
    }

    public static e69 e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new e69(tbPageContext);
        }
        return (e69) invokeL.objValue;
    }

    public static f69 f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new f69(tbPageContext);
        }
        return (f69) invokeL.objValue;
    }

    public static g69 g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new g69(tbPageContext);
        }
        return (g69) invokeL.objValue;
    }

    public static i69 i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new i69(tbPageContext);
        }
        return (i69) invokeL.objValue;
    }

    public static j69 j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new j69(tbPageContext);
        }
        return (j69) invokeL.objValue;
    }

    public static k69 k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new k69(tbPageContext);
        }
        return (k69) invokeL.objValue;
    }

    public static l69 l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new l69(tbPageContext);
        }
        return (l69) invokeL.objValue;
    }

    public static o69 o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new o69(tbPageContext);
        }
        return (o69) invokeL.objValue;
    }

    public static p69 p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new p69(tbPageContext);
        }
        return (p69) invokeL.objValue;
    }

    public static q69 q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new q69(tbPageContext);
        }
        return (q69) invokeL.objValue;
    }

    public static r69 r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new r69(tbPageContext);
        }
        return (r69) invokeL.objValue;
    }

    public static c69 c(@NonNull TbPageContext<?> tbPageContext, @NonNull t69 t69Var, @NonNull EditorTools editorTools, @NonNull m59 m59Var, @NonNull e89 e89Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, t69Var, editorTools, m59Var, e89Var)) == null) {
            c69 c69Var = new c69(tbPageContext, m59Var, e89Var);
            c69Var.T(t69Var);
            c69Var.Z(new a(editorTools));
            return c69Var;
        }
        return (c69) invokeLLLLL.objValue;
    }

    public static h69 h(@NonNull TbPageContext<?> tbPageContext, @NonNull i89 i89Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, i89Var)) == null) {
            return new h69(tbPageContext, i89Var);
        }
        return (h69) invokeLL.objValue;
    }

    public static m69 m(@NonNull TbPageContext<?> tbPageContext, @NonNull t69 t69Var, @NonNull EditorTools editorTools, @NonNull i89 i89Var, @NonNull m59 m59Var, @NonNull e89 e89Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, t69Var, editorTools, i89Var, m59Var, e89Var})) == null) {
            m69 m69Var = new m69(tbPageContext, i89Var, m59Var, e89Var);
            m69Var.V(t69Var);
            m69Var.X(new b(editorTools));
            return m69Var;
        }
        return (m69) invokeCommon.objValue;
    }

    public static n69 n(@NonNull TbPageContext<?> tbPageContext, @NonNull t69 t69Var, @NonNull m59 m59Var, @NonNull e89 e89Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, t69Var, m59Var, e89Var)) == null) {
            n69 n69Var = new n69(tbPageContext, m59Var, e89Var);
            n69Var.M(t69Var);
            return n69Var;
        }
        return (n69) invokeLLLL.objValue;
    }
}
