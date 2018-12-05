package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
/* loaded from: classes6.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<x>> implements com.baidu.tieba.a.f {
    public BdUniqueId bdE;
    private NEGFeedBackView.a bwX;
    private com.baidu.tieba.card.data.k cSs;
    private String caw;
    private x dQB;
    private ad eqD;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bwX = null;
        this.eqD = new ad<bc>() { // from class: com.baidu.tieba.homepage.personalize.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                com.baidu.tieba.card.data.k kVar = h.this.cSs;
                v.apD().dQ(true);
                if (view != null && h.this.dQB != null && h.this.dQB.getView() != null && kVar != null && kVar.ZR() != null && !StringUtils.isNull(kVar.ZR().getTid())) {
                    if (view.getId() != h.this.dQB.getView().getId()) {
                        if (h.this.dQB.getHeaderImg() == null || view.getId() != h.this.dQB.getHeaderImg().getId()) {
                            if (h.this.dQB.apf() == null || view.getId() != h.this.dQB.apf().getId()) {
                                if (h.this.dQB.cbw != null && h.this.dQB.cbw.aKh != null && view.getId() == h.this.dQB.cbw.aKh.getId()) {
                                    TiebaStatic.log(kVar.aqa());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(kVar.aqb());
                            return;
                        }
                        TiebaStatic.log(kVar.aqb());
                        return;
                    }
                    TiebaStatic.log(kVar.mP("c12642"));
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
    public com.baidu.tieba.card.a.a<x> onCreateViewHolder(ViewGroup viewGroup) {
        this.dQB = new x(this.mPageContext);
        this.dQB.currentPageType = 2;
        if (this.dQB.caJ != null) {
            this.dQB.caJ.avL = 2;
        }
        if (this.dQB.cbw != null && this.dQB.cbw.aKi != null) {
            this.dQB.cbw.aKi.avL = 2;
        }
        if (this.dQB.cWl != null) {
            this.dQB.cWl.cWY = 2;
        }
        this.dQB.j(this.bdE);
        this.dQB.b(this.eqD);
        return new com.baidu.tieba.card.a.a<>(this.dQB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (kVar == null || kVar.ZR() == null || aVar == null || aVar.aqe() == null) {
            return null;
        }
        this.cSs = kVar;
        kVar.kC(i + 1);
        v.apD().a(kVar.mO("c12641"));
        if (kVar.asc != null && kVar.asc.size() > 0) {
            kVar.ZR().a(kVar.asc);
        }
        bc bcVar = new bc(kVar.ZR());
        bcVar.stType = "personalize_page";
        bcVar.avJ = 1;
        bcVar.avK = 3;
        bcVar.avM = 1;
        aVar.aqe().a(this.bwX);
        if (aVar.aqe() instanceof com.baidu.tieba.a.e) {
            aVar.aqe().setPage(this.caw);
        }
        aVar.aqe().a(bcVar);
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
