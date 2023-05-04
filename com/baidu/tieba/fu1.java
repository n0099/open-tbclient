package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.tieba.eu1;
/* loaded from: classes4.dex */
public interface fu1<T extends eu1> extends TypedCallbackHandler {
    @UiThread
    void N();

    void U(k92 k92Var);

    String a();

    void attachActivity(Activity activity);

    void b(l62 l62Var);

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

    T s();

    void t(k92 k92Var);
}
