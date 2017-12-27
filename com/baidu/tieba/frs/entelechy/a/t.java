package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.play.aa;
/* loaded from: classes2.dex */
public class t extends com.baidu.tieba.frs.g<be, a<com.baidu.tieba.frs.entelechy.view.a>> implements com.baidu.tieba.card.u, com.baidu.tieba.frs.d.c {
    private v<be> cis;
    private com.baidu.tieba.frs.entelechy.view.a dDz;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.cis = new v<be>() { // from class: com.baidu.tieba.frs.entelechy.a.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, be beVar) {
                if (view != null && beVar != null) {
                    if (view.getId() == d.g.layout_root || (t.this.dDz.ciE != null && t.this.dDz.ciE.getCommentContainer() != null && view.getId() == t.this.dDz.ciE.getCommentContainer().getId())) {
                        com.baidu.tieba.frs.d.b.axH().a(com.baidu.tieba.frs.d.c.dMh, beVar, 1);
                        t.this.O(beVar);
                    } else if (view.getId() == d.g.card_home_page_normal_thread_user_name || view.getId() == d.g.card_home_page_normal_thread_user_header) {
                        com.baidu.tieba.frs.d.b.axH().a(com.baidu.tieba.frs.d.c.dMh, beVar, 2);
                    } else if (view.getId() == d.g.header_divider) {
                        com.baidu.tieba.frs.e.g.a(com.baidu.tieba.frs.d.c.dMh, beVar.zw());
                    } else if (view.getId() == d.g.frame_video) {
                        com.baidu.tieba.frs.d.b.axH().a(com.baidu.tieba.frs.d.c.dMh, beVar, 4);
                        t.this.O(beVar);
                    } else if (view.getId() == d.g.card_god_reply_layout) {
                        t.this.O(beVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: at */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.dDz = new com.baidu.tieba.frs.entelechy.view.a(this.mPageContext, this.mPageId);
        this.dDz.j(this.mPageId);
        this.dDz.setForumName(this.mForumName);
        return new a(this.dDz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, be beVar, a aVar) {
        if (aVar == null || aVar.akh() == null) {
            return null;
        }
        com.baidu.tieba.frs.f.a(aVar.akh().ajD(), this.dwm);
        aVar.akh().setVideoStatsData(M(beVar));
        aVar.akh().a(beVar);
        aVar.akh().setForumName(this.mForumName);
        aVar.akh().b(this.cis);
        com.baidu.tieba.frs.d.b.axH().a(dMh, beVar);
        com.baidu.tieba.frs.d.b.axH().R(beVar);
        if (beVar != null) {
            TiebaStatic.log(new ak("c12125").ab("tid", beVar.getId()).s("obj_locate", asK() ? 2 : 1).f("obj_id", beVar.zq() != null ? beVar.zq().live_id : -1L).s("obj_type", 1));
            beVar.zW();
        }
        return aVar.getView();
    }

    private aa M(be beVar) {
        if (beVar == null) {
            return null;
        }
        aa aaVar = new aa();
        aaVar.mLocate = beVar.zS() ? "3" : "2";
        aaVar.cSk = dMh.dLX;
        aaVar.bAK = beVar.getTid();
        aaVar.mSource = beVar.mRecomSource;
        aaVar.gEO = beVar.aOH;
        aaVar.gEP = beVar.mRecomWeight;
        aaVar.gER = beVar.mRecomAbTag;
        if (beVar.zp() != null) {
            aaVar.gES = beVar.zp().video_md5;
        }
        return aaVar;
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(be beVar) {
        TiebaStatic.log(new ak("c12126").ab("tid", beVar.getId()).s("obj_locate", asK() ? 2 : 1).f("obj_id", beVar.zq() == null ? -1L : beVar.zq().live_id).s("obj_type", 1));
    }
}
