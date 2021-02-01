package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.h.f;
/* loaded from: classes2.dex */
public class a extends com.baidu.card.a<bt> {
    private ConcernRecommendLayout kcr;
    private int mSkinType;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.kcr = new ConcernRecommendLayout(tbPageContext.getPageActivity());
        this.kcr.setPageContext(tbPageContext);
        this.kcr.setPageUniqueId(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.kcr;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.kcr.onChangeSkinType(tbPageContext, i);
            g(this.kcr, 3);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.card.a
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.kcr.setPageUniqueId(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void C(bt btVar) {
        this.kcr.setData(btVar);
    }

    public void setOnItemCoverListener(f<MetaData> fVar) {
        this.kcr.setOnItemCoverListener(fVar);
    }

    public void setHasBorder(boolean z) {
        this.kcr.setHasBorder(z);
    }
}
