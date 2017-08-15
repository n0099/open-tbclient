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
public class p extends com.baidu.tieba.frs.d<bl, a<com.baidu.tieba.frs.entelechy.view.a>> implements v, com.baidu.tieba.frs.e.c {
    private x<bl> bkD;
    private String mForumName;
    private TbPageContext<?> oV;

    /* JADX INFO: Access modifiers changed from: protected */
    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.bkD = new x<bl>() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bl blVar) {
                if (view != null && blVar != null) {
                    if (view.getId() == d.h.layout_root) {
                        com.baidu.tieba.frs.e.b.ajF().a(com.baidu.tieba.frs.e.c.cxO, blVar, 1);
                        TiebaStatic.log(new aj("c12126").aa("tid", blVar.getId()).r("obj_locate", p.this.afj() ? 2 : 1).g("obj_id", blVar.rX() == null ? -1L : blVar.rX().live_id).r("obj_type", 1));
                    } else if (view.getId() == d.h.card_home_page_normal_thread_user_name || view.getId() == d.h.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.e.b.ajF().a(com.baidu.tieba.frs.e.c.cxO, blVar, 2);
                    } else if (view.getId() == d.h.header_divider) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.e.c.cxO, blVar.sd());
                    } else if (view.getId() == d.h.frame_video) {
                        com.baidu.tieba.frs.e.b.ajF().a(com.baidu.tieba.frs.e.c.cxO, blVar, 4);
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
        com.baidu.tieba.frs.entelechy.view.a aVar = new com.baidu.tieba.frs.entelechy.view.a(this.oV, this.mPageId);
        aVar.j(this.mPageId);
        aVar.setForumName(this.mForumName);
        return new a(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.d, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bl blVar, a aVar) {
        if (aVar == null || aVar.Xy() == null) {
            return null;
        }
        aVar.Xy().setVideoStatsData(E(blVar));
        aVar.Xy().a(blVar);
        aVar.Xy().setForumName(this.mForumName);
        aVar.Xy().b(this.bkD);
        com.baidu.tieba.frs.e.b.ajF().a(cxO, blVar);
        com.baidu.tieba.frs.e.b.ajF().M(blVar);
        if (blVar != null) {
            TiebaStatic.log(new aj("c12125").aa("tid", blVar.getId()).r("obj_locate", afj() ? 2 : 1).g("obj_id", blVar.rX() != null ? blVar.rX().live_id : -1L).r("obj_type", 1));
            blVar.sD();
        }
        return aVar.getView();
    }

    private w E(bl blVar) {
        if (blVar == null) {
            return null;
        }
        w wVar = new w();
        wVar.mLocate = blVar.sz() ? TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE : "2";
        wVar.aAC = cxO.cxG;
        wVar.bDM = blVar.getTid();
        wVar.mSource = blVar.aaC;
        wVar.fCq = blVar.aaH;
        wVar.fCr = blVar.aaD;
        wVar.fCt = blVar.aaE;
        if (blVar.sJ() != null && blVar.sJ().channelId > 0) {
            wVar.WK = "" + blVar.sJ().channelId;
        } else {
            wVar.WK = "0";
        }
        return wVar;
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
