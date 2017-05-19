package com.baidu.tieba.frs.entelechy;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.entelechy.a.am;
import com.baidu.tieba.frs.r;
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.a {
    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.d w(r rVar) {
        return new com.baidu.tieba.frs.entelechy.c.a(rVar);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.b aal() {
        return new j();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.view.b a(String str, r rVar, int i) {
        if (rVar == null) {
            return null;
        }
        c cVar = new c(rVar, null, null, i);
        cVar.a(rVar.YR());
        return cVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public am a(r rVar, BdTypeListView bdTypeListView, boolean z) {
        return new com.baidu.tieba.frs.entelechy.a.b(rVar, bdTypeListView, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.b.a
    /* renamed from: a */
    public com.baidu.tieba.frs.e.i c(r rVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (rVar.Zt()) {
            return null;
        }
        return new com.baidu.tieba.frs.e.i(rVar, noPressedRelativeLayout);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.c b(r rVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        return new com.baidu.tieba.frs.e.d(rVar, noPressedRelativeLayout);
    }
}
