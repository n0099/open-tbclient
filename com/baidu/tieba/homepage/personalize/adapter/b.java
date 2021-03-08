package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.f, ThreadCardViewHolder<com.baidu.tieba.homepage.personalize.data.f>> {
    private com.baidu.adp.widget.ListView.s anC;
    public BdUniqueId fIy;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder<com.baidu.tieba.homepage.personalize.data.f> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        aVar.c(new com.baidu.tieba.homepage.personalize.view.a(this.mPageContext, this.fIy));
        aVar.ti().bA(0);
        aVar.ti().bC(0);
        aVar.ti().bB(0);
        aVar.ti().by(0);
        ThreadCardViewHolder<com.baidu.tieba.homepage.personalize.data.f> threadCardViewHolder = new ThreadCardViewHolder<>(aVar.a(BaseCardInfo.SupportType.FULL, viewGroup, this.anC));
        threadCardViewHolder.setPageId(this.fIy);
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.f fVar, ThreadCardViewHolder<com.baidu.tieba.homepage.personalize.data.f> threadCardViewHolder) {
        if (fVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
            return null;
        }
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.homepage.personalize.data.f>) fVar);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.card.t.csH().e(fVar.cRR());
        com.baidu.tieba.a.d.bKY().e(fVar.cRR());
        return threadCardViewHolder.getView();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fIy = bdUniqueId;
    }
}
