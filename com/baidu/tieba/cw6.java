package com.baidu.tieba;

import com.baidu.tbadk.core.BaseFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static bw6 a(BaseFragment baseFragment, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, baseFragment, i)) == null) {
            if (baseFragment == null) {
                return null;
            }
            if (i == 1) {
                return new gw6(baseFragment, i);
            }
            if (i == 2) {
                return new fw6(baseFragment, i);
            }
            if (i != 3) {
                return null;
            }
            return new dw6(baseFragment, i);
        }
        return (bw6) invokeLI.objValue;
    }
}
