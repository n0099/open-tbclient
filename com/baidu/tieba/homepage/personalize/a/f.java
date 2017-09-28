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
    public BdUniqueId aPx;
    private x bmG;
    private com.baidu.tieba.homepage.personalize.model.e cZv;
    private com.baidu.tieba.card.k cZx;
    private TbPageContext<?> mG;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bmG = new x() { // from class: com.baidu.tieba.homepage.personalize.a.f.1
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                u.XR().cB(true);
                if (f.this.cZx != null && view != null && bVar != null && (bVar instanceof com.baidu.tieba.card.data.n) && f.this.cZv != null) {
                    com.baidu.tieba.card.data.n nVar = (com.baidu.tieba.card.data.n) bVar;
                    if (nVar.bes != null) {
                        if ((view.getTag() instanceof String) && nVar.Nj() != null && nVar.Nj().getId() != null && !com.baidu.tieba.homepage.personalize.f.bt(com.baidu.adp.lib.g.b.c(nVar.Nj().getTid(), 0L))) {
                            com.baidu.tieba.homepage.personalize.f.bs(com.baidu.adp.lib.g.b.c(nVar.Nj().getTid(), 0L));
                            f.this.cZv.a(com.baidu.adp.lib.g.b.c(nVar.Nj().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.XU(), nVar.XW(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                        }
                        if (!(view instanceof TbImageView)) {
                            if (view.getId() == f.this.cZx.getView().getId()) {
                                if (nVar.bes.sz() != null && nVar.bes.sz().channelId > 0) {
                                    nVar.u("c11929", true);
                                }
                                TiebaStatic.log(new ak("c11004").ad("tid", nVar.bes.getTid()));
                                TiebaStatic.log(new ak("c10806").r("obj_locate", 1).ad("tid", nVar.bes.getId()));
                                return;
                            }
                            TiebaStatic.log(new ak("c11004").ad("tid", nVar.bes.getTid()));
                            return;
                        }
                        TiebaStatic.log(new ak("c11004").ad("tid", nVar.bes.getTid()));
                    }
                }
            }
        };
        this.mG = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: au */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        this.cZx = new com.baidu.tieba.card.k(this.mG);
        this.cZx.k(this.aPx);
        return new d(this.cZx);
    }

    private com.baidu.tieba.play.x b(com.baidu.tieba.card.data.n nVar) {
        com.baidu.tieba.play.x xVar = null;
        if (nVar != null) {
            xVar = new com.baidu.tieba.play.x();
            xVar.mLocate = "1";
            xVar.cyX = nVar.Xf;
            xVar.fyf = nVar.XW();
            xVar.Wi = nVar.getExtra();
            if (nVar.Nj() != null) {
                xVar.azf = String.valueOf(nVar.Nj().getFid());
                if (nVar.Nj().rM() != null) {
                    xVar.fyg = nVar.Nj().rM().video_md5;
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
            nVar.hR(i + 1);
            dVar.Yr().setVideoStatsData(b(nVar));
            dVar.Yr().a(nVar);
            dVar.Yr().b(this.bmG);
            if (nVar.bes != null && nVar.bes.getTid() != null) {
                u.XR().a(new ak("c11003").ad("tid", nVar.bes.getTid()));
            }
        }
        return dVar.getView();
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.cZv = eVar;
    }
}
