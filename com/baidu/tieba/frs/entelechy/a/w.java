package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadSmartAppLayout;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class w extends com.baidu.tieba.frs.h<bj, com.baidu.card.ag<bk>> implements com.baidu.adp.widget.ListView.x, com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String aeX;
    private com.baidu.tieba.card.aa<bk> fFX;
    private int hvz;
    private String mFrom;

    public w(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.hvz = 3;
        this.fFX = new com.baidu.tieba.card.aa<bk>() { // from class: com.baidu.tieba.frs.entelechy.a.w.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bk bkVar) {
                if (view != null && bkVar != null) {
                    if (w.this.hmM != null) {
                        w.this.hmM.a(view, (View) bkVar, (Object) w.this.getType());
                    }
                    if ("c13010".equals(w.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").ag("obj_type", 1).s("fid", bkVar.getFid()).dh("tid", bkVar.getTid()));
                    }
                    com.baidu.tieba.frs.d.a.a(bkVar, 1, w.this.mPageId, com.baidu.tieba.frs.d.d.hvA, w.this.getTbPageTag());
                    if (view.getId() == R.id.thread_card_root && bkVar.aPk()) {
                        w.this.as(bkVar);
                    }
                    if ((view instanceof ThreadSmartAppLayout) || view.getId() == R.id.iv_thread_smart_app_head || view.getId() == R.id.tv_thread_smart_app_title || view.getId() == R.id.tv_thread_smart_app_abstract) {
                        com.baidu.tieba.card.m.Dn(bkVar.getTid());
                        if (bkVar.aRn() != null) {
                            TiebaStatic.log(new an("c13274").s("uid", TbadkCoreApplication.getCurrentAccountId()).s("fid", bkVar.getFid()).dh("obj_source", "frs_card").s("obj_id", bkVar.aRn().swan_app_id.longValue()).dh("obj_name", bkVar.aRn().name).dh("tid", bkVar.getTid()).ag("obj_param1", bkVar.aRn().is_game.intValue()));
                            return;
                        }
                        return;
                    }
                    com.baidu.tieba.frs.d.c.caQ().a(com.baidu.tieba.frs.d.d.hvA, bkVar, 1);
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
    public com.baidu.card.ag<bk> b(ViewGroup viewGroup) {
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity(), false);
        aVar.a((com.baidu.card.h) new com.baidu.card.ac(this.mPageContext.getPageActivity()));
        com.baidu.card.ae a = aVar.a(false, viewGroup, this.gSQ);
        a.setSourceForPb(3);
        com.baidu.card.ag<bk> agVar = new com.baidu.card.ag<>(a);
        agVar.setPageId(this.mPageId);
        a((com.baidu.adp.widget.ListView.x) this);
        return agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bj bjVar, com.baidu.card.ag<bk> agVar) {
        super.a(i, view, viewGroup, (ViewGroup) bjVar, (bj) agVar);
        if (bjVar == null || agVar == null || agVar.getView() == null) {
            return null;
        }
        agVar.rM().setPage(this.aeX);
        agVar.rM().setPosition(i);
        agVar.b((com.baidu.card.ag<bk>) bjVar.dEA);
        agVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        agVar.rM().a(this.fFX);
        bjVar.dEA.aRK();
        return agVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void zL(String str) {
        this.aeX = str;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void qw(int i) {
        this.hvz = i;
    }

    @Override // com.baidu.tieba.card.z
    public void lV(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return hvA;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void a(View view, com.baidu.adp.widget.ListView.o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
        if ((oVar instanceof bj) && (view.getTag() instanceof com.baidu.card.ag)) {
            com.baidu.card.ag agVar = (com.baidu.card.ag) view.getTag();
            bk bkVar = ((bj) oVar).dEA;
            bkVar.objType = 1;
            if (this.fFX != null) {
                this.fFX.a(agVar.getView(), bkVar);
            }
            au.a((AbsThreadDataSupport) bkVar, view.getContext(), this.hvz, false);
            agVar.rM().b(new a.C0097a(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(bk bkVar) {
        TiebaStatic.log(new an("c12126").dh("tid", bkVar.getId()).ag("obj_locate", bUE() ? 2 : 1).s("obj_id", bkVar.aQS() == null ? -1L : bkVar.aQS().live_id).ag("obj_type", 1));
    }
}
