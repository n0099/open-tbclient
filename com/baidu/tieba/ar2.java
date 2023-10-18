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
import com.baidu.tieba.br2;
/* loaded from: classes5.dex */
public interface ar2 extends br2.b {
    String A();

    yr1 B(String str);

    View C(String str);

    String D();

    void E(Context context);

    p53 F();

    void G(mq2 mq2Var, jo2 jo2Var);

    en1 H();

    @NonNull
    sd3 I();

    x42 J();

    void K();

    SwanAppPropertyWindow L(Activity activity);

    void M(String str);

    hn1 N();

    boolean O();

    void P();

    hn1 Q();

    void a();

    String b();

    void c();

    void d(mq2 mq2Var, jo2 jo2Var);

    @NonNull
    e63 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    e63 f(String str);

    String g();

    SwanAppActivity getActivity();

    SwanCoreVersion getCoreVersion();

    xr1 i();

    @NonNull
    e63 j(String str);

    boolean k();

    void l(Context context);

    void m(SwanAppActivity swanAppActivity);

    void n(String str, pf2 pf2Var);

    FullScreenFloatView o(Activity activity);

    void p();

    void q();

    @DebugTrace
    vr1 r();

    @NonNull
    Pair<Integer, Integer> s();

    SwanAppConfigData t();

    void u(Intent intent);

    void v(pf2 pf2Var);

    void w();

    void x();

    @NonNull
    Pair<Integer, Integer> y();

    void z(sf2 sf2Var, boolean z);
}
