package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.v;
import com.baidu.tieba.play.y;
/* loaded from: classes2.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, c<n>> implements com.baidu.tieba.a.f {
    public BdUniqueId aRC;
    private String bHB;
    private NEGFeedBackView.a bjc;
    private ad dTe;
    private com.baidu.tieba.homepage.personalize.model.e dYk;
    private n dYp;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        if (view.getId() == this.dYp.getView().getId()) {
            TiebaStatic.log(lVar.S(lVar.btL));
        } else if (this.dYp.bHO != null && this.dYp.bHO.getBarNameTv() != null && view.getId() == this.dYp.bHO.getBarNameTv().getId()) {
            TiebaStatic.log(lVar.ajy());
        } else if (this.dYp.bIC != null && this.dYp.bIC.ayn != null && view.getId() == this.dYp.bIC.ayn.getId()) {
            TiebaStatic.log(lVar.ajy());
        } else if (this.dYp.getHeaderImg() != null && view.getId() == this.dYp.getHeaderImg().getId()) {
            TiebaStatic.log(lVar.T(lVar.btL));
        } else if (this.dYp.aiF() != null && view.getId() == this.dYp.aiF().getId()) {
            TiebaStatic.log(lVar.T(lVar.btL));
        } else if (this.dYp.bHO != null && this.dYp.bHO.getCommentContainer() != null && view.getId() == this.dYp.bHO.getCommentContainer().getId()) {
            TiebaStatic.log(lVar.S(lVar.btL));
        } else if (this.dYp.cws != null && view.getId() == this.dYp.cws.getId()) {
            TiebaStatic.log(lVar.S(lVar.btL));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, com.baidu.tieba.card.data.l lVar) {
        if (view instanceof TbImageView) {
            TiebaStatic.log(new an("c11004").ae("tid", lVar.btL.getTid()));
        } else if (view.getId() == this.dYp.getView().getId()) {
            if (lVar.btL.wk() != null && lVar.btL.wk().channelId > 0) {
                lVar.o("c11929", true);
            }
            TiebaStatic.log(new an("c11004").ae("tid", lVar.btL.getTid()));
            TiebaStatic.log(new an("c10806").r("obj_locate", 1).ae("tid", lVar.btL.getId()));
            TiebaStatic.log(lVar.S(lVar.btL));
        } else {
            TiebaStatic.log(new an("c11004").ae("tid", lVar.btL.getTid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bjc = null;
        this.dTe = new ad<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                v.ajb().cL(true);
                if (i.this.dYk != null && lVar != null && lVar.Tg() != null && !StringUtils.isNull(lVar.Tg().getTid()) && i.this.dYp != null && i.this.dYp.getView() != null) {
                    if (lVar.Tg().ajF > 0) {
                        TiebaStatic.log(lVar.S(lVar.Tg()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.e.bR(com.baidu.adp.lib.g.b.c(lVar.Tg().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.e.bQ(com.baidu.adp.lib.g.b.c(lVar.Tg().getTid(), 0L));
                        i.this.dYk.a(com.baidu.adp.lib.g.b.c(lVar.Tg().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.ajl(), lVar.ajn(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (i.this.mType == com.baidu.tieba.card.data.l.cCk) {
                        i.this.b(view, lVar);
                    } else if (i.this.mType == com.baidu.tieba.card.data.l.cCl) {
                        i.this.c(view, lVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aEu();
    }

    private void aEu() {
        com.baidu.tieba.card.data.l.cCm = "c10708";
        com.baidu.tieba.card.data.l.cCn = "c10735";
        com.baidu.tieba.card.data.l.cCo = "c10709";
        com.baidu.tieba.card.data.l.cCp = "c10734";
        com.baidu.tieba.card.data.l.cCq = "c11929";
        com.baidu.tieba.card.data.l.cCr = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aP */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        this.dYp = new n(this.mPageContext);
        this.dYp.currentPageType = 2;
        if (this.dYp.bHO != null) {
            this.dYp.bHO.ajY = 2;
        }
        if (this.dYp.bIC != null && this.dYp.bIC.ayo != null) {
            this.dYp.bIC.ayo.ajY = 2;
        }
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.n() { // from class: com.baidu.tieba.homepage.personalize.a.i.2
            @Override // com.baidu.adp.widget.ListView.n
            public void a(View view, com.baidu.adp.widget.ListView.h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                n ajC;
                if ((view.getTag() instanceof c) && (ajC = ((c) view.getTag()).ajC()) != null) {
                    ajC.onClick(ajC.getView());
                }
            }
        });
        this.dYp.j(this.aRC);
        this.dYp.b(this.dTe);
        return new c(this.dYp);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, c cVar) {
        if (lVar != null) {
            lVar.iW(i + 1);
            lVar.sourceType = 0;
        }
        cVar.ajC().setVideoStatsData(b(lVar));
        if (cVar.ajC() instanceof com.baidu.tieba.a.e) {
            cVar.ajC().setPage(this.bHB);
        }
        cVar.ajC().a(lVar);
        cVar.ajC().a(this.bjc);
        if (lVar != null) {
            if (getType() != null && getType() == com.baidu.tieba.card.data.l.cCl) {
                v.ajb().a(lVar.ajw());
                an anVar = new an("c11003");
                bb Tg = lVar.Tg();
                if (Tg != null) {
                    anVar.ae("tid", Tg.getTid());
                    if (Tg.vj() != null) {
                        anVar.r("ab_type", Tg.vj().hadConcerned() ? 1 : 0);
                    }
                }
                v.ajb().a(anVar);
            } else {
                v.ajb().a(lVar.ajw());
            }
        }
        return cVar.getView();
    }

    private y b(com.baidu.tieba.card.data.l lVar) {
        y yVar = null;
        if (lVar != null) {
            yVar = new y();
            yVar.mLocate = "1";
            yVar.aWq = lVar.tid;
            if (lVar.Tg() != null) {
                yVar.cBR = String.valueOf(lVar.Tg().getFid());
                if (lVar.Tg().vB() != null) {
                    yVar.ghF = lVar.Tg().vB().video_md5;
                    yVar.ghH = String.valueOf(lVar.Tg().vB().is_vertical);
                }
            }
            yVar.afx = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.ghE = lVar.ajn();
            yVar.ghC = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
        }
        return yVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bjc = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dYk = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void iB(String str) {
        this.bHB = str;
    }
}
