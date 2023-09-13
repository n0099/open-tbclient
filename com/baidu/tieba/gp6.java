package com.baidu.tieba;

import android.view.ViewGroup;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmName;
@JvmName(name = "CardUtil")
/* loaded from: classes6.dex */
public final class gp6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(ax<?> axVar, int i, int i2) {
        cy cyVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65536, null, axVar, i, i2) == null) {
            if (axVar instanceof cy) {
                cyVar = (cy) axVar;
            } else {
                cyVar = null;
            }
            if (cyVar != null && (cyVar.f.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                ViewGroup.LayoutParams layoutParams = cyVar.f.d.getLayoutParams();
                if (layoutParams != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.width = i;
                    marginLayoutParams.height = i2;
                    if (cyVar.f.d.getVisibility() != 8) {
                        cyVar.f.d.setLayoutParams(marginLayoutParams);
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
        }
    }
}
