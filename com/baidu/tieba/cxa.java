package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.cba;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cxa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements cba.f {
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

        @Override // com.baidu.tieba.cba.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D(new lh5(2, 12, null));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements cba.f {
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

        @Override // com.baidu.tieba.cba.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D(new lh5(2, 12, null));
            }
        }
    }

    public static bva a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new bva(tbPageContext);
        }
        return (bva) invokeL.objValue;
    }

    public static dva b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new dva(tbPageContext);
        }
        return (dva) invokeL.objValue;
    }

    public static fva d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new fva(tbPageContext);
        }
        return (fva) invokeL.objValue;
    }

    public static gva e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new gva(tbPageContext);
        }
        return (gva) invokeL.objValue;
    }

    public static hva f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new hva(tbPageContext);
        }
        return (hva) invokeL.objValue;
    }

    public static iva g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new iva(tbPageContext);
        }
        return (iva) invokeL.objValue;
    }

    public static kva i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new kva(tbPageContext);
        }
        return (kva) invokeL.objValue;
    }

    public static lva j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new lva(tbPageContext);
        }
        return (lva) invokeL.objValue;
    }

    public static mva k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new mva(tbPageContext);
        }
        return (mva) invokeL.objValue;
    }

    public static nva l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new nva(tbPageContext);
        }
        return (nva) invokeL.objValue;
    }

    public static qva o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new qva(tbPageContext);
        }
        return (qva) invokeL.objValue;
    }

    public static rva p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new rva(tbPageContext);
        }
        return (rva) invokeL.objValue;
    }

    public static sva q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new sva(tbPageContext);
        }
        return (sva) invokeL.objValue;
    }

    public static tva r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new tva(tbPageContext);
        }
        return (tva) invokeL.objValue;
    }

    public static eva c(@NonNull TbPageContext<?> tbPageContext, @NonNull vva vvaVar, @NonNull EditorTools editorTools, @NonNull oua ouaVar, @NonNull gxa gxaVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, vvaVar, editorTools, ouaVar, gxaVar)) == null) {
            eva evaVar = new eva(tbPageContext, ouaVar, gxaVar);
            evaVar.U(vvaVar);
            evaVar.b0(new a(editorTools));
            return evaVar;
        }
        return (eva) invokeLLLLL.objValue;
    }

    public static jva h(@NonNull TbPageContext<?> tbPageContext, @NonNull kxa kxaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, kxaVar)) == null) {
            return new jva(tbPageContext, kxaVar);
        }
        return (jva) invokeLL.objValue;
    }

    public static ova m(@NonNull TbPageContext<?> tbPageContext, @NonNull vva vvaVar, @NonNull EditorTools editorTools, @NonNull kxa kxaVar, @NonNull oua ouaVar, @NonNull gxa gxaVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, vvaVar, editorTools, kxaVar, ouaVar, gxaVar})) == null) {
            ova ovaVar = new ova(tbPageContext, kxaVar, ouaVar, gxaVar);
            ovaVar.W(vvaVar);
            ovaVar.Y(new b(editorTools));
            return ovaVar;
        }
        return (ova) invokeCommon.objValue;
    }

    public static pva n(@NonNull TbPageContext<?> tbPageContext, @NonNull vva vvaVar, @NonNull oua ouaVar, @NonNull gxa gxaVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, vvaVar, ouaVar, gxaVar)) == null) {
            pva pvaVar = new pva(tbPageContext, ouaVar, gxaVar);
            pvaVar.M(vvaVar);
            return pvaVar;
        }
        return (pva) invokeLLLL.objValue;
    }
}
