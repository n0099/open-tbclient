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
public class g extends com.baidu.adp.widget.ListView.a<bl, a<CardFrsGodAutoVideoView>> implements v, com.baidu.tieba.frs.f.c {
    private TbPageContext<?> ako;
    private x<bl> bjp;
    private String forumName;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.bjp = new x<bl>() { // from class: com.baidu.tieba.frs.entelechy.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bl blVar) {
                if (view != null && blVar != null) {
                    if (view.getId() == d.h.frame_video) {
                        com.baidu.tieba.frs.f.b.aiM().a(com.baidu.tieba.frs.f.c.cut, blVar, 4);
                    } else if (view.getId() == d.h.layout_root) {
                        com.baidu.tieba.frs.f.b.aiM().a(com.baidu.tieba.frs.f.c.cut, blVar, 1);
                    } else if (view.getId() == d.h.image_user) {
                        com.baidu.tieba.frs.f.b.aiM().a(com.baidu.tieba.frs.f.c.cut, blVar, 2);
                    } else if (view.getId() == d.h.card_divider_tv) {
                        com.baidu.tieba.frs.g.h.a(com.baidu.tieba.frs.f.c.cut, blVar.rT());
                    }
                }
            }
        };
        this.ako = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: M */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.a aVar = new com.baidu.tieba.frs.entelechy.view.a(this.ako, this.mPageId);
        aVar.j(this.mPageId);
        aVar.setForumName(this.forumName);
        return new a(aVar);
    }

    private w E(bl blVar) {
        if (blVar == null) {
            return null;
        }
        w wVar = new w();
        wVar.mLocate = blVar.sp() ? TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE : "2";
        wVar.azk = cut.cul;
        wVar.bBT = blVar.getTid();
        wVar.fzo = blVar.Zg;
        if (blVar.sz() != null && blVar.sz().channelId > 0) {
            wVar.Vm = "" + blVar.sz().channelId;
        }
        blVar.st();
        return wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bl blVar, a aVar) {
        if (aVar == null || aVar.WX() == null) {
            return null;
        }
        aVar.WX().setVideoStatsData(E(blVar));
        aVar.WX().a(blVar);
        aVar.WX().a(this.bjp);
        com.baidu.tieba.frs.f.b.aiM().a(cut, blVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.forumName = str;
    }
}
