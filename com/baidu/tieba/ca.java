package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes3.dex */
public interface ca {
    @NonNull
    public static final ServiceReference a;
    @Nullable
    public static final ca b;

    static {
        ServiceReference serviceReference = new ServiceReference("DebugProcessor", "DebugService4Adp");
        a = serviceReference;
        b = (ca) ServiceManager.getService(serviceReference);
    }

    void a(int i, @NonNull String str, @Nullable Object obj);
}
