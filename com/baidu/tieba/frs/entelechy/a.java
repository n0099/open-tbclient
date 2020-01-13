package com.baidu.tieba.frs.entelechy;

import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.a.af;
import com.baidu.tieba.frs.entelechy.a.q;
import com.baidu.tieba.frs.vc.d;
/* loaded from: classes7.dex */
public class a implements com.baidu.tieba.frs.entelechy.b.a {
    private com.baidu.tieba.frs.view.b gtY;

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.b bFd() {
        return new c();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.view.b a(String str, FrsFragment frsFragment, int i) {
        if (frsFragment == null) {
            return null;
        }
        this.gtY = new b(frsFragment, null, null, i);
        this.gtY.c(frsFragment.bCc());
        return this.gtY;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public af a(FrsFragment frsFragment, r rVar, boolean z) {
        return new q(frsFragment, rVar, z);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public d a(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment.bCN()) {
            return null;
        }
        return new d(frsFragment, noPressedRelativeLayout);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.c b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        return new com.baidu.tieba.frs.vc.b(frsFragment, noPressedRelativeLayout);
    }
}
