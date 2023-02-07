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
import com.baidu.tieba.iu2;
/* loaded from: classes4.dex */
public interface hu2 extends iu2.b {
    ev1 A(String str);

    View B(String str);

    String C();

    w83 D();

    void E(tt2 tt2Var, qr2 qr2Var);

    kq1 F();

    @NonNull
    zg3 G();

    e82 H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    nq1 L();

    SwanCoreVersion M();

    boolean N();

    void O();

    nq1 P();

    void a();

    String b();

    void c();

    void d(tt2 tt2Var, qr2 qr2Var);

    @NonNull
    l93 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    l93 f(String str);

    String g();

    SwanAppActivity getActivity();

    dv1 i();

    @NonNull
    l93 j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, wi2 wi2Var);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    bv1 q();

    @NonNull
    Pair<Integer, Integer> r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(wi2 wi2Var);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(zi2 zi2Var, boolean z);

    String z();
}
