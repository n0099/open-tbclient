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
    public BdUniqueId aNy;
    private TbPageContext<?> ako;
    private x bjm;
    private com.baidu.tieba.homepage.personalize.model.e cSr;
    private com.baidu.tieba.card.k cSt;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bjm = new x() { // from class: com.baidu.tieba.homepage.personalize.b.f.1
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                u.Ww().cA(true);
                if (f.this.cSt != null && view != null && bVar != null && (bVar instanceof com.baidu.tieba.card.data.n) && f.this.cSr != null) {
                    com.baidu.tieba.card.data.n nVar = (com.baidu.tieba.card.data.n) bVar;
                    if (nVar.bbB != null) {
                        if ((view.getTag() instanceof String) && nVar.MA() != null && nVar.MA().getId() != null && !com.baidu.tieba.homepage.personalize.f.bw(com.baidu.adp.lib.g.b.c(nVar.MA().getTid(), 0L))) {
                            com.baidu.tieba.homepage.personalize.f.bv(com.baidu.adp.lib.g.b.c(nVar.MA().getTid(), 0L));
                            f.this.cSr.a(com.baidu.adp.lib.g.b.c(nVar.MA().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.WA(), nVar.WC(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                        }
                        if (!(view instanceof TbImageView)) {
                            if (view.getId() == f.this.cSt.getView().getId()) {
                                if (nVar.bbB.sz() != null && nVar.bbB.sz().channelId > 0) {
                                    nVar.v("c11929", true);
                                }
                                TiebaStatic.log(new aj("c11004").aa("tid", nVar.bbB.getTid()));
                                TiebaStatic.log(new aj("c10806").r("obj_locate", 1).aa("tid", nVar.bbB.getId()));
                                return;
                            }
                            TiebaStatic.log(new aj("c11004").aa("tid", nVar.bbB.getTid()));
                            return;
                        }
                        TiebaStatic.log(new aj("c11004").aa("tid", nVar.bbB.getTid()));
                    }
                }
            }
        };
        this.ako = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: an */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        this.cSt = new com.baidu.tieba.card.k(this.ako);
        this.cSt.j(this.aNy);
        return new d(this.cSt);
    }

    private w b(com.baidu.tieba.card.data.n nVar) {
        w wVar = null;
        if (nVar != null) {
            wVar = new w();
            wVar.mLocate = "1";
            wVar.bBT = nVar.Ww;
            wVar.fzo = nVar.WC();
            if (nVar.MA() != null) {
                wVar.azk = String.valueOf(nVar.MA().getFid());
                if (nVar.MA().sz() != null && nVar.MA().sz().channelId > 0) {
                    wVar.Vm = "" + nVar.MA().sz().channelId;
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
            nVar.hu(i + 1);
            dVar.WX().setVideoStatsData(b(nVar));
            dVar.WX().a(nVar);
            dVar.WX().a(this.bjm);
            if (nVar.bbB != null && nVar.bbB.getTid() != null) {
                u.Ww().a(new aj("c11003").aa("tid", nVar.bbB.getTid()));
            }
        }
        return dVar.getView();
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.cSr = eVar;
    }
}
