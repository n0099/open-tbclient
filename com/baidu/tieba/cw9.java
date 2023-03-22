package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.mb9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class cw9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements mb9.f {
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

        @Override // com.baidu.tieba.mb9.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C(new lb5(2, 12, null));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements mb9.f {
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

        @Override // com.baidu.tieba.mb9.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C(new lb5(2, 12, null));
            }
        }
    }

    public static bu9 a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new bu9(tbPageContext);
        }
        return (bu9) invokeL.objValue;
    }

    public static du9 b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new du9(tbPageContext);
        }
        return (du9) invokeL.objValue;
    }

    public static fu9 d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new fu9(tbPageContext);
        }
        return (fu9) invokeL.objValue;
    }

    public static gu9 e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new gu9(tbPageContext);
        }
        return (gu9) invokeL.objValue;
    }

    public static hu9 f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new hu9(tbPageContext);
        }
        return (hu9) invokeL.objValue;
    }

    public static iu9 g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new iu9(tbPageContext);
        }
        return (iu9) invokeL.objValue;
    }

    public static ku9 i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new ku9(tbPageContext);
        }
        return (ku9) invokeL.objValue;
    }

    public static lu9 j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new lu9(tbPageContext);
        }
        return (lu9) invokeL.objValue;
    }

    public static mu9 k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new mu9(tbPageContext);
        }
        return (mu9) invokeL.objValue;
    }

    public static nu9 l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new nu9(tbPageContext);
        }
        return (nu9) invokeL.objValue;
    }

    public static qu9 o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new qu9(tbPageContext);
        }
        return (qu9) invokeL.objValue;
    }

    public static ru9 p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new ru9(tbPageContext);
        }
        return (ru9) invokeL.objValue;
    }

    public static su9 q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new su9(tbPageContext);
        }
        return (su9) invokeL.objValue;
    }

    public static tu9 r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new tu9(tbPageContext);
        }
        return (tu9) invokeL.objValue;
    }

    public static eu9 c(@NonNull TbPageContext<?> tbPageContext, @NonNull vu9 vu9Var, @NonNull EditorTools editorTools, @NonNull ot9 ot9Var, @NonNull gw9 gw9Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, vu9Var, editorTools, ot9Var, gw9Var)) == null) {
            eu9 eu9Var = new eu9(tbPageContext, ot9Var, gw9Var);
            eu9Var.X(vu9Var);
            eu9Var.e0(new a(editorTools));
            return eu9Var;
        }
        return (eu9) invokeLLLLL.objValue;
    }

    public static ju9 h(@NonNull TbPageContext<?> tbPageContext, @NonNull kw9 kw9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, kw9Var)) == null) {
            return new ju9(tbPageContext, kw9Var);
        }
        return (ju9) invokeLL.objValue;
    }

    public static ou9 m(@NonNull TbPageContext<?> tbPageContext, @NonNull vu9 vu9Var, @NonNull EditorTools editorTools, @NonNull kw9 kw9Var, @NonNull ot9 ot9Var, @NonNull gw9 gw9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, vu9Var, editorTools, kw9Var, ot9Var, gw9Var})) == null) {
            ou9 ou9Var = new ou9(tbPageContext, kw9Var, ot9Var, gw9Var);
            ou9Var.a0(vu9Var);
            ou9Var.c0(new b(editorTools));
            return ou9Var;
        }
        return (ou9) invokeCommon.objValue;
    }

    public static pu9 n(@NonNull TbPageContext<?> tbPageContext, @NonNull vu9 vu9Var, @NonNull ot9 ot9Var, @NonNull gw9 gw9Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, vu9Var, ot9Var, gw9Var)) == null) {
            pu9 pu9Var = new pu9(tbPageContext, ot9Var, gw9Var);
            pu9Var.M(vu9Var);
            return pu9Var;
        }
        return (pu9) invokeLLLL.objValue;
    }
}
