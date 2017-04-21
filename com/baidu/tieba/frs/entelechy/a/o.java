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
    private TbPageContext<?> ajU;
    private com.baidu.tieba.frs.entelechy.view.t bUO;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bUP;
    private com.baidu.adp.lib.e.b<TbImageView> bUQ;
    private cf<bi> bbB;
    private String mForumName;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bbB = new p(this);
        this.bUP = new com.baidu.adp.lib.e.b<>(new q(this), 6, 0);
        this.bUQ = new com.baidu.adp.lib.e.b<>(new r(this), 12, 0);
        this.ajU = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.bUO = new com.baidu.tieba.frs.entelechy.view.t(this.ajU);
        this.bUO.setConstrainLayoutPool(this.bUP);
        this.bUO.setConstrainImagePool(this.bUQ);
        this.bUO.setForumName(this.mForumName);
        this.bUO.j(this.ajU.getUniqueId());
        return new com.baidu.tieba.card.b.a(this.bUO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bi biVar, com.baidu.tieba.card.b.a aVar) {
        if (aVar == null || aVar.UB() == null) {
            return null;
        }
        aVar.UB().onBindDataToView(biVar);
        aVar.UB().setOnSubCardOnClickListenner(this.bbB);
        com.baidu.tieba.frs.e.b.aeq().a(cbn, biVar);
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.bUO != null) {
            this.bUO.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.cd
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
