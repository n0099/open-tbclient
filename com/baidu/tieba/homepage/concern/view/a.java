package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.h.f;
/* loaded from: classes21.dex */
public class a extends com.baidu.card.b<bp> {
    private ConcernRecommendLayout jyD;
    private int mSkinType;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.jyD = new ConcernRecommendLayout(tbPageContext.getPageActivity());
        this.jyD.setPageContext(tbPageContext);
        this.jyD.setPageUniqueId(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.jyD;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.jyD.onChangeSkinType(tbPageContext, i);
            e(this.jyD, 3);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.jyD.setPageUniqueId(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void H(bp bpVar) {
        this.jyD.setData(bpVar);
    }

    public void setOnItemCoverListener(f<MetaData> fVar) {
        this.jyD.setOnItemCoverListener(fVar);
    }

    public void setHasBorder(boolean z) {
        this.jyD.setHasBorder(z);
    }
}
