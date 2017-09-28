package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.n, d<com.baidu.tieba.card.j>> {
    public BdUniqueId aPx;
    private c.a aVH;
    private x cVT;
    private com.baidu.tieba.homepage.personalize.model.e cZC;
    private com.baidu.tieba.card.j cZG;
    private TbPageContext<?> mG;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aVH = null;
        this.cVT = new x<com.baidu.tieba.card.data.n>() { // from class: com.baidu.tieba.homepage.personalize.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.n nVar) {
                u.XR().cB(true);
                if (j.this.cZC != null && nVar != null && nVar.Nj() != null && !StringUtils.isNull(nVar.Nj().getTid()) && j.this.cZG != null && j.this.cZG.getView() != null) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.bt(com.baidu.adp.lib.g.b.c(nVar.Nj().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.bs(com.baidu.adp.lib.g.b.c(nVar.Nj().getTid(), 0L));
                        j.this.cZC.a(com.baidu.adp.lib.g.b.c(nVar.Nj().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.XU(), nVar.XW(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (view.getId() != j.this.cZG.getView().getId()) {
                        if (j.this.cZG.bnj == null || j.this.cZG.bnj.getBarNameTv() == null || view.getId() != j.this.cZG.bnj.getBarNameTv().getId()) {
                            if (j.this.cZG.getHeaderImg() == null || view.getId() != j.this.cZG.getHeaderImg().getId()) {
                                if (j.this.cZG.Xu() != null && view.getId() == j.this.cZG.Xu().getId()) {
                                    TiebaStatic.log(nVar.C(nVar.bes));
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(nVar.C(nVar.bes));
                            return;
                        }
                        TiebaStatic.log(nVar.Yf());
                        return;
                    }
                    TiebaStatic.log(nVar.B(nVar.bes));
                }
            }
        };
        this.mG = tbPageContext;
        apJ();
    }

    private void apJ() {
        com.baidu.tieba.card.data.n.bNN = "c10708";
        com.baidu.tieba.card.data.n.bNO = "c10735";
        com.baidu.tieba.card.data.n.bNP = "c10756";
        com.baidu.tieba.card.data.n.bNQ = "c10709";
        com.baidu.tieba.card.data.n.bNR = "c10734";
        com.baidu.tieba.card.data.n.bNS = "c11929";
        com.baidu.tieba.card.data.n.bNT = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: au */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        this.cZG = new com.baidu.tieba.card.j(this.mG);
        this.cZG.k(this.aPx);
        this.cZG.b(this.cVT);
        return new d(this.cZG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.n nVar, d dVar) {
        if (nVar != null) {
            nVar.hR(i + 1);
            nVar.sourceType = 0;
        }
        dVar.Yr().setVideoStatsData(b(nVar));
        dVar.Yr().a(nVar);
        dVar.Yr().a(this.aVH);
        if (nVar != null) {
            u.XR().a(nVar.Yd());
        }
        return dVar.getView();
    }

    private com.baidu.tieba.play.x b(com.baidu.tieba.card.data.n nVar) {
        com.baidu.tieba.play.x xVar = null;
        if (nVar != null) {
            xVar = new com.baidu.tieba.play.x();
            xVar.mLocate = "1";
            xVar.cyX = nVar.Xf;
            if (nVar.Nj() != null) {
                xVar.azf = String.valueOf(nVar.Nj().getFid());
                if (nVar.Nj().rM() != null) {
                    xVar.fyg = nVar.Nj().rM().video_md5;
                }
            }
            xVar.Wi = nVar.getExtra();
            xVar.mSource = nVar.getSource();
            xVar.fyf = nVar.XW();
            xVar.fyd = nVar.getWeight();
        }
        return xVar;
    }

    public void setEventCallback(c.a aVar) {
        this.aVH = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.cZC = eVar;
    }
}
