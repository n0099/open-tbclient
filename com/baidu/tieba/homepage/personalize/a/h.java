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
    private String bWE;
    public BdUniqueId bag;
    private NEGFeedBackView.a btz;
    private com.baidu.tieba.card.data.k cLL;
    private x dJY;
    private ad ejJ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.btz = null;
        this.ejJ = new ad<bc>() { // from class: com.baidu.tieba.homepage.personalize.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                com.baidu.tieba.card.data.k kVar = h.this.cLL;
                v.anQ().dP(true);
                if (view != null && h.this.dJY != null && h.this.dJY.getView() != null && kVar != null && kVar.YL() != null && !StringUtils.isNull(kVar.YL().getTid())) {
                    if (view.getId() != h.this.dJY.getView().getId()) {
                        if (h.this.dJY.getHeaderImg() == null || view.getId() != h.this.dJY.getHeaderImg().getId()) {
                            if (h.this.dJY.ant() == null || view.getId() != h.this.dJY.ant().getId()) {
                                if (h.this.dJY.bXE != null && h.this.dJY.bXE.aGH != null && view.getId() == h.this.dJY.bXE.aGH.getId()) {
                                    TiebaStatic.log(kVar.aon());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(kVar.aoo());
                            return;
                        }
                        TiebaStatic.log(kVar.aoo());
                        return;
                    }
                    TiebaStatic.log(kVar.mq("c12642"));
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
    public com.baidu.tieba.card.a.a<x> onCreateViewHolder(ViewGroup viewGroup) {
        this.dJY = new x(this.mPageContext);
        this.dJY.currentPageType = 2;
        if (this.dJY.bWR != null) {
            this.dJY.bWR.asl = 2;
        }
        if (this.dJY.bXE != null && this.dJY.bXE.aGI != null) {
            this.dJY.bXE.aGI.asl = 2;
        }
        if (this.dJY.cPE != null) {
            this.dJY.cPE.cQr = 2;
        }
        this.dJY.j(this.bag);
        this.dJY.b(this.ejJ);
        return new com.baidu.tieba.card.a.a<>(this.dJY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (kVar == null || kVar.YL() == null || aVar == null || aVar.aor() == null) {
            return null;
        }
        this.cLL = kVar;
        kVar.km(i + 1);
        v.anQ().a(kVar.mp("c12641"));
        if (kVar.aoB != null && kVar.aoB.size() > 0) {
            kVar.YL().a(kVar.aoB);
        }
        bc bcVar = new bc(kVar.YL());
        bcVar.stType = "personalize_page";
        bcVar.asj = 1;
        bcVar.ask = 3;
        bcVar.asm = 1;
        aVar.aor().a(this.btz);
        if (aVar.aor() instanceof com.baidu.tieba.a.e) {
            aVar.aor().setPage(this.bWE);
        }
        aVar.aor().a(bcVar);
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
