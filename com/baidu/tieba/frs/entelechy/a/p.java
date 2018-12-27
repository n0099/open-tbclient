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
    private boolean aJJ;
    private ad<bb> caA;
    private String caz;
    public boolean dRC;
    private boolean dSX;
    private int dSY;
    private com.baidu.tieba.frs.e.b dSZ;
    private com.baidu.tieba.frs.entelechy.view.a dTK;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.aJJ = false;
        this.dSX = false;
        this.dSY = 3;
        this.dSZ = new com.baidu.tieba.frs.e.b();
        this.caA = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (p.this.dKA != null) {
                        p.this.dKA.a(view, bbVar, bb.atj);
                    }
                    if ("c13010".equals(p.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").x("obj_type", 2).i(ImageViewerConfig.FORUM_ID, bbVar.getFid()).aA("tid", bbVar.getTid()));
                    }
                    if (view.getId() == e.g.card_home_page_normal_thread_user_name || view.getId() == e.g.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.e.a.a(bbVar, 2, p.this.mPageId, p.this.dSZ);
                    } else if (view.getId() == e.g.frame_video) {
                        com.baidu.tieba.frs.e.a.a(bbVar, 4, p.this.mPageId, p.this.dSZ);
                    } else if (view == p.this.dTK.caM.getCommentContainer()) {
                        com.baidu.tieba.frs.e.a.a(bbVar, 5, p.this.mPageId, p.this.dSZ);
                    } else {
                        com.baidu.tieba.frs.e.a.a(bbVar, 1, p.this.mPageId, p.this.dSZ);
                    }
                    if (view.getId() == e.g.layout_root || (p.this.dTK.caM != null && p.this.dTK.caM.getCommentContainer() != null && view.getId() == p.this.dTK.caM.getCommentContainer().getId())) {
                        com.baidu.tieba.frs.e.c.aHz().a(p.this.dSZ, bbVar, 1);
                        p.this.Z(bbVar);
                    } else if (view.getId() == e.g.card_home_page_normal_thread_user_name || view.getId() == e.g.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.e.c.aHz().a(p.this.dSZ, bbVar, 2);
                    } else if (view.getId() == e.g.header_divider) {
                        com.baidu.tieba.frs.f.h.a(p.this.dSZ, bbVar.Af());
                    } else if (view.getId() == e.g.frame_video) {
                        com.baidu.tieba.frs.e.c.aHz().a(p.this.dSZ, bbVar, 4);
                        p.this.Z(bbVar);
                    } else if (view.getId() == e.g.card_god_reply_layout) {
                        p.this.Z(bbVar);
                    }
                    if (view.getId() == e.g.frame_video) {
                        com.baidu.tieba.frs.e.c.aHz().b(p.this.dSZ, bbVar, 1);
                    } else if (view.getId() == e.g.card_home_page_normal_thread_user_name || view.getId() == e.g.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.e.c.aHz().b(p.this.dSZ, bbVar, 2);
                    } else if (view.getId() == e.g.share_num_container) {
                        com.baidu.tieba.frs.e.c.aHz().b(p.this.dSZ, bbVar, 5);
                    } else if (view.getId() == e.g.agree_view_container) {
                        com.baidu.tieba.frs.e.c.aHz().b(p.this.dSZ, bbVar, 4);
                    } else {
                        com.baidu.tieba.frs.e.c.aHz().b(p.this.dSZ, bbVar, 3);
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
        if (aVar.caM != null) {
            aVar.caM.setInFrsAllThread(this.aJJ);
        }
        aVar.iK(this.dSY);
        if (this.dSY != 15 && this.dSX && aVar.caL != null) {
            aVar.caL.setFrom(4);
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
        this.dTK = aVar;
        return new a(this.dTK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, a aVar) {
        if (aVar == null || aVar.aqT() == null) {
            return null;
        }
        if (aVar.aqT() instanceof com.baidu.tieba.a.e) {
            aVar.aqT().setPage(this.caz);
        }
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        com.baidu.tieba.frs.g.a(aVar.aqT().acq(), this.dKt);
        com.baidu.tieba.frs.g.a(aVar.aqT().acr(), this.dKt);
        aVar.aqT().setVideoStatsData(X(bbVar));
        if (this.dKt != null && this.dKt.bgT() != null && !StringUtils.isNull(this.dKt.bgT().getTopic_special_icon()) && !StringUtils.isNull(this.dKt.bgT().getTopic_special_icon_right())) {
            aVar.aqT().al(this.dKt.bgT().getTopic_special_icon(), this.dKt.bgT().getTopic_special_icon_right());
        }
        aVar.aqT().a(bbVar);
        aVar.aqT().setForumName(this.mForumName);
        aVar.aqT().b(this.caA);
        if (this.dKt != null) {
            aVar.aqT().dUb = this.dKt.hmN;
        } else {
            aVar.aqT().dUb = this.dRC;
        }
        if (this.dSZ != null) {
            aVar.aqT().dUc = this.dSZ.eeg;
            int i2 = 0;
            if (this.dKt != null) {
                i2 = this.dKt.aHd();
            }
            bbVar.avH = (i + 1) - i2;
        }
        com.baidu.tieba.frs.e.c.aHz().a(this.dSZ, bbVar);
        com.baidu.tieba.frs.e.c.aHz().ad(bbVar);
        com.baidu.tieba.frs.e.a.a(bbVar, this.mPageId, this.dSZ);
        if (bbVar != null) {
            TiebaStatic.log(new am("c12125").aA("tid", bbVar.getId()).x("obj_locate", aBm() ? 2 : 1).i(VideoPlayActivityConfig.OBJ_ID, bbVar.Aa() != null ? bbVar.Aa().live_id : -1L).x("obj_type", 1));
            bbVar.AD();
        }
        return aVar.getView();
    }

    private z X(bb bbVar) {
        if (bbVar == null) {
            return null;
        }
        z zVar = new z();
        zVar.mLocate = bbVar.Az() ? "3" : "2";
        if (this.dSZ.eeg == 501) {
            zVar.mLocate = "frs_tab";
        }
        zVar.daG = this.dSZ.eef;
        zVar.biz = bbVar.getTid();
        zVar.mSource = bbVar.mRecomSource;
        zVar.gHE = bbVar.auX;
        zVar.gHF = bbVar.mRecomWeight;
        zVar.gHH = bbVar.mRecomAbTag;
        if (bbVar.zY() != null) {
            zVar.gHI = bbVar.zY().video_md5;
        }
        return zVar;
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void iK(int i) {
        this.dSY = i;
    }

    @Override // com.baidu.tieba.a.f
    public void jL(String str) {
        this.caz = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(bb bbVar) {
        TiebaStatic.log(new am("c12126").aA("tid", bbVar.getId()).x("obj_locate", aBm() ? 2 : 1).i(VideoPlayActivityConfig.OBJ_ID, bbVar.Aa() == null ? -1L : bbVar.Aa().live_id).x("obj_type", 1));
    }

    public void setInFrsAllThread(boolean z) {
        this.aJJ = z;
    }

    @Override // com.baidu.tieba.card.ac
    public void fx(boolean z) {
        this.dSX = z;
    }

    @Override // com.baidu.tieba.frs.e.d
    public com.baidu.tieba.frs.e.b aEI() {
        return this.dSZ;
    }
}
