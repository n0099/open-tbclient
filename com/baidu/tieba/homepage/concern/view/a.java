package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.h.f;
/* loaded from: classes22.dex */
public class a extends com.baidu.card.b<bq> {
    private ConcernRecommendLayout jMf;
    private int mSkinType;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.jMf = new ConcernRecommendLayout(tbPageContext.getPageActivity());
        this.jMf.setPageContext(tbPageContext);
        this.jMf.setPageUniqueId(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.jMf;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.jMf.onChangeSkinType(tbPageContext, i);
            e(this.jMf, 3);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.jMf.setPageUniqueId(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void H(bq bqVar) {
        this.jMf.setData(bqVar);
    }

    public void setOnItemCoverListener(f<MetaData> fVar) {
        this.jMf.setOnItemCoverListener(fVar);
    }

    public void setHasBorder(boolean z) {
        this.jMf.setHasBorder(z);
    }
}
