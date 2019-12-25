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
/* loaded from: classes6.dex */
public class a {
    private BdTypeListView efM;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private z gwg = new z() { // from class: com.baidu.tieba.frs.gamerecommend.a.a.1
        @Override // com.baidu.tieba.card.z
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            super.a(view, bVar);
            a.this.notifyDataSetChanged();
        }
    };
    private List<com.baidu.adp.widget.ListView.a> aoz = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.mPageContext = tbPageContext;
        this.efM = bdTypeListView;
        this.mForumId = str;
        this.mForumName = str2;
        uR();
    }

    private void uR() {
        b bVar = new b(this.mPageContext, this.mForumId, this.mForumName);
        bVar.d(this.gwg);
        this.aoz.add(bVar);
        c cVar = new c(this.mPageContext, this.mForumId);
        cVar.d(this.gwg);
        this.aoz.add(cVar);
        this.aoz.add(new h(this.mPageContext, this.mForumId));
        this.aoz.add(new f(this.mPageContext, this.mForumId));
        this.aoz.add(new i(this.mPageContext, com.baidu.tieba.e.h.fKM, this.mPageContext.getUniqueId(), this.mForumId));
        e eVar = new e(this.mPageContext, this.mForumId);
        eVar.d(this.gwg);
        this.aoz.add(eVar);
        this.aoz.add(new d(this.mPageContext, com.baidu.tieba.e.c.fKA, this.mPageContext.getUniqueId(), this.mForumId));
        this.aoz.add(new g(this.mPageContext, com.baidu.tieba.e.f.fKI, this.mPageContext.getUniqueId(), this.mForumId));
        ab abVar = new ab(this.mPageContext, r.gmi, this.mPageContext.getUniqueId());
        abVar.bEC();
        abVar.setForumId(this.mForumId);
        this.aoz.add(abVar);
        this.efM.addAdapters(this.aoz);
    }

    public void setData(List<m> list) {
        if (this.efM != null) {
            this.efM.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.efM.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.efM.getAdapter().notifyDataSetChanged();
        }
    }
}
