package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes4.dex */
public interface i95 {
    @NonNull
    public static final ServiceReference a;
    @NonNull
    public static final i95 b;

    static {
        ServiceReference serviceReference = new ServiceReference("tbBaseEmotion", "EmotionService");
        a = serviceReference;
        b = (i95) ServiceManager.getService(serviceReference);
    }

    boolean a(@NonNull String str);

    @NonNull
    String b(@NonNull String str);

    @NonNull
    String c();

    @NonNull
    String d(@NonNull String str, boolean z);

    @NonNull
    String e(@NonNull String str, @NonNull String str2);
}
