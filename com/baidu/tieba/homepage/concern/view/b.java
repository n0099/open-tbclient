package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.h.f;
/* loaded from: classes22.dex */
public class b extends com.baidu.card.b<bo> {
    private ConcernRecommendLayout jfr;
    private int mSkinType;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.jfr = new ConcernRecommendLayout(tbPageContext.getPageActivity());
        this.jfr.setPageContext(tbPageContext);
        this.jfr.setPageUniqueId(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.jfr;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.jfr.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.jfr.setPageUniqueId(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void H(bo boVar) {
        this.jfr.setData(boVar);
    }

    public void setOnItemCoverListener(f<MetaData> fVar) {
        this.jfr.setOnItemCoverListener(fVar);
    }

    public void setHasBorder(boolean z) {
        this.jfr.setHasBorder(z);
    }
}
