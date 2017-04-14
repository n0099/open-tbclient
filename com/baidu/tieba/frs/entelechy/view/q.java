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
public class q extends a {
    private bi aiB;
    private TbPageContext ajT;
    private boolean bTq;
    private CommonUserLikeButton.a brt;
    public EntelechyUserLikeButton brw;
    private com.baidu.tbadk.core.view.userLike.c brx;
    public TextView bsY;
    private View.OnClickListener bta;
    private int mSkinType;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bTq = false;
        this.brt = new r(this);
        this.bta = new s(this);
        this.ajT = tbPageContext;
        this.baZ.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbd.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds4);
        this.bbd.setLayoutParams(layoutParams);
        this.bsY = new TextView(tbPageContext.getPageActivity());
        this.bsY.setIncludeFontPadding(false);
        this.bsY.setTextSize(0, com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds24));
        this.bsY.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.bsY.setOnClickListener(this.bta);
        this.bbe.addView(this.bsY, 1);
        this.brw = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.brw.setFanNumCallBack(this.brt);
        this.brw.setId(w.h.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, w.h.header_divider);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds36);
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds32);
        this.brw.setGravity(21);
        this.brw.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.brw);
        this.brx = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.brw);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void k(bi biVar) {
        super.onBindDataToView(biVar);
        if (biVar != null) {
            this.aiB = biVar;
            if (this.aiB.ts() != null && this.aiB.ts().channelId > 0) {
                this.bTq = true;
            } else {
                this.bTq = false;
            }
            if (this.bTq) {
                this.baZ.setIsGod(false);
            } else if (this.aiB.getAuthor() == null || this.aiB.getAuthor().getPendantData() == null || StringUtils.isNull(this.aiB.getAuthor().getPendantData().qB())) {
                this.baZ.setIsGod(true);
            } else {
                this.baZ.setIsGod(false);
            }
            if (biVar.getAuthor() != null) {
                this.brx.a(biVar.getAuthor());
                if (this.bTq) {
                    this.bsY.setVisibility(4);
                } else {
                    this.bsY.setVisibility(0);
                    gI(biVar.getAuthor().getFansNum());
                }
                if (this.aiB.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aiB.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.brw.setVisibility(8);
                    return;
                } else if (this.bTq) {
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
            int i = ((RelativeLayout.LayoutParams) this.bbf.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.brw.getLayoutParams();
            if (biVar.sJ() != null) {
                layoutParams.topMargin = i + com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds20);
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds40);
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
            this.bsY.setText(String.format(this.ajT.getResources().getString(w.l.fans_default_name_god_user), com.baidu.tbadk.core.util.au.t(i)));
        }
    }
}
