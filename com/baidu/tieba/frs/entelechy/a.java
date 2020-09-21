package com.baidu.tieba.frs.entelechy;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.a.al;
import com.baidu.tieba.frs.entelechy.a.s;
import com.baidu.tieba.frs.vc.d;
/* loaded from: classes21.dex */
public class a implements com.baidu.tieba.frs.entelechy.b.a {
    private com.baidu.tieba.frs.view.b iju;

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.b csB() {
        return new c();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.view.b a(String str, FrsFragment frsFragment, int i) {
        if (frsFragment == null) {
            return null;
        }
        this.iju = new b(frsFragment, null, null, i);
        this.iju.c(frsFragment.coX());
        return this.iju;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public al a(FrsFragment frsFragment, v vVar, boolean z) {
        return new s(frsFragment, vVar, z);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public d a(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment.cpM()) {
            return null;
        }
        return new d(frsFragment, noPressedRelativeLayout);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.c b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        return new com.baidu.tieba.frs.vc.b(frsFragment, noPressedRelativeLayout);
    }
}
