package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.aj;
import com.baidu.card.al;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class o extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.a, al<com.baidu.tieba.homepage.concern.b.a>> {
    private TbPageContext<?> mPageContext;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public al<com.baidu.tieba.homepage.concern.b.a> b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity(), false);
        aVar.c(new com.baidu.tieba.homepage.concern.view.a(this.mPageContext));
        aVar.tP().bv(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44));
        aVar.tP().bx(0);
        aVar.tP().bw(0);
        aVar.tP().br(0);
        return new al<>(aVar.tQ());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.a aVar, al<com.baidu.tieba.homepage.concern.b.a> alVar) {
        alVar.b((al<com.baidu.tieba.homepage.concern.b.a>) aVar);
        return alVar.getView();
    }
}
