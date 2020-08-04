package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.as;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class ac extends com.baidu.tieba.frs.j<bu, com.baidu.card.ak<bv>> implements com.baidu.adp.widget.ListView.z, com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String afx;
    private com.baidu.tieba.card.aa<bv> fWK;
    private int hOF;
    private String mFrom;

    public ac(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.hOF = 3;
        this.fWK = new com.baidu.tieba.card.aa<bv>() { // from class: com.baidu.tieba.frs.entelechy.a.ac.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bv bvVar) {
                if (view != null && bvVar != null) {
                    if (ac.this.hFd != null) {
                        ac.this.hFd.a(view, (View) bvVar, (Object) ac.this.getType());
                    }
                    if ("c13010".equals(ac.this.mFrom)) {
                        TiebaStatic.log(new ap("c13010").ah("obj_type", 1).t("fid", bvVar.getFid()).dn("tid", bvVar.getTid()));
                    }
                    com.baidu.tieba.frs.d.a.a(bvVar, 1, ac.this.mPageId, com.baidu.tieba.frs.d.d.hOG, ac.this.getTbPageTag());
                    if (view.getId() == R.id.thread_card_root && bvVar.aUR()) {
                        ac.this.ap(bvVar);
                    }
                    if (view instanceof VoteView) {
                        com.baidu.tieba.card.m.Ez(bvVar.getTid());
                    } else {
                        com.baidu.tieba.frs.d.c.chQ().a(com.baidu.tieba.frs.d.d.hOG, bvVar, 1);
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
    /* renamed from: aR */
    public com.baidu.card.ak<bv> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        as asVar = new as(this.mPageContext.getPageActivity());
        asVar.setPageContext(this.mPageContext);
        asVar.setFromForPb(3);
        asVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds8));
        aVar.a((com.baidu.card.h) asVar);
        com.baidu.card.ai a = aVar.a(false, viewGroup, this.hlu);
        a.setSourceForPb(3);
        com.baidu.card.ak<bv> akVar = new com.baidu.card.ak<>(a);
        akVar.setPageId(this.mPageId);
        akVar.aL(false);
        a((com.baidu.adp.widget.ListView.z) this);
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bu buVar, com.baidu.card.ak<bv> akVar) {
        super.a(i, view, viewGroup, (ViewGroup) buVar, (bu) akVar);
        if (buVar == null || akVar == null || akVar.getView() == null) {
            return null;
        }
        akVar.sg().setPage(this.afx);
        akVar.sg().setPosition(i);
        akVar.b((com.baidu.card.ak<bv>) buVar.dLK);
        akVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.sg().a(this.fWK);
        buVar.dLK.aXx();
        return akVar.getView();
    }

    @Override // com.baidu.adp.widget.ListView.z
    public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
        if ((qVar instanceof bu) && (view.getTag() instanceof com.baidu.card.ak)) {
            com.baidu.card.ak akVar = (com.baidu.card.ak) view.getTag();
            bv bvVar = ((bu) qVar).dLK;
            bvVar.objType = 1;
            if (this.fWK != null) {
                this.fWK.a(akVar.getView(), bvVar);
            }
            ax.a((AbsThreadDataSupport) bvVar, view.getContext(), this.hOF, false);
            akVar.sg().b(new a.C0096a(1));
        }
    }

    @Override // com.baidu.tieba.a.f
    public void AP(String str) {
        this.afx = str;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void rn(int i) {
        this.hOF = i;
    }

    @Override // com.baidu.tieba.card.z
    public void mJ(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return hOG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(bv bvVar) {
        TiebaStatic.log(new ap("c12126").dn("tid", bvVar.getId()).ah("obj_locate", cbj() ? 2 : 1).t("obj_id", bvVar.aWF() == null ? -1L : bvVar.aWF().live_id).ah("obj_type", 1));
    }
}
