package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.v;
import com.baidu.tieba.play.aa;
/* loaded from: classes2.dex */
public class i extends com.baidu.adp.widget.ListView.a<n, d<com.baidu.tieba.card.j>> {
    public BdUniqueId bGE;
    private c.a bMW;
    private int cardShowType;
    private v ebW;
    private com.baidu.tieba.homepage.personalize.model.e efH;
    private com.baidu.tieba.card.j efM;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, n nVar) {
        if (view.getId() == this.efM.getView().getId()) {
            TiebaStatic.log(nVar.K(nVar.bXi));
        } else if (this.efM.ciT != null && this.efM.ciT.getBarNameTv() != null && view.getId() == this.efM.ciT.getBarNameTv().getId()) {
            TiebaStatic.log(nVar.ald());
        } else if (this.efM.cSM != null && this.efM.cSM.bcH != null && view.getId() == this.efM.cSM.bcH.getId()) {
            TiebaStatic.log(nVar.ald());
        } else if (this.efM.getHeaderImg() != null && view.getId() == this.efM.getHeaderImg().getId()) {
            TiebaStatic.log(nVar.L(nVar.bXi));
        } else if (this.efM.akj() != null && view.getId() == this.efM.akj().getId()) {
            TiebaStatic.log(nVar.L(nVar.bXi));
        } else if (this.efM.ciT != null && this.efM.ciT.getCommentContainer() != null && view.getId() == this.efM.ciT.getCommentContainer().getId()) {
            TiebaStatic.log(nVar.K(nVar.bXi));
        } else if (this.efM.cSK != null && view.getId() == this.efM.cSK.getId()) {
            TiebaStatic.log(nVar.K(nVar.bXi));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, n nVar) {
        if (view instanceof TbImageView) {
            TiebaStatic.log(new ak("c11004").aa("tid", nVar.bXi.getTid()));
        } else if (view.getId() == this.efM.getView().getId()) {
            if (nVar.bXi.zV() != null && nVar.bXi.zV().channelId > 0) {
                nVar.t("c11929", true);
            }
            TiebaStatic.log(new ak("c11004").aa("tid", nVar.bXi.getTid()));
            TiebaStatic.log(new ak("c10806").s("obj_locate", 1).aa("tid", nVar.bXi.getId()));
            TiebaStatic.log(nVar.K(nVar.bXi));
        } else {
            TiebaStatic.log(new ak("c11004").aa("tid", nVar.bXi.getTid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bMW = null;
        this.cardShowType = 0;
        this.ebW = new v<n>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, n nVar) {
                s.akK().dg(true);
                if (i.this.efH != null && nVar != null && nVar.VM() != null && !StringUtils.isNull(nVar.VM().getTid()) && i.this.efM != null && i.this.efM.getView() != null) {
                    if (nVar.VM().aPa > 0) {
                        TiebaStatic.log(nVar.K(nVar.VM()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.g.bM(com.baidu.adp.lib.g.b.c(nVar.VM().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.g.bL(com.baidu.adp.lib.g.b.c(nVar.VM().getTid(), 0L));
                        i.this.efH.a(com.baidu.adp.lib.g.b.c(nVar.VM().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.akS(), nVar.akU(), com.baidu.adp.lib.g.b.h((String) view.getTag(), 1));
                    }
                    if (i.this.mType == n.cXD) {
                        i.this.b(view, nVar);
                    } else if (i.this.mType == n.cXE) {
                        i.this.c(view, nVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aBH();
    }

    private void aBH() {
        n.cXF = "c10708";
        n.cXG = "c10735";
        n.cXH = "c10756";
        n.cXI = "c10709";
        n.cXJ = "c10734";
        n.cXK = "c11929";
        n.cXL = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        this.efM = new com.baidu.tieba.card.j(this.mPageContext);
        this.efM.currentPageType = 2;
        if (this.efM.ciT != null) {
            this.efM.ciT.bbX = 2;
        }
        if (this.efM.cSM != null && this.efM.cSM.bcI != null) {
            this.efM.cSM.bcI.bbX = 2;
        }
        this.efM.j(this.bGE);
        this.efM.b(this.ebW);
        return new d(this.efM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, n nVar, d dVar) {
        if (nVar != null) {
            nVar.lH(i + 1);
            nVar.sourceType = 0;
        }
        dVar.alp().setVideoStatsData(b(nVar));
        if (nVar != null && nVar.bXi != null) {
            nVar.bXi.aPd = this.cardShowType;
        }
        dVar.alp().a(nVar);
        dVar.alp().a(this.bMW);
        if (nVar != null) {
            if (getType() != null && getType() == n.cXE) {
                s.akK().a(nVar.alb());
                ak akVar = new ak("c11003");
                bd VM = nVar.VM();
                if (VM != null) {
                    akVar.aa("tid", VM.getTid());
                    if (VM.yT() != null) {
                        akVar.s("ab_type", VM.yT().hadConcerned() ? 1 : 0);
                    }
                }
                s.akK().a(akVar);
            } else {
                s.akK().a(nVar.alb());
            }
        }
        return dVar.getView();
    }

    private aa b(n nVar) {
        aa aaVar = null;
        if (nVar != null) {
            aaVar = new aa();
            aaVar.mLocate = "1";
            aaVar.bBb = nVar.tid;
            if (nVar.VM() != null) {
                aaVar.cXh = String.valueOf(nVar.VM().getFid());
                if (nVar.VM().zl() != null) {
                    aaVar.guu = nVar.VM().zl().video_md5;
                }
            }
            aaVar.aLh = nVar.getExtra();
            aaVar.mSource = nVar.getSource();
            aaVar.gut = nVar.akU();
            aaVar.gur = nVar.getWeight();
        }
        return aaVar;
    }

    public void setEventCallback(c.a aVar) {
        this.bMW = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.efH = eVar;
    }

    public void setCardShowType(int i) {
        this.cardShowType = i;
    }
}
