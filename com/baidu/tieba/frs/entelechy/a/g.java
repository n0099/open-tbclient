package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.card.t;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.play.aa;
/* loaded from: classes2.dex */
public class g extends com.baidu.tieba.frs.g<bd, a<Object>> implements t, u, com.baidu.tieba.frs.e.c {
    private int clN;
    private v<bd> clO;
    private String forumName;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.clN = 0;
        this.clO = new v<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    if (view.getId() == d.g.frame_video) {
                        com.baidu.tieba.frs.e.b.azS().a(com.baidu.tieba.frs.e.c.dUj, bdVar, 4);
                    } else if (view.getId() == d.g.layout_root) {
                        com.baidu.tieba.frs.e.b.azS().a(com.baidu.tieba.frs.e.c.dUj, bdVar, 1);
                    } else if (view.getId() == d.g.image_user) {
                        com.baidu.tieba.frs.e.b.azS().a(com.baidu.tieba.frs.e.c.dUj, bdVar, 2);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.g.a(com.baidu.tieba.frs.e.c.dUj, bdVar.zM());
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
        com.baidu.tieba.frs.entelechy.view.a aVar = new com.baidu.tieba.frs.entelechy.view.a(this.mPageContext, this.mPageId);
        aVar.j(this.mPageId);
        aVar.setForumName(this.forumName);
        return new a(aVar);
    }

    private aa P(bd bdVar) {
        if (bdVar == null) {
            return null;
        }
        aa aaVar = new aa();
        aaVar.mLocate = bdVar.Ae() ? "3" : "2";
        aaVar.cZL = dUj.dTZ;
        aaVar.bCV = bdVar.getTid();
        aaVar.gwe = bdVar.mRecomAbTag;
        if (bdVar.zF() != null) {
            aaVar.gwf = bdVar.zF().video_md5;
        }
        bdVar.Ai();
        return aaVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, a aVar) {
        if (aVar == null || aVar.alY() == null) {
            return null;
        }
        if (bdVar != null) {
            bdVar.aQp = this.clN;
        }
        com.baidu.tieba.frs.f.a(aVar.alY().alu(), this.dDS);
        aVar.alY().setVideoStatsData(P(bdVar));
        aVar.alY().a(bdVar);
        aVar.alY().b(this.clO);
        com.baidu.tieba.frs.e.b.azS().a(dUj, bdVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.t
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.u
    public void setCardShowType(int i) {
        this.clN = i;
    }
}
