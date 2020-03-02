package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes9.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.e.e, com.baidu.tieba.card.a.a<com.baidu.tieba.card.g>> {
    private com.baidu.tieba.card.g gBH;
    private String mForumId;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.e.e.fQm);
        this.mPageContext = tbPageContext;
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: av */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.g> b(ViewGroup viewGroup) {
        this.gBH = new com.baidu.tieba.card.g(this.mPageContext);
        this.gBH.setForumId(this.mForumId);
        return new com.baidu.tieba.card.a.a<>(this.gBH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.e eVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.g> aVar) {
        if (aVar.bvK() == null) {
            return null;
        }
        aVar.bvK().a(eVar);
        aVar.bvK().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return aVar.bvK().getView();
    }
}
