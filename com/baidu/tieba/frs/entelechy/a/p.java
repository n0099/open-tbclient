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
import com.baidu.tieba.play.y;
/* loaded from: classes2.dex */
public class p extends com.baidu.tieba.frs.h<bb, a<com.baidu.tieba.frs.entelechy.view.a>> implements com.baidu.tieba.a.f, ab, ac, com.baidu.tieba.frs.e.c {
    private boolean aAK;
    private String bNq;
    private ad<bb> bNr;
    private int dAA;
    private com.baidu.tieba.frs.e.a dAB;
    private boolean dAz;
    private com.baidu.tieba.frs.entelechy.view.a dBm;
    public boolean dyU;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.aAK = false;
        this.dAz = false;
        this.dAA = 3;
        this.dAB = new com.baidu.tieba.frs.e.a();
        this.bNr = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (p.this.drU != null) {
                        p.this.drU.a(view, bbVar, bb.aka);
                    }
                    if ("c13010".equals(p.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").w("obj_type", 2).g(ImageViewerConfig.FORUM_ID, bbVar.getFid()).al("tid", bbVar.getTid()));
                    }
                    if (view.getId() == e.g.layout_root || (p.this.dBm.bND != null && p.this.dBm.bND.getCommentContainer() != null && view.getId() == p.this.dBm.bND.getCommentContainer().getId())) {
                        com.baidu.tieba.frs.e.b.aCj().a(p.this.dAB, bbVar, 1);
                        p.this.Z(bbVar);
                    } else if (view.getId() == e.g.card_home_page_normal_thread_user_name || view.getId() == e.g.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.e.b.aCj().a(p.this.dAB, bbVar, 2);
                    } else if (view.getId() == e.g.header_divider) {
                        com.baidu.tieba.frs.f.h.a(p.this.dAB, bbVar.wL());
                    } else if (view.getId() == e.g.frame_video) {
                        com.baidu.tieba.frs.e.b.aCj().a(p.this.dAB, bbVar, 4);
                        p.this.Z(bbVar);
                    } else if (view.getId() == e.g.card_god_reply_layout) {
                        p.this.Z(bbVar);
                    }
                    if (view.getId() == e.g.frame_video) {
                        com.baidu.tieba.frs.e.b.aCj().b(p.this.dAB, bbVar, 1);
                    } else if (view.getId() == e.g.card_home_page_normal_thread_user_name || view.getId() == e.g.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.e.b.aCj().b(p.this.dAB, bbVar, 2);
                    } else if (view.getId() == e.g.share_num_container) {
                        com.baidu.tieba.frs.e.b.aCj().b(p.this.dAB, bbVar, 5);
                    } else if (view.getId() == e.g.agree_view_container) {
                        com.baidu.tieba.frs.e.b.aCj().b(p.this.dAB, bbVar, 4);
                    } else {
                        com.baidu.tieba.frs.e.b.aCj().b(p.this.dAB, bbVar, 3);
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
        if (aVar.bND != null) {
            aVar.bND.setInFrsAllThread(this.aAK);
        }
        aVar.hK(this.dAA);
        if (this.dAA != 15 && this.dAz && aVar.bNC != null) {
            aVar.bNC.setFrom(4);
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
        this.dBm = aVar;
        return new a(this.dBm);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, a aVar) {
        if (aVar == null || aVar.aln() == null) {
            return null;
        }
        if (aVar.aln() instanceof com.baidu.tieba.a.e) {
            aVar.aln().setPage(this.bNq);
        }
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        com.baidu.tieba.frs.g.a(aVar.aln().Xq(), this.drN);
        com.baidu.tieba.frs.g.a(aVar.aln().Xr(), this.drN);
        aVar.aln().setVideoStatsData(X(bbVar));
        if (this.drN != null && this.drN.bbH() != null && !StringUtils.isNull(this.drN.bbH().getTopic_special_icon()) && !StringUtils.isNull(this.drN.bbH().getTopic_special_icon_right())) {
            aVar.aln().V(this.drN.bbH().getTopic_special_icon(), this.drN.bbH().getTopic_special_icon_right());
        }
        aVar.aln().a(bbVar);
        aVar.aln().setForumName(this.mForumName);
        aVar.aln().b(this.bNr);
        if (this.drN != null) {
            aVar.aln().dBD = this.drN.gTQ;
        } else {
            aVar.aln().dBD = this.dyU;
        }
        if (this.dAB != null) {
            aVar.aln().dBE = this.dAB.dLK;
        }
        com.baidu.tieba.frs.e.b.aCj().a(this.dAB, bbVar);
        com.baidu.tieba.frs.e.b.aCj().ad(bbVar);
        if (bbVar != null) {
            TiebaStatic.log(new am("c12125").al("tid", bbVar.getId()).w("obj_locate", avT() ? 2 : 1).g(VideoPlayActivityConfig.OBJ_ID, bbVar.wG() != null ? bbVar.wG().live_id : -1L).w("obj_type", 1));
            bbVar.xj();
        }
        return aVar.getView();
    }

    private y X(bb bbVar) {
        if (bbVar == null) {
            return null;
        }
        y yVar = new y();
        yVar.mLocate = bbVar.xf() ? "3" : "2";
        if (this.dAB.dLK == 501) {
            yVar.mLocate = "frs_tab";
        }
        yVar.cHI = this.dAB.dLJ;
        yVar.aZG = bbVar.getTid();
        yVar.mSource = bbVar.mRecomSource;
        yVar.goU = bbVar.alP;
        yVar.goV = bbVar.mRecomWeight;
        yVar.goX = bbVar.mRecomAbTag;
        if (bbVar.wE() != null) {
            yVar.goY = bbVar.wE().video_md5;
        }
        return yVar;
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void hK(int i) {
        this.dAA = i;
    }

    @Override // com.baidu.tieba.a.f
    public void jd(String str) {
        this.bNq = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(bb bbVar) {
        TiebaStatic.log(new am("c12126").al("tid", bbVar.getId()).w("obj_locate", avT() ? 2 : 1).g(VideoPlayActivityConfig.OBJ_ID, bbVar.wG() == null ? -1L : bbVar.wG().live_id).w("obj_type", 1));
    }

    public void setInFrsAllThread(boolean z) {
        this.aAK = z;
    }

    @Override // com.baidu.tieba.card.ac
    public void eR(boolean z) {
        this.dAz = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a azt() {
        return this.dAB;
    }
}
