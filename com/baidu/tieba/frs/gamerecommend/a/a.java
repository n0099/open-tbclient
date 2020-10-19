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
/* loaded from: classes22.dex */
public class a {
    private BdTypeListView fSo;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private aa iEW = new aa() { // from class: com.baidu.tieba.frs.gamerecommend.a.a.1
        @Override // com.baidu.tieba.card.aa
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            super.a(view, bVar);
            a.this.notifyDataSetChanged();
        }
    };
    private List<com.baidu.adp.widget.ListView.a> bhH = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.mPageContext = tbPageContext;
        this.fSo = bdTypeListView;
        this.mForumId = str;
        this.mForumName = str2;
        Le();
    }

    private void Le() {
        b bVar = new b(this.mPageContext, this.mForumId, this.mForumName);
        bVar.d(this.iEW);
        this.bhH.add(bVar);
        c cVar = new c(this.mPageContext, this.mForumId);
        cVar.d(this.iEW);
        this.bhH.add(cVar);
        this.bhH.add(new h(this.mPageContext, this.mForumId));
        this.bhH.add(new f(this.mPageContext, this.mForumId));
        this.bhH.add(new i(this.mPageContext, com.baidu.tieba.e.h.hMA, this.mPageContext.getUniqueId(), this.mForumId));
        e eVar = new e(this.mPageContext, this.mForumId);
        eVar.d(this.iEW);
        this.bhH.add(eVar);
        this.bhH.add(new d(this.mPageContext, com.baidu.tieba.e.c.hMo, this.mPageContext.getUniqueId(), this.mForumId));
        this.bhH.add(new g(this.mPageContext, com.baidu.tieba.e.f.hMw, this.mPageContext.getUniqueId(), this.mForumId));
        ag agVar = new ag(this.mPageContext, y.isU, this.mPageContext.getUniqueId());
        agVar.cwz();
        agVar.setForumId(this.mForumId);
        this.bhH.add(agVar);
        this.fSo.addAdapters(this.bhH);
    }

    public void setData(List<q> list) {
        if (this.fSo != null) {
            this.fSo.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.fSo.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fSo.getAdapter().notifyDataSetChanged();
        }
    }
}
