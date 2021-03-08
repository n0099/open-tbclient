package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class z extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.a.c, ThreadCardViewHolder<com.baidu.tieba.homepage.concern.a.c>> implements com.baidu.tieba.a.f {
    private String ajx;
    private com.baidu.adp.widget.ListView.s anC;
    public BdUniqueId fIy;
    private byte kdJ;
    private TbPageContext<?> mPageContext;

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, byte b) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
        this.kdJ = b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder<com.baidu.tieba.homepage.concern.a.c> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        aVar.c(new com.baidu.tieba.homepage.concern.view.b(this.mPageContext, this.fIy, this.kdJ));
        aVar.ti().bA(0);
        aVar.ti().bC(0);
        aVar.ti().bB(0);
        aVar.ti().by(0);
        ThreadCardViewHolder<com.baidu.tieba.homepage.concern.a.c> threadCardViewHolder = new ThreadCardViewHolder<>(aVar.a(BaseCardInfo.SupportType.FULL, viewGroup, this.anC));
        threadCardViewHolder.setPageId(this.fIy);
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.a.c cVar, ThreadCardViewHolder<com.baidu.tieba.homepage.concern.a.c> threadCardViewHolder) {
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.homepage.concern.a.c>) cVar);
        if (threadCardViewHolder.tj() != null) {
            threadCardViewHolder.tj().setPosition(i);
            threadCardViewHolder.tj().setPage(this.ajx);
            threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void ED(String str) {
        this.ajx = str;
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.anC = sVar;
    }
}
