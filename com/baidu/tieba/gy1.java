package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.tieba.fy1;
/* loaded from: classes6.dex */
public interface gy1<T extends fy1> extends TypedCallbackHandler {
    @UiThread
    void L();

    void S(ld2 ld2Var);

    String Z();

    String a();

    void attachActivity(Activity activity);

    void b(ma2 ma2Var);

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

    void s(ld2 ld2Var);
}
