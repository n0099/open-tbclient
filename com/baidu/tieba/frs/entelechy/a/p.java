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
    private x<bl> bkE;
    private String mForumName;
    private TbPageContext<?> oW;

    /* JADX INFO: Access modifiers changed from: protected */
    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.bkE = new x<bl>() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bl blVar) {
                if (view != null && blVar != null) {
                    if (view.getId() == d.h.layout_root) {
                        com.baidu.tieba.frs.e.b.ajz().a(com.baidu.tieba.frs.e.c.cxO, blVar, 1);
                        TiebaStatic.log(new aj("c12126").aa("tid", blVar.getId()).r("obj_locate", p.this.afd() ? 2 : 1).g("obj_id", blVar.rY() == null ? -1L : blVar.rY().live_id).r("obj_type", 1));
                    } else if (view.getId() == d.h.card_home_page_normal_thread_user_name || view.getId() == d.h.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.e.b.ajz().a(com.baidu.tieba.frs.e.c.cxO, blVar, 2);
                    } else if (view.getId() == d.h.header_divider) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.e.c.cxO, blVar.se());
                    } else if (view.getId() == d.h.frame_video) {
                        com.baidu.tieba.frs.e.b.ajz().a(com.baidu.tieba.frs.e.c.cxO, blVar, 4);
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
        aVar.setForumName(this.mForumName);
        return new a(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.d, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bl blVar, a aVar) {
        if (aVar == null || aVar.Xv() == null) {
            return null;
        }
        aVar.Xv().setVideoStatsData(E(blVar));
        aVar.Xv().a(blVar);
        aVar.Xv().setForumName(this.mForumName);
        aVar.Xv().b(this.bkE);
        com.baidu.tieba.frs.e.b.ajz().a(cxO, blVar);
        com.baidu.tieba.frs.e.b.ajz().M(blVar);
        if (blVar != null) {
            TiebaStatic.log(new aj("c12125").aa("tid", blVar.getId()).r("obj_locate", afd() ? 2 : 1).g("obj_id", blVar.rY() != null ? blVar.rY().live_id : -1L).r("obj_type", 1));
            blVar.sE();
        }
        return aVar.getView();
    }

    private w E(bl blVar) {
        if (blVar == null) {
            return null;
        }
        w wVar = new w();
        wVar.mLocate = blVar.sA() ? TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE : "2";
        wVar.aAD = cxO.cxG;
        wVar.bDN = blVar.getTid();
        wVar.mSource = blVar.aaC;
        wVar.fCs = blVar.aaH;
        wVar.fCt = blVar.aaD;
        wVar.fCv = blVar.aaE;
        if (blVar.sK() != null && blVar.sK().channelId > 0) {
            wVar.WL = "" + blVar.sK().channelId;
        } else {
            wVar.WL = "0";
        }
        return wVar;
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
