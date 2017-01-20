package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.widget.ListView.a<bh, com.baidu.tieba.card.b.a<com.baidu.tieba.frs.entelechy.view.t>> implements cd, com.baidu.tieba.frs.e.e {
    private TbPageContext<?> FY;
    private cf<bh> aUz;
    private com.baidu.tieba.frs.entelechy.view.t bLD;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bLE;
    private com.baidu.adp.lib.e.b<TbImageView> bLF;
    private String mForumName;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aUz = new p(this);
        this.bLE = new com.baidu.adp.lib.e.b<>(new q(this), 6, 0);
        this.bLF = new com.baidu.adp.lib.e.b<>(new r(this), 12, 0);
        this.FY = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.bLD = new com.baidu.tieba.frs.entelechy.view.t(this.FY);
        this.bLD.setConstrainLayoutPool(this.bLE);
        this.bLD.setConstrainImagePool(this.bLF);
        this.bLD.setForumName(this.mForumName);
        this.bLD.j(this.FY.getUniqueId());
        return new com.baidu.tieba.card.b.a(this.bLD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, com.baidu.tieba.card.b.a aVar) {
        if (aVar == null || aVar.Sd() == null) {
            return null;
        }
        aVar.Sd().onBindDataToView(bhVar);
        aVar.Sd().setOnSubCardOnClickListenner(this.aUz);
        com.baidu.tieba.frs.e.b.acx().a(bTj, bhVar);
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.bLD != null) {
            this.bLD.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.cd
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
