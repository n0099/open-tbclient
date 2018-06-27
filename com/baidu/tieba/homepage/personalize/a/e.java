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
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<r>> implements com.baidu.tieba.a.f {
    public BdUniqueId aRF;
    private String bGM;
    private NEGFeedBackView.a bir;
    private ad dQw;
    private r dUs;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bir = null;
        this.dQw = new ad<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                v.aiz().cK(true);
                if (view != null && e.this.dUs != null && e.this.dUs.getView() != null && kVar != null && kVar.SV() != null && !StringUtils.isNull(kVar.SV().getTid())) {
                    if (view.getId() != e.this.dUs.getView().getId()) {
                        if (e.this.dUs.getHeaderImg() == null || view.getId() != e.this.dUs.getHeaderImg().getId()) {
                            if (e.this.dUs.aid() == null || view.getId() != e.this.dUs.aid().getId()) {
                                if (e.this.dUs.bGZ == null || e.this.dUs.bGZ.getBarNameTv() == null || view.getId() != e.this.dUs.bGZ.getBarNameTv().getId()) {
                                    if (e.this.dUs.bHN == null || e.this.dUs.bHN.ayD == null || view.getId() != e.this.dUs.bHN.ayD.getId()) {
                                        if (e.this.dUs.aic() != null && view.getId() == e.this.dUs.aic().getId()) {
                                            TiebaStatic.log(kVar.li("c12202"));
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(kVar.aiW());
                                    return;
                                }
                                TiebaStatic.log(kVar.aiW());
                                return;
                            }
                            TiebaStatic.log(kVar.lh("c12191"));
                            return;
                        }
                        TiebaStatic.log(kVar.lh("c12191"));
                        return;
                    }
                    TiebaStatic.log(kVar.lh("c12192"));
                }
            }
        };
        this.mPageContext = tbPageContext;
        aDx();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: X */
    public com.baidu.tieba.card.a.a<r> onCreateViewHolder(ViewGroup viewGroup) {
        this.dUs = new r(this.mPageContext);
        this.dUs.currentPageType = 2;
        if (this.dUs.bGZ != null) {
            this.dUs.bGZ.akz = 2;
        }
        if (this.dUs.bHN != null && this.dUs.bHN.ayE != null) {
            this.dUs.bHN.ayE.akz = 2;
        }
        this.dUs.j(this.aRF);
        return new com.baidu.tieba.card.a.a<>(this.dUs);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<r> aVar) {
        if (kVar == null || aVar == null || aVar.aja() == null) {
            return null;
        }
        kVar.iL(i + 1);
        v.aiz().a(kVar.lg("c12190"));
        if (aVar.aja() instanceof com.baidu.tieba.a.e) {
            aVar.aja().setPage(this.bGM);
        }
        aVar.aja().a(kVar);
        aVar.aja().b(this.dQw);
        aVar.aja().a(this.bir);
        return aVar.getView();
    }

    private void aDx() {
        com.baidu.tieba.card.data.k.czs = "c10705";
        com.baidu.tieba.card.data.k.czt = "c10730";
        com.baidu.tieba.card.data.k.czu = "c10731";
        com.baidu.tieba.card.data.k.czv = "c10704";
        com.baidu.tieba.card.data.k.czw = "c10755";
        com.baidu.tieba.card.data.k.czx = "c10710";
        com.baidu.tieba.card.data.k.czy = "c10736";
        com.baidu.tieba.card.data.k.czz = "c10737";
        com.baidu.tieba.card.data.k.czA = "c10711";
        com.baidu.tieba.card.data.k.czB = "c10758";
        com.baidu.tieba.card.data.k.czC = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bir = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void iD(String str) {
        this.bGM = str;
    }
}
