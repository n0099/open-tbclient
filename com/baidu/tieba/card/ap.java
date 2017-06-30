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
    private com.baidu.tbadk.core.data.bm aiu;
    private TbPageContext ajP;
    private View.OnClickListener bBW;
    private View.OnClickListener bBX;
    public TextView bBZ;
    public EntelechyUserLikeButton bCa;
    private com.baidu.tieba.card.data.l bCb;
    private CommonUserLikeButton.a bCc;
    private int mSkinType;

    public ap(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bCc = new aq(this);
        this.bBW = new ar(this);
        this.bBX = new as(this);
        this.ajP = tbPageContext;
    }

    @Override // com.baidu.tieba.card.au
    public void a(com.baidu.tieba.card.data.l lVar) {
        super.a(lVar);
        if (lVar != null && lVar.threadData != null) {
            this.bCb = lVar;
            this.aiu = lVar.threadData;
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
    public void hm(int i) {
        if (this.bBZ != null) {
            this.bBZ.setText(String.format(this.ajP.getResources().getString(w.l.fans_default_name_god_user), com.baidu.tbadk.core.util.aw.t(i)));
        }
    }
}
