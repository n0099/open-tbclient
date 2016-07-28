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
    private TbPageContext EA;
    private UserLikeButton.a aJK;
    public UserLikeButton aTa;
    private com.baidu.tieba.card.a.m aUA;
    public TextView aUv;
    private View.OnClickListener aUx;
    private View.OnClickListener aUy;
    private com.baidu.tbadk.core.data.be abb;
    private int mSkinType;

    public ap(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aJK = new aq(this);
        this.aUx = new ar(this);
        this.aUy = new as(this);
        this.EA = tbPageContext;
        this.aUG.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aUI.getLayoutParams();
        layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds4);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds6);
        this.aUI.setLayoutParams(layoutParams);
        this.aUv = new TextView(tbPageContext.getPageActivity());
        this.aUv.setId(u.g.fans_num);
        this.aUv.setIncludeFontPadding(false);
        this.aUv.setTextSize(0, com.baidu.adp.lib.util.k.c(tbPageContext.getPageActivity(), u.e.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.c(tbPageContext.getPageActivity(), u.e.ds14);
        this.aUv.setLayoutParams(layoutParams2);
        this.aUv.setOnClickListener(this.aUx);
        this.aTY.addView(this.aUv, 1);
        this.aTa = new UserLikeButton(tbPageContext.getPageActivity());
        this.aTa.setId(u.g.card_god_feed_like_btn);
        this.aTa.setAfterClickListener(this.aUy);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds120), com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds56));
        layoutParams3.addRule(11);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds24);
        layoutParams3.topMargin = com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds36);
        this.aTa.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.aTa);
        this.aTa.setFanNumCallBack(this.aJK);
    }

    @Override // com.baidu.tieba.card.au
    public void a(com.baidu.tieba.card.a.m mVar) {
        super.a(mVar);
        if (mVar != null && mVar.threadData != null) {
            this.aUA = mVar;
            this.abb = mVar.threadData;
            if (mVar.threadData.getAuthor() != null) {
                fE(mVar.threadData.getAuthor().getFansNum());
                if (this.abb.getAuthor().getGodUserData().getFollowed() == 1) {
                    this.aTa.setVisibility(8);
                    return;
                }
                this.aTa.setVisibility(0);
                this.aTa.setData(this.abb);
            }
        }
    }

    @Override // com.baidu.tieba.card.au
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.j((View) this.aUv, u.d.cp_cont_d);
            this.aTa.aJ(true);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.au
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
        if (this.aTa != null) {
            this.aTa.i(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fE(int i) {
        if (this.aUv != null) {
            this.aUv.setText(String.format(this.EA.getResources().getString(u.j.fans_default_name_god_user), com.baidu.tbadk.core.util.ba.w(i)));
        }
    }
}
