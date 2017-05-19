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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class q extends x {
    private bk ahV;
    private TbPageContext ajr;
    private com.baidu.tbadk.core.view.userLike.c buw;
    private View.OnClickListener bvp;
    private View.OnClickListener bvq;
    public TextView bvs;
    public EntelechyUserLikeButton bvt;
    private CommonUserLikeButton.a bvv;
    private int mSkinType;

    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.bvv = new r(this);
        this.bvp = new s(this);
        this.bvq = new t(this);
        this.ajr = tbPageContext;
        this.amf.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvQ.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds4);
        this.bvQ.setLayoutParams(layoutParams);
        this.bvs = new TextView(tbPageContext.getPageActivity());
        this.bvs.setId(w.h.fans_num);
        this.bvs.setIncludeFontPadding(false);
        this.bvs.setTextSize(0, com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds14);
        this.bvs.setLayoutParams(layoutParams2);
        this.bvs.setOnClickListener(this.bvp);
        this.bcs.addView(this.bvs, 1);
        this.bvt = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.bvt.setId(w.h.card_god_feed_like_btn);
        this.bvt.setFanNumCallBack(this.bvv);
        this.buw = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bvt);
        this.buw.i(bdUniqueId);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, w.h.header_divider);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds36);
        layoutParams3.topMargin = com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds32);
        this.bvt.setGravity(21);
        this.bvt.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.bvt);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.x
    public void p(bk bkVar) {
        boolean z = false;
        super.onBindDataToView(bkVar);
        if (bkVar != null) {
            this.ahV = bkVar;
            if (bkVar.getAuthor() != null) {
                gL(bkVar.getAuthor().getFansNum());
                this.buw.a(bkVar.getAuthor());
                if (this.ahV.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.ahV.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bvt.setVisibility(8);
                    return;
                } else if (this.ahV.getAuthor().getGodUserData().getIsLike()) {
                    if (this.ahV.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.bvt.setVisibility(8);
                    } else {
                        this.bvt.setVisibility(0);
                        this.bvt.aQ(true);
                    }
                } else {
                    this.bvt.setVisibility(0);
                }
            }
            MetaData author = bkVar.getAuthor();
            ThemeCardInUserData themeCardInUserData = null;
            if (author != null) {
                themeCardInUserData = author.getThemeCard();
            }
            if (themeCardInUserData != null && !StringUtils.isNull(themeCardInUserData.getCardImageUrlAndroid())) {
                z = true;
            }
            int i = ((RelativeLayout.LayoutParams) this.bct.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bvt.getLayoutParams();
            if (!z && bkVar.rT() != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds12) + i;
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds32);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.x, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.i(this.bvs, w.e.cp_cont_d);
            this.bvt.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.x
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gL(int i) {
        if (this.bvs != null) {
            this.bvs.setText(String.format(this.ajr.getResources().getString(w.l.fans_default_name_god_user), com.baidu.tbadk.core.util.au.t(i)));
        }
    }
}
