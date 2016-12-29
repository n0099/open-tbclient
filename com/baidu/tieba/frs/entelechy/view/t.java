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
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class t extends aa {
    private TbPageContext GO;
    private com.baidu.tbadk.core.view.userLike.c aQT;
    private CommonUserLikeButton.a aQX;
    private bg adN;
    public EntelechyUserLikeButton baZ;
    private View.OnClickListener bcA;
    public TextView bcx;
    private View.OnClickListener bcz;
    private int mSkinType;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aQX = new u(this);
        this.bcz = new v(this);
        this.bcA = new w(this);
        this.GO = tbPageContext;
        this.bcJ.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcM.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds4);
        this.bcM.setLayoutParams(layoutParams);
        this.bcx = new TextView(tbPageContext.getPageActivity());
        this.bcx.setId(r.g.fans_num);
        this.bcx.setIncludeFontPadding(false);
        this.bcx.setTextSize(0, com.baidu.adp.lib.util.k.e(tbPageContext.getPageActivity(), r.e.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.e(tbPageContext.getPageActivity(), r.e.ds14);
        this.bcx.setLayoutParams(layoutParams2);
        this.bcx.setOnClickListener(this.bcz);
        this.bcd.addView(this.bcx, 1);
        this.baZ = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.baZ.setId(r.g.card_god_feed_like_btn);
        this.baZ.setFanNumCallBack(this.aQX);
        this.aQT = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.baZ);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, r.g.header_divider);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds36);
        layoutParams3.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds32);
        this.baZ.setGravity(21);
        this.baZ.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.baZ);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.aa
    public void o(bg bgVar) {
        boolean z = false;
        super.onBindDataToView(bgVar);
        if (bgVar != null) {
            this.adN = bgVar;
            if (bgVar.getAuthor() != null) {
                gg(bgVar.getAuthor().getFansNum());
                this.aQT.a(bgVar.getAuthor());
                if (this.adN.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.adN.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.baZ.setVisibility(8);
                    return;
                } else if (this.adN.getAuthor().getGodUserData().getIsLike()) {
                    if (this.adN.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.baZ.setVisibility(8);
                    } else {
                        this.baZ.setVisibility(0);
                        this.baZ.aP(true);
                    }
                } else {
                    this.baZ.setVisibility(0);
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
            int i = ((RelativeLayout.LayoutParams) this.bAV.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.baZ.getLayoutParams();
            if (!z && bgVar.rZ() != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds12) + i;
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds32);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.aa, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ar.j((View) this.bcx, r.d.cp_cont_d);
            this.baZ.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.aa
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gg(int i) {
        if (this.bcx != null) {
            this.bcx.setText(String.format(this.GO.getResources().getString(r.j.fans_default_name_god_user), com.baidu.tbadk.core.util.av.v(i)));
        }
    }
}
