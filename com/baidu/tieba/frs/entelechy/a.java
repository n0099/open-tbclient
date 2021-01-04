package com.baidu.tieba.frs.entelechy;

import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.adapter.al;
import com.baidu.tieba.frs.entelechy.adapter.u;
import com.baidu.tieba.frs.vc.d;
/* loaded from: classes2.dex */
public class a implements com.baidu.tieba.frs.entelechy.a.a {
    private com.baidu.tieba.frs.view.b joJ;

    @Override // com.baidu.tieba.frs.entelechy.a.a
    public com.baidu.tieba.frs.entelechy.a.b cIw() {
        return new c();
    }

    @Override // com.baidu.tieba.frs.entelechy.a.a
    public com.baidu.tieba.frs.view.b a(String str, FrsFragment frsFragment, int i) {
        if (frsFragment == null) {
            return null;
        }
        this.joJ = new b(frsFragment, null, null, i);
        this.joJ.c(frsFragment.cER());
        return this.joJ;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.a
    public al a(FrsFragment frsFragment, s sVar, boolean z) {
        return new u(frsFragment, sVar, z);
    }

    @Override // com.baidu.tieba.frs.entelechy.a.a
    public d a(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment.cFH()) {
            return null;
        }
        return new d(frsFragment, noPressedRelativeLayout);
    }

    @Override // com.baidu.tieba.frs.entelechy.a.a
    public com.baidu.tieba.frs.entelechy.a.c b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        return new com.baidu.tieba.frs.vc.b(frsFragment, noPressedRelativeLayout);
    }
}
