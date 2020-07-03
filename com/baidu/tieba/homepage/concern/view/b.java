package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.h.f;
/* loaded from: classes9.dex */
public class b extends com.baidu.card.b<bm> {
    private ConcernRecommendLayout inG;
    private int mSkinType;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.inG = new ConcernRecommendLayout(tbPageContext.getPageActivity());
        this.inG.setPageContext(tbPageContext);
        this.inG.setPageUniqueId(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.inG;
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.inG.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.inG.setPageUniqueId(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: a */
    public void D(bm bmVar) {
        this.inG.setData(bmVar);
    }

    public void setOnItemCoverListener(f<MetaData> fVar) {
        this.inG.setOnItemCoverListener(fVar);
    }
}
