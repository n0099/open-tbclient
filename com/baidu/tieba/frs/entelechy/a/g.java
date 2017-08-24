package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.entelechy.view.CardFrsGodAutoVideoView;
import com.baidu.tieba.play.w;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.widget.ListView.a<bl, a<CardFrsGodAutoVideoView>> implements v, com.baidu.tieba.frs.e.c {
    private x<bl> bkE;
    private String forumName;
    private TbPageContext<?> oW;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.bkE = new x<bl>() { // from class: com.baidu.tieba.frs.entelechy.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bl blVar) {
                if (view != null && blVar != null) {
                    if (view.getId() == d.h.frame_video) {
                        com.baidu.tieba.frs.e.b.ajz().a(com.baidu.tieba.frs.e.c.cxO, blVar, 4);
                    } else if (view.getId() == d.h.layout_root) {
                        com.baidu.tieba.frs.e.b.ajz().a(com.baidu.tieba.frs.e.c.cxO, blVar, 1);
                    } else if (view.getId() == d.h.image_user) {
                        com.baidu.tieba.frs.e.b.ajz().a(com.baidu.tieba.frs.e.c.cxO, blVar, 2);
                    } else if (view.getId() == d.h.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.e.c.cxO, blVar.se());
                    }
                }
            }
        };
        this.oW = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: N */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.a aVar = new com.baidu.tieba.frs.entelechy.view.a(this.oW, this.mPageId);
        aVar.j(this.mPageId);
        aVar.setForumName(this.forumName);
        return new a(aVar);
    }

    private w E(bl blVar) {
        if (blVar == null) {
            return null;
        }
        w wVar = new w();
        wVar.mLocate = blVar.sA() ? TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE : "2";
        wVar.aAD = cxO.cxG;
        wVar.bDN = blVar.getTid();
        wVar.fCv = blVar.aaE;
        if (blVar.sK() != null && blVar.sK().channelId > 0) {
            wVar.WL = "" + blVar.sK().channelId;
        }
        blVar.sE();
        return wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bl blVar, a aVar) {
        if (aVar == null || aVar.Xv() == null) {
            return null;
        }
        aVar.Xv().setVideoStatsData(E(blVar));
        aVar.Xv().a(blVar);
        aVar.Xv().b(this.bkE);
        com.baidu.tieba.frs.e.b.ajz().a(cxO, blVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.forumName = str;
    }
}
