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
    public BdUniqueId aQJ;
    private String bER;
    private NEGFeedBackView.a bgZ;
    private ab dNe;
    private r dQR;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bgZ = null;
        this.dNe = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                v.ajh().cG(true);
                if (view != null && e.this.dQR != null && e.this.dQR.getView() != null && kVar != null && kVar.Sz() != null && !StringUtils.isNull(kVar.Sz().getTid())) {
                    if (view.getId() != e.this.dQR.getView().getId()) {
                        if (e.this.dQR.getHeaderImg() == null || view.getId() != e.this.dQR.getHeaderImg().getId()) {
                            if (e.this.dQR.aiL() == null || view.getId() != e.this.dQR.aiL().getId()) {
                                if (e.this.dQR.bFe == null || e.this.dQR.bFe.getBarNameTv() == null || view.getId() != e.this.dQR.bFe.getBarNameTv().getId()) {
                                    if (e.this.dQR.bFT == null || e.this.dQR.bFT.axM == null || view.getId() != e.this.dQR.bFT.axM.getId()) {
                                        if (e.this.dQR.aiK() != null && view.getId() == e.this.dQR.aiK().getId()) {
                                            TiebaStatic.log(kVar.ll("c12202"));
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(kVar.ajC());
                                    return;
                                }
                                TiebaStatic.log(kVar.ajC());
                                return;
                            }
                            TiebaStatic.log(kVar.lk("c12191"));
                            return;
                        }
                        TiebaStatic.log(kVar.lk("c12191"));
                        return;
                    }
                    TiebaStatic.log(kVar.lk("c12192"));
                }
            }
        };
        this.mPageContext = tbPageContext;
        aCS();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<r> onCreateViewHolder(ViewGroup viewGroup) {
        this.dQR = new r(this.mPageContext);
        this.dQR.currentPageType = 2;
        if (this.dQR.bFe != null) {
            this.dQR.bFe.aka = 2;
        }
        if (this.dQR.bFT != null && this.dQR.bFT.axN != null) {
            this.dQR.bFT.axN.aka = 2;
        }
        this.dQR.j(this.aQJ);
        return new com.baidu.tieba.card.a.a<>(this.dQR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<r> aVar) {
        if (kVar == null || aVar == null || aVar.ajG() == null) {
            return null;
        }
        kVar.iN(i + 1);
        v.ajh().a(kVar.lj("c12190"));
        if (aVar.ajG() instanceof com.baidu.tieba.a.e) {
            aVar.ajG().setPage(this.bER);
        }
        aVar.ajG().a(kVar);
        aVar.ajG().b(this.dNe);
        aVar.ajG().a(this.bgZ);
        return aVar.getView();
    }

    private void aCS() {
        com.baidu.tieba.card.data.k.cBy = "c10705";
        com.baidu.tieba.card.data.k.cBz = "c10730";
        com.baidu.tieba.card.data.k.cBA = "c10731";
        com.baidu.tieba.card.data.k.cBB = "c10704";
        com.baidu.tieba.card.data.k.cBC = "c10755";
        com.baidu.tieba.card.data.k.cBD = "c10710";
        com.baidu.tieba.card.data.k.cBE = "c10736";
        com.baidu.tieba.card.data.k.cBF = "c10737";
        com.baidu.tieba.card.data.k.cBG = "c10711";
        com.baidu.tieba.card.data.k.cBH = "c10758";
        com.baidu.tieba.card.data.k.cBI = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bgZ = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void iy(String str) {
        this.bER = str;
    }
}
