package com.baidu.tieba.homepage.hotTopic.tab.a;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItem;
/* loaded from: classes22.dex */
public class j extends com.baidu.tieba.homepage.hotTopic.tab.a.a<com.baidu.tieba.homepage.hotTopic.tab.b.e, a> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public j(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.homepage.hotTopic.tab.b.a.jvR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bE */
    public a c(ViewGroup viewGroup) {
        HotTopicTabThreadItem hotTopicTabThreadItem = new HotTopicTabThreadItem(viewGroup.getContext());
        hotTopicTabThreadItem.setOnItemCoverListener(this.aiM);
        hotTopicTabThreadItem.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        a aVar = new a(hotTopicTabThreadItem);
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.homepage.hotTopic.tab.a.a, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.hotTopic.tab.b.e eVar, a aVar) {
        if (eVar == null || aVar == null) {
            return null;
        }
        aVar.a(eVar);
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public static class a extends af.a {
        private HotTopicTabThreadItem jvM;

        a(HotTopicTabThreadItem hotTopicTabThreadItem) {
            super(hotTopicTabThreadItem);
            this.jvM = hotTopicTabThreadItem;
        }

        void a(com.baidu.tieba.homepage.hotTopic.tab.b.e eVar) {
            if (eVar != null) {
                this.jvM.a(eVar);
            }
        }

        void onChangeSkinType(int i) {
            this.jvM.onChangeSkinType(i);
        }
    }
}
