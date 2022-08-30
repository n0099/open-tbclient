package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes3.dex */
public interface ek0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "eventbus");

    <T extends dk0> void a(@Nullable T t);

    <T extends dk0> void b(@NonNull Object obj, @NonNull gk0<T> gk0Var);

    <T extends dk0> void c(@NonNull Object obj, int i, @NonNull gk0<T> gk0Var);

    void unregister(@NonNull Object obj);
}
