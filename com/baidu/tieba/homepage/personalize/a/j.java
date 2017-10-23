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
    public BdUniqueId aPk;
    private c.a aVu;
    private x cVH;
    private com.baidu.tieba.homepage.personalize.model.e cZp;
    private com.baidu.tieba.card.j cZt;
    private TbPageContext<?> mH;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aVu = null;
        this.cVH = new x<com.baidu.tieba.card.data.n>() { // from class: com.baidu.tieba.homepage.personalize.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.n nVar) {
                u.XN().cA(true);
                if (j.this.cZp != null && nVar != null && nVar.Nd() != null && !StringUtils.isNull(nVar.Nd().getTid()) && j.this.cZt != null && j.this.cZt.getView() != null) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.bu(com.baidu.adp.lib.g.b.c(nVar.Nd().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.bt(com.baidu.adp.lib.g.b.c(nVar.Nd().getTid(), 0L));
                        j.this.cZp.a(com.baidu.adp.lib.g.b.c(nVar.Nd().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.XQ(), nVar.XS(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (view.getId() != j.this.cZt.getView().getId()) {
                        if (j.this.cZt.bmV == null || j.this.cZt.bmV.getBarNameTv() == null || view.getId() != j.this.cZt.bmV.getBarNameTv().getId()) {
                            if (j.this.cZt.getHeaderImg() == null || view.getId() != j.this.cZt.getHeaderImg().getId()) {
                                if (j.this.cZt.Xq() != null && view.getId() == j.this.cZt.Xq().getId()) {
                                    TiebaStatic.log(nVar.C(nVar.bee));
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(nVar.C(nVar.bee));
                            return;
                        }
                        TiebaStatic.log(nVar.Yb());
                        return;
                    }
                    TiebaStatic.log(nVar.B(nVar.bee));
                }
            }
        };
        this.mH = tbPageContext;
        apE();
    }

    private void apE() {
        com.baidu.tieba.card.data.n.bNB = "c10708";
        com.baidu.tieba.card.data.n.bNC = "c10735";
        com.baidu.tieba.card.data.n.bND = "c10756";
        com.baidu.tieba.card.data.n.bNE = "c10709";
        com.baidu.tieba.card.data.n.bNF = "c10734";
        com.baidu.tieba.card.data.n.bNG = "c11929";
        com.baidu.tieba.card.data.n.bNH = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: au */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        this.cZt = new com.baidu.tieba.card.j(this.mH);
        this.cZt.k(this.aPk);
        this.cZt.b(this.cVH);
        return new d(this.cZt);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.n nVar, d dVar) {
        if (nVar != null) {
            nVar.hQ(i + 1);
            nVar.sourceType = 0;
        }
        dVar.Yn().setVideoStatsData(b(nVar));
        dVar.Yn().a(nVar);
        dVar.Yn().a(this.aVu);
        if (nVar != null) {
            u.XN().a(nVar.XZ());
        }
        return dVar.getView();
    }

    private com.baidu.tieba.play.x b(com.baidu.tieba.card.data.n nVar) {
        com.baidu.tieba.play.x xVar = null;
        if (nVar != null) {
            xVar = new com.baidu.tieba.play.x();
            xVar.mLocate = "1";
            xVar.cyL = nVar.WT;
            if (nVar.Nd() != null) {
                xVar.ayT = String.valueOf(nVar.Nd().getFid());
                if (nVar.Nd().rF() != null) {
                    xVar.fxR = nVar.Nd().rF().video_md5;
                }
            }
            xVar.VW = nVar.getExtra();
            xVar.mSource = nVar.getSource();
            xVar.fxQ = nVar.XS();
            xVar.fxO = nVar.getWeight();
        }
        return xVar;
    }

    public void setEventCallback(c.a aVar) {
        this.aVu = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.cZp = eVar;
    }
}
