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
    public BdUniqueId aPy;
    private c.a aVM;
    private x deu;
    private com.baidu.tieba.homepage.personalize.model.e dhZ;
    private com.baidu.tieba.card.j did;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aVM = null;
        this.deu = new x<n>() { // from class: com.baidu.tieba.homepage.personalize.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, n nVar) {
                u.aaj().cw(true);
                if (j.this.dhZ != null && nVar != null && nVar.NA() != null && !StringUtils.isNull(nVar.NA().getTid()) && j.this.did != null && j.this.did.getView() != null) {
                    if (nVar.NA().aao > 0) {
                        TiebaStatic.log(nVar.B(nVar.NA()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.bv(com.baidu.adp.lib.g.b.c(nVar.NA().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.bu(com.baidu.adp.lib.g.b.c(nVar.NA().getTid(), 0L));
                        j.this.dhZ.a(com.baidu.adp.lib.g.b.c(nVar.NA().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.aam(), nVar.aao(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (view.getId() != j.this.did.getView().getId()) {
                        if (j.this.did.boM == null || j.this.did.boM.getBarNameTv() == null || view.getId() != j.this.did.boM.getBarNameTv().getId()) {
                            if (j.this.did.getHeaderImg() == null || view.getId() != j.this.did.getHeaderImg().getId()) {
                                if (j.this.did.ZM() == null || view.getId() != j.this.did.ZM().getId()) {
                                    if (j.this.did.boM == null || j.this.did.boM.getCommentContainer() == null || view.getId() != j.this.did.boM.getCommentContainer().getId()) {
                                        if (j.this.did.bRd != null && view.getId() == j.this.did.bRd.getId()) {
                                            TiebaStatic.log(nVar.B(nVar.bff));
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(nVar.B(nVar.bff));
                                    return;
                                }
                                TiebaStatic.log(nVar.C(nVar.bff));
                                return;
                            }
                            TiebaStatic.log(nVar.C(nVar.bff));
                            return;
                        }
                        TiebaStatic.log(nVar.aax());
                        return;
                    }
                    TiebaStatic.log(nVar.B(nVar.bff));
                }
            }
        };
        this.mPageContext = tbPageContext;
        ast();
    }

    private void ast() {
        n.bVs = "c10708";
        n.bVt = "c10735";
        n.bVu = "c10756";
        n.bVv = "c10709";
        n.bVw = "c10734";
        n.bVx = "c11929";
        n.bVy = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        this.did = new com.baidu.tieba.card.j(this.mPageContext);
        this.did.k(this.aPy);
        this.did.b(this.deu);
        return new d(this.did);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, n nVar, d dVar) {
        if (nVar != null) {
            nVar.ih(i + 1);
            nVar.sourceType = 0;
        }
        dVar.aaJ().setVideoStatsData(b(nVar));
        dVar.aaJ().a(nVar);
        dVar.aaJ().a(this.aVM);
        if (nVar != null) {
            u.aaj().a(nVar.aav());
        }
        return dVar.getView();
    }

    private com.baidu.tieba.play.x b(n nVar) {
        com.baidu.tieba.play.x xVar = null;
        if (nVar != null) {
            xVar = new com.baidu.tieba.play.x();
            xVar.mLocate = "1";
            xVar.aMq = nVar.Xl;
            if (nVar.NA() != null) {
                xVar.azM = String.valueOf(nVar.NA().getFid());
                if (nVar.NA().rL() != null) {
                    xVar.fHn = nVar.NA().rL().video_md5;
                }
            }
            xVar.Wo = nVar.getExtra();
            xVar.mSource = nVar.getSource();
            xVar.fHm = nVar.aao();
            xVar.fHk = nVar.getWeight();
        }
        return xVar;
    }

    public void setEventCallback(c.a aVar) {
        this.aVM = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dhZ = eVar;
    }
}
