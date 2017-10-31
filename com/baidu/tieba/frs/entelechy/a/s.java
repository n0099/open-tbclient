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
public class s extends com.baidu.tieba.frs.d<bh, a<com.baidu.tieba.frs.entelechy.view.a>> implements v, com.baidu.tieba.frs.e.c {
    private x<bh> boe;
    private com.baidu.tieba.frs.entelechy.view.a cEL;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.boe = new x<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.s.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (view.getId() == d.g.layout_root || (s.this.cEL.boD != null && s.this.cEL.boD.getCommentContainer() != null && view.getId() == s.this.cEL.boD.getCommentContainer().getId())) {
                        com.baidu.tieba.frs.e.b.aoe().a(com.baidu.tieba.frs.e.c.cPd, bhVar, 1);
                        s.this.F(bhVar);
                    } else if (view.getId() == d.g.card_home_page_normal_thread_user_name || view.getId() == d.g.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.e.b.aoe().a(com.baidu.tieba.frs.e.c.cPd, bhVar, 2);
                    } else if (view.getId() == d.g.header_divider) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.e.c.cPd, bhVar.rS());
                    } else if (view.getId() == d.g.frame_video) {
                        com.baidu.tieba.frs.e.b.aoe().a(com.baidu.tieba.frs.e.c.cPd, bhVar, 4);
                        s.this.F(bhVar);
                    } else if (view.getId() == d.g.card_god_reply_layout) {
                        s.this.F(bhVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aj */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cEL = new com.baidu.tieba.frs.entelechy.view.a(this.mPageContext, this.mPageId);
        this.cEL.k(this.mPageId);
        this.cEL.setForumName(this.mForumName);
        return new a(this.cEL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.d, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, a aVar) {
        if (aVar == null || aVar.aax() == null) {
            return null;
        }
        aVar.aax().setVideoStatsData(D(bhVar));
        aVar.aax().a(bhVar);
        aVar.aax().setForumName(this.mForumName);
        aVar.aax().b(this.boe);
        com.baidu.tieba.frs.e.b.aoe().a(cPd, bhVar);
        com.baidu.tieba.frs.e.b.aoe().N(bhVar);
        if (bhVar != null) {
            TiebaStatic.log(new ak("c12125").ac("tid", bhVar.getId()).r("obj_locate", aiK() ? 2 : 1).f("obj_id", bhVar.rM() != null ? bhVar.rM().live_id : -1L).r("obj_type", 1));
            bhVar.st();
        }
        return aVar.getView();
    }

    private com.baidu.tieba.play.x D(bh bhVar) {
        if (bhVar == null) {
            return null;
        }
        com.baidu.tieba.play.x xVar = new com.baidu.tieba.play.x();
        xVar.mLocate = bhVar.sp() ? TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE : "2";
        xVar.azE = cPd.cOV;
        xVar.aMi = bhVar.getTid();
        xVar.mSource = bhVar.ZQ;
        xVar.fGE = bhVar.ZV;
        xVar.fGF = bhVar.ZR;
        xVar.fGH = bhVar.ZS;
        if (bhVar.rL() != null) {
            xVar.fGI = bhVar.rL().video_md5;
        }
        return xVar;
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(bh bhVar) {
        TiebaStatic.log(new ak("c12126").ac("tid", bhVar.getId()).r("obj_locate", aiK() ? 2 : 1).f("obj_id", bhVar.rM() == null ? -1L : bhVar.rM().live_id).r("obj_type", 1));
    }
}
