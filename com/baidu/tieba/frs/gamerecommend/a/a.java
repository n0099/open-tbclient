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
/* loaded from: classes7.dex */
public class a {
    private BdTypeListView efW;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private z gzq = new z() { // from class: com.baidu.tieba.frs.gamerecommend.a.a.1
        @Override // com.baidu.tieba.card.z
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            super.a(view, bVar);
            a.this.notifyDataSetChanged();
        }
    };
    private List<com.baidu.adp.widget.ListView.a> apl = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.mPageContext = tbPageContext;
        this.efW = bdTypeListView;
        this.mForumId = str;
        this.mForumName = str2;
        vi();
    }

    private void vi() {
        b bVar = new b(this.mPageContext, this.mForumId, this.mForumName);
        bVar.d(this.gzq);
        this.apl.add(bVar);
        c cVar = new c(this.mPageContext, this.mForumId);
        cVar.d(this.gzq);
        this.apl.add(cVar);
        this.apl.add(new h(this.mPageContext, this.mForumId));
        this.apl.add(new f(this.mPageContext, this.mForumId));
        this.apl.add(new i(this.mPageContext, com.baidu.tieba.e.h.fNV, this.mPageContext.getUniqueId(), this.mForumId));
        e eVar = new e(this.mPageContext, this.mForumId);
        eVar.d(this.gzq);
        this.apl.add(eVar);
        this.apl.add(new d(this.mPageContext, com.baidu.tieba.e.c.fNJ, this.mPageContext.getUniqueId(), this.mForumId));
        this.apl.add(new g(this.mPageContext, com.baidu.tieba.e.f.fNR, this.mPageContext.getUniqueId(), this.mForumId));
        ab abVar = new ab(this.mPageContext, r.gpr, this.mPageContext.getUniqueId());
        abVar.bFE();
        abVar.setForumId(this.mForumId);
        this.apl.add(abVar);
        this.efW.addAdapters(this.apl);
    }

    public void setData(List<m> list) {
        if (this.efW != null) {
            this.efW.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.efW.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.efW.getAdapter().notifyDataSetChanged();
        }
    }
}
