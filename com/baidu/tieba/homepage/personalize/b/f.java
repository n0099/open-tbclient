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
    public BdUniqueId aOM;
    private TbPageContext<?> alI;
    private x bkw;
    private com.baidu.tieba.homepage.personalize.model.e cTK;
    private com.baidu.tieba.card.k cTM;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bkw = new x() { // from class: com.baidu.tieba.homepage.personalize.b.f.1
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                u.WB().cA(true);
                if (f.this.cTM != null && view != null && bVar != null && (bVar instanceof com.baidu.tieba.card.data.n) && f.this.cTK != null) {
                    com.baidu.tieba.card.data.n nVar = (com.baidu.tieba.card.data.n) bVar;
                    if (nVar.bcL != null) {
                        if ((view.getTag() instanceof String) && nVar.MF() != null && nVar.MF().getId() != null && !com.baidu.tieba.homepage.personalize.f.bw(com.baidu.adp.lib.g.b.d(nVar.MF().getTid(), 0L))) {
                            com.baidu.tieba.homepage.personalize.f.bv(com.baidu.adp.lib.g.b.d(nVar.MF().getTid(), 0L));
                            f.this.cTK.a(com.baidu.adp.lib.g.b.d(nVar.MF().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.WF(), nVar.WH(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                        }
                        if (!(view instanceof TbImageView)) {
                            if (view.getId() == f.this.cTM.getView().getId()) {
                                if (nVar.bcL.sJ() != null && nVar.bcL.sJ().channelId > 0) {
                                    nVar.v("c11929", true);
                                }
                                TiebaStatic.log(new aj("c11004").aa("tid", nVar.bcL.getTid()));
                                TiebaStatic.log(new aj("c10806").r("obj_locate", 1).aa("tid", nVar.bcL.getId()));
                                return;
                            }
                            TiebaStatic.log(new aj("c11004").aa("tid", nVar.bcL.getTid()));
                            return;
                        }
                        TiebaStatic.log(new aj("c11004").aa("tid", nVar.bcL.getTid()));
                    }
                }
            }
        };
        this.alI = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: an */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        this.cTM = new com.baidu.tieba.card.k(this.alI);
        this.cTM.j(this.aOM);
        return new d(this.cTM);
    }

    private w b(com.baidu.tieba.card.data.n nVar) {
        w wVar = null;
        if (nVar != null) {
            wVar = new w();
            wVar.mLocate = "1";
            wVar.bDd = nVar.XS;
            wVar.fAA = nVar.WH();
            if (nVar.MF() != null) {
                wVar.aAB = String.valueOf(nVar.MF().getFid());
                if (nVar.MF().sJ() != null && nVar.MF().sJ().channelId > 0) {
                    wVar.WI = "" + nVar.MF().sJ().channelId;
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
            nVar.hv(i + 1);
            dVar.Xc().setVideoStatsData(b(nVar));
            dVar.Xc().a(nVar);
            dVar.Xc().a(this.bkw);
            if (nVar.bcL != null && nVar.bcL.getTid() != null) {
                u.WB().a(new aj("c11003").aa("tid", nVar.bcL.getTid()));
            }
        }
        return dVar.getView();
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.cTK = eVar;
    }
}
