package com.baidu.tieba.frs.entelechy;

import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.entelechy.a.v;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.view.BdExpandListView;
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.frs.entelechy.b.a {
    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.g Sg() {
        return new com.baidu.tieba.frs.f.a();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.d L(FrsActivity frsActivity) {
        return new com.baidu.tieba.frs.entelechy.tabView.a(frsActivity);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.b Sh() {
        return new m();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.view.c a(String str, FrsActivity frsActivity, int i) {
        b dVar;
        if (frsActivity == null) {
            return null;
        }
        if ("frs_page".equals(str)) {
            dVar = new n(frsActivity, FrsHeaderView.PAGE.FRS_LIST, null, null, i);
        } else {
            dVar = new d(frsActivity, FrsHeaderView.PAGE.FRS_LIST, null, null, i);
        }
        dVar.b(frsActivity.Qk());
        dVar.b(frsActivity.Ql());
        return dVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public v a(FrsActivity frsActivity, BdExpandListView bdExpandListView, boolean z) {
        return new com.baidu.tieba.frs.entelechy.a.c(frsActivity, bdExpandListView, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.b.a
    /* renamed from: a */
    public com.baidu.tieba.frs.h.e c(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        return new com.baidu.tieba.frs.h.e(frsActivity, noPressedRelativeLayout);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.c b(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        return new com.baidu.tieba.frs.h.a(frsActivity, noPressedRelativeLayout);
    }
}
