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
import com.baidu.tieba.ft2;
/* loaded from: classes4.dex */
public interface et2 extends ft2.b {
    bu1 A(String str);

    View B(String str);

    String C();

    t73 D();

    void E(qs2 qs2Var, nq2 nq2Var);

    hp1 F();

    @NonNull
    wf3 G();

    b72 H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    kp1 L();

    SwanCoreVersion M();

    boolean N();

    void O();

    kp1 P();

    void a();

    String b();

    void c();

    void d(qs2 qs2Var, nq2 nq2Var);

    @NonNull
    i83 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    i83 f(String str);

    String g();

    SwanAppActivity getActivity();

    au1 i();

    @NonNull
    i83 j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, th2 th2Var);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    yt1 q();

    @NonNull
    Pair<Integer, Integer> r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(th2 th2Var);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(wh2 wh2Var, boolean z);

    String z();
}
