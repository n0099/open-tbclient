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
    public BdUniqueId aZt;
    private String bVS;
    private NEGFeedBackView.a bsM;
    private ad eip;
    private n enE;
    private com.baidu.tieba.homepage.personalize.model.e eny;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        if (view.getId() == this.enE.getView().getId()) {
            TiebaStatic.log(lVar.T(lVar.bIj));
        } else if (this.enE.bWf != null && this.enE.bWf.getBarNameTv() != null && view.getId() == this.enE.bWf.getBarNameTv().getId()) {
            TiebaStatic.log(lVar.aoM());
        } else if (this.enE.bWS != null && this.enE.bWS.aFR != null && view.getId() == this.enE.bWS.aFR.getId()) {
            TiebaStatic.log(lVar.aoM());
        } else if (this.enE.getHeaderImg() != null && view.getId() == this.enE.getHeaderImg().getId()) {
            TiebaStatic.log(lVar.U(lVar.bIj));
        } else if (this.enE.anS() != null && view.getId() == this.enE.anS().getId()) {
            TiebaStatic.log(lVar.U(lVar.bIj));
        } else if (this.enE.bWf != null && this.enE.bWf.getCommentContainer() != null && view.getId() == this.enE.bWf.getCommentContainer().getId()) {
            TiebaStatic.log(lVar.T(lVar.bIj));
        } else if (this.enE.cKD != null && view.getId() == this.enE.cKD.getId()) {
            TiebaStatic.log(lVar.T(lVar.bIj));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, com.baidu.tieba.card.data.l lVar) {
        if (view instanceof TbImageView) {
            TiebaStatic.log(new am("c11004").ax("tid", lVar.bIj.getTid()));
        } else if (view.getId() == this.enE.getView().getId()) {
            if (lVar.bIj.zy() != null && lVar.bIj.zy().channelId > 0) {
                lVar.w("c11929", true);
            }
            TiebaStatic.log(new am("c11004").ax("tid", lVar.bIj.getTid()));
            TiebaStatic.log(new am("c10806").x("obj_locate", 1).ax("tid", lVar.bIj.getId()));
            TiebaStatic.log(lVar.T(lVar.bIj));
        } else {
            TiebaStatic.log(new am("c11004").ax("tid", lVar.bIj.getTid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bsM = null;
        this.eip = new ad<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                v.aop().dy(true);
                if (i.this.eny != null && lVar != null && lVar.YB() != null && !StringUtils.isNull(lVar.YB().getTid()) && i.this.enE != null && i.this.enE.getView() != null) {
                    if (lVar.YB().are > 0) {
                        TiebaStatic.log(lVar.T(lVar.YB()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.cc(com.baidu.adp.lib.g.b.d(lVar.YB().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.cb(com.baidu.adp.lib.g.b.d(lVar.YB().getTid(), 0L));
                        i.this.eny.a(com.baidu.adp.lib.g.b.d(lVar.YB().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.aoz(), lVar.aoB(), com.baidu.adp.lib.g.b.l((String) view.getTag(), 1));
                    }
                    if (i.this.mType == com.baidu.tieba.card.data.l.cQu) {
                        i.this.b(view, lVar);
                    } else if (i.this.mType == com.baidu.tieba.card.data.l.cQv) {
                        i.this.c(view, lVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aKb();
    }

    private void aKb() {
        com.baidu.tieba.card.data.l.cQw = "c10708";
        com.baidu.tieba.card.data.l.cQx = "c10735";
        com.baidu.tieba.card.data.l.cQy = "c10709";
        com.baidu.tieba.card.data.l.cQz = "c10734";
        com.baidu.tieba.card.data.l.cQA = "c11929";
        com.baidu.tieba.card.data.l.cQB = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aP */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        final n nVar = new n(this.mPageContext);
        nVar.currentPageType = 2;
        if (nVar.bWf != null) {
            nVar.bWf.ary = 2;
        }
        if (nVar.bWS != null && nVar.bWS.aFS != null) {
            nVar.bWS.aFS.ary = 2;
        }
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.n() { // from class: com.baidu.tieba.homepage.personalize.a.i.2
            @Override // com.baidu.adp.widget.ListView.n
            public void a(View view, com.baidu.adp.widget.ListView.h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                n aoQ;
                if ((view.getTag() instanceof c) && (aoQ = ((c) view.getTag()).aoQ()) != null) {
                    aoQ.onClick(aoQ.getView());
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
        nVar.j(this.aZt);
        nVar.b(this.eip);
        this.enE = nVar;
        return new c(this.enE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, c cVar) {
        if (lVar != null) {
            lVar.jT(i + 1);
            lVar.sourceType = 0;
        }
        cVar.aoQ().setVideoStatsData(b(lVar));
        if (cVar.aoQ() instanceof com.baidu.tieba.a.e) {
            cVar.aoQ().setPage(this.bVS);
        }
        cVar.aoQ().a(lVar);
        cVar.aoQ().a(this.bsM);
        if (lVar != null) {
            if (getType() != null && getType() == com.baidu.tieba.card.data.l.cQv) {
                v.aop().a(lVar.aoK());
                am amVar = new am("c11003");
                bb YB = lVar.YB();
                if (YB != null) {
                    amVar.ax("tid", YB.getTid());
                    if (YB.yv() != null) {
                        amVar.x("ab_type", YB.yv().hadConcerned() ? 1 : 0);
                    }
                }
                v.aop().a(amVar);
            } else {
                v.aop().a(lVar.aoK());
            }
        }
        return cVar.getView();
    }

    private z b(com.baidu.tieba.card.data.l lVar) {
        z zVar = null;
        if (lVar != null) {
            zVar = new z();
            zVar.mLocate = "1";
            zVar.beh = lVar.tid;
            if (lVar.YB() != null) {
                zVar.cQb = String.valueOf(lVar.YB().getFid());
                if (lVar.YB().yN() != null) {
                    zVar.gwA = lVar.YB().yN().video_md5;
                    zVar.gwC = String.valueOf(lVar.YB().yN().is_vertical);
                }
            }
            zVar.amT = lVar.getExtra();
            zVar.mSource = lVar.getSource();
            zVar.gwz = lVar.aoB();
            zVar.gwx = lVar.getWeight();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
        }
        return zVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bsM = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.eny = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void jq(String str) {
        this.bVS = str;
    }
}
