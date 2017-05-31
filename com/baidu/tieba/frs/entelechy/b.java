package com.baidu.tieba.frs.entelechy;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.entelechy.a.al;
import com.baidu.tieba.frs.r;
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.a {
    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.d w(r rVar) {
        return new com.baidu.tieba.frs.entelechy.c.a(rVar);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.b abn() {
        return new j();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.view.b a(String str, r rVar, int i) {
        if (rVar == null) {
            return null;
        }
        c cVar = new c(rVar, null, null, i);
        cVar.a(rVar.ZV());
        return cVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public al a(r rVar, BdTypeListView bdTypeListView, boolean z) {
        return new com.baidu.tieba.frs.entelechy.a.b(rVar, bdTypeListView, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.b.a
    /* renamed from: a */
    public com.baidu.tieba.frs.f.i c(r rVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (rVar.aaw()) {
            return null;
        }
        return new com.baidu.tieba.frs.f.i(rVar, noPressedRelativeLayout);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.c b(r rVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        return new com.baidu.tieba.frs.f.d(rVar, noPressedRelativeLayout);
    }
}
