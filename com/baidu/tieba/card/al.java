package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class al extends aq {
    private com.baidu.tbadk.core.data.bk ahV;
    private TbPageContext ajr;
    private View.OnClickListener bvp;
    private View.OnClickListener bvq;
    public TextView bvs;
    public EntelechyUserLikeButton bvt;
    private com.baidu.tieba.card.data.l bvu;
    private CommonUserLikeButton.a bvv;
    private int mSkinType;

    public al(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bvv = new am(this);
        this.bvp = new an(this);
        this.bvq = new ao(this);
        this.ajr = tbPageContext;
    }

    @Override // com.baidu.tieba.card.aq
    public void a(com.baidu.tieba.card.data.l lVar) {
        super.onBindDataToView(lVar);
        if (lVar != null && lVar.threadData != null) {
            this.bvu = lVar;
            this.ahV = lVar.threadData;
        }
    }

    @Override // com.baidu.tieba.card.aq, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.aq
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gL(int i) {
        if (this.bvs != null) {
            this.bvs.setText(String.format(this.ajr.getResources().getString(w.l.fans_default_name_god_user), com.baidu.tbadk.core.util.au.t(i)));
        }
    }
}
