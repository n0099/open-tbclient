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
    private boolean aJH;
    private String caw;
    private ad<bb> cax;
    public boolean dOO;
    private com.baidu.tieba.frs.entelechy.view.a dQT;
    private boolean dQg;
    private int dQh;
    private com.baidu.tieba.frs.e.a dQi;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.aJH = false;
        this.dQg = false;
        this.dQh = 3;
        this.dQi = new com.baidu.tieba.frs.e.a();
        this.cax = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (p.this.dHM != null) {
                        p.this.dHM.a(view, bbVar, bb.atj);
                    }
                    if ("c13010".equals(p.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").x("obj_type", 2).i(ImageViewerConfig.FORUM_ID, bbVar.getFid()).aA("tid", bbVar.getTid()));
                    }
                    if (view.getId() == e.g.layout_root || (p.this.dQT.caJ != null && p.this.dQT.caJ.getCommentContainer() != null && view.getId() == p.this.dQT.caJ.getCommentContainer().getId())) {
                        com.baidu.tieba.frs.e.b.aGK().a(p.this.dQi, bbVar, 1);
                        p.this.Z(bbVar);
                    } else if (view.getId() == e.g.card_home_page_normal_thread_user_name || view.getId() == e.g.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.e.b.aGK().a(p.this.dQi, bbVar, 2);
                    } else if (view.getId() == e.g.header_divider) {
                        com.baidu.tieba.frs.f.h.a(p.this.dQi, bbVar.Af());
                    } else if (view.getId() == e.g.frame_video) {
                        com.baidu.tieba.frs.e.b.aGK().a(p.this.dQi, bbVar, 4);
                        p.this.Z(bbVar);
                    } else if (view.getId() == e.g.card_god_reply_layout) {
                        p.this.Z(bbVar);
                    }
                    if (view.getId() == e.g.frame_video) {
                        com.baidu.tieba.frs.e.b.aGK().b(p.this.dQi, bbVar, 1);
                    } else if (view.getId() == e.g.card_home_page_normal_thread_user_name || view.getId() == e.g.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.e.b.aGK().b(p.this.dQi, bbVar, 2);
                    } else if (view.getId() == e.g.share_num_container) {
                        com.baidu.tieba.frs.e.b.aGK().b(p.this.dQi, bbVar, 5);
                    } else if (view.getId() == e.g.agree_view_container) {
                        com.baidu.tieba.frs.e.b.aGK().b(p.this.dQi, bbVar, 4);
                    } else {
                        com.baidu.tieba.frs.e.b.aGK().b(p.this.dQi, bbVar, 3);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ar */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        final com.baidu.tieba.frs.entelechy.view.a aVar = new com.baidu.tieba.frs.entelechy.view.a(this.mPageContext, this.mPageId);
        aVar.j(this.mPageId);
        aVar.setForumName(this.mForumName);
        if (aVar.caJ != null) {
            aVar.caJ.setInFrsAllThread(this.aJH);
        }
        aVar.iJ(this.dQh);
        if (this.dQh != 15 && this.dQg && aVar.caI != null) {
            aVar.caI.setFrom(4);
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
        this.dQT = aVar;
        return new a(this.dQT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, a aVar) {
        if (aVar == null || aVar.aqe() == null) {
            return null;
        }
        if (aVar.aqe() instanceof com.baidu.tieba.a.e) {
            aVar.aqe().setPage(this.caw);
        }
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        com.baidu.tieba.frs.g.a(aVar.aqe().aco(), this.dHF);
        com.baidu.tieba.frs.g.a(aVar.aqe().acp(), this.dHF);
        aVar.aqe().setVideoStatsData(X(bbVar));
        if (this.dHF != null && this.dHF.bgh() != null && !StringUtils.isNull(this.dHF.bgh().getTopic_special_icon()) && !StringUtils.isNull(this.dHF.bgh().getTopic_special_icon_right())) {
            aVar.aqe().al(this.dHF.bgh().getTopic_special_icon(), this.dHF.bgh().getTopic_special_icon_right());
        }
        aVar.aqe().a(bbVar);
        aVar.aqe().setForumName(this.mForumName);
        aVar.aqe().b(this.cax);
        if (this.dHF != null) {
            aVar.aqe().dRk = this.dHF.hjC;
        } else {
            aVar.aqe().dRk = this.dOO;
        }
        if (this.dQi != null) {
            aVar.aqe().dRl = this.dQi.ebp;
        }
        com.baidu.tieba.frs.e.b.aGK().a(this.dQi, bbVar);
        com.baidu.tieba.frs.e.b.aGK().ad(bbVar);
        if (bbVar != null) {
            TiebaStatic.log(new am("c12125").aA("tid", bbVar.getId()).x("obj_locate", aAx() ? 2 : 1).i(VideoPlayActivityConfig.OBJ_ID, bbVar.Aa() != null ? bbVar.Aa().live_id : -1L).x("obj_type", 1));
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
        if (this.dQi.ebp == 501) {
            zVar.mLocate = "frs_tab";
        }
        zVar.cXO = this.dQi.ebo;
        zVar.biw = bbVar.getTid();
        zVar.mSource = bbVar.mRecomSource;
        zVar.gEN = bbVar.auX;
        zVar.gEO = bbVar.mRecomWeight;
        zVar.gEQ = bbVar.mRecomAbTag;
        if (bbVar.zY() != null) {
            zVar.gER = bbVar.zY().video_md5;
        }
        return zVar;
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void iJ(int i) {
        this.dQh = i;
    }

    @Override // com.baidu.tieba.a.f
    public void jK(String str) {
        this.caw = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(bb bbVar) {
        TiebaStatic.log(new am("c12126").aA("tid", bbVar.getId()).x("obj_locate", aAx() ? 2 : 1).i(VideoPlayActivityConfig.OBJ_ID, bbVar.Aa() == null ? -1L : bbVar.Aa().live_id).x("obj_type", 1));
    }

    public void setInFrsAllThread(boolean z) {
        this.aJH = z;
    }

    @Override // com.baidu.tieba.card.ac
    public void fv(boolean z) {
        this.dQg = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a aDT() {
        return this.dQi;
    }
}
