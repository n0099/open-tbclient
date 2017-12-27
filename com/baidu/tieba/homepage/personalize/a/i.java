package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.be;
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
    public BdUniqueId bGo;
    private c.a bMG;
    private v ear;
    private com.baidu.tieba.homepage.personalize.model.e edY;
    private com.baidu.tieba.card.j eed;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, n nVar) {
        if (view.getId() == this.eed.getView().getId()) {
            TiebaStatic.log(nVar.K(nVar.bWT));
        } else if (this.eed.ciE != null && this.eed.ciE.getBarNameTv() != null && view.getId() == this.eed.ciE.getBarNameTv().getId()) {
            TiebaStatic.log(nVar.ajV());
        } else if (this.eed.getHeaderImg() != null && view.getId() == this.eed.getHeaderImg().getId()) {
            TiebaStatic.log(nVar.L(nVar.bWT));
        } else if (this.eed.ajb() != null && view.getId() == this.eed.ajb().getId()) {
            TiebaStatic.log(nVar.L(nVar.bWT));
        } else if (this.eed.ciE != null && this.eed.ciE.getCommentContainer() != null && view.getId() == this.eed.ciE.getCommentContainer().getId()) {
            TiebaStatic.log(nVar.K(nVar.bWT));
        } else if (this.eed.cNP != null && view.getId() == this.eed.cNP.getId()) {
            TiebaStatic.log(nVar.K(nVar.bWT));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, n nVar) {
        if (view instanceof TbImageView) {
            TiebaStatic.log(new ak("c11004").ab("tid", nVar.bWT.getTid()));
        } else if (view.getId() == this.eed.getView().getId()) {
            if (nVar.bWT.Ac() != null && nVar.bWT.Ac().channelId > 0) {
                nVar.t("c11929", true);
            }
            TiebaStatic.log(new ak("c11004").ab("tid", nVar.bWT.getTid()));
            TiebaStatic.log(new ak("c10806").s("obj_locate", 1).ab("tid", nVar.bWT.getId()));
            TiebaStatic.log(nVar.K(nVar.bWT));
        } else {
            TiebaStatic.log(new ak("c11004").ab("tid", nVar.bWT.getTid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bMG = null;
        this.ear = new v<n>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, n nVar) {
                s.ajC().df(true);
                if (i.this.edY != null && nVar != null && nVar.VW() != null && !StringUtils.isNull(nVar.VW().getTid()) && i.this.eed != null && i.this.eed.getView() != null) {
                    if (nVar.VW().aOZ > 0) {
                        TiebaStatic.log(nVar.K(nVar.VW()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.g.bM(com.baidu.adp.lib.g.b.c(nVar.VW().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.g.bL(com.baidu.adp.lib.g.b.c(nVar.VW().getTid(), 0L));
                        i.this.edY.a(com.baidu.adp.lib.g.b.c(nVar.VW().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.ajK(), nVar.ajM(), com.baidu.adp.lib.g.b.h((String) view.getTag(), 1));
                    }
                    if (i.this.mType == n.cSG) {
                        i.this.b(view, nVar);
                    } else if (i.this.mType == n.cSH) {
                        i.this.c(view, nVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aBx();
    }

    private void aBx() {
        n.cSI = "c10708";
        n.cSJ = "c10735";
        n.cSK = "c10756";
        n.cSL = "c10709";
        n.cSM = "c10734";
        n.cSN = "c11929";
        n.cSO = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aO */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        this.eed = new com.baidu.tieba.card.j(this.mPageContext);
        this.eed.currentPageType = 2;
        if (this.eed.ciE != null) {
            this.eed.ciE.bbP = 2;
        }
        this.eed.j(this.bGo);
        this.eed.b(this.ear);
        return new d(this.eed);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, n nVar, d dVar) {
        if (nVar != null) {
            nVar.lE(i + 1);
            nVar.sourceType = 0;
        }
        dVar.akh().setVideoStatsData(b(nVar));
        dVar.akh().a(nVar);
        dVar.akh().a(this.bMG);
        if (nVar != null) {
            if (getType() != null && getType() == n.cSH) {
                s.ajC().a(nVar.ajT());
                ak akVar = new ak("c11003");
                be VW = nVar.VW();
                if (VW != null) {
                    akVar.ab("tid", VW.getTid());
                    if (VW.yX() != null) {
                        akVar.s("ab_type", VW.yX().hadConcerned() ? 1 : 0);
                    }
                }
            } else {
                s.ajC().a(nVar.ajT());
            }
        }
        return dVar.getView();
    }

    private aa b(n nVar) {
        aa aaVar = null;
        if (nVar != null) {
            aaVar = new aa();
            aaVar.mLocate = "1";
            aaVar.bAK = nVar.tid;
            if (nVar.VW() != null) {
                aaVar.cSk = String.valueOf(nVar.VW().getFid());
                if (nVar.VW().zp() != null) {
                    aaVar.gES = nVar.VW().zp().video_md5;
                }
            }
            aaVar.aLg = nVar.getExtra();
            aaVar.mSource = nVar.getSource();
            aaVar.gER = nVar.ajM();
            aaVar.gEP = nVar.getWeight();
        }
        return aaVar;
    }

    public void setEventCallback(c.a aVar) {
        this.bMG = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.edY = eVar;
    }
}
