package com.baidu.tieba.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class am extends y {
    private com.baidu.tbadk.core.data.bl ahM;
    private TbPageContext ajh;
    private com.baidu.tieba.card.data.n bBc;
    private View.OnClickListener bBd;
    private View.OnClickListener bBe;
    private int mSkinType;

    public am(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bBd = new an(this);
        this.bBe = new ao(this);
        this.ajh = tbPageContext;
    }

    @Override // com.baidu.tieba.card.y
    public void a(com.baidu.tieba.card.data.n nVar) {
        super.a(nVar);
        if (nVar != null && nVar.aYA != null) {
            this.bBc = nVar;
            this.ahM = nVar.aYA;
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
