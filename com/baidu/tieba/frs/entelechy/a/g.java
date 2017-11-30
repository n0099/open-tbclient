package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.entelechy.view.CardFrsGodAutoVideoView;
import com.baidu.tieba.play.y;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.widget.ListView.a<bd, a<CardFrsGodAutoVideoView>> implements com.baidu.tieba.card.u, com.baidu.tieba.frs.e.c {
    private v<bd> buV;
    private String forumName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.buV = new v<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    if (view.getId() == d.g.frame_video) {
                        com.baidu.tieba.frs.e.b.aqn().a(com.baidu.tieba.frs.e.c.cYM, bdVar, 4);
                    } else if (view.getId() == d.g.layout_root) {
                        com.baidu.tieba.frs.e.b.aqn().a(com.baidu.tieba.frs.e.c.cYM, bdVar, 1);
                    } else if (view.getId() == d.g.image_user) {
                        com.baidu.tieba.frs.e.b.aqn().a(com.baidu.tieba.frs.e.c.cYM, bdVar, 2);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.g.a(com.baidu.tieba.frs.e.c.cYM, bdVar.rW());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: al */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.a aVar = new com.baidu.tieba.frs.entelechy.view.a(this.mPageContext, this.mPageId);
        aVar.k(this.mPageId);
        aVar.setForumName(this.forumName);
        return new a(aVar);
    }

    private y G(bd bdVar) {
        if (bdVar == null) {
            return null;
        }
        y yVar = new y();
        yVar.mLocate = bdVar.ss() ? "3" : "2";
        yVar.aAn = cYM.cYE;
        yVar.aMR = bdVar.getTid();
        yVar.fQs = bdVar.aal;
        if (bdVar.rP() != null) {
            yVar.fQt = bdVar.rP().video_md5;
        }
        bdVar.sw();
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, a aVar) {
        if (aVar == null || aVar.acs() == null) {
            return null;
        }
        aVar.acs().setVideoStatsData(G(bdVar));
        aVar.acs().a(bdVar);
        aVar.acs().b(this.buV);
        com.baidu.tieba.frs.e.b.aqn().a(cYM, bdVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.forumName = str;
    }
}
