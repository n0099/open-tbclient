package com.baidu.tieba.frs.entelechy;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.entelechy.a.ai;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.a {
    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.g XS() {
        return new com.baidu.tieba.frs.g.a();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.d N(FrsActivity frsActivity) {
        return new com.baidu.tieba.frs.entelechy.c.a(frsActivity);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.b XT() {
        return new n();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.view.c a(String str, FrsActivity frsActivity, int i) {
        b eVar;
        if (frsActivity == null) {
            return null;
        }
        if ("frs_page".equals(str)) {
            eVar = new o(frsActivity, null, null, i);
        } else {
            eVar = new e(frsActivity, null, null, i);
        }
        eVar.b(frsActivity.Wg());
        eVar.b(frsActivity.Wh());
        return eVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public ai a(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        return new com.baidu.tieba.frs.entelechy.a.c(frsActivity, bdTypeListView, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.b.a
    /* renamed from: a */
    public com.baidu.tieba.frs.j.h c(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        return new com.baidu.tieba.frs.j.h(frsActivity, noPressedRelativeLayout);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.c b(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        return new com.baidu.tieba.frs.j.d(frsActivity, noPressedRelativeLayout);
    }
}
