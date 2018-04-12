package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.play.y;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.frs.f<bd, a<Object>> implements com.baidu.tieba.a.f, aa, com.baidu.tieba.frs.e.c {
    private String bvX;
    private ab<bd> bvY;
    private String forumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.bvY = new ab<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, bd bdVar) {
                if (view2 != null && bdVar != null) {
                    if ("c13010".equals(d.this.mFrom)) {
                        TiebaStatic.log(new al("c13010").r("obj_type", 2).f(ImageViewerConfig.FORUM_ID, bdVar.getFid()).ac("tid", bdVar.getTid()));
                    }
                    if (view2.getId() == d.g.frame_video) {
                        com.baidu.tieba.frs.e.b.auH().a(com.baidu.tieba.frs.e.c.doy, bdVar, 4);
                    } else if (view2.getId() == d.g.layout_root) {
                        com.baidu.tieba.frs.e.b.auH().a(com.baidu.tieba.frs.e.c.doy, bdVar, 1);
                    } else if (view2.getId() == d.g.image_user) {
                        com.baidu.tieba.frs.e.b.auH().a(com.baidu.tieba.frs.e.c.doy, bdVar, 2);
                    } else if (view2.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.g.a(com.baidu.tieba.frs.e.c.doy, bdVar.sn());
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
        yVar.mLocate = bdVar.sG() ? "3" : "2";
        yVar.crJ = doy.doo;
        yVar.aNu = bdVar.getTid();
        yVar.fQP = bdVar.mRecomAbTag;
        if (bdVar.sh() != null) {
            yVar.fQQ = bdVar.sh().video_md5;
        }
        bdVar.sK();
        return yVar;
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
            aVar.afY().setPage(this.bvX);
        }
        com.baidu.tieba.frs.e.a(aVar.afY().afz(), this.cWO);
        aVar.afY().setVideoStatsData(Q(bdVar));
        aVar.afY().a(bdVar);
        aVar.afY().b(this.bvY);
        com.baidu.tieba.frs.e.b.auH().a(doy, bdVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.aa
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.a.f
    public void hY(String str) {
        this.bvX = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }
}
