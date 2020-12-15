package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.entelechy.a.ah;
import com.baidu.tieba.frs.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private BdTypeListView gpZ;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private ab jlC = new ab() { // from class: com.baidu.tieba.frs.gamerecommend.a.a.1
        @Override // com.baidu.tieba.card.ab
        public void a(View view, BaseCardInfo baseCardInfo) {
            super.a(view, baseCardInfo);
            a.this.notifyDataSetChanged();
        }
    };
    private List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.mPageContext = tbPageContext;
        this.gpZ = bdTypeListView;
        this.mForumId = str;
        this.mForumName = str2;
        Nt();
    }

    private void Nt() {
        b bVar = new b(this.mPageContext, this.mForumId, this.mForumName);
        bVar.d(this.jlC);
        this.bnf.add(bVar);
        c cVar = new c(this.mPageContext, this.mForumId);
        cVar.d(this.jlC);
        this.bnf.add(cVar);
        this.bnf.add(new h(this.mPageContext, this.mForumId));
        this.bnf.add(new f(this.mPageContext, this.mForumId));
        this.bnf.add(new i(this.mPageContext, com.baidu.tieba.f.h.iqJ, this.mPageContext.getUniqueId(), this.mForumId));
        e eVar = new e(this.mPageContext, this.mForumId);
        eVar.d(this.jlC);
        this.bnf.add(eVar);
        this.bnf.add(new d(this.mPageContext, com.baidu.tieba.f.c.iqx, this.mPageContext.getUniqueId(), this.mForumId));
        this.bnf.add(new g(this.mPageContext, com.baidu.tieba.f.f.iqF, this.mPageContext.getUniqueId(), this.mForumId));
        ah ahVar = new ah(this.mPageContext, x.iWT, this.mPageContext.getUniqueId());
        ahVar.cGe();
        ahVar.setForumId(this.mForumId);
        this.bnf.add(ahVar);
        this.gpZ.addAdapters(this.bnf);
    }

    public void setData(List<q> list) {
        if (this.gpZ != null) {
            this.gpZ.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.gpZ.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.gpZ.getAdapter().notifyDataSetChanged();
        }
    }
}
