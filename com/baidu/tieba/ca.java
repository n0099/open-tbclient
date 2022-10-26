package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes3.dex */
public interface ca {
    public static final ServiceReference a;
    public static final ca b;

    void a(int i, String str, Object obj);

    static {
        ServiceReference serviceReference = new ServiceReference("DebugProcessor", "DebugService4Adp");
        a = serviceReference;
        b = (ca) ServiceManager.getService(serviceReference);
    }
}
