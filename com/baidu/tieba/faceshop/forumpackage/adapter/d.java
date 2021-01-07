package com.baidu.tieba.faceshop.forumpackage.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionEmptyView;
/* loaded from: classes9.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.faceshop.forumpackage.data.a, ForumEmotionEmptyViewHolder> {
    private a iYS;
    private com.baidu.tieba.faceshop.forumpackage.data.b iYV;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, com.baidu.tieba.faceshop.forumpackage.data.b bVar, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
        this.iYV = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bj */
    public ForumEmotionEmptyViewHolder e(ViewGroup viewGroup) {
        ForumEmotionEmptyView forumEmotionEmptyView = new ForumEmotionEmptyView(this.mPageContext);
        forumEmotionEmptyView.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        return new ForumEmotionEmptyViewHolder(this.mPageContext, forumEmotionEmptyView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.faceshop.forumpackage.data.a aVar, ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder) {
        forumEmotionEmptyViewHolder.a(aVar, i, this.iYV, this.iYS);
        return forumEmotionEmptyViewHolder.getView();
    }

    public void a(a aVar) {
        this.iYS = aVar;
    }
}
