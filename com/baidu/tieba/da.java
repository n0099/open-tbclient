package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes3.dex */
public interface da {
    @NonNull
    public static final ServiceReference a;
    @Nullable
    public static final da b;

    void a(int i, @NonNull String str, @Nullable Object obj);

    static {
        ServiceReference serviceReference = new ServiceReference("DebugProcessor", "DebugService4Adp");
        a = serviceReference;
        b = (da) ServiceManager.getService(serviceReference);
    }
}
