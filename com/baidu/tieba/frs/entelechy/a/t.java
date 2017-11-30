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
import com.baidu.tieba.play.y;
/* loaded from: classes.dex */
public class t extends com.baidu.tieba.frs.d<bd, a<com.baidu.tieba.frs.entelechy.view.a>> implements com.baidu.tieba.card.u, com.baidu.tieba.frs.e.c {
    private v<bd> buV;
    private com.baidu.tieba.frs.entelechy.view.a cOk;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.buV = new v<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    if (view.getId() == d.g.layout_root || (t.this.cOk.bvH != null && t.this.cOk.bvH.getCommentContainer() != null && view.getId() == t.this.cOk.bvH.getCommentContainer().getId())) {
                        com.baidu.tieba.frs.e.b.aqn().a(com.baidu.tieba.frs.e.c.cYM, bdVar, 1);
                        t.this.I(bdVar);
                    } else if (view.getId() == d.g.card_home_page_normal_thread_user_name || view.getId() == d.g.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.e.b.aqn().a(com.baidu.tieba.frs.e.c.cYM, bdVar, 2);
                    } else if (view.getId() == d.g.header_divider) {
                        com.baidu.tieba.frs.f.g.a(com.baidu.tieba.frs.e.c.cYM, bdVar.rW());
                    } else if (view.getId() == d.g.frame_video) {
                        com.baidu.tieba.frs.e.b.aqn().a(com.baidu.tieba.frs.e.c.cYM, bdVar, 4);
                        t.this.I(bdVar);
                    } else if (view.getId() == d.g.card_god_reply_layout) {
                        t.this.I(bdVar);
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
        this.cOk = new com.baidu.tieba.frs.entelechy.view.a(this.mPageContext, this.mPageId);
        this.cOk.k(this.mPageId);
        this.cOk.setForumName(this.mForumName);
        return new a(this.cOk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.d, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, a aVar) {
        if (aVar == null || aVar.acs() == null) {
            return null;
        }
        aVar.acs().setVideoStatsData(G(bdVar));
        aVar.acs().a(bdVar);
        aVar.acs().setForumName(this.mForumName);
        aVar.acs().b(this.buV);
        com.baidu.tieba.frs.e.b.aqn().a(cYM, bdVar);
        com.baidu.tieba.frs.e.b.aqn().Q(bdVar);
        if (bdVar != null) {
            TiebaStatic.log(new ak("c12125").ac("tid", bdVar.getId()).r("obj_locate", akS() ? 2 : 1).f("obj_id", bdVar.rQ() != null ? bdVar.rQ().live_id : -1L).r("obj_type", 1));
            bdVar.sw();
        }
        return aVar.getView();
    }

    private y G(bd bdVar) {
        if (bdVar == null) {
            return null;
        }
        y yVar = new y();
        yVar.mLocate = bdVar.ss() ? "3" : "2";
        yVar.aAn = cYM.cYE;
        yVar.aMR = bdVar.getTid();
        yVar.mSource = bdVar.aaj;
        yVar.fQp = bdVar.aao;
        yVar.fQq = bdVar.aak;
        yVar.fQs = bdVar.aal;
        if (bdVar.rP() != null) {
            yVar.fQt = bdVar.rP().video_md5;
        }
        return yVar;
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(bd bdVar) {
        TiebaStatic.log(new ak("c12126").ac("tid", bdVar.getId()).r("obj_locate", akS() ? 2 : 1).f("obj_id", bdVar.rQ() == null ? -1L : bdVar.rQ().live_id).r("obj_type", 1));
    }
}
