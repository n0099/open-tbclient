package com.baidu.tieba.frs.entelechy;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.entelechy.a.aj;
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.frs.entelechy.b.a {
    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.g aeg() {
        return new com.baidu.tieba.frs.f.a();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.d C(FrsActivity frsActivity) {
        return new com.baidu.tieba.frs.entelechy.c.a(frsActivity);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.b aeh() {
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
        jVar.b(frsActivity.abN());
        jVar.b(frsActivity.abO());
        return jVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public aj a(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        return new com.baidu.tieba.frs.entelechy.a.a(frsActivity, bdTypeListView, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.b.a
    /* renamed from: a */
    public com.baidu.tieba.frs.j.f c(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        return new com.baidu.tieba.frs.j.f(frsActivity, noPressedRelativeLayout);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.a
    public com.baidu.tieba.frs.entelechy.b.c b(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        return new com.baidu.tieba.frs.j.d(frsActivity, noPressedRelativeLayout);
    }
}
