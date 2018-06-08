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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.play.y;
/* loaded from: classes2.dex */
public class p extends com.baidu.tieba.frs.f<bd, a<com.baidu.tieba.frs.entelechy.view.a>> implements com.baidu.tieba.a.f, aa, com.baidu.tieba.frs.e.c {
    private String bER;
    private ab<bd> bES;
    private com.baidu.tieba.frs.entelechy.view.a doM;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.bES = new ab<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    if (p.this.dhm != null) {
                        p.this.dhm.a(view, bdVar, bd.ahM);
                    }
                    if ("c13010".equals(p.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").r("obj_type", 2).f(ImageViewerConfig.FORUM_ID, bdVar.getFid()).ah("tid", bdVar.getTid()));
                    }
                    if (view.getId() == d.g.layout_root || (p.this.doM.bFe != null && p.this.doM.bFe.getCommentContainer() != null && view.getId() == p.this.doM.bFe.getCommentContainer().getId())) {
                        com.baidu.tieba.frs.e.b.ayQ().a(com.baidu.tieba.frs.e.c.dyP, bdVar, 1);
                        p.this.S(bdVar);
                    } else if (view.getId() == d.g.card_home_page_normal_thread_user_name || view.getId() == d.g.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.e.b.ayQ().a(com.baidu.tieba.frs.e.c.dyP, bdVar, 2);
                    } else if (view.getId() == d.g.header_divider) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.e.c.dyP, bdVar.vJ());
                    } else if (view.getId() == d.g.frame_video) {
                        com.baidu.tieba.frs.e.b.ayQ().a(com.baidu.tieba.frs.e.c.dyP, bdVar, 4);
                        p.this.S(bdVar);
                    } else if (view.getId() == d.g.card_god_reply_layout) {
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
    /* renamed from: ar */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.doM = new com.baidu.tieba.frs.entelechy.view.a(this.mPageContext, this.mPageId);
        this.doM.j(this.mPageId);
        this.doM.setForumName(this.mForumName);
        return new a(this.doM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, a aVar) {
        if (aVar == null || aVar.ajG() == null) {
            return null;
        }
        if (aVar.ajG() instanceof com.baidu.tieba.a.e) {
            aVar.ajG().setPage(this.bER);
        }
        super.onFillViewHolder(i, view, viewGroup, bdVar, aVar);
        com.baidu.tieba.frs.e.a(aVar.ajG().UW(), this.dhf);
        com.baidu.tieba.frs.e.a(aVar.ajG().UX(), this.dhf);
        aVar.ajG().setVideoStatsData(Q(bdVar));
        if (this.dhf != null && this.dhf.bam() != null && !StringUtils.isNull(this.dhf.bam().getTopic_special_icon()) && !StringUtils.isNull(this.dhf.bam().getTopic_special_icon_right())) {
            aVar.ajG().P(this.dhf.bam().getTopic_special_icon(), this.dhf.bam().getTopic_special_icon_right());
        }
        aVar.ajG().a(bdVar);
        aVar.ajG().setForumName(this.mForumName);
        aVar.ajG().b(this.bES);
        com.baidu.tieba.frs.e.b.ayQ().a(dyP, bdVar);
        com.baidu.tieba.frs.e.b.ayQ().V(bdVar);
        if (bdVar != null) {
            TiebaStatic.log(new am("c12125").ah("tid", bdVar.getId()).r("obj_locate", atg() ? 2 : 1).f(VideoPlayActivityConfig.OBJ_ID, bdVar.vE() != null ? bdVar.vE().live_id : -1L).r("obj_type", 1));
            bdVar.wg();
        }
        return aVar.getView();
    }

    private y Q(bd bdVar) {
        if (bdVar == null) {
            return null;
        }
        y yVar = new y();
        yVar.mLocate = bdVar.wc() ? "3" : "2";
        yVar.cBu = dyP.dyF;
        yVar.aVt = bdVar.getTid();
        yVar.mSource = bdVar.mRecomSource;
        yVar.gdb = bdVar.ajv;
        yVar.gdc = bdVar.mRecomWeight;
        yVar.gde = bdVar.mRecomAbTag;
        if (bdVar.vD() != null) {
            yVar.gdf = bdVar.vD().video_md5;
        }
        return yVar;
    }

    @Override // com.baidu.tieba.card.aa
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.a.f
    public void iy(String str) {
        this.bER = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(bd bdVar) {
        TiebaStatic.log(new am("c12126").ah("tid", bdVar.getId()).r("obj_locate", atg() ? 2 : 1).f(VideoPlayActivityConfig.OBJ_ID, bdVar.vE() == null ? -1L : bdVar.vE().live_id).r("obj_type", 1));
    }
}
