package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes3.dex */
public interface em0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "eventbus");

    <T extends dm0> void a(@Nullable T t);

    <T extends dm0> void b(@NonNull Object obj, @NonNull gm0<T> gm0Var);

    <T extends dm0> void c(@NonNull Object obj, int i, @NonNull gm0<T> gm0Var);

    void unregister(@NonNull Object obj);
}
