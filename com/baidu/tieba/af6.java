package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.webkit.sdk.WebViewFactoryProvider;
/* loaded from: classes3.dex */
public interface af6 {
    public static final ServiceReference a = new ServiceReference(WebViewFactoryProvider.SETTING_MONITOR, "IMonitorBehavior");

    void a(Throwable th);
}
