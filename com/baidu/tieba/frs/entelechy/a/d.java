package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.play.y;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.frs.f<bd, a<Object>> implements com.baidu.tieba.a.f, aa, com.baidu.tieba.frs.e.c {
    private String bER;
    private ab<bd> bES;
    private String forumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.bES = new ab<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    if (d.this.dhm != null) {
                        d.this.dhm.a(view, bdVar, bd.ahR);
                    }
                    if ("c13010".equals(d.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").r("obj_type", 2).f(ImageViewerConfig.FORUM_ID, bdVar.getFid()).ah("tid", bdVar.getTid()));
                    }
                    if (view.getId() == d.g.frame_video) {
                        com.baidu.tieba.frs.e.b.ayQ().a(com.baidu.tieba.frs.e.c.dyP, bdVar, 4);
                    } else if (view.getId() == d.g.layout_root) {
                        com.baidu.tieba.frs.e.b.ayQ().a(com.baidu.tieba.frs.e.c.dyP, bdVar, 1);
                    } else if (view.getId() == d.g.image_user) {
                        com.baidu.tieba.frs.e.b.ayQ().a(com.baidu.tieba.frs.e.c.dyP, bdVar, 2);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.e.c.dyP, bdVar.vJ());
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
        com.baidu.tieba.frs.entelechy.view.a aVar = new com.baidu.tieba.frs.entelechy.view.a(this.mPageContext, this.mPageId);
        aVar.j(this.mPageId);
        aVar.setForumName(this.forumName);
        return new a(aVar);
    }

    private y Q(bd bdVar) {
        if (bdVar == null) {
            return null;
        }
        y yVar = new y();
        yVar.mLocate = bdVar.wc() ? "3" : "2";
        yVar.cBu = dyP.dyF;
        yVar.aVt = bdVar.getTid();
        yVar.gde = bdVar.mRecomAbTag;
        if (bdVar.vD() != null) {
            yVar.gdf = bdVar.vD().video_md5;
        }
        bdVar.wg();
        return yVar;
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
        com.baidu.tieba.frs.e.a(aVar.ajG().UW(), this.dhf);
        aVar.ajG().setVideoStatsData(Q(bdVar));
        aVar.ajG().a(bdVar);
        aVar.ajG().b(this.bES);
        com.baidu.tieba.frs.e.b.ayQ().a(dyP, bdVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.aa
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.a.f
    public void iy(String str) {
        this.bER = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }
}
