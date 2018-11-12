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
    private boolean aGh;
    private String bWE;
    private ad<bb> bWF;
    public boolean dIp;
    private boolean dJD;
    private int dJE;
    private com.baidu.tieba.frs.e.a dJF;
    private com.baidu.tieba.frs.entelechy.view.a dKq;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.aGh = false;
        this.dJD = false;
        this.dJE = 3;
        this.dJF = new com.baidu.tieba.frs.e.a();
        this.bWF = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (p.this.dBn != null) {
                        p.this.dBn.a(view, bbVar, bb.apJ);
                    }
                    if ("c13010".equals(p.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").x("obj_type", 2).h(ImageViewerConfig.FORUM_ID, bbVar.getFid()).ax("tid", bbVar.getTid()));
                    }
                    if (view.getId() == e.g.layout_root || (p.this.dKq.bWR != null && p.this.dKq.bWR.getCommentContainer() != null && view.getId() == p.this.dKq.bWR.getCommentContainer().getId())) {
                        com.baidu.tieba.frs.e.b.aEY().a(p.this.dJF, bbVar, 1);
                        p.this.Z(bbVar);
                    } else if (view.getId() == e.g.card_home_page_normal_thread_user_name || view.getId() == e.g.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.e.b.aEY().a(p.this.dJF, bbVar, 2);
                    } else if (view.getId() == e.g.header_divider) {
                        com.baidu.tieba.frs.f.h.a(p.this.dJF, bbVar.zb());
                    } else if (view.getId() == e.g.frame_video) {
                        com.baidu.tieba.frs.e.b.aEY().a(p.this.dJF, bbVar, 4);
                        p.this.Z(bbVar);
                    } else if (view.getId() == e.g.card_god_reply_layout) {
                        p.this.Z(bbVar);
                    }
                    if (view.getId() == e.g.frame_video) {
                        com.baidu.tieba.frs.e.b.aEY().b(p.this.dJF, bbVar, 1);
                    } else if (view.getId() == e.g.card_home_page_normal_thread_user_name || view.getId() == e.g.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.e.b.aEY().b(p.this.dJF, bbVar, 2);
                    } else if (view.getId() == e.g.share_num_container) {
                        com.baidu.tieba.frs.e.b.aEY().b(p.this.dJF, bbVar, 5);
                    } else if (view.getId() == e.g.agree_view_container) {
                        com.baidu.tieba.frs.e.b.aEY().b(p.this.dJF, bbVar, 4);
                    } else {
                        com.baidu.tieba.frs.e.b.aEY().b(p.this.dJF, bbVar, 3);
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
        if (aVar.bWR != null) {
            aVar.bWR.setInFrsAllThread(this.aGh);
        }
        aVar.iv(this.dJE);
        if (this.dJE != 15 && this.dJD && aVar.bWQ != null) {
            aVar.bWQ.setFrom(4);
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
        this.dKq = aVar;
        return new a(this.dKq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, a aVar) {
        if (aVar == null || aVar.aor() == null) {
            return null;
        }
        if (aVar.aor() instanceof com.baidu.tieba.a.e) {
            aVar.aor().setPage(this.bWE);
        }
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        com.baidu.tieba.frs.g.a(aVar.aor().abi(), this.dBg);
        com.baidu.tieba.frs.g.a(aVar.aor().abj(), this.dBg);
        aVar.aor().setVideoStatsData(X(bbVar));
        if (this.dBg != null && this.dBg.ber() != null && !StringUtils.isNull(this.dBg.ber().getTopic_special_icon()) && !StringUtils.isNull(this.dBg.ber().getTopic_special_icon_right())) {
            aVar.aor().ai(this.dBg.ber().getTopic_special_icon(), this.dBg.ber().getTopic_special_icon_right());
        }
        aVar.aor().a(bbVar);
        aVar.aor().setForumName(this.mForumName);
        aVar.aor().b(this.bWF);
        if (this.dBg != null) {
            aVar.aor().dKH = this.dBg.hcJ;
        } else {
            aVar.aor().dKH = this.dIp;
        }
        if (this.dJF != null) {
            aVar.aor().dKI = this.dJF.dUM;
        }
        com.baidu.tieba.frs.e.b.aEY().a(this.dJF, bbVar);
        com.baidu.tieba.frs.e.b.aEY().ad(bbVar);
        if (bbVar != null) {
            TiebaStatic.log(new am("c12125").ax("tid", bbVar.getId()).x("obj_locate", ayN() ? 2 : 1).h(VideoPlayActivityConfig.OBJ_ID, bbVar.yW() != null ? bbVar.yW().live_id : -1L).x("obj_type", 1));
            bbVar.zz();
        }
        return aVar.getView();
    }

    private z X(bb bbVar) {
        if (bbVar == null) {
            return null;
        }
        z zVar = new z();
        zVar.mLocate = bbVar.zv() ? "3" : "2";
        if (this.dJF.dUM == 501) {
            zVar.mLocate = "frs_tab";
        }
        zVar.cRh = this.dJF.dUL;
        zVar.beV = bbVar.getTid();
        zVar.mSource = bbVar.mRecomSource;
        zVar.gxX = bbVar.arx;
        zVar.gxY = bbVar.mRecomWeight;
        zVar.gya = bbVar.mRecomAbTag;
        if (bbVar.yU() != null) {
            zVar.gyb = bbVar.yU().video_md5;
        }
        return zVar;
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void iv(int i) {
        this.dJE = i;
    }

    @Override // com.baidu.tieba.a.f
    public void js(String str) {
        this.bWE = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(bb bbVar) {
        TiebaStatic.log(new am("c12126").ax("tid", bbVar.getId()).x("obj_locate", ayN() ? 2 : 1).h(VideoPlayActivityConfig.OBJ_ID, bbVar.yW() == null ? -1L : bbVar.yW().live_id).x("obj_type", 1));
    }

    public void setInFrsAllThread(boolean z) {
        this.aGh = z;
    }

    @Override // com.baidu.tieba.card.ac
    public void fu(boolean z) {
        this.dJD = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a aCh() {
        return this.dJF;
    }
}
