package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.frs.entelechy.a.ag;
import com.baidu.tieba.frs.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeListView fml;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private aa hON = new aa() { // from class: com.baidu.tieba.frs.gamerecommend.a.a.1
        @Override // com.baidu.tieba.card.aa
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            super.a(view, bVar);
            a.this.notifyDataSetChanged();
        }
    };
    private List<com.baidu.adp.widget.ListView.a> aUP = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.mPageContext = tbPageContext;
        this.fml = bdTypeListView;
        this.mForumId = str;
        this.mForumName = str2;
        Dz();
    }

    private void Dz() {
        b bVar = new b(this.mPageContext, this.mForumId, this.mForumName);
        bVar.d(this.hON);
        this.aUP.add(bVar);
        c cVar = new c(this.mPageContext, this.mForumId);
        cVar.d(this.hON);
        this.aUP.add(cVar);
        this.aUP.add(new h(this.mPageContext, this.mForumId));
        this.aUP.add(new f(this.mPageContext, this.mForumId));
        this.aUP.add(new i(this.mPageContext, com.baidu.tieba.e.h.gXV, this.mPageContext.getUniqueId(), this.mForumId));
        e eVar = new e(this.mPageContext, this.mForumId);
        eVar.d(this.hON);
        this.aUP.add(eVar);
        this.aUP.add(new d(this.mPageContext, com.baidu.tieba.e.c.gXJ, this.mPageContext.getUniqueId(), this.mForumId));
        this.aUP.add(new g(this.mPageContext, com.baidu.tieba.e.f.gXR, this.mPageContext.getUniqueId(), this.mForumId));
        ag agVar = new ag(this.mPageContext, x.hDv, this.mPageContext.getUniqueId());
        agVar.cbL();
        agVar.setForumId(this.mForumId);
        this.aUP.add(agVar);
        this.fml.addAdapters(this.aUP);
    }

    public void setData(List<q> list) {
        if (this.fml != null) {
            this.fml.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.fml.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fml.getAdapter().notifyDataSetChanged();
        }
    }
}
