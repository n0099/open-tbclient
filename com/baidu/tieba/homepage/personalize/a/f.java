package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.widget.ListView.a<n, d<com.baidu.tieba.card.k>> {
    public BdUniqueId aPy;
    private x bok;
    private com.baidu.tieba.homepage.personalize.model.e dhS;
    private com.baidu.tieba.card.k dhU;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bok = new x() { // from class: com.baidu.tieba.homepage.personalize.a.f.1
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                u.aaj().cw(true);
                if (f.this.dhU != null && view != null && bVar != null && (bVar instanceof n) && f.this.dhS != null) {
                    n nVar = (n) bVar;
                    if (nVar.bff != null) {
                        if ((view.getTag() instanceof String) && nVar.NA() != null && nVar.NA().getId() != null && !com.baidu.tieba.homepage.personalize.f.bv(com.baidu.adp.lib.g.b.c(nVar.NA().getTid(), 0L))) {
                            com.baidu.tieba.homepage.personalize.f.bu(com.baidu.adp.lib.g.b.c(nVar.NA().getTid(), 0L));
                            f.this.dhS.a(com.baidu.adp.lib.g.b.c(nVar.NA().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.aam(), nVar.aao(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                        }
                        if (!(view instanceof TbImageView)) {
                            if (view.getId() == f.this.dhU.getView().getId()) {
                                if (nVar.bff.sz() != null && nVar.bff.sz().channelId > 0) {
                                    nVar.s("c11929", true);
                                }
                                TiebaStatic.log(new ak("c11004").ac("tid", nVar.bff.getTid()));
                                TiebaStatic.log(new ak("c10806").r("obj_locate", 1).ac("tid", nVar.bff.getId()));
                                return;
                            }
                            TiebaStatic.log(new ak("c11004").ac("tid", nVar.bff.getTid()));
                            return;
                        }
                        TiebaStatic.log(new ak("c11004").ac("tid", nVar.bff.getTid()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        this.dhU = new com.baidu.tieba.card.k(this.mPageContext);
        this.dhU.k(this.aPy);
        return new d(this.dhU);
    }

    private com.baidu.tieba.play.x b(n nVar) {
        com.baidu.tieba.play.x xVar = null;
        if (nVar != null) {
            xVar = new com.baidu.tieba.play.x();
            xVar.mLocate = "1";
            xVar.aMq = nVar.Xl;
            xVar.fHm = nVar.aao();
            xVar.Wo = nVar.getExtra();
            if (nVar.NA() != null) {
                xVar.azM = String.valueOf(nVar.NA().getFid());
                if (nVar.NA().rL() != null) {
                    xVar.fHn = nVar.NA().rL().video_md5;
                }
            }
        }
        return xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, n nVar, d dVar) {
        if (nVar != null) {
            nVar.ih(i + 1);
            dVar.aaJ().setVideoStatsData(b(nVar));
            dVar.aaJ().a(nVar);
            dVar.aaJ().b(this.bok);
            if (nVar.bff != null && nVar.bff.getTid() != null) {
                u.aaj().a(new ak("c11003").ac("tid", nVar.bff.getTid()));
            }
        }
        return dVar.getView();
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dhS = eVar;
    }
}
