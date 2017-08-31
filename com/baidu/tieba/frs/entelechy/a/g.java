package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.entelechy.view.CardFrsGodAutoVideoView;
import com.baidu.tieba.play.w;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.widget.ListView.a<bj, a<CardFrsGodAutoVideoView>> implements v, com.baidu.tieba.frs.f.c {
    private x<bj> bkZ;
    private String forumName;
    private TbPageContext<?> mF;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.bkZ = new x<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (view.getId() == d.h.frame_video) {
                        com.baidu.tieba.frs.f.b.alj().a(com.baidu.tieba.frs.f.c.cEr, bjVar, 4);
                    } else if (view.getId() == d.h.layout_root) {
                        com.baidu.tieba.frs.f.b.alj().a(com.baidu.tieba.frs.f.c.cEr, bjVar, 1);
                    } else if (view.getId() == d.h.image_user) {
                        com.baidu.tieba.frs.f.b.alj().a(com.baidu.tieba.frs.f.c.cEr, bjVar, 2);
                    } else if (view.getId() == d.h.card_divider_tv) {
                        com.baidu.tieba.frs.g.h.a(com.baidu.tieba.frs.f.c.cEr, bjVar.rZ());
                    }
                }
            }
        };
        this.mF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: S */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.a aVar = new com.baidu.tieba.frs.entelechy.view.a(this.mF, this.mPageId);
        aVar.l(this.mPageId);
        aVar.setForumName(this.forumName);
        return new a(aVar);
    }

    private w I(bj bjVar) {
        if (bjVar == null) {
            return null;
        }
        w wVar = new w();
        wVar.mLocate = bjVar.sv() ? TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE : "2";
        wVar.azO = cEr.cEj;
        wVar.bGH = bjVar.getTid();
        wVar.fAX = bjVar.ZJ;
        if (bjVar.rS() != null) {
            wVar.fAY = bjVar.rS().video_md5;
        }
        if (bjVar.sF() != null && bjVar.sF().channelId > 0) {
            wVar.VU = "" + bjVar.sF().channelId;
        }
        bjVar.sz();
        return wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bj bjVar, a aVar) {
        if (aVar == null || aVar.Yy() == null) {
            return null;
        }
        aVar.Yy().setVideoStatsData(I(bjVar));
        aVar.Yy().a(bjVar);
        aVar.Yy().b(this.bkZ);
        com.baidu.tieba.frs.f.b.alj().a(cEr, bjVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.forumName = str;
    }
}
