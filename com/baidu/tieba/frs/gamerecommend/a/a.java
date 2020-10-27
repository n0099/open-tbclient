package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.frs.entelechy.a.ag;
import com.baidu.tieba.frs.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private BdTypeListView gcr;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private ab iRs = new ab() { // from class: com.baidu.tieba.frs.gamerecommend.a.a.1
        @Override // com.baidu.tieba.card.ab
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            super.a(view, bVar);
            a.this.notifyDataSetChanged();
        }
    };
    private List<com.baidu.adp.widget.ListView.a> bje = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.mPageContext = tbPageContext;
        this.gcr = bdTypeListView;
        this.mForumId = str;
        this.mForumName = str2;
        Ly();
    }

    private void Ly() {
        b bVar = new b(this.mPageContext, this.mForumId, this.mForumName);
        bVar.d(this.iRs);
        this.bje.add(bVar);
        c cVar = new c(this.mPageContext, this.mForumId);
        cVar.d(this.iRs);
        this.bje.add(cVar);
        this.bje.add(new h(this.mPageContext, this.mForumId));
        this.bje.add(new f(this.mPageContext, this.mForumId));
        this.bje.add(new i(this.mPageContext, com.baidu.tieba.e.h.hYX, this.mPageContext.getUniqueId(), this.mForumId));
        e eVar = new e(this.mPageContext, this.mForumId);
        eVar.d(this.iRs);
        this.bje.add(eVar);
        this.bje.add(new d(this.mPageContext, com.baidu.tieba.e.c.hYL, this.mPageContext.getUniqueId(), this.mForumId));
        this.bje.add(new g(this.mPageContext, com.baidu.tieba.e.f.hYT, this.mPageContext.getUniqueId(), this.mForumId));
        ag agVar = new ag(this.mPageContext, y.iFq, this.mPageContext.getUniqueId());
        agVar.czG();
        agVar.setForumId(this.mForumId);
        this.bje.add(agVar);
        this.gcr.addAdapters(this.bje);
    }

    public void setData(List<q> list) {
        if (this.gcr != null) {
            this.gcr.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.gcr.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.gcr.getAdapter().notifyDataSetChanged();
        }
    }
}
