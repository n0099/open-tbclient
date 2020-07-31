package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.h.f;
/* loaded from: classes16.dex */
public class b extends com.baidu.card.b<bn> {
    private ConcernRecommendLayout itI;
    private int mSkinType;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.itI = new ConcernRecommendLayout(tbPageContext.getPageActivity());
        this.itI.setPageContext(tbPageContext);
        this.itI.setPageUniqueId(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.itI;
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.itI.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.itI.setPageUniqueId(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: a */
    public void D(bn bnVar) {
        this.itI.setData(bnVar);
    }

    public void setOnItemCoverListener(f<MetaData> fVar) {
        this.itI.setOnItemCoverListener(fVar);
    }

    public void setHasBorder(boolean z) {
        this.itI.setHasBorder(z);
    }
}
