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
    private BdTypeListView eko;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private z gBE = new z() { // from class: com.baidu.tieba.frs.gamerecommend.a.a.1
        @Override // com.baidu.tieba.card.z
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            super.a(view, bVar);
            a.this.notifyDataSetChanged();
        }
    };
    private List<com.baidu.adp.widget.ListView.a> asF = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.mPageContext = tbPageContext;
        this.eko = bdTypeListView;
        this.mForumId = str;
        this.mForumName = str2;
        wM();
    }

    private void wM() {
        b bVar = new b(this.mPageContext, this.mForumId, this.mForumName);
        bVar.d(this.gBE);
        this.asF.add(bVar);
        c cVar = new c(this.mPageContext, this.mForumId);
        cVar.d(this.gBE);
        this.asF.add(cVar);
        this.asF.add(new h(this.mPageContext, this.mForumId));
        this.asF.add(new f(this.mPageContext, this.mForumId));
        this.asF.add(new i(this.mPageContext, com.baidu.tieba.e.h.fQF, this.mPageContext.getUniqueId(), this.mForumId));
        e eVar = new e(this.mPageContext, this.mForumId);
        eVar.d(this.gBE);
        this.asF.add(eVar);
        this.asF.add(new d(this.mPageContext, com.baidu.tieba.e.c.fQt, this.mPageContext.getUniqueId(), this.mForumId));
        this.asF.add(new g(this.mPageContext, com.baidu.tieba.e.f.fQB, this.mPageContext.getUniqueId(), this.mForumId));
        ab abVar = new ab(this.mPageContext, r.grH, this.mPageContext.getUniqueId());
        abVar.bHj();
        abVar.setForumId(this.mForumId);
        this.asF.add(abVar);
        this.eko.addAdapters(this.asF);
    }

    public void setData(List<m> list) {
        if (this.eko != null) {
            this.eko.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.eko.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.eko.getAdapter().notifyDataSetChanged();
        }
    }
}
