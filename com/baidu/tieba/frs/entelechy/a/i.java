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
public class i extends com.baidu.adp.widget.ListView.a<bl, a<com.baidu.tieba.frs.entelechy.view.d>> implements v, com.baidu.tieba.frs.f.c {
    public static int cmJ = 5;
    public static int cmK = 10;
    public static int cmL = 15;
    private TbPageContext<?> ako;
    private x<bl> bjp;
    private String forumName;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(bl blVar, String str) {
        if (blVar != null) {
            int sw = blVar.sw();
            aj ajVar = new aj(str);
            ajVar.aa("obj_locate", iQ(sw));
            ajVar.aa("tid", blVar.getTid());
            ajVar.r("obj_type", 2);
            TiebaStatic.log(ajVar);
        }
    }

    private String iQ(int i) {
        if (i == cmJ) {
            return TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
        }
        if (i == cmK) {
            return "10";
        }
        if (i != cmL) {
            return "";
        }
        return "11";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.bjp = new x<bl>() { // from class: com.baidu.tieba.frs.entelechy.a.i.1
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
        com.baidu.tieba.frs.entelechy.view.d dVar = new com.baidu.tieba.frs.entelechy.view.d(this.ako, this.mPageId);
        dVar.j(this.mPageId);
        dVar.setForumName(this.forumName);
        return new a(dVar);
    }

    private w E(bl blVar) {
        w wVar = null;
        if (blVar != null) {
            wVar = new w();
            wVar.mLocate = iQ(blVar.sw());
            wVar.azk = cut.cul;
            wVar.bBT = blVar.getTid();
            wVar.fzo = blVar.Zg;
            if (blVar.sz() != null && blVar.sz().channelId > 0) {
                wVar.Vm = "" + blVar.sz().channelId;
            }
            blVar.st();
        }
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
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.forumName = str;
    }
}
