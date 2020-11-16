package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.entelechy.a.ag;
import com.baidu.tieba.frs.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class a {
    private BdTypeListView ghN;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private ab iYb = new ab() { // from class: com.baidu.tieba.frs.gamerecommend.a.a.1
        @Override // com.baidu.tieba.card.ab
        public void a(View view, BaseCardInfo baseCardInfo) {
            super.a(view, baseCardInfo);
            a.this.notifyDataSetChanged();
        }
    };
    private List<com.baidu.adp.widget.ListView.a> biN = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.mPageContext = tbPageContext;
        this.ghN = bdTypeListView;
        this.mForumId = str;
        this.mForumName = str2;
        Lp();
    }

    private void Lp() {
        b bVar = new b(this.mPageContext, this.mForumId, this.mForumName);
        bVar.d(this.iYb);
        this.biN.add(bVar);
        c cVar = new c(this.mPageContext, this.mForumId);
        cVar.d(this.iYb);
        this.biN.add(cVar);
        this.biN.add(new h(this.mPageContext, this.mForumId));
        this.biN.add(new f(this.mPageContext, this.mForumId));
        this.biN.add(new i(this.mPageContext, com.baidu.tieba.f.h.ifN, this.mPageContext.getUniqueId(), this.mForumId));
        e eVar = new e(this.mPageContext, this.mForumId);
        eVar.d(this.iYb);
        this.biN.add(eVar);
        this.biN.add(new d(this.mPageContext, com.baidu.tieba.f.c.ifB, this.mPageContext.getUniqueId(), this.mForumId));
        this.biN.add(new g(this.mPageContext, com.baidu.tieba.f.f.ifJ, this.mPageContext.getUniqueId(), this.mForumId));
        ag agVar = new ag(this.mPageContext, y.iMa, this.mPageContext.getUniqueId());
        agVar.cBK();
        agVar.setForumId(this.mForumId);
        this.biN.add(agVar);
        this.ghN.addAdapters(this.biN);
    }

    public void setData(List<q> list) {
        if (this.ghN != null) {
            this.ghN.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.ghN.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.ghN.getAdapter().notifyDataSetChanged();
        }
    }
}
