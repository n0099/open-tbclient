package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.widget.ListView.a<n, d<com.baidu.tieba.card.j>> {
    public BdUniqueId aPq;
    private c.a aVE;
    private x ddZ;
    private com.baidu.tieba.homepage.personalize.model.e dhF;
    private com.baidu.tieba.card.j dhJ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aVE = null;
        this.ddZ = new x<n>() { // from class: com.baidu.tieba.homepage.personalize.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, n nVar) {
                u.ZX().cv(true);
                if (j.this.dhF != null && nVar != null && nVar.Np() != null && !StringUtils.isNull(nVar.Np().getTid()) && j.this.dhJ != null && j.this.dhJ.getView() != null) {
                    if (nVar.Np().aao > 0) {
                        TiebaStatic.log(nVar.B(nVar.Np()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.bv(com.baidu.adp.lib.g.b.c(nVar.Np().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.bu(com.baidu.adp.lib.g.b.c(nVar.Np().getTid(), 0L));
                        j.this.dhF.a(com.baidu.adp.lib.g.b.c(nVar.Np().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.aaa(), nVar.aac(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (view.getId() != j.this.dhJ.getView().getId()) {
                        if (j.this.dhJ.boD == null || j.this.dhJ.boD.getBarNameTv() == null || view.getId() != j.this.dhJ.boD.getBarNameTv().getId()) {
                            if (j.this.dhJ.getHeaderImg() == null || view.getId() != j.this.dhJ.getHeaderImg().getId()) {
                                if (j.this.dhJ.ZA() == null || view.getId() != j.this.dhJ.ZA().getId()) {
                                    if (j.this.dhJ.boD == null || j.this.dhJ.boD.getCommentContainer() == null || view.getId() != j.this.dhJ.boD.getCommentContainer().getId()) {
                                        if (j.this.dhJ.bQQ != null && view.getId() == j.this.dhJ.bQQ.getId()) {
                                            TiebaStatic.log(nVar.B(nVar.beV));
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(nVar.B(nVar.beV));
                                    return;
                                }
                                TiebaStatic.log(nVar.C(nVar.beV));
                                return;
                            }
                            TiebaStatic.log(nVar.C(nVar.beV));
                            return;
                        }
                        TiebaStatic.log(nVar.aal());
                        return;
                    }
                    TiebaStatic.log(nVar.B(nVar.beV));
                }
            }
        };
        this.mPageContext = tbPageContext;
        asc();
    }

    private void asc() {
        n.bVf = "c10708";
        n.bVg = "c10735";
        n.bVh = "c10756";
        n.bVi = "c10709";
        n.bVj = "c10734";
        n.bVk = "c11929";
        n.bVl = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        this.dhJ = new com.baidu.tieba.card.j(this.mPageContext);
        this.dhJ.k(this.aPq);
        this.dhJ.b(this.ddZ);
        return new d(this.dhJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, n nVar, d dVar) {
        if (nVar != null) {
            nVar.ij(i + 1);
            nVar.sourceType = 0;
        }
        dVar.aax().setVideoStatsData(b(nVar));
        dVar.aax().a(nVar);
        dVar.aax().a(this.aVE);
        if (nVar != null) {
            u.ZX().a(nVar.aaj());
        }
        return dVar.getView();
    }

    private com.baidu.tieba.play.x b(n nVar) {
        com.baidu.tieba.play.x xVar = null;
        if (nVar != null) {
            xVar = new com.baidu.tieba.play.x();
            xVar.mLocate = "1";
            xVar.aMi = nVar.Xl;
            if (nVar.Np() != null) {
                xVar.azE = String.valueOf(nVar.Np().getFid());
                if (nVar.Np().rL() != null) {
                    xVar.fGI = nVar.Np().rL().video_md5;
                }
            }
            xVar.Wo = nVar.getExtra();
            xVar.mSource = nVar.getSource();
            xVar.fGH = nVar.aac();
            xVar.fGF = nVar.getWeight();
        }
        return xVar;
    }

    public void setEventCallback(c.a aVar) {
        this.aVE = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dhF = eVar;
    }
}
