package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.frs.entelechy.a.ad;
import com.baidu.tieba.frs.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeListView faQ;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private aa hAS = new aa() { // from class: com.baidu.tieba.frs.gamerecommend.a.a.1
        @Override // com.baidu.tieba.card.aa
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            super.a(view, bVar);
            a.this.notifyDataSetChanged();
        }
    };
    private List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.mPageContext = tbPageContext;
        this.faQ = bdTypeListView;
        this.mForumId = str;
        this.mForumName = str2;
        CY();
    }

    private void CY() {
        b bVar = new b(this.mPageContext, this.mForumId, this.mForumName);
        bVar.d(this.hAS);
        this.aSj.add(bVar);
        c cVar = new c(this.mPageContext, this.mForumId);
        cVar.d(this.hAS);
        this.aSj.add(cVar);
        this.aSj.add(new h(this.mPageContext, this.mForumId));
        this.aSj.add(new f(this.mPageContext, this.mForumId));
        this.aSj.add(new i(this.mPageContext, com.baidu.tieba.e.h.gKN, this.mPageContext.getUniqueId(), this.mForumId));
        e eVar = new e(this.mPageContext, this.mForumId);
        eVar.d(this.hAS);
        this.aSj.add(eVar);
        this.aSj.add(new d(this.mPageContext, com.baidu.tieba.e.c.gKB, this.mPageContext.getUniqueId(), this.mForumId));
        this.aSj.add(new g(this.mPageContext, com.baidu.tieba.e.f.gKJ, this.mPageContext.getUniqueId(), this.mForumId));
        ad adVar = new ad(this.mPageContext, u.hqx, this.mPageContext.getUniqueId());
        adVar.bYt();
        adVar.setForumId(this.mForumId);
        this.aSj.add(adVar);
        this.faQ.addAdapters(this.aSj);
    }

    public void setData(List<o> list) {
        if (this.faQ != null) {
            this.faQ.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.faQ.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.faQ.getAdapter().notifyDataSetChanged();
        }
    }
}
