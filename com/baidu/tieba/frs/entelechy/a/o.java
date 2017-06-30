package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cg;
import com.baidu.tieba.card.ci;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.widget.ListView.a<bm, com.baidu.tieba.card.b.a<com.baidu.tieba.frs.entelechy.view.q>> implements cg, com.baidu.tieba.frs.d.e {
    private TbPageContext<?> ajP;
    private ci<bm> bgf;
    private com.baidu.tieba.frs.entelechy.view.q cgI;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> cgJ;
    private com.baidu.adp.lib.e.b<TbImageView> cgK;
    private String mForumName;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: n */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cgI = new com.baidu.tieba.frs.entelechy.view.q(this.ajP, this.mPageId);
        this.cgI.setConstrainLayoutPool(this.cgJ);
        this.cgI.setConstrainImagePool(this.cgK);
        this.cgI.setForumName(this.mForumName);
        this.cgI.j(this.mPageId);
        return new com.baidu.tieba.card.b.a(this.cgI);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bm bmVar, com.baidu.tieba.card.b.a aVar) {
        if (aVar == null || aVar.Wp() == null) {
            return null;
        }
        aVar.Wp().a((com.baidu.tieba.card.a) bmVar);
        aVar.Wp().a(this.bgf);
        com.baidu.tieba.frs.d.b.aho().a(cnC, bmVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.cg
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
