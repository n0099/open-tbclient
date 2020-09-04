package com.baidu.tieba.homepage.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.tabfeed.view.HotTopicRankLayout;
/* loaded from: classes16.dex */
public class j extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.tabfeed.data.b, com.baidu.adp.widget.ListView.b<HotTopicRankLayout>> {
    private v akK;
    private TbPageContext mPageContext;

    public j(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.homepage.hotTopic.tab.b.a.iLP);
        this.mPageContext = tbPageContext;
    }

    public void a(v vVar) {
        this.akK = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bC */
    public com.baidu.adp.widget.ListView.b<HotTopicRankLayout> b(ViewGroup viewGroup) {
        return new com.baidu.adp.widget.ListView.b<>(new HotTopicRankLayout(viewGroup.getContext()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.tabfeed.data.b bVar, com.baidu.adp.widget.ListView.b<HotTopicRankLayout> bVar2) {
        if (bVar == null || bVar2 == null) {
            return null;
        }
        HotTopicRankLayout qK = bVar2.qK();
        qK.F(bVar);
        qK.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return bVar2.getView();
    }
}
