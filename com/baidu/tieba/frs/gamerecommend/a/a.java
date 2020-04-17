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
    private BdTypeListView eOe;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private z hlY = new z() { // from class: com.baidu.tieba.frs.gamerecommend.a.a.1
        @Override // com.baidu.tieba.card.z
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            super.a(view, bVar);
            a.this.notifyDataSetChanged();
        }
    };
    private List<com.baidu.adp.widget.ListView.a> aMd = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.mPageContext = tbPageContext;
        this.eOe = bdTypeListView;
        this.mForumId = str;
        this.mForumName = str2;
        BC();
    }

    private void BC() {
        b bVar = new b(this.mPageContext, this.mForumId, this.mForumName);
        bVar.d(this.hlY);
        this.aMd.add(bVar);
        c cVar = new c(this.mPageContext, this.mForumId);
        cVar.d(this.hlY);
        this.aMd.add(cVar);
        this.aMd.add(new h(this.mPageContext, this.mForumId));
        this.aMd.add(new f(this.mPageContext, this.mForumId));
        this.aMd.add(new i(this.mPageContext, com.baidu.tieba.e.h.gvW, this.mPageContext.getUniqueId(), this.mForumId));
        e eVar = new e(this.mPageContext, this.mForumId);
        eVar.d(this.hlY);
        this.aMd.add(eVar);
        this.aMd.add(new d(this.mPageContext, com.baidu.tieba.e.c.gvK, this.mPageContext.getUniqueId(), this.mForumId));
        this.aMd.add(new g(this.mPageContext, com.baidu.tieba.e.f.gvS, this.mPageContext.getUniqueId(), this.mForumId));
        ad adVar = new ad(this.mPageContext, u.hbD, this.mPageContext.getUniqueId());
        adVar.bRZ();
        adVar.setForumId(this.mForumId);
        this.aMd.add(adVar);
        this.eOe.addAdapters(this.aMd);
    }

    public void setData(List<m> list) {
        if (this.eOe != null) {
            this.eOe.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.eOe.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.eOe.getAdapter().notifyDataSetChanged();
        }
    }
}
