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
    private v<be> buT;
    private HashSet<String> cNV;
    private com.baidu.tieba.card.t cOe;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    private void J(bd bdVar) {
        if (this.cNV == null) {
            this.cNV = new HashSet<>();
        }
        if (bdVar.getTid() != null && !this.cNV.contains(bdVar.getTid())) {
            this.cNV.add(bdVar.getTid());
            TiebaStatic.log(new ak("c11662").r("obj_param1", 1).ac("post_id", bdVar.getTid()));
        }
    }

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.buT = new v<be>() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, be beVar) {
                if (view != null && beVar != null && beVar.threadData != null) {
                    bd bdVar = beVar.threadData;
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.aqv().a(com.baidu.tieba.frs.e.c.cYY, bdVar, 2);
                    } else {
                        com.baidu.tieba.frs.e.b.aqv().a(com.baidu.tieba.frs.e.c.cYY, bdVar, 1);
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
        this.cOe = new com.baidu.tieba.card.t(this.mPageContext);
        this.cOe.k(this.mPageId);
        this.cOe.currentPageType = 3;
        this.cOe.dR(false);
        if (this.cOe.bvI != null) {
            this.cOe.bvI.anO = 3;
        }
        if (this.cOe.ccm != null) {
            this.cOe.ccm.ccQ = 3;
        }
        return new com.baidu.tieba.card.a.a<>(this.cOe);
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
        beVar.aaF = 2;
        beVar.aaG = 1;
        com.baidu.tieba.frs.d.a(aVar.acB().abX(), this.cGO);
        aVar.acB().a(beVar);
        aVar.acB().b(this.buT);
        com.baidu.tieba.frs.e.b.aqv().a(cYY, bdVar);
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
