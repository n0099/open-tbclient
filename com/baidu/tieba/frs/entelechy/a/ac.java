package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.au;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class ac extends com.baidu.tieba.frs.k<bv, am<bw>> implements com.baidu.adp.widget.ListView.ab, com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String aht;
    private com.baidu.tieba.card.aa<bw> gAn;
    private int iyR;
    private String mFrom;

    public ac(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.iyR = 3;
        this.gAn = new com.baidu.tieba.card.aa<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.ac.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if (ac.this.ioA != null) {
                        ac.this.ioA.a(view, (View) bwVar, (Object) ac.this.getType());
                    }
                    if ("c13010".equals(ac.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").aj("obj_type", 1).u("fid", bwVar.getFid()).dK("tid", bwVar.getTid()));
                    }
                    com.baidu.tieba.frs.d.a.a(bwVar, 1, ac.this.mPageId, com.baidu.tieba.frs.d.d.iyS, ac.this.getTbPageTag());
                    if (view.getId() == R.id.thread_card_root && bwVar.bgN()) {
                        ac.this.aq(bwVar);
                    }
                    if (view instanceof VoteView) {
                        com.baidu.tieba.card.m.Ij(bwVar.getTid());
                    } else {
                        com.baidu.tieba.frs.d.c.czh().a(com.baidu.tieba.frs.d.d.iyS, bwVar, 1);
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
    /* renamed from: aT */
    public am<bw> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        au auVar = new au(this.mPageContext.getPageActivity());
        auVar.setPageContext(this.mPageContext);
        auVar.setFromForPb(3);
        auVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds8));
        aVar.a((com.baidu.card.i) auVar);
        com.baidu.card.ak a2 = aVar.a(false, viewGroup, this.hUo);
        a2.setSourceForPb(3);
        am<bw> amVar = new am<>(a2);
        amVar.setPageId(this.mPageId);
        amVar.aM(false);
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
        amVar.tW().setPage(this.aht);
        amVar.tW().setPosition(i);
        amVar.b((am<bw>) bvVar.eji);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.gAn);
        bvVar.eji.bjt();
        return amVar.getView();
    }

    @Override // com.baidu.adp.widget.ListView.ab
    public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
        if ((qVar instanceof bv) && (view.getTag() instanceof am)) {
            am amVar = (am) view.getTag();
            bw bwVar = ((bv) qVar).eji;
            bwVar.objType = 1;
            if (this.gAn != null) {
                this.gAn.a(amVar.getView(), bwVar);
            }
            ay.a((AbsThreadDataSupport) bwVar, view.getContext(), this.iyR, false);
            amVar.tW().b(new a.C0097a(1));
        }
    }

    @Override // com.baidu.tieba.a.f
    public void Es(String str) {
        this.aht = str;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void ux(int i) {
        this.iyR = i;
    }

    @Override // com.baidu.tieba.card.z
    public void nZ(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return iyS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(bw bwVar) {
        TiebaStatic.log(new aq("c12126").dK("tid", bwVar.getId()).aj("obj_locate", csq() ? 2 : 1).u("obj_id", bwVar.biB() == null ? -1L : bwVar.biB().live_id).aj("obj_type", 1));
    }
}
