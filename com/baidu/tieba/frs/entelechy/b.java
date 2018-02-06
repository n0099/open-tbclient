package com.baidu.tieba.frs.entelechy;

import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.entelechy.a.s;
import com.baidu.tieba.frs.i;
/* loaded from: classes2.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.a {
    private a dJF;

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.b awV() {
        return new d();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.view.c a(String str, i iVar, int i) {
        if (iVar == null) {
            return null;
        }
        this.dJF = new c(iVar, null, null, i);
        this.dJF.a(iVar.auL());
        return this.dJF;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public s a(i iVar, n nVar, boolean z) {
        return new com.baidu.tieba.frs.entelechy.a.b(iVar, nVar, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.b.a
    /* renamed from: a */
    public com.baidu.tieba.frs.g.d c(i iVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (iVar.avn()) {
            return null;
        }
        return new com.baidu.tieba.frs.g.d(iVar, noPressedRelativeLayout);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.c b(i iVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        return new com.baidu.tieba.frs.g.b(iVar, noPressedRelativeLayout);
    }
}
