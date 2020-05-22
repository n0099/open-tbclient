package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class g extends com.baidu.card.b<AbsThreadDataSupport> {
    private com.baidu.tieba.homepage.topic.topictab.view.a ifU;

    public g(Context context, TbPageContext<?> tbPageContext) {
        super(context);
        this.ifU = new com.baidu.tieba.homepage.topic.topictab.view.a(tbPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.ifU.cgU();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport instanceof com.baidu.tieba.homepage.topic.topictab.b.a) {
            this.ifU.a((com.baidu.tieba.homepage.topic.topictab.b.a) absThreadDataSupport);
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        this.ifU.onChangeSkinType(tbPageContext, i);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.ifU.setTag(bdUniqueId);
    }
}
