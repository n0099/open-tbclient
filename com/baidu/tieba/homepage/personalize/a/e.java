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
    private String bWE;
    public BdUniqueId bag;
    private NEGFeedBackView.a btz;
    private ad ejJ;
    private r eoP;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.btz = null;
        this.ejJ = new ad<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                v.anQ().dP(true);
                if (view != null && e.this.eoP != null && e.this.eoP.getView() != null && kVar != null && kVar.YL() != null && !StringUtils.isNull(kVar.YL().getTid())) {
                    if (view.getId() != e.this.eoP.getView().getId()) {
                        if (e.this.eoP.getHeaderImg() == null || view.getId() != e.this.eoP.getHeaderImg().getId()) {
                            if (e.this.eoP.ant() == null || view.getId() != e.this.eoP.ant().getId()) {
                                if (e.this.eoP.bWR == null || e.this.eoP.bWR.getBarNameTv() == null || view.getId() != e.this.eoP.bWR.getBarNameTv().getId()) {
                                    if (e.this.eoP.bXE == null || e.this.eoP.bXE.aGH == null || view.getId() != e.this.eoP.bXE.aGH.getId()) {
                                        if (e.this.eoP.ans() != null && view.getId() == e.this.eoP.ans().getId()) {
                                            TiebaStatic.log(kVar.mo("c12202"));
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(kVar.aon());
                                    return;
                                }
                                TiebaStatic.log(kVar.aon());
                                return;
                            }
                            TiebaStatic.log(kVar.mn("c12191"));
                            return;
                        }
                        TiebaStatic.log(kVar.mn("c12191"));
                        return;
                    }
                    TiebaStatic.log(kVar.mn("c12192"));
                }
            }
        };
        this.mPageContext = tbPageContext;
        aJz();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<r> onCreateViewHolder(ViewGroup viewGroup) {
        this.eoP = new r(this.mPageContext);
        this.eoP.currentPageType = 2;
        if (this.eoP.bWR != null) {
            this.eoP.bWR.asl = 2;
        }
        if (this.eoP.bXE != null && this.eoP.bXE.aGI != null) {
            this.eoP.bXE.aGI.asl = 2;
        }
        this.eoP.j(this.bag);
        return new com.baidu.tieba.card.a.a<>(this.eoP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<r> aVar) {
        if (kVar == null || aVar == null || aVar.aor() == null) {
            return null;
        }
        kVar.km(i + 1);
        v.anQ().a(kVar.mm("c12190"));
        if (aVar.aor() instanceof com.baidu.tieba.a.e) {
            aVar.aor().setPage(this.bWE);
        }
        aVar.aor().a(kVar);
        aVar.aor().b(this.ejJ);
        aVar.aor().a(this.btz);
        return aVar.getView();
    }

    private void aJz() {
        com.baidu.tieba.card.data.k.cRl = "c10705";
        com.baidu.tieba.card.data.k.cRm = "c10730";
        com.baidu.tieba.card.data.k.cRn = "c10731";
        com.baidu.tieba.card.data.k.cRo = "c10704";
        com.baidu.tieba.card.data.k.cRp = "c10755";
        com.baidu.tieba.card.data.k.cRq = "c10710";
        com.baidu.tieba.card.data.k.cRr = "c10736";
        com.baidu.tieba.card.data.k.cRs = "c10737";
        com.baidu.tieba.card.data.k.cRt = "c10711";
        com.baidu.tieba.card.data.k.cRu = "c10758";
        com.baidu.tieba.card.data.k.cRv = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.btz = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void js(String str) {
        this.bWE = str;
    }
}
