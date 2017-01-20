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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class t extends aa {
    private TbPageContext FY;
    private bh acX;
    private CommonUserLikeButton.a bkJ;
    public EntelechyUserLikeButton bkM;
    private com.baidu.tbadk.core.view.userLike.c bkN;
    public TextView bmm;
    private View.OnClickListener bmo;
    private View.OnClickListener bmp;
    private int mSkinType;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bkJ = new u(this);
        this.bmo = new v(this);
        this.bmp = new w(this);
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
        this.bkM.setId(r.h.card_god_feed_like_btn);
        this.bkM.setFanNumCallBack(this.bkJ);
        this.bkN = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bkM);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, r.h.header_divider);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds36);
        layoutParams3.topMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds32);
        this.bkM.setGravity(21);
        this.bkM.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.bkM);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.aa
    public void k(bh bhVar) {
        boolean z = false;
        super.onBindDataToView(bhVar);
        if (bhVar != null) {
            this.acX = bhVar;
            if (bhVar.getAuthor() != null) {
                gI(bhVar.getAuthor().getFansNum());
                this.bkN.a(bhVar.getAuthor());
                if (this.acX.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.acX.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bkM.setVisibility(8);
                    return;
                } else if (this.acX.getAuthor().getGodUserData().getIsLike()) {
                    if (this.acX.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.bkM.setVisibility(8);
                    } else {
                        this.bkM.setVisibility(0);
                        this.bkM.aP(true);
                    }
                } else {
                    this.bkM.setVisibility(0);
                }
            }
            MetaData author = bhVar.getAuthor();
            ThemeCardInUserData themeCardInUserData = null;
            if (author != null) {
                themeCardInUserData = author.getThemeCard();
            }
            if (themeCardInUserData != null && !StringUtils.isNull(themeCardInUserData.getCardImageUrlAndroid())) {
                z = true;
            }
            int i = ((RelativeLayout.LayoutParams) this.aUZ.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bkM.getLayoutParams();
            if (!z && bhVar.rR() != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds12) + i;
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds32);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.aa, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.i((View) this.bmm, r.e.cp_cont_d);
            this.bkM.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.aa
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gI(int i) {
        if (this.bmm != null) {
            this.bmm.setText(String.format(this.FY.getResources().getString(r.l.fans_default_name_god_user), com.baidu.tbadk.core.util.at.u(i)));
        }
    }
}
