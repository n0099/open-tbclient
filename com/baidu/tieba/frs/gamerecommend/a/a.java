package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.entelechy.a.ad;
import com.baidu.tieba.frs.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeListView ekE;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private z gCC = new z() { // from class: com.baidu.tieba.frs.gamerecommend.a.a.1
        @Override // com.baidu.tieba.card.z
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            super.a(view, bVar);
            a.this.notifyDataSetChanged();
        }
    };
    private List<com.baidu.adp.widget.ListView.a> asP = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.mPageContext = tbPageContext;
        this.ekE = bdTypeListView;
        this.mForumId = str;
        this.mForumName = str2;
        wR();
    }

    private void wR() {
        b bVar = new b(this.mPageContext, this.mForumId, this.mForumName);
        bVar.d(this.gCC);
        this.asP.add(bVar);
        c cVar = new c(this.mPageContext, this.mForumId);
        cVar.d(this.gCC);
        this.asP.add(cVar);
        this.asP.add(new h(this.mPageContext, this.mForumId));
        this.asP.add(new f(this.mPageContext, this.mForumId));
        this.asP.add(new i(this.mPageContext, com.baidu.tieba.e.h.fRo, this.mPageContext.getUniqueId(), this.mForumId));
        e eVar = new e(this.mPageContext, this.mForumId);
        eVar.d(this.gCC);
        this.asP.add(eVar);
        this.asP.add(new d(this.mPageContext, com.baidu.tieba.e.c.fRc, this.mPageContext.getUniqueId(), this.mForumId));
        this.asP.add(new g(this.mPageContext, com.baidu.tieba.e.f.fRk, this.mPageContext.getUniqueId(), this.mForumId));
        ad adVar = new ad(this.mPageContext, s.gsr, this.mPageContext.getUniqueId());
        adVar.bHy();
        adVar.setForumId(this.mForumId);
        this.asP.add(adVar);
        this.ekE.addAdapters(this.asP);
    }

    public void setData(List<m> list) {
        if (this.ekE != null) {
            this.ekE.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.ekE.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.ekE.getAdapter().notifyDataSetChanged();
        }
    }
}
