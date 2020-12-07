package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.homepage.concern.a.c;
/* loaded from: classes22.dex */
public class b extends com.baidu.card.b<c> {
    private RecommendBarLayout jMl;
    private int jMm;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, byte b) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.jMl = new RecommendBarLayout(tbPageContext, tbPageContext.getPageActivity(), bdUniqueId, b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.jMl;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.jMl.onChangeSkinType(tbPageContext, i);
            e(this.jMl, 3);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.jMl.setPageId(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(c cVar) {
        if (cVar != null && this.jMm != cVar.hashCode()) {
            this.jMm = cVar.hashCode();
            this.jMl.setData(cVar);
        }
    }
}
