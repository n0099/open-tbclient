package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.widget.ListView.a<bj, com.baidu.tieba.card.b.a<com.baidu.tieba.frs.entelechy.view.t>> implements cd, com.baidu.tieba.frs.e.e {
    private TbPageContext<?> ajF;
    private com.baidu.tieba.frs.entelechy.view.t bSJ;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bSK;
    private com.baidu.adp.lib.e.b<TbImageView> bSL;
    private cf<bj> baM;
    private String mForumName;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.baM = new p(this);
        this.bSK = new com.baidu.adp.lib.e.b<>(new q(this), 6, 0);
        this.bSL = new com.baidu.adp.lib.e.b<>(new r(this), 12, 0);
        this.ajF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.bSJ = new com.baidu.tieba.frs.entelechy.view.t(this.ajF);
        this.bSJ.setConstrainLayoutPool(this.bSK);
        this.bSJ.setConstrainImagePool(this.bSL);
        this.bSJ.setForumName(this.mForumName);
        this.bSJ.j(this.ajF.getUniqueId());
        return new com.baidu.tieba.card.b.a(this.bSJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bj bjVar, com.baidu.tieba.card.b.a aVar) {
        if (aVar == null || aVar.Tb() == null) {
            return null;
        }
        aVar.Tb().onBindDataToView(bjVar);
        aVar.Tb().setOnSubCardOnClickListenner(this.baM);
        com.baidu.tieba.frs.e.b.adv().a(cav, bjVar);
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.bSJ != null) {
            this.bSJ.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.cd
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
