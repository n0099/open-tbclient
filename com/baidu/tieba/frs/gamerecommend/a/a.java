package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.entelechy.a.ab;
import com.baidu.tieba.frs.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeListView eka;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private z gBq = new z() { // from class: com.baidu.tieba.frs.gamerecommend.a.a.1
        @Override // com.baidu.tieba.card.z
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            super.a(view, bVar);
            a.this.notifyDataSetChanged();
        }
    };
    private List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.mPageContext = tbPageContext;
        this.eka = bdTypeListView;
        this.mForumId = str;
        this.mForumName = str2;
        wM();
    }

    private void wM() {
        b bVar = new b(this.mPageContext, this.mForumId, this.mForumName);
        bVar.d(this.gBq);
        this.asE.add(bVar);
        c cVar = new c(this.mPageContext, this.mForumId);
        cVar.d(this.gBq);
        this.asE.add(cVar);
        this.asE.add(new h(this.mPageContext, this.mForumId));
        this.asE.add(new f(this.mPageContext, this.mForumId));
        this.asE.add(new i(this.mPageContext, com.baidu.tieba.e.h.fQq, this.mPageContext.getUniqueId(), this.mForumId));
        e eVar = new e(this.mPageContext, this.mForumId);
        eVar.d(this.gBq);
        this.asE.add(eVar);
        this.asE.add(new d(this.mPageContext, com.baidu.tieba.e.c.fQe, this.mPageContext.getUniqueId(), this.mForumId));
        this.asE.add(new g(this.mPageContext, com.baidu.tieba.e.f.fQm, this.mPageContext.getUniqueId(), this.mForumId));
        ab abVar = new ab(this.mPageContext, r.grs, this.mPageContext.getUniqueId());
        abVar.bHg();
        abVar.setForumId(this.mForumId);
        this.asE.add(abVar);
        this.eka.addAdapters(this.asE);
    }

    public void setData(List<m> list) {
        if (this.eka != null) {
            this.eka.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.eka.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.eka.getAdapter().notifyDataSetChanged();
        }
    }
}
