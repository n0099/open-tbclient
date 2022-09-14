package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.gm8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements gm8.f {
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

        @Override // com.baidu.tieba.gm8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A(new u45(2, 12, null));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements gm8.f {
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

        @Override // com.baidu.tieba.gm8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A(new u45(2, 12, null));
            }
        }
    }

    public static h39 a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) ? new h39(tbPageContext) : (h39) invokeL.objValue;
    }

    public static j39 b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) ? new j39(tbPageContext) : (j39) invokeL.objValue;
    }

    public static k39 c(@NonNull TbPageContext<?> tbPageContext, @NonNull z39 z39Var, @NonNull EditorTools editorTools, @NonNull x29 x29Var, @NonNull e59 e59Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, z39Var, editorTools, x29Var, e59Var)) == null) {
            k39 k39Var = new k39(tbPageContext, x29Var, e59Var);
            k39Var.R(z39Var);
            k39Var.W(new a(editorTools));
            return k39Var;
        }
        return (k39) invokeLLLLL.objValue;
    }

    public static l39 d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) ? new l39(tbPageContext) : (l39) invokeL.objValue;
    }

    public static m39 e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) ? new m39(tbPageContext) : (m39) invokeL.objValue;
    }

    public static n39 f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) ? new n39(tbPageContext) : (n39) invokeL.objValue;
    }

    public static o39 g(@NonNull TbPageContext<?> tbPageContext, @NonNull i59 i59Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, tbPageContext, i59Var)) == null) ? new o39(tbPageContext, i59Var) : (o39) invokeLL.objValue;
    }

    public static p39 h(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, tbPageContext)) == null) ? new p39(tbPageContext) : (p39) invokeL.objValue;
    }

    public static q39 i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) ? new q39(tbPageContext) : (q39) invokeL.objValue;
    }

    public static r39 j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) ? new r39(tbPageContext) : (r39) invokeL.objValue;
    }

    public static s39 k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) ? new s39(tbPageContext) : (s39) invokeL.objValue;
    }

    public static t39 l(@NonNull TbPageContext<?> tbPageContext, @NonNull z39 z39Var, @NonNull EditorTools editorTools, @NonNull i59 i59Var, @NonNull x29 x29Var, @NonNull e59 e59Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{tbPageContext, z39Var, editorTools, i59Var, x29Var, e59Var})) == null) {
            t39 t39Var = new t39(tbPageContext, i59Var, x29Var, e59Var);
            t39Var.T(z39Var);
            t39Var.V(new b(editorTools));
            return t39Var;
        }
        return (t39) invokeCommon.objValue;
    }

    public static u39 m(@NonNull TbPageContext<?> tbPageContext, @NonNull z39 z39Var, @NonNull x29 x29Var, @NonNull e59 e59Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, z39Var, x29Var, e59Var)) == null) {
            u39 u39Var = new u39(tbPageContext, x29Var, e59Var);
            u39Var.K(z39Var);
            return u39Var;
        }
        return (u39) invokeLLLL.objValue;
    }

    public static v39 n(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, tbPageContext)) == null) ? new v39(tbPageContext) : (v39) invokeL.objValue;
    }

    public static w39 o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) ? new w39(tbPageContext) : (w39) invokeL.objValue;
    }

    public static x39 p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) ? new x39(tbPageContext) : (x39) invokeL.objValue;
    }
}
