package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends com.baidu.card.b<com.baidu.tbadk.core.data.a> {
    private com.baidu.tieba.homepage.topic.topictab.view.a gmC;

    public e(Context context, TbPageContext<?> tbPageContext) {
        super(context);
        this.gmC = new com.baidu.tieba.homepage.topic.topictab.view.a(tbPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.gmC.bvD();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(com.baidu.tbadk.core.data.a aVar) {
        if (aVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) {
            this.gmC.a((com.baidu.tieba.homepage.topic.topictab.b.a) aVar);
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        this.gmC.onChangeSkinType(tbPageContext, i);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.gmC.setTag(bdUniqueId);
    }
}
