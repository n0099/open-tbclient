package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.at;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class ae extends com.baidu.tieba.frs.k<by, ThreadCardViewHolder<bz>> implements com.baidu.adp.widget.ListView.w, com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.b.d {
    private String air;
    private com.baidu.tieba.card.aa<bz> hiC;
    private int jkI;
    private String mFrom;

    public ae(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.jkI = 3;
        this.hiC = new com.baidu.tieba.card.aa<bz>() { // from class: com.baidu.tieba.frs.entelechy.adapter.ae.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bz bzVar) {
                if (view != null && bzVar != null) {
                    if (ae.this.jag != null) {
                        ae.this.jag.a(view, (View) bzVar, (Object) ae.this.getType());
                    }
                    if ("c13010".equals(ae.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").an("obj_type", 1).w("fid", bzVar.getFid()).dW("tid", bzVar.getTid()));
                    }
                    com.baidu.tieba.frs.b.a.a(bzVar, 1, ae.this.mPageId, com.baidu.tieba.frs.b.d.jkJ, ae.this.getTbPageTag());
                    if (view.getId() == R.id.thread_card_root && bzVar.bmc()) {
                        ae.this.as(bzVar);
                    }
                    if (view instanceof VoteView) {
                        com.baidu.tieba.card.m.Ic(bzVar.getTid());
                    } else {
                        com.baidu.tieba.frs.b.c.cIR().a(com.baidu.tieba.frs.b.d.jkJ, bzVar, 1);
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
    /* renamed from: bd */
    public ThreadCardViewHolder<bz> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        at atVar = new at(this.mPageContext.getPageActivity());
        atVar.setPageContext(this.mPageContext);
        atVar.setFromForPb(3);
        aVar.a((com.baidu.card.h) atVar);
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.EXTEND, viewGroup, this.iGb);
        a2.setSourceForPb(3);
        ThreadCardViewHolder<bz> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.mPageId);
        threadCardViewHolder.aL(false);
        a((com.baidu.adp.widget.ListView.w) this);
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, by byVar, ThreadCardViewHolder<bz> threadCardViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) byVar, (by) threadCardViewHolder);
        if (byVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
            return null;
        }
        threadCardViewHolder.tm().setPage(this.air);
        threadCardViewHolder.tm().setPosition(i);
        threadCardViewHolder.b((ThreadCardViewHolder<bz>) byVar.eHK);
        threadCardViewHolder.tm().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tm().a(this.hiC);
        byVar.eHK.boL();
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.adp.widget.ListView.w
    public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
        if ((nVar instanceof by) && (view.getTag() instanceof ThreadCardViewHolder)) {
            ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
            bz bzVar = ((by) nVar).eHK;
            bzVar.objType = 1;
            if (this.hiC != null) {
                this.hiC.a(threadCardViewHolder.getView(), bzVar);
            }
            ay.a((com.baidu.tbadk.core.data.a) bzVar, view.getContext(), this.jkI, false);
            threadCardViewHolder.tm().b(new a.C0089a(1));
        }
    }

    @Override // com.baidu.tieba.a.f
    public void Ea(String str) {
        this.air = str;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void uN(int i) {
        this.jkI = i;
    }

    @Override // com.baidu.tieba.card.z
    public void pt(boolean z) {
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return jkJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(bz bzVar) {
        TiebaStatic.log(new aq("c12126").dW("tid", bzVar.getId()).an("obj_locate", cAV() ? 2 : 1).w("obj_id", bzVar.bnQ() == null ? -1L : bzVar.bnQ().live_id).an("obj_type", 1));
    }
}
