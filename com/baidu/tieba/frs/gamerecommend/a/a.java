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
    private BdTypeListView fCT;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private aa ijb = new aa() { // from class: com.baidu.tieba.frs.gamerecommend.a.a.1
        @Override // com.baidu.tieba.card.aa
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            super.a(view, bVar);
            a.this.notifyDataSetChanged();
        }
    };
    private List<com.baidu.adp.widget.ListView.a> bbw = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.mPageContext = tbPageContext;
        this.fCT = bdTypeListView;
        this.mForumId = str;
        this.mForumName = str2;
        Jv();
    }

    private void Jv() {
        b bVar = new b(this.mPageContext, this.mForumId, this.mForumName);
        bVar.d(this.ijb);
        this.bbw.add(bVar);
        c cVar = new c(this.mPageContext, this.mForumId);
        cVar.d(this.ijb);
        this.bbw.add(cVar);
        this.bbw.add(new h(this.mPageContext, this.mForumId));
        this.bbw.add(new f(this.mPageContext, this.mForumId));
        this.bbw.add(new i(this.mPageContext, com.baidu.tieba.e.h.hqA, this.mPageContext.getUniqueId(), this.mForumId));
        e eVar = new e(this.mPageContext, this.mForumId);
        eVar.d(this.ijb);
        this.bbw.add(eVar);
        this.bbw.add(new d(this.mPageContext, com.baidu.tieba.e.c.hqo, this.mPageContext.getUniqueId(), this.mForumId));
        this.bbw.add(new g(this.mPageContext, com.baidu.tieba.e.f.hqw, this.mPageContext.getUniqueId(), this.mForumId));
        ag agVar = new ag(this.mPageContext, y.hWT, this.mPageContext.getUniqueId());
        agVar.cpP();
        agVar.setForumId(this.mForumId);
        this.bbw.add(agVar);
        this.fCT.addAdapters(this.bbw);
    }

    public void setData(List<q> list) {
        if (this.fCT != null) {
            this.fCT.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.fCT.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fCT.getAdapter().notifyDataSetChanged();
        }
    }
}
