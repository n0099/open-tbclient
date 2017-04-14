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
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class t extends aa {
    private bi aiB;
    private TbPageContext ajT;
    private CommonUserLikeButton.a brt;
    public EntelechyUserLikeButton brw;
    private com.baidu.tbadk.core.view.userLike.c brx;
    public TextView bsY;
    private View.OnClickListener bta;
    private View.OnClickListener btb;
    private int mSkinType;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.brt = new u(this);
        this.bta = new v(this);
        this.btb = new w(this);
        this.ajT = tbPageContext;
        this.btk.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bto.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds4);
        this.bto.setLayoutParams(layoutParams);
        this.bsY = new TextView(tbPageContext.getPageActivity());
        this.bsY.setId(w.h.fans_num);
        this.bsY.setIncludeFontPadding(false);
        this.bsY.setTextSize(0, com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds14);
        this.bsY.setLayoutParams(layoutParams2);
        this.bsY.setOnClickListener(this.bta);
        this.bbe.addView(this.bsY, 1);
        this.brw = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.brw.setId(w.h.card_god_feed_like_btn);
        this.brw.setFanNumCallBack(this.brt);
        this.brx = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.brw);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, w.h.header_divider);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds36);
        layoutParams3.topMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds32);
        this.brw.setGravity(21);
        this.brw.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.brw);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.aa
    public void k(bi biVar) {
        boolean z = false;
        super.onBindDataToView(biVar);
        if (biVar != null) {
            this.aiB = biVar;
            if (biVar.getAuthor() != null) {
                gI(biVar.getAuthor().getFansNum());
                this.brx.a(biVar.getAuthor());
                if (this.aiB.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aiB.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.brw.setVisibility(8);
                    return;
                } else if (this.aiB.getAuthor().getGodUserData().getIsLike()) {
                    if (this.aiB.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.brw.setVisibility(8);
                    } else {
                        this.brw.setVisibility(0);
                        this.brw.aQ(true);
                    }
                } else {
                    this.brw.setVisibility(0);
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
            int i = ((RelativeLayout.LayoutParams) this.bbf.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.brw.getLayoutParams();
            if (!z && biVar.sJ() != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds12) + i;
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds32);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.aa, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.i(this.bsY, w.e.cp_cont_d);
            this.brw.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.aa
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gI(int i) {
        if (this.bsY != null) {
            this.bsY.setText(String.format(this.ajT.getResources().getString(w.l.fans_default_name_god_user), com.baidu.tbadk.core.util.au.t(i)));
        }
    }
}
