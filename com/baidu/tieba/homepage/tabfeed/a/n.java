package com.baidu.tieba.homepage.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnListData;
import com.baidu.tieba.homepage.tabfeed.view.SpecialTopicLayout;
/* loaded from: classes21.dex */
public class n extends com.baidu.adp.widget.ListView.a<SpecialColumnListData, com.baidu.adp.widget.ListView.b<SpecialTopicLayout>> {
    private v alj;
    private TbPageContext mPageContext;

    public n(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), SpecialColumnListData.TYPE);
        this.mPageContext = tbPageContext;
    }

    public void a(v vVar) {
        this.alj = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bD */
    public com.baidu.adp.widget.ListView.b<SpecialTopicLayout> c(ViewGroup viewGroup) {
        SpecialTopicLayout specialTopicLayout = new SpecialTopicLayout(this.mPageContext);
        specialTopicLayout.setShowMore(true);
        return new com.baidu.adp.widget.ListView.b<>(specialTopicLayout);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, SpecialColumnListData specialColumnListData, com.baidu.adp.widget.ListView.b<SpecialTopicLayout> bVar) {
        bVar.qP().G(specialColumnListData);
        return bVar.getView();
    }
}
