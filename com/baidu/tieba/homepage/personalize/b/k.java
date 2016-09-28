package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ao;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.card.cd;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, a> {
    private TbPageContext<?> GM;
    public BdUniqueId aYW;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bUl;
    private com.baidu.adp.lib.f.b<TbImageView> bUm;
    private ao cGx;
    private com.baidu.tieba.homepage.personalize.c.f cGy;
    private cd cGz;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bUl = new com.baidu.adp.lib.f.b<>(new l(this), 6, 0);
        this.bUm = new com.baidu.adp.lib.f.b<>(new m(this), 12, 0);
        this.cGz = new n(this);
        this.GM = tbPageContext;
        amS();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ai */
    public a a(ViewGroup viewGroup) {
        this.cGx = new ao(this.GM);
        this.cGx.setConstrainLayoutPool(this.bUl);
        this.cGx.setConstrainImagePool(this.bUm);
        this.cGx.j(this.aYW);
        return new a(this.cGx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.m mVar, a aVar) {
        if (mVar != null) {
            mVar.gj(i + 1);
        }
        cb.Oj().a(mVar.OA());
        aVar.cGB.onBindDataToView(mVar);
        aVar.cGB.setOnSubCardOnClickListenner(this.cGz);
        return aVar.getView();
    }

    private void amS() {
        com.baidu.tieba.card.data.m.bbZ = "c10705";
        com.baidu.tieba.card.data.m.bca = "c10730";
        com.baidu.tieba.card.data.m.bcb = "c10731";
        com.baidu.tieba.card.data.m.bcc = "c10704";
        com.baidu.tieba.card.data.m.bcd = "c10755";
        com.baidu.tieba.card.data.m.bce = "c10710";
        com.baidu.tieba.card.data.m.bcf = "c10736";
        com.baidu.tieba.card.data.m.bcg = "c10737";
        com.baidu.tieba.card.data.m.bch = "c10711";
        com.baidu.tieba.card.data.m.bci = "c10758";
        com.baidu.tieba.card.data.m.bcj = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.cGx != null) {
            this.cGx.setFromCDN(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public ao cGB;

        public a(ao aoVar) {
            super(aoVar.getView());
            this.cGB = aoVar;
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.c.f fVar) {
        this.cGy = fVar;
    }
}
