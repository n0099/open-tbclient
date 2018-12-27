package com.baidu.tieba.frs.entelechy;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.a.q;
/* loaded from: classes6.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.a {
    private a dRW;

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.b aEc() {
        return new d();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.view.b a(String str, FrsFragment frsFragment, int i) {
        if (frsFragment == null) {
            return null;
        }
        this.dRW = new c(frsFragment, null, null, i);
        this.dRW.a(frsFragment.aBp());
        return this.dRW;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public q a(FrsFragment frsFragment, m mVar, boolean z) {
        return new com.baidu.tieba.frs.entelechy.a.b(frsFragment, mVar, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.b.a
    /* renamed from: a */
    public com.baidu.tieba.frs.vc.d c(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment.aBQ()) {
            return null;
        }
        return new com.baidu.tieba.frs.vc.d(frsFragment, noPressedRelativeLayout);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.c b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        return new com.baidu.tieba.frs.vc.b(frsFragment, noPressedRelativeLayout);
    }

    public c aEd() {
        if (this.dRW instanceof c) {
            return (c) this.dRW;
        }
        return null;
    }
}
