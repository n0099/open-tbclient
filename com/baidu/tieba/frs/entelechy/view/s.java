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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class s extends w {
    private TbPageContext GO;
    private com.baidu.tbadk.core.view.userLike.c aRC;
    private CommonUserLikeButton.a aRG;
    private bk aeu;
    public EntelechyUserLikeButton bbT;
    public TextView bdf;
    private View.OnClickListener bdh;
    private View.OnClickListener bdi;
    private int mSkinType;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aRG = new t(this);
        this.bdh = new u(this);
        this.bdi = new v(this);
        this.GO = tbPageContext;
        this.bdr.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdu.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds4);
        this.bdu.setLayoutParams(layoutParams);
        this.bdf = new TextView(tbPageContext.getPageActivity());
        this.bdf.setId(r.g.fans_num);
        this.bdf.setIncludeFontPadding(false);
        this.bdf.setTextSize(0, com.baidu.adp.lib.util.k.e(tbPageContext.getPageActivity(), r.e.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.e(tbPageContext.getPageActivity(), r.e.ds14);
        this.bdf.setLayoutParams(layoutParams2);
        this.bdf.setOnClickListener(this.bdh);
        this.bcK.addView(this.bdf, 1);
        this.bbT = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.bbT.setId(r.g.card_god_feed_like_btn);
        this.bbT.setFanNumCallBack(this.aRG);
        this.aRC = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bbT);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, r.g.guess_your_like_header);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds36);
        layoutParams3.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds32);
        this.bbT.setGravity(21);
        this.bbT.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.bbT);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.w
    public void j(bk bkVar) {
        boolean z = false;
        super.onBindDataToView(bkVar);
        if (bkVar != null) {
            this.aeu = bkVar;
            if (bkVar.getAuthor() != null) {
                gh(bkVar.getAuthor().getFansNum());
                this.aRC.a(bkVar.getAuthor());
                if (this.aeu.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aeu.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bbT.setVisibility(8);
                    return;
                } else if (this.aeu.getAuthor().getGodUserData().getIsLike()) {
                    if (this.aeu.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.bbT.setVisibility(8);
                    } else {
                        this.bbT.setVisibility(0);
                        this.bbT.aO(true);
                    }
                } else {
                    this.bbT.setVisibility(0);
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
            int i = ((RelativeLayout.LayoutParams) this.bUJ.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bbT.getLayoutParams();
            if (!z && bkVar.si() != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds12) + i;
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds32);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.w, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.j((View) this.bdf, r.d.cp_cont_d);
            this.bbT.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.w
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gh(int i) {
        if (this.bdf != null) {
            this.bdf.setText(String.format(this.GO.getResources().getString(r.j.fans_default_name_god_user), ax.v(i)));
        }
    }
}
