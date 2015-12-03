package com.baidu.tieba.homepage.listview.card.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.homepage.listview.a<b, c> {
    private TbPageContext<?> mContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: J */
    public c a(ViewGroup viewGroup) {
        return new c(this.mContext, com.baidu.tieba.homepage.fragment.a.b.h(this.mContext.getPageActivity(), com.baidu.tieba.homepage.fragment.a.b.a(this.mContext.getPageActivity(), b.class)));
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
