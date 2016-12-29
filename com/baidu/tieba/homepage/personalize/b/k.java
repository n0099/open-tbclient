package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.aq;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.card.cb;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, com.baidu.tieba.card.a.a<aq>> {
    private TbPageContext<?> GO;
    private o.a afo;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bFm;
    private com.baidu.adp.lib.f.b<TbImageView> bFn;
    public BdUniqueId bbl;
    private aq cqW;
    private com.baidu.tieba.homepage.personalize.c.f cqX;
    private cb cqY;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afo = null;
        this.bFm = new com.baidu.adp.lib.f.b<>(new l(this), 6, 0);
        this.bFn = new com.baidu.adp.lib.f.b<>(new m(this), 12, 0);
        this.cqY = new n(this);
        this.GO = tbPageContext;
        ajn();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: i */
    public com.baidu.tieba.card.a.a<aq> a(ViewGroup viewGroup) {
        this.cqW = new aq(this.GO);
        this.cqW.setSingleImageRatio(0.75d);
        this.cqW.setConstrainLayoutPool(this.bFm);
        this.cqW.setConstrainImagePool(this.bFn);
        this.cqW.j(this.bbl);
        return new com.baidu.tieba.card.a.a<>(this.cqW);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.m mVar, com.baidu.tieba.card.a.a<aq> aVar) {
        if (mVar != null) {
            mVar.gj(i + 1);
        }
        bz.OH().a(mVar.OZ());
        aVar.Po().onBindDataToView(mVar);
        aVar.Po().setOnSubCardOnClickListenner(this.cqY);
        aVar.Po().a(this.afo);
        return aVar.getView();
    }

    private void ajn() {
        com.baidu.tieba.card.data.m.bem = "c10705";
        com.baidu.tieba.card.data.m.ben = "c10730";
        com.baidu.tieba.card.data.m.beo = "c10731";
        com.baidu.tieba.card.data.m.bep = "c10704";
        com.baidu.tieba.card.data.m.beq = "c10755";
        com.baidu.tieba.card.data.m.ber = "c10710";
        com.baidu.tieba.card.data.m.bes = "c10736";
        com.baidu.tieba.card.data.m.beu = "c10737";
        com.baidu.tieba.card.data.m.bev = "c10711";
        com.baidu.tieba.card.data.m.bew = "c10758";
        com.baidu.tieba.card.data.m.bex = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.cqW != null) {
            this.cqW.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.c.f fVar) {
        this.cqX = fVar;
    }

    public void setEventCallback(o.a aVar) {
        this.afo = aVar;
    }
}
