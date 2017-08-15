package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
import com.baidu.tieba.play.w;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.ListView.a<bl, a<com.baidu.tieba.frs.entelechy.view.d>> implements v, com.baidu.tieba.frs.e.c {
    public static int coD = 5;
    public static int coE = 10;
    public static int coF = 15;
    private x<bl> bkD;
    private String forumName;
    private TbPageContext<?> oV;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(bl blVar, String str) {
        if (blVar != null) {
            int sG = blVar.sG();
            aj ajVar = new aj(str);
            ajVar.aa("obj_locate", iS(sG));
            ajVar.aa("tid", blVar.getTid());
            ajVar.r("obj_type", 2);
            TiebaStatic.log(ajVar);
        }
    }

    private String iS(int i) {
        if (i == coD) {
            return TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
        }
        if (i == coE) {
            return "10";
        }
        if (i != coF) {
            return "";
        }
        return "11";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.bkD = new x<bl>() { // from class: com.baidu.tieba.frs.entelechy.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bl blVar) {
                if (view != null && blVar != null) {
                    if (view.getId() == d.h.frame_video) {
                        i.this.b(blVar, "c11718");
                    } else if (view.getId() == d.h.layout_root) {
                        i.this.b(blVar, "c10242");
                    } else if (view.getId() == d.h.image_user || view.getId() == d.h.pendant_image_user) {
                        i.this.b(blVar, "c10241");
                    } else if (view.getId() == d.h.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.e.c.cxO, blVar.sd());
                    }
                }
            }
        };
        this.oV = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: N */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.d dVar = new com.baidu.tieba.frs.entelechy.view.d(this.oV, this.mPageId);
        dVar.j(this.mPageId);
        dVar.setForumName(this.forumName);
        return new a(dVar);
    }

    private w E(bl blVar) {
        w wVar = null;
        if (blVar != null) {
            wVar = new w();
            wVar.mLocate = iS(blVar.sG());
            wVar.aAC = cxO.cxG;
            wVar.bDM = blVar.getTid();
            wVar.fCt = blVar.aaE;
            if (blVar.sJ() != null && blVar.sJ().channelId > 0) {
                wVar.WK = "" + blVar.sJ().channelId;
            }
            blVar.sD();
        }
        return wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bl blVar, a aVar) {
        if (aVar == null || aVar.Xy() == null) {
            return null;
        }
        aVar.Xy().setVideoStatsData(E(blVar));
        aVar.Xy().a(blVar);
        aVar.Xy().b(this.bkD);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.forumName = str;
    }
}
