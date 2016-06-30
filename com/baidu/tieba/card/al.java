package com.baidu.tieba.card;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.UserLikeButton;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class al extends z {
    private TbPageContext Ea;
    private UserLikeButton.a aIT;
    public UserLikeButton aSe;
    private com.baidu.tieba.card.a.o aTA;
    private View.OnClickListener aTB;
    private View.OnClickListener aTC;
    public TextView aTz;
    private com.baidu.tbadk.core.data.az aas;
    private int mSkinType;

    public al(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aIT = new am(this);
        this.aTB = new an(this);
        this.aTC = new ao(this);
        this.Ea = tbPageContext;
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
        layoutParams2.rightMargin = com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds24);
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds36);
        this.aSe.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.aSe);
        this.aSe.setFanNumCallBack(this.aIT);
    }

    @Override // com.baidu.tieba.card.z
    public void a(com.baidu.tieba.card.a.o oVar) {
        super.a(oVar);
        if (oVar != null && oVar.aVc != null) {
            this.aTA = oVar;
            this.aas = oVar.aVc;
            if (oVar.aVc.getAuthor() != null) {
                fF(oVar.aVc.getAuthor().getFansNum());
                if (this.aas.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aas.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.aSe.setVisibility(8);
                    return;
                }
                if (this.aas.getAuthor().getGodUserData().getFollowed() == 1) {
                    this.aSe.setVisibility(8);
                } else {
                    this.aSe.setVisibility(0);
                    this.aSe.setData(this.aas);
                }
                if (this.aas.getAuthor().getGodUserData().getType() == 2) {
                    this.aSY.setGodIconMargin(0);
                } else {
                    this.aSY.setGodIconMargin(-1);
                }
            }
        }
    }

    @Override // com.baidu.tieba.card.z
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.j((View) this.aTz, u.d.cp_cont_d);
            this.aSe.aG(true);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.z
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
