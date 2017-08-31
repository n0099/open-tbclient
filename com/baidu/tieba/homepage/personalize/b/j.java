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
    public BdUniqueId aOx;
    private h.a alx;
    private x cYE;
    private com.baidu.tieba.homepage.personalize.model.e dct;
    private com.baidu.tieba.card.j dcy;
    private TbPageContext<?> mF;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.alx = null;
        this.cYE = new x<com.baidu.tieba.card.data.n>() { // from class: com.baidu.tieba.homepage.personalize.b.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.n nVar) {
                u.XY().cC(true);
                if (j.this.dct != null && nVar != null && nVar.MR() != null && !StringUtils.isNull(nVar.MR().getTid()) && j.this.dcy != null && j.this.dcy.getView() != null) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.bw(com.baidu.adp.lib.g.b.c(nVar.MR().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.bv(com.baidu.adp.lib.g.b.c(nVar.MR().getTid(), 0L));
                        j.this.dct.a(com.baidu.adp.lib.g.b.c(nVar.MR().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.Yb(), nVar.Yd(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (view.getId() != j.this.dcy.getView().getId()) {
                        if (j.this.dcy.blz == null || j.this.dcy.blz.getBarNameTv() == null || view.getId() != j.this.dcy.blz.getBarNameTv().getId()) {
                            if (j.this.dcy.getHeaderImg() == null || view.getId() != j.this.dcy.getHeaderImg().getId()) {
                                if (j.this.dcy.XD() != null && view.getId() == j.this.dcy.XD().getId()) {
                                    TiebaStatic.log(nVar.H(nVar.bcJ));
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(nVar.H(nVar.bcJ));
                            return;
                        }
                        TiebaStatic.log(nVar.Ym());
                        return;
                    }
                    TiebaStatic.log(nVar.G(nVar.bcJ));
                }
            }
        };
        this.mF = tbPageContext;
        aqS();
    }

    private void aqS() {
        com.baidu.tieba.card.data.n.bNr = "c10708";
        com.baidu.tieba.card.data.n.bNs = "c10735";
        com.baidu.tieba.card.data.n.bNt = "c10756";
        com.baidu.tieba.card.data.n.bNu = "c10709";
        com.baidu.tieba.card.data.n.bNv = "c10734";
        com.baidu.tieba.card.data.n.bNw = "c11929";
        com.baidu.tieba.card.data.n.bNx = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: at */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        this.dcy = new com.baidu.tieba.card.j(this.mF);
        this.dcy.l(this.aOx);
        this.dcy.b(this.cYE);
        return new d(this.dcy);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.n nVar, d dVar) {
        if (nVar != null) {
            nVar.hH(i + 1);
            nVar.sourceType = 0;
        }
        dVar.Yy().setVideoStatsData(b(nVar));
        dVar.Yy().a(nVar);
        dVar.Yy().a(this.alx);
        if (nVar != null) {
            u.XY().a(nVar.Yk());
        }
        return dVar.getView();
    }

    private w b(com.baidu.tieba.card.data.n nVar) {
        w wVar = null;
        if (nVar != null) {
            wVar = new w();
            wVar.mLocate = "1";
            wVar.bGH = nVar.Xe;
            if (nVar.MR() != null) {
                wVar.azO = String.valueOf(nVar.MR().getFid());
                if (nVar.MR().sF() != null && nVar.MR().sF().channelId > 0) {
                    wVar.VU = "" + nVar.MR().sF().channelId;
                } else {
                    wVar.VU = "0";
                }
                if (nVar.MR().rS() != null) {
                    wVar.fAY = nVar.MR().rS().video_md5;
                }
            }
            wVar.mSource = nVar.getSource();
            wVar.fAX = nVar.Yd();
            wVar.fAV = nVar.getWeight();
        }
        return wVar;
    }

    public void setEventCallback(h.a aVar) {
        this.alx = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dct = eVar;
    }
}
