package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes22.dex */
public class e extends com.baidu.card.b<com.baidu.tbadk.core.data.a> {
    private com.baidu.tieba.homepage.topic.topictab.view.a jVA;
    private int mSkinType;

    public e(Context context, TbPageContext<?> tbPageContext) {
        super(context);
        this.mSkinType = 3;
        this.jVA = new com.baidu.tieba.homepage.topic.topictab.view.a(tbPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.jVA.cRd();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        if (aVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) {
            this.jVA.a((com.baidu.tieba.homepage.topic.topictab.b.a) aVar);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.jVA.onChangeSkinType(tbPageContext, i);
            e(getView(), 3);
        }
        this.mSkinType = i;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.jVA.setTag(bdUniqueId);
    }
}
