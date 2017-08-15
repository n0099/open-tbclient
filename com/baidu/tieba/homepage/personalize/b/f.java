package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
import com.baidu.tieba.play.w;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.n, d<com.baidu.tieba.card.k>> {
    public BdUniqueId aON;
    private x bkA;
    private com.baidu.tieba.homepage.personalize.model.e cVJ;
    private com.baidu.tieba.card.k cVL;
    private TbPageContext<?> oV;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bkA = new x() { // from class: com.baidu.tieba.homepage.personalize.b.f.1
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                u.WX().cA(true);
                if (f.this.cVL != null && view != null && bVar != null && (bVar instanceof com.baidu.tieba.card.data.n) && f.this.cVJ != null) {
                    com.baidu.tieba.card.data.n nVar = (com.baidu.tieba.card.data.n) bVar;
                    if (nVar.bcM != null) {
                        if ((view.getTag() instanceof String) && nVar.MF() != null && nVar.MF().getId() != null && !com.baidu.tieba.homepage.personalize.f.bw(com.baidu.adp.lib.g.b.d(nVar.MF().getTid(), 0L))) {
                            com.baidu.tieba.homepage.personalize.f.bv(com.baidu.adp.lib.g.b.d(nVar.MF().getTid(), 0L));
                            f.this.cVJ.a(com.baidu.adp.lib.g.b.d(nVar.MF().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.Xb(), nVar.Xd(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                        }
                        if (!(view instanceof TbImageView)) {
                            if (view.getId() == f.this.cVL.getView().getId()) {
                                if (nVar.bcM.sJ() != null && nVar.bcM.sJ().channelId > 0) {
                                    nVar.v("c11929", true);
                                }
                                TiebaStatic.log(new aj("c11004").aa("tid", nVar.bcM.getTid()));
                                TiebaStatic.log(new aj("c10806").r("obj_locate", 1).aa("tid", nVar.bcM.getId()));
                                return;
                            }
                            TiebaStatic.log(new aj("c11004").aa("tid", nVar.bcM.getTid()));
                            return;
                        }
                        TiebaStatic.log(new aj("c11004").aa("tid", nVar.bcM.getTid()));
                    }
                }
            }
        };
        this.oV = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        this.cVL = new com.baidu.tieba.card.k(this.oV);
        this.cVL.j(this.aON);
        return new d(this.cVL);
    }

    private w b(com.baidu.tieba.card.data.n nVar) {
        w wVar = null;
        if (nVar != null) {
            wVar = new w();
            wVar.mLocate = "1";
            wVar.bDM = nVar.XU;
            wVar.fCt = nVar.Xd();
            if (nVar.MF() != null) {
                wVar.aAC = String.valueOf(nVar.MF().getFid());
                if (nVar.MF().sJ() != null && nVar.MF().sJ().channelId > 0) {
                    wVar.WK = "" + nVar.MF().sJ().channelId;
                }
            }
        }
        return wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.n nVar, d dVar) {
        if (nVar != null) {
            nVar.hw(i + 1);
            dVar.Xy().setVideoStatsData(b(nVar));
            dVar.Xy().a(nVar);
            dVar.Xy().b(this.bkA);
            if (nVar.bcM != null && nVar.bcM.getTid() != null) {
                u.WX().a(new aj("c11003").aa("tid", nVar.bcM.getTid()));
            }
        }
        return dVar.getView();
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.cVJ = eVar;
    }
}
