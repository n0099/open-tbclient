package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.y3a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bpa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements y3a.f {
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

        @Override // com.baidu.tieba.y3a.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C(new ci5(2, 12, null));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements y3a.f {
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

        @Override // com.baidu.tieba.y3a.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C(new ci5(2, 12, null));
            }
        }
    }

    public static ana a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new ana(tbPageContext);
        }
        return (ana) invokeL.objValue;
    }

    public static cna b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new cna(tbPageContext);
        }
        return (cna) invokeL.objValue;
    }

    public static ena d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new ena(tbPageContext);
        }
        return (ena) invokeL.objValue;
    }

    public static fna e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new fna(tbPageContext);
        }
        return (fna) invokeL.objValue;
    }

    public static gna f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new gna(tbPageContext);
        }
        return (gna) invokeL.objValue;
    }

    public static hna g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new hna(tbPageContext);
        }
        return (hna) invokeL.objValue;
    }

    public static jna i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new jna(tbPageContext);
        }
        return (jna) invokeL.objValue;
    }

    public static kna j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new kna(tbPageContext);
        }
        return (kna) invokeL.objValue;
    }

    public static lna k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new lna(tbPageContext);
        }
        return (lna) invokeL.objValue;
    }

    public static mna l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new mna(tbPageContext);
        }
        return (mna) invokeL.objValue;
    }

    public static pna o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new pna(tbPageContext);
        }
        return (pna) invokeL.objValue;
    }

    public static qna p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new qna(tbPageContext);
        }
        return (qna) invokeL.objValue;
    }

    public static rna q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new rna(tbPageContext);
        }
        return (rna) invokeL.objValue;
    }

    public static sna r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new sna(tbPageContext);
        }
        return (sna) invokeL.objValue;
    }

    public static dna c(@NonNull TbPageContext<?> tbPageContext, @NonNull una unaVar, @NonNull EditorTools editorTools, @NonNull nma nmaVar, @NonNull fpa fpaVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, unaVar, editorTools, nmaVar, fpaVar)) == null) {
            dna dnaVar = new dna(tbPageContext, nmaVar, fpaVar);
            dnaVar.U(unaVar);
            dnaVar.b0(new a(editorTools));
            return dnaVar;
        }
        return (dna) invokeLLLLL.objValue;
    }

    public static ina h(@NonNull TbPageContext<?> tbPageContext, @NonNull jpa jpaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, jpaVar)) == null) {
            return new ina(tbPageContext, jpaVar);
        }
        return (ina) invokeLL.objValue;
    }

    public static nna m(@NonNull TbPageContext<?> tbPageContext, @NonNull una unaVar, @NonNull EditorTools editorTools, @NonNull jpa jpaVar, @NonNull nma nmaVar, @NonNull fpa fpaVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, unaVar, editorTools, jpaVar, nmaVar, fpaVar})) == null) {
            nna nnaVar = new nna(tbPageContext, jpaVar, nmaVar, fpaVar);
            nnaVar.W(unaVar);
            nnaVar.Y(new b(editorTools));
            return nnaVar;
        }
        return (nna) invokeCommon.objValue;
    }

    public static ona n(@NonNull TbPageContext<?> tbPageContext, @NonNull una unaVar, @NonNull nma nmaVar, @NonNull fpa fpaVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, unaVar, nmaVar, fpaVar)) == null) {
            ona onaVar = new ona(tbPageContext, nmaVar, fpaVar);
            onaVar.M(unaVar);
            return onaVar;
        }
        return (ona) invokeLLLL.objValue;
    }
}
