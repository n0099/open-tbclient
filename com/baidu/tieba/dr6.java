package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes5.dex */
public interface dr6 {
    public static final ServiceReference a = new ServiceReference("tieba.core", "eventbus");

    /* loaded from: classes5.dex */
    public interface a {
        public static final ServiceReference a = new ServiceReference("tieba.core", "eventbus.autorelease");

        void a(@NonNull BdUniqueId bdUniqueId);
    }

    void a(@NonNull Object obj);

    <T extends cr6> void b(@NonNull Object obj, @NonNull er6<T> er6Var);

    <T extends cr6> void c(@Nullable T t);
}
