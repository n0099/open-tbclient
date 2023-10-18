package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes5.dex */
public interface di0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "eventbus");

    void a(@NonNull Object obj);

    <T extends ci0> void b(@Nullable T t);

    <T extends ci0> void c(@NonNull Object obj, @NonNull fi0<T> fi0Var);

    <T extends ci0> void d(@NonNull Object obj, int i, @NonNull fi0<T> fi0Var);
}
