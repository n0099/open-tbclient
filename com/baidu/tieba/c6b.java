package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.eha;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c6b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements eha.f {
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

        @Override // com.baidu.tieba.eha.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D(new si5(2, 12, null));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements eha.f {
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

        @Override // com.baidu.tieba.eha.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D(new si5(2, 12, null));
            }
        }
    }

    public static b4b a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new b4b(tbPageContext);
        }
        return (b4b) invokeL.objValue;
    }

    public static d4b b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new d4b(tbPageContext);
        }
        return (d4b) invokeL.objValue;
    }

    public static f4b d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new f4b(tbPageContext);
        }
        return (f4b) invokeL.objValue;
    }

    public static g4b e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new g4b(tbPageContext);
        }
        return (g4b) invokeL.objValue;
    }

    public static h4b f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new h4b(tbPageContext);
        }
        return (h4b) invokeL.objValue;
    }

    public static i4b g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new i4b(tbPageContext);
        }
        return (i4b) invokeL.objValue;
    }

    public static k4b i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new k4b(tbPageContext);
        }
        return (k4b) invokeL.objValue;
    }

    public static l4b j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new l4b(tbPageContext);
        }
        return (l4b) invokeL.objValue;
    }

    public static m4b k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new m4b(tbPageContext);
        }
        return (m4b) invokeL.objValue;
    }

    public static n4b l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new n4b(tbPageContext);
        }
        return (n4b) invokeL.objValue;
    }

    public static q4b o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new q4b(tbPageContext);
        }
        return (q4b) invokeL.objValue;
    }

    public static r4b p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new r4b(tbPageContext);
        }
        return (r4b) invokeL.objValue;
    }

    public static s4b q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new s4b(tbPageContext);
        }
        return (s4b) invokeL.objValue;
    }

    public static t4b r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new t4b(tbPageContext);
        }
        return (t4b) invokeL.objValue;
    }

    public static e4b c(@NonNull TbPageContext<?> tbPageContext, @NonNull v4b v4bVar, @NonNull EditorTools editorTools, @NonNull o3b o3bVar, @NonNull g6b g6bVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, v4bVar, editorTools, o3bVar, g6bVar)) == null) {
            e4b e4bVar = new e4b(tbPageContext, o3bVar, g6bVar);
            e4bVar.U(v4bVar);
            e4bVar.b0(new a(editorTools));
            return e4bVar;
        }
        return (e4b) invokeLLLLL.objValue;
    }

    public static j4b h(@NonNull TbPageContext<?> tbPageContext, @NonNull k6b k6bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, k6bVar)) == null) {
            return new j4b(tbPageContext, k6bVar);
        }
        return (j4b) invokeLL.objValue;
    }

    public static o4b m(@NonNull TbPageContext<?> tbPageContext, @NonNull v4b v4bVar, @NonNull EditorTools editorTools, @NonNull k6b k6bVar, @NonNull o3b o3bVar, @NonNull g6b g6bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, v4bVar, editorTools, k6bVar, o3bVar, g6bVar})) == null) {
            o4b o4bVar = new o4b(tbPageContext, k6bVar, o3bVar, g6bVar);
            o4bVar.W(v4bVar);
            o4bVar.Y(new b(editorTools));
            return o4bVar;
        }
        return (o4b) invokeCommon.objValue;
    }

    public static p4b n(@NonNull TbPageContext<?> tbPageContext, @NonNull v4b v4bVar, @NonNull o3b o3bVar, @NonNull g6b g6bVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, v4bVar, o3bVar, g6bVar)) == null) {
            p4b p4bVar = new p4b(tbPageContext, o3bVar, g6bVar);
            p4bVar.M(v4bVar);
            return p4bVar;
        }
        return (p4b) invokeLLLL.objValue;
    }
}
