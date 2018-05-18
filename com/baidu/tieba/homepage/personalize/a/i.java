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
    public BdUniqueId aTs;
    private NEGFeedBackView.a aYP;
    private String bwO;
    private ab dBW;
    private com.baidu.tieba.homepage.personalize.model.e dFF;
    private n dFK;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view2, com.baidu.tieba.card.data.l lVar) {
        if (view2.getId() == this.dFK.getView().getId()) {
            TiebaStatic.log(lVar.O(lVar.bjy));
        } else if (this.dFK.bxb != null && this.dFK.bxb.getBarNameTv() != null && view2.getId() == this.dFK.bxb.getBarNameTv().getId()) {
            TiebaStatic.log(lVar.afU());
        } else if (this.dFK.bxQ != null && this.dFK.bxQ.apF != null && view2.getId() == this.dFK.bxQ.apF.getId()) {
            TiebaStatic.log(lVar.afU());
        } else if (this.dFK.getHeaderImg() != null && view2.getId() == this.dFK.getHeaderImg().getId()) {
            TiebaStatic.log(lVar.P(lVar.bjy));
        } else if (this.dFK.afc() != null && view2.getId() == this.dFK.afc().getId()) {
            TiebaStatic.log(lVar.P(lVar.bjy));
        } else if (this.dFK.bxb != null && this.dFK.bxb.getCommentContainer() != null && view2.getId() == this.dFK.bxb.getCommentContainer().getId()) {
            TiebaStatic.log(lVar.O(lVar.bjy));
        } else if (this.dFK.cnh != null && view2.getId() == this.dFK.cnh.getId()) {
            TiebaStatic.log(lVar.O(lVar.bjy));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view2, com.baidu.tieba.card.data.l lVar) {
        if (view2 instanceof TbImageView) {
            TiebaStatic.log(new al("c11004").ac("tid", lVar.bjy.getTid()));
        } else if (view2.getId() == this.dFK.getView().getId()) {
            if (lVar.bjy.sP() != null && lVar.bjy.sP().channelId > 0) {
                lVar.p("c11929", true);
            }
            TiebaStatic.log(new al("c11004").ac("tid", lVar.bjy.getTid()));
            TiebaStatic.log(new al("c10806").r("obj_locate", 1).ac("tid", lVar.bjy.getId()));
            TiebaStatic.log(lVar.O(lVar.bjy));
        } else {
            TiebaStatic.log(new al("c11004").ac("tid", lVar.bjy.getTid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aYP = null;
        this.dBW = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, com.baidu.tieba.card.data.l lVar) {
                v.afy().cB(true);
                if (i.this.dFF != null && lVar != null && lVar.Pb() != null && !StringUtils.isNull(lVar.Pb().getTid()) && i.this.dFK != null && i.this.dFK.getView() != null) {
                    if (lVar.Pb().abK > 0) {
                        TiebaStatic.log(lVar.O(lVar.Pb()));
                        return;
                    }
                    if ((view2.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.e.bK(com.baidu.adp.lib.g.b.c(lVar.Pb().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.e.bJ(com.baidu.adp.lib.g.b.c(lVar.Pb().getTid(), 0L));
                        i.this.dFF.a(com.baidu.adp.lib.g.b.c(lVar.Pb().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.afI(), lVar.afK(), com.baidu.adp.lib.g.b.g((String) view2.getTag(), 1));
                    }
                    if (i.this.mType == com.baidu.tieba.card.data.l.cti) {
                        i.this.b(view2, lVar);
                    } else if (i.this.mType == com.baidu.tieba.card.data.l.ctj) {
                        i.this.c(view2, lVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        axX();
    }

    private void axX() {
        com.baidu.tieba.card.data.l.ctk = "c10708";
        com.baidu.tieba.card.data.l.ctl = "c10735";
        com.baidu.tieba.card.data.l.ctm = "c10756";
        com.baidu.tieba.card.data.l.ctn = "c10709";
        com.baidu.tieba.card.data.l.cto = "c10734";
        com.baidu.tieba.card.data.l.ctp = "c11929";
        com.baidu.tieba.card.data.l.ctq = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aP */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        this.dFK = new n(this.mPageContext);
        this.dFK.currentPageType = 2;
        if (this.dFK.bxb != null) {
            this.dFK.bxb.abW = 2;
        }
        if (this.dFK.bxQ != null && this.dFK.bxQ.apG != null) {
            this.dFK.bxQ.apG.abW = 2;
        }
        this.dFK.j(this.aTs);
        this.dFK.b(this.dBW);
        return new c(this.dFK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, c cVar) {
        if (lVar != null) {
            lVar.iM(i + 1);
            lVar.sourceType = 0;
        }
        cVar.afY().setVideoStatsData(b(lVar));
        if (cVar.afY() instanceof com.baidu.tieba.a.e) {
            cVar.afY().setPage(this.bwO);
        }
        cVar.afY().a(lVar);
        cVar.afY().a(this.aYP);
        if (lVar != null) {
            if (getType() != null && getType() == com.baidu.tieba.card.data.l.ctj) {
                v.afy().a(lVar.afS());
                al alVar = new al("c11003");
                bd Pb = lVar.Pb();
                if (Pb != null) {
                    alVar.ac("tid", Pb.getTid());
                    if (Pb.rP() != null) {
                        alVar.r("ab_type", Pb.rP().hadConcerned() ? 1 : 0);
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
            yVar.aNv = lVar.tid;
            if (lVar.Pb() != null) {
                yVar.csP = String.valueOf(lVar.Pb().getFid());
                if (lVar.Pb().sg() != null) {
                    yVar.fRT = lVar.Pb().sg().video_md5;
                    yVar.fRV = String.valueOf(lVar.Pb().sg().is_vertical);
                }
            }
            yVar.XN = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.fRS = lVar.afK();
            yVar.fRQ = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
        }
        return yVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.aYP = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dFF = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void hZ(String str) {
        this.bwO = str;
    }
}
