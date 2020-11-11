package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.homepage.concern.a.d;
/* loaded from: classes22.dex */
public class c extends com.baidu.card.b<d> {
    private RecommendBarLayout jxS;
    private int jxT;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, byte b) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.jxS = new RecommendBarLayout(tbPageContext, tbPageContext.getPageActivity(), bdUniqueId, b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.jxS;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.jxS.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.jxS.setPageId(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(d dVar) {
        if (dVar != null && this.jxT != dVar.hashCode()) {
            this.jxT = dVar.hashCode();
            this.jxS.setData(dVar);
        }
    }
}
