package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.n, com.baidu.tieba.card.b.a<ap>> {
    private TbPageContext<?> ajF;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bSK;
    private com.baidu.adp.lib.e.b<TbImageView> bSL;
    private cf baM;
    public BdUniqueId baP;
    private ap czs;
    private com.baidu.tieba.homepage.personalize.model.f czt;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.baM = new h(this);
        this.bSK = new com.baidu.adp.lib.e.b<>(new i(this), 6, 0);
        this.bSL = new com.baidu.adp.lib.e.b<>(new j(this), 12, 0);
        this.ajF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.czs = new ap(this.ajF);
        if (this.czs.brM != null) {
            this.czs.brM.setReplyTimeVisible(false);
            this.czs.brM.setViewNumEnabled(true);
        }
        this.czs.Sm();
        this.czs.setSingleImageRatio(0.75d);
        this.czs.setConstrainLayoutPool(this.bSK);
        this.czs.setConstrainImagePool(this.bSL);
        this.czs.j(this.baP);
        return new com.baidu.tieba.card.b.a(this.czs);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.n nVar, com.baidu.tieba.card.b.a aVar) {
        if (nVar == null || aVar == null || aVar.Tb() == null) {
            return null;
        }
        nVar.gI(i + 1);
        aVar.Tb().onBindDataToView(nVar);
        aVar.Tb().setOnSubCardOnClickListenner(this.baM);
        if (nVar.threadData != null && nVar.threadData.getTid() != null) {
            cc.Sv().a(new as("c11003").Z("tid", nVar.threadData.getTid()));
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.czs != null) {
            this.czs.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.czt = fVar;
    }
}
