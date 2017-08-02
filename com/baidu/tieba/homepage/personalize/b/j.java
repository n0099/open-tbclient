package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
import com.baidu.tieba.play.w;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.n, d<com.baidu.tieba.card.j>> {
    public BdUniqueId aNy;
    private h.a akI;
    private TbPageContext<?> ako;
    private x cOT;
    private com.baidu.tieba.card.j cSC;
    private com.baidu.tieba.homepage.personalize.model.e cSy;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akI = null;
        this.cOT = new x<com.baidu.tieba.card.data.n>() { // from class: com.baidu.tieba.homepage.personalize.b.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.n nVar) {
                u.Ww().cA(true);
                if (j.this.cSy != null && nVar != null && nVar.MA() != null && !StringUtils.isNull(nVar.MA().getTid()) && j.this.cSC != null && j.this.cSC.getView() != null) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.bw(com.baidu.adp.lib.g.b.c(nVar.MA().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.bv(com.baidu.adp.lib.g.b.c(nVar.MA().getTid(), 0L));
                        j.this.cSy.a(com.baidu.adp.lib.g.b.c(nVar.MA().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.WA(), nVar.WC(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (view.getId() != j.this.cSC.getView().getId()) {
                        if (j.this.cSC.bjP == null || j.this.cSC.bjP.getBarNameTv() == null || view.getId() != j.this.cSC.bjP.getBarNameTv().getId()) {
                            if (j.this.cSC.getHeaderImg() == null || view.getId() != j.this.cSC.getHeaderImg().getId()) {
                                if (j.this.cSC.Wc() != null && view.getId() == j.this.cSC.Wc().getId()) {
                                    TiebaStatic.log(nVar.D(nVar.bbB));
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(nVar.D(nVar.bbB));
                            return;
                        }
                        TiebaStatic.log(nVar.WL());
                        return;
                    }
                    TiebaStatic.log(nVar.C(nVar.bbB));
                }
            }
        };
        this.ako = tbPageContext;
        aov();
    }

    private void aov() {
        com.baidu.tieba.card.data.n.bIF = "c10708";
        com.baidu.tieba.card.data.n.bIG = "c10735";
        com.baidu.tieba.card.data.n.bIH = "c10756";
        com.baidu.tieba.card.data.n.bII = "c10709";
        com.baidu.tieba.card.data.n.bIJ = "c10734";
        com.baidu.tieba.card.data.n.bIK = "c11929";
        com.baidu.tieba.card.data.n.bIL = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: an */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        this.cSC = new com.baidu.tieba.card.j(this.ako);
        this.cSC.j(this.aNy);
        this.cSC.a(this.cOT);
        return new d(this.cSC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.n nVar, d dVar) {
        if (nVar != null) {
            nVar.hu(i + 1);
            nVar.sourceType = 0;
        }
        dVar.WX().setVideoStatsData(b(nVar));
        dVar.WX().a(nVar);
        dVar.WX().a(this.akI);
        if (nVar != null) {
            u.Ww().a(nVar.WJ());
        }
        return dVar.getView();
    }

    private w b(com.baidu.tieba.card.data.n nVar) {
        w wVar = null;
        if (nVar != null) {
            wVar = new w();
            wVar.mLocate = "1";
            wVar.bBT = nVar.Ww;
            if (nVar.MA() != null) {
                wVar.azk = String.valueOf(nVar.MA().getFid());
                if (nVar.MA().sz() != null && nVar.MA().sz().channelId > 0) {
                    wVar.Vm = "" + nVar.MA().sz().channelId;
                } else {
                    wVar.Vm = "0";
                }
            }
            wVar.mSource = nVar.getSource();
            wVar.fzo = nVar.WC();
            wVar.fzm = nVar.getWeight();
        }
        return wVar;
    }

    public void setEventCallback(h.a aVar) {
        this.akI = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.cSy = eVar;
    }
}
