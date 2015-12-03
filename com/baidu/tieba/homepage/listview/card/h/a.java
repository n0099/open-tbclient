package com.baidu.tieba.homepage.listview.card.h;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.listview.card.h.b;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.homepage.listview.a<b, e> {
    protected TbPageContext<?> pageContext;

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.pageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: M */
    public e a(ViewGroup viewGroup) {
        return new e(com.baidu.tieba.homepage.fragment.a.b.h(this.mContext, com.baidu.tieba.homepage.fragment.a.b.a(this.mContext, b.a.class)), this.pageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, b bVar, e eVar) {
        if (eVar == null || eVar.TY() == null) {
            return null;
        }
        eVar.byI.setVisibility(0);
        if (this.aRB) {
            eVar.c(bVar);
            this.aRB = false;
        }
        eVar.cZ(TbadkCoreApplication.m411getInst().getSkinType());
        return eVar.getView();
    }
}
