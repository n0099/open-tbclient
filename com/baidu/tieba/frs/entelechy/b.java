package com.baidu.tieba.frs.entelechy;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.a.q;
/* loaded from: classes6.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.a {
    private a dSF;

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.b aEz() {
        return new d();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.view.b a(String str, FrsFragment frsFragment, int i) {
        if (frsFragment == null) {
            return null;
        }
        this.dSF = new c(frsFragment, null, null, i);
        this.dSF.a(frsFragment.aBM());
        return this.dSF;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public q a(FrsFragment frsFragment, m mVar, boolean z) {
        return new com.baidu.tieba.frs.entelechy.a.b(frsFragment, mVar, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.b.a
    /* renamed from: a */
    public com.baidu.tieba.frs.vc.d c(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment.aCn()) {
            return null;
        }
        return new com.baidu.tieba.frs.vc.d(frsFragment, noPressedRelativeLayout);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.c b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        return new com.baidu.tieba.frs.vc.b(frsFragment, noPressedRelativeLayout);
    }

    public c aEA() {
        if (this.dSF instanceof c) {
            return (c) this.dSF;
        }
        return null;
    }
}
