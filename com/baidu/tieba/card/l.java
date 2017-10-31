package com.baidu.tieba.card;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
/* loaded from: classes.dex */
public class l extends n {
    private bh ajq;
    public EntelechyUserLikeButton bSC;
    private com.baidu.tieba.card.data.l bSD;
    private TbPageContext mPageContext;
    private int mSkinType;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.n, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        super.a(lVar);
        if (lVar != null && lVar.blk != null) {
            this.bSD = lVar;
            this.ajq = lVar.blk;
        }
    }

    @Override // com.baidu.tieba.card.n, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.n
    public void k(BdUniqueId bdUniqueId) {
        super.k(bdUniqueId);
    }
}
