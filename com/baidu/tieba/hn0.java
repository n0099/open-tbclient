package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes6.dex */
public interface hn0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "eventbus");

    <T extends gn0> void a(@Nullable T t);

    <T extends gn0> void b(@NonNull Object obj, @NonNull jn0<T> jn0Var);

    <T extends gn0> void c(@NonNull Object obj, int i, @NonNull jn0<T> jn0Var);

    void unregister(@NonNull Object obj);
}
