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
    public BdUniqueId aPq;
    private x bob;
    private com.baidu.tieba.card.k dhA;
    private com.baidu.tieba.homepage.personalize.model.e dhy;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bob = new x() { // from class: com.baidu.tieba.homepage.personalize.a.f.1
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                u.ZX().cv(true);
                if (f.this.dhA != null && view != null && bVar != null && (bVar instanceof n) && f.this.dhy != null) {
                    n nVar = (n) bVar;
                    if (nVar.beV != null) {
                        if ((view.getTag() instanceof String) && nVar.Np() != null && nVar.Np().getId() != null && !com.baidu.tieba.homepage.personalize.f.bv(com.baidu.adp.lib.g.b.c(nVar.Np().getTid(), 0L))) {
                            com.baidu.tieba.homepage.personalize.f.bu(com.baidu.adp.lib.g.b.c(nVar.Np().getTid(), 0L));
                            f.this.dhy.a(com.baidu.adp.lib.g.b.c(nVar.Np().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.aaa(), nVar.aac(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                        }
                        if (!(view instanceof TbImageView)) {
                            if (view.getId() == f.this.dhA.getView().getId()) {
                                if (nVar.beV.sz() != null && nVar.beV.sz().channelId > 0) {
                                    nVar.s("c11929", true);
                                }
                                TiebaStatic.log(new ak("c11004").ac("tid", nVar.beV.getTid()));
                                TiebaStatic.log(new ak("c10806").r("obj_locate", 1).ac("tid", nVar.beV.getId()));
                                return;
                            }
                            TiebaStatic.log(new ak("c11004").ac("tid", nVar.beV.getTid()));
                            return;
                        }
                        TiebaStatic.log(new ak("c11004").ac("tid", nVar.beV.getTid()));
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
        this.dhA = new com.baidu.tieba.card.k(this.mPageContext);
        this.dhA.k(this.aPq);
        return new d(this.dhA);
    }

    private com.baidu.tieba.play.x b(n nVar) {
        com.baidu.tieba.play.x xVar = null;
        if (nVar != null) {
            xVar = new com.baidu.tieba.play.x();
            xVar.mLocate = "1";
            xVar.aMi = nVar.Xl;
            xVar.fGH = nVar.aac();
            xVar.Wo = nVar.getExtra();
            if (nVar.Np() != null) {
                xVar.azE = String.valueOf(nVar.Np().getFid());
                if (nVar.Np().rL() != null) {
                    xVar.fGI = nVar.Np().rL().video_md5;
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
            nVar.ij(i + 1);
            dVar.aax().setVideoStatsData(b(nVar));
            dVar.aax().a(nVar);
            dVar.aax().b(this.bob);
            if (nVar.beV != null && nVar.beV.getTid() != null) {
                u.ZX().a(new ak("c11003").ac("tid", nVar.beV.getTid()));
            }
        }
        return dVar.getView();
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dhy = eVar;
    }
}
