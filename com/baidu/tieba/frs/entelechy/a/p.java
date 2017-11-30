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
import java.util.HashSet;
/* loaded from: classes.dex */
public class p extends com.baidu.adp.widget.ListView.a<bd, com.baidu.tieba.card.a.a<com.baidu.tieba.card.t>> implements com.baidu.tieba.card.u, com.baidu.tieba.frs.e.c {
    private v<be> buS;
    private HashSet<String> cNK;
    private com.baidu.tieba.card.t cNT;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    private void H(bd bdVar) {
        if (this.cNK == null) {
            this.cNK = new HashSet<>();
        }
        if (bdVar.getTid() != null && !this.cNK.contains(bdVar.getTid())) {
            this.cNK.add(bdVar.getTid());
            TiebaStatic.log(new ak("c11662").r("obj_param1", 1).ac("post_id", bdVar.getTid()));
        }
    }

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.buS = new v<be>() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, be beVar) {
                if (view != null && beVar != null && beVar.threadData != null) {
                    bd bdVar = beVar.threadData;
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.aqn().a(com.baidu.tieba.frs.e.c.cYM, bdVar, 2);
                    } else {
                        com.baidu.tieba.frs.e.b.aqn().a(com.baidu.tieba.frs.e.c.cYM, bdVar, 1);
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
        this.cNT = new com.baidu.tieba.card.t(this.mPageContext);
        this.cNT.k(this.mPageId);
        this.cNT.currentPageType = 3;
        this.cNT.dQ(false);
        if (this.cNT.bvH != null) {
            this.cNT.bvH.anM = 3;
        }
        if (this.cNT.cci != null) {
            this.cNT.cci.ccL = 3;
        }
        return new com.baidu.tieba.card.a.a<>(this.cNT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.t> aVar) {
        if (bdVar != null && bdVar.rc()) {
            H(bdVar);
        }
        if (aVar == null || aVar.acs() == null) {
            return null;
        }
        be beVar = new be(bdVar);
        beVar.stType = "frs_page";
        beVar.aaL = 2;
        beVar.aaM = 1;
        aVar.acs().a(beVar);
        aVar.acs().b(this.buS);
        com.baidu.tieba.frs.e.b.aqn().a(cYM, bdVar);
        if (bdVar != null) {
            bdVar.sw();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
