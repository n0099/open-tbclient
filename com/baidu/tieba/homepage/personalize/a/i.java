package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.v;
import com.baidu.tieba.play.y;
/* loaded from: classes2.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, c<n>> implements com.baidu.tieba.a.f {
    public BdUniqueId aTr;
    private NEGFeedBackView.a aYO;
    private String bvX;
    private ab dAP;
    private n dEE;
    private com.baidu.tieba.homepage.personalize.model.e dEz;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view2, com.baidu.tieba.card.data.l lVar) {
        if (view2.getId() == this.dEE.getView().getId()) {
            TiebaStatic.log(lVar.O(lVar.bji));
        } else if (this.dEE.bwk != null && this.dEE.bwk.getBarNameTv() != null && view2.getId() == this.dEE.bwk.getBarNameTv().getId()) {
            TiebaStatic.log(lVar.afU());
        } else if (this.dEE.bwZ != null && this.dEE.bwZ.apF != null && view2.getId() == this.dEE.bwZ.apF.getId()) {
            TiebaStatic.log(lVar.afU());
        } else if (this.dEE.getHeaderImg() != null && view2.getId() == this.dEE.getHeaderImg().getId()) {
            TiebaStatic.log(lVar.P(lVar.bji));
        } else if (this.dEE.afc() != null && view2.getId() == this.dEE.afc().getId()) {
            TiebaStatic.log(lVar.P(lVar.bji));
        } else if (this.dEE.bwk != null && this.dEE.bwk.getCommentContainer() != null && view2.getId() == this.dEE.bwk.getCommentContainer().getId()) {
            TiebaStatic.log(lVar.O(lVar.bji));
        } else if (this.dEE.clX != null && view2.getId() == this.dEE.clX.getId()) {
            TiebaStatic.log(lVar.O(lVar.bji));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view2, com.baidu.tieba.card.data.l lVar) {
        if (view2 instanceof TbImageView) {
            TiebaStatic.log(new al("c11004").ac("tid", lVar.bji.getTid()));
        } else if (view2.getId() == this.dEE.getView().getId()) {
            if (lVar.bji.sQ() != null && lVar.bji.sQ().channelId > 0) {
                lVar.p("c11929", true);
            }
            TiebaStatic.log(new al("c11004").ac("tid", lVar.bji.getTid()));
            TiebaStatic.log(new al("c10806").r("obj_locate", 1).ac("tid", lVar.bji.getId()));
            TiebaStatic.log(lVar.O(lVar.bji));
        } else {
            TiebaStatic.log(new al("c11004").ac("tid", lVar.bji.getTid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aYO = null;
        this.dAP = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, com.baidu.tieba.card.data.l lVar) {
                v.afy().cB(true);
                if (i.this.dEz != null && lVar != null && lVar.Pe() != null && !StringUtils.isNull(lVar.Pe().getTid()) && i.this.dEE != null && i.this.dEE.getView() != null) {
                    if (lVar.Pe().abJ > 0) {
                        TiebaStatic.log(lVar.O(lVar.Pe()));
                        return;
                    }
                    if ((view2.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.e.bK(com.baidu.adp.lib.g.b.c(lVar.Pe().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.e.bJ(com.baidu.adp.lib.g.b.c(lVar.Pe().getTid(), 0L));
                        i.this.dEz.a(com.baidu.adp.lib.g.b.c(lVar.Pe().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.afI(), lVar.afK(), com.baidu.adp.lib.g.b.g((String) view2.getTag(), 1));
                    }
                    if (i.this.mType == com.baidu.tieba.card.data.l.crZ) {
                        i.this.b(view2, lVar);
                    } else if (i.this.mType == com.baidu.tieba.card.data.l.csa) {
                        i.this.c(view2, lVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        axZ();
    }

    private void axZ() {
        com.baidu.tieba.card.data.l.csb = "c10708";
        com.baidu.tieba.card.data.l.csc = "c10735";
        com.baidu.tieba.card.data.l.csd = "c10756";
        com.baidu.tieba.card.data.l.cse = "c10709";
        com.baidu.tieba.card.data.l.csf = "c10734";
        com.baidu.tieba.card.data.l.csg = "c11929";
        com.baidu.tieba.card.data.l.csh = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aP */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        this.dEE = new n(this.mPageContext);
        this.dEE.currentPageType = 2;
        if (this.dEE.bwk != null) {
            this.dEE.bwk.abV = 2;
        }
        if (this.dEE.bwZ != null && this.dEE.bwZ.apG != null) {
            this.dEE.bwZ.apG.abV = 2;
        }
        this.dEE.j(this.aTr);
        this.dEE.b(this.dAP);
        return new c(this.dEE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, c cVar) {
        if (lVar != null) {
            lVar.iN(i + 1);
            lVar.sourceType = 0;
        }
        cVar.afY().setVideoStatsData(b(lVar));
        if (cVar.afY() instanceof com.baidu.tieba.a.e) {
            cVar.afY().setPage(this.bvX);
        }
        cVar.afY().a(lVar);
        cVar.afY().a(this.aYO);
        if (lVar != null) {
            if (getType() != null && getType() == com.baidu.tieba.card.data.l.csa) {
                v.afy().a(lVar.afS());
                al alVar = new al("c11003");
                bd Pe = lVar.Pe();
                if (Pe != null) {
                    alVar.ac("tid", Pe.getTid());
                    if (Pe.rQ() != null) {
                        alVar.r("ab_type", Pe.rQ().hadConcerned() ? 1 : 0);
                    }
                }
                v.afy().a(alVar);
            } else {
                v.afy().a(lVar.afS());
            }
        }
        return cVar.getView();
    }

    private y b(com.baidu.tieba.card.data.l lVar) {
        y yVar = null;
        if (lVar != null) {
            yVar = new y();
            yVar.mLocate = "1";
            yVar.aNu = lVar.tid;
            if (lVar.Pe() != null) {
                yVar.crG = String.valueOf(lVar.Pe().getFid());
                if (lVar.Pe().sh() != null) {
                    yVar.fQN = lVar.Pe().sh().video_md5;
                    yVar.fQP = String.valueOf(lVar.Pe().sh().is_vertical);
                }
            }
            yVar.XM = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.fQM = lVar.afK();
            yVar.fQK = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
        }
        return yVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.aYO = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dEz = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void hY(String str) {
        this.bvX = str;
    }
}
