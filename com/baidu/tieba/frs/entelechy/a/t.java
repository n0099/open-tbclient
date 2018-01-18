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
    private v<bd> ciz;
    private com.baidu.tieba.frs.entelechy.view.a dIa;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.ciz = new v<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    if (view.getId() == d.g.layout_root || (t.this.dIa.ciL != null && t.this.dIa.ciL.getCommentContainer() != null && view.getId() == t.this.dIa.ciL.getCommentContainer().getId())) {
                        com.baidu.tieba.frs.d.b.ayK().a(com.baidu.tieba.frs.d.c.dQJ, bdVar, 1);
                        t.this.O(bdVar);
                    } else if (view.getId() == d.g.card_home_page_normal_thread_user_name || view.getId() == d.g.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.d.b.ayK().a(com.baidu.tieba.frs.d.c.dQJ, bdVar, 2);
                    } else if (view.getId() == d.g.header_divider) {
                        com.baidu.tieba.frs.e.g.a(com.baidu.tieba.frs.d.c.dQJ, bdVar.zr());
                    } else if (view.getId() == d.g.frame_video) {
                        com.baidu.tieba.frs.d.b.ayK().a(com.baidu.tieba.frs.d.c.dQJ, bdVar, 4);
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
        this.dIa = new com.baidu.tieba.frs.entelechy.view.a(this.mPageContext, this.mPageId);
        this.dIa.j(this.mPageId);
        this.dIa.setForumName(this.mForumName);
        return new a(this.dIa);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, a aVar) {
        if (aVar == null || aVar.alk() == null) {
            return null;
        }
        com.baidu.tieba.frs.f.a(aVar.alk().akG(), this.dAN);
        aVar.alk().setVideoStatsData(M(bdVar));
        aVar.alk().a(bdVar);
        aVar.alk().setForumName(this.mForumName);
        aVar.alk().b(this.ciz);
        com.baidu.tieba.frs.d.b.ayK().a(dQJ, bdVar);
        com.baidu.tieba.frs.d.b.ayK().R(bdVar);
        if (bdVar != null) {
            TiebaStatic.log(new ak("c12125").ab("tid", bdVar.getId()).s("obj_locate", atN() ? 2 : 1).f("obj_id", bdVar.zl() != null ? bdVar.zl().live_id : -1L).s("obj_type", 1));
            bdVar.zO();
        }
        return aVar.getView();
    }

    private aa M(bd bdVar) {
        if (bdVar == null) {
            return null;
        }
        aa aaVar = new aa();
        aaVar.mLocate = bdVar.zK() ? "3" : "2";
        aaVar.cWM = dQJ.dQz;
        aaVar.bAT = bdVar.getTid();
        aaVar.mSource = bdVar.mRecomSource;
        aaVar.gtV = bdVar.aOF;
        aaVar.gtW = bdVar.mRecomWeight;
        aaVar.gtY = bdVar.mRecomAbTag;
        if (bdVar.zk() != null) {
            aaVar.gtZ = bdVar.zk().video_md5;
        }
        return aaVar;
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(bd bdVar) {
        TiebaStatic.log(new ak("c12126").ab("tid", bdVar.getId()).s("obj_locate", atN() ? 2 : 1).f("obj_id", bdVar.zl() == null ? -1L : bdVar.zl().live_id).s("obj_type", 1));
    }
}
