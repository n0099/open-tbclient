package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.UserLikeButton;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class n extends a {
    private TbPageContext EA;
    private UserLikeButton.a aJK;
    public UserLikeButton aTa;
    public TextView aUv;
    private View.OnClickListener aUx;
    private View.OnClickListener aUy;
    private be abb;
    private int mSkinType;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aJK = new o(this);
        this.aUx = new p(this);
        this.aUy = new q(this);
        this.EA = tbPageContext;
        this.aTU.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aTX.getLayoutParams();
        layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds4);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds6);
        this.aTX.setLayoutParams(layoutParams);
        this.aUv = new TextView(tbPageContext.getPageActivity());
        this.aUv.setIncludeFontPadding(false);
        this.aUv.setTextSize(0, com.baidu.adp.lib.util.k.c(tbPageContext.getPageActivity(), u.e.ds24));
        this.aUv.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.aUv.setOnClickListener(this.aUx);
        this.aTY.addView(this.aUv, 1);
        this.aTa = new UserLikeButton(tbPageContext.getPageActivity());
        this.aTa.setId(u.g.card_god_feed_like_btn);
        this.aTa.setAfterClickListener(this.aUy);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds120), com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, u.g.guess_your_like_header);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds32);
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds36);
        this.aTa.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.aTa);
        this.aTa.setFanNumCallBack(this.aJK);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void i(be beVar) {
        super.i(beVar);
        if (beVar != null) {
            this.abb = beVar;
            if (beVar.getAuthor() != null) {
                fE(beVar.getAuthor().getFansNum());
                if (this.abb.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.abb.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.aTa.setVisibility(8);
                    return;
                } else if (this.abb.getAuthor().getGodUserData().getFollowed() == 1) {
                    if (this.abb.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.aTa.setVisibility(8);
                    } else {
                        this.aTa.aJ(true);
                    }
                } else {
                    this.aTa.setVisibility(0);
                    this.aTa.setData(this.abb);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.bHx.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aTa.getLayoutParams();
            if (beVar.qP() != null) {
                layoutParams.topMargin = i + com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds16);
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds36);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            av.j((View) this.aUv, u.d.cp_cont_d);
            this.aTa.aJ(true);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
        if (this.aTa != null) {
            this.aTa.i(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fE(int i) {
        if (this.aUv != null) {
            this.aUv.setText(String.format(this.EA.getResources().getString(u.j.fans_default_name_god_user), ba.w(i)));
        }
    }
}
