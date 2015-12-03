package com.baidu.tieba.homepage.listview.card.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.homepage.listview.a<b, c> {
    private TbPageContext<?> pageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.pageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: G */
    public c a(ViewGroup viewGroup) {
        return new c(com.baidu.tieba.homepage.fragment.a.b.h(this.pageContext.getPageActivity(), com.baidu.tieba.homepage.fragment.a.b.a(this.pageContext.getPageActivity(), b.class)), this.pageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, b bVar, c cVar) {
        if (bVar == null) {
            return null;
        }
        if (this.aRB) {
            cVar.c(bVar);
            this.aRB = false;
        }
        cVar.cZ(TbadkCoreApplication.m411getInst().getSkinType());
        return cVar.getView();
    }
}
