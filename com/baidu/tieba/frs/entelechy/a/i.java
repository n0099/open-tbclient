package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
import com.baidu.tieba.play.w;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.ListView.a<bj, a<com.baidu.tieba.frs.entelechy.view.d>> implements v, com.baidu.tieba.frs.f.c {
    public static int cwa = 5;
    public static int cwb = 10;
    public static int cwc = 15;
    private x<bj> bkY;
    private String forumName;
    private TbPageContext<?> mF;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(bj bjVar, String str) {
        if (bjVar != null) {
            int sC = bjVar.sC();
            ak akVar = new ak(str);
            akVar.ad("obj_locate", ji(sC));
            akVar.ad("tid", bjVar.getTid());
            akVar.r("obj_type", 2);
            TiebaStatic.log(akVar);
        }
    }

    private String ji(int i) {
        if (i == cwa) {
            return TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
        }
        if (i == cwb) {
            return "10";
        }
        if (i != cwc) {
            return "";
        }
        return "11";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.bkY = new x<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (view.getId() == d.h.frame_video) {
                        i.this.b(bjVar, "c11718");
                    } else if (view.getId() == d.h.layout_root) {
                        i.this.b(bjVar, "c10242");
                    } else if (view.getId() == d.h.image_user || view.getId() == d.h.pendant_image_user) {
                        i.this.b(bjVar, "c10241");
                    } else if (view.getId() == d.h.card_divider_tv) {
                        com.baidu.tieba.frs.g.h.a(com.baidu.tieba.frs.f.c.cFj, bjVar.rZ());
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
        com.baidu.tieba.frs.entelechy.view.d dVar = new com.baidu.tieba.frs.entelechy.view.d(this.mF, this.mPageId);
        dVar.l(this.mPageId);
        dVar.setForumName(this.forumName);
        return new a(dVar);
    }

    private w I(bj bjVar) {
        w wVar = null;
        if (bjVar != null) {
            wVar = new w();
            wVar.mLocate = ji(bjVar.sC());
            wVar.azL = cFj.cFb;
            wVar.bHy = bjVar.getTid();
            wVar.fBQ = bjVar.ZJ;
            if (bjVar.rS() != null) {
                wVar.fBR = bjVar.rS().video_md5;
            }
            if (bjVar.sF() != null && bjVar.sF().channelId > 0) {
                wVar.VU = "" + bjVar.sF().channelId;
            }
            bjVar.sz();
        }
        return wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bj bjVar, a aVar) {
        if (aVar == null || aVar.YJ() == null) {
            return null;
        }
        aVar.YJ().setVideoStatsData(I(bjVar));
        aVar.YJ().a(bjVar);
        aVar.YJ().b(this.bkY);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.forumName = str;
    }
}
