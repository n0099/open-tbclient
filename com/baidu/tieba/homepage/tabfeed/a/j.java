package com.baidu.tieba.homepage.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.AdapterViewHolder;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.tabfeed.view.HotTopicRankLayout;
/* loaded from: classes2.dex */
public class j extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.tabfeed.data.b, AdapterViewHolder<HotTopicRankLayout>> {
    private s anC;
    private TbPageContext mPageContext;

    public j(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.homepage.hotTopic.tab.b.a.kiR);
        this.mPageContext = tbPageContext;
    }

    public void a(s sVar) {
        this.anC = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bX */
    public AdapterViewHolder<HotTopicRankLayout> e(ViewGroup viewGroup) {
        return new AdapterViewHolder<>(new HotTopicRankLayout(viewGroup.getContext()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.tabfeed.data.b bVar, AdapterViewHolder<HotTopicRankLayout> adapterViewHolder) {
        if (bVar == null || adapterViewHolder == null) {
            return null;
        }
        HotTopicRankLayout qr = adapterViewHolder.qr();
        qr.E(bVar);
        qr.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return adapterViewHolder.getView();
    }
}
