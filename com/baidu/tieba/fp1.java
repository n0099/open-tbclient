package com.baidu.tieba;

import android.view.View;
import android.webkit.ValueCallback;
/* loaded from: classes4.dex */
public interface fp1 extends w12 {
    boolean canGoBack();

    View covertToView();

    void destroy();

    @Override // com.baidu.tieba.w12
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
