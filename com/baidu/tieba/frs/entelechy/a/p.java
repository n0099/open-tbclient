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
public class p extends com.baidu.tieba.frs.d<bj, a<com.baidu.tieba.frs.entelechy.view.a>> implements v, com.baidu.tieba.frs.f.c {
    private x<bj> bkY;
    private TbPageContext<?> mF;
    private String mForumName;

    /* JADX INFO: Access modifiers changed from: protected */
    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.bkY = new x<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (view.getId() == d.h.layout_root) {
                        com.baidu.tieba.frs.f.b.alu().a(com.baidu.tieba.frs.f.c.cFj, bjVar, 1);
                        TiebaStatic.log(new ak("c12126").ad("tid", bjVar.getId()).r("obj_locate", p.this.agM() ? 2 : 1).f("obj_id", bjVar.rT() == null ? -1L : bjVar.rT().live_id).r("obj_type", 1));
                    } else if (view.getId() == d.h.card_home_page_normal_thread_user_name || view.getId() == d.h.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.f.b.alu().a(com.baidu.tieba.frs.f.c.cFj, bjVar, 2);
                    } else if (view.getId() == d.h.header_divider) {
                        com.baidu.tieba.frs.g.h.a(com.baidu.tieba.frs.f.c.cFj, bjVar.rZ());
                    } else if (view.getId() == d.h.frame_video) {
                        com.baidu.tieba.frs.f.b.alu().a(com.baidu.tieba.frs.f.c.cFj, bjVar, 4);
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
        aVar.setForumName(this.mForumName);
        return new a(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.d, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bj bjVar, a aVar) {
        if (aVar == null || aVar.YJ() == null) {
            return null;
        }
        aVar.YJ().setVideoStatsData(I(bjVar));
        aVar.YJ().a(bjVar);
        aVar.YJ().setForumName(this.mForumName);
        aVar.YJ().b(this.bkY);
        com.baidu.tieba.frs.f.b.alu().a(cFj, bjVar);
        com.baidu.tieba.frs.f.b.alu().Q(bjVar);
        if (bjVar != null) {
            TiebaStatic.log(new ak("c12125").ad("tid", bjVar.getId()).r("obj_locate", agM() ? 2 : 1).f("obj_id", bjVar.rT() != null ? bjVar.rT().live_id : -1L).r("obj_type", 1));
            bjVar.sz();
        }
        return aVar.getView();
    }

    private w I(bj bjVar) {
        if (bjVar == null) {
            return null;
        }
        w wVar = new w();
        wVar.mLocate = bjVar.sv() ? TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE : "2";
        wVar.azL = cFj.cFb;
        wVar.bHy = bjVar.getTid();
        wVar.mSource = bjVar.ZH;
        wVar.fBN = bjVar.ZM;
        wVar.fBO = bjVar.ZI;
        wVar.fBQ = bjVar.ZJ;
        if (bjVar.rS() != null) {
            wVar.fBR = bjVar.rS().video_md5;
        }
        if (bjVar.sF() != null && bjVar.sF().channelId > 0) {
            wVar.VU = "" + bjVar.sF().channelId;
        } else {
            wVar.VU = "0";
        }
        return wVar;
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
