package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadSmartAppLayout;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class u extends com.baidu.tieba.frs.h<bi, com.baidu.card.af<bj>> implements com.baidu.adp.widget.ListView.s, com.baidu.tieba.a.f, com.baidu.tieba.card.x, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String LC;
    private com.baidu.tieba.card.z<bj> eMX;
    private int gwp;
    private String mFrom;

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.gwp = 3;
        this.eMX = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.u.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (u.this.gnS != null) {
                        u.this.gnS.a(view, (View) bjVar, (Object) u.this.getType());
                    }
                    if ("c13010".equals(u.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").X("obj_type", 1).s("fid", bjVar.getFid()).cy("tid", bjVar.getTid()));
                    }
                    com.baidu.tieba.frs.d.a.a(bjVar, 1, u.this.mPageId, com.baidu.tieba.frs.d.d.gwq, u.this.getTbPageTag());
                    if (view.getId() == R.id.thread_card_root && bjVar.aBb()) {
                        u.this.ao(bjVar);
                    }
                    if ((view instanceof ThreadSmartAppLayout) || view.getId() == R.id.iv_thread_smart_app_head || view.getId() == R.id.tv_thread_smart_app_title || view.getId() == R.id.tv_thread_smart_app_abstract) {
                        com.baidu.tieba.card.l.zS(bjVar.getTid());
                        if (bjVar.aDa() != null) {
                            TiebaStatic.log(new an("c13274").s("uid", TbadkCoreApplication.getCurrentAccountId()).s("fid", bjVar.getFid()).cy("obj_source", "frs_card").s("obj_id", bjVar.aDa().swan_app_id.longValue()).cy("obj_name", bjVar.aDa().name).cy("tid", bjVar.getTid()).X("obj_param1", bjVar.aDa().is_game.intValue()));
                            return;
                        }
                        return;
                    }
                    com.baidu.tieba.frs.d.c.bJJ().a(com.baidu.tieba.frs.d.d.gwq, bjVar, 1);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public com.baidu.card.af<bj> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        aVar.a((com.baidu.card.h) new com.baidu.card.ab(this.mPageContext.getPageActivity()));
        com.baidu.card.ad a = aVar.a(false, viewGroup, this.fWD);
        a.aQ(3);
        com.baidu.card.af<bj> afVar = new com.baidu.card.af<>(a);
        afVar.setPageId(this.mPageId);
        a((com.baidu.adp.widget.ListView.s) this);
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bi biVar, com.baidu.card.af<bj> afVar) {
        super.a(i, view, viewGroup, (ViewGroup) biVar, (bi) afVar);
        if (biVar == null || afVar == null || afVar.getView() == null) {
            return null;
        }
        afVar.nk().setPage(this.LC);
        afVar.nk().setPosition(i);
        afVar.b((com.baidu.card.af<bj>) biVar.cRf);
        afVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.nk().a(this.eMX);
        biVar.cRf.aDw();
        return afVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void wO(String str) {
        this.LC = str;
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pz(int i) {
        this.gwp = i;
    }

    @Override // com.baidu.tieba.card.y
    public void kr(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bGX() {
        return gwq;
    }

    @Override // com.baidu.adp.widget.ListView.s
    public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
        if ((mVar instanceof bi) && (view.getTag() instanceof com.baidu.card.af)) {
            com.baidu.card.af afVar = (com.baidu.card.af) view.getTag();
            bj bjVar = ((bi) mVar).cRf;
            bjVar.objType = 1;
            if (this.eMX != null) {
                this.eMX.a(afVar.getView(), bjVar);
            }
            au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), this.gwp, false);
            afVar.nk().b(new a.C0052a(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(bj bjVar) {
        TiebaStatic.log(new an("c12126").cy("tid", bjVar.getId()).X("obj_locate", bDC() ? 2 : 1).s("obj_id", bjVar.aCH() == null ? -1L : bjVar.aCH().live_id).X("obj_type", 1));
    }
}
