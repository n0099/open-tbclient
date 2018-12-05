package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.r;
import com.baidu.tieba.card.v;
/* loaded from: classes6.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<r>> implements com.baidu.tieba.a.f {
    public BdUniqueId bdE;
    private NEGFeedBackView.a bwX;
    private String caw;
    private ad eqD;
    private r evJ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bwX = null;
        this.eqD = new ad<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                v.apD().dQ(true);
                if (view != null && e.this.evJ != null && e.this.evJ.getView() != null && kVar != null && kVar.ZR() != null && !StringUtils.isNull(kVar.ZR().getTid())) {
                    if (view.getId() != e.this.evJ.getView().getId()) {
                        if (e.this.evJ.getHeaderImg() == null || view.getId() != e.this.evJ.getHeaderImg().getId()) {
                            if (e.this.evJ.apf() == null || view.getId() != e.this.evJ.apf().getId()) {
                                if (e.this.evJ.caJ == null || e.this.evJ.caJ.getBarNameTv() == null || view.getId() != e.this.evJ.caJ.getBarNameTv().getId()) {
                                    if (e.this.evJ.cbw == null || e.this.evJ.cbw.aKh == null || view.getId() != e.this.evJ.cbw.aKh.getId()) {
                                        if (e.this.evJ.ape() != null && view.getId() == e.this.evJ.ape().getId()) {
                                            TiebaStatic.log(kVar.mN("c12202"));
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(kVar.aqa());
                                    return;
                                }
                                TiebaStatic.log(kVar.aqa());
                                return;
                            }
                            TiebaStatic.log(kVar.mM("c12191"));
                            return;
                        }
                        TiebaStatic.log(kVar.mM("c12191"));
                        return;
                    }
                    TiebaStatic.log(kVar.mM("c12192"));
                }
            }
        };
        this.mPageContext = tbPageContext;
        aLr();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<r> onCreateViewHolder(ViewGroup viewGroup) {
        this.evJ = new r(this.mPageContext);
        this.evJ.currentPageType = 2;
        if (this.evJ.caJ != null) {
            this.evJ.caJ.avL = 2;
        }
        if (this.evJ.cbw != null && this.evJ.cbw.aKi != null) {
            this.evJ.cbw.aKi.avL = 2;
        }
        this.evJ.j(this.bdE);
        return new com.baidu.tieba.card.a.a<>(this.evJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<r> aVar) {
        if (kVar == null || aVar == null || aVar.aqe() == null) {
            return null;
        }
        kVar.kC(i + 1);
        v.apD().a(kVar.mL("c12190"));
        if (aVar.aqe() instanceof com.baidu.tieba.a.e) {
            aVar.aqe().setPage(this.caw);
        }
        aVar.aqe().a(kVar);
        aVar.aqe().b(this.eqD);
        aVar.aqe().a(this.bwX);
        return aVar.getView();
    }

    private void aLr() {
        com.baidu.tieba.card.data.k.cXS = "c10705";
        com.baidu.tieba.card.data.k.cXT = "c10730";
        com.baidu.tieba.card.data.k.cXU = "c10731";
        com.baidu.tieba.card.data.k.cXV = "c10704";
        com.baidu.tieba.card.data.k.cXW = "c10755";
        com.baidu.tieba.card.data.k.cXX = "c10710";
        com.baidu.tieba.card.data.k.cXY = "c10736";
        com.baidu.tieba.card.data.k.cXZ = "c10737";
        com.baidu.tieba.card.data.k.cYa = "c10711";
        com.baidu.tieba.card.data.k.cYb = "c10758";
        com.baidu.tieba.card.data.k.cYc = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bwX = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void jK(String str) {
        this.caw = str;
    }
}
