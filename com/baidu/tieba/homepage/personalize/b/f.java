package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
import com.baidu.tieba.play.w;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.n, d<com.baidu.tieba.card.k>> {
    public BdUniqueId aOu;
    private x bkV;
    private com.baidu.tieba.homepage.personalize.model.e ddh;
    private com.baidu.tieba.card.k ddj;
    private TbPageContext<?> mF;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bkV = new x() { // from class: com.baidu.tieba.homepage.personalize.b.f.1
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                u.Yj().cC(true);
                if (f.this.ddj != null && view != null && bVar != null && (bVar instanceof com.baidu.tieba.card.data.n) && f.this.ddh != null) {
                    com.baidu.tieba.card.data.n nVar = (com.baidu.tieba.card.data.n) bVar;
                    if (nVar.bcG != null) {
                        if ((view.getTag() instanceof String) && nVar.MR() != null && nVar.MR().getId() != null && !com.baidu.tieba.homepage.personalize.f.bw(com.baidu.adp.lib.g.b.c(nVar.MR().getTid(), 0L))) {
                            com.baidu.tieba.homepage.personalize.f.bv(com.baidu.adp.lib.g.b.c(nVar.MR().getTid(), 0L));
                            f.this.ddh.a(com.baidu.adp.lib.g.b.c(nVar.MR().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.Ym(), nVar.Yo(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                        }
                        if (!(view instanceof TbImageView)) {
                            if (view.getId() == f.this.ddj.getView().getId()) {
                                if (nVar.bcG.sF() != null && nVar.bcG.sF().channelId > 0) {
                                    nVar.v("c11929", true);
                                }
                                TiebaStatic.log(new ak("c11004").ad("tid", nVar.bcG.getTid()));
                                TiebaStatic.log(new ak("c10806").r("obj_locate", 1).ad("tid", nVar.bcG.getId()));
                                return;
                            }
                            TiebaStatic.log(new ak("c11004").ad("tid", nVar.bcG.getTid()));
                            return;
                        }
                        TiebaStatic.log(new ak("c11004").ad("tid", nVar.bcG.getTid()));
                    }
                }
            }
        };
        this.mF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: at */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        this.ddj = new com.baidu.tieba.card.k(this.mF);
        this.ddj.l(this.aOu);
        return new d(this.ddj);
    }

    private w b(com.baidu.tieba.card.data.n nVar) {
        w wVar = null;
        if (nVar != null) {
            wVar = new w();
            wVar.mLocate = "1";
            wVar.bHy = nVar.Xe;
            wVar.fBQ = nVar.Yo();
            if (nVar.MR() != null) {
                wVar.azL = String.valueOf(nVar.MR().getFid());
                if (nVar.MR().sF() != null && nVar.MR().sF().channelId > 0) {
                    wVar.VU = "" + nVar.MR().sF().channelId;
                }
                if (nVar.MR().rS() != null) {
                    wVar.fBR = nVar.MR().rS().video_md5;
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
            nVar.hJ(i + 1);
            dVar.YJ().setVideoStatsData(b(nVar));
            dVar.YJ().a(nVar);
            dVar.YJ().b(this.bkV);
            if (nVar.bcG != null && nVar.bcG.getTid() != null) {
                u.Yj().a(new ak("c11003").ad("tid", nVar.bcG.getTid()));
            }
        }
        return dVar.getView();
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.ddh = eVar;
    }
}
