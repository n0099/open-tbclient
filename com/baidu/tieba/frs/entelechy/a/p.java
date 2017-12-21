package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.e;
import java.util.HashSet;
/* loaded from: classes.dex */
public class p extends e<bd, com.baidu.tieba.card.a.a<com.baidu.tieba.card.t>> implements com.baidu.tieba.card.u, com.baidu.tieba.frs.e.c {
    private v<be> buX;
    private HashSet<String> cNZ;
    private com.baidu.tieba.card.t cOi;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    private void J(bd bdVar) {
        if (this.cNZ == null) {
            this.cNZ = new HashSet<>();
        }
        if (bdVar.getTid() != null && !this.cNZ.contains(bdVar.getTid())) {
            this.cNZ.add(bdVar.getTid());
            TiebaStatic.log(new ak("c11662").r("obj_param1", 1).ac("post_id", bdVar.getTid()));
        }
    }

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.buX = new v<be>() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, be beVar) {
                if (view != null && beVar != null && beVar.threadData != null) {
                    bd bdVar = beVar.threadData;
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.aqw().a(com.baidu.tieba.frs.e.c.cZc, bdVar, 2);
                    } else {
                        com.baidu.tieba.frs.e.b.aqw().a(com.baidu.tieba.frs.e.c.cZc, bdVar, 1);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: U */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.t> onCreateViewHolder(ViewGroup viewGroup) {
        this.cOi = new com.baidu.tieba.card.t(this.mPageContext);
        this.cOi.k(this.mPageId);
        this.cOi.currentPageType = 3;
        this.cOi.dR(false);
        if (this.cOi.bvM != null) {
            this.cOi.bvM.anR = 3;
        }
        if (this.cOi.ccq != null) {
            this.cOi.ccq.ccU = 3;
        }
        return new com.baidu.tieba.card.a.a<>(this.cOi);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.e, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.t> aVar) {
        if (bdVar != null && bdVar.ra()) {
            J(bdVar);
        }
        if (aVar == null || aVar.acB() == null) {
            return null;
        }
        be beVar = new be(bdVar);
        beVar.stType = "frs_page";
        beVar.aaI = 2;
        beVar.aaJ = 1;
        com.baidu.tieba.frs.d.a(aVar.acB().abX(), this.cGS);
        aVar.acB().a(beVar);
        aVar.acB().b(this.buX);
        com.baidu.tieba.frs.e.b.aqw().a(cZc, bdVar);
        if (bdVar != null) {
            bdVar.su();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
