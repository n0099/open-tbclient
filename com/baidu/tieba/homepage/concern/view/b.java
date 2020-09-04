package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.h.f;
/* loaded from: classes16.dex */
public class b extends com.baidu.card.b<bo> {
    private ConcernRecommendLayout iIf;
    private int mSkinType;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.iIf = new ConcernRecommendLayout(tbPageContext.getPageActivity());
        this.iIf.setPageContext(tbPageContext);
        this.iIf.setPageUniqueId(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.iIf;
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.iIf.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.iIf.setPageUniqueId(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: a */
    public void F(bo boVar) {
        this.iIf.setData(boVar);
    }

    public void setOnItemCoverListener(f<MetaData> fVar) {
        this.iIf.setOnItemCoverListener(fVar);
    }

    public void setHasBorder(boolean z) {
        this.iIf.setHasBorder(z);
    }
}
