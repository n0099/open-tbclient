package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class am6 implements kn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vv6 a;

    public am6() {
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

    @Override // com.baidu.tieba.kn6
    public ln6 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new cm6();
        }
        return (ln6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kn6
    public jv6 a(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, frsFragment, noPressedRelativeLayout)) == null) {
            if (!frsFragment.Q3()) {
                return new jv6(frsFragment, noPressedRelativeLayout);
            }
            return null;
        }
        return (jv6) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.kn6
    public mn6 d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, frsFragment, noPressedRelativeLayout)) == null) {
            return new hv6(frsFragment, noPressedRelativeLayout);
        }
        return (mn6) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.kn6
    public jn6 b(FrsFragment frsFragment, co coVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frsFragment, coVar, z)) == null) {
            return new vm6(frsFragment, coVar, z);
        }
        return (jn6) invokeLLZ.objValue;
    }

    @Override // com.baidu.tieba.kn6
    public vv6 e(String str, FrsFragment frsFragment, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, str, frsFragment, i)) == null) {
            if (frsFragment == null) {
                return null;
            }
            bm6 bm6Var = new bm6(frsFragment, null, null, i);
            this.a = bm6Var;
            bm6Var.R(frsFragment.p3());
            return this.a;
        }
        return (vv6) invokeLLI.objValue;
    }
}
