package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.UserLikeButton;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class m extends a {
    private TbPageContext Ea;
    private UserLikeButton.a aIT;
    public UserLikeButton aSe;
    private View.OnClickListener aTB;
    private View.OnClickListener aTC;
    public TextView aTz;
    private az aas;
    private int mSkinType;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aIT = new n(this);
        this.aTB = new o(this);
        this.aTC = new p(this);
        this.Ea = tbPageContext;
        this.aSY.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aTb.getLayoutParams();
        layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds4);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds6);
        this.aTb.setLayoutParams(layoutParams);
        this.aTz = new TextView(tbPageContext.getPageActivity());
        this.aTz.setIncludeFontPadding(false);
        this.aTz.setTextSize(0, com.baidu.adp.lib.util.k.c(tbPageContext.getPageActivity(), u.e.ds24));
        this.aTz.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.aTz.setOnClickListener(this.aTB);
        this.aTc.addView(this.aTz, 1);
        this.aSe = new UserLikeButton(tbPageContext.getPageActivity());
        this.aSe.setId(u.g.card_god_feed_like_btn);
        this.aSe.setAfterClickListener(this.aTC);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds120), com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds32);
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds36);
        this.aSe.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.aSe);
        this.aSe.setFanNumCallBack(this.aIT);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void h(az azVar) {
        super.h(azVar);
        if (azVar != null) {
            this.aas = azVar;
            if (azVar.getAuthor() != null) {
                fF(azVar.getAuthor().getFansNum());
                if (this.aas.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aas.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.aSe.setVisibility(8);
                    return;
                } else if (this.aas.getAuthor().getGodUserData().getFollowed() == 1) {
                    if (this.aas.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.aSe.setVisibility(8);
                    } else {
                        this.aSe.aG(true);
                    }
                } else {
                    this.aSe.setVisibility(0);
                    this.aSe.setData(this.aas);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.bGc.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aSe.getLayoutParams();
            if (azVar.qZ() != null) {
                layoutParams.topMargin = i + com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds16);
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds36);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            av.j((View) this.aTz, u.d.cp_cont_d);
            this.aSe.aG(true);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
        if (this.aSe != null) {
            this.aSe.i(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fF(int i) {
        if (this.aTz != null) {
            this.aTz.setText(String.format(this.Ea.getResources().getString(u.j.fans_default_name_god_user), ba.B(i)));
        }
    }
}
