package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class g extends com.baidu.card.b<AbsThreadDataSupport> {
    private com.baidu.tieba.homepage.topic.topictab.view.a joP;

    public g(Context context, TbPageContext<?> tbPageContext) {
        super(context);
        this.joP = new com.baidu.tieba.homepage.topic.topictab.view.a(tbPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.joP.cGA();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport instanceof com.baidu.tieba.homepage.topic.topictab.b.a) {
            this.joP.a((com.baidu.tieba.homepage.topic.topictab.b.a) absThreadDataSupport);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        this.joP.onChangeSkinType(tbPageContext, i);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.joP.setTag(bdUniqueId);
    }
}
