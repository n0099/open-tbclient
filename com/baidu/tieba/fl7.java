package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class fl7 implements sm7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dx7 a;

    public fl7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.sm7
    public tm7 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new hl7();
        }
        return (tm7) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sm7
    public nw7 a(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, frsFragment, noPressedRelativeLayout)) == null) {
            if (!frsFragment.k4()) {
                return new nw7(frsFragment, noPressedRelativeLayout);
            }
            return null;
        }
        return (nw7) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.sm7
    public um7 d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, frsFragment, noPressedRelativeLayout)) == null) {
            return new lw7(frsFragment, noPressedRelativeLayout);
        }
        return (um7) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.sm7
    public qm7 b(FrsFragment frsFragment, eo eoVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frsFragment, eoVar, z)) == null) {
            return new cm7(frsFragment, eoVar, z);
        }
        return (qm7) invokeLLZ.objValue;
    }

    @Override // com.baidu.tieba.sm7
    public dx7 e(String str, FrsFragment frsFragment, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, str, frsFragment, i)) == null) {
            if (frsFragment == null) {
                return null;
            }
            gl7 gl7Var = new gl7(frsFragment, null, null, i);
            this.a = gl7Var;
            gl7Var.T(frsFragment.F3());
            return this.a;
        }
        return (dx7) invokeLLI.objValue;
    }
}
