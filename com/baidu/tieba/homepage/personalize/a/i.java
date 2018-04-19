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
    private ab dAS;
    private com.baidu.tieba.homepage.personalize.model.e dEC;
    private n dEH;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view2, com.baidu.tieba.card.data.l lVar) {
        if (view2.getId() == this.dEH.getView().getId()) {
            TiebaStatic.log(lVar.O(lVar.bji));
        } else if (this.dEH.bwk != null && this.dEH.bwk.getBarNameTv() != null && view2.getId() == this.dEH.bwk.getBarNameTv().getId()) {
            TiebaStatic.log(lVar.afU());
        } else if (this.dEH.bwZ != null && this.dEH.bwZ.apF != null && view2.getId() == this.dEH.bwZ.apF.getId()) {
            TiebaStatic.log(lVar.afU());
        } else if (this.dEH.getHeaderImg() != null && view2.getId() == this.dEH.getHeaderImg().getId()) {
            TiebaStatic.log(lVar.P(lVar.bji));
        } else if (this.dEH.afc() != null && view2.getId() == this.dEH.afc().getId()) {
            TiebaStatic.log(lVar.P(lVar.bji));
        } else if (this.dEH.bwk != null && this.dEH.bwk.getCommentContainer() != null && view2.getId() == this.dEH.bwk.getCommentContainer().getId()) {
            TiebaStatic.log(lVar.O(lVar.bji));
        } else if (this.dEH.cma != null && view2.getId() == this.dEH.cma.getId()) {
            TiebaStatic.log(lVar.O(lVar.bji));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view2, com.baidu.tieba.card.data.l lVar) {
        if (view2 instanceof TbImageView) {
            TiebaStatic.log(new al("c11004").ac("tid", lVar.bji.getTid()));
        } else if (view2.getId() == this.dEH.getView().getId()) {
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
        this.dAS = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, com.baidu.tieba.card.data.l lVar) {
                v.afy().cB(true);
                if (i.this.dEC != null && lVar != null && lVar.Pe() != null && !StringUtils.isNull(lVar.Pe().getTid()) && i.this.dEH != null && i.this.dEH.getView() != null) {
                    if (lVar.Pe().abJ > 0) {
                        TiebaStatic.log(lVar.O(lVar.Pe()));
                        return;
                    }
                    if ((view2.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.e.bK(com.baidu.adp.lib.g.b.c(lVar.Pe().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.e.bJ(com.baidu.adp.lib.g.b.c(lVar.Pe().getTid(), 0L));
                        i.this.dEC.a(com.baidu.adp.lib.g.b.c(lVar.Pe().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.afI(), lVar.afK(), com.baidu.adp.lib.g.b.g((String) view2.getTag(), 1));
                    }
                    if (i.this.mType == com.baidu.tieba.card.data.l.csc) {
                        i.this.b(view2, lVar);
                    } else if (i.this.mType == com.baidu.tieba.card.data.l.csd) {
                        i.this.c(view2, lVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        axZ();
    }

    private void axZ() {
        com.baidu.tieba.card.data.l.cse = "c10708";
        com.baidu.tieba.card.data.l.csf = "c10735";
        com.baidu.tieba.card.data.l.csg = "c10756";
        com.baidu.tieba.card.data.l.csh = "c10709";
        com.baidu.tieba.card.data.l.csi = "c10734";
        com.baidu.tieba.card.data.l.csj = "c11929";
        com.baidu.tieba.card.data.l.csk = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aP */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        this.dEH = new n(this.mPageContext);
        this.dEH.currentPageType = 2;
        if (this.dEH.bwk != null) {
            this.dEH.bwk.abV = 2;
        }
        if (this.dEH.bwZ != null && this.dEH.bwZ.apG != null) {
            this.dEH.bwZ.apG.abV = 2;
        }
        this.dEH.j(this.aTr);
        this.dEH.b(this.dAS);
        return new c(this.dEH);
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
            if (getType() != null && getType() == com.baidu.tieba.card.data.l.csd) {
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
                yVar.crJ = String.valueOf(lVar.Pe().getFid());
                if (lVar.Pe().sh() != null) {
                    yVar.fQQ = lVar.Pe().sh().video_md5;
                    yVar.fQS = String.valueOf(lVar.Pe().sh().is_vertical);
                }
            }
            yVar.XM = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.fQP = lVar.afK();
            yVar.fQN = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
        }
        return yVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.aYO = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dEC = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void hY(String str) {
        this.bvX = str;
    }
}
