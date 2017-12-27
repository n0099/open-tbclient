package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.be;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.play.aa;
/* loaded from: classes2.dex */
public class g extends com.baidu.tieba.frs.g<be, a<Object>> implements com.baidu.tieba.card.u, com.baidu.tieba.frs.d.c {
    private v<be> cis;
    private String forumName;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.cis = new v<be>() { // from class: com.baidu.tieba.frs.entelechy.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, be beVar) {
                if (view != null && beVar != null) {
                    if (view.getId() == d.g.frame_video) {
                        com.baidu.tieba.frs.d.b.axH().a(com.baidu.tieba.frs.d.c.dMh, beVar, 4);
                    } else if (view.getId() == d.g.layout_root) {
                        com.baidu.tieba.frs.d.b.axH().a(com.baidu.tieba.frs.d.c.dMh, beVar, 1);
                    } else if (view.getId() == d.g.image_user) {
                        com.baidu.tieba.frs.d.b.axH().a(com.baidu.tieba.frs.d.c.dMh, beVar, 2);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.e.g.a(com.baidu.tieba.frs.d.c.dMh, beVar.zw());
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
        com.baidu.tieba.frs.entelechy.view.a aVar = new com.baidu.tieba.frs.entelechy.view.a(this.mPageContext, this.mPageId);
        aVar.j(this.mPageId);
        aVar.setForumName(this.forumName);
        return new a(aVar);
    }

    private aa M(be beVar) {
        if (beVar == null) {
            return null;
        }
        aa aaVar = new aa();
        aaVar.mLocate = beVar.zS() ? "3" : "2";
        aaVar.cSk = dMh.dLX;
        aaVar.bAK = beVar.getTid();
        aaVar.gER = beVar.mRecomAbTag;
        if (beVar.zp() != null) {
            aaVar.gES = beVar.zp().video_md5;
        }
        beVar.zW();
        return aaVar;
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
        aVar.akh().b(this.cis);
        com.baidu.tieba.frs.d.b.axH().a(dMh, beVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.forumName = str;
    }
}
