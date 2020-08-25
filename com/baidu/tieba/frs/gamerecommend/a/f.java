package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes16.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.e.e, com.baidu.tieba.card.a.a<com.baidu.tieba.card.h>> {
    private com.baidu.tieba.card.h ijk;
    private String mForumId;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.e.e.hqo);
        this.mPageContext = tbPageContext;
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.h> b(ViewGroup viewGroup) {
        this.ijk = new com.baidu.tieba.card.h(this.mPageContext);
        this.ijk.setForumId(this.mForumId);
        return new com.baidu.tieba.card.a.a<>(this.ijk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.e eVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.h> aVar) {
        if (aVar.ccE() == null) {
            return null;
        }
        aVar.ccE().a(eVar);
        aVar.ccE().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return aVar.ccE().getView();
    }
}
