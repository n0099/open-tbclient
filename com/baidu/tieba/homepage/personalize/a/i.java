package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.v;
import com.baidu.tieba.play.y;
/* loaded from: classes2.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, c<n>> implements com.baidu.tieba.a.f {
    public BdUniqueId aUU;
    private String bNq;
    private NEGFeedBackView.a boM;
    private ad eav;
    private com.baidu.tieba.homepage.personalize.model.e efE;
    private n efK;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        if (view.getId() == this.efK.getView().getId()) {
            TiebaStatic.log(lVar.T(lVar.bzB));
        } else if (this.efK.bND != null && this.efK.bND.getBarNameTv() != null && view.getId() == this.efK.bND.getBarNameTv().getId()) {
            TiebaStatic.log(lVar.alj());
        } else if (this.efK.bOr != null && this.efK.bOr.aBk != null && view.getId() == this.efK.bOr.aBk.getId()) {
            TiebaStatic.log(lVar.alj());
        } else if (this.efK.getHeaderImg() != null && view.getId() == this.efK.getHeaderImg().getId()) {
            TiebaStatic.log(lVar.U(lVar.bzB));
        } else if (this.efK.akp() != null && view.getId() == this.efK.akp().getId()) {
            TiebaStatic.log(lVar.U(lVar.bzB));
        } else if (this.efK.bND != null && this.efK.bND.getCommentContainer() != null && view.getId() == this.efK.bND.getCommentContainer().getId()) {
            TiebaStatic.log(lVar.T(lVar.bzB));
        } else if (this.efK.cCi != null && view.getId() == this.efK.cCi.getId()) {
            TiebaStatic.log(lVar.T(lVar.bzB));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, com.baidu.tieba.card.data.l lVar) {
        if (view instanceof TbImageView) {
            TiebaStatic.log(new am("c11004").al("tid", lVar.bzB.getTid()));
        } else if (view.getId() == this.efK.getView().getId()) {
            if (lVar.bzB.xp() != null && lVar.bzB.xp().channelId > 0) {
                lVar.p("c11929", true);
            }
            TiebaStatic.log(new am("c11004").al("tid", lVar.bzB.getTid()));
            TiebaStatic.log(new am("c10806").w("obj_locate", 1).al("tid", lVar.bzB.getId()));
            TiebaStatic.log(lVar.T(lVar.bzB));
        } else {
            TiebaStatic.log(new am("c11004").al("tid", lVar.bzB.getTid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.boM = null;
        this.eav = new ad<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                v.akM().dc(true);
                if (i.this.efE != null && lVar != null && lVar.UT() != null && !StringUtils.isNull(lVar.UT().getTid()) && i.this.efK != null && i.this.efK.getView() != null) {
                    if (lVar.UT().amj > 0) {
                        TiebaStatic.log(lVar.T(lVar.UT()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.bV(com.baidu.adp.lib.g.b.d(lVar.UT().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.bU(com.baidu.adp.lib.g.b.d(lVar.UT().getTid(), 0L));
                        i.this.efE.a(com.baidu.adp.lib.g.b.d(lVar.UT().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.akW(), lVar.akY(), com.baidu.adp.lib.g.b.l((String) view.getTag(), 1));
                    }
                    if (i.this.mType == com.baidu.tieba.card.data.l.cIb) {
                        i.this.b(view, lVar);
                    } else if (i.this.mType == com.baidu.tieba.card.data.l.cIc) {
                        i.this.c(view, lVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aGJ();
    }

    private void aGJ() {
        com.baidu.tieba.card.data.l.cId = "c10708";
        com.baidu.tieba.card.data.l.cIe = "c10735";
        com.baidu.tieba.card.data.l.cIf = "c10709";
        com.baidu.tieba.card.data.l.cIg = "c10734";
        com.baidu.tieba.card.data.l.cIh = "c11929";
        com.baidu.tieba.card.data.l.cIi = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aP */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        final n nVar = new n(this.mPageContext);
        nVar.currentPageType = 2;
        if (nVar.bND != null) {
            nVar.bND.amD = 2;
        }
        if (nVar.bOr != null && nVar.bOr.aBl != null) {
            nVar.bOr.aBl.amD = 2;
        }
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.n() { // from class: com.baidu.tieba.homepage.personalize.a.i.2
            @Override // com.baidu.adp.widget.ListView.n
            public void a(View view, com.baidu.adp.widget.ListView.h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                n aln;
                if ((view.getTag() instanceof c) && (aln = ((c) view.getTag()).aln()) != null) {
                    aln.onClick(aln.getView());
                }
            }
        });
        if (!isPreloadSizeReady(1)) {
            nVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.homepage.personalize.a.i.3
                @Override // com.baidu.adp.widget.a.b
                public void k(int i, int i2, int i3) {
                    i.this.setPreloadSize(i, i2, i3);
                    if (i.this.isPreloadSizeReady(1)) {
                        nVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        nVar.j(this.aUU);
        nVar.b(this.eav);
        this.efK = nVar;
        return new c(this.efK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, c cVar) {
        if (lVar != null) {
            lVar.jv(i + 1);
            lVar.sourceType = 0;
        }
        cVar.aln().setVideoStatsData(b(lVar));
        if (cVar.aln() instanceof com.baidu.tieba.a.e) {
            cVar.aln().setPage(this.bNq);
        }
        cVar.aln().a(lVar);
        cVar.aln().a(this.boM);
        if (lVar != null) {
            if (getType() != null && getType() == com.baidu.tieba.card.data.l.cIc) {
                v.akM().a(lVar.alh());
                am amVar = new am("c11003");
                bb UT = lVar.UT();
                if (UT != null) {
                    amVar.al("tid", UT.getTid());
                    if (UT.wm() != null) {
                        amVar.w("ab_type", UT.wm().hadConcerned() ? 1 : 0);
                    }
                }
                v.akM().a(amVar);
            } else {
                v.akM().a(lVar.alh());
            }
        }
        return cVar.getView();
    }

    private y b(com.baidu.tieba.card.data.l lVar) {
        y yVar = null;
        if (lVar != null) {
            yVar = new y();
            yVar.mLocate = "1";
            yVar.aZG = lVar.tid;
            if (lVar.UT() != null) {
                yVar.cHI = String.valueOf(lVar.UT().getFid());
                if (lVar.UT().wE() != null) {
                    yVar.goY = lVar.UT().wE().video_md5;
                    yVar.gpa = String.valueOf(lVar.UT().wE().is_vertical);
                }
            }
            yVar.ahY = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.goX = lVar.akY();
            yVar.goV = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
        }
        return yVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.boM = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.efE = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void jd(String str) {
        this.bNq = str;
    }
}
