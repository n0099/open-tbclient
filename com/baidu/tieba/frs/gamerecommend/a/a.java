package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.frs.entelechy.a.ag;
import com.baidu.tieba.frs.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class a {
    private BdTypeListView fCP;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private aa iiV = new aa() { // from class: com.baidu.tieba.frs.gamerecommend.a.a.1
        @Override // com.baidu.tieba.card.aa
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            super.a(view, bVar);
            a.this.notifyDataSetChanged();
        }
    };
    private List<com.baidu.adp.widget.ListView.a> bbu = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.mPageContext = tbPageContext;
        this.fCP = bdTypeListView;
        this.mForumId = str;
        this.mForumName = str2;
        Jv();
    }

    private void Jv() {
        b bVar = new b(this.mPageContext, this.mForumId, this.mForumName);
        bVar.d(this.iiV);
        this.bbu.add(bVar);
        c cVar = new c(this.mPageContext, this.mForumId);
        cVar.d(this.iiV);
        this.bbu.add(cVar);
        this.bbu.add(new h(this.mPageContext, this.mForumId));
        this.bbu.add(new f(this.mPageContext, this.mForumId));
        this.bbu.add(new i(this.mPageContext, com.baidu.tieba.e.h.hqu, this.mPageContext.getUniqueId(), this.mForumId));
        e eVar = new e(this.mPageContext, this.mForumId);
        eVar.d(this.iiV);
        this.bbu.add(eVar);
        this.bbu.add(new d(this.mPageContext, com.baidu.tieba.e.c.hqi, this.mPageContext.getUniqueId(), this.mForumId));
        this.bbu.add(new g(this.mPageContext, com.baidu.tieba.e.f.hqq, this.mPageContext.getUniqueId(), this.mForumId));
        ag agVar = new ag(this.mPageContext, y.hWN, this.mPageContext.getUniqueId());
        agVar.cpO();
        agVar.setForumId(this.mForumId);
        this.bbu.add(agVar);
        this.fCP.addAdapters(this.bbu);
    }

    public void setData(List<q> list) {
        if (this.fCP != null) {
            this.fCP.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.fCP.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fCP.getAdapter().notifyDataSetChanged();
        }
    }
}
