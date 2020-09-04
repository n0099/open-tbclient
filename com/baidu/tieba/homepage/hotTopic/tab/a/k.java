package com.baidu.tieba.homepage.hotTopic.tab.a;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItemView;
/* loaded from: classes16.dex */
public class k extends a<com.baidu.tieba.homepage.hotTopic.tab.b.f, com.baidu.adp.widget.ListView.b<HotTopicTabThreadItemView>> {
    public k(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.homepage.hotTopic.tab.b.a.iLR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bC */
    public com.baidu.adp.widget.ListView.b<HotTopicTabThreadItemView> b(ViewGroup viewGroup) {
        HotTopicTabThreadItemView hotTopicTabThreadItemView = new HotTopicTabThreadItemView(viewGroup.getContext());
        hotTopicTabThreadItemView.setOnItemCoverListener(this.ahY);
        hotTopicTabThreadItemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        return new com.baidu.adp.widget.ListView.b<>(hotTopicTabThreadItemView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.homepage.hotTopic.tab.a.a, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.hotTopic.tab.b.f fVar, com.baidu.adp.widget.ListView.b<HotTopicTabThreadItemView> bVar) {
        bVar.qK().a(fVar);
        return bVar.getView();
    }
}
