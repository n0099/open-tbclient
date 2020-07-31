package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class d extends com.baidu.card.b<AbsThreadDataSupport> {
    private e iBR;

    public d(Context context, TbPageContext<?> tbPageContext) {
        super(context);
        this.iBR = new e(tbPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.iBR.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport instanceof com.baidu.tieba.homepage.personalize.data.g) {
            this.iBR.a((com.baidu.tieba.homepage.personalize.data.g) absThreadDataSupport);
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ao.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        this.iBR.onChangeSkinType(tbPageContext, i);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.iBR.setTag(bdUniqueId);
    }
}
