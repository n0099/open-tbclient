package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.play.aa;
/* loaded from: classes2.dex */
public class g extends com.baidu.tieba.frs.g<bd, a<Object>> implements com.baidu.tieba.card.u, com.baidu.tieba.frs.d.c {
    private v<bd> ciH;
    private String forumName;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.ciH = new v<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    if (view.getId() == d.g.frame_video) {
                        com.baidu.tieba.frs.d.b.ayP().a(com.baidu.tieba.frs.d.c.dRe, bdVar, 4);
                    } else if (view.getId() == d.g.layout_root) {
                        com.baidu.tieba.frs.d.b.ayP().a(com.baidu.tieba.frs.d.c.dRe, bdVar, 1);
                    } else if (view.getId() == d.g.image_user) {
                        com.baidu.tieba.frs.d.b.ayP().a(com.baidu.tieba.frs.d.c.dRe, bdVar, 2);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.e.g.a(com.baidu.tieba.frs.d.c.dRe, bdVar.zs());
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
        com.baidu.tieba.frs.entelechy.view.a aVar = new com.baidu.tieba.frs.entelechy.view.a(this.mPageContext, this.mPageId);
        aVar.j(this.mPageId);
        aVar.setForumName(this.forumName);
        return new a(aVar);
    }

    private aa M(bd bdVar) {
        if (bdVar == null) {
            return null;
        }
        aa aaVar = new aa();
        aaVar.mLocate = bdVar.zL() ? "3" : "2";
        aaVar.cXh = dRe.dQU;
        aaVar.bBb = bdVar.getTid();
        aaVar.gut = bdVar.mRecomAbTag;
        if (bdVar.zl() != null) {
            aaVar.guu = bdVar.zl().video_md5;
        }
        bdVar.zP();
        return aaVar;
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
        aVar.alp().b(this.ciH);
        com.baidu.tieba.frs.d.b.ayP().a(dRe, bdVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.forumName = str;
    }
}
