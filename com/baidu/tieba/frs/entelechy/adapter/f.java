package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class f extends com.baidu.tieba.frs.k<bz, ThreadCardViewHolder<bz>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.b.d {
    private String aji;
    private boolean alQ;
    private com.baidu.tieba.card.aa<bz> hnl;
    private boolean jpH;
    private boolean jpI;
    private int jpp;
    private com.baidu.tieba.frs.b.b jpq;
    private TbPageContext<?> mPageContext;

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.alQ = false;
        this.jpH = false;
        this.jpp = 3;
        this.jpq = new com.baidu.tieba.frs.b.b();
        this.hnl = new com.baidu.tieba.card.aa<bz>() { // from class: com.baidu.tieba.frs.entelechy.adapter.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bz bzVar) {
                if (view != null && bzVar != null) {
                    BdToast.b(f.this.mContext, f.this.mContext.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).bue();
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.bs(4272);
        dVar.setPageUniqueId(this.mPageId);
        aVar.a(dVar);
        com.baidu.card.i iVar = new com.baidu.card.i(this.mPageContext.getPageActivity());
        if (this.jpp == 502) {
            iVar.setNeedFrsTabName(false);
        } else {
            iVar.setNeedFrsTabName(true);
        }
        aVar.c(iVar);
        if (this.jpI) {
            aVar.a((com.baidu.card.h) new com.baidu.card.s(this.mPageContext.getPageActivity()));
        }
        aVar.a((com.baidu.card.h) new com.baidu.card.ag(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.aa(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.l(this.mPageContext.getPageActivity()));
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.alQ);
        nVar.setForm("frs");
        aVar.a((com.baidu.card.h) nVar);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.eOz = 2;
        dVar2.eOA = 2;
        dVar2.eOF = 2;
        amVar.setAgreeStatisticData(dVar2);
        amVar.setFrom(2);
        amVar.setShareReportFrom(1);
        amVar.setFromForPb(this.jpp);
        amVar.bs(Opcodes.ARETURN);
        if (this.jpH) {
            amVar.bt(4);
        }
        aVar.b(amVar);
        aVar.tx().bz(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ak tw = aVar.tw();
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(tw);
        threadCardViewHolder.setPageId(this.mPageId);
        tw.a(this.hnl);
        tw.setSourceForPb(this.jpp);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.f.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                BdToast.b(f.this.mContext, f.this.mContext.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).bue();
            }
        });
        threadCardViewHolder.tz();
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bz bzVar, ThreadCardViewHolder threadCardViewHolder) {
        if (threadCardViewHolder == null) {
            return null;
        }
        if (bzVar == null) {
            return threadCardViewHolder.getView();
        }
        if (threadCardViewHolder.ty() instanceof com.baidu.tieba.a.e) {
            threadCardViewHolder.ty().setPage(this.aji);
        }
        super.a(i, view, viewGroup, (ViewGroup) bzVar, (bz) threadCardViewHolder);
        com.baidu.tieba.frs.j.a(threadCardViewHolder.ty().ts(), this.jeH);
        if (this.jeH != null && this.jeH.getForum() != null && !StringUtils.isNull(this.jeH.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.jeH.getForum().getTopic_special_icon_right())) {
            bzVar.dK(this.jeH.getForum().getTopic_special_icon(), this.jeH.getForum().getTopic_special_icon_right());
        }
        if (!bzVar.isBjh()) {
            threadCardViewHolder.tA();
        }
        threadCardViewHolder.b((ThreadCardViewHolder) bzVar);
        threadCardViewHolder.ty().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.ty().a(this.hnl);
        bzVar.bsF();
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void wt(int i) {
        this.jpp = i;
    }

    @Override // com.baidu.tieba.a.f
    public void Fl(String str) {
        this.aji = str;
    }

    @Override // com.baidu.tieba.card.z
    public void px(boolean z) {
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.alQ = z;
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jpq;
    }

    public void qX(boolean z) {
        this.jpH = z;
    }

    public void qY(boolean z) {
        this.jpI = z;
    }
}
