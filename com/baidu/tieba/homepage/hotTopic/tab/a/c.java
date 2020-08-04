package com.baidu.tieba.homepage.hotTopic.tab.a;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout;
/* loaded from: classes16.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.hotTopic.tab.b.c, a> {
    private com.baidu.tbadk.h.f<com.baidu.tieba.homepage.hotTopic.tab.b.b> iwT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.homepage.hotTopic.tab.b.a.ixb);
        this.iwT = new com.baidu.tbadk.h.f<com.baidu.tieba.homepage.hotTopic.tab.b.b>() { // from class: com.baidu.tieba.homepage.hotTopic.tab.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, com.baidu.tieba.homepage.hotTopic.tab.b.b bVar, int i, long j) {
                if (bVar != null) {
                    if (bVar.ixd) {
                        com.baidu.tieba.homepage.hotTopic.tab.a.b("c13736", bVar, i + 1);
                    } else {
                        com.baidu.tieba.homepage.hotTopic.tab.a.b("c13735", bVar, i + 1);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void b(View view, com.baidu.tieba.homepage.hotTopic.tab.b.b bVar, int i, long j) {
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bC */
    public a b(ViewGroup viewGroup) {
        HotTopicTabRankListLayout hotTopicTabRankListLayout = new HotTopicTabRankListLayout(viewGroup.getContext());
        hotTopicTabRankListLayout.setOnItemCoverListener(this.iwT);
        hotTopicTabRankListLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        hotTopicTabRankListLayout.setPadding(l.getDimens(viewGroup.getContext(), R.dimen.tbds22), 0, l.getDimens(viewGroup.getContext(), R.dimen.tbds22), 0);
        a aVar = new a(hotTopicTabRankListLayout);
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.hotTopic.tab.b.c cVar, a aVar) {
        if (cVar == null || aVar == null) {
            return null;
        }
        aVar.a(cVar);
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class a extends ad.a {
        private int iwV;
        private HotTopicTabRankListLayout iwW;

        a(HotTopicTabRankListLayout hotTopicTabRankListLayout) {
            super(hotTopicTabRankListLayout);
            this.iwV = 3;
            this.iwW = hotTopicTabRankListLayout;
        }

        void a(com.baidu.tieba.homepage.hotTopic.tab.b.c cVar) {
            if (cVar != null) {
                this.iwW.a(cVar);
            }
        }

        void onChangeSkinType(int i) {
            if (this.iwV != i) {
                this.iwW.onChangeSkinType(i);
                this.iwV = i;
            }
        }
    }
}
