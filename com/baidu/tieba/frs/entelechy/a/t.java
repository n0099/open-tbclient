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
    private v<bd> buW;
    private com.baidu.tieba.frs.entelechy.view.a cOv;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.buW = new v<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    if (view.getId() == d.g.layout_root || (t.this.cOv.bvI != null && t.this.cOv.bvI.getCommentContainer() != null && view.getId() == t.this.cOv.bvI.getCommentContainer().getId())) {
                        com.baidu.tieba.frs.e.b.aqw().a(com.baidu.tieba.frs.e.c.cYY, bdVar, 1);
                        t.this.K(bdVar);
                    } else if (view.getId() == d.g.card_home_page_normal_thread_user_name || view.getId() == d.g.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.e.b.aqw().a(com.baidu.tieba.frs.e.c.cYY, bdVar, 2);
                    } else if (view.getId() == d.g.header_divider) {
                        com.baidu.tieba.frs.f.g.a(com.baidu.tieba.frs.e.c.cYY, bdVar.rU());
                    } else if (view.getId() == d.g.frame_video) {
                        com.baidu.tieba.frs.e.b.aqw().a(com.baidu.tieba.frs.e.c.cYY, bdVar, 4);
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
        this.cOv = new com.baidu.tieba.frs.entelechy.view.a(this.mPageContext, this.mPageId);
        this.cOv.k(this.mPageId);
        this.cOv.setForumName(this.mForumName);
        return new a(this.cOv);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.e, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, a aVar) {
        if (aVar == null || aVar.acC() == null) {
            return null;
        }
        com.baidu.tieba.frs.d.a(aVar.acC().abY(), this.cGO);
        aVar.acC().setVideoStatsData(I(bdVar));
        aVar.acC().a(bdVar);
        aVar.acC().setForumName(this.mForumName);
        aVar.acC().b(this.buW);
        com.baidu.tieba.frs.e.b.aqw().a(cYY, bdVar);
        com.baidu.tieba.frs.e.b.aqw().S(bdVar);
        if (bdVar != null) {
            TiebaStatic.log(new ak("c12125").ac("tid", bdVar.getId()).r("obj_locate", alc() ? 2 : 1).f("obj_id", bdVar.rO() != null ? bdVar.rO().live_id : -1L).r("obj_type", 1));
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
        yVar.aAs = cYY.cYQ;
        yVar.aMU = bdVar.getTid();
        yVar.mSource = bdVar.aad;
        yVar.fRi = bdVar.aai;
        yVar.fRj = bdVar.aae;
        yVar.fRl = bdVar.aaf;
        if (bdVar.rN() != null) {
            yVar.fRm = bdVar.rN().video_md5;
        }
        return yVar;
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(bd bdVar) {
        TiebaStatic.log(new ak("c12126").ac("tid", bdVar.getId()).r("obj_locate", alc() ? 2 : 1).f("obj_id", bdVar.rO() == null ? -1L : bdVar.rO().live_id).r("obj_type", 1));
    }
}
