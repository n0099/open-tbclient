package com.baidu.tieba.frs.entelechy;

import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.a.l;
import com.baidu.tieba.frs.entelechy.a.z;
import com.baidu.tieba.frs.vc.d;
/* loaded from: classes4.dex */
public class a implements com.baidu.tieba.frs.entelechy.b.a {
    private com.baidu.tieba.frs.view.b fgB;

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.b bfi() {
        return new c();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.view.b a(String str, FrsFragment frsFragment, int i) {
        if (frsFragment == null) {
            return null;
        }
        this.fgB = new b(frsFragment, null, null, i);
        this.fgB.b(frsFragment.bcm());
        return this.fgB;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public z a(FrsFragment frsFragment, r rVar, boolean z) {
        return new l(frsFragment, rVar, z);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public d a(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment.bcT()) {
            return null;
        }
        return new d(frsFragment, noPressedRelativeLayout);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.c b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        return new com.baidu.tieba.frs.vc.b(frsFragment, noPressedRelativeLayout);
    }
}
