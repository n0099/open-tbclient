package com.baidu.tieba;

import com.baidu.tieba.forum.widget.TbNestedScrollView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public interface bp7 {

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(bp7 bp7Var, TbNestedScrollView v, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLII(65536, null, bp7Var, v, i, i2) == null) {
                Intrinsics.checkNotNullParameter(v, "v");
            }
        }
    }

    void a(TbNestedScrollView tbNestedScrollView, int i, int i2);

    void b(TbNestedScrollView tbNestedScrollView, int i, int i2);
}
