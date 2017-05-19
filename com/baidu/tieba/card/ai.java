package com.baidu.tieba.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class ai extends u {
    private com.baidu.tbadk.core.data.bk ahV;
    private TbPageContext ajr;
    private com.baidu.tieba.card.data.n bvo;
    private View.OnClickListener bvp;
    private View.OnClickListener bvq;
    private int mSkinType;

    public ai(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bvp = new aj(this);
        this.bvq = new ak(this);
        this.ajr = tbPageContext;
    }

    @Override // com.baidu.tieba.card.u
    public void a(com.baidu.tieba.card.data.n nVar) {
        super.onBindDataToView(nVar);
        if (nVar != null && nVar.bcB != null) {
            this.bvo = nVar;
            this.ahV = nVar.bcB;
            nVar.sourceType = 0;
        }
    }

    @Override // com.baidu.tieba.card.u, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.u
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }
}
