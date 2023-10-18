package com.baidu.tieba;

import android.view.View;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class b77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, view2)) == null) {
            Intrinsics.checkNotNullParameter(view2, "<this>");
            Object tag = view2.getTag(R.id.obfuscated_res_0x7f092961);
            if ((tag instanceof Integer) && Intrinsics.areEqual(tag, Integer.valueOf(SkinManager.getCurrentSkinType()))) {
                return true;
            }
            view2.setTag(R.id.obfuscated_res_0x7f092961, Integer.valueOf(SkinManager.getCurrentSkinType()));
            return false;
        }
        return invokeL.booleanValue;
    }
}
