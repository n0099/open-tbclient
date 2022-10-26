package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.cn8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class g69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public final class a implements cn8.f {
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

        @Override // com.baidu.tieba.cn8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A(new l55(2, 12, null));
            }
        }
    }

    /* loaded from: classes4.dex */
    public final class b implements cn8.f {
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

        @Override // com.baidu.tieba.cn8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A(new l55(2, 12, null));
            }
        }
    }

    public static f49 a(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new f49(tbPageContext);
        }
        return (f49) invokeL.objValue;
    }

    public static h49 b(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new h49(tbPageContext);
        }
        return (h49) invokeL.objValue;
    }

    public static j49 d(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new j49(tbPageContext);
        }
        return (j49) invokeL.objValue;
    }

    public static k49 e(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new k49(tbPageContext);
        }
        return (k49) invokeL.objValue;
    }

    public static l49 f(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new l49(tbPageContext);
        }
        return (l49) invokeL.objValue;
    }

    public static m49 g(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new m49(tbPageContext);
        }
        return (m49) invokeL.objValue;
    }

    public static o49 i(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new o49(tbPageContext);
        }
        return (o49) invokeL.objValue;
    }

    public static p49 j(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new p49(tbPageContext);
        }
        return (p49) invokeL.objValue;
    }

    public static q49 k(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new q49(tbPageContext);
        }
        return (q49) invokeL.objValue;
    }

    public static r49 l(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new r49(tbPageContext);
        }
        return (r49) invokeL.objValue;
    }

    public static u49 o(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new u49(tbPageContext);
        }
        return (u49) invokeL.objValue;
    }

    public static v49 p(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new v49(tbPageContext);
        }
        return (v49) invokeL.objValue;
    }

    public static w49 q(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new w49(tbPageContext);
        }
        return (w49) invokeL.objValue;
    }

    public static x49 r(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new x49(tbPageContext);
        }
        return (x49) invokeL.objValue;
    }

    public static i49 c(TbPageContext tbPageContext, z49 z49Var, EditorTools editorTools, s39 s39Var, k69 k69Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, z49Var, editorTools, s39Var, k69Var)) == null) {
            i49 i49Var = new i49(tbPageContext, s39Var, k69Var);
            i49Var.T(z49Var);
            i49Var.Z(new a(editorTools));
            return i49Var;
        }
        return (i49) invokeLLLLL.objValue;
    }

    public static n49 h(TbPageContext tbPageContext, o69 o69Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, o69Var)) == null) {
            return new n49(tbPageContext, o69Var);
        }
        return (n49) invokeLL.objValue;
    }

    public static s49 m(TbPageContext tbPageContext, z49 z49Var, EditorTools editorTools, o69 o69Var, s39 s39Var, k69 k69Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, z49Var, editorTools, o69Var, s39Var, k69Var})) == null) {
            s49 s49Var = new s49(tbPageContext, o69Var, s39Var, k69Var);
            s49Var.V(z49Var);
            s49Var.X(new b(editorTools));
            return s49Var;
        }
        return (s49) invokeCommon.objValue;
    }

    public static t49 n(TbPageContext tbPageContext, z49 z49Var, s39 s39Var, k69 k69Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, z49Var, s39Var, k69Var)) == null) {
            t49 t49Var = new t49(tbPageContext, s39Var, k69Var);
            t49Var.M(z49Var);
            return t49Var;
        }
        return (t49) invokeLLLL.objValue;
    }
}
