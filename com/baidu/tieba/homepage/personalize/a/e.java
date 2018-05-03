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
    public BdUniqueId aTr;
    private NEGFeedBackView.a aYO;
    private String bvX;
    private ab dAP;
    private r dEw;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aYO = null;
        this.dAP = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, com.baidu.tieba.card.data.k kVar) {
                v.afy().cB(true);
                if (view2 != null && e.this.dEw != null && e.this.dEw.getView() != null && kVar != null && kVar.Pe() != null && !StringUtils.isNull(kVar.Pe().getTid())) {
                    if (view2.getId() != e.this.dEw.getView().getId()) {
                        if (e.this.dEw.getHeaderImg() == null || view2.getId() != e.this.dEw.getHeaderImg().getId()) {
                            if (e.this.dEw.afc() == null || view2.getId() != e.this.dEw.afc().getId()) {
                                if (e.this.dEw.bwk == null || e.this.dEw.bwk.getBarNameTv() == null || view2.getId() != e.this.dEw.bwk.getBarNameTv().getId()) {
                                    if (e.this.dEw.bwZ == null || e.this.dEw.bwZ.apF == null || view2.getId() != e.this.dEw.bwZ.apF.getId()) {
                                        if (e.this.dEw.afb() != null && view2.getId() == e.this.dEw.afb().getId()) {
                                            TiebaStatic.log(kVar.kF("c12202"));
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
                            TiebaStatic.log(kVar.kE("c12191"));
                            return;
                        }
                        TiebaStatic.log(kVar.kE("c12191"));
                        return;
                    }
                    TiebaStatic.log(kVar.kE("c12192"));
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
    public com.baidu.tieba.card.a.a<r> onCreateViewHolder(ViewGroup viewGroup) {
        this.dEw = new r(this.mPageContext);
        this.dEw.currentPageType = 2;
        if (this.dEw.bwk != null) {
            this.dEw.bwk.abV = 2;
        }
        if (this.dEw.bwZ != null && this.dEw.bwZ.apG != null) {
            this.dEw.bwZ.apG.abV = 2;
        }
        this.dEw.j(this.aTr);
        return new com.baidu.tieba.card.a.a<>(this.dEw);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<r> aVar) {
        if (kVar == null || aVar == null || aVar.afY() == null) {
            return null;
        }
        kVar.iN(i + 1);
        v.afy().a(kVar.kD("c12190"));
        if (aVar.afY() instanceof com.baidu.tieba.a.e) {
            aVar.afY().setPage(this.bvX);
        }
        aVar.afY().a(kVar);
        aVar.afY().b(this.dAP);
        aVar.afY().a(this.aYO);
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
