package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.card.at;
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
/* loaded from: classes16.dex */
public class ac extends com.baidu.tieba.frs.k<bv, com.baidu.card.al<bw>> implements com.baidu.adp.widget.ListView.ab, com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String agH;
    private com.baidu.tieba.card.aa<bw> giJ;
    private int icK;
    private String mFrom;

    public ac(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.icK = 3;
        this.giJ = new com.baidu.tieba.card.aa<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.ac.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if (ac.this.hSt != null) {
                        ac.this.hSt.a(view, (View) bwVar, (Object) ac.this.getType());
                    }
                    if ("c13010".equals(ac.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").ai("obj_type", 1).u("fid", bwVar.getFid()).dD("tid", bwVar.getTid()));
                    }
                    com.baidu.tieba.frs.d.a.a(bwVar, 1, ac.this.mPageId, com.baidu.tieba.frs.d.d.icL, ac.this.getTbPageTag());
                    if (view.getId() == R.id.thread_card_root && bwVar.bdk()) {
                        ac.this.ap(bwVar);
                    }
                    if (view instanceof VoteView) {
                        com.baidu.tieba.card.m.GY(bwVar.getTid());
                    } else {
                        com.baidu.tieba.frs.d.c.csu().a(com.baidu.tieba.frs.d.d.icL, bwVar, 1);
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
    /* renamed from: aQ */
    public com.baidu.card.al<bw> b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity(), false);
        at atVar = new at(this.mPageContext.getPageActivity());
        atVar.setPageContext(this.mPageContext);
        atVar.setFromForPb(3);
        atVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds8));
        aVar.a((com.baidu.card.h) atVar);
        com.baidu.card.aj a = aVar.a(false, viewGroup, this.hyl);
        a.setSourceForPb(3);
        com.baidu.card.al<bw> alVar = new com.baidu.card.al<>(a);
        alVar.setPageId(this.mPageId);
        alVar.aM(false);
        a((com.baidu.adp.widget.ListView.ab) this);
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, com.baidu.card.al<bw> alVar) {
        super.a(i, view, viewGroup, (ViewGroup) bvVar, (bv) alVar);
        if (bvVar == null || alVar == null || alVar.getView() == null) {
            return null;
        }
        alVar.tR().setPage(this.agH);
        alVar.tR().setPosition(i);
        alVar.b((com.baidu.card.al<bw>) bvVar.dUS);
        alVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        alVar.tR().a(this.giJ);
        bvVar.dUS.bfQ();
        return alVar.getView();
    }

    @Override // com.baidu.adp.widget.ListView.ab
    public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
        if ((qVar instanceof bv) && (view.getTag() instanceof com.baidu.card.al)) {
            com.baidu.card.al alVar = (com.baidu.card.al) view.getTag();
            bw bwVar = ((bv) qVar).dUS;
            bwVar.objType = 1;
            if (this.giJ != null) {
                this.giJ.a(alVar.getView(), bwVar);
            }
            ay.a((AbsThreadDataSupport) bwVar, view.getContext(), this.icK, false);
            alVar.tR().b(new a.C0095a(1));
        }
    }

    @Override // com.baidu.tieba.a.f
    public void Dj(String str) {
        this.agH = str;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void tz(int i) {
        this.icK = i;
    }

    @Override // com.baidu.tieba.card.z
    public void nm(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return icL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(bw bwVar) {
        TiebaStatic.log(new aq("c12126").dD("tid", bwVar.getId()).ai("obj_locate", clF() ? 2 : 1).u("obj_id", bwVar.beY() == null ? -1L : bwVar.beY().live_id).ai("obj_type", 1));
    }
}
