package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class d extends com.baidu.card.a<com.baidu.tbadk.core.data.a> {
    private com.baidu.tieba.homepage.topic.topictab.view.a kmE;
    private int mSkinType;

    public d(Context context, TbPageContext<?> tbPageContext) {
        super(context);
        this.mSkinType = 3;
        this.kmE = new com.baidu.tieba.homepage.topic.topictab.view.a(tbPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.kmE.cSz();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        if (aVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) {
            this.kmE.a((com.baidu.tieba.homepage.topic.topictab.b.a) aVar);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.kmE.onChangeSkinType(tbPageContext, i);
            g(getView(), 3);
        }
        this.mSkinType = i;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.kmE.setTag(bdUniqueId);
    }
}
