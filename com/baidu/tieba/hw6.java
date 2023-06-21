package com.baidu.tieba;

import com.baidu.tbadk.core.BaseFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static gw6 a(BaseFragment baseFragment, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, baseFragment, i)) == null) {
            if (baseFragment == null) {
                return null;
            }
            if (i == 1) {
                return new lw6(baseFragment, i);
            }
            if (i == 2) {
                return new kw6(baseFragment, i);
            }
            if (i != 3) {
                return null;
            }
            return new iw6(baseFragment, i);
        }
        return (gw6) invokeLI.objValue;
    }
}
