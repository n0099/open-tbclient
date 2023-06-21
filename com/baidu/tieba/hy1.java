package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.tieba.gy1;
/* loaded from: classes6.dex */
public interface hy1<T extends gy1> extends TypedCallbackHandler {
    @UiThread
    void L();

    void S(md2 md2Var);

    String Z();

    String a();

    void attachActivity(Activity activity);

    void b(na2 na2Var);

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

    void s(md2 md2Var);
}
