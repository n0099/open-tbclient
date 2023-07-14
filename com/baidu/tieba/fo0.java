package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes5.dex */
public interface fo0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "eventbus");

    <T extends eo0> void a(@Nullable T t);

    <T extends eo0> void b(@NonNull Object obj, @NonNull ho0<T> ho0Var);

    <T extends eo0> void c(@NonNull Object obj, int i, @NonNull ho0<T> ho0Var);

    void unregister(@NonNull Object obj);
}
