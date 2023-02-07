package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.webkit.sdk.WebViewFactoryProvider;
/* loaded from: classes4.dex */
public interface ec6 {
    public static final ServiceReference a = new ServiceReference(WebViewFactoryProvider.SETTING_MONITOR, "IMonitorBehavior");

    void a();

    void b(Throwable th);
}
