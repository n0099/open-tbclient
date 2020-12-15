package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes22.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.f.e, com.baidu.tieba.card.a.a<com.baidu.tieba.card.h>> {
    private com.baidu.tieba.card.h jlR;
    private String mForumId;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.f.e.iqD);
        this.mPageContext = tbPageContext;
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.h> c(ViewGroup viewGroup) {
        this.jlR = new com.baidu.tieba.card.h(this.mPageContext);
        this.jlR.setForumId(this.mForumId);
        return new com.baidu.tieba.card.a.a<>(this.jlR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.f.e eVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.h> aVar) {
        if (aVar.csN() == null) {
            return null;
        }
        aVar.csN().a(eVar);
        aVar.csN().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return aVar.csN().getView();
    }
}
