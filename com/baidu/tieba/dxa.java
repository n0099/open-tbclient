package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.dba;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dxa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements dba.f {
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

        @Override // com.baidu.tieba.dba.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D(new lh5(2, 12, null));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements dba.f {
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

        @Override // com.baidu.tieba.dba.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D(new lh5(2, 12, null));
            }
        }
    }

    public static cva a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new cva(tbPageContext);
        }
        return (cva) invokeL.objValue;
    }

    public static eva b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new eva(tbPageContext);
        }
        return (eva) invokeL.objValue;
    }

    public static gva d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new gva(tbPageContext);
        }
        return (gva) invokeL.objValue;
    }

    public static hva e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new hva(tbPageContext);
        }
        return (hva) invokeL.objValue;
    }

    public static iva f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new iva(tbPageContext);
        }
        return (iva) invokeL.objValue;
    }

    public static jva g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new jva(tbPageContext);
        }
        return (jva) invokeL.objValue;
    }

    public static lva i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new lva(tbPageContext);
        }
        return (lva) invokeL.objValue;
    }

    public static mva j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new mva(tbPageContext);
        }
        return (mva) invokeL.objValue;
    }

    public static nva k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new nva(tbPageContext);
        }
        return (nva) invokeL.objValue;
    }

    public static ova l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new ova(tbPageContext);
        }
        return (ova) invokeL.objValue;
    }

    public static rva o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new rva(tbPageContext);
        }
        return (rva) invokeL.objValue;
    }

    public static sva p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new sva(tbPageContext);
        }
        return (sva) invokeL.objValue;
    }

    public static tva q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new tva(tbPageContext);
        }
        return (tva) invokeL.objValue;
    }

    public static uva r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new uva(tbPageContext);
        }
        return (uva) invokeL.objValue;
    }

    public static fva c(@NonNull TbPageContext<?> tbPageContext, @NonNull wva wvaVar, @NonNull EditorTools editorTools, @NonNull pua puaVar, @NonNull hxa hxaVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, wvaVar, editorTools, puaVar, hxaVar)) == null) {
            fva fvaVar = new fva(tbPageContext, puaVar, hxaVar);
            fvaVar.U(wvaVar);
            fvaVar.b0(new a(editorTools));
            return fvaVar;
        }
        return (fva) invokeLLLLL.objValue;
    }

    public static kva h(@NonNull TbPageContext<?> tbPageContext, @NonNull lxa lxaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, lxaVar)) == null) {
            return new kva(tbPageContext, lxaVar);
        }
        return (kva) invokeLL.objValue;
    }

    public static pva m(@NonNull TbPageContext<?> tbPageContext, @NonNull wva wvaVar, @NonNull EditorTools editorTools, @NonNull lxa lxaVar, @NonNull pua puaVar, @NonNull hxa hxaVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, wvaVar, editorTools, lxaVar, puaVar, hxaVar})) == null) {
            pva pvaVar = new pva(tbPageContext, lxaVar, puaVar, hxaVar);
            pvaVar.W(wvaVar);
            pvaVar.Y(new b(editorTools));
            return pvaVar;
        }
        return (pva) invokeCommon.objValue;
    }

    public static qva n(@NonNull TbPageContext<?> tbPageContext, @NonNull wva wvaVar, @NonNull pua puaVar, @NonNull hxa hxaVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, wvaVar, puaVar, hxaVar)) == null) {
            qva qvaVar = new qva(tbPageContext, puaVar, hxaVar);
            qvaVar.M(wvaVar);
            return qvaVar;
        }
        return (qva) invokeLLLL.objValue;
    }
}
