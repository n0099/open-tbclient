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
    public BdUniqueId aTs;
    private NEGFeedBackView.a aYP;
    private String bwO;
    private com.baidu.tieba.card.data.k cnj;
    private ab dBW;
    private x dff;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aYP = null;
        this.dBW = new ab<be>() { // from class: com.baidu.tieba.homepage.personalize.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, be beVar) {
                com.baidu.tieba.card.data.k kVar = h.this.cnj;
                v.afy().cB(true);
                if (view2 != null && h.this.dff != null && h.this.dff.getView() != null && kVar != null && kVar.Pb() != null && !StringUtils.isNull(kVar.Pb().getTid())) {
                    if (view2.getId() != h.this.dff.getView().getId()) {
                        if (h.this.dff.getHeaderImg() == null || view2.getId() != h.this.dff.getHeaderImg().getId()) {
                            if (h.this.dff.afc() == null || view2.getId() != h.this.dff.afc().getId()) {
                                if (h.this.dff.bxQ != null && h.this.dff.bxQ.apF != null && view2.getId() == h.this.dff.bxQ.apF.getId()) {
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
                    TiebaStatic.log(kVar.kK("c12642"));
                }
            }
        };
        this.mPageContext = tbPageContext;
        axX();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<x> onCreateViewHolder(ViewGroup viewGroup) {
        this.dff = new x(this.mPageContext);
        this.dff.currentPageType = 2;
        if (this.dff.bxb != null) {
            this.dff.bxb.abW = 2;
        }
        if (this.dff.bxQ != null && this.dff.bxQ.apG != null) {
            this.dff.bxQ.apG.abW = 2;
        }
        if (this.dff.crr != null) {
            this.dff.crr.csc = 2;
        }
        this.dff.j(this.aTs);
        this.dff.b(this.dBW);
        return new com.baidu.tieba.card.a.a<>(this.dff);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (kVar == null || kVar.Pb() == null || aVar == null || aVar.afY() == null) {
            return null;
        }
        this.cnj = kVar;
        kVar.iM(i + 1);
        v.afy().a(kVar.kJ("c12641"));
        if (kVar.YI != null && kVar.YI.size() > 0) {
            kVar.Pb().a(kVar.YI);
        }
        be beVar = new be(kVar.Pb());
        beVar.stType = "personalize_page";
        beVar.abU = 1;
        beVar.abV = 3;
        aVar.afY().a(this.aYP);
        if (aVar.afY() instanceof com.baidu.tieba.a.e) {
            aVar.afY().setPage(this.bwO);
        }
        aVar.afY().a(beVar);
        return aVar.getView();
    }

    private void axX() {
        com.baidu.tieba.card.data.k.csT = "c10705";
        com.baidu.tieba.card.data.k.csU = "c10730";
        com.baidu.tieba.card.data.k.csV = "c10731";
        com.baidu.tieba.card.data.k.csW = "c10704";
        com.baidu.tieba.card.data.k.csX = "c10755";
        com.baidu.tieba.card.data.k.csY = "c10710";
        com.baidu.tieba.card.data.k.csZ = "c10736";
        com.baidu.tieba.card.data.k.cta = "c10737";
        com.baidu.tieba.card.data.k.ctb = "c10711";
        com.baidu.tieba.card.data.k.ctc = "c10758";
        com.baidu.tieba.card.data.k.ctd = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.aYP = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void hZ(String str) {
        this.bwO = str;
    }
}
