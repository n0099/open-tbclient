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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class u extends a {
    private bk ahV;
    private TbPageContext ajr;
    private com.baidu.tbadk.core.view.userLike.c buw;
    private View.OnClickListener bvp;
    public TextView bvs;
    public EntelechyUserLikeButton bvt;
    private CommonUserLikeButton.a bvv;
    private int mSkinType;

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.bvv = new v(this);
        this.bvp = new w(this);
        this.ajr = tbPageContext;
        this.bvs = new TextView(tbPageContext.getPageActivity());
        this.bvs.setIncludeFontPadding(false);
        this.bvs.setTextSize(0, com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds6);
        this.bvs.setLayoutParams(layoutParams);
        this.bvs.setOnClickListener(this.bvp);
        this.bcs.addView(this.bvs, 1);
        this.bvt = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.bvt.setFanNumCallBack(this.bvv);
        this.bvt.setId(w.h.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, w.h.header_divider);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds32);
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds24);
        this.bvt.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.bvt);
        this.buw = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bvt);
        this.buw.i(bdUniqueId);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void p(bk bkVar) {
        super.onBindDataToView(bkVar);
        if (bkVar != null) {
            this.ahV = bkVar;
            if (bkVar.getAuthor() != null) {
                this.buw.a(bkVar.getAuthor());
                gL(bkVar.getAuthor().getFansNum());
                if (!this.ahV.rB()) {
                    this.bvt.setVisibility(8);
                } else if (this.ahV.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.ahV.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bvt.setVisibility(8);
                    return;
                } else if (this.ahV.getAuthor().getGodUserData() != null && this.ahV.getAuthor().getGodUserData().getIsLike()) {
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
            int i = ((RelativeLayout.LayoutParams) this.bct.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bvt.getLayoutParams();
            if (bkVar.rT() != null) {
                layoutParams.topMargin = i + com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds4);
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.i(this.bvs, w.e.cp_cont_d);
            this.bvt.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gL(int i) {
        if (this.bvs != null) {
            String string = this.ajr.getResources().getString(w.l.fans_default_name_god_user);
            if (this.ahV != null && !StringUtils.isNull(this.ahV.rD()) && this.ahV.rD().equals(this.mForumName)) {
                if (this.ahV.rB()) {
                    String format = String.format(string, com.baidu.tbadk.core.util.au.t(i));
                    this.bvs.setVisibility(0);
                    this.bvs.setText(format);
                    return;
                }
                this.bvs.setVisibility(8);
                return;
            }
            this.bvs.setText(this.ajr.getResources().getString(w.l.default_personalized_name));
        }
    }
}
