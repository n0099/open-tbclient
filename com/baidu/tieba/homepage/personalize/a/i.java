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
    public BdUniqueId bdE;
    private NEGFeedBackView.a bwX;
    private String caw;
    private ad eqD;
    private com.baidu.tieba.homepage.personalize.model.e evM;
    private n evS;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        if (view.getId() == this.evS.getView().getId()) {
            TiebaStatic.log(lVar.T(lVar.bMJ));
        } else if (this.evS.caJ != null && this.evS.caJ.getBarNameTv() != null && view.getId() == this.evS.caJ.getBarNameTv().getId()) {
            TiebaStatic.log(lVar.aqa());
        } else if (this.evS.cbw != null && this.evS.cbw.aKh != null && view.getId() == this.evS.cbw.aKh.getId()) {
            TiebaStatic.log(lVar.aqa());
        } else if (this.evS.getHeaderImg() != null && view.getId() == this.evS.getHeaderImg().getId()) {
            TiebaStatic.log(lVar.U(lVar.bMJ));
        } else if (this.evS.apf() != null && view.getId() == this.evS.apf().getId()) {
            TiebaStatic.log(lVar.U(lVar.bMJ));
        } else if (this.evS.caJ != null && this.evS.caJ.getCommentContainer() != null && view.getId() == this.evS.caJ.getCommentContainer().getId()) {
            TiebaStatic.log(lVar.T(lVar.bMJ));
        } else if (this.evS.cSq != null && view.getId() == this.evS.cSq.getId()) {
            TiebaStatic.log(lVar.T(lVar.bMJ));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, com.baidu.tieba.card.data.l lVar) {
        if (view instanceof TbImageView) {
            TiebaStatic.log(new am("c11004").aA("tid", lVar.bMJ.getTid()));
        } else if (view.getId() == this.evS.getView().getId()) {
            if (lVar.bMJ.AJ() != null && lVar.bMJ.AJ().channelId > 0) {
                lVar.y("c11929", true);
            }
            TiebaStatic.log(new am("c11004").aA("tid", lVar.bMJ.getTid()));
            TiebaStatic.log(new am("c10806").x("obj_locate", 1).aA("tid", lVar.bMJ.getId()));
            TiebaStatic.log(lVar.T(lVar.bMJ));
        } else {
            TiebaStatic.log(new am("c11004").aA("tid", lVar.bMJ.getTid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bwX = null;
        this.eqD = new ad<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                v.apD().dQ(true);
                if (i.this.evM != null && lVar != null && lVar.ZR() != null && !StringUtils.isNull(lVar.ZR().getTid()) && i.this.evS != null && i.this.evS.getView() != null) {
                    if (lVar.ZR().avr > 0) {
                        TiebaStatic.log(lVar.T(lVar.ZR()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.ce(com.baidu.adp.lib.g.b.d(lVar.ZR().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.cd(com.baidu.adp.lib.g.b.d(lVar.ZR().getTid(), 0L));
                        i.this.evM.a(com.baidu.adp.lib.g.b.d(lVar.ZR().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.apN(), lVar.apP(), com.baidu.adp.lib.g.b.l((String) view.getTag(), 1));
                    }
                    if (i.this.mType == com.baidu.tieba.card.data.l.cYh) {
                        i.this.b(view, lVar);
                    } else if (i.this.mType == com.baidu.tieba.card.data.l.cYi) {
                        i.this.c(view, lVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aLq();
    }

    private void aLq() {
        com.baidu.tieba.card.data.l.cYj = "c10708";
        com.baidu.tieba.card.data.l.cYk = "c10735";
        com.baidu.tieba.card.data.l.cYl = "c10709";
        com.baidu.tieba.card.data.l.cYm = "c10734";
        com.baidu.tieba.card.data.l.cYn = "c11929";
        com.baidu.tieba.card.data.l.cYo = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        final n nVar = new n(this.mPageContext);
        nVar.currentPageType = 2;
        if (nVar.caJ != null) {
            nVar.caJ.avL = 2;
        }
        if (nVar.cbw != null && nVar.cbw.aKi != null) {
            nVar.cbw.aKi.avL = 2;
        }
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.n() { // from class: com.baidu.tieba.homepage.personalize.a.i.2
            @Override // com.baidu.adp.widget.ListView.n
            public void a(View view, com.baidu.adp.widget.ListView.h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                n aqe;
                if ((view.getTag() instanceof c) && (aqe = ((c) view.getTag()).aqe()) != null) {
                    aqe.onClick(aqe.getView());
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
        nVar.j(this.bdE);
        nVar.b(this.eqD);
        this.evS = nVar;
        return new c(this.evS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, c cVar) {
        if (lVar != null) {
            lVar.kC(i + 1);
            lVar.sourceType = 0;
        }
        cVar.aqe().setVideoStatsData(b(lVar));
        if (cVar.aqe() instanceof com.baidu.tieba.a.e) {
            cVar.aqe().setPage(this.caw);
        }
        cVar.aqe().a(lVar);
        cVar.aqe().a(this.bwX);
        if (lVar != null) {
            if (getType() != null && getType() == com.baidu.tieba.card.data.l.cYi) {
                v.apD().a(lVar.apY());
                am amVar = new am("c11003");
                bb ZR = lVar.ZR();
                if (ZR != null) {
                    amVar.aA("tid", ZR.getTid());
                    if (ZR.zG() != null) {
                        amVar.x("ab_type", ZR.zG().hadConcerned() ? 1 : 0);
                    }
                }
                v.apD().a(amVar);
            } else {
                v.apD().a(lVar.apY());
            }
        }
        return cVar.getView();
    }

    private z b(com.baidu.tieba.card.data.l lVar) {
        z zVar = null;
        if (lVar != null) {
            zVar = new z();
            zVar.mLocate = "1";
            zVar.biw = lVar.tid;
            if (lVar.ZR() != null) {
                zVar.cXO = String.valueOf(lVar.ZR().getFid());
                if (lVar.ZR().zY() != null) {
                    zVar.gER = lVar.ZR().zY().video_md5;
                    zVar.gET = String.valueOf(lVar.ZR().zY().is_vertical);
                }
            }
            zVar.arh = lVar.getExtra();
            zVar.mSource = lVar.getSource();
            zVar.gEQ = lVar.apP();
            zVar.gEO = lVar.getWeight();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
        }
        return zVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bwX = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.evM = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void jK(String str) {
        this.caw = str;
    }
}
