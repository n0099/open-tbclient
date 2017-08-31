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
    public BdUniqueId aOx;
    private x bkW;
    private com.baidu.tieba.homepage.personalize.model.e dcm;
    private com.baidu.tieba.card.k dco;
    private TbPageContext<?> mF;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bkW = new x() { // from class: com.baidu.tieba.homepage.personalize.b.f.1
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                u.XY().cC(true);
                if (f.this.dco != null && view != null && bVar != null && (bVar instanceof com.baidu.tieba.card.data.n) && f.this.dcm != null) {
                    com.baidu.tieba.card.data.n nVar = (com.baidu.tieba.card.data.n) bVar;
                    if (nVar.bcJ != null) {
                        if ((view.getTag() instanceof String) && nVar.MR() != null && nVar.MR().getId() != null && !com.baidu.tieba.homepage.personalize.f.bw(com.baidu.adp.lib.g.b.c(nVar.MR().getTid(), 0L))) {
                            com.baidu.tieba.homepage.personalize.f.bv(com.baidu.adp.lib.g.b.c(nVar.MR().getTid(), 0L));
                            f.this.dcm.a(com.baidu.adp.lib.g.b.c(nVar.MR().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.Yb(), nVar.Yd(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                        }
                        if (!(view instanceof TbImageView)) {
                            if (view.getId() == f.this.dco.getView().getId()) {
                                if (nVar.bcJ.sF() != null && nVar.bcJ.sF().channelId > 0) {
                                    nVar.v("c11929", true);
                                }
                                TiebaStatic.log(new ak("c11004").ad("tid", nVar.bcJ.getTid()));
                                TiebaStatic.log(new ak("c10806").r("obj_locate", 1).ad("tid", nVar.bcJ.getId()));
                                return;
                            }
                            TiebaStatic.log(new ak("c11004").ad("tid", nVar.bcJ.getTid()));
                            return;
                        }
                        TiebaStatic.log(new ak("c11004").ad("tid", nVar.bcJ.getTid()));
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
        this.dco = new com.baidu.tieba.card.k(this.mF);
        this.dco.l(this.aOx);
        return new d(this.dco);
    }

    private w b(com.baidu.tieba.card.data.n nVar) {
        w wVar = null;
        if (nVar != null) {
            wVar = new w();
            wVar.mLocate = "1";
            wVar.bGH = nVar.Xe;
            wVar.fAX = nVar.Yd();
            if (nVar.MR() != null) {
                wVar.azO = String.valueOf(nVar.MR().getFid());
                if (nVar.MR().sF() != null && nVar.MR().sF().channelId > 0) {
                    wVar.VU = "" + nVar.MR().sF().channelId;
                }
                if (nVar.MR().rS() != null) {
                    wVar.fAY = nVar.MR().rS().video_md5;
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
            nVar.hH(i + 1);
            dVar.Yy().setVideoStatsData(b(nVar));
            dVar.Yy().a(nVar);
            dVar.Yy().b(this.bkW);
            if (nVar.bcJ != null && nVar.bcJ.getTid() != null) {
                u.XY().a(new ak("c11003").ad("tid", nVar.bcJ.getTid()));
            }
        }
        return dVar.getView();
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dcm = eVar;
    }
}
