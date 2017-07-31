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
    public BdUniqueId aOM;
    private TbPageContext<?> alI;
    private h.a amc;
    private x cQm;
    private com.baidu.tieba.homepage.personalize.model.e cTR;
    private com.baidu.tieba.card.j cTV;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.amc = null;
        this.cQm = new x<com.baidu.tieba.card.data.n>() { // from class: com.baidu.tieba.homepage.personalize.b.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.n nVar) {
                u.WB().cA(true);
                if (j.this.cTR != null && nVar != null && nVar.MF() != null && !StringUtils.isNull(nVar.MF().getTid()) && j.this.cTV != null && j.this.cTV.getView() != null) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.bw(com.baidu.adp.lib.g.b.d(nVar.MF().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.bv(com.baidu.adp.lib.g.b.d(nVar.MF().getTid(), 0L));
                        j.this.cTR.a(com.baidu.adp.lib.g.b.d(nVar.MF().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.WF(), nVar.WH(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (view.getId() != j.this.cTV.getView().getId()) {
                        if (j.this.cTV.bkZ == null || j.this.cTV.bkZ.getBarNameTv() == null || view.getId() != j.this.cTV.bkZ.getBarNameTv().getId()) {
                            if (j.this.cTV.getHeaderImg() == null || view.getId() != j.this.cTV.getHeaderImg().getId()) {
                                if (j.this.cTV.Wh() != null && view.getId() == j.this.cTV.Wh().getId()) {
                                    TiebaStatic.log(nVar.D(nVar.bcL));
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(nVar.D(nVar.bcL));
                            return;
                        }
                        TiebaStatic.log(nVar.WQ());
                        return;
                    }
                    TiebaStatic.log(nVar.C(nVar.bcL));
                }
            }
        };
        this.alI = tbPageContext;
        aoH();
    }

    private void aoH() {
        com.baidu.tieba.card.data.n.bJP = "c10708";
        com.baidu.tieba.card.data.n.bJQ = "c10735";
        com.baidu.tieba.card.data.n.bJR = "c10756";
        com.baidu.tieba.card.data.n.bJS = "c10709";
        com.baidu.tieba.card.data.n.bJT = "c10734";
        com.baidu.tieba.card.data.n.bJU = "c11929";
        com.baidu.tieba.card.data.n.bJV = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: an */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        this.cTV = new com.baidu.tieba.card.j(this.alI);
        this.cTV.j(this.aOM);
        this.cTV.a(this.cQm);
        return new d(this.cTV);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.n nVar, d dVar) {
        if (nVar != null) {
            nVar.hv(i + 1);
            nVar.sourceType = 0;
        }
        dVar.Xc().setVideoStatsData(b(nVar));
        dVar.Xc().a(nVar);
        dVar.Xc().a(this.amc);
        if (nVar != null) {
            u.WB().a(nVar.WO());
        }
        return dVar.getView();
    }

    private w b(com.baidu.tieba.card.data.n nVar) {
        w wVar = null;
        if (nVar != null) {
            wVar = new w();
            wVar.mLocate = "1";
            wVar.bDd = nVar.XS;
            if (nVar.MF() != null) {
                wVar.aAB = String.valueOf(nVar.MF().getFid());
                if (nVar.MF().sJ() != null && nVar.MF().sJ().channelId > 0) {
                    wVar.WI = "" + nVar.MF().sJ().channelId;
                } else {
                    wVar.WI = "0";
                }
            }
            wVar.mSource = nVar.getSource();
            wVar.fAA = nVar.WH();
            wVar.fAy = nVar.getWeight();
        }
        return wVar;
    }

    public void setEventCallback(h.a aVar) {
        this.amc = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.cTR = eVar;
    }
}
