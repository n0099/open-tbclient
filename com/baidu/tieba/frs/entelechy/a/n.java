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
    private v<be> clT;
    private int clW;
    private HashSet<String> dKZ;
    private com.baidu.tieba.card.s dLf;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    private void Q(bd bdVar) {
        if (this.dKZ == null) {
            this.dKZ = new HashSet<>();
        }
        if (bdVar.getTid() != null && !this.dKZ.contains(bdVar.getTid())) {
            this.dKZ.add(bdVar.getTid());
            TiebaStatic.log(new ak("c11662").s("obj_param1", 1).ab("post_id", bdVar.getTid()));
        }
    }

    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.clW = 0;
        this.clT = new v<be>() { // from class: com.baidu.tieba.frs.entelechy.a.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, be beVar) {
                if (view != null && beVar != null && beVar.threadData != null) {
                    bd bdVar = beVar.threadData;
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.azR().a(com.baidu.tieba.frs.e.c.dUq, bdVar, 2);
                    } else {
                        com.baidu.tieba.frs.e.b.azR().a(com.baidu.tieba.frs.e.c.dUq, bdVar, 1);
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
        this.dLf = new com.baidu.tieba.card.s(this.mPageContext);
        this.dLf.j(this.mPageId);
        this.dLf.currentPageType = 3;
        this.dLf.eL(false);
        if (this.dLf.cmk != null) {
            this.dLf.cmk.aQE = 3;
        }
        if (this.dLf.cYC != null) {
            this.dLf.cYC.cZh = 3;
        }
        if (this.dLf.cmX != null) {
            this.dLf.cmX.setHideBarName(true);
        }
        return new com.baidu.tieba.card.a.a<>(this.dLf);
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
            bdVar.aQz = this.clW;
        }
        be beVar = new be(bdVar);
        beVar.stType = "frs_page";
        beVar.aQC = 2;
        beVar.aQD = 1;
        beVar.aQE = 3;
        com.baidu.tieba.frs.f.a(aVar.alY().alu(), this.dEb);
        com.baidu.tieba.frs.f.a(aVar.alY().alv(), this.dEb);
        aVar.alY().a(beVar);
        aVar.alY().b(this.clT);
        com.baidu.tieba.frs.e.b.azR().a(dUq, bdVar);
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
        this.clW = i;
    }
}
