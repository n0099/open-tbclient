package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class q extends com.baidu.tieba.frs.d<bh, a<com.baidu.tieba.frs.entelechy.view.a>> implements v, com.baidu.tieba.frs.f.c {
    private x<bh> bmv;
    private String mForumName;
    private TbPageContext<?> mH;

    /* JADX INFO: Access modifiers changed from: protected */
    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.bmv = new x<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (view.getId() == d.h.layout_root) {
                        com.baidu.tieba.frs.f.b.alt().a(com.baidu.tieba.frs.f.c.cFQ, bhVar, 1);
                        TiebaStatic.log(new ak("c12126").ac("tid", bhVar.getId()).r("obj_locate", q.this.agD() ? 2 : 1).f("obj_id", bhVar.rG() == null ? -1L : bhVar.rG().live_id).r("obj_type", 1));
                    } else if (view.getId() == d.h.card_home_page_normal_thread_user_name || view.getId() == d.h.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.f.b.alt().a(com.baidu.tieba.frs.f.c.cFQ, bhVar, 2);
                    } else if (view.getId() == d.h.header_divider) {
                        com.baidu.tieba.frs.g.h.a(com.baidu.tieba.frs.f.c.cFQ, bhVar.rM());
                    } else if (view.getId() == d.h.frame_video) {
                        com.baidu.tieba.frs.f.b.alt().a(com.baidu.tieba.frs.f.c.cFQ, bhVar, 4);
                    }
                }
            }
        };
        this.mH = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: S */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.a aVar = new com.baidu.tieba.frs.entelechy.view.a(this.mH, this.mPageId);
        aVar.k(this.mPageId);
        aVar.setForumName(this.mForumName);
        return new a(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.d, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, a aVar) {
        if (aVar == null || aVar.Yn() == null) {
            return null;
        }
        aVar.Yn().setVideoStatsData(D(bhVar));
        aVar.Yn().a(bhVar);
        aVar.Yn().setForumName(this.mForumName);
        aVar.Yn().b(this.bmv);
        com.baidu.tieba.frs.f.b.alt().a(cFQ, bhVar);
        com.baidu.tieba.frs.f.b.alt().L(bhVar);
        if (bhVar != null) {
            TiebaStatic.log(new ak("c12125").ac("tid", bhVar.getId()).r("obj_locate", agD() ? 2 : 1).f("obj_id", bhVar.rG() != null ? bhVar.rG().live_id : -1L).r("obj_type", 1));
            bhVar.sm();
        }
        return aVar.getView();
    }

    private com.baidu.tieba.play.x D(bh bhVar) {
        if (bhVar == null) {
            return null;
        }
        com.baidu.tieba.play.x xVar = new com.baidu.tieba.play.x();
        xVar.mLocate = bhVar.si() ? TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE : "2";
        xVar.ayT = cFQ.cFI;
        xVar.cyL = bhVar.getTid();
        xVar.mSource = bhVar.Zv;
        xVar.fxN = bhVar.ZA;
        xVar.fxO = bhVar.Zw;
        xVar.fxQ = bhVar.Zx;
        if (bhVar.rF() != null) {
            xVar.fxR = bhVar.rF().video_md5;
        }
        return xVar;
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
