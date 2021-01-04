package com.baidu.tieba.homepage.hotTopic.tab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class c extends a<by, ThreadCardViewHolder<bz>> {
    private aa<bz> ahf;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext, bz.eSV);
        this.ahf = new aa<bz>() { // from class: com.baidu.tieba.homepage.hotTopic.tab.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bz bzVar) {
                c.this.f(view, bzVar);
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        v vVar = new v(this.mPageContext.getPageActivity());
        vVar.setFrom("hot_topic");
        vVar.setFromCDN(this.mIsFromCDN);
        aVar.c(vVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.anl);
        a2.setSourceForPb(2);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(a2);
        threadCardViewHolder.setPageId(this.mPageId);
        a(new w() { // from class: com.baidu.tieba.homepage.hotTopic.tab.a.c.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof by) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    bz bzVar = ((by) nVar).eMv;
                    bzVar.objType = 1;
                    if (c.this.ahf != null) {
                        c.this.ahf.a(threadCardViewHolder2.getView(), bzVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) bzVar, view.getContext(), 0, false);
                    threadCardViewHolder2.ty().b(new a.C0090a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.homepage.hotTopic.tab.a.a, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, by byVar, ThreadCardViewHolder<bz> threadCardViewHolder) {
        if (byVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || byVar.eMv == null) {
            return null;
        }
        byVar.eMv.eQR = getPositionByType(i) + 1;
        threadCardViewHolder.ty().setPosition(i);
        threadCardViewHolder.b((ThreadCardViewHolder<bz>) byVar.eMv);
        threadCardViewHolder.ty().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.ty().a(this.ahf);
        a(threadCardViewHolder.getView(), byVar.eMv, i, i);
        return threadCardViewHolder.getView();
    }
}
