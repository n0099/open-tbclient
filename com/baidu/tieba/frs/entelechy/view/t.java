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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class t extends aa {
    private bj ain;
    private TbPageContext ajF;
    private CommonUserLikeButton.a brB;
    public EntelechyUserLikeButton brE;
    private com.baidu.tbadk.core.view.userLike.c brF;
    public TextView btg;
    private View.OnClickListener bti;
    private View.OnClickListener btj;
    private int mSkinType;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.brB = new u(this);
        this.bti = new v(this);
        this.btj = new w(this);
        this.ajF = tbPageContext;
        this.btt.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.btw.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds4);
        this.btw.setLayoutParams(layoutParams);
        this.btg = new TextView(tbPageContext.getPageActivity());
        this.btg.setId(w.h.fans_num);
        this.btg.setIncludeFontPadding(false);
        this.btg.setTextSize(0, com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds14);
        this.btg.setLayoutParams(layoutParams2);
        this.btg.setOnClickListener(this.bti);
        this.bbl.addView(this.btg, 1);
        this.brE = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.brE.setId(w.h.card_god_feed_like_btn);
        this.brE.setFanNumCallBack(this.brB);
        this.brF = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.brE);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, w.h.header_divider);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds36);
        layoutParams3.topMargin = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds32);
        this.brE.setGravity(21);
        this.brE.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.brE);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.aa
    public void k(bj bjVar) {
        boolean z = false;
        super.onBindDataToView(bjVar);
        if (bjVar != null) {
            this.ain = bjVar;
            if (bjVar.getAuthor() != null) {
                gF(bjVar.getAuthor().getFansNum());
                this.brF.a(bjVar.getAuthor());
                if (this.ain.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.ain.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.brE.setVisibility(8);
                    return;
                } else if (this.ain.getAuthor().getGodUserData().getIsLike()) {
                    if (this.ain.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.brE.setVisibility(8);
                    } else {
                        this.brE.setVisibility(0);
                        this.brE.aO(true);
                    }
                } else {
                    this.brE.setVisibility(0);
                }
            }
            MetaData author = bjVar.getAuthor();
            ThemeCardInUserData themeCardInUserData = null;
            if (author != null) {
                themeCardInUserData = author.getThemeCard();
            }
            if (themeCardInUserData != null && !StringUtils.isNull(themeCardInUserData.getCardImageUrlAndroid())) {
                z = true;
            }
            int i = ((RelativeLayout.LayoutParams) this.bbm.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.brE.getLayoutParams();
            if (!z && bjVar.sl() != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds12) + i;
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds32);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.aa, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.i((View) this.btg, w.e.cp_cont_d);
            this.brE.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.aa
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gF(int i) {
        if (this.btg != null) {
            this.btg.setText(String.format(this.ajF.getResources().getString(w.l.fans_default_name_god_user), com.baidu.tbadk.core.util.au.t(i)));
        }
    }
}
