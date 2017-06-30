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
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class q extends x {
    private bm aiu;
    private TbPageContext ajP;
    private View.OnClickListener bBW;
    private View.OnClickListener bBX;
    public TextView bBZ;
    private com.baidu.tbadk.core.view.userLike.c bBd;
    public EntelechyUserLikeButton bCa;
    private CommonUserLikeButton.a bCc;
    private int mSkinType;

    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.bCc = new r(this);
        this.bBW = new s(this);
        this.bBX = new t(this);
        this.ajP = tbPageContext;
        this.amN.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bCt.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds4);
        this.bCt.setLayoutParams(layoutParams);
        this.bBZ = new TextView(tbPageContext.getPageActivity());
        this.bBZ.setId(w.h.fans_num);
        this.bBZ.setIncludeFontPadding(false);
        this.bBZ.setTextSize(0, com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds14);
        this.bBZ.setLayoutParams(layoutParams2);
        this.bBZ.setOnClickListener(this.bBW);
        this.bgH.addView(this.bBZ, 1);
        this.bCa = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.bCa.setId(w.h.card_god_feed_like_btn);
        this.bCa.setFanNumCallBack(this.bCc);
        this.bBd = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bCa);
        this.bBd.i(bdUniqueId);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, w.h.header_divider);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds36);
        layoutParams3.topMargin = com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds32);
        this.bCa.setGravity(21);
        this.bCa.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.bCa);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.x
    public void t(bm bmVar) {
        boolean z = false;
        super.a(bmVar);
        if (bmVar != null) {
            this.aiu = bmVar;
            if (bmVar.getAuthor() != null) {
                hm(bmVar.getAuthor().getFansNum());
                this.bBd.a(bmVar.getAuthor());
                if (this.aiu.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aiu.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bCa.setVisibility(8);
                    return;
                } else if (this.aiu.getAuthor().getGodUserData().getIsLike()) {
                    if (this.aiu.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.bCa.setVisibility(8);
                    } else {
                        this.bCa.setVisibility(0);
                        this.bCa.aP(true);
                    }
                } else {
                    this.bCa.setVisibility(0);
                }
            }
            MetaData author = bmVar.getAuthor();
            ThemeCardInUserData themeCardInUserData = null;
            if (author != null) {
                themeCardInUserData = author.getThemeCard();
            }
            if (themeCardInUserData != null && !StringUtils.isNull(themeCardInUserData.getCardImageUrlAndroid())) {
                z = true;
            }
            int i = ((RelativeLayout.LayoutParams) this.bgI.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bCa.getLayoutParams();
            if (!z && bmVar.rM() != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds12) + i;
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds32);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.x, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.as.i(this.bBZ, w.e.cp_cont_d);
            this.bCa.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.x
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hm(int i) {
        if (this.bBZ != null) {
            this.bBZ.setText(String.format(this.ajP.getResources().getString(w.l.fans_default_name_god_user), com.baidu.tbadk.core.util.aw.t(i)));
        }
    }
}
