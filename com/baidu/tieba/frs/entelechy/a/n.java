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
import com.baidu.tieba.card.t;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class n extends com.baidu.tieba.frs.g<bd, com.baidu.tieba.card.a.a<com.baidu.tieba.card.s>> implements t, u, com.baidu.tieba.frs.e.c {
    private v<be> clK;
    private int clN;
    private HashSet<String> dKS;
    private com.baidu.tieba.card.s dKY;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    private void Q(bd bdVar) {
        if (this.dKS == null) {
            this.dKS = new HashSet<>();
        }
        if (bdVar.getTid() != null && !this.dKS.contains(bdVar.getTid())) {
            this.dKS.add(bdVar.getTid());
            TiebaStatic.log(new ak("c11662").s("obj_param1", 1).ab("post_id", bdVar.getTid()));
        }
    }

    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.clN = 0;
        this.clK = new v<be>() { // from class: com.baidu.tieba.frs.entelechy.a.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, be beVar) {
                if (view != null && beVar != null && beVar.threadData != null) {
                    bd bdVar = beVar.threadData;
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.azS().a(com.baidu.tieba.frs.e.c.dUj, bdVar, 2);
                    } else {
                        com.baidu.tieba.frs.e.b.azS().a(com.baidu.tieba.frs.e.c.dUj, bdVar, 1);
                    }
                    if (view.getId() == d.g.thread_user_pendant_header || view.getId() == d.g.card_home_page_normal_thread_user_name || view.getId() == d.g.card_home_page_normal_thread_user_header) {
                        ak akVar = new ak("c12940");
                        akVar.ab("obj_type", "1");
                        akVar.ab("tid", beVar.threadData.getTid());
                        TiebaStatic.log(akVar);
                    } else if (view.getId() == d.g.original_thread_view) {
                        ak akVar2 = new ak("c12940");
                        akVar2.ab("obj_type", "3");
                        akVar2.ab("tid", beVar.threadData.getTid());
                        TiebaStatic.log(akVar2);
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
    /* renamed from: ad */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.s> onCreateViewHolder(ViewGroup viewGroup) {
        this.dKY = new com.baidu.tieba.card.s(this.mPageContext);
        this.dKY.j(this.mPageId);
        this.dKY.currentPageType = 3;
        this.dKY.eL(false);
        if (this.dKY.cma != null) {
            this.dKY.cma.aQv = 3;
        }
        if (this.dKY.cYt != null) {
            this.dKY.cYt.cYY = 3;
        }
        if (this.dKY.cmO != null) {
            this.dKY.cmO.setHideBarName(true);
        }
        return new com.baidu.tieba.card.a.a<>(this.dKY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.s> aVar) {
        if (bdVar != null && bdVar.yU()) {
            Q(bdVar);
        }
        if (aVar == null || aVar.alY() == null) {
            return null;
        }
        if (bdVar != null) {
            bdVar.aQp = this.clN;
        }
        be beVar = new be(bdVar);
        beVar.stType = "frs_page";
        beVar.aQt = 2;
        beVar.aQu = 1;
        beVar.aQv = 3;
        com.baidu.tieba.frs.f.a(aVar.alY().alu(), this.dDS);
        com.baidu.tieba.frs.f.a(aVar.alY().alv(), this.dDS);
        aVar.alY().a(beVar);
        aVar.alY().b(this.clK);
        com.baidu.tieba.frs.e.b.azS().a(dUj, bdVar);
        if (bdVar != null) {
            bdVar.Ai();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.t
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.u
    public void setCardShowType(int i) {
        this.clN = i;
    }
}
