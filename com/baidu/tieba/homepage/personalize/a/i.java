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
import com.baidu.tieba.play.z;
/* loaded from: classes6.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, c<n>> implements com.baidu.tieba.a.f {
    private String bWE;
    public BdUniqueId bag;
    private NEGFeedBackView.a btz;
    private ad ejJ;
    private com.baidu.tieba.homepage.personalize.model.e eoS;
    private n eoY;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        if (view.getId() == this.eoY.getView().getId()) {
            TiebaStatic.log(lVar.T(lVar.bIU));
        } else if (this.eoY.bWR != null && this.eoY.bWR.getBarNameTv() != null && view.getId() == this.eoY.bWR.getBarNameTv().getId()) {
            TiebaStatic.log(lVar.aon());
        } else if (this.eoY.bXE != null && this.eoY.bXE.aGH != null && view.getId() == this.eoY.bXE.aGH.getId()) {
            TiebaStatic.log(lVar.aon());
        } else if (this.eoY.getHeaderImg() != null && view.getId() == this.eoY.getHeaderImg().getId()) {
            TiebaStatic.log(lVar.U(lVar.bIU));
        } else if (this.eoY.ant() != null && view.getId() == this.eoY.ant().getId()) {
            TiebaStatic.log(lVar.U(lVar.bIU));
        } else if (this.eoY.bWR != null && this.eoY.bWR.getCommentContainer() != null && view.getId() == this.eoY.bWR.getCommentContainer().getId()) {
            TiebaStatic.log(lVar.T(lVar.bIU));
        } else if (this.eoY.cLJ != null && view.getId() == this.eoY.cLJ.getId()) {
            TiebaStatic.log(lVar.T(lVar.bIU));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, com.baidu.tieba.card.data.l lVar) {
        if (view instanceof TbImageView) {
            TiebaStatic.log(new am("c11004").ax("tid", lVar.bIU.getTid()));
        } else if (view.getId() == this.eoY.getView().getId()) {
            if (lVar.bIU.zF() != null && lVar.bIU.zF().channelId > 0) {
                lVar.w("c11929", true);
            }
            TiebaStatic.log(new am("c11004").ax("tid", lVar.bIU.getTid()));
            TiebaStatic.log(new am("c10806").x("obj_locate", 1).ax("tid", lVar.bIU.getId()));
            TiebaStatic.log(lVar.T(lVar.bIU));
        } else {
            TiebaStatic.log(new am("c11004").ax("tid", lVar.bIU.getTid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.btz = null;
        this.ejJ = new ad<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                v.anQ().dP(true);
                if (i.this.eoS != null && lVar != null && lVar.YL() != null && !StringUtils.isNull(lVar.YL().getTid()) && i.this.eoY != null && i.this.eoY.getView() != null) {
                    if (lVar.YL().arR > 0) {
                        TiebaStatic.log(lVar.T(lVar.YL()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.bX(com.baidu.adp.lib.g.b.d(lVar.YL().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.bW(com.baidu.adp.lib.g.b.d(lVar.YL().getTid(), 0L));
                        i.this.eoS.a(com.baidu.adp.lib.g.b.d(lVar.YL().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.aoa(), lVar.aoc(), com.baidu.adp.lib.g.b.l((String) view.getTag(), 1));
                    }
                    if (i.this.mType == com.baidu.tieba.card.data.l.cRA) {
                        i.this.b(view, lVar);
                    } else if (i.this.mType == com.baidu.tieba.card.data.l.cRB) {
                        i.this.c(view, lVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aJz();
    }

    private void aJz() {
        com.baidu.tieba.card.data.l.cRC = "c10708";
        com.baidu.tieba.card.data.l.cRD = "c10735";
        com.baidu.tieba.card.data.l.cRE = "c10709";
        com.baidu.tieba.card.data.l.cRF = "c10734";
        com.baidu.tieba.card.data.l.cRG = "c11929";
        com.baidu.tieba.card.data.l.cRH = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        final n nVar = new n(this.mPageContext);
        nVar.currentPageType = 2;
        if (nVar.bWR != null) {
            nVar.bWR.asl = 2;
        }
        if (nVar.bXE != null && nVar.bXE.aGI != null) {
            nVar.bXE.aGI.asl = 2;
        }
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.n() { // from class: com.baidu.tieba.homepage.personalize.a.i.2
            @Override // com.baidu.adp.widget.ListView.n
            public void a(View view, com.baidu.adp.widget.ListView.h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                n aor;
                if ((view.getTag() instanceof c) && (aor = ((c) view.getTag()).aor()) != null) {
                    aor.onClick(aor.getView());
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
        nVar.j(this.bag);
        nVar.b(this.ejJ);
        this.eoY = nVar;
        return new c(this.eoY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, c cVar) {
        if (lVar != null) {
            lVar.km(i + 1);
            lVar.sourceType = 0;
        }
        cVar.aor().setVideoStatsData(b(lVar));
        if (cVar.aor() instanceof com.baidu.tieba.a.e) {
            cVar.aor().setPage(this.bWE);
        }
        cVar.aor().a(lVar);
        cVar.aor().a(this.btz);
        if (lVar != null) {
            if (getType() != null && getType() == com.baidu.tieba.card.data.l.cRB) {
                v.anQ().a(lVar.aol());
                am amVar = new am("c11003");
                bb YL = lVar.YL();
                if (YL != null) {
                    amVar.ax("tid", YL.getTid());
                    if (YL.yC() != null) {
                        amVar.x("ab_type", YL.yC().hadConcerned() ? 1 : 0);
                    }
                }
                v.anQ().a(amVar);
            } else {
                v.anQ().a(lVar.aol());
            }
        }
        return cVar.getView();
    }

    private z b(com.baidu.tieba.card.data.l lVar) {
        z zVar = null;
        if (lVar != null) {
            zVar = new z();
            zVar.mLocate = "1";
            zVar.beV = lVar.tid;
            if (lVar.YL() != null) {
                zVar.cRh = String.valueOf(lVar.YL().getFid());
                if (lVar.YL().yU() != null) {
                    zVar.gyb = lVar.YL().yU().video_md5;
                    zVar.gyd = String.valueOf(lVar.YL().yU().is_vertical);
                }
            }
            zVar.anG = lVar.getExtra();
            zVar.mSource = lVar.getSource();
            zVar.gya = lVar.aoc();
            zVar.gxY = lVar.getWeight();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
        }
        return zVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.btz = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.eoS = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void js(String str) {
        this.bWE = str;
    }
}
