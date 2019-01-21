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
    public BdUniqueId beu;
    private NEGFeedBackView.a bxP;
    private String cbl;
    private ad euc;
    private com.baidu.tieba.homepage.personalize.model.e ezq;
    private n ezw;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        if (view.getId() == this.ezw.getView().getId()) {
            TiebaStatic.log(lVar.a(lVar.bNA, 1));
            com.baidu.tieba.q.c.bCC().b(this.beu, com.baidu.tieba.q.a.a(lVar.bNA, "a002", "common_click", 1, lVar.aqZ(), false, null, null));
        } else if (this.ezw.getVideoView() != null && view.getId() == this.ezw.getVideoView().getId()) {
            com.baidu.tieba.q.c.bCC().b(this.beu, com.baidu.tieba.q.a.a(lVar.bNA, "a002", "common_click", 4, lVar.aqZ(), false, null, null));
            TiebaStatic.log(lVar.arq());
        } else if (this.ezw.cby != null && this.ezw.cby.getBarNameTv() != null && view.getId() == this.ezw.cby.getBarNameTv().getId()) {
            TiebaStatic.log(lVar.arm());
        } else if (this.ezw.ccl != null && this.ezw.ccl.aKM != null && view.getId() == this.ezw.ccl.aKM.getId()) {
            TiebaStatic.log(lVar.arm());
        } else if (this.ezw.getHeaderImg() != null && view.getId() == this.ezw.getHeaderImg().getId()) {
            TiebaStatic.log(lVar.U(lVar.bNA));
            com.baidu.tieba.q.c.bCC().b(this.beu, com.baidu.tieba.q.a.a(lVar.bNA, "a002", "common_click", 2, lVar.aqZ(), false, null, null));
        } else if (this.ezw.aqs() != null && view.getId() == this.ezw.aqs().getId()) {
            TiebaStatic.log(lVar.U(lVar.bNA));
            com.baidu.tieba.q.c.bCC().b(this.beu, com.baidu.tieba.q.a.a(lVar.bNA, "a002", "common_click", 2, lVar.aqZ(), false, null, null));
        } else if (this.ezw.cby != null && this.ezw.cby.getCommentContainer() != null && view.getId() == this.ezw.cby.getCommentContainer().getId()) {
            TiebaStatic.log(lVar.a(lVar.bNA, 2));
            com.baidu.tieba.q.c.bCC().b(this.beu, com.baidu.tieba.q.a.a(lVar.bNA, "a002", "common_click", 5, lVar.aqZ(), false, null, null));
        } else if (this.ezw.cVS != null && view.getId() == this.ezw.cVS.getId()) {
            TiebaStatic.log(lVar.T(lVar.bNA));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, com.baidu.tieba.card.data.l lVar) {
        if (view instanceof TbImageView) {
            TiebaStatic.log(new am("c11004").aB("tid", lVar.bNA.getTid()));
            com.baidu.tieba.q.c.bCC().b(this.beu, com.baidu.tieba.q.a.a(lVar.bNA, "a002", "common_click", 3, lVar.aqZ(), false, null, null));
        } else if (view.getId() == this.ezw.getView().getId()) {
            if (lVar.bNA.AW() != null && lVar.bNA.AW().channelId > 0) {
                lVar.y("c11929", true);
            }
            TiebaStatic.log(new am("c11004").aB("tid", lVar.bNA.getTid()));
            TiebaStatic.log(new am("c10806").y("obj_locate", 1).aB("tid", lVar.bNA.getId()));
            TiebaStatic.log(lVar.T(lVar.bNA));
            com.baidu.tieba.q.c.bCC().b(this.beu, com.baidu.tieba.q.a.a(lVar.bNA, "a002", "common_click", 1, lVar.aqZ(), false, null, null));
        } else {
            TiebaStatic.log(new am("c11004").aB("tid", lVar.bNA.getTid()));
            com.baidu.tieba.q.c.bCC().b(this.beu, com.baidu.tieba.q.a.a(lVar.bNA, "a002", "common_click", 1, lVar.aqZ(), false, null, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bxP = null;
        this.euc = new ad<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                v.aqP().dT(true);
                if (i.this.ezq != null && lVar != null && lVar.aaq() != null && !StringUtils.isNull(lVar.aaq().getTid()) && i.this.ezw != null && i.this.ezw.getView() != null) {
                    if (lVar.aaq().avU > 0) {
                        TiebaStatic.log(lVar.T(lVar.aaq()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.cj(com.baidu.adp.lib.g.b.d(lVar.aaq().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.ci(com.baidu.adp.lib.g.b.d(lVar.aaq().getTid(), 0L));
                        i.this.ezq.a(com.baidu.adp.lib.g.b.d(lVar.aaq().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.aqZ(), lVar.arb(), com.baidu.adp.lib.g.b.l((String) view.getTag(), 1));
                    }
                    if (i.this.mType == com.baidu.tieba.card.data.l.dbL) {
                        i.this.b(view, lVar);
                    } else if (i.this.mType == com.baidu.tieba.card.data.l.dbM) {
                        i.this.c(view, lVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aME();
    }

    private void aME() {
        com.baidu.tieba.card.data.l.dbN = "c10708";
        com.baidu.tieba.card.data.l.dbO = "c10735";
        com.baidu.tieba.card.data.l.dbP = "c10709";
        com.baidu.tieba.card.data.l.dbQ = "c10734";
        com.baidu.tieba.card.data.l.dbR = "c11929";
        com.baidu.tieba.card.data.l.dbS = "c11928";
        com.baidu.tieba.card.data.l.dbT = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        final n nVar = new n(this.mPageContext);
        nVar.currentPageType = 2;
        if (nVar.cby != null) {
            nVar.cby.awp = 2;
        }
        if (nVar.ccl != null && nVar.ccl.aKN != null) {
            nVar.ccl.aKN.awp = 2;
        }
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.n() { // from class: com.baidu.tieba.homepage.personalize.a.i.2
            @Override // com.baidu.adp.widget.ListView.n
            public void a(View view, com.baidu.adp.widget.ListView.h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                n arr;
                if ((view.getTag() instanceof c) && (arr = ((c) view.getTag()).arr()) != null) {
                    arr.onClick(arr.getView());
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
        nVar.j(this.beu);
        nVar.b(this.euc);
        this.ezw = nVar;
        return new c(this.ezw);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, c cVar) {
        if (lVar != null) {
            lVar.kP(i + 1);
            lVar.sourceType = 0;
        }
        cVar.arr().setVideoStatsData(b(lVar));
        if (cVar.arr() instanceof com.baidu.tieba.a.e) {
            cVar.arr().setPage(this.cbl);
        }
        cVar.arr().kL(i + 1);
        cVar.arr().a(lVar);
        cVar.arr().a(this.bxP);
        if (lVar != null) {
            if (getType() != null && getType() == com.baidu.tieba.card.data.l.dbM) {
                v.aqP().a(lVar.ark());
                am amVar = new am("c11003");
                bb aaq = lVar.aaq();
                if (aaq != null) {
                    amVar.aB("tid", aaq.getTid());
                    if (aaq.zT() != null) {
                        amVar.y("ab_type", aaq.zT().hadConcerned() ? 1 : 0);
                    }
                }
                v.aqP().a(amVar);
            } else {
                v.aqP().a(lVar.ark());
            }
        }
        com.baidu.tieba.q.c.bCC().a(this.beu, lVar.bNA != null ? lVar.bNA.getId() : null, com.baidu.tieba.q.a.a(lVar.bNA, "a002", "common_exp", lVar.aqZ(), false, null, null));
        return cVar.getView();
    }

    private z b(com.baidu.tieba.card.data.l lVar) {
        z zVar = null;
        if (lVar != null) {
            zVar = new z();
            zVar.mLocate = "1";
            zVar.bjn = lVar.tid;
            if (lVar.aaq() != null) {
                zVar.dbs = String.valueOf(lVar.aaq().getFid());
                if (lVar.aaq().Al() != null) {
                    zVar.gIN = lVar.aaq().Al().video_md5;
                    zVar.gIP = String.valueOf(lVar.aaq().Al().is_vertical);
                }
            }
            zVar.arK = lVar.getExtra();
            zVar.mSource = lVar.getSource();
            zVar.gIM = lVar.arb();
            zVar.gIK = lVar.getWeight();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mFloor = String.valueOf(lVar.aqZ());
        }
        return zVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bxP = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.ezq = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void kb(String str) {
        this.cbl = str;
    }
}
