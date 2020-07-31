package com.baidu.tieba.homepage.hotTopic.tab.a;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItem;
/* loaded from: classes16.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.hotTopic.tab.b.e, a> {
    private com.baidu.tbadk.h.f<com.baidu.tieba.homepage.hotTopic.tab.b.e> iwR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.homepage.hotTopic.tab.b.a.ixa);
        this.iwR = new com.baidu.tbadk.h.f<com.baidu.tieba.homepage.hotTopic.tab.b.e>() { // from class: com.baidu.tieba.homepage.hotTopic.tab.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, com.baidu.tieba.homepage.hotTopic.tab.b.e eVar, int i, long j) {
                if (eVar != null) {
                    com.baidu.tieba.homepage.hotTopic.tab.a.b("c13738", eVar, i);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void b(View view, com.baidu.tieba.homepage.hotTopic.tab.b.e eVar, int i, long j) {
                if (eVar != null) {
                    com.baidu.tieba.homepage.hotTopic.tab.a.c("c13825", eVar, i);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bE */
    public a b(ViewGroup viewGroup) {
        HotTopicTabThreadItem hotTopicTabThreadItem = new HotTopicTabThreadItem(viewGroup.getContext());
        hotTopicTabThreadItem.setOnItemCoverListener(this.iwR);
        hotTopicTabThreadItem.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        a aVar = new a(hotTopicTabThreadItem);
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.hotTopic.tab.b.e eVar, a aVar) {
        if (eVar == null || aVar == null) {
            return null;
        }
        aVar.a(eVar);
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class a extends ad.a {
        private HotTopicTabThreadItem iwW;

        a(HotTopicTabThreadItem hotTopicTabThreadItem) {
            super(hotTopicTabThreadItem);
            this.iwW = hotTopicTabThreadItem;
        }

        void a(com.baidu.tieba.homepage.hotTopic.tab.b.e eVar) {
            if (eVar != null) {
                this.iwW.a(eVar);
            }
        }

        void onChangeSkinType(int i) {
            this.iwW.onChangeSkinType(i);
        }
    }
}
