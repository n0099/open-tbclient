package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.h.f;
/* loaded from: classes21.dex */
public class b extends com.baidu.card.b<bo> {
    private ConcernRecommendLayout iQx;
    private int mSkinType;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.iQx = new ConcernRecommendLayout(tbPageContext.getPageActivity());
        this.iQx.setPageContext(tbPageContext);
        this.iQx.setPageUniqueId(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.iQx;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.iQx.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.iQx.setPageUniqueId(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void G(bo boVar) {
        this.iQx.setData(boVar);
    }

    public void setOnItemCoverListener(f<MetaData> fVar) {
        this.iQx.setOnItemCoverListener(fVar);
    }

    public void setHasBorder(boolean z) {
        this.iQx.setHasBorder(z);
    }
}
