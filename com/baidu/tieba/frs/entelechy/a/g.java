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
    private v<bd> ciz;
    private String forumName;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.ciz = new v<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    if (view.getId() == d.g.frame_video) {
                        com.baidu.tieba.frs.d.b.ayK().a(com.baidu.tieba.frs.d.c.dQJ, bdVar, 4);
                    } else if (view.getId() == d.g.layout_root) {
                        com.baidu.tieba.frs.d.b.ayK().a(com.baidu.tieba.frs.d.c.dQJ, bdVar, 1);
                    } else if (view.getId() == d.g.image_user) {
                        com.baidu.tieba.frs.d.b.ayK().a(com.baidu.tieba.frs.d.c.dQJ, bdVar, 2);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.e.g.a(com.baidu.tieba.frs.d.c.dQJ, bdVar.zr());
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
        aaVar.mLocate = bdVar.zK() ? "3" : "2";
        aaVar.cWM = dQJ.dQz;
        aaVar.bAT = bdVar.getTid();
        aaVar.gtY = bdVar.mRecomAbTag;
        if (bdVar.zk() != null) {
            aaVar.gtZ = bdVar.zk().video_md5;
        }
        bdVar.zO();
        return aaVar;
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
        aVar.alk().b(this.ciz);
        com.baidu.tieba.frs.d.b.ayK().a(dQJ, bdVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.forumName = str;
    }
}
