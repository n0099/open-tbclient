package com.baidu.tieba.frs.entelechy;

import com.baidu.adp.widget.ListView.t;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.a.ai;
import com.baidu.tieba.frs.entelechy.a.s;
import com.baidu.tieba.frs.vc.d;
/* loaded from: classes9.dex */
public class a implements com.baidu.tieba.frs.entelechy.b.a {
    private com.baidu.tieba.frs.view.b hvl;

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.b bXW() {
        return new c();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.view.b a(String str, FrsFragment frsFragment, int i) {
        if (frsFragment == null) {
            return null;
        }
        this.hvl = new b(frsFragment, null, null, i);
        this.hvl.c(frsFragment.bUL());
        return this.hvl;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public ai a(FrsFragment frsFragment, t tVar, boolean z) {
        return new s(frsFragment, tVar, z);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public d a(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment.bVx()) {
            return null;
        }
        return new d(frsFragment, noPressedRelativeLayout);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.c b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        return new com.baidu.tieba.frs.vc.b(frsFragment, noPressedRelativeLayout);
    }
}
