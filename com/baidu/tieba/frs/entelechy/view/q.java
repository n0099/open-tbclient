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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class q extends x {
    private bl ahM;
    private TbPageContext ajh;
    private com.baidu.tbadk.core.view.userLike.c bAk;
    private View.OnClickListener bBd;
    private View.OnClickListener bBe;
    public TextView bBg;
    public EntelechyUserLikeButton bBh;
    private CommonUserLikeButton.a bBj;
    private int mSkinType;

    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.bBj = new r(this);
        this.bBd = new s(this);
        this.bBe = new t(this);
        this.ajh = tbPageContext;
        this.alV.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bBA.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds4);
        this.bBA.setLayoutParams(layoutParams);
        this.bBg = new TextView(tbPageContext.getPageActivity());
        this.bBg.setId(w.h.fans_num);
        this.bBg.setIncludeFontPadding(false);
        this.bBg.setTextSize(0, com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds14);
        this.bBg.setLayoutParams(layoutParams2);
        this.bBg.setOnClickListener(this.bBd);
        this.bdK.addView(this.bBg, 1);
        this.bBh = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.bBh.setId(w.h.card_god_feed_like_btn);
        this.bBh.setFanNumCallBack(this.bBj);
        this.bAk = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bBh);
        this.bAk.i(bdUniqueId);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, w.h.header_divider);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds36);
        layoutParams3.topMargin = com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds32);
        this.bBh.setGravity(21);
        this.bBh.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.bBh);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.x
    public void r(bl blVar) {
        boolean z = false;
        super.a(blVar);
        if (blVar != null) {
            this.ahM = blVar;
            if (blVar.getAuthor() != null) {
                hj(blVar.getAuthor().getFansNum());
                this.bAk.a(blVar.getAuthor());
                if (this.ahM.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.ahM.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bBh.setVisibility(8);
                    return;
                } else if (this.ahM.getAuthor().getGodUserData().getIsLike()) {
                    if (this.ahM.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.bBh.setVisibility(8);
                    } else {
                        this.bBh.setVisibility(0);
                        this.bBh.aO(true);
                    }
                } else {
                    this.bBh.setVisibility(0);
                }
            }
            MetaData author = blVar.getAuthor();
            ThemeCardInUserData themeCardInUserData = null;
            if (author != null) {
                themeCardInUserData = author.getThemeCard();
            }
            if (themeCardInUserData != null && !StringUtils.isNull(themeCardInUserData.getCardImageUrlAndroid())) {
                z = true;
            }
            int i = ((RelativeLayout.LayoutParams) this.bdL.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bBh.getLayoutParams();
            if (!z && blVar.rP() != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds12) + i;
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds32);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.x, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.i(this.bBg, w.e.cp_cont_d);
            this.bBh.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.x
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hj(int i) {
        if (this.bBg != null) {
            this.bBg.setText(String.format(this.ajh.getResources().getString(w.l.fans_default_name_god_user), com.baidu.tbadk.core.util.au.t(i)));
        }
    }
}
