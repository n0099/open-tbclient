package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.ci;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.tieba.card.b.a<ap>> {
    public BdUniqueId aMp;
    private TbPageContext<?> ajP;
    private ci bgf;
    private ap cJI;
    private com.baidu.tieba.homepage.personalize.model.f cJJ;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> cgJ;
    private com.baidu.adp.lib.e.b<TbImageView> cgK;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bgf = new h(this);
        this.cgJ = new com.baidu.adp.lib.e.b<>(new i(this), 6, 0);
        this.cgK = new com.baidu.adp.lib.e.b<>(new j(this), 12, 0);
        this.ajP = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: n */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cJI = new ap(this.ajP);
        this.cJI.setSingleImageRatio(0.75d);
        this.cJI.setConstrainLayoutPool(this.cgJ);
        this.cJI.setConstrainImagePool(this.cgK);
        this.cJI.j(this.aMp);
        return new com.baidu.tieba.card.b.a(this.cJI);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.b.a aVar) {
        if (lVar == null || aVar == null || aVar.Wp() == null) {
            return null;
        }
        lVar.ho(i + 1);
        aVar.Wp().a((com.baidu.tieba.card.a) lVar);
        aVar.Wp().a(this.bgf);
        if (lVar.threadData != null && lVar.threadData.getTid() != null) {
            cf.VN().a(new au("c11003").Z("tid", lVar.threadData.getTid()));
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.cJI != null) {
            this.cJI.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cJJ = fVar;
    }
}
