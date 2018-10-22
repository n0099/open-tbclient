package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.ac;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.e;
import com.baidu.tieba.play.z;
/* loaded from: classes6.dex */
public class p extends com.baidu.tieba.frs.h<bb, a<com.baidu.tieba.frs.entelechy.view.a>> implements com.baidu.tieba.a.f, ab, ac, com.baidu.tieba.frs.e.c {
    private boolean aFr;
    private String bVS;
    private ad<bb> bVT;
    public boolean dGU;
    private int dIA;
    private com.baidu.tieba.frs.e.a dIB;
    private boolean dIz;
    private com.baidu.tieba.frs.entelechy.view.a dJm;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.aFr = false;
        this.dIz = false;
        this.dIA = 3;
        this.dIB = new com.baidu.tieba.frs.e.a();
        this.bVT = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (p.this.dzW != null) {
                        p.this.dzW.a(view, bbVar, bb.aoV);
                    }
                    if ("c13010".equals(p.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").x("obj_type", 2).h(ImageViewerConfig.FORUM_ID, bbVar.getFid()).ax("tid", bbVar.getTid()));
                    }
                    if (view.getId() == e.g.layout_root || (p.this.dJm.bWf != null && p.this.dJm.bWf.getCommentContainer() != null && view.getId() == p.this.dJm.bWf.getCommentContainer().getId())) {
                        com.baidu.tieba.frs.e.b.aFC().a(p.this.dIB, bbVar, 1);
                        p.this.Z(bbVar);
                    } else if (view.getId() == e.g.card_home_page_normal_thread_user_name || view.getId() == e.g.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.e.b.aFC().a(p.this.dIB, bbVar, 2);
                    } else if (view.getId() == e.g.header_divider) {
                        com.baidu.tieba.frs.f.h.a(p.this.dIB, bbVar.yU());
                    } else if (view.getId() == e.g.frame_video) {
                        com.baidu.tieba.frs.e.b.aFC().a(p.this.dIB, bbVar, 4);
                        p.this.Z(bbVar);
                    } else if (view.getId() == e.g.card_god_reply_layout) {
                        p.this.Z(bbVar);
                    }
                    if (view.getId() == e.g.frame_video) {
                        com.baidu.tieba.frs.e.b.aFC().b(p.this.dIB, bbVar, 1);
                    } else if (view.getId() == e.g.card_home_page_normal_thread_user_name || view.getId() == e.g.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.e.b.aFC().b(p.this.dIB, bbVar, 2);
                    } else if (view.getId() == e.g.share_num_container) {
                        com.baidu.tieba.frs.e.b.aFC().b(p.this.dIB, bbVar, 5);
                    } else if (view.getId() == e.g.agree_view_container) {
                        com.baidu.tieba.frs.e.b.aFC().b(p.this.dIB, bbVar, 4);
                    } else {
                        com.baidu.tieba.frs.e.b.aFC().b(p.this.dIB, bbVar, 3);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        final com.baidu.tieba.frs.entelechy.view.a aVar = new com.baidu.tieba.frs.entelechy.view.a(this.mPageContext, this.mPageId);
        aVar.j(this.mPageId);
        aVar.setForumName(this.mForumName);
        if (aVar.bWf != null) {
            aVar.bWf.setInFrsAllThread(this.aFr);
        }
        aVar.ii(this.dIA);
        if (this.dIA != 15 && this.dIz && aVar.bWe != null) {
            aVar.bWe.setFrom(4);
        }
        if (!isPreloadSizeReady(1)) {
            aVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.frs.entelechy.a.p.2
                @Override // com.baidu.adp.widget.a.b
                public void k(int i, int i2, int i3) {
                    p.this.setPreloadSize(i, i2, i3);
                    if (p.this.isPreloadSizeReady(1)) {
                        aVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        this.dJm = aVar;
        return new a(this.dJm);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, a aVar) {
        if (aVar == null || aVar.aoQ() == null) {
            return null;
        }
        if (aVar.aoQ() instanceof com.baidu.tieba.a.e) {
            aVar.aoQ().setPage(this.bVS);
        }
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        com.baidu.tieba.frs.g.a(aVar.aoQ().aaY(), this.dzP);
        com.baidu.tieba.frs.g.a(aVar.aoQ().aaZ(), this.dzP);
        aVar.aoQ().setVideoStatsData(X(bbVar));
        if (this.dzP != null && this.dzP.beT() != null && !StringUtils.isNull(this.dzP.beT().getTopic_special_icon()) && !StringUtils.isNull(this.dzP.beT().getTopic_special_icon_right())) {
            aVar.aoQ().ai(this.dzP.beT().getTopic_special_icon(), this.dzP.beT().getTopic_special_icon_right());
        }
        aVar.aoQ().a(bbVar);
        aVar.aoQ().setForumName(this.mForumName);
        aVar.aoQ().b(this.bVT);
        if (this.dzP != null) {
            aVar.aoQ().dJD = this.dzP.hbm;
        } else {
            aVar.aoQ().dJD = this.dGU;
        }
        if (this.dIB != null) {
            aVar.aoQ().dJE = this.dIB.dTG;
        }
        com.baidu.tieba.frs.e.b.aFC().a(this.dIB, bbVar);
        com.baidu.tieba.frs.e.b.aFC().ad(bbVar);
        if (bbVar != null) {
            TiebaStatic.log(new am("c12125").ax("tid", bbVar.getId()).x("obj_locate", azq() ? 2 : 1).h(VideoPlayActivityConfig.OBJ_ID, bbVar.yP() != null ? bbVar.yP().live_id : -1L).x("obj_type", 1));
            bbVar.zs();
        }
        return aVar.getView();
    }

    private z X(bb bbVar) {
        if (bbVar == null) {
            return null;
        }
        z zVar = new z();
        zVar.mLocate = bbVar.zo() ? "3" : "2";
        if (this.dIB.dTG == 501) {
            zVar.mLocate = "frs_tab";
        }
        zVar.cQb = this.dIB.dTF;
        zVar.beh = bbVar.getTid();
        zVar.mSource = bbVar.mRecomSource;
        zVar.gww = bbVar.aqK;
        zVar.gwx = bbVar.mRecomWeight;
        zVar.gwz = bbVar.mRecomAbTag;
        if (bbVar.yN() != null) {
            zVar.gwA = bbVar.yN().video_md5;
        }
        return zVar;
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void ii(int i) {
        this.dIA = i;
    }

    @Override // com.baidu.tieba.a.f
    public void jq(String str) {
        this.bVS = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(bb bbVar) {
        TiebaStatic.log(new am("c12126").ax("tid", bbVar.getId()).x("obj_locate", azq() ? 2 : 1).h(VideoPlayActivityConfig.OBJ_ID, bbVar.yP() == null ? -1L : bbVar.yP().live_id).x("obj_type", 1));
    }

    public void setInFrsAllThread(boolean z) {
        this.aFr = z;
    }

    @Override // com.baidu.tieba.card.ac
    public void fj(boolean z) {
        this.dIz = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a aCN() {
        return this.dIB;
    }
}
