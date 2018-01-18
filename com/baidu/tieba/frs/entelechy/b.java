package com.baidu.tieba.frs.entelechy;

import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.entelechy.a.u;
import com.baidu.tieba.frs.i;
/* loaded from: classes2.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.a {
    private a dGd;

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.b avR() {
        return new d();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.view.c a(String str, i iVar, int i) {
        if (iVar == null) {
            return null;
        }
        this.dGd = new c(iVar, null, null, i);
        this.dGd.a(iVar.atQ());
        return this.dGd;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public u a(i iVar, n nVar, boolean z) {
        return new com.baidu.tieba.frs.entelechy.a.b(iVar, nVar, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.b.a
    /* renamed from: a */
    public com.baidu.tieba.frs.f.d c(i iVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (iVar.aut()) {
            return null;
        }
        return new com.baidu.tieba.frs.f.d(iVar, noPressedRelativeLayout);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.c b(i iVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        return new com.baidu.tieba.frs.f.b(iVar, noPressedRelativeLayout);
    }
}
