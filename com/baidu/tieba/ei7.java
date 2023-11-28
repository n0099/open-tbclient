package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class ei7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(NavigationBar navigationBar, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65536, null, navigationBar, f) == null) {
            Intrinsics.checkNotNullParameter(navigationBar, "<this>");
            if (navigationBar.getContext() instanceof BaseFragmentActivity) {
                Context context = navigationBar.getContext();
                if (context != null) {
                    xh7.j((BaseFragmentActivity) context).E(f);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.core.BaseFragmentActivity");
            }
        }
    }
}
