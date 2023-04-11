package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tieba.gt2;
/* loaded from: classes4.dex */
public interface ft2 extends gt2.b {
    cu1 A(String str);

    View B(String str);

    String C();

    u73 D();

    void E(rs2 rs2Var, oq2 oq2Var);

    ip1 F();

    @NonNull
    xf3 G();

    c72 H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    lp1 L();

    SwanCoreVersion M();

    boolean N();

    void O();

    lp1 P();

    void a();

    String b();

    void c();

    void d(rs2 rs2Var, oq2 oq2Var);

    @NonNull
    j83 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    j83 f(String str);

    String g();

    SwanAppActivity getActivity();

    bu1 i();

    @NonNull
    j83 j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, uh2 uh2Var);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    zt1 q();

    @NonNull
    Pair<Integer, Integer> r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(uh2 uh2Var);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(xh2 xh2Var, boolean z);

    String z();
}
