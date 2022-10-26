package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes3.dex */
public interface em0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "eventbus");

    void a(dm0 dm0Var);

    void b(Object obj, gm0 gm0Var);

    void c(Object obj, int i, gm0 gm0Var);

    void unregister(Object obj);
}
