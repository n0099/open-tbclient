package com.baidu.tieba.frs.entelechy;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.entelechy.a.q;
import com.baidu.tieba.frs.f;
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.a {
    private a cns;

    public com.baidu.tieba.frs.entelechy.b.d z(f fVar) {
        return new com.baidu.tieba.frs.entelechy.c.a(fVar);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.b agN() {
        return new d();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.view.b a(String str, f fVar, int i) {
        if (fVar == null) {
            return null;
        }
        this.cns = new c(fVar, null, null, i);
        this.cns.a(fVar.afn());
        return this.cns;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public q a(f fVar, BdTypeListView bdTypeListView, boolean z) {
        return new com.baidu.tieba.frs.entelechy.a.b(fVar, bdTypeListView, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.b.a
    /* renamed from: a */
    public com.baidu.tieba.frs.g.d c(f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (fVar.afQ()) {
            return null;
        }
        return new com.baidu.tieba.frs.g.d(fVar, noPressedRelativeLayout);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.c b(f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        return new com.baidu.tieba.frs.g.b(fVar, noPressedRelativeLayout);
    }

    public c agO() {
        if (this.cns instanceof c) {
            return (c) this.cns;
        }
        return null;
    }
}
