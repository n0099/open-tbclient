package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ex0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void a(@Nullable Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65536, null, activity, z) == null) && activity != null) {
            if (z) {
                activity.setRequestedOrientation(8);
            } else {
                activity.setRequestedOrientation(0);
            }
            activity.getWindow().setFlags(1024, 1024);
        }
    }
}
