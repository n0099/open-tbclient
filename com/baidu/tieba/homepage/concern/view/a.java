package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.h.f;
/* loaded from: classes2.dex */
public class a extends com.baidu.card.a<bt> {
    private ConcernRecommendLayout keI;
    private int mSkinType;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.keI = new ConcernRecommendLayout(tbPageContext.getPageActivity());
        this.keI.setPageContext(tbPageContext);
        this.keI.setPageUniqueId(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.keI;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.keI.onChangeSkinType(tbPageContext, i);
            g(this.keI, 3);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.card.a
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.keI.setPageUniqueId(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void E(bt btVar) {
        this.keI.setData(btVar);
    }

    public void setOnItemCoverListener(f<MetaData> fVar) {
        this.keI.setOnItemCoverListener(fVar);
    }

    public void setHasBorder(boolean z) {
        this.keI.setHasBorder(z);
    }
}
