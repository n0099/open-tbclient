package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.frs.entelechy.a.w;
import com.baidu.tieba.frs.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private BdTypeListView dvB;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private ab fII = new ab() { // from class: com.baidu.tieba.frs.gamerecommend.a.a.1
        @Override // com.baidu.tieba.card.ab
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            super.a(view, bVar);
            a.this.notifyDataSetChanged();
        }
    };
    private List<com.baidu.adp.widget.ListView.a> agQ = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.mPageContext = tbPageContext;
        this.dvB = bdTypeListView;
        this.mForumId = str;
        this.mForumName = str2;
        sX();
    }

    private void sX() {
        b bVar = new b(this.mPageContext, this.mForumId, this.mForumName);
        bVar.e(this.fII);
        this.agQ.add(bVar);
        c cVar = new c(this.mPageContext, this.mForumId);
        cVar.e(this.fII);
        this.agQ.add(cVar);
        this.agQ.add(new h(this.mPageContext, this.mForumId));
        this.agQ.add(new f(this.mPageContext, this.mForumId));
        this.agQ.add(new i(this.mPageContext, com.baidu.tieba.e.h.eWU, this.mPageContext.getUniqueId(), this.mForumId));
        e eVar = new e(this.mPageContext, this.mForumId);
        eVar.e(this.fII);
        this.agQ.add(eVar);
        this.agQ.add(new d(this.mPageContext, com.baidu.tieba.e.c.eWI, this.mPageContext.getUniqueId(), this.mForumId));
        this.agQ.add(new g(this.mPageContext, com.baidu.tieba.e.f.eWQ, this.mPageContext.getUniqueId(), this.mForumId));
        w wVar = new w(this.mPageContext, q.fyC, this.mPageContext.getUniqueId());
        wVar.bng();
        wVar.setForumId(this.mForumId);
        this.agQ.add(wVar);
        this.dvB.addAdapters(this.agQ);
    }

    public void setData(List<m> list) {
        if (this.dvB != null) {
            this.dvB.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.dvB.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.dvB.getAdapter().notifyDataSetChanged();
        }
    }
}
