package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes5.dex */
public interface dn0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "eventbus");

    <T extends cn0> void a(@Nullable T t);

    <T extends cn0> void b(@NonNull Object obj, @NonNull fn0<T> fn0Var);

    <T extends cn0> void c(@NonNull Object obj, int i, @NonNull fn0<T> fn0Var);

    void unregister(@NonNull Object obj);
}
