package com.baidu.tieba.frs.entelechy;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.entelechy.a.ad;
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.frs.entelechy.b.a {
    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.g Xz() {
        return new com.baidu.tieba.frs.g.a();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.d N(FrsActivity frsActivity) {
        return new com.baidu.tieba.frs.entelechy.tabView.a(frsActivity);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.b XA() {
        return new m();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.view.c a(String str, FrsActivity frsActivity, int i) {
        b dVar;
        if (frsActivity == null) {
            return null;
        }
        if ("frs_page".equals(str)) {
            dVar = new n(frsActivity, null, null, i);
        } else {
            dVar = new d(frsActivity, null, null, i);
        }
        dVar.b(frsActivity.VN());
        dVar.b(frsActivity.VO());
        return dVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public ad a(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        return new com.baidu.tieba.frs.entelechy.a.c(frsActivity, bdTypeListView, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.b.a
    /* renamed from: a */
    public com.baidu.tieba.frs.i.h c(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        return new com.baidu.tieba.frs.i.h(frsActivity, noPressedRelativeLayout);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.c b(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        return new com.baidu.tieba.frs.i.d(frsActivity, noPressedRelativeLayout);
    }
}
