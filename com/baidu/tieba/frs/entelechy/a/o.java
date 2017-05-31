package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cg;
import com.baidu.tieba.card.ci;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.widget.ListView.a<bl, com.baidu.tieba.card.b.a<com.baidu.tieba.frs.entelechy.view.q>> implements cg, com.baidu.tieba.frs.d.e {
    private TbPageContext<?> ajh;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bYA;
    private com.baidu.adp.lib.e.b<TbImageView> bYB;
    private com.baidu.tieba.frs.entelechy.view.q bYz;
    private ci<bl> bdm;
    private String mForumName;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: l */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.bYz = new com.baidu.tieba.frs.entelechy.view.q(this.ajh, this.mPageId);
        this.bYz.setConstrainLayoutPool(this.bYA);
        this.bYz.setConstrainImagePool(this.bYB);
        this.bYz.setForumName(this.mForumName);
        this.bYz.j(this.mPageId);
        return new com.baidu.tieba.card.b.a(this.bYz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bl blVar, com.baidu.tieba.card.b.a aVar) {
        if (aVar == null || aVar.UY() == null) {
            return null;
        }
        aVar.UY().a((com.baidu.tieba.card.a) blVar);
        aVar.UY().a(this.bdm);
        com.baidu.tieba.frs.d.b.adw().a(cfm, blVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.cg
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
