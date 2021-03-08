package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class j extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, ThreadCardViewHolder<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.l> ahy;
    private String ajx;
    private com.baidu.adp.widget.ListView.s anC;
    public BdUniqueId fIy;
    private BdUniqueId kdb;
    private com.baidu.card.i kdc;
    private TbPageContext<?> mPageContext;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ahy = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.concern.adapter.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                BdToast.b(j.this.mPageContext.getContext(), j.this.mPageContext.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).bqF();
            }
        };
        this.mPageContext = tbPageContext;
        this.kdb = bdUniqueId2;
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.anC = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public AutoVideoCardViewHolder<com.baidu.tieba.card.data.l> e(ViewGroup viewGroup) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, ThreadCardViewHolder<com.baidu.tieba.card.data.l> threadCardViewHolder) {
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId ql() {
        return this.kdb != null ? this.kdb : com.baidu.tieba.card.data.b.iBN;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qm() {
        return com.baidu.tieba.card.data.b.iBU;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qn() {
        return com.baidu.tieba.card.data.b.iBV;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qo() {
        return com.baidu.tieba.card.data.b.iBW;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public ThreadCardViewHolder<com.baidu.tieba.card.data.l> c(ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        this.kdc = new com.baidu.card.i(this.mPageContext.getPageActivity());
        this.kdc.setPageUniqueId(this.fIy);
        aVar.c(this.kdc);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.anC);
        ThreadCardViewHolder<com.baidu.tieba.card.data.l> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.fIy);
        a2.a(this.ahy);
        a2.setSourceForPb(1);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.concern.adapter.j.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                BdToast.b(j.this.mPageContext.getContext(), j.this.mPageContext.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).bqF();
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: b */
    public View c(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, ThreadCardViewHolder<com.baidu.tieba.card.data.l> threadCardViewHolder) {
        if (lVar == null) {
            return threadCardViewHolder.getView();
        }
        if (threadCardViewHolder == null) {
            return null;
        }
        lVar.xe(lVar.position + 1);
        com.baidu.tieba.card.t.csH().e(lVar.Jc("c12351"));
        threadCardViewHolder.tj().setPosition(i);
        lVar.sourceType = 0;
        if (threadCardViewHolder.tj() instanceof com.baidu.tieba.a.e) {
            threadCardViewHolder.tj().setPage(this.ajx);
        }
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.card.data.l>) lVar);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tj().a(this.ahy);
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void ED(String str) {
        this.ajx = str;
    }
}
