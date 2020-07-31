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
/* loaded from: classes16.dex */
public class a {
    private BdTypeListView frv;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private aa hUM = new aa() { // from class: com.baidu.tieba.frs.gamerecommend.a.a.1
        @Override // com.baidu.tieba.card.aa
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            super.a(view, bVar);
            a.this.notifyDataSetChanged();
        }
    };
    private List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.mPageContext = tbPageContext;
        this.frv = bdTypeListView;
        this.mForumId = str;
        this.mForumName = str2;
        DS();
    }

    private void DS() {
        b bVar = new b(this.mPageContext, this.mForumId, this.mForumName);
        bVar.d(this.hUM);
        this.aWf.add(bVar);
        c cVar = new c(this.mPageContext, this.mForumId);
        cVar.d(this.hUM);
        this.aWf.add(cVar);
        this.aWf.add(new h(this.mPageContext, this.mForumId));
        this.aWf.add(new f(this.mPageContext, this.mForumId));
        this.aWf.add(new i(this.mPageContext, com.baidu.tieba.e.h.hdA, this.mPageContext.getUniqueId(), this.mForumId));
        e eVar = new e(this.mPageContext, this.mForumId);
        eVar.d(this.hUM);
        this.aWf.add(eVar);
        this.aWf.add(new d(this.mPageContext, com.baidu.tieba.e.c.hdo, this.mPageContext.getUniqueId(), this.mForumId));
        this.aWf.add(new g(this.mPageContext, com.baidu.tieba.e.f.hdw, this.mPageContext.getUniqueId(), this.mForumId));
        ag agVar = new ag(this.mPageContext, x.hJt, this.mPageContext.getUniqueId());
        agVar.cfj();
        agVar.setForumId(this.mForumId);
        this.aWf.add(agVar);
        this.frv.addAdapters(this.aWf);
    }

    public void setData(List<q> list) {
        if (this.frv != null) {
            this.frv.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.frv.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.frv.getAdapter().notifyDataSetChanged();
        }
    }
}
