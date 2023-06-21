package com.baidu.tieba;

import android.view.View;
import android.webkit.ValueCallback;
/* loaded from: classes5.dex */
public interface gy1 extends xa2 {
    boolean canGoBack();

    View covertToView();

    void destroy();

    @Override // com.baidu.tieba.xa2
    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    int getContentHeight();

    View getCurrentWebView();

    float getScale();

    int getWebViewScrollX();

    int getWebViewScrollY();

    void goBack();

    void setDefaultViewSize(int i, int i2, String str);

    void webViewScrollTo(int i, int i2);
}
