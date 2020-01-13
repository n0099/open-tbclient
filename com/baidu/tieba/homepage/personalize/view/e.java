package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class e extends com.baidu.card.b<com.baidu.tbadk.core.data.a> {
    private com.baidu.tieba.homepage.topic.topictab.view.a hdG;

    public e(Context context, TbPageContext<?> tbPageContext) {
        super(context);
        this.hdG = new com.baidu.tieba.homepage.topic.topictab.view.a(tbPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.hdG.bNZ();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        if (aVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) {
            this.hdG.a((com.baidu.tieba.homepage.topic.topictab.b.a) aVar);
        }
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        this.hdG.onChangeSkinType(tbPageContext, i);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.hdG.setTag(bdUniqueId);
    }
}
