package com.baidu.tieba.homepage.topic.topicdetail.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.topic.topicdetail.view.e;
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.topic.topicdetail.b.d, com.baidu.tieba.card.a.a<e>> {
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.homepage.topic.topicdetail.b.d.igx);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aG */
    public com.baidu.tieba.card.a.a<e> b(ViewGroup viewGroup) {
        e eVar = new e(this.mPageContext);
        eVar.setTag(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.topic.topicdetail.b.d dVar, com.baidu.tieba.card.a.a<e> aVar) {
        if (dVar == null || aVar == null || aVar.bLU() == null) {
            return null;
        }
        aVar.bLU().a(dVar);
        aVar.bLU().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }
}
