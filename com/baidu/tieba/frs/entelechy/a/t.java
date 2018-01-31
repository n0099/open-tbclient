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
import com.baidu.tieba.play.aa;
/* loaded from: classes2.dex */
public class t extends com.baidu.tieba.frs.g<bd, a<com.baidu.tieba.frs.entelechy.view.a>> implements com.baidu.tieba.card.u, com.baidu.tieba.frs.d.c {
    private v<bd> ciH;
    private com.baidu.tieba.frs.entelechy.view.a dIv;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.ciH = new v<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    if (view.getId() == d.g.layout_root || (t.this.dIv.ciT != null && t.this.dIv.ciT.getCommentContainer() != null && view.getId() == t.this.dIv.ciT.getCommentContainer().getId())) {
                        com.baidu.tieba.frs.d.b.ayP().a(com.baidu.tieba.frs.d.c.dRe, bdVar, 1);
                        t.this.O(bdVar);
                    } else if (view.getId() == d.g.card_home_page_normal_thread_user_name || view.getId() == d.g.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.d.b.ayP().a(com.baidu.tieba.frs.d.c.dRe, bdVar, 2);
                    } else if (view.getId() == d.g.header_divider) {
                        com.baidu.tieba.frs.e.g.a(com.baidu.tieba.frs.d.c.dRe, bdVar.zs());
                    } else if (view.getId() == d.g.frame_video) {
                        com.baidu.tieba.frs.d.b.ayP().a(com.baidu.tieba.frs.d.c.dRe, bdVar, 4);
                        t.this.O(bdVar);
                    } else if (view.getId() == d.g.card_god_reply_layout) {
                        t.this.O(bdVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: av */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.dIv = new com.baidu.tieba.frs.entelechy.view.a(this.mPageContext, this.mPageId);
        this.dIv.j(this.mPageId);
        this.dIv.setForumName(this.mForumName);
        return new a(this.dIv);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, a aVar) {
        if (aVar == null || aVar.alp() == null) {
            return null;
        }
        com.baidu.tieba.frs.f.a(aVar.alp().akL(), this.dBi);
        aVar.alp().setVideoStatsData(M(bdVar));
        aVar.alp().a(bdVar);
        aVar.alp().setForumName(this.mForumName);
        aVar.alp().b(this.ciH);
        com.baidu.tieba.frs.d.b.ayP().a(dRe, bdVar);
        com.baidu.tieba.frs.d.b.ayP().R(bdVar);
        if (bdVar != null) {
            TiebaStatic.log(new ak("c12125").aa("tid", bdVar.getId()).s("obj_locate", atS() ? 2 : 1).f("obj_id", bdVar.zm() != null ? bdVar.zm().live_id : -1L).s("obj_type", 1));
            bdVar.zP();
        }
        return aVar.getView();
    }

    private aa M(bd bdVar) {
        if (bdVar == null) {
            return null;
        }
        aa aaVar = new aa();
        aaVar.mLocate = bdVar.zL() ? "3" : "2";
        aaVar.cXh = dRe.dQU;
        aaVar.bBb = bdVar.getTid();
        aaVar.mSource = bdVar.mRecomSource;
        aaVar.guq = bdVar.aOI;
        aaVar.gur = bdVar.mRecomWeight;
        aaVar.gut = bdVar.mRecomAbTag;
        if (bdVar.zl() != null) {
            aaVar.guu = bdVar.zl().video_md5;
        }
        return aaVar;
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(bd bdVar) {
        TiebaStatic.log(new ak("c12126").aa("tid", bdVar.getId()).s("obj_locate", atS() ? 2 : 1).f("obj_id", bdVar.zm() == null ? -1L : bdVar.zm().live_id).s("obj_type", 1));
    }
}
