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
    public BdUniqueId aOO;
    private h.a amd;
    private x cSl;
    private com.baidu.tieba.homepage.personalize.model.e cVQ;
    private com.baidu.tieba.card.j cVU;
    private TbPageContext<?> oW;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.amd = null;
        this.cSl = new x<com.baidu.tieba.card.data.n>() { // from class: com.baidu.tieba.homepage.personalize.b.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.n nVar) {
                u.WU().cA(true);
                if (j.this.cVQ != null && nVar != null && nVar.MF() != null && !StringUtils.isNull(nVar.MF().getTid()) && j.this.cVU != null && j.this.cVU.getView() != null) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.bw(com.baidu.adp.lib.g.b.d(nVar.MF().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.bv(com.baidu.adp.lib.g.b.d(nVar.MF().getTid(), 0L));
                        j.this.cVQ.a(com.baidu.adp.lib.g.b.d(nVar.MF().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.WY(), nVar.Xa(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (view.getId() != j.this.cVU.getView().getId()) {
                        if (j.this.cVU.ble == null || j.this.cVU.ble.getBarNameTv() == null || view.getId() != j.this.cVU.ble.getBarNameTv().getId()) {
                            if (j.this.cVU.getHeaderImg() == null || view.getId() != j.this.cVU.getHeaderImg().getId()) {
                                if (j.this.cVU.WA() != null && view.getId() == j.this.cVU.WA().getId()) {
                                    TiebaStatic.log(nVar.D(nVar.bcN));
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(nVar.D(nVar.bcN));
                            return;
                        }
                        TiebaStatic.log(nVar.Xj());
                        return;
                    }
                    TiebaStatic.log(nVar.C(nVar.bcN));
                }
            }
        };
        this.oW = tbPageContext;
        api();
    }

    private void api() {
        com.baidu.tieba.card.data.n.bKz = "c10708";
        com.baidu.tieba.card.data.n.bKA = "c10735";
        com.baidu.tieba.card.data.n.bKB = "c10756";
        com.baidu.tieba.card.data.n.bKC = "c10709";
        com.baidu.tieba.card.data.n.bKD = "c10734";
        com.baidu.tieba.card.data.n.bKE = "c11929";
        com.baidu.tieba.card.data.n.bKF = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        this.cVU = new com.baidu.tieba.card.j(this.oW);
        this.cVU.j(this.aOO);
        this.cVU.b(this.cSl);
        return new d(this.cVU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.n nVar, d dVar) {
        if (nVar != null) {
            nVar.hw(i + 1);
            nVar.sourceType = 0;
        }
        dVar.Xv().setVideoStatsData(b(nVar));
        dVar.Xv().a(nVar);
        dVar.Xv().a(this.amd);
        if (nVar != null) {
            u.WU().a(nVar.Xh());
        }
        return dVar.getView();
    }

    private w b(com.baidu.tieba.card.data.n nVar) {
        w wVar = null;
        if (nVar != null) {
            wVar = new w();
            wVar.mLocate = "1";
            wVar.bDN = nVar.XV;
            if (nVar.MF() != null) {
                wVar.aAD = String.valueOf(nVar.MF().getFid());
                if (nVar.MF().sK() != null && nVar.MF().sK().channelId > 0) {
                    wVar.WL = "" + nVar.MF().sK().channelId;
                } else {
                    wVar.WL = "0";
                }
            }
            wVar.mSource = nVar.getSource();
            wVar.fCv = nVar.Xa();
            wVar.fCt = nVar.getWeight();
        }
        return wVar;
    }

    public void setEventCallback(h.a aVar) {
        this.amd = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.cVQ = eVar;
    }
}
