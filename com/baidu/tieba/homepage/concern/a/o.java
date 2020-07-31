package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class o extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.a, ak<com.baidu.tieba.homepage.concern.b.a>> {
    private TbPageContext<?> mPageContext;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public ak<com.baidu.tieba.homepage.concern.b.a> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        aVar.c(new com.baidu.tieba.homepage.concern.view.a(this.mPageContext));
        aVar.se().bq(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44));
        aVar.se().bs(0);
        aVar.se().br(0);
        aVar.se().bm(0);
        return new ak<>(aVar.sf());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.a aVar, ak<com.baidu.tieba.homepage.concern.b.a> akVar) {
        akVar.b((ak<com.baidu.tieba.homepage.concern.b.a>) aVar);
        return akVar.getView();
    }
}
