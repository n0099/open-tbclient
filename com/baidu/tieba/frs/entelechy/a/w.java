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
public class w extends com.baidu.tieba.frs.h<bi, com.baidu.card.af<bj>> implements com.baidu.adp.widget.ListView.v, com.baidu.tieba.a.f, com.baidu.tieba.card.x, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String aey;
    private com.baidu.tieba.card.z<bj> fsa;
    private int hgF;
    private String mFrom;

    public w(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.hgF = 3;
        this.fsa = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.w.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (w.this.gXU != null) {
                        w.this.gXU.a(view, (View) bjVar, (Object) w.this.getType());
                    }
                    if ("c13010".equals(w.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").af("obj_type", 1).t("fid", bjVar.getFid()).cI("tid", bjVar.getTid()));
                    }
                    com.baidu.tieba.frs.d.a.a(bjVar, 1, w.this.mPageId, com.baidu.tieba.frs.d.d.hgG, w.this.getTbPageTag());
                    if (view.getId() == R.id.thread_card_root && bjVar.aJr()) {
                        w.this.ar(bjVar);
                    }
                    if ((view instanceof ThreadSmartAppLayout) || view.getId() == R.id.iv_thread_smart_app_head || view.getId() == R.id.tv_thread_smart_app_title || view.getId() == R.id.tv_thread_smart_app_abstract) {
                        com.baidu.tieba.card.l.BB(bjVar.getTid());
                        if (bjVar.aLq() != null) {
                            TiebaStatic.log(new an("c13274").t("uid", TbadkCoreApplication.getCurrentAccountId()).t("fid", bjVar.getFid()).cI("obj_source", "frs_card").t("obj_id", bjVar.aLq().swan_app_id.longValue()).cI("obj_name", bjVar.aLq().name).cI("tid", bjVar.getTid()).af("obj_param1", bjVar.aLq().is_game.intValue()));
                            return;
                        }
                        return;
                    }
                    com.baidu.tieba.frs.d.c.bUu().a(com.baidu.tieba.frs.d.d.hgG, bjVar, 1);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aA */
    public com.baidu.card.af<bj> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        aVar.a((com.baidu.card.h) new com.baidu.card.ab(this.mPageContext.getPageActivity()));
        com.baidu.card.ad a = aVar.a(false, viewGroup, this.gEc);
        a.bc(3);
        com.baidu.card.af<bj> afVar = new com.baidu.card.af<>(a);
        afVar.setPageId(this.mPageId);
        a((com.baidu.adp.widget.ListView.v) this);
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
        afVar.rD().setPage(this.aey);
        afVar.rD().setPosition(i);
        afVar.b((com.baidu.card.af<bj>) biVar.dqA);
        afVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.rD().a(this.fsa);
        biVar.dqA.aLN();
        return afVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void yc(String str) {
        this.aey = str;
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pV(int i) {
        this.hgF = i;
    }

    @Override // com.baidu.tieba.card.y
    public void lz(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return hgG;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
        if ((mVar instanceof bi) && (view.getTag() instanceof com.baidu.card.af)) {
            com.baidu.card.af afVar = (com.baidu.card.af) view.getTag();
            bj bjVar = ((bi) mVar).dqA;
            bjVar.objType = 1;
            if (this.fsa != null) {
                this.fsa.a(afVar.getView(), bjVar);
            }
            au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), this.hgF, false);
            afVar.rD().b(new a.C0074a(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(bj bjVar) {
        TiebaStatic.log(new an("c12126").cI("tid", bjVar.getId()).af("obj_locate", bOk() ? 2 : 1).t("obj_id", bjVar.aKX() == null ? -1L : bjVar.aKX().live_id).af("obj_type", 1));
    }
}
