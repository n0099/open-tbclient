package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Cloneable;
/* loaded from: classes5.dex */
public interface bh8<T> extends Cloneable {

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static <T> Object a(bh8<T> bh8Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bh8Var)) == null) {
                return Cloneable.DefaultImpls.clone(bh8Var);
            }
            return invokeL.objValue;
        }
    }
}
