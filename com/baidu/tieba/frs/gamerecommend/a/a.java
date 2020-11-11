package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.frs.entelechy.a.ag;
import com.baidu.tieba.frs.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private BdTypeListView gih;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private ab iXp = new ab() { // from class: com.baidu.tieba.frs.gamerecommend.a.a.1
        @Override // com.baidu.tieba.card.ab
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            super.a(view, bVar);
            a.this.notifyDataSetChanged();
        }
    };
    private List<com.baidu.adp.widget.ListView.a> bky = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.mPageContext = tbPageContext;
        this.gih = bdTypeListView;
        this.mForumId = str;
        this.mForumName = str2;
        LY();
    }

    private void LY() {
        b bVar = new b(this.mPageContext, this.mForumId, this.mForumName);
        bVar.d(this.iXp);
        this.bky.add(bVar);
        c cVar = new c(this.mPageContext, this.mForumId);
        cVar.d(this.iXp);
        this.bky.add(cVar);
        this.bky.add(new h(this.mPageContext, this.mForumId));
        this.bky.add(new f(this.mPageContext, this.mForumId));
        this.bky.add(new i(this.mPageContext, com.baidu.tieba.e.h.ieY, this.mPageContext.getUniqueId(), this.mForumId));
        e eVar = new e(this.mPageContext, this.mForumId);
        eVar.d(this.iXp);
        this.bky.add(eVar);
        this.bky.add(new d(this.mPageContext, com.baidu.tieba.e.c.ieM, this.mPageContext.getUniqueId(), this.mForumId));
        this.bky.add(new g(this.mPageContext, com.baidu.tieba.e.f.ieU, this.mPageContext.getUniqueId(), this.mForumId));
        ag agVar = new ag(this.mPageContext, y.iLn, this.mPageContext.getUniqueId());
        agVar.cCh();
        agVar.setForumId(this.mForumId);
        this.bky.add(agVar);
        this.gih.addAdapters(this.bky);
    }

    public void setData(List<q> list) {
        if (this.gih != null) {
            this.gih.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.gih.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.gih.getAdapter().notifyDataSetChanged();
        }
    }
}
