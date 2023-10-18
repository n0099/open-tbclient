package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public interface f37 extends Comparable<f37> {
    boolean D();

    boolean E();

    String F();

    boolean L();

    int getPriority();

    void hide();

    int l(int i, int i2);

    void reset();

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static int a(f37 f37Var, f37 other) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, f37Var, other)) == null) {
                Intrinsics.checkNotNullParameter(other, "other");
                return Intrinsics.compare(other.getPriority(), f37Var.getPriority());
            }
            return invokeLL.intValue;
        }
    }
}
