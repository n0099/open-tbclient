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
    private x<bh> boe;
    private String forumName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.boe = new x<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (view.getId() == d.g.frame_video) {
                        com.baidu.tieba.frs.e.b.aoe().a(com.baidu.tieba.frs.e.c.cPd, bhVar, 4);
                    } else if (view.getId() == d.g.layout_root) {
                        com.baidu.tieba.frs.e.b.aoe().a(com.baidu.tieba.frs.e.c.cPd, bhVar, 1);
                    } else if (view.getId() == d.g.image_user) {
                        com.baidu.tieba.frs.e.b.aoe().a(com.baidu.tieba.frs.e.c.cPd, bhVar, 2);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.e.c.cPd, bhVar.rS());
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
        xVar.azE = cPd.cOV;
        xVar.aMi = bhVar.getTid();
        xVar.fGH = bhVar.ZS;
        if (bhVar.rL() != null) {
            xVar.fGI = bhVar.rL().video_md5;
        }
        bhVar.st();
        return xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, a aVar) {
        if (aVar == null || aVar.aax() == null) {
            return null;
        }
        aVar.aax().setVideoStatsData(D(bhVar));
        aVar.aax().a(bhVar);
        aVar.aax().b(this.boe);
        com.baidu.tieba.frs.e.b.aoe().a(cPd, bhVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.forumName = str;
    }
}
