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
public class p extends com.baidu.tieba.frs.h<bb, a<com.baidu.tieba.frs.entelechy.view.a>> implements com.baidu.tieba.a.f, ab, ac, com.baidu.tieba.frs.e.d {
    private boolean aKm;
    private String cbl;
    private ad<bb> cbm;
    public boolean dSm;
    private boolean dTE;
    private int dTF;
    private com.baidu.tieba.frs.e.b dTG;
    private com.baidu.tieba.frs.entelechy.view.a dUr;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.aKm = false;
        this.dTE = false;
        this.dTF = 3;
        this.dTG = new com.baidu.tieba.frs.e.b();
        this.cbm = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (p.this.dLk != null) {
                        p.this.dLk.a(view, bbVar, bb.atM);
                    }
                    if ("c13010".equals(p.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").y("obj_type", 2).i(ImageViewerConfig.FORUM_ID, bbVar.getFid()).aB("tid", bbVar.getTid()));
                    }
                    if (view.getId() == e.g.card_home_page_normal_thread_user_name || view.getId() == e.g.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.e.a.a(bbVar, 2, p.this.mPageId, p.this.dTG);
                    } else if (view.getId() == e.g.frame_video) {
                        com.baidu.tieba.frs.e.a.a(bbVar, 4, p.this.mPageId, p.this.dTG);
                    } else if (view == p.this.dUr.cby.getCommentContainer()) {
                        com.baidu.tieba.frs.e.a.a(bbVar, 5, p.this.mPageId, p.this.dTG);
                    } else {
                        com.baidu.tieba.frs.e.a.a(bbVar, 1, p.this.mPageId, p.this.dTG);
                    }
                    if (view.getId() == e.g.layout_root || (p.this.dUr.cby != null && p.this.dUr.cby.getCommentContainer() != null && view.getId() == p.this.dUr.cby.getCommentContainer().getId())) {
                        com.baidu.tieba.frs.e.c.aHW().a(p.this.dTG, bbVar, 1);
                        p.this.Z(bbVar);
                    } else if (view.getId() == e.g.card_home_page_normal_thread_user_name || view.getId() == e.g.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.e.c.aHW().a(p.this.dTG, bbVar, 2);
                    } else if (view.getId() == e.g.header_divider) {
                        com.baidu.tieba.frs.f.h.a(p.this.dTG, bbVar.As());
                    } else if (view.getId() == e.g.frame_video) {
                        com.baidu.tieba.frs.e.c.aHW().a(p.this.dTG, bbVar, 4);
                        p.this.Z(bbVar);
                    } else if (view.getId() == e.g.card_god_reply_layout) {
                        p.this.Z(bbVar);
                    }
                    if (view.getId() == e.g.frame_video) {
                        com.baidu.tieba.frs.e.c.aHW().b(p.this.dTG, bbVar, 1);
                    } else if (view.getId() == e.g.card_home_page_normal_thread_user_name || view.getId() == e.g.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.e.c.aHW().b(p.this.dTG, bbVar, 2);
                    } else if (view.getId() == e.g.share_num_container) {
                        com.baidu.tieba.frs.e.c.aHW().b(p.this.dTG, bbVar, 5);
                    } else if (view.getId() == e.g.agree_view_container) {
                        com.baidu.tieba.frs.e.c.aHW().b(p.this.dTG, bbVar, 4);
                    } else {
                        com.baidu.tieba.frs.e.c.aHW().b(p.this.dTG, bbVar, 3);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        final com.baidu.tieba.frs.entelechy.view.a aVar = new com.baidu.tieba.frs.entelechy.view.a(this.mPageContext, this.mPageId);
        aVar.j(this.mPageId);
        aVar.setForumName(this.mForumName);
        if (aVar.cby != null) {
            aVar.cby.setInFrsAllThread(this.aKm);
        }
        aVar.iK(this.dTF);
        if (this.dTF != 15 && this.dTE && aVar.cbx != null) {
            aVar.cbx.setFrom(4);
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
        this.dUr = aVar;
        return new a(this.dUr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, a aVar) {
        if (aVar == null || aVar.arr() == null) {
            return null;
        }
        if (aVar.arr() instanceof com.baidu.tieba.a.e) {
            aVar.arr().setPage(this.cbl);
        }
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        com.baidu.tieba.frs.g.a(aVar.arr().acN(), this.dLd);
        com.baidu.tieba.frs.g.a(aVar.arr().acO(), this.dLd);
        aVar.arr().setVideoStatsData(X(bbVar));
        if (this.dLd != null && this.dLd.bhx() != null && !StringUtils.isNull(this.dLd.bhx().getTopic_special_icon()) && !StringUtils.isNull(this.dLd.bhx().getTopic_special_icon_right())) {
            aVar.arr().am(this.dLd.bhx().getTopic_special_icon(), this.dLd.bhx().getTopic_special_icon_right());
        }
        aVar.arr().a(bbVar);
        aVar.arr().setForumName(this.mForumName);
        aVar.arr().b(this.cbm);
        if (this.dLd != null) {
            aVar.arr().dUI = this.dLd.hnT;
        } else {
            aVar.arr().dUI = this.dSm;
        }
        if (this.dTG != null) {
            aVar.arr().dUJ = this.dTG.eeN;
            int i2 = 0;
            if (this.dLd != null) {
                i2 = this.dLd.aHA();
            }
            bbVar.awk = (i + 1) - i2;
        }
        com.baidu.tieba.frs.e.c.aHW().a(this.dTG, bbVar);
        com.baidu.tieba.frs.e.c.aHW().ad(bbVar);
        com.baidu.tieba.frs.e.a.a(bbVar, this.mPageId, this.dTG);
        if (bbVar != null) {
            TiebaStatic.log(new am("c12125").aB("tid", bbVar.getId()).y("obj_locate", aBJ() ? 2 : 1).i(VideoPlayActivityConfig.OBJ_ID, bbVar.An() != null ? bbVar.An().live_id : -1L).y("obj_type", 1));
            bbVar.AQ();
        }
        return aVar.getView();
    }

    private z X(bb bbVar) {
        if (bbVar == null) {
            return null;
        }
        z zVar = new z();
        zVar.mLocate = bbVar.AM() ? "3" : "2";
        if (this.dTG.eeN == 501) {
            zVar.mLocate = "frs_tab";
        }
        zVar.dbs = this.dTG.eeM;
        zVar.bjn = bbVar.getTid();
        zVar.mSource = bbVar.mRecomSource;
        zVar.gIJ = bbVar.avA;
        zVar.gIK = bbVar.mRecomWeight;
        zVar.gIM = bbVar.mRecomAbTag;
        if (bbVar.Al() != null) {
            zVar.gIN = bbVar.Al().video_md5;
        }
        return zVar;
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void iK(int i) {
        this.dTF = i;
    }

    @Override // com.baidu.tieba.a.f
    public void kb(String str) {
        this.cbl = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(bb bbVar) {
        TiebaStatic.log(new am("c12126").aB("tid", bbVar.getId()).y("obj_locate", aBJ() ? 2 : 1).i(VideoPlayActivityConfig.OBJ_ID, bbVar.An() == null ? -1L : bbVar.An().live_id).y("obj_type", 1));
    }

    public void setInFrsAllThread(boolean z) {
        this.aKm = z;
    }

    @Override // com.baidu.tieba.card.ac
    public void fA(boolean z) {
        this.dTE = z;
    }

    @Override // com.baidu.tieba.frs.e.d
    public com.baidu.tieba.frs.e.b aFf() {
        return this.dTG;
    }
}
