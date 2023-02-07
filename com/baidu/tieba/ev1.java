package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.tieba.dv1;
/* loaded from: classes4.dex */
public interface ev1<T extends dv1> extends TypedCallbackHandler {
    @UiThread
    void N();

    void U(ja2 ja2Var);

    String a();

    void attachActivity(Activity activity);

    void b(k72 k72Var);

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

    void t(ja2 ja2Var);
}
