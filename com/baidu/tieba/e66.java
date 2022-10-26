package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Collection;
import java.util.List;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class e66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final int a(List list, Comparable key, Function1 selector) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, list, key, selector)) == null) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(selector, "selector");
            int size = list.size() - 1;
            if (list.isEmpty()) {
                return -1;
            }
            int i = 0;
            while (i < size) {
                int i2 = (i + size) >>> 1;
                int compareValues = ComparisonsKt__ComparisonsKt.compareValues((Comparable) selector.invoke(list.get(i2)), key);
                if (compareValues < 0) {
                    i = i2 + 1;
                } else if (compareValues > 0) {
                    size = i2;
                } else {
                    return i2 - 1;
                }
            }
            return i;
        }
        return invokeLLL.intValue;
    }

    public static final int b(List list, Comparable key, Function1 selector) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, list, key, selector)) == null) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(selector, "selector");
            int size = list.size() - 1;
            if (list.isEmpty()) {
                return -1;
            }
            int i = 0;
            while (i < size) {
                int i2 = (i + size) >>> 1;
                int compareValues = ComparisonsKt__ComparisonsKt.compareValues((Comparable) selector.invoke(list.get(i2)), key);
                if (compareValues < 0) {
                    i = i2 + 1;
                } else if (compareValues > 0) {
                    size = i2;
                } else {
                    return i2 - 1;
                }
            }
            return size;
        }
        return invokeLLL.intValue;
    }

    public static final w46 c(Collection collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, collection)) == null) {
            Intrinsics.checkNotNullParameter(collection, "<this>");
            return new w46(collection);
        }
        return (w46) invokeL.objValue;
    }
}
