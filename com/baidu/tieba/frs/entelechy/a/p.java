package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class p extends com.baidu.tieba.frs.g<be, com.baidu.tieba.card.a.a<com.baidu.tieba.card.t>> implements com.baidu.tieba.card.u, com.baidu.tieba.frs.d.c {
    private v<bf> cip;
    private HashSet<String> dCZ;
    private com.baidu.tieba.card.t dDi;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    private void N(be beVar) {
        if (this.dCZ == null) {
            this.dCZ = new HashSet<>();
        }
        if (beVar.getTid() != null && !this.dCZ.contains(beVar.getTid())) {
            this.dCZ.add(beVar.getTid());
            TiebaStatic.log(new ak("c11662").s("obj_param1", 1).ab("post_id", beVar.getTid()));
        }
    }

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.cip = new v<bf>() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, bf bfVar) {
                if (view != null && bfVar != null && bfVar.threadData != null) {
                    be beVar = bfVar.threadData;
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.d.b.axH().a(com.baidu.tieba.frs.d.c.dMh, beVar, 2);
                    } else {
                        com.baidu.tieba.frs.d.b.axH().a(com.baidu.tieba.frs.d.c.dMh, beVar, 1);
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
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.t> onCreateViewHolder(ViewGroup viewGroup) {
        this.dDi = new com.baidu.tieba.card.t(this.mPageContext);
        this.dDi.j(this.mPageId);
        this.dDi.currentPageType = 3;
        this.dDi.ey(false);
        if (this.dDi.ciE != null) {
            this.dDi.ciE.bbP = 3;
        }
        if (this.dDi.cQU != null) {
            this.dDi.cQU.cRx = 3;
        }
        return new com.baidu.tieba.card.a.a<>(this.dDi);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, be beVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.t> aVar) {
        if (beVar != null && beVar.yC()) {
            N(beVar);
        }
        if (aVar == null || aVar.akh() == null) {
            return null;
        }
        bf bfVar = new bf(beVar);
        bfVar.stType = "frs_page";
        bfVar.aPe = 2;
        bfVar.aPf = 1;
        com.baidu.tieba.frs.f.a(aVar.akh().ajD(), this.dwm);
        aVar.akh().a(bfVar);
        aVar.akh().b(this.cip);
        com.baidu.tieba.frs.d.b.axH().a(dMh, beVar);
        if (beVar != null) {
            beVar.zW();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
