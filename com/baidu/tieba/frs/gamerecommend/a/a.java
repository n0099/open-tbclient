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
/* loaded from: classes21.dex */
public class a {
    private BdTypeListView fGf;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private aa iqd = new aa() { // from class: com.baidu.tieba.frs.gamerecommend.a.a.1
        @Override // com.baidu.tieba.card.aa
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            super.a(view, bVar);
            a.this.notifyDataSetChanged();
        }
    };
    private List<com.baidu.adp.widget.ListView.a> bdV = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.mPageContext = tbPageContext;
        this.fGf = bdTypeListView;
        this.mForumId = str;
        this.mForumName = str2;
        JZ();
    }

    private void JZ() {
        b bVar = new b(this.mPageContext, this.mForumId, this.mForumName);
        bVar.d(this.iqd);
        this.bdV.add(bVar);
        c cVar = new c(this.mPageContext, this.mForumId);
        cVar.d(this.iqd);
        this.bdV.add(cVar);
        this.bdV.add(new h(this.mPageContext, this.mForumId));
        this.bdV.add(new f(this.mPageContext, this.mForumId));
        this.bdV.add(new i(this.mPageContext, com.baidu.tieba.e.h.hxF, this.mPageContext.getUniqueId(), this.mForumId));
        e eVar = new e(this.mPageContext, this.mForumId);
        eVar.d(this.iqd);
        this.bdV.add(eVar);
        this.bdV.add(new d(this.mPageContext, com.baidu.tieba.e.c.hxt, this.mPageContext.getUniqueId(), this.mForumId));
        this.bdV.add(new g(this.mPageContext, com.baidu.tieba.e.f.hxB, this.mPageContext.getUniqueId(), this.mForumId));
        ag agVar = new ag(this.mPageContext, y.idX, this.mPageContext.getUniqueId());
        agVar.ctc();
        agVar.setForumId(this.mForumId);
        this.bdV.add(agVar);
        this.fGf.addAdapters(this.bdV);
    }

    public void setData(List<q> list) {
        if (this.fGf != null) {
            this.fGf.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.fGf.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fGf.getAdapter().notifyDataSetChanged();
        }
    }
}
