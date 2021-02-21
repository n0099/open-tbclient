package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.homepage.concern.a.c;
/* loaded from: classes2.dex */
public class b extends com.baidu.card.a<c> {
    private RecommendBarLayout kcL;
    private int kcM;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, byte b2) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.kcL = new RecommendBarLayout(tbPageContext, tbPageContext.getPageActivity(), bdUniqueId, b2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.kcL;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.kcL.onChangeSkinType(tbPageContext, i);
            g(this.kcL, 3);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.card.a
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.kcL.setPageId(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(c cVar) {
        if (cVar != null && this.kcM != cVar.hashCode()) {
            this.kcM = cVar.hashCode();
            this.kcL.setData(cVar);
        }
    }
}
