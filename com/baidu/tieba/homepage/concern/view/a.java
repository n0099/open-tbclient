package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.h.f;
/* loaded from: classes2.dex */
public class a extends com.baidu.card.a<br> {
    private ConcernRecommendLayout jZv;
    private int mSkinType;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.jZv = new ConcernRecommendLayout(tbPageContext.getPageActivity());
        this.jZv.setPageContext(tbPageContext);
        this.jZv.setPageUniqueId(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.jZv;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.jZv.onChangeSkinType(tbPageContext, i);
            g(this.jZv, 3);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.card.a
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.jZv.setPageUniqueId(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void D(br brVar) {
        this.jZv.setData(brVar);
    }

    public void setOnItemCoverListener(f<MetaData> fVar) {
        this.jZv.setOnItemCoverListener(fVar);
    }

    public void setHasBorder(boolean z) {
        this.jZv.setHasBorder(z);
    }
}
