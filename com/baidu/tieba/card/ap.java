package com.baidu.tieba.card;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.UserLikeButton;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ap extends au {
    private TbPageContext Ea;
    private UserLikeButton.a aIT;
    public UserLikeButton aSe;
    private View.OnClickListener aTB;
    private View.OnClickListener aTC;
    private com.baidu.tieba.card.a.m aTE;
    public TextView aTz;
    private com.baidu.tbadk.core.data.az aas;
    private int mSkinType;

    public ap(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aIT = new aq(this);
        this.aTB = new ar(this);
        this.aTC = new as(this);
        this.Ea = tbPageContext;
        this.aTK.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aTM.getLayoutParams();
        layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds4);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds6);
        this.aTM.setLayoutParams(layoutParams);
        this.aTz = new TextView(tbPageContext.getPageActivity());
        this.aTz.setId(u.g.fans_num);
        this.aTz.setIncludeFontPadding(false);
        this.aTz.setTextSize(0, com.baidu.adp.lib.util.k.c(tbPageContext.getPageActivity(), u.e.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.c(tbPageContext.getPageActivity(), u.e.ds14);
        this.aTz.setLayoutParams(layoutParams2);
        this.aTz.setOnClickListener(this.aTB);
        this.aTc.addView(this.aTz, 1);
        this.aSe = new UserLikeButton(tbPageContext.getPageActivity());
        this.aSe.setId(u.g.card_god_feed_like_btn);
        this.aSe.setAfterClickListener(this.aTC);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds120), com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds56));
        layoutParams3.addRule(11);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds24);
        layoutParams3.topMargin = com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds36);
        this.aSe.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.aSe);
        this.aSe.setFanNumCallBack(this.aIT);
    }

    @Override // com.baidu.tieba.card.au
    public void a(com.baidu.tieba.card.a.m mVar) {
        super.a(mVar);
        if (mVar != null && mVar.threadData != null) {
            this.aTE = mVar;
            this.aas = mVar.threadData;
            if (mVar.threadData.getAuthor() != null) {
                fF(mVar.threadData.getAuthor().getFansNum());
                if (this.aas.getAuthor().getGodUserData().getFollowed() == 1) {
                    this.aSe.setVisibility(8);
                    return;
                }
                this.aSe.setVisibility(0);
                this.aSe.setData(this.aas);
            }
        }
    }

    @Override // com.baidu.tieba.card.au
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.j((View) this.aTz, u.d.cp_cont_d);
            this.aSe.aG(true);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.au
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
        if (this.aSe != null) {
            this.aSe.i(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fF(int i) {
        if (this.aTz != null) {
            this.aTz.setText(String.format(this.Ea.getResources().getString(u.j.fans_default_name_god_user), com.baidu.tbadk.core.util.ba.B(i)));
        }
    }
}
