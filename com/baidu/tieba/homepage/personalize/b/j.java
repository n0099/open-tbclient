package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
import com.baidu.tieba.play.w;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.n, d<com.baidu.tieba.card.j>> {
    public BdUniqueId aOu;
    private h.a alv;
    private x cZy;
    private com.baidu.tieba.homepage.personalize.model.e ddo;
    private com.baidu.tieba.card.j dds;
    private TbPageContext<?> mF;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.alv = null;
        this.cZy = new x<com.baidu.tieba.card.data.n>() { // from class: com.baidu.tieba.homepage.personalize.b.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.n nVar) {
                u.Yj().cC(true);
                if (j.this.ddo != null && nVar != null && nVar.MR() != null && !StringUtils.isNull(nVar.MR().getTid()) && j.this.dds != null && j.this.dds.getView() != null) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.bw(com.baidu.adp.lib.g.b.c(nVar.MR().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.bv(com.baidu.adp.lib.g.b.c(nVar.MR().getTid(), 0L));
                        j.this.ddo.a(com.baidu.adp.lib.g.b.c(nVar.MR().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.Ym(), nVar.Yo(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (view.getId() != j.this.dds.getView().getId()) {
                        if (j.this.dds.bly == null || j.this.dds.bly.getBarNameTv() == null || view.getId() != j.this.dds.bly.getBarNameTv().getId()) {
                            if (j.this.dds.getHeaderImg() == null || view.getId() != j.this.dds.getHeaderImg().getId()) {
                                if (j.this.dds.XO() != null && view.getId() == j.this.dds.XO().getId()) {
                                    TiebaStatic.log(nVar.H(nVar.bcG));
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(nVar.H(nVar.bcG));
                            return;
                        }
                        TiebaStatic.log(nVar.Yx());
                        return;
                    }
                    TiebaStatic.log(nVar.G(nVar.bcG));
                }
            }
        };
        this.mF = tbPageContext;
        ard();
    }

    private void ard() {
        com.baidu.tieba.card.data.n.bOi = "c10708";
        com.baidu.tieba.card.data.n.bOj = "c10735";
        com.baidu.tieba.card.data.n.bOk = "c10756";
        com.baidu.tieba.card.data.n.bOl = "c10709";
        com.baidu.tieba.card.data.n.bOm = "c10734";
        com.baidu.tieba.card.data.n.bOn = "c11929";
        com.baidu.tieba.card.data.n.bOo = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: at */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        this.dds = new com.baidu.tieba.card.j(this.mF);
        this.dds.l(this.aOu);
        this.dds.b(this.cZy);
        return new d(this.dds);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.n nVar, d dVar) {
        if (nVar != null) {
            nVar.hJ(i + 1);
            nVar.sourceType = 0;
        }
        dVar.YJ().setVideoStatsData(b(nVar));
        dVar.YJ().a(nVar);
        dVar.YJ().a(this.alv);
        if (nVar != null) {
            u.Yj().a(nVar.Yv());
        }
        return dVar.getView();
    }

    private w b(com.baidu.tieba.card.data.n nVar) {
        w wVar = null;
        if (nVar != null) {
            wVar = new w();
            wVar.mLocate = "1";
            wVar.bHy = nVar.Xe;
            if (nVar.MR() != null) {
                wVar.azL = String.valueOf(nVar.MR().getFid());
                if (nVar.MR().sF() != null && nVar.MR().sF().channelId > 0) {
                    wVar.VU = "" + nVar.MR().sF().channelId;
                } else {
                    wVar.VU = "0";
                }
                if (nVar.MR().rS() != null) {
                    wVar.fBR = nVar.MR().rS().video_md5;
                }
            }
            wVar.mSource = nVar.getSource();
            wVar.fBQ = nVar.Yo();
            wVar.fBO = nVar.getWeight();
        }
        return wVar;
    }

    public void setEventCallback(h.a aVar) {
        this.alv = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.ddo = eVar;
    }
}
