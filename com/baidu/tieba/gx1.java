package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.tieba.fx1;
/* loaded from: classes6.dex */
public interface gx1<T extends fx1> extends TypedCallbackHandler {
    @UiThread
    void L();

    void S(lc2 lc2Var);

    String Z();

    String a();

    void attachActivity(Activity activity);

    void b(m92 m92Var);

    void c0();

    void destroy();

    SwanAppWebViewManager.d getConfig();

    String getUserAgent();

    void loadUrl(String str);

    void onJSLoaded();

    void onPause();

    void onResume();

    @UiThread
    void p();

    T r();

    void s(lc2 lc2Var);
}
