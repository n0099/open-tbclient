package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.xo8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b89 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements xo8.f {
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

        @Override // com.baidu.tieba.xo8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A(new l65(2, 12, null));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements xo8.f {
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

        @Override // com.baidu.tieba.xo8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A(new l65(2, 12, null));
            }
        }
    }

    public static a69 a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new a69(tbPageContext);
        }
        return (a69) invokeL.objValue;
    }

    public static c69 b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new c69(tbPageContext);
        }
        return (c69) invokeL.objValue;
    }

    public static e69 d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new e69(tbPageContext);
        }
        return (e69) invokeL.objValue;
    }

    public static f69 e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new f69(tbPageContext);
        }
        return (f69) invokeL.objValue;
    }

    public static g69 f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new g69(tbPageContext);
        }
        return (g69) invokeL.objValue;
    }

    public static h69 g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new h69(tbPageContext);
        }
        return (h69) invokeL.objValue;
    }

    public static j69 i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new j69(tbPageContext);
        }
        return (j69) invokeL.objValue;
    }

    public static k69 j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new k69(tbPageContext);
        }
        return (k69) invokeL.objValue;
    }

    public static l69 k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new l69(tbPageContext);
        }
        return (l69) invokeL.objValue;
    }

    public static m69 l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new m69(tbPageContext);
        }
        return (m69) invokeL.objValue;
    }

    public static p69 o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new p69(tbPageContext);
        }
        return (p69) invokeL.objValue;
    }

    public static q69 p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new q69(tbPageContext);
        }
        return (q69) invokeL.objValue;
    }

    public static r69 q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new r69(tbPageContext);
        }
        return (r69) invokeL.objValue;
    }

    public static s69 r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new s69(tbPageContext);
        }
        return (s69) invokeL.objValue;
    }

    public static d69 c(@NonNull TbPageContext<?> tbPageContext, @NonNull u69 u69Var, @NonNull EditorTools editorTools, @NonNull n59 n59Var, @NonNull f89 f89Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, u69Var, editorTools, n59Var, f89Var)) == null) {
            d69 d69Var = new d69(tbPageContext, n59Var, f89Var);
            d69Var.T(u69Var);
            d69Var.Z(new a(editorTools));
            return d69Var;
        }
        return (d69) invokeLLLLL.objValue;
    }

    public static i69 h(@NonNull TbPageContext<?> tbPageContext, @NonNull j89 j89Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, j89Var)) == null) {
            return new i69(tbPageContext, j89Var);
        }
        return (i69) invokeLL.objValue;
    }

    public static n69 m(@NonNull TbPageContext<?> tbPageContext, @NonNull u69 u69Var, @NonNull EditorTools editorTools, @NonNull j89 j89Var, @NonNull n59 n59Var, @NonNull f89 f89Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, u69Var, editorTools, j89Var, n59Var, f89Var})) == null) {
            n69 n69Var = new n69(tbPageContext, j89Var, n59Var, f89Var);
            n69Var.V(u69Var);
            n69Var.X(new b(editorTools));
            return n69Var;
        }
        return (n69) invokeCommon.objValue;
    }

    public static o69 n(@NonNull TbPageContext<?> tbPageContext, @NonNull u69 u69Var, @NonNull n59 n59Var, @NonNull f89 f89Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, u69Var, n59Var, f89Var)) == null) {
            o69 o69Var = new o69(tbPageContext, n59Var, f89Var);
            o69Var.M(u69Var);
            return o69Var;
        }
        return (o69) invokeLLLL.objValue;
    }
}
