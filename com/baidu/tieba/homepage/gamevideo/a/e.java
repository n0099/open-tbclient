package com.baidu.tieba.homepage.gamevideo.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.s;
import com.baidu.adp.widget.ListView.w;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.k;
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.widget.ListView.a<k, ThreadCardViewHolder<k>> {
    private aa<k> ago;
    private s amu;
    private BdUniqueId fEN;
    private int fce;
    private NEGFeedBackView.a gbz;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, k kVar, ThreadCardViewHolder<k> threadCardViewHolder) {
        return a2(i, view, viewGroup, kVar, (ThreadCardViewHolder) threadCardViewHolder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ago = new aa<k>() { // from class: com.baidu.tieba.homepage.gamevideo.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, k kVar) {
                int id = view.getId();
                if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                    com.baidu.tieba.homepage.gamevideo.e.a.c(kVar, e.this.fce);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(s sVar) {
        this.amu = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder<k> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eJO = 15;
        dVar.eJU = 11;
        amVar.setAgreeStatisticData(dVar);
        amVar.setFrom(12);
        amVar.setShareReportFrom(9);
        amVar.setGameId(this.fce);
        amVar.setFromForPb(18);
        amVar.bq(32);
        aVar.b(amVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.amu);
        a2.setSourceForPb(18);
        ThreadCardViewHolder<k> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.fEN);
        a(new w() { // from class: com.baidu.tieba.homepage.gamevideo.a.e.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    k kVar = (k) nVar;
                    kVar.objType = 1;
                    if (e.this.ago != null) {
                        e.this.ago.a(threadCardViewHolder2.getView(), kVar);
                    }
                    com.baidu.tieba.homepage.gamevideo.e.a.a(kVar, view.getContext(), 18, false, com.baidu.card.e.a((s) viewGroup2, view, i));
                    threadCardViewHolder2.tm().b(new a.C0089a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(final int i, final View view, final ViewGroup viewGroup, k kVar, ThreadCardViewHolder threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.eHK == null) {
            return null;
        }
        kVar.wT(kVar.position + 1);
        threadCardViewHolder.tm().setPosition(i);
        if (threadCardViewHolder.tm().tg() instanceof am) {
            ((am) threadCardViewHolder.tm().tg()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.homepage.gamevideo.a.e.3
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.e.a((s) viewGroup, view, i));
                    }
                }
            });
        }
        threadCardViewHolder.aK(false).a(this.gbz);
        threadCardViewHolder.b((ThreadCardViewHolder) kVar);
        threadCardViewHolder.tm().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tm().a(this.ago);
        return threadCardViewHolder.getView();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fEN = bdUniqueId;
    }

    public void By(int i) {
        this.fce = i;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.gbz = aVar;
    }
}
