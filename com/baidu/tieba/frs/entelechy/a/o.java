package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.widget.ListView.a<bi, com.baidu.tieba.card.b.a<com.baidu.tieba.frs.entelechy.view.t>> implements cd, com.baidu.tieba.frs.e.e {
    private TbPageContext<?> ajT;
    private com.baidu.tieba.frs.entelechy.view.t bSx;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bSy;
    private com.baidu.adp.lib.e.b<TbImageView> bSz;
    private cf<bi> baF;
    private String mForumName;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.baF = new p(this);
        this.bSy = new com.baidu.adp.lib.e.b<>(new q(this), 6, 0);
        this.bSz = new com.baidu.adp.lib.e.b<>(new r(this), 12, 0);
        this.ajT = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.bSx = new com.baidu.tieba.frs.entelechy.view.t(this.ajT);
        this.bSx.setConstrainLayoutPool(this.bSy);
        this.bSx.setConstrainImagePool(this.bSz);
        this.bSx.setForumName(this.mForumName);
        this.bSx.j(this.ajT.getUniqueId());
        return new com.baidu.tieba.card.b.a(this.bSx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bi biVar, com.baidu.tieba.card.b.a aVar) {
        if (aVar == null || aVar.Tz() == null) {
            return null;
        }
        aVar.Tz().onBindDataToView(biVar);
        aVar.Tz().setOnSubCardOnClickListenner(this.baF);
        com.baidu.tieba.frs.e.b.adp().a(bYW, biVar);
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.bSx != null) {
            this.bSx.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.cd
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
