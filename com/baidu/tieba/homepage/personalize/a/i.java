package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bc;
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
    public BdUniqueId aRF;
    private String bGM;
    private NEGFeedBackView.a bir;
    private ad dQw;
    private n dUA;
    private com.baidu.tieba.homepage.personalize.model.e dUv;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        if (view.getId() == this.dUA.getView().getId()) {
            TiebaStatic.log(lVar.Q(lVar.btc));
        } else if (this.dUA.bGZ != null && this.dUA.bGZ.getBarNameTv() != null && view.getId() == this.dUA.bGZ.getBarNameTv().getId()) {
            TiebaStatic.log(lVar.aiW());
        } else if (this.dUA.bHN != null && this.dUA.bHN.ayD != null && view.getId() == this.dUA.bHN.ayD.getId()) {
            TiebaStatic.log(lVar.aiW());
        } else if (this.dUA.getHeaderImg() != null && view.getId() == this.dUA.getHeaderImg().getId()) {
            TiebaStatic.log(lVar.R(lVar.btc));
        } else if (this.dUA.aid() != null && view.getId() == this.dUA.aid().getId()) {
            TiebaStatic.log(lVar.R(lVar.btc));
        } else if (this.dUA.bGZ != null && this.dUA.bGZ.getCommentContainer() != null && view.getId() == this.dUA.bGZ.getCommentContainer().getId()) {
            TiebaStatic.log(lVar.Q(lVar.btc));
        } else if (this.dUA.ctS != null && view.getId() == this.dUA.ctS.getId()) {
            TiebaStatic.log(lVar.Q(lVar.btc));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, com.baidu.tieba.card.data.l lVar) {
        if (view instanceof TbImageView) {
            TiebaStatic.log(new an("c11004").ah("tid", lVar.btc.getTid()));
        } else if (view.getId() == this.dUA.getView().getId()) {
            if (lVar.btc.ww() != null && lVar.btc.ww().channelId > 0) {
                lVar.p("c11929", true);
            }
            TiebaStatic.log(new an("c11004").ah("tid", lVar.btc.getTid()));
            TiebaStatic.log(new an("c10806").r("obj_locate", 1).ah("tid", lVar.btc.getId()));
            TiebaStatic.log(lVar.Q(lVar.btc));
        } else {
            TiebaStatic.log(new an("c11004").ah("tid", lVar.btc.getTid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bir = null;
        this.dQw = new ad<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                v.aiz().cK(true);
                if (i.this.dUv != null && lVar != null && lVar.SV() != null && !StringUtils.isNull(lVar.SV().getTid()) && i.this.dUA != null && i.this.dUA.getView() != null) {
                    if (lVar.SV().aki > 0) {
                        TiebaStatic.log(lVar.Q(lVar.SV()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.e.bM(com.baidu.adp.lib.g.b.c(lVar.SV().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.e.bL(com.baidu.adp.lib.g.b.c(lVar.SV().getTid(), 0L));
                        i.this.dUv.a(com.baidu.adp.lib.g.b.c(lVar.SV().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.aiJ(), lVar.aiL(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (i.this.mType == com.baidu.tieba.card.data.l.czH) {
                        i.this.b(view, lVar);
                    } else if (i.this.mType == com.baidu.tieba.card.data.l.czI) {
                        i.this.c(view, lVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aDx();
    }

    private void aDx() {
        com.baidu.tieba.card.data.l.czJ = "c10708";
        com.baidu.tieba.card.data.l.czK = "c10735";
        com.baidu.tieba.card.data.l.czL = "c10756";
        com.baidu.tieba.card.data.l.czM = "c10709";
        com.baidu.tieba.card.data.l.czN = "c10734";
        com.baidu.tieba.card.data.l.czO = "c11929";
        com.baidu.tieba.card.data.l.czP = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aO */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        this.dUA = new n(this.mPageContext);
        this.dUA.currentPageType = 2;
        if (this.dUA.bGZ != null) {
            this.dUA.bGZ.akz = 2;
        }
        if (this.dUA.bHN != null && this.dUA.bHN.ayE != null) {
            this.dUA.bHN.ayE.akz = 2;
        }
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.n() { // from class: com.baidu.tieba.homepage.personalize.a.i.2
            @Override // com.baidu.adp.widget.ListView.n
            public void a(View view, com.baidu.adp.widget.ListView.h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                n aja;
                if ((view.getTag() instanceof c) && (aja = ((c) view.getTag()).aja()) != null) {
                    aja.onClick(aja.getView());
                }
            }
        });
        this.dUA.j(this.aRF);
        this.dUA.b(this.dQw);
        return new c(this.dUA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, c cVar) {
        if (lVar != null) {
            lVar.iL(i + 1);
            lVar.sourceType = 0;
        }
        cVar.aja().setVideoStatsData(b(lVar));
        if (cVar.aja() instanceof com.baidu.tieba.a.e) {
            cVar.aja().setPage(this.bGM);
        }
        cVar.aja().a(lVar);
        cVar.aja().a(this.bir);
        if (lVar != null) {
            if (getType() != null && getType() == com.baidu.tieba.card.data.l.czI) {
                v.aiz().a(lVar.aiU());
                an anVar = new an("c11003");
                bc SV = lVar.SV();
                if (SV != null) {
                    anVar.ah("tid", SV.getTid());
                    if (SV.vw() != null) {
                        anVar.r("ab_type", SV.vw().hadConcerned() ? 1 : 0);
                    }
                }
                v.aiz().a(anVar);
            } else {
                v.aiz().a(lVar.aiU());
            }
        }
        return cVar.getView();
    }

    private y b(com.baidu.tieba.card.data.l lVar) {
        y yVar = null;
        if (lVar != null) {
            yVar = new y();
            yVar.mLocate = "1";
            yVar.aWo = lVar.tid;
            if (lVar.SV() != null) {
                yVar.czo = String.valueOf(lVar.SV().getFid());
                if (lVar.SV().vN() != null) {
                    yVar.ghg = lVar.SV().vN().video_md5;
                    yVar.ghi = String.valueOf(lVar.SV().vN().is_vertical);
                }
            }
            yVar.agd = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.ghf = lVar.aiL();
            yVar.ghd = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
        }
        return yVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bir = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dUv = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void iD(String str) {
        this.bGM = str;
    }
}
