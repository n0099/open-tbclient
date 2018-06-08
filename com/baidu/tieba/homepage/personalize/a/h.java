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
    public BdUniqueId aQJ;
    private String bER;
    private NEGFeedBackView.a bgZ;
    private com.baidu.tieba.card.data.k cvO;
    private ab dNe;
    private x dou;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bgZ = null;
        this.dNe = new ab<be>() { // from class: com.baidu.tieba.homepage.personalize.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, be beVar) {
                com.baidu.tieba.card.data.k kVar = h.this.cvO;
                v.ajh().cG(true);
                if (view != null && h.this.dou != null && h.this.dou.getView() != null && kVar != null && kVar.Sz() != null && !StringUtils.isNull(kVar.Sz().getTid())) {
                    if (view.getId() != h.this.dou.getView().getId()) {
                        if (h.this.dou.getHeaderImg() == null || view.getId() != h.this.dou.getHeaderImg().getId()) {
                            if (h.this.dou.aiL() == null || view.getId() != h.this.dou.aiL().getId()) {
                                if (h.this.dou.bFT != null && h.this.dou.bFT.axM != null && view.getId() == h.this.dou.bFT.axM.getId()) {
                                    TiebaStatic.log(kVar.ajC());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(kVar.ajD());
                            return;
                        }
                        TiebaStatic.log(kVar.ajD());
                        return;
                    }
                    TiebaStatic.log(kVar.ln("c12642"));
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
    public com.baidu.tieba.card.a.a<x> onCreateViewHolder(ViewGroup viewGroup) {
        this.dou = new x(this.mPageContext);
        this.dou.currentPageType = 2;
        if (this.dou.bFe != null) {
            this.dou.bFe.aka = 2;
        }
        if (this.dou.bFT != null && this.dou.bFT.axN != null) {
            this.dou.bFT.axN.aka = 2;
        }
        if (this.dou.czT != null) {
            this.dou.czT.cAF = 2;
        }
        this.dou.j(this.aQJ);
        this.dou.b(this.dNe);
        return new com.baidu.tieba.card.a.a<>(this.dou);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (kVar == null || kVar.Sz() == null || aVar == null || aVar.ajG() == null) {
            return null;
        }
        this.cvO = kVar;
        kVar.iN(i + 1);
        v.ajh().a(kVar.lm("c12641"));
        if (kVar.agK != null && kVar.agK.size() > 0) {
            kVar.Sz().a(kVar.agK);
        }
        be beVar = new be(kVar.Sz());
        beVar.stType = "personalize_page";
        beVar.ajY = 1;
        beVar.ajZ = 3;
        aVar.ajG().a(this.bgZ);
        if (aVar.ajG() instanceof com.baidu.tieba.a.e) {
            aVar.ajG().setPage(this.bER);
        }
        aVar.ajG().a(beVar);
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
