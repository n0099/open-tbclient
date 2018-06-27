package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.ac;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.d;
import com.baidu.tieba.play.y;
/* loaded from: classes2.dex */
public class p extends com.baidu.tieba.frs.h<bc, a<com.baidu.tieba.frs.entelechy.view.a>> implements com.baidu.tieba.a.f, ab, ac, com.baidu.tieba.frs.e.c {
    private boolean ayb;
    private String bGM;
    private ad<bc> bGN;
    private com.baidu.tieba.frs.entelechy.view.a drV;
    private boolean drj;
    private int drk;
    private com.baidu.tieba.frs.e.a drl;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.ayb = false;
        this.drj = false;
        this.drk = 3;
        this.drl = new com.baidu.tieba.frs.e.a();
        this.bGN = new ad<bc>() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                if (view != null && bcVar != null) {
                    if (p.this.djj != null) {
                        p.this.djj.a(view, bcVar, bc.aie);
                    }
                    if ("c13010".equals(p.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").r("obj_type", 2).f(ImageViewerConfig.FORUM_ID, bcVar.getFid()).ah("tid", bcVar.getTid()));
                    }
                    if (view.getId() == d.g.layout_root || (p.this.drV.bGZ != null && p.this.drV.bGZ.getCommentContainer() != null && view.getId() == p.this.drV.bGZ.getCommentContainer().getId())) {
                        com.baidu.tieba.frs.e.b.azw().a(p.this.drl, bcVar, 1);
                        p.this.W(bcVar);
                    } else if (view.getId() == d.g.card_home_page_normal_thread_user_name || view.getId() == d.g.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.e.b.azw().a(p.this.drl, bcVar, 2);
                    } else if (view.getId() == d.g.header_divider) {
                        com.baidu.tieba.frs.f.h.a(p.this.drl, bcVar.vT());
                    } else if (view.getId() == d.g.frame_video) {
                        com.baidu.tieba.frs.e.b.azw().a(p.this.drl, bcVar, 4);
                        p.this.W(bcVar);
                    } else if (view.getId() == d.g.card_god_reply_layout) {
                        p.this.W(bcVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ap */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.drV = new com.baidu.tieba.frs.entelechy.view.a(this.mPageContext, this.mPageId);
        this.drV.j(this.mPageId);
        this.drV.setForumName(this.mForumName);
        if (this.drV.bGZ != null) {
            this.drV.bGZ.setInFrsAllThread(this.ayb);
        }
        this.drV.hf(this.drk);
        if (this.drk != 15 && this.drj && this.drV.bGY != null) {
            this.drV.bGY.setFrom(4);
        }
        return new a(this.drV);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bc bcVar, a aVar) {
        if (aVar == null || aVar.aja() == null) {
            return null;
        }
        if (aVar.aja() instanceof com.baidu.tieba.a.e) {
            aVar.aja().setPage(this.bGM);
        }
        super.onFillViewHolder(i, view, viewGroup, bcVar, aVar);
        com.baidu.tieba.frs.g.a(aVar.aja().Vr(), this.djc);
        com.baidu.tieba.frs.g.a(aVar.aja().Vs(), this.djc);
        aVar.aja().setVideoStatsData(U(bcVar));
        if (this.djc != null && this.djc.baT() != null && !StringUtils.isNull(this.djc.baT().getTopic_special_icon()) && !StringUtils.isNull(this.djc.baT().getTopic_special_icon_right())) {
            aVar.aja().P(this.djc.baT().getTopic_special_icon(), this.djc.baT().getTopic_special_icon_right());
        }
        aVar.aja().a(bcVar);
        aVar.aja().setForumName(this.mForumName);
        aVar.aja().b(this.bGN);
        com.baidu.tieba.frs.e.b.azw().a(this.drl, bcVar);
        com.baidu.tieba.frs.e.b.azw().aa(bcVar);
        if (bcVar != null) {
            TiebaStatic.log(new an("c12125").ah("tid", bcVar.getId()).r("obj_locate", atx() ? 2 : 1).f(VideoPlayActivityConfig.OBJ_ID, bcVar.vO() != null ? bcVar.vO().live_id : -1L).r("obj_type", 1));
            bcVar.wq();
        }
        return aVar.getView();
    }

    private y U(bc bcVar) {
        if (bcVar == null) {
            return null;
        }
        y yVar = new y();
        yVar.mLocate = bcVar.wm() ? "3" : "2";
        yVar.czo = this.drl.dBT;
        yVar.aWo = bcVar.getTid();
        yVar.mSource = bcVar.mRecomSource;
        yVar.ghc = bcVar.ajQ;
        yVar.ghd = bcVar.mRecomWeight;
        yVar.ghf = bcVar.mRecomAbTag;
        if (bcVar.vN() != null) {
            yVar.ghg = bcVar.vN().video_md5;
        }
        return yVar;
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void hf(int i) {
        this.drk = i;
    }

    @Override // com.baidu.tieba.a.f
    public void iD(String str) {
        this.bGM = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(bc bcVar) {
        TiebaStatic.log(new an("c12126").ah("tid", bcVar.getId()).r("obj_locate", atx() ? 2 : 1).f(VideoPlayActivityConfig.OBJ_ID, bcVar.vO() == null ? -1L : bcVar.vO().live_id).r("obj_type", 1));
    }

    public void setInFrsAllThread(boolean z) {
        this.ayb = z;
    }

    @Override // com.baidu.tieba.card.ac
    public void ez(boolean z) {
        this.drj = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a awC() {
        return this.drl;
    }
}
