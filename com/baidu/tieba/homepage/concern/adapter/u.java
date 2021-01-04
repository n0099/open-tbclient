package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class u extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ThreadCardViewHolder<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.k> ahf;
    private String aji;
    private com.baidu.adp.widget.ListView.s anl;
    public BdUniqueId fJu;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ThreadCardViewHolder<com.baidu.tieba.card.data.k> threadCardViewHolder) {
        return a2(i, view, viewGroup, kVar, (ThreadCardViewHolder) threadCardViewHolder);
    }

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ahf = new aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.adapter.u.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && kVar != null && kVar.boO() != null && !StringUtils.isNull(kVar.boO().getTid())) {
                    u.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.anl = sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        if (view.getId() == R.id.thread_card_root || view.getId() == R.id.thread_info_commont_container) {
            com.baidu.tieba.homepage.concern.c.a(view, kVar, 2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eOz = 9;
        dVar.eOF = 9;
        amVar.setAgreeStatisticData(dVar);
        amVar.setFrom(4);
        amVar.setStType("personalize_page");
        amVar.setShareReportFrom(4);
        amVar.setFromForPb(1);
        amVar.bs(32);
        aVar.b(amVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.anl);
        a2.setSourceForPb(1);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(a2);
        threadCardViewHolder.setPageId(this.fJu);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.concern.adapter.u.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) nVar;
                    kVar.objType = 1;
                    if (u.this.ahf != null) {
                        u.this.ahf.a(threadCardViewHolder2.getView(), kVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 1, false, com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup2, view, i));
                    threadCardViewHolder2.ty().b(new a.C0090a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(final int i, final View view, final ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ThreadCardViewHolder threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.eMv == null) {
            return null;
        }
        kVar.yA(kVar.position + 1);
        threadCardViewHolder.ty().setPosition(i);
        if (threadCardViewHolder.ty().ts() instanceof am) {
            ((am) threadCardViewHolder.ty().ts()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.homepage.concern.adapter.u.3
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup, view, i));
                    }
                }
            });
        }
        if (threadCardViewHolder.ty() instanceof com.baidu.tieba.a.e) {
            threadCardViewHolder.ty().setPage(this.aji);
        }
        threadCardViewHolder.a(false, Align.ALIGN_RIGHT_BOTTOM);
        threadCardViewHolder.b((ThreadCardViewHolder) kVar);
        threadCardViewHolder.ty().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.ty().a(this.ahf);
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Fm(String str) {
        this.aji = str;
    }
}
