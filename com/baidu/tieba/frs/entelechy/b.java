package com.baidu.tieba.frs.entelechy;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.entelechy.a.q;
import com.baidu.tieba.frs.f;
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.a {
    private a cuQ;

    public com.baidu.tieba.frs.entelechy.b.d y(f fVar) {
        return new com.baidu.tieba.frs.entelechy.c.a(fVar);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.b aiE() {
        return new d();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.view.b a(String str, f fVar, int i) {
        if (fVar == null) {
            return null;
        }
        this.cuQ = new c(fVar, null, null, i);
        this.cuQ.a(fVar.agQ());
        return this.cuQ;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public q a(f fVar, BdTypeListView bdTypeListView, boolean z) {
        return new com.baidu.tieba.frs.entelechy.a.b(fVar, bdTypeListView, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.b.a
    /* renamed from: a */
    public com.baidu.tieba.frs.h.d c(f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (fVar.aht()) {
            return null;
        }
        return new com.baidu.tieba.frs.h.d(fVar, noPressedRelativeLayout);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.c b(f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        return new com.baidu.tieba.frs.h.b(fVar, noPressedRelativeLayout);
    }

    public c aiF() {
        if (this.cuQ instanceof c) {
            return (c) this.cuQ;
        }
        return null;
    }
}
