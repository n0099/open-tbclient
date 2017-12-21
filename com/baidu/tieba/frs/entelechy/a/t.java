package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.e;
import com.baidu.tieba.play.y;
/* loaded from: classes.dex */
public class t extends e<bd, a<com.baidu.tieba.frs.entelechy.view.a>> implements com.baidu.tieba.card.u, com.baidu.tieba.frs.e.c {
    private v<bd> bva;
    private com.baidu.tieba.frs.entelechy.view.a cOz;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.bva = new v<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    if (view.getId() == d.g.layout_root || (t.this.cOz.bvM != null && t.this.cOz.bvM.getCommentContainer() != null && view.getId() == t.this.cOz.bvM.getCommentContainer().getId())) {
                        com.baidu.tieba.frs.e.b.aqw().a(com.baidu.tieba.frs.e.c.cZc, bdVar, 1);
                        t.this.K(bdVar);
                    } else if (view.getId() == d.g.card_home_page_normal_thread_user_name || view.getId() == d.g.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.e.b.aqw().a(com.baidu.tieba.frs.e.c.cZc, bdVar, 2);
                    } else if (view.getId() == d.g.header_divider) {
                        com.baidu.tieba.frs.f.g.a(com.baidu.tieba.frs.e.c.cZc, bdVar.rU());
                    } else if (view.getId() == d.g.frame_video) {
                        com.baidu.tieba.frs.e.b.aqw().a(com.baidu.tieba.frs.e.c.cZc, bdVar, 4);
                        t.this.K(bdVar);
                    } else if (view.getId() == d.g.card_god_reply_layout) {
                        t.this.K(bdVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: al */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cOz = new com.baidu.tieba.frs.entelechy.view.a(this.mPageContext, this.mPageId);
        this.cOz.k(this.mPageId);
        this.cOz.setForumName(this.mForumName);
        return new a(this.cOz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.e, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, a aVar) {
        if (aVar == null || aVar.acB() == null) {
            return null;
        }
        com.baidu.tieba.frs.d.a(aVar.acB().abX(), this.cGS);
        aVar.acB().setVideoStatsData(I(bdVar));
        aVar.acB().a(bdVar);
        aVar.acB().setForumName(this.mForumName);
        aVar.acB().b(this.bva);
        com.baidu.tieba.frs.e.b.aqw().a(cZc, bdVar);
        com.baidu.tieba.frs.e.b.aqw().S(bdVar);
        if (bdVar != null) {
            TiebaStatic.log(new ak("c12125").ac("tid", bdVar.getId()).r("obj_locate", alb() ? 2 : 1).f("obj_id", bdVar.rO() != null ? bdVar.rO().live_id : -1L).r("obj_type", 1));
            bdVar.su();
        }
        return aVar.getView();
    }

    private y I(bd bdVar) {
        if (bdVar == null) {
            return null;
        }
        y yVar = new y();
        yVar.mLocate = bdVar.sq() ? "3" : "2";
        yVar.aAv = cZc.cYU;
        yVar.aMX = bdVar.getTid();
        yVar.mSource = bdVar.aag;
        yVar.fRn = bdVar.aal;
        yVar.fRo = bdVar.aah;
        yVar.fRq = bdVar.aai;
        if (bdVar.rN() != null) {
            yVar.fRr = bdVar.rN().video_md5;
        }
        return yVar;
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(bd bdVar) {
        TiebaStatic.log(new ak("c12126").ac("tid", bdVar.getId()).r("obj_locate", alb() ? 2 : 1).f("obj_id", bdVar.rO() == null ? -1L : bdVar.rO().live_id).r("obj_type", 1));
    }
}
