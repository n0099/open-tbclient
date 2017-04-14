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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class x extends a {
    private bi aiB;
    private TbPageContext ajT;
    private CommonUserLikeButton.a brt;
    public EntelechyUserLikeButton brw;
    private com.baidu.tbadk.core.view.userLike.c brx;
    public TextView bsY;
    private View.OnClickListener bta;
    private int mSkinType;

    public x(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.brt = new y(this);
        this.bta = new z(this);
        this.ajT = tbPageContext;
        this.bsY = new TextView(tbPageContext.getPageActivity());
        this.bsY.setIncludeFontPadding(false);
        this.bsY.setTextSize(0, com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds6);
        this.bsY.setLayoutParams(layoutParams);
        this.bsY.setOnClickListener(this.bta);
        this.bbe.addView(this.bsY, 1);
        this.brw = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.brw.setFanNumCallBack(this.brt);
        this.brw.setId(w.h.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, w.h.header_divider);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds32);
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds24);
        this.brw.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.brw);
        this.brx = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.brw);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void k(bi biVar) {
        super.onBindDataToView(biVar);
        if (biVar != null) {
            this.aiB = biVar;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbd.getLayoutParams();
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (this.aiB.getAuthor() == null || this.aiB.getAuthor().getPendantData() == null || StringUtils.isNull(this.aiB.getAuthor().getPendantData().qB())) {
                if (this.aiB.sr()) {
                    this.baZ.setIsGod(true);
                    layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds4);
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds6);
                } else {
                    this.baZ.setIsGod(false);
                }
            } else {
                this.baZ.setIsGod(false);
            }
            this.bbd.setLayoutParams(layoutParams);
            if (biVar.getAuthor() != null) {
                this.brx.a(biVar.getAuthor());
                gI(biVar.getAuthor().getFansNum());
                if (!this.aiB.sr()) {
                    this.brw.setVisibility(8);
                } else if (this.aiB.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aiB.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.brw.setVisibility(8);
                    return;
                } else if (this.aiB.getAuthor().getGodUserData() != null && this.aiB.getAuthor().getGodUserData().getIsLike()) {
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
            int i = ((RelativeLayout.LayoutParams) this.bbf.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.brw.getLayoutParams();
            if (biVar.sJ() != null) {
                layoutParams2.topMargin = i + com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds4);
            } else {
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.i(this.bsY, w.e.cp_cont_d);
            this.brw.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gI(int i) {
        if (this.bsY != null) {
            String string = this.ajT.getResources().getString(w.l.fans_default_name_god_user);
            if (this.aiB != null && !StringUtils.isNull(this.aiB.st()) && this.aiB.st().equals(this.mForumName)) {
                if (this.aiB.sr()) {
                    String format = String.format(string, com.baidu.tbadk.core.util.au.t(i));
                    this.bsY.setVisibility(0);
                    this.bsY.setText(format);
                    return;
                }
                this.bsY.setVisibility(8);
                return;
            }
            this.bsY.setText(this.ajT.getResources().getString(w.l.default_personalized_name));
        }
    }
}
