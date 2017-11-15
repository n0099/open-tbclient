package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.entelechy.view.CardFrsGodAutoVideoView;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.widget.ListView.a<bh, a<CardFrsGodAutoVideoView>> implements v, com.baidu.tieba.frs.e.c {
    private x<bh> bon;
    private String forumName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.bon = new x<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (view.getId() == d.g.frame_video) {
                        com.baidu.tieba.frs.e.b.aot().a(com.baidu.tieba.frs.e.c.cPx, bhVar, 4);
                    } else if (view.getId() == d.g.layout_root) {
                        com.baidu.tieba.frs.e.b.aot().a(com.baidu.tieba.frs.e.c.cPx, bhVar, 1);
                    } else if (view.getId() == d.g.image_user) {
                        com.baidu.tieba.frs.e.b.aot().a(com.baidu.tieba.frs.e.c.cPx, bhVar, 2);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.e.c.cPx, bhVar.rS());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aj */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.a aVar = new com.baidu.tieba.frs.entelechy.view.a(this.mPageContext, this.mPageId);
        aVar.k(this.mPageId);
        aVar.setForumName(this.forumName);
        return new a(aVar);
    }

    private com.baidu.tieba.play.x D(bh bhVar) {
        if (bhVar == null) {
            return null;
        }
        com.baidu.tieba.play.x xVar = new com.baidu.tieba.play.x();
        xVar.mLocate = bhVar.sp() ? TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE : "2";
        xVar.azM = cPx.cPp;
        xVar.aMq = bhVar.getTid();
        xVar.fHm = bhVar.ZS;
        if (bhVar.rL() != null) {
            xVar.fHn = bhVar.rL().video_md5;
        }
        bhVar.st();
        return xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, a aVar) {
        if (aVar == null || aVar.aaJ() == null) {
            return null;
        }
        aVar.aaJ().setVideoStatsData(D(bhVar));
        aVar.aaJ().a(bhVar);
        aVar.aaJ().b(this.bon);
        com.baidu.tieba.frs.e.b.aot().a(cPx, bhVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.forumName = str;
    }
}
