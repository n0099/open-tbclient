package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.dr9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class aca {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements dr9.f {
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

        @Override // com.baidu.tieba.dr9.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C(new se5(2, 12, null));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements dr9.f {
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

        @Override // com.baidu.tieba.dr9.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C(new se5(2, 12, null));
            }
        }
    }

    public static z9a a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new z9a(tbPageContext);
        }
        return (z9a) invokeL.objValue;
    }

    public static baa b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new baa(tbPageContext);
        }
        return (baa) invokeL.objValue;
    }

    public static daa d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new daa(tbPageContext);
        }
        return (daa) invokeL.objValue;
    }

    public static eaa e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new eaa(tbPageContext);
        }
        return (eaa) invokeL.objValue;
    }

    public static faa f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new faa(tbPageContext);
        }
        return (faa) invokeL.objValue;
    }

    public static gaa g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new gaa(tbPageContext);
        }
        return (gaa) invokeL.objValue;
    }

    public static iaa i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new iaa(tbPageContext);
        }
        return (iaa) invokeL.objValue;
    }

    public static jaa j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new jaa(tbPageContext);
        }
        return (jaa) invokeL.objValue;
    }

    public static kaa k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new kaa(tbPageContext);
        }
        return (kaa) invokeL.objValue;
    }

    public static laa l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new laa(tbPageContext);
        }
        return (laa) invokeL.objValue;
    }

    public static oaa o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new oaa(tbPageContext);
        }
        return (oaa) invokeL.objValue;
    }

    public static paa p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new paa(tbPageContext);
        }
        return (paa) invokeL.objValue;
    }

    public static qaa q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new qaa(tbPageContext);
        }
        return (qaa) invokeL.objValue;
    }

    public static raa r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new raa(tbPageContext);
        }
        return (raa) invokeL.objValue;
    }

    public static caa c(@NonNull TbPageContext<?> tbPageContext, @NonNull taa taaVar, @NonNull EditorTools editorTools, @NonNull m9a m9aVar, @NonNull eca ecaVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, taaVar, editorTools, m9aVar, ecaVar)) == null) {
            caa caaVar = new caa(tbPageContext, m9aVar, ecaVar);
            caaVar.T(taaVar);
            caaVar.a0(new a(editorTools));
            return caaVar;
        }
        return (caa) invokeLLLLL.objValue;
    }

    public static haa h(@NonNull TbPageContext<?> tbPageContext, @NonNull ica icaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, icaVar)) == null) {
            return new haa(tbPageContext, icaVar);
        }
        return (haa) invokeLL.objValue;
    }

    public static maa m(@NonNull TbPageContext<?> tbPageContext, @NonNull taa taaVar, @NonNull EditorTools editorTools, @NonNull ica icaVar, @NonNull m9a m9aVar, @NonNull eca ecaVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, taaVar, editorTools, icaVar, m9aVar, ecaVar})) == null) {
            maa maaVar = new maa(tbPageContext, icaVar, m9aVar, ecaVar);
            maaVar.W(taaVar);
            maaVar.Y(new b(editorTools));
            return maaVar;
        }
        return (maa) invokeCommon.objValue;
    }

    public static naa n(@NonNull TbPageContext<?> tbPageContext, @NonNull taa taaVar, @NonNull m9a m9aVar, @NonNull eca ecaVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, taaVar, m9aVar, ecaVar)) == null) {
            naa naaVar = new naa(tbPageContext, m9aVar, ecaVar);
            naaVar.M(taaVar);
            return naaVar;
        }
        return (naa) invokeLLLL.objValue;
    }
}
