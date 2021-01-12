package com.baidu.tieba.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements c {
    public static final AtomicReference<c> jLS = new AtomicReference<>(null);
    private static final c jLT = new b();

    public static c cLy() {
        c cVar = jLS.get();
        return cVar == null ? jLT : cVar;
    }

    @Override // com.baidu.tieba.h.c
    public com.baidu.adp.widget.ListView.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.tieba.h.c
    public com.baidu.adp.widget.ListView.a<?, ?> b(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.tieba.h.c
    public com.baidu.adp.widget.ListView.a<?, ?> c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        return null;
    }
}
