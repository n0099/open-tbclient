package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes4.dex */
public interface ea {
    @NonNull
    public static final ServiceReference a;
    @Nullable
    public static final ea b;

    void a(int i, @NonNull String str, @Nullable Object obj);

    static {
        ServiceReference serviceReference = new ServiceReference("DebugProcessor", "DebugService4Adp");
        a = serviceReference;
        b = (ea) ServiceManager.getService(serviceReference);
    }
}
