package com.baidu.tieba.homepage.listview.card.g;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.homepage.listview.a<b, f> {
    protected TbPageContext<?> pageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.pageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: L */
    public f a(ViewGroup viewGroup) {
        f fVar = new f(this.pageContext, com.baidu.tieba.homepage.fragment.a.b.h(this.mContext, com.baidu.tieba.homepage.fragment.a.b.a(this.mContext, b.class)));
        fVar.byI.setVisibility(8);
        return fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, b bVar, f fVar) {
        if (fVar == null || fVar.TY() == null) {
            return null;
        }
        if (this.aRB) {
            fVar.c(bVar);
            this.aRB = false;
        }
        fVar.cZ(TbadkCoreApplication.m411getInst().getSkinType());
        return fVar.getView();
    }
}
