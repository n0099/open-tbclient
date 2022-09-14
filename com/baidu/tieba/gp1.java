package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.tieba.fp1;
/* loaded from: classes4.dex */
public interface gp1<T extends fp1> extends TypedCallbackHandler {
    @UiThread
    void N();

    void U(l42 l42Var);

    String a();

    void attachActivity(Activity activity);

    void b(m12 m12Var);

    String b0();

    SwanAppWebViewManager.d d();

    void destroy();

    void e0();

    String getUserAgent();

    void loadUrl(String str);

    void onJSLoaded();

    void onPause();

    void onResume();

    @UiThread
    void q();

    T r();

    void t(l42 l42Var);
}
