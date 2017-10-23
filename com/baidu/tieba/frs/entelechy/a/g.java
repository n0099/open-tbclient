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
public class g extends com.baidu.adp.widget.ListView.a<bh, a<CardFrsGodAutoVideoView>> implements v, com.baidu.tieba.frs.f.c {
    private x<bh> bmv;
    private String forumName;
    private TbPageContext<?> mH;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.bmv = new x<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (view.getId() == d.h.frame_video) {
                        com.baidu.tieba.frs.f.b.alt().a(com.baidu.tieba.frs.f.c.cFQ, bhVar, 4);
                    } else if (view.getId() == d.h.layout_root) {
                        com.baidu.tieba.frs.f.b.alt().a(com.baidu.tieba.frs.f.c.cFQ, bhVar, 1);
                    } else if (view.getId() == d.h.image_user) {
                        com.baidu.tieba.frs.f.b.alt().a(com.baidu.tieba.frs.f.c.cFQ, bhVar, 2);
                    } else if (view.getId() == d.h.card_divider_tv) {
                        com.baidu.tieba.frs.g.h.a(com.baidu.tieba.frs.f.c.cFQ, bhVar.rM());
                    }
                }
            }
        };
        this.mH = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: S */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.a aVar = new com.baidu.tieba.frs.entelechy.view.a(this.mH, this.mPageId);
        aVar.k(this.mPageId);
        aVar.setForumName(this.forumName);
        return new a(aVar);
    }

    private com.baidu.tieba.play.x D(bh bhVar) {
        if (bhVar == null) {
            return null;
        }
        com.baidu.tieba.play.x xVar = new com.baidu.tieba.play.x();
        xVar.mLocate = bhVar.si() ? TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE : "2";
        xVar.ayT = cFQ.cFI;
        xVar.cyL = bhVar.getTid();
        xVar.fxQ = bhVar.Zx;
        if (bhVar.rF() != null) {
            xVar.fxR = bhVar.rF().video_md5;
        }
        bhVar.sm();
        return xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, a aVar) {
        if (aVar == null || aVar.Yn() == null) {
            return null;
        }
        aVar.Yn().setVideoStatsData(D(bhVar));
        aVar.Yn().a(bhVar);
        aVar.Yn().b(this.bmv);
        com.baidu.tieba.frs.f.b.alt().a(cFQ, bhVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.forumName = str;
    }
}
