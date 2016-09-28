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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.UserLikeButton;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class t extends x {
    private TbPageContext GM;
    private UserLikeButton.a aPz;
    public UserLikeButton aYK;
    public TextView aZX;
    private View.OnClickListener aZZ;
    private bi adW;
    private View.OnClickListener baa;
    private int mSkinType;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aPz = new u(this);
        this.aZZ = new v(this);
        this.baa = new w(this);
        this.GM = tbPageContext;
        this.bai.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bak.getLayoutParams();
        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds4);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds6);
        this.bak.setLayoutParams(layoutParams);
        this.aZX = new TextView(tbPageContext.getPageActivity());
        this.aZX.setId(r.g.fans_num);
        this.aZX.setIncludeFontPadding(false);
        this.aZX.setTextSize(0, com.baidu.adp.lib.util.k.e(tbPageContext.getPageActivity(), r.e.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.e(tbPageContext.getPageActivity(), r.e.ds14);
        this.aZX.setLayoutParams(layoutParams2);
        this.aZX.setOnClickListener(this.aZZ);
        this.aZA.addView(this.aZX, 1);
        this.aYK = new UserLikeButton(tbPageContext.getPageActivity());
        this.aYK.setId(r.g.card_god_feed_like_btn);
        this.aYK.setAfterClickListener(this.baa);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds120), com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, r.g.guess_your_like_header);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds32);
        layoutParams3.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds36);
        this.aYK.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.aYK);
        this.aYK.setFanNumCallBack(this.aPz);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.x
    public void k(bi biVar) {
        boolean z = false;
        super.onBindDataToView(biVar);
        if (biVar != null) {
            this.adW = biVar;
            if (biVar.getAuthor() != null) {
                gh(biVar.getAuthor().getFansNum());
                if (this.adW.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.adW.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.aYK.setVisibility(8);
                    return;
                } else if (this.adW.getAuthor().getGodUserData().getFollowed() == 1) {
                    if (this.adW.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.aYK.setVisibility(8);
                    } else {
                        this.aYK.aK(true);
                    }
                } else {
                    this.aYK.setVisibility(0);
                    this.aYK.a(this.adW, true);
                }
            }
            MetaData author = biVar.getAuthor();
            ThemeCardInUserData themeCardInUserData = null;
            if (author != null) {
                themeCardInUserData = author.getThemeCard();
            }
            if (themeCardInUserData != null && !StringUtils.isNull(themeCardInUserData.getCardImageUrlAndroid())) {
                z = true;
            }
            int i = ((RelativeLayout.LayoutParams) this.bSw.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aYK.getLayoutParams();
            if (!z && biVar.sg() != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds16) + i;
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds36);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.x, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            av.j((View) this.aZX, r.d.cp_cont_d);
            this.aYK.aK(true);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.x
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
        if (this.aYK != null) {
            this.aYK.i(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gh(int i) {
        if (this.aZX != null) {
            this.aZX.setText(String.format(this.GM.getResources().getString(r.j.fans_default_name_god_user), com.baidu.tbadk.core.util.az.w(i)));
        }
    }
}
