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
    private BdTypeListView duK;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private ab fHR = new ab() { // from class: com.baidu.tieba.frs.gamerecommend.a.a.1
        @Override // com.baidu.tieba.card.ab
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            super.a(view, bVar);
            a.this.notifyDataSetChanged();
        }
    };
    private List<com.baidu.adp.widget.ListView.a> agy = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.mPageContext = tbPageContext;
        this.duK = bdTypeListView;
        this.mForumId = str;
        this.mForumName = str2;
        sY();
    }

    private void sY() {
        b bVar = new b(this.mPageContext, this.mForumId, this.mForumName);
        bVar.e(this.fHR);
        this.agy.add(bVar);
        c cVar = new c(this.mPageContext, this.mForumId);
        cVar.e(this.fHR);
        this.agy.add(cVar);
        this.agy.add(new h(this.mPageContext, this.mForumId));
        this.agy.add(new f(this.mPageContext, this.mForumId));
        this.agy.add(new i(this.mPageContext, com.baidu.tieba.e.h.eWd, this.mPageContext.getUniqueId(), this.mForumId));
        e eVar = new e(this.mPageContext, this.mForumId);
        eVar.e(this.fHR);
        this.agy.add(eVar);
        this.agy.add(new d(this.mPageContext, com.baidu.tieba.e.c.eVR, this.mPageContext.getUniqueId(), this.mForumId));
        this.agy.add(new g(this.mPageContext, com.baidu.tieba.e.f.eVZ, this.mPageContext.getUniqueId(), this.mForumId));
        w wVar = new w(this.mPageContext, q.fxL, this.mPageContext.getUniqueId());
        wVar.bne();
        wVar.setForumId(this.mForumId);
        this.agy.add(wVar);
        this.duK.addAdapters(this.agy);
    }

    public void setData(List<m> list) {
        if (this.duK != null) {
            this.duK.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.duK.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.duK.getAdapter().notifyDataSetChanged();
        }
    }
}
