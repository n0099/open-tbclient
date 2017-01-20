package com.baidu.tieba.card;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ap extends au {
    private TbPageContext FY;
    private com.baidu.tbadk.core.data.bh acX;
    private CommonUserLikeButton.a bkJ;
    public EntelechyUserLikeButton bkM;
    private com.baidu.tbadk.core.view.userLike.c bkN;
    public TextView bmm;
    private View.OnClickListener bmo;
    private View.OnClickListener bmp;
    private com.baidu.tieba.card.data.n bmr;
    private int mSkinType;

    public ap(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bkJ = new aq(this);
        this.bmo = new ar(this);
        this.bmp = new as(this);
        this.FY = tbPageContext;
        this.bmy.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bmB.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds4);
        this.bmB.setLayoutParams(layoutParams);
        this.bmm = new TextView(tbPageContext.getPageActivity());
        this.bmm.setId(r.h.fans_num);
        this.bmm.setIncludeFontPadding(false);
        this.bmm.setTextSize(0, com.baidu.adp.lib.util.k.e(tbPageContext.getPageActivity(), r.f.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.e(tbPageContext.getPageActivity(), r.f.ds14);
        this.bmm.setLayoutParams(layoutParams2);
        this.bmm.setOnClickListener(this.bmo);
        this.aUY.addView(this.bmm, 1);
        this.bkM = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.bkM.setAfterOnClickListener(this.bmp);
        this.bkM.setFanNumCallBack(this.bkJ);
        this.bkN = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bkM);
        this.bkM.setId(r.h.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds56));
        layoutParams3.addRule(11);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds28);
        layoutParams3.topMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds32);
        this.bkM.setGravity(21);
        this.bkM.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.bkM);
    }

    @Override // com.baidu.tieba.card.au
    public void a(com.baidu.tieba.card.data.n nVar) {
        super.onBindDataToView(nVar);
        if (nVar != null && nVar.threadData != null) {
            this.bmr = nVar;
            this.acX = nVar.threadData;
            if (nVar.threadData.getAuthor() != null) {
                gI(nVar.threadData.getAuthor().getFansNum());
                if (this.acX.getAuthor().getGodUserData().getIsLike()) {
                    this.bkM.setVisibility(8);
                    return;
                }
                this.bkM.setVisibility(0);
                this.bkN.a(this.acX.getAuthor());
            }
        }
    }

    @Override // com.baidu.tieba.card.au, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.i((View) this.bmm, r.e.cp_cont_d);
            this.bkM.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.au
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
        this.bkN.i(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gI(int i) {
        if (this.bmm != null) {
            this.bmm.setText(String.format(this.FY.getResources().getString(r.l.fans_default_name_god_user), com.baidu.tbadk.core.util.at.u(i)));
        }
    }
}
