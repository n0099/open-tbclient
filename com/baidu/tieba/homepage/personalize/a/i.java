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
    private ad eio;
    private n enD;
    private com.baidu.tieba.homepage.personalize.model.e enx;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        if (view.getId() == this.enD.getView().getId()) {
            TiebaStatic.log(lVar.T(lVar.bIj));
        } else if (this.enD.bWf != null && this.enD.bWf.getBarNameTv() != null && view.getId() == this.enD.bWf.getBarNameTv().getId()) {
            TiebaStatic.log(lVar.aoL());
        } else if (this.enD.bWS != null && this.enD.bWS.aFR != null && view.getId() == this.enD.bWS.aFR.getId()) {
            TiebaStatic.log(lVar.aoL());
        } else if (this.enD.getHeaderImg() != null && view.getId() == this.enD.getHeaderImg().getId()) {
            TiebaStatic.log(lVar.U(lVar.bIj));
        } else if (this.enD.anR() != null && view.getId() == this.enD.anR().getId()) {
            TiebaStatic.log(lVar.U(lVar.bIj));
        } else if (this.enD.bWf != null && this.enD.bWf.getCommentContainer() != null && view.getId() == this.enD.bWf.getCommentContainer().getId()) {
            TiebaStatic.log(lVar.T(lVar.bIj));
        } else if (this.enD.cKD != null && view.getId() == this.enD.cKD.getId()) {
            TiebaStatic.log(lVar.T(lVar.bIj));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, com.baidu.tieba.card.data.l lVar) {
        if (view instanceof TbImageView) {
            TiebaStatic.log(new am("c11004").ax("tid", lVar.bIj.getTid()));
        } else if (view.getId() == this.enD.getView().getId()) {
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
        this.eio = new ad<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                v.aoo().dy(true);
                if (i.this.enx != null && lVar != null && lVar.YA() != null && !StringUtils.isNull(lVar.YA().getTid()) && i.this.enD != null && i.this.enD.getView() != null) {
                    if (lVar.YA().are > 0) {
                        TiebaStatic.log(lVar.T(lVar.YA()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.cc(com.baidu.adp.lib.g.b.d(lVar.YA().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.cb(com.baidu.adp.lib.g.b.d(lVar.YA().getTid(), 0L));
                        i.this.enx.a(com.baidu.adp.lib.g.b.d(lVar.YA().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.aoy(), lVar.aoA(), com.baidu.adp.lib.g.b.l((String) view.getTag(), 1));
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
                n aoP;
                if ((view.getTag() instanceof c) && (aoP = ((c) view.getTag()).aoP()) != null) {
                    aoP.onClick(aoP.getView());
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
        nVar.b(this.eio);
        this.enD = nVar;
        return new c(this.enD);
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
        cVar.aoP().setVideoStatsData(b(lVar));
        if (cVar.aoP() instanceof com.baidu.tieba.a.e) {
            cVar.aoP().setPage(this.bVS);
        }
        cVar.aoP().a(lVar);
        cVar.aoP().a(this.bsM);
        if (lVar != null) {
            if (getType() != null && getType() == com.baidu.tieba.card.data.l.cQv) {
                v.aoo().a(lVar.aoJ());
                am amVar = new am("c11003");
                bb YA = lVar.YA();
                if (YA != null) {
                    amVar.ax("tid", YA.getTid());
                    if (YA.yv() != null) {
                        amVar.x("ab_type", YA.yv().hadConcerned() ? 1 : 0);
                    }
                }
                v.aoo().a(amVar);
            } else {
                v.aoo().a(lVar.aoJ());
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
            if (lVar.YA() != null) {
                zVar.cQb = String.valueOf(lVar.YA().getFid());
                if (lVar.YA().yN() != null) {
                    zVar.gwz = lVar.YA().yN().video_md5;
                    zVar.gwB = String.valueOf(lVar.YA().yN().is_vertical);
                }
            }
            zVar.amT = lVar.getExtra();
            zVar.mSource = lVar.getSource();
            zVar.gwy = lVar.aoA();
            zVar.gww = lVar.getWeight();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
        }
        return zVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bsM = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.enx = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void jq(String str) {
        this.bVS = str;
    }
}
