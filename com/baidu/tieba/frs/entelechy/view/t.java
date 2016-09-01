package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.UserLikeButton;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class t extends x {
    private TbPageContext GM;
    private UserLikeButton.a aOm;
    public UserLikeButton aYi;
    public TextView aZG;
    private View.OnClickListener aZI;
    private View.OnClickListener aZJ;
    private bg adL;
    private int mSkinType;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aOm = new u(this);
        this.aZI = new v(this);
        this.aZJ = new w(this);
        this.GM = tbPageContext;
        this.aZR.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aZT.getLayoutParams();
        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds4);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds6);
        this.aZT.setLayoutParams(layoutParams);
        this.aZG = new TextView(tbPageContext.getPageActivity());
        this.aZG.setId(t.g.fans_num);
        this.aZG.setIncludeFontPadding(false);
        this.aZG.setTextSize(0, com.baidu.adp.lib.util.k.e(tbPageContext.getPageActivity(), t.e.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.e(tbPageContext.getPageActivity(), t.e.ds14);
        this.aZG.setLayoutParams(layoutParams2);
        this.aZG.setOnClickListener(this.aZI);
        this.aZg.addView(this.aZG, 1);
        this.aYi = new UserLikeButton(tbPageContext.getPageActivity());
        this.aYi.setId(t.g.card_god_feed_like_btn);
        this.aYi.setAfterClickListener(this.aZJ);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds120), com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, t.g.guess_your_like_header);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds32);
        layoutParams3.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds36);
        this.aYi.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.aYi);
        this.aYi.setFanNumCallBack(this.aOm);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.x
    public void i(bg bgVar) {
        boolean z = false;
        super.onBindDataToView(bgVar);
        if (bgVar != null) {
            this.adL = bgVar;
            if (bgVar.getAuthor() != null) {
                gc(bgVar.getAuthor().getFansNum());
                if (this.adL.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.adL.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.aYi.setVisibility(8);
                    return;
                } else if (this.adL.getAuthor().getGodUserData().getFollowed() == 1) {
                    if (this.adL.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.aYi.setVisibility(8);
                    } else {
                        this.aYi.aK(true);
                    }
                } else {
                    this.aYi.setVisibility(0);
                    this.aYi.setData(this.adL);
                }
            }
            MetaData author = bgVar.getAuthor();
            ThemeCardInUserData themeCardInUserData = null;
            if (author != null) {
                themeCardInUserData = author.getThemeCard();
            }
            if (themeCardInUserData != null && !StringUtils.isNull(themeCardInUserData.getCardImageUrlAndroid())) {
                z = true;
            }
            int i = ((RelativeLayout.LayoutParams) this.bSD.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aYi.getLayoutParams();
            if (!z && bgVar.rU() != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds16) + i;
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds36);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.x, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            av.j((View) this.aZG, t.d.cp_cont_d);
            this.aYi.aK(true);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.x
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
        if (this.aYi != null) {
            this.aYi.i(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc(int i) {
        if (this.aZG != null) {
            this.aZG.setText(String.format(this.GM.getResources().getString(t.j.fans_default_name_god_user), ba.w(i)));
        }
    }
}
