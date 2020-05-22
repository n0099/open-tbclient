package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ae;
import com.baidu.card.ag;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class m extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.a, ag<com.baidu.tieba.homepage.concern.b.a>> {
    private TbPageContext<?> mPageContext;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public ag<com.baidu.tieba.homepage.concern.b.a> b(ViewGroup viewGroup) {
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity(), false);
        aVar.c(new com.baidu.tieba.homepage.concern.view.a(this.mPageContext));
        aVar.rK().bi(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44));
        aVar.rK().bk(0);
        aVar.rK().bj(0);
        aVar.rK().be(0);
        return new ag<>(aVar.rL());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.a aVar, ag<com.baidu.tieba.homepage.concern.b.a> agVar) {
        agVar.b((ag<com.baidu.tieba.homepage.concern.b.a>) aVar);
        return agVar.getView();
    }
}
