package com.baidu.tieba.homepage.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.AdapterViewHolder;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnListData;
import com.baidu.tieba.homepage.tabfeed.view.SpecialTopicLayout;
/* loaded from: classes2.dex */
public class n extends com.baidu.adp.widget.ListView.a<SpecialColumnListData, AdapterViewHolder<SpecialTopicLayout>> {
    private s anC;
    private TbPageContext mPageContext;

    public n(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), SpecialColumnListData.TYPE);
        this.mPageContext = tbPageContext;
    }

    public void a(s sVar) {
        this.anC = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bX */
    public AdapterViewHolder<SpecialTopicLayout> e(ViewGroup viewGroup) {
        SpecialTopicLayout specialTopicLayout = new SpecialTopicLayout(this.mPageContext);
        specialTopicLayout.setShowMore(true);
        return new AdapterViewHolder<>(specialTopicLayout);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, SpecialColumnListData specialColumnListData, AdapterViewHolder<SpecialTopicLayout> adapterViewHolder) {
        adapterViewHolder.qr().E(specialColumnListData);
        return adapterViewHolder.getView();
    }
}
