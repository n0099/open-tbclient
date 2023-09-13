package com.baidu.tieba;

import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public interface fa2 {
    void addJavascriptInterface(@NonNull Object obj, @NonNull String str);

    void continueTimer();

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    String getContainerId();

    String getUrl();

    boolean isDestroyed();

    boolean isWebView();

    void onJSLoaded();

    void suspendTimer();
}
