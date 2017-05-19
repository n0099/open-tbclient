package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.card.cd;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.widget.ListView.a<bk, com.baidu.tieba.card.b.a<com.baidu.tieba.frs.entelechy.view.q>> implements cb, com.baidu.tieba.frs.c.e {
    private TbPageContext<?> ajr;
    private com.baidu.tieba.frs.entelechy.view.q bSI;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bSJ;
    private com.baidu.adp.lib.e.b<TbImageView> bSK;
    private cd<bk> bbX;
    private String mForumName;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.bbX = new p(this);
        this.bSJ = new com.baidu.adp.lib.e.b<>(new q(this), 6, 0);
        this.bSK = new com.baidu.adp.lib.e.b<>(new r(this), 12, 0);
        this.ajr = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.bSI = new com.baidu.tieba.frs.entelechy.view.q(this.ajr, this.mPageId);
        this.bSI.setConstrainLayoutPool(this.bSJ);
        this.bSI.setConstrainImagePool(this.bSK);
        this.bSI.setForumName(this.mForumName);
        this.bSI.j(this.mPageId);
        return new com.baidu.tieba.card.b.a(this.bSI);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bk bkVar, com.baidu.tieba.card.b.a aVar) {
        if (aVar == null || aVar.TU() == null) {
            return null;
        }
        aVar.TU().onBindDataToView(bkVar);
        aVar.TU().setOnSubCardOnClickListenner(this.bbX);
        com.baidu.tieba.frs.c.b.acs().a(bZb, bkVar);
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.bSI != null) {
            this.bSI.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.cb
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
