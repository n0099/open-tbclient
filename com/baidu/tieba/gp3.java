package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class gp3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(SwanAppActivity swanAppActivity) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65536, null, swanAppActivity) != null) || swanAppActivity == null || (intent = swanAppActivity.getIntent()) == null) {
            return;
        }
        if (x73.D()) {
            j92.k().s();
        }
        Bundle bundle = new Bundle();
        bundle.putAll(intent.getExtras());
        bundle.putBoolean("should_ignore_launch_time", true);
        Bundle bundle2 = bundle.getBundle("mExtraData");
        if (bundle2 == null) {
            bundle2 = new Bundle();
            bundle.putBundle("mExtraData", bundle2);
        }
        bundle2.putLong("launch_flag_for_statistic", System.currentTimeMillis());
        bundle2.putLong("page_display_flag_for_statistic", System.currentTimeMillis());
        xb3.K().n(new String[0]);
        bundle.remove("pms_db_info_onload");
        bundle.remove("pms_db_info_updated");
        bundle.remove("mPage");
        bundle.putString("launch_id", SwanLauncher.h());
        xb3.K().l(bundle, "update_tag_by_activity_on_relaunch");
    }
}
