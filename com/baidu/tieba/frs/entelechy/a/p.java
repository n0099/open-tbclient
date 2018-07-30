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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.ac;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.d;
import com.baidu.tieba.play.y;
/* loaded from: classes2.dex */
public class p extends com.baidu.tieba.frs.h<bb, a<com.baidu.tieba.frs.entelechy.view.a>> implements com.baidu.tieba.a.f, ab, ac, com.baidu.tieba.frs.e.c {
    private boolean axH;
    private String bHB;
    private ad<bb> bHC;
    private boolean dtW;
    private int dtX;
    private com.baidu.tieba.frs.e.a dtY;
    private com.baidu.tieba.frs.entelechy.view.a duI;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.axH = false;
        this.dtW = false;
        this.dtX = 3;
        this.dtY = new com.baidu.tieba.frs.e.a();
        this.bHC = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (p.this.dlZ != null) {
                        p.this.dlZ.a(view, bbVar, bb.ahA);
                    }
                    if ("c13010".equals(p.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").r("obj_type", 2).f(ImageViewerConfig.FORUM_ID, bbVar.getFid()).af("tid", bbVar.getTid()));
                    }
                    if (view.getId() == d.g.layout_root || (p.this.duI.bHO != null && p.this.duI.bHO.getCommentContainer() != null && view.getId() == p.this.duI.bHO.getCommentContainer().getId())) {
                        com.baidu.tieba.frs.e.b.aAd().a(p.this.dtY, bbVar, 1);
                        p.this.Y(bbVar);
                    } else if (view.getId() == d.g.card_home_page_normal_thread_user_name || view.getId() == d.g.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.e.b.aAd().a(p.this.dtY, bbVar, 2);
                    } else if (view.getId() == d.g.header_divider) {
                        com.baidu.tieba.frs.f.h.a(p.this.dtY, bbVar.vI());
                    } else if (view.getId() == d.g.frame_video) {
                        com.baidu.tieba.frs.e.b.aAd().a(p.this.dtY, bbVar, 4);
                        p.this.Y(bbVar);
                    } else if (view.getId() == d.g.card_god_reply_layout) {
                        p.this.Y(bbVar);
                    }
                    if (view.getId() == d.g.frame_video) {
                        com.baidu.tieba.frs.e.b.aAd().b(p.this.dtY, bbVar, 1);
                    } else if (view.getId() == d.g.card_home_page_normal_thread_user_name || view.getId() == d.g.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.e.b.aAd().b(p.this.dtY, bbVar, 2);
                    } else if (view.getId() == d.g.share_num_container) {
                        com.baidu.tieba.frs.e.b.aAd().b(p.this.dtY, bbVar, 5);
                    } else if (view.getId() == d.g.agree_view_container) {
                        com.baidu.tieba.frs.e.b.aAd().b(p.this.dtY, bbVar, 4);
                    } else {
                        com.baidu.tieba.frs.e.b.aAd().b(p.this.dtY, bbVar, 3);
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
        this.duI = new com.baidu.tieba.frs.entelechy.view.a(this.mPageContext, this.mPageId);
        this.duI.j(this.mPageId);
        this.duI.setForumName(this.mForumName);
        if (this.duI.bHO != null) {
            this.duI.bHO.setInFrsAllThread(this.axH);
        }
        this.duI.hl(this.dtX);
        if (this.dtX != 15 && this.dtW && this.duI.bHN != null) {
            this.duI.bHN.setFrom(4);
        }
        return new a(this.duI);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, a aVar) {
        if (aVar == null || aVar.ajz() == null) {
            return null;
        }
        if (aVar.ajz() instanceof com.baidu.tieba.a.e) {
            aVar.ajz().setPage(this.bHB);
        }
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        com.baidu.tieba.frs.g.a(aVar.ajz().VA(), this.dlS);
        com.baidu.tieba.frs.g.a(aVar.ajz().VB(), this.dlS);
        aVar.ajz().setVideoStatsData(W(bbVar));
        if (this.dlS != null && this.dlS.aZl() != null && !StringUtils.isNull(this.dlS.aZl().getTopic_special_icon()) && !StringUtils.isNull(this.dlS.aZl().getTopic_special_icon_right())) {
            aVar.ajz().O(this.dlS.aZl().getTopic_special_icon(), this.dlS.aZl().getTopic_special_icon_right());
        }
        aVar.ajz().a(bbVar);
        aVar.ajz().setForumName(this.mForumName);
        aVar.ajz().b(this.bHC);
        if (this.dlS != null) {
            aVar.ajz().duY = this.dlS.gMm;
        }
        com.baidu.tieba.frs.e.b.aAd().a(this.dtY, bbVar);
        com.baidu.tieba.frs.e.b.aAd().ac(bbVar);
        if (bbVar != null) {
            TiebaStatic.log(new an("c12125").af("tid", bbVar.getId()).r("obj_locate", aub() ? 2 : 1).f(VideoPlayActivityConfig.OBJ_ID, bbVar.vD() != null ? bbVar.vD().live_id : -1L).r("obj_type", 1));
            bbVar.wf();
        }
        return aVar.getView();
    }

    private y W(bb bbVar) {
        if (bbVar == null) {
            return null;
        }
        y yVar = new y();
        yVar.mLocate = bbVar.wb() ? "3" : "2";
        yVar.cBU = this.dtY.dEF;
        yVar.aWq = bbVar.getTid();
        yVar.mSource = bbVar.mRecomSource;
        yVar.ghC = bbVar.ajn;
        yVar.ghD = bbVar.mRecomWeight;
        yVar.ghF = bbVar.mRecomAbTag;
        if (bbVar.vC() != null) {
            yVar.ghG = bbVar.vC().video_md5;
        }
        return yVar;
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void hl(int i) {
        this.dtX = i;
    }

    @Override // com.baidu.tieba.a.f
    public void iA(String str) {
        this.bHB = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(bb bbVar) {
        TiebaStatic.log(new an("c12126").af("tid", bbVar.getId()).r("obj_locate", aub() ? 2 : 1).f(VideoPlayActivityConfig.OBJ_ID, bbVar.vD() == null ? -1L : bbVar.vD().live_id).r("obj_type", 1));
    }

    public void setInFrsAllThread(boolean z) {
        this.axH = z;
    }

    @Override // com.baidu.tieba.card.ac
    public void eA(boolean z) {
        this.dtW = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a axh() {
        return this.dtY;
    }
}
