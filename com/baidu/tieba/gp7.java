package com.baidu.tieba;

import com.baidu.tieba.forum.widget.TbNestedScrollView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public interface gp7 {

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(gp7 gp7Var, TbNestedScrollView v, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLII(65536, null, gp7Var, v, i, i2) == null) {
                Intrinsics.checkNotNullParameter(v, "v");
            }
        }
    }

    void a(TbNestedScrollView tbNestedScrollView, int i, int i2);

    void b(TbNestedScrollView tbNestedScrollView, int i, int i2);
}
