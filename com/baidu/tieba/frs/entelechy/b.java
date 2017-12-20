package com.baidu.tieba.frs.entelechy;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.entelechy.a.u;
import com.baidu.tieba.frs.g;
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.a {
    private a cMv;

    public com.baidu.tieba.frs.entelechy.b.d z(g gVar) {
        return new com.baidu.tieba.frs.entelechy.c.a(gVar);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.b anh() {
        return new d();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.view.c a(String str, g gVar, int i) {
        if (gVar == null) {
            return null;
        }
        this.cMv = new c(gVar, null, null, i);
        this.cMv.a(gVar.alf());
        return this.cMv;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public u a(g gVar, BdTypeListView bdTypeListView, boolean z) {
        return new com.baidu.tieba.frs.entelechy.a.b(gVar, bdTypeListView, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.b.a
    /* renamed from: a */
    public com.baidu.tieba.frs.g.d c(g gVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (gVar.alG()) {
            return null;
        }
        return new com.baidu.tieba.frs.g.d(gVar, noPressedRelativeLayout);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.c b(g gVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        return new com.baidu.tieba.frs.g.b(gVar, noPressedRelativeLayout);
    }

    public c ani() {
        if (this.cMv instanceof c) {
            return (c) this.cMv;
        }
        return null;
    }
}
