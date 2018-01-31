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
/* loaded from: classes2.dex */
public class p extends com.baidu.tieba.frs.g<bd, com.baidu.tieba.card.a.a<com.baidu.tieba.card.t>> implements com.baidu.tieba.card.u, com.baidu.tieba.frs.d.c {
    private v<be> ciE;
    private HashSet<String> dHV;
    private com.baidu.tieba.card.t dIe;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    private void N(bd bdVar) {
        if (this.dHV == null) {
            this.dHV = new HashSet<>();
        }
        if (bdVar.getTid() != null && !this.dHV.contains(bdVar.getTid())) {
            this.dHV.add(bdVar.getTid());
            TiebaStatic.log(new ak("c11662").s("obj_param1", 1).aa("post_id", bdVar.getTid()));
        }
    }

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.ciE = new v<be>() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, be beVar) {
                if (view != null && beVar != null && beVar.threadData != null) {
                    bd bdVar = beVar.threadData;
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.d.b.ayP().a(com.baidu.tieba.frs.d.c.dRe, bdVar, 2);
                    } else {
                        com.baidu.tieba.frs.d.b.ayP().a(com.baidu.tieba.frs.d.c.dRe, bdVar, 1);
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
    /* renamed from: ac */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.t> onCreateViewHolder(ViewGroup viewGroup) {
        this.dIe = new com.baidu.tieba.card.t(this.mPageContext);
        this.dIe.j(this.mPageId);
        this.dIe.currentPageType = 3;
        this.dIe.eE(false);
        if (this.dIe.ciT != null) {
            this.dIe.ciT.bbX = 3;
        }
        if (this.dIe.cVR != null) {
            this.dIe.cVR.cWu = 3;
        }
        return new com.baidu.tieba.card.a.a<>(this.dIe);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.t> aVar) {
        if (bdVar != null && bdVar.yA()) {
            N(bdVar);
        }
        if (aVar == null || aVar.alp() == null) {
            return null;
        }
        be beVar = new be(bdVar);
        beVar.stType = "frs_page";
        beVar.aPg = 2;
        beVar.aPh = 1;
        com.baidu.tieba.frs.f.a(aVar.alp().akL(), this.dBi);
        com.baidu.tieba.frs.f.a(aVar.alp().akM(), this.dBi);
        aVar.alp().a(beVar);
        aVar.alp().b(this.ciE);
        com.baidu.tieba.frs.d.b.ayP().a(dRe, bdVar);
        if (bdVar != null) {
            bdVar.zP();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
