package com.baidu.tieba;

import android.view.View;
import com.baidu.tieba.tblauncher.MainTabScheduleStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dea {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(MainTabScheduleStrategy mainTabScheduleStrategy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, mainTabScheduleStrategy) == null) {
            eea.b(mainTabScheduleStrategy);
        }
    }

    public static void b(Runnable runnable, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, runnable, i) == null) {
            eea.f(new jea(runnable, i));
        }
    }

    public static void c(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, view2, i) == null) {
            eea.f(new lea(view2, i));
        }
    }
}
