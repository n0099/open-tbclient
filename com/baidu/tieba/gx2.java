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
import com.baidu.tieba.hx2;
/* loaded from: classes6.dex */
public interface gx2 extends hx2.b {
    dy1 A(String str);

    View B(String str);

    String C();

    vb3 D();

    void E(sw2 sw2Var, pu2 pu2Var);

    jt1 F();

    @NonNull
    yj3 G();

    db2 H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    mt1 L();

    boolean M();

    void N();

    mt1 O();

    void a();

    String b();

    void c();

    void d(sw2 sw2Var, pu2 pu2Var);

    @NonNull
    kc3 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    kc3 f(String str);

    String g();

    SwanAppActivity getActivity();

    SwanCoreVersion getCoreVersion();

    cy1 i();

    @NonNull
    kc3 j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, vl2 vl2Var);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    ay1 q();

    @NonNull
    Pair<Integer, Integer> r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(vl2 vl2Var);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(yl2 yl2Var, boolean z);

    String z();
}
