package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.tieba.bu1;
/* loaded from: classes4.dex */
public interface cu1<T extends bu1> extends TypedCallbackHandler {
    @UiThread
    void N();

    void U(h92 h92Var);

    String a();

    void attachActivity(Activity activity);

    void b(i62 i62Var);

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

    void t(h92 h92Var);
}
