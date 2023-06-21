package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes5.dex */
public interface ff {
    @NonNull
    public static final ServiceReference a = new ServiceReference("UniKVTest", "UniKVTest");

    boolean isTypeDoubleKv();

    boolean isTypeKv();

    boolean isTypeSp();
}
