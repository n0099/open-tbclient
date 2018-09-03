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
import com.baidu.tieba.f;
import com.baidu.tieba.play.y;
/* loaded from: classes2.dex */
public class p extends com.baidu.tieba.frs.h<bb, a<com.baidu.tieba.frs.entelechy.view.a>> implements com.baidu.tieba.a.f, ab, ac, com.baidu.tieba.frs.e.c {
    private boolean axE;
    private String bHB;
    private ad<bb> bHC;
    private boolean dtT;
    private int dtU;
    private com.baidu.tieba.frs.e.a dtV;
    private com.baidu.tieba.frs.entelechy.view.a duF;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.axE = false;
        this.dtT = false;
        this.dtU = 3;
        this.dtV = new com.baidu.tieba.frs.e.a();
        this.bHC = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (p.this.dlX != null) {
                        p.this.dlX.a(view, bbVar, bb.ahA);
                    }
                    if ("c13010".equals(p.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").r("obj_type", 2).f(ImageViewerConfig.FORUM_ID, bbVar.getFid()).ae("tid", bbVar.getTid()));
                    }
                    if (view.getId() == f.g.layout_root || (p.this.duF.bHO != null && p.this.duF.bHO.getCommentContainer() != null && view.getId() == p.this.duF.bHO.getCommentContainer().getId())) {
                        com.baidu.tieba.frs.e.b.aAa().a(p.this.dtV, bbVar, 1);
                        p.this.Y(bbVar);
                    } else if (view.getId() == f.g.card_home_page_normal_thread_user_name || view.getId() == f.g.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.e.b.aAa().a(p.this.dtV, bbVar, 2);
                    } else if (view.getId() == f.g.header_divider) {
                        com.baidu.tieba.frs.f.h.a(p.this.dtV, bbVar.vH());
                    } else if (view.getId() == f.g.frame_video) {
                        com.baidu.tieba.frs.e.b.aAa().a(p.this.dtV, bbVar, 4);
                        p.this.Y(bbVar);
                    } else if (view.getId() == f.g.card_god_reply_layout) {
                        p.this.Y(bbVar);
                    }
                    if (view.getId() == f.g.frame_video) {
                        com.baidu.tieba.frs.e.b.aAa().b(p.this.dtV, bbVar, 1);
                    } else if (view.getId() == f.g.card_home_page_normal_thread_user_name || view.getId() == f.g.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.e.b.aAa().b(p.this.dtV, bbVar, 2);
                    } else if (view.getId() == f.g.share_num_container) {
                        com.baidu.tieba.frs.e.b.aAa().b(p.this.dtV, bbVar, 5);
                    } else if (view.getId() == f.g.agree_view_container) {
                        com.baidu.tieba.frs.e.b.aAa().b(p.this.dtV, bbVar, 4);
                    } else {
                        com.baidu.tieba.frs.e.b.aAa().b(p.this.dtV, bbVar, 3);
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
        this.duF = new com.baidu.tieba.frs.entelechy.view.a(this.mPageContext, this.mPageId);
        this.duF.j(this.mPageId);
        this.duF.setForumName(this.mForumName);
        if (this.duF.bHO != null) {
            this.duF.bHO.setInFrsAllThread(this.axE);
        }
        this.duF.hk(this.dtU);
        if (this.dtU != 15 && this.dtT && this.duF.bHN != null) {
            this.duF.bHN.setFrom(4);
        }
        return new a(this.duF);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, a aVar) {
        if (aVar == null || aVar.ajC() == null) {
            return null;
        }
        if (aVar.ajC() instanceof com.baidu.tieba.a.e) {
            aVar.ajC().setPage(this.bHB);
        }
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        com.baidu.tieba.frs.g.a(aVar.ajC().VD(), this.dlQ);
        com.baidu.tieba.frs.g.a(aVar.ajC().VE(), this.dlQ);
        aVar.ajC().setVideoStatsData(W(bbVar));
        if (this.dlQ != null && this.dlQ.aZg() != null && !StringUtils.isNull(this.dlQ.aZg().getTopic_special_icon()) && !StringUtils.isNull(this.dlQ.aZg().getTopic_special_icon_right())) {
            aVar.ajC().O(this.dlQ.aZg().getTopic_special_icon(), this.dlQ.aZg().getTopic_special_icon_right());
        }
        aVar.ajC().a(bbVar);
        aVar.ajC().setForumName(this.mForumName);
        aVar.ajC().b(this.bHC);
        if (this.dlQ != null) {
            aVar.ajC().duV = this.dlQ.gMo;
        }
        com.baidu.tieba.frs.e.b.aAa().a(this.dtV, bbVar);
        com.baidu.tieba.frs.e.b.aAa().ac(bbVar);
        if (bbVar != null) {
            TiebaStatic.log(new an("c12125").ae("tid", bbVar.getId()).r("obj_locate", aua() ? 2 : 1).f(VideoPlayActivityConfig.OBJ_ID, bbVar.vC() != null ? bbVar.vC().live_id : -1L).r("obj_type", 1));
            bbVar.we();
        }
        return aVar.getView();
    }

    private y W(bb bbVar) {
        if (bbVar == null) {
            return null;
        }
        y yVar = new y();
        yVar.mLocate = bbVar.wa() ? "3" : "2";
        yVar.cBR = this.dtV.dEC;
        yVar.aWq = bbVar.getTid();
        yVar.mSource = bbVar.mRecomSource;
        yVar.ghB = bbVar.ajn;
        yVar.ghC = bbVar.mRecomWeight;
        yVar.ghE = bbVar.mRecomAbTag;
        if (bbVar.vB() != null) {
            yVar.ghF = bbVar.vB().video_md5;
        }
        return yVar;
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void hk(int i) {
        this.dtU = i;
    }

    @Override // com.baidu.tieba.a.f
    public void iB(String str) {
        this.bHB = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(bb bbVar) {
        TiebaStatic.log(new an("c12126").ae("tid", bbVar.getId()).r("obj_locate", aua() ? 2 : 1).f(VideoPlayActivityConfig.OBJ_ID, bbVar.vC() == null ? -1L : bbVar.vC().live_id).r("obj_type", 1));
    }

    public void setInFrsAllThread(boolean z) {
        this.axE = z;
    }

    @Override // com.baidu.tieba.card.ac
    public void eA(boolean z) {
        this.dtT = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a axg() {
        return this.dtV;
    }
}
