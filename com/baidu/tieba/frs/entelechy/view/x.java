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
    private bi aiC;
    private TbPageContext ajU;
    private CommonUserLikeButton.a btL;
    public EntelechyUserLikeButton btO;
    private com.baidu.tbadk.core.view.userLike.c btP;
    public TextView bvr;
    private View.OnClickListener bvt;
    private int mSkinType;

    public x(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.btL = new y(this);
        this.bvt = new z(this);
        this.ajU = tbPageContext;
        this.bvr = new TextView(tbPageContext.getPageActivity());
        this.bvr.setIncludeFontPadding(false);
        this.bvr.setTextSize(0, com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds6);
        this.bvr.setLayoutParams(layoutParams);
        this.bvr.setOnClickListener(this.bvt);
        this.bca.addView(this.bvr, 1);
        this.btO = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.btO.setFanNumCallBack(this.btL);
        this.btO.setId(w.h.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, w.h.header_divider);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds32);
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds24);
        this.btO.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.btO);
        this.btP = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.btO);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void k(bi biVar) {
        super.onBindDataToView(biVar);
        if (biVar != null) {
            this.aiC = biVar;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbZ.getLayoutParams();
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (this.aiC.getAuthor() == null || this.aiC.getAuthor().getPendantData() == null || StringUtils.isNull(this.aiC.getAuthor().getPendantData().qB())) {
                if (this.aiC.sr()) {
                    this.bbV.setIsGod(true);
                    layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds4);
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds6);
                } else {
                    this.bbV.setIsGod(false);
                }
            } else {
                this.bbV.setIsGod(false);
            }
            this.bbZ.setLayoutParams(layoutParams);
            if (biVar.getAuthor() != null) {
                this.btP.a(biVar.getAuthor());
                gO(biVar.getAuthor().getFansNum());
                if (!this.aiC.sr()) {
                    this.btO.setVisibility(8);
                } else if (this.aiC.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aiC.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.btO.setVisibility(8);
                    return;
                } else if (this.aiC.getAuthor().getGodUserData() != null && this.aiC.getAuthor().getGodUserData().getIsLike()) {
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
            int i = ((RelativeLayout.LayoutParams) this.bcb.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.btO.getLayoutParams();
            if (biVar.sJ() != null) {
                layoutParams2.topMargin = i + com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds4);
            } else {
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.i(this.bvr, w.e.cp_cont_d);
            this.btO.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gO(int i) {
        if (this.bvr != null) {
            String string = this.ajU.getResources().getString(w.l.fans_default_name_god_user);
            if (this.aiC != null && !StringUtils.isNull(this.aiC.st()) && this.aiC.st().equals(this.mForumName)) {
                if (this.aiC.sr()) {
                    String format = String.format(string, com.baidu.tbadk.core.util.au.t(i));
                    this.bvr.setVisibility(0);
                    this.bvr.setText(format);
                    return;
                }
                this.bvr.setVisibility(8);
                return;
            }
            this.bvr.setText(this.ajU.getResources().getString(w.l.default_personalized_name));
        }
    }
}
