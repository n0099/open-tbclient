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
    public BdUniqueId bdH;
    private NEGFeedBackView.a bxa;
    private String caz;
    private ad etv;
    private com.baidu.tieba.homepage.personalize.model.e eyF;
    private n eyL;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        if (view.getId() == this.eyL.getView().getId()) {
            TiebaStatic.log(lVar.T(lVar.bMM));
            com.baidu.tieba.q.c.bBT().b(this.bdH, com.baidu.tieba.q.a.a(lVar.bMM, "a002", "common_click", 1, lVar.aqC(), false, null, null));
        } else if (this.eyL.getVideoView() != null && view.getId() == this.eyL.getVideoView().getId()) {
            TiebaStatic.log(lVar.T(lVar.bMM));
            com.baidu.tieba.q.c.bBT().b(this.bdH, com.baidu.tieba.q.a.a(lVar.bMM, "a002", "common_click", 4, lVar.aqC(), false, null, null));
        } else if (this.eyL.caM != null && this.eyL.caM.getBarNameTv() != null && view.getId() == this.eyL.caM.getBarNameTv().getId()) {
            TiebaStatic.log(lVar.aqP());
        } else if (this.eyL.cbz != null && this.eyL.cbz.aKj != null && view.getId() == this.eyL.cbz.aKj.getId()) {
            TiebaStatic.log(lVar.aqP());
        } else if (this.eyL.getHeaderImg() != null && view.getId() == this.eyL.getHeaderImg().getId()) {
            TiebaStatic.log(lVar.U(lVar.bMM));
            com.baidu.tieba.q.c.bBT().b(this.bdH, com.baidu.tieba.q.a.a(lVar.bMM, "a002", "common_click", 2, lVar.aqC(), false, null, null));
        } else if (this.eyL.apV() != null && view.getId() == this.eyL.apV().getId()) {
            TiebaStatic.log(lVar.U(lVar.bMM));
            com.baidu.tieba.q.c.bBT().b(this.bdH, com.baidu.tieba.q.a.a(lVar.bMM, "a002", "common_click", 2, lVar.aqC(), false, null, null));
        } else if (this.eyL.caM != null && this.eyL.caM.getCommentContainer() != null && view.getId() == this.eyL.caM.getCommentContainer().getId()) {
            TiebaStatic.log(lVar.T(lVar.bMM));
            com.baidu.tieba.q.c.bBT().b(this.bdH, com.baidu.tieba.q.a.a(lVar.bMM, "a002", "common_click", 5, lVar.aqC(), false, null, null));
        } else if (this.eyL.cVg != null && view.getId() == this.eyL.cVg.getId()) {
            TiebaStatic.log(lVar.T(lVar.bMM));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, com.baidu.tieba.card.data.l lVar) {
        if (view instanceof TbImageView) {
            TiebaStatic.log(new am("c11004").aA("tid", lVar.bMM.getTid()));
            com.baidu.tieba.q.c.bBT().b(this.bdH, com.baidu.tieba.q.a.a(lVar.bMM, "a002", "common_click", 3, lVar.aqC(), false, null, null));
        } else if (view.getId() == this.eyL.getView().getId()) {
            if (lVar.bMM.AJ() != null && lVar.bMM.AJ().channelId > 0) {
                lVar.y("c11929", true);
            }
            TiebaStatic.log(new am("c11004").aA("tid", lVar.bMM.getTid()));
            TiebaStatic.log(new am("c10806").x("obj_locate", 1).aA("tid", lVar.bMM.getId()));
            TiebaStatic.log(lVar.T(lVar.bMM));
            com.baidu.tieba.q.c.bBT().b(this.bdH, com.baidu.tieba.q.a.a(lVar.bMM, "a002", "common_click", 1, lVar.aqC(), false, null, null));
        } else {
            TiebaStatic.log(new am("c11004").aA("tid", lVar.bMM.getTid()));
            com.baidu.tieba.q.c.bBT().b(this.bdH, com.baidu.tieba.q.a.a(lVar.bMM, "a002", "common_click", 1, lVar.aqC(), false, null, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bxa = null;
        this.etv = new ad<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                v.aqs().dQ(true);
                if (i.this.eyF != null && lVar != null && lVar.ZT() != null && !StringUtils.isNull(lVar.ZT().getTid()) && i.this.eyL != null && i.this.eyL.getView() != null) {
                    if (lVar.ZT().avr > 0) {
                        TiebaStatic.log(lVar.T(lVar.ZT()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.cj(com.baidu.adp.lib.g.b.d(lVar.ZT().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.ci(com.baidu.adp.lib.g.b.d(lVar.ZT().getTid(), 0L));
                        i.this.eyF.a(com.baidu.adp.lib.g.b.d(lVar.ZT().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.aqC(), lVar.aqE(), com.baidu.adp.lib.g.b.l((String) view.getTag(), 1));
                    }
                    if (i.this.mType == com.baidu.tieba.card.data.l.daZ) {
                        i.this.b(view, lVar);
                    } else if (i.this.mType == com.baidu.tieba.card.data.l.dba) {
                        i.this.c(view, lVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aMe();
    }

    private void aMe() {
        com.baidu.tieba.card.data.l.dbb = "c10708";
        com.baidu.tieba.card.data.l.dbc = "c10735";
        com.baidu.tieba.card.data.l.dbd = "c10709";
        com.baidu.tieba.card.data.l.dbe = "c10734";
        com.baidu.tieba.card.data.l.dbf = "c11929";
        com.baidu.tieba.card.data.l.dbg = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        final n nVar = new n(this.mPageContext);
        nVar.currentPageType = 2;
        if (nVar.caM != null) {
            nVar.caM.avM = 2;
        }
        if (nVar.cbz != null && nVar.cbz.aKk != null) {
            nVar.cbz.aKk.avM = 2;
        }
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.n() { // from class: com.baidu.tieba.homepage.personalize.a.i.2
            @Override // com.baidu.adp.widget.ListView.n
            public void a(View view, com.baidu.adp.widget.ListView.h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                n aqT;
                if ((view.getTag() instanceof c) && (aqT = ((c) view.getTag()).aqT()) != null) {
                    aqT.onClick(aqT.getView());
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
        nVar.j(this.bdH);
        nVar.b(this.etv);
        this.eyL = nVar;
        return new c(this.eyL);
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
        cVar.aqT().setVideoStatsData(b(lVar));
        if (cVar.aqT() instanceof com.baidu.tieba.a.e) {
            cVar.aqT().setPage(this.caz);
        }
        cVar.aqT().kL(i + 1);
        cVar.aqT().a(lVar);
        cVar.aqT().a(this.bxa);
        if (lVar != null) {
            if (getType() != null && getType() == com.baidu.tieba.card.data.l.dba) {
                v.aqs().a(lVar.aqN());
                am amVar = new am("c11003");
                bb ZT = lVar.ZT();
                if (ZT != null) {
                    amVar.aA("tid", ZT.getTid());
                    if (ZT.zG() != null) {
                        amVar.x("ab_type", ZT.zG().hadConcerned() ? 1 : 0);
                    }
                }
                v.aqs().a(amVar);
            } else {
                v.aqs().a(lVar.aqN());
            }
        }
        com.baidu.tieba.q.c.bBT().a(this.bdH, lVar.bMM != null ? lVar.bMM.getId() : null, com.baidu.tieba.q.a.a(lVar.bMM, "a002", "common_exp", lVar.aqC(), false, null, null));
        return cVar.getView();
    }

    private z b(com.baidu.tieba.card.data.l lVar) {
        z zVar = null;
        if (lVar != null) {
            zVar = new z();
            zVar.mLocate = "1";
            zVar.biz = lVar.tid;
            if (lVar.ZT() != null) {
                zVar.daG = String.valueOf(lVar.ZT().getFid());
                if (lVar.ZT().zY() != null) {
                    zVar.gHI = lVar.ZT().zY().video_md5;
                    zVar.gHK = String.valueOf(lVar.ZT().zY().is_vertical);
                }
            }
            zVar.arh = lVar.getExtra();
            zVar.mSource = lVar.getSource();
            zVar.gHH = lVar.aqE();
            zVar.gHF = lVar.getWeight();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mFloor = String.valueOf(lVar.aqC());
        }
        return zVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bxa = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.eyF = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void jL(String str) {
        this.caz = str;
    }
}
