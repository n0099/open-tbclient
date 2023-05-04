package com.baidu.tieba;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class d37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @JvmOverloads
    public static final boolean a(View view2, Object obj, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65536, null, view2, obj, z)) == null) {
            Intrinsics.checkNotNullParameter(view2, "<this>");
            if (Intrinsics.areEqual(view2.getTag(R.id.obfuscated_res_0x7f0927ce), obj)) {
                return true;
            }
            if (z) {
                view2.setTag(R.id.obfuscated_res_0x7f0927ce, obj);
            }
            return false;
        }
        return invokeLLZ.booleanValue;
    }

    public static /* synthetic */ boolean b(View view2, Object obj, boolean z, int i, Object obj2) {
        if ((i & 2) != 0) {
            z = true;
        }
        return a(view2, obj, z);
    }
}
