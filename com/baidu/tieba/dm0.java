package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes4.dex */
public interface dm0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "eventbus");

    <T extends cm0> void a(@Nullable T t);

    <T extends cm0> void b(@NonNull Object obj, @NonNull fm0<T> fm0Var);

    <T extends cm0> void c(@NonNull Object obj, int i, @NonNull fm0<T> fm0Var);

    void unregister(@NonNull Object obj);
}
