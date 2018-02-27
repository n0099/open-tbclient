package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.t;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.play.aa;
/* loaded from: classes2.dex */
public class r extends com.baidu.tieba.frs.g<bd, a<com.baidu.tieba.frs.entelechy.view.a>> implements t, u, com.baidu.tieba.frs.e.c {
    private int clK;
    private v<bd> clL;
    private com.baidu.tieba.frs.entelechy.view.a dLk;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.clK = 0;
        this.clL = new v<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    if (view.getId() == d.g.layout_root || (r.this.dLk.clX != null && r.this.dLk.clX.getCommentContainer() != null && view.getId() == r.this.dLk.clX.getCommentContainer().getId())) {
                        com.baidu.tieba.frs.e.b.azQ().a(com.baidu.tieba.frs.e.c.dUe, bdVar, 1);
                        r.this.R(bdVar);
                    } else if (view.getId() == d.g.card_home_page_normal_thread_user_name || view.getId() == d.g.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.e.b.azQ().a(com.baidu.tieba.frs.e.c.dUe, bdVar, 2);
                    } else if (view.getId() == d.g.header_divider) {
                        com.baidu.tieba.frs.f.g.a(com.baidu.tieba.frs.e.c.dUe, bdVar.zM());
                    } else if (view.getId() == d.g.frame_video) {
                        com.baidu.tieba.frs.e.b.azQ().a(com.baidu.tieba.frs.e.c.dUe, bdVar, 4);
                        r.this.R(bdVar);
                    } else if (view.getId() == d.g.card_god_reply_layout) {
                        r.this.R(bdVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aw */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.dLk = new com.baidu.tieba.frs.entelechy.view.a(this.mPageContext, this.mPageId);
        this.dLk.j(this.mPageId);
        this.dLk.setForumName(this.mForumName);
        return new a(this.dLk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, a aVar) {
        if (aVar == null || aVar.alX() == null) {
            return null;
        }
        if (bdVar != null) {
            bdVar.aQo = this.clK;
        }
        com.baidu.tieba.frs.f.a(aVar.alX().alt(), this.dDP);
        com.baidu.tieba.frs.f.a(aVar.alX().alu(), this.dDP);
        aVar.alX().setVideoStatsData(P(bdVar));
        aVar.alX().a(bdVar);
        aVar.alX().setForumName(this.mForumName);
        aVar.alX().b(this.clL);
        com.baidu.tieba.frs.e.b.azQ().a(dUe, bdVar);
        com.baidu.tieba.frs.e.b.azQ().U(bdVar);
        if (bdVar != null) {
            TiebaStatic.log(new ak("c12125").ab("tid", bdVar.getId()).s("obj_locate", auH() ? 2 : 1).f("obj_id", bdVar.zG() != null ? bdVar.zG().live_id : -1L).s("obj_type", 1));
            bdVar.Ai();
        }
        return aVar.getView();
    }

    private aa P(bd bdVar) {
        if (bdVar == null) {
            return null;
        }
        aa aaVar = new aa();
        aaVar.mLocate = bdVar.Ae() ? "3" : "2";
        aaVar.cZI = dUe.dTU;
        aaVar.bCS = bdVar.getTid();
        aaVar.mSource = bdVar.mRecomSource;
        aaVar.gvL = bdVar.aPR;
        aaVar.gvM = bdVar.mRecomWeight;
        aaVar.gvO = bdVar.mRecomAbTag;
        if (bdVar.zF() != null) {
            aaVar.gvP = bdVar.zF().video_md5;
        }
        return aaVar;
    }

    @Override // com.baidu.tieba.card.t
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.u
    public void setCardShowType(int i) {
        this.clK = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(bd bdVar) {
        TiebaStatic.log(new ak("c12126").ab("tid", bdVar.getId()).s("obj_locate", auH() ? 2 : 1).f("obj_id", bdVar.zG() == null ? -1L : bdVar.zG().live_id).s("obj_type", 1));
    }
}
