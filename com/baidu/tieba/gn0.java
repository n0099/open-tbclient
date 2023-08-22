package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes6.dex */
public interface gn0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "eventbus");

    <T extends fn0> void a(@Nullable T t);

    <T extends fn0> void b(@NonNull Object obj, @NonNull in0<T> in0Var);

    <T extends fn0> void c(@NonNull Object obj, int i, @NonNull in0<T> in0Var);

    void unregister(@NonNull Object obj);
}
