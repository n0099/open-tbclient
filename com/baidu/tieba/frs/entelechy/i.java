package com.baidu.tieba.frs.entelechy;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.entelechy.a.am;
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.frs.entelechy.b.a {
    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.g Yz() {
        return new com.baidu.tieba.frs.e.a();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.d B(FrsActivity frsActivity) {
        return new com.baidu.tieba.frs.entelechy.c.a(frsActivity);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.b YA() {
        return new t();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.view.c a(String str, FrsActivity frsActivity, int i) {
        g jVar;
        if (frsActivity == null) {
            return null;
        }
        if ("book_page".equals(str)) {
            jVar = new a(frsActivity, null, null, i);
        } else if ("frs_page".equals(str)) {
            jVar = new u(frsActivity, null, null, i);
        } else {
            jVar = new j(frsActivity, null, null, i);
        }
        jVar.b(frsActivity.Wc());
        jVar.b(frsActivity.Wd());
        return jVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public am a(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        return new com.baidu.tieba.frs.entelechy.a.b(frsActivity, bdTypeListView, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.b.a
    /* renamed from: a */
    public com.baidu.tieba.frs.h.i c(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        return new com.baidu.tieba.frs.h.i(frsActivity, noPressedRelativeLayout);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.c b(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        return new com.baidu.tieba.frs.h.d(frsActivity, noPressedRelativeLayout);
    }
}
