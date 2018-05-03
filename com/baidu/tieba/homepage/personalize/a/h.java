package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
/* loaded from: classes2.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<x>> implements com.baidu.tieba.a.f {
    public BdUniqueId aTr;
    private NEGFeedBackView.a aYO;
    private String bvX;
    private com.baidu.tieba.card.data.k clZ;
    private ab dAP;
    private x ddX;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aYO = null;
        this.dAP = new ab<be>() { // from class: com.baidu.tieba.homepage.personalize.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, be beVar) {
                com.baidu.tieba.card.data.k kVar = h.this.clZ;
                v.afy().cB(true);
                if (view2 != null && h.this.ddX != null && h.this.ddX.getView() != null && kVar != null && kVar.Pe() != null && !StringUtils.isNull(kVar.Pe().getTid())) {
                    if (view2.getId() != h.this.ddX.getView().getId()) {
                        if (h.this.ddX.getHeaderImg() == null || view2.getId() != h.this.ddX.getHeaderImg().getId()) {
                            if (h.this.ddX.afc() == null || view2.getId() != h.this.ddX.afc().getId()) {
                                if (h.this.ddX.bwZ != null && h.this.ddX.bwZ.apF != null && view2.getId() == h.this.ddX.bwZ.apF.getId()) {
                                    TiebaStatic.log(kVar.afU());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(kVar.afV());
                            return;
                        }
                        TiebaStatic.log(kVar.afV());
                        return;
                    }
                    TiebaStatic.log(kVar.kH("c12642"));
                }
            }
        };
        this.mPageContext = tbPageContext;
        axZ();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<x> onCreateViewHolder(ViewGroup viewGroup) {
        this.ddX = new x(this.mPageContext);
        this.ddX.currentPageType = 2;
        if (this.ddX.bwk != null) {
            this.ddX.bwk.abV = 2;
        }
        if (this.ddX.bwZ != null && this.ddX.bwZ.apG != null) {
            this.ddX.bwZ.apG.abV = 2;
        }
        if (this.ddX.cqh != null) {
            this.ddX.cqh.cqS = 2;
        }
        this.ddX.j(this.aTr);
        this.ddX.b(this.dAP);
        return new com.baidu.tieba.card.a.a<>(this.ddX);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (kVar == null || kVar.Pe() == null || aVar == null || aVar.afY() == null) {
            return null;
        }
        this.clZ = kVar;
        kVar.iN(i + 1);
        v.afy().a(kVar.kG("c12641"));
        if (kVar.YI != null && kVar.YI.size() > 0) {
            kVar.Pe().a(kVar.YI);
        }
        be beVar = new be(kVar.Pe());
        beVar.stType = "personalize_page";
        beVar.abT = 1;
        beVar.abU = 3;
        aVar.afY().a(this.aYO);
        if (aVar.afY() instanceof com.baidu.tieba.a.e) {
            aVar.afY().setPage(this.bvX);
        }
        aVar.afY().a(beVar);
        return aVar.getView();
    }

    private void axZ() {
        com.baidu.tieba.card.data.k.crK = "c10705";
        com.baidu.tieba.card.data.k.crL = "c10730";
        com.baidu.tieba.card.data.k.crM = "c10731";
        com.baidu.tieba.card.data.k.crN = "c10704";
        com.baidu.tieba.card.data.k.crO = "c10755";
        com.baidu.tieba.card.data.k.crP = "c10710";
        com.baidu.tieba.card.data.k.crQ = "c10736";
        com.baidu.tieba.card.data.k.crR = "c10737";
        com.baidu.tieba.card.data.k.crS = "c10711";
        com.baidu.tieba.card.data.k.crT = "c10758";
        com.baidu.tieba.card.data.k.crU = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.aYO = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void hY(String str) {
        this.bvX = str;
    }
}
