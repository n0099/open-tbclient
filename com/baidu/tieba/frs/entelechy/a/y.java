package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadSmartAppLayout;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class y extends com.baidu.tieba.frs.k<bv, am<bw>> implements com.baidu.adp.widget.ListView.ab, com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String ahu;
    private com.baidu.tieba.card.ab<bw> gSA;
    private int iRk;
    private String mFrom;

    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.iRk = 3;
        this.gSA = new com.baidu.tieba.card.ab<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.y.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if (y.this.iGT != null) {
                        y.this.iGT.a(view, (View) bwVar, (Object) y.this.getType());
                    }
                    if ("c13010".equals(y.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").al("obj_type", 1).w("fid", bwVar.getFid()).dR("tid", bwVar.getTid()));
                    }
                    com.baidu.tieba.frs.d.a.a(bwVar, 1, y.this.mPageId, com.baidu.tieba.frs.d.d.iRl, y.this.getTbPageTag());
                    if (view.getId() == R.id.thread_card_root && bwVar.blg()) {
                        y.this.aq(bwVar);
                    }
                    if ((view instanceof ThreadSmartAppLayout) || view.getId() == R.id.iv_thread_smart_app_head || view.getId() == R.id.tv_thread_smart_app_title || view.getId() == R.id.tv_thread_smart_app_abstract) {
                        com.baidu.tieba.card.n.IZ(bwVar.getTid());
                        if (bwVar.bnp() != null) {
                            TiebaStatic.log(new aq("c13274").w("uid", TbadkCoreApplication.getCurrentAccountId()).w("fid", bwVar.getFid()).dR("obj_source", "frs_card").w("obj_id", bwVar.bnp().swan_app_id.longValue()).dR("obj_name", bwVar.bnp().name).dR("tid", bwVar.getTid()).al("obj_param1", bwVar.bnp().is_game.intValue()));
                            return;
                        }
                        return;
                    }
                    com.baidu.tieba.frs.d.c.cEP().a(com.baidu.tieba.frs.d.d.iRl, bwVar, 1);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aV */
    public am<bw> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        aVar.a((com.baidu.card.i) new com.baidu.card.ai(this.mPageContext.getPageActivity()));
        com.baidu.card.ak a2 = aVar.a(false, viewGroup, this.imM);
        a2.setSourceForPb(3);
        am<bw> amVar = new am<>(a2);
        amVar.setPageId(this.mPageId);
        a((com.baidu.adp.widget.ListView.ab) this);
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, am<bw> amVar) {
        super.a(i, view, viewGroup, (ViewGroup) bvVar, (bv) amVar);
        if (bvVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        amVar.tW().setPage(this.ahu);
        amVar.tW().setPosition(i);
        amVar.b((am<bw>) bvVar.exA);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.gSA);
        bvVar.exA.bnM();
        return amVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void EZ(String str) {
        this.ahu = str;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void vd(int i) {
        this.iRk = i;
    }

    @Override // com.baidu.tieba.card.aa
    public void oA(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return iRl;
    }

    @Override // com.baidu.adp.widget.ListView.ab
    public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
        if ((qVar instanceof bv) && (view.getTag() instanceof am)) {
            am amVar = (am) view.getTag();
            bw bwVar = ((bv) qVar).exA;
            bwVar.objType = 1;
            if (this.gSA != null) {
                this.gSA.a(amVar.getView(), bwVar);
            }
            ay.a((AbsThreadDataSupport) bwVar, view.getContext(), this.iRk, false);
            amVar.tW().b(new a.C0097a(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(bw bwVar) {
        TiebaStatic.log(new aq("c12126").dR("tid", bwVar.getId()).al("obj_locate", cxY() ? 2 : 1).w("obj_id", bwVar.bmU() == null ? -1L : bwVar.bmU().live_id).al("obj_type", 1));
    }
}
