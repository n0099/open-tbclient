package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.play.y;
/* loaded from: classes2.dex */
public class p extends com.baidu.tieba.frs.f<bd, a<com.baidu.tieba.frs.entelechy.view.a>> implements com.baidu.tieba.a.f, aa, com.baidu.tieba.frs.e.c {
    private String bwO;
    private ab<bd> bwP;
    private com.baidu.tieba.frs.entelechy.view.a dfx;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.bwP = new ab<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, bd bdVar) {
                if (view2 != null && bdVar != null) {
                    if ("c13010".equals(p.this.mFrom)) {
                        TiebaStatic.log(new al("c13010").r("obj_type", 2).f(ImageViewerConfig.FORUM_ID, bdVar.getFid()).ac("tid", bdVar.getTid()));
                    }
                    if (view2.getId() == d.g.layout_root || (p.this.dfx.bxb != null && p.this.dfx.bxb.getCommentContainer() != null && view2.getId() == p.this.dfx.bxb.getCommentContainer().getId())) {
                        com.baidu.tieba.frs.e.b.auG().a(com.baidu.tieba.frs.e.c.dpD, bdVar, 1);
                        p.this.S(bdVar);
                    } else if (view2.getId() == d.g.card_home_page_normal_thread_user_name || view2.getId() == d.g.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.e.b.auG().a(com.baidu.tieba.frs.e.c.dpD, bdVar, 2);
                    } else if (view2.getId() == d.g.header_divider) {
                        com.baidu.tieba.frs.f.g.a(com.baidu.tieba.frs.e.c.dpD, bdVar.sm());
                    } else if (view2.getId() == d.g.frame_video) {
                        com.baidu.tieba.frs.e.b.auG().a(com.baidu.tieba.frs.e.c.dpD, bdVar, 4);
                        p.this.S(bdVar);
                    } else if (view2.getId() == d.g.card_god_reply_layout) {
                        p.this.S(bdVar);
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
        this.dfx = new com.baidu.tieba.frs.entelechy.view.a(this.mPageContext, this.mPageId);
        this.dfx.j(this.mPageId);
        this.dfx.setForumName(this.mForumName);
        return new a(this.dfx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, bd bdVar, a aVar) {
        if (aVar == null || aVar.afY() == null) {
            return null;
        }
        if (aVar.afY() instanceof com.baidu.tieba.a.e) {
            aVar.afY().setPage(this.bwO);
        }
        com.baidu.tieba.frs.e.a(aVar.afY().afz(), this.cXS);
        com.baidu.tieba.frs.e.a(aVar.afY().afA(), this.cXS);
        aVar.afY().setVideoStatsData(Q(bdVar));
        if (this.cXS != null && this.cXS.aVq() != null && !StringUtils.isNull(this.cXS.aVq().getTopic_special_icon()) && !StringUtils.isNull(this.cXS.aVq().getTopic_special_icon_right())) {
            aVar.afY().M(this.cXS.aVq().getTopic_special_icon(), this.cXS.aVq().getTopic_special_icon_right());
        }
        aVar.afY().a(bdVar);
        aVar.afY().setForumName(this.mForumName);
        aVar.afY().b(this.bwP);
        com.baidu.tieba.frs.e.b.auG().a(dpD, bdVar);
        com.baidu.tieba.frs.e.b.auG().V(bdVar);
        if (bdVar != null) {
            TiebaStatic.log(new al("c12125").ac("tid", bdVar.getId()).r("obj_locate", apa() ? 2 : 1).f(VideoPlayActivityConfig.OBJ_ID, bdVar.sh() != null ? bdVar.sh().live_id : -1L).r("obj_type", 1));
            bdVar.sJ();
        }
        return aVar.getView();
    }

    private y Q(bd bdVar) {
        if (bdVar == null) {
            return null;
        }
        y yVar = new y();
        yVar.mLocate = bdVar.sF() ? "3" : "2";
        yVar.csP = dpD.dpt;
        yVar.aNv = bdVar.getTid();
        yVar.mSource = bdVar.mRecomSource;
        yVar.fRP = bdVar.abr;
        yVar.fRQ = bdVar.mRecomWeight;
        yVar.fRS = bdVar.mRecomAbTag;
        if (bdVar.sg() != null) {
            yVar.fRT = bdVar.sg().video_md5;
        }
        return yVar;
    }

    @Override // com.baidu.tieba.card.aa
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.a.f
    public void hZ(String str) {
        this.bwO = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(bd bdVar) {
        TiebaStatic.log(new al("c12126").ac("tid", bdVar.getId()).r("obj_locate", apa() ? 2 : 1).f(VideoPlayActivityConfig.OBJ_ID, bdVar.sh() == null ? -1L : bdVar.sh().live_id).r("obj_type", 1));
    }
}
