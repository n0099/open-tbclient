package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.r;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<r>> implements com.baidu.tieba.a.f {
    public BdUniqueId aTs;
    private NEGFeedBackView.a aYP;
    private String bwO;
    private ab dBW;
    private r dFC;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aYP = null;
        this.dBW = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, com.baidu.tieba.card.data.k kVar) {
                v.afy().cB(true);
                if (view2 != null && e.this.dFC != null && e.this.dFC.getView() != null && kVar != null && kVar.Pb() != null && !StringUtils.isNull(kVar.Pb().getTid())) {
                    if (view2.getId() != e.this.dFC.getView().getId()) {
                        if (e.this.dFC.getHeaderImg() == null || view2.getId() != e.this.dFC.getHeaderImg().getId()) {
                            if (e.this.dFC.afc() == null || view2.getId() != e.this.dFC.afc().getId()) {
                                if (e.this.dFC.bxb == null || e.this.dFC.bxb.getBarNameTv() == null || view2.getId() != e.this.dFC.bxb.getBarNameTv().getId()) {
                                    if (e.this.dFC.bxQ == null || e.this.dFC.bxQ.apF == null || view2.getId() != e.this.dFC.bxQ.apF.getId()) {
                                        if (e.this.dFC.afb() != null && view2.getId() == e.this.dFC.afb().getId()) {
                                            TiebaStatic.log(kVar.kI("c12202"));
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(kVar.afU());
                                    return;
                                }
                                TiebaStatic.log(kVar.afU());
                                return;
                            }
                            TiebaStatic.log(kVar.kH("c12191"));
                            return;
                        }
                        TiebaStatic.log(kVar.kH("c12191"));
                        return;
                    }
                    TiebaStatic.log(kVar.kH("c12192"));
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
    public com.baidu.tieba.card.a.a<r> onCreateViewHolder(ViewGroup viewGroup) {
        this.dFC = new r(this.mPageContext);
        this.dFC.currentPageType = 2;
        if (this.dFC.bxb != null) {
            this.dFC.bxb.abW = 2;
        }
        if (this.dFC.bxQ != null && this.dFC.bxQ.apG != null) {
            this.dFC.bxQ.apG.abW = 2;
        }
        this.dFC.j(this.aTs);
        return new com.baidu.tieba.card.a.a<>(this.dFC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<r> aVar) {
        if (kVar == null || aVar == null || aVar.afY() == null) {
            return null;
        }
        kVar.iM(i + 1);
        v.afy().a(kVar.kG("c12190"));
        if (aVar.afY() instanceof com.baidu.tieba.a.e) {
            aVar.afY().setPage(this.bwO);
        }
        aVar.afY().a(kVar);
        aVar.afY().b(this.dBW);
        aVar.afY().a(this.aYP);
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
