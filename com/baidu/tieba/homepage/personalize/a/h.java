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
    public BdUniqueId aZt;
    private String bVS;
    private NEGFeedBackView.a bsM;
    private com.baidu.tieba.card.data.k cKF;
    private x dIU;
    private ad eip;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bsM = null;
        this.eip = new ad<bc>() { // from class: com.baidu.tieba.homepage.personalize.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                com.baidu.tieba.card.data.k kVar = h.this.cKF;
                v.aop().dy(true);
                if (view != null && h.this.dIU != null && h.this.dIU.getView() != null && kVar != null && kVar.YB() != null && !StringUtils.isNull(kVar.YB().getTid())) {
                    if (view.getId() != h.this.dIU.getView().getId()) {
                        if (h.this.dIU.getHeaderImg() == null || view.getId() != h.this.dIU.getHeaderImg().getId()) {
                            if (h.this.dIU.anS() == null || view.getId() != h.this.dIU.anS().getId()) {
                                if (h.this.dIU.bWS != null && h.this.dIU.bWS.aFR != null && view.getId() == h.this.dIU.bWS.aFR.getId()) {
                                    TiebaStatic.log(kVar.aoM());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(kVar.aoN());
                            return;
                        }
                        TiebaStatic.log(kVar.aoN());
                        return;
                    }
                    TiebaStatic.log(kVar.mp("c12642"));
                }
            }
        };
        this.mPageContext = tbPageContext;
        aKb();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a<x> onCreateViewHolder(ViewGroup viewGroup) {
        this.dIU = new x(this.mPageContext);
        this.dIU.currentPageType = 2;
        if (this.dIU.bWf != null) {
            this.dIU.bWf.ary = 2;
        }
        if (this.dIU.bWS != null && this.dIU.bWS.aFS != null) {
            this.dIU.bWS.aFS.ary = 2;
        }
        if (this.dIU.cOy != null) {
            this.dIU.cOy.cPl = 2;
        }
        this.dIU.j(this.aZt);
        this.dIU.b(this.eip);
        return new com.baidu.tieba.card.a.a<>(this.dIU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (kVar == null || kVar.YB() == null || aVar == null || aVar.aoQ() == null) {
            return null;
        }
        this.cKF = kVar;
        kVar.jT(i + 1);
        v.aop().a(kVar.mo("c12641"));
        if (kVar.anO != null && kVar.anO.size() > 0) {
            kVar.YB().a(kVar.anO);
        }
        bc bcVar = new bc(kVar.YB());
        bcVar.stType = "personalize_page";
        bcVar.arw = 1;
        bcVar.arx = 3;
        bcVar.arz = 1;
        aVar.aoQ().a(this.bsM);
        if (aVar.aoQ() instanceof com.baidu.tieba.a.e) {
            aVar.aoQ().setPage(this.bVS);
        }
        aVar.aoQ().a(bcVar);
        return aVar.getView();
    }

    private void aKb() {
        com.baidu.tieba.card.data.k.cQf = "c10705";
        com.baidu.tieba.card.data.k.cQg = "c10730";
        com.baidu.tieba.card.data.k.cQh = "c10731";
        com.baidu.tieba.card.data.k.cQi = "c10704";
        com.baidu.tieba.card.data.k.cQj = "c10755";
        com.baidu.tieba.card.data.k.cQk = "c10710";
        com.baidu.tieba.card.data.k.cQl = "c10736";
        com.baidu.tieba.card.data.k.cQm = "c10737";
        com.baidu.tieba.card.data.k.cQn = "c10711";
        com.baidu.tieba.card.data.k.cQo = "c10758";
        com.baidu.tieba.card.data.k.cQp = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bsM = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void jq(String str) {
        this.bVS = str;
    }
}
