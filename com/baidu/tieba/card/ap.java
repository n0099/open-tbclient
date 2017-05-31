package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ap extends au {
    private com.baidu.tbadk.core.data.bl ahM;
    private TbPageContext ajh;
    private View.OnClickListener bBd;
    private View.OnClickListener bBe;
    public TextView bBg;
    public EntelechyUserLikeButton bBh;
    private com.baidu.tieba.card.data.l bBi;
    private CommonUserLikeButton.a bBj;
    private int mSkinType;

    public ap(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bBj = new aq(this);
        this.bBd = new ar(this);
        this.bBe = new as(this);
        this.ajh = tbPageContext;
    }

    @Override // com.baidu.tieba.card.au
    public void a(com.baidu.tieba.card.data.l lVar) {
        super.a(lVar);
        if (lVar != null && lVar.threadData != null) {
            this.bBi = lVar;
            this.ahM = lVar.threadData;
        }
    }

    @Override // com.baidu.tieba.card.au, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.au
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hj(int i) {
        if (this.bBg != null) {
            this.bBg.setText(String.format(this.ajh.getResources().getString(w.l.fans_default_name_god_user), com.baidu.tbadk.core.util.au.t(i)));
        }
    }
}
