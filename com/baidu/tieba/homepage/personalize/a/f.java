package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.n, d<com.baidu.tieba.card.k>> {
    public BdUniqueId aPk;
    private x bms;
    private com.baidu.tieba.homepage.personalize.model.e cZi;
    private com.baidu.tieba.card.k cZk;
    private TbPageContext<?> mH;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bms = new x() { // from class: com.baidu.tieba.homepage.personalize.a.f.1
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                u.XN().cA(true);
                if (f.this.cZk != null && view != null && bVar != null && (bVar instanceof com.baidu.tieba.card.data.n) && f.this.cZi != null) {
                    com.baidu.tieba.card.data.n nVar = (com.baidu.tieba.card.data.n) bVar;
                    if (nVar.bee != null) {
                        if ((view.getTag() instanceof String) && nVar.Nd() != null && nVar.Nd().getId() != null && !com.baidu.tieba.homepage.personalize.f.bu(com.baidu.adp.lib.g.b.c(nVar.Nd().getTid(), 0L))) {
                            com.baidu.tieba.homepage.personalize.f.bt(com.baidu.adp.lib.g.b.c(nVar.Nd().getTid(), 0L));
                            f.this.cZi.a(com.baidu.adp.lib.g.b.c(nVar.Nd().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.XQ(), nVar.XS(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                        }
                        if (!(view instanceof TbImageView)) {
                            if (view.getId() == f.this.cZk.getView().getId()) {
                                if (nVar.bee.ss() != null && nVar.bee.ss().channelId > 0) {
                                    nVar.u("c11929", true);
                                }
                                TiebaStatic.log(new ak("c11004").ac("tid", nVar.bee.getTid()));
                                TiebaStatic.log(new ak("c10806").r("obj_locate", 1).ac("tid", nVar.bee.getId()));
                                return;
                            }
                            TiebaStatic.log(new ak("c11004").ac("tid", nVar.bee.getTid()));
                            return;
                        }
                        TiebaStatic.log(new ak("c11004").ac("tid", nVar.bee.getTid()));
                    }
                }
            }
        };
        this.mH = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: au */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        this.cZk = new com.baidu.tieba.card.k(this.mH);
        this.cZk.k(this.aPk);
        return new d(this.cZk);
    }

    private com.baidu.tieba.play.x b(com.baidu.tieba.card.data.n nVar) {
        com.baidu.tieba.play.x xVar = null;
        if (nVar != null) {
            xVar = new com.baidu.tieba.play.x();
            xVar.mLocate = "1";
            xVar.cyL = nVar.WT;
            xVar.fxQ = nVar.XS();
            xVar.VW = nVar.getExtra();
            if (nVar.Nd() != null) {
                xVar.ayT = String.valueOf(nVar.Nd().getFid());
                if (nVar.Nd().rF() != null) {
                    xVar.fxR = nVar.Nd().rF().video_md5;
                }
            }
        }
        return xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.n nVar, d dVar) {
        if (nVar != null) {
            nVar.hQ(i + 1);
            dVar.Yn().setVideoStatsData(b(nVar));
            dVar.Yn().a(nVar);
            dVar.Yn().b(this.bms);
            if (nVar.bee != null && nVar.bee.getTid() != null) {
                u.XN().a(new ak("c11003").ac("tid", nVar.bee.getTid()));
            }
        }
        return dVar.getView();
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.cZi = eVar;
    }
}
