package com.baidu.tieba.faceshop.forumpackage.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionItemView;
/* loaded from: classes8.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.faceshop.forumpackage.data.c, ForumEmotionViewHolder> {
    private a jbP;
    private com.baidu.tieba.faceshop.forumpackage.data.b jbS;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, com.baidu.tieba.faceshop.forumpackage.data.b bVar, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
        this.jbS = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bi */
    public ForumEmotionViewHolder e(ViewGroup viewGroup) {
        ForumEmotionItemView forumEmotionItemView = new ForumEmotionItemView(this.mPageContext);
        ForumEmotionViewHolder forumEmotionViewHolder = new ForumEmotionViewHolder(this.mPageContext, forumEmotionItemView);
        forumEmotionItemView.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        return forumEmotionViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.faceshop.forumpackage.data.c cVar, ForumEmotionViewHolder forumEmotionViewHolder) {
        forumEmotionViewHolder.a(cVar, this.jbS, this.jbP, i);
        return forumEmotionViewHolder.getView();
    }

    public void a(a aVar) {
        this.jbP = aVar;
    }
}
