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
public class p extends com.baidu.tieba.frs.d<bl, a<com.baidu.tieba.frs.entelechy.view.a>> implements v, com.baidu.tieba.frs.f.c {
    private TbPageContext<?> ako;
    private x<bl> bjp;
    private String mForumName;

    /* JADX INFO: Access modifiers changed from: protected */
    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.bjp = new x<bl>() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bl blVar) {
                if (view != null && blVar != null) {
                    if (view.getId() == d.h.layout_root) {
                        com.baidu.tieba.frs.f.b.aiM().a(com.baidu.tieba.frs.f.c.cut, blVar, 1);
                        TiebaStatic.log(new aj("c12126").aa("tid", blVar.getId()).r("obj_locate", p.this.aeJ() ? 2 : 1).f("obj_id", blVar.rN() == null ? -1L : blVar.rN().live_id).r("obj_type", 1));
                    } else if (view.getId() == d.h.card_home_page_normal_thread_user_name || view.getId() == d.h.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.f.b.aiM().a(com.baidu.tieba.frs.f.c.cut, blVar, 2);
                    } else if (view.getId() == d.h.header_divider) {
                        com.baidu.tieba.frs.g.h.a(com.baidu.tieba.frs.f.c.cut, blVar.rT());
                    } else if (view.getId() == d.h.frame_video) {
                        com.baidu.tieba.frs.f.b.aiM().a(com.baidu.tieba.frs.f.c.cut, blVar, 4);
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
        aVar.setForumName(this.mForumName);
        return new a(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.d, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bl blVar, a aVar) {
        if (aVar == null || aVar.WX() == null) {
            return null;
        }
        aVar.WX().setVideoStatsData(E(blVar));
        aVar.WX().a(blVar);
        aVar.WX().setForumName(this.mForumName);
        aVar.WX().a(this.bjp);
        com.baidu.tieba.frs.f.b.aiM().a(cut, blVar);
        com.baidu.tieba.frs.f.b.aiM().M(blVar);
        if (blVar != null) {
            TiebaStatic.log(new aj("c12125").aa("tid", blVar.getId()).r("obj_locate", aeJ() ? 2 : 1).f("obj_id", blVar.rN() != null ? blVar.rN().live_id : -1L).r("obj_type", 1));
            blVar.st();
        }
        return aVar.getView();
    }

    private w E(bl blVar) {
        if (blVar == null) {
            return null;
        }
        w wVar = new w();
        wVar.mLocate = blVar.sp() ? TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE : "2";
        wVar.azk = cut.cul;
        wVar.bBT = blVar.getTid();
        wVar.mSource = blVar.Ze;
        wVar.fzl = blVar.Zj;
        wVar.fzm = blVar.Zf;
        wVar.fzo = blVar.Zg;
        if (blVar.sz() != null && blVar.sz().channelId > 0) {
            wVar.Vm = "" + blVar.sz().channelId;
        } else {
            wVar.Vm = "0";
        }
        return wVar;
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
