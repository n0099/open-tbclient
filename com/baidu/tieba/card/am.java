package com.baidu.tieba.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class am extends y {
    private com.baidu.tbadk.core.data.bm aiu;
    private TbPageContext ajP;
    private com.baidu.tieba.card.data.n bBV;
    private View.OnClickListener bBW;
    private View.OnClickListener bBX;
    private int mSkinType;

    public am(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bBW = new an(this);
        this.bBX = new ao(this);
        this.ajP = tbPageContext;
    }

    @Override // com.baidu.tieba.card.y
    public void a(com.baidu.tieba.card.data.n nVar) {
        super.a(nVar);
        if (nVar != null && nVar.bai != null) {
            this.bBV = nVar;
            this.aiu = nVar.bai;
            nVar.sourceType = 0;
        }
    }

    @Override // com.baidu.tieba.card.y, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.y
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }
}
