package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.ll9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b6a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements ll9.f {
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

        @Override // com.baidu.tieba.ll9.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C(new qc5(2, 12, null));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements ll9.f {
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

        @Override // com.baidu.tieba.ll9.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C(new qc5(2, 12, null));
            }
        }
    }

    public static a4a a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new a4a(tbPageContext);
        }
        return (a4a) invokeL.objValue;
    }

    public static c4a b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new c4a(tbPageContext);
        }
        return (c4a) invokeL.objValue;
    }

    public static e4a d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new e4a(tbPageContext);
        }
        return (e4a) invokeL.objValue;
    }

    public static f4a e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new f4a(tbPageContext);
        }
        return (f4a) invokeL.objValue;
    }

    public static g4a f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new g4a(tbPageContext);
        }
        return (g4a) invokeL.objValue;
    }

    public static h4a g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new h4a(tbPageContext);
        }
        return (h4a) invokeL.objValue;
    }

    public static j4a i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new j4a(tbPageContext);
        }
        return (j4a) invokeL.objValue;
    }

    public static k4a j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new k4a(tbPageContext);
        }
        return (k4a) invokeL.objValue;
    }

    public static l4a k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new l4a(tbPageContext);
        }
        return (l4a) invokeL.objValue;
    }

    public static m4a l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new m4a(tbPageContext);
        }
        return (m4a) invokeL.objValue;
    }

    public static p4a o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new p4a(tbPageContext);
        }
        return (p4a) invokeL.objValue;
    }

    public static q4a p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new q4a(tbPageContext);
        }
        return (q4a) invokeL.objValue;
    }

    public static r4a q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new r4a(tbPageContext);
        }
        return (r4a) invokeL.objValue;
    }

    public static s4a r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new s4a(tbPageContext);
        }
        return (s4a) invokeL.objValue;
    }

    public static d4a c(@NonNull TbPageContext<?> tbPageContext, @NonNull u4a u4aVar, @NonNull EditorTools editorTools, @NonNull n3a n3aVar, @NonNull f6a f6aVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, u4aVar, editorTools, n3aVar, f6aVar)) == null) {
            d4a d4aVar = new d4a(tbPageContext, n3aVar, f6aVar);
            d4aVar.X(u4aVar);
            d4aVar.e0(new a(editorTools));
            return d4aVar;
        }
        return (d4a) invokeLLLLL.objValue;
    }

    public static i4a h(@NonNull TbPageContext<?> tbPageContext, @NonNull j6a j6aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, j6aVar)) == null) {
            return new i4a(tbPageContext, j6aVar);
        }
        return (i4a) invokeLL.objValue;
    }

    public static n4a m(@NonNull TbPageContext<?> tbPageContext, @NonNull u4a u4aVar, @NonNull EditorTools editorTools, @NonNull j6a j6aVar, @NonNull n3a n3aVar, @NonNull f6a f6aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, u4aVar, editorTools, j6aVar, n3aVar, f6aVar})) == null) {
            n4a n4aVar = new n4a(tbPageContext, j6aVar, n3aVar, f6aVar);
            n4aVar.a0(u4aVar);
            n4aVar.c0(new b(editorTools));
            return n4aVar;
        }
        return (n4a) invokeCommon.objValue;
    }

    public static o4a n(@NonNull TbPageContext<?> tbPageContext, @NonNull u4a u4aVar, @NonNull n3a n3aVar, @NonNull f6a f6aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, u4aVar, n3aVar, f6aVar)) == null) {
            o4a o4aVar = new o4a(tbPageContext, n3aVar, f6aVar);
            o4aVar.M(u4aVar);
            return o4aVar;
        }
        return (o4a) invokeLLLL.objValue;
    }
}
