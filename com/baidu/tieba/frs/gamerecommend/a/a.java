package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.entelechy.a.ad;
import com.baidu.tieba.frs.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeListView eOj;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private z hme = new z() { // from class: com.baidu.tieba.frs.gamerecommend.a.a.1
        @Override // com.baidu.tieba.card.z
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            super.a(view, bVar);
            a.this.notifyDataSetChanged();
        }
    };
    private List<com.baidu.adp.widget.ListView.a> aMj = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.mPageContext = tbPageContext;
        this.eOj = bdTypeListView;
        this.mForumId = str;
        this.mForumName = str2;
        BB();
    }

    private void BB() {
        b bVar = new b(this.mPageContext, this.mForumId, this.mForumName);
        bVar.d(this.hme);
        this.aMj.add(bVar);
        c cVar = new c(this.mPageContext, this.mForumId);
        cVar.d(this.hme);
        this.aMj.add(cVar);
        this.aMj.add(new h(this.mPageContext, this.mForumId));
        this.aMj.add(new f(this.mPageContext, this.mForumId));
        this.aMj.add(new i(this.mPageContext, com.baidu.tieba.e.h.gwc, this.mPageContext.getUniqueId(), this.mForumId));
        e eVar = new e(this.mPageContext, this.mForumId);
        eVar.d(this.hme);
        this.aMj.add(eVar);
        this.aMj.add(new d(this.mPageContext, com.baidu.tieba.e.c.gvQ, this.mPageContext.getUniqueId(), this.mForumId));
        this.aMj.add(new g(this.mPageContext, com.baidu.tieba.e.f.gvY, this.mPageContext.getUniqueId(), this.mForumId));
        ad adVar = new ad(this.mPageContext, u.hbJ, this.mPageContext.getUniqueId());
        adVar.bRX();
        adVar.setForumId(this.mForumId);
        this.aMj.add(adVar);
        this.eOj.addAdapters(this.aMj);
    }

    public void setData(List<m> list) {
        if (this.eOj != null) {
            this.eOj.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.eOj.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.eOj.getAdapter().notifyDataSetChanged();
        }
    }
}
