package com.baidu.tieba.browser.lifecycle;

import androidx.lifecycle.LifecycleObserver;
/* loaded from: classes3.dex */
public interface WebViewLifeCycle extends LifecycleObserver {
    void onDestroy();

    void onPause();

    void onResume();
}
