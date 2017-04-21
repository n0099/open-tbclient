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
    private bi aiC;
    private TbPageContext ajU;
    private CommonUserLikeButton.a btL;
    public EntelechyUserLikeButton btO;
    private com.baidu.tbadk.core.view.userLike.c btP;
    public TextView bvr;
    private View.OnClickListener bvt;
    private View.OnClickListener bvu;
    private int mSkinType;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.btL = new u(this);
        this.bvt = new v(this);
        this.bvu = new w(this);
        this.ajU = tbPageContext;
        this.bvD.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvG.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds4);
        this.bvG.setLayoutParams(layoutParams);
        this.bvr = new TextView(tbPageContext.getPageActivity());
        this.bvr.setId(w.h.fans_num);
        this.bvr.setIncludeFontPadding(false);
        this.bvr.setTextSize(0, com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds14);
        this.bvr.setLayoutParams(layoutParams2);
        this.bvr.setOnClickListener(this.bvt);
        this.bca.addView(this.bvr, 1);
        this.btO = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.btO.setId(w.h.card_god_feed_like_btn);
        this.btO.setFanNumCallBack(this.btL);
        this.btP = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.btO);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, w.h.header_divider);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds36);
        layoutParams3.topMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds32);
        this.btO.setGravity(21);
        this.btO.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.btO);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.aa
    public void k(bi biVar) {
        boolean z = false;
        super.onBindDataToView(biVar);
        if (biVar != null) {
            this.aiC = biVar;
            if (biVar.getAuthor() != null) {
                gO(biVar.getAuthor().getFansNum());
                this.btP.a(biVar.getAuthor());
                if (this.aiC.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aiC.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.btO.setVisibility(8);
                    return;
                } else if (this.aiC.getAuthor().getGodUserData().getIsLike()) {
                    if (this.aiC.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.btO.setVisibility(8);
                    } else {
                        this.btO.setVisibility(0);
                        this.btO.aQ(true);
                    }
                } else {
                    this.btO.setVisibility(0);
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
            int i = ((RelativeLayout.LayoutParams) this.bcb.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.btO.getLayoutParams();
            if (!z && biVar.sJ() != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds12) + i;
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds32);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.aa, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.i(this.bvr, w.e.cp_cont_d);
            this.btO.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.aa
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gO(int i) {
        if (this.bvr != null) {
            this.bvr.setText(String.format(this.ajU.getResources().getString(w.l.fans_default_name_god_user), com.baidu.tbadk.core.util.au.t(i)));
        }
    }
}
