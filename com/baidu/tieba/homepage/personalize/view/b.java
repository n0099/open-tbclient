package com.baidu.tieba.homepage.personalize.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes9.dex */
public class b extends com.baidu.card.b<com.baidu.tbadk.core.data.a> {
    private HomePageAlaRecommendLayout hhm;
    private int mSkinType;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.hhm = new HomePageAlaRecommendLayout(tbPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.hhm;
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.hhm.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.hhm.setData((com.baidu.tieba.homepage.personalize.data.f) aVar);
    }
}
