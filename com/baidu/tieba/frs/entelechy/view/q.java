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
    private bi aiC;
    private TbPageContext ajU;
    private boolean bVH;
    private CommonUserLikeButton.a btL;
    public EntelechyUserLikeButton btO;
    private com.baidu.tbadk.core.view.userLike.c btP;
    public TextView bvr;
    private View.OnClickListener bvt;
    private int mSkinType;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bVH = false;
        this.btL = new r(this);
        this.bvt = new s(this);
        this.ajU = tbPageContext;
        this.bbV.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbZ.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds4);
        this.bbZ.setLayoutParams(layoutParams);
        this.bvr = new TextView(tbPageContext.getPageActivity());
        this.bvr.setIncludeFontPadding(false);
        this.bvr.setTextSize(0, com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds24));
        this.bvr.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.bvr.setOnClickListener(this.bvt);
        this.bca.addView(this.bvr, 1);
        this.btO = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.btO.setFanNumCallBack(this.btL);
        this.btO.setId(w.h.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, w.h.header_divider);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds36);
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds32);
        this.btO.setGravity(21);
        this.btO.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.btO);
        this.btP = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.btO);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void k(bi biVar) {
        super.onBindDataToView(biVar);
        if (biVar != null) {
            this.aiC = biVar;
            if (this.aiC.ts() != null && this.aiC.ts().channelId > 0) {
                this.bVH = true;
            } else {
                this.bVH = false;
            }
            if (this.bVH) {
                this.bbV.setIsGod(false);
            } else if (this.aiC.getAuthor() == null || this.aiC.getAuthor().getPendantData() == null || StringUtils.isNull(this.aiC.getAuthor().getPendantData().qB())) {
                this.bbV.setIsGod(true);
            } else {
                this.bbV.setIsGod(false);
            }
            if (biVar.getAuthor() != null) {
                this.btP.a(biVar.getAuthor());
                if (this.bVH) {
                    this.bvr.setVisibility(4);
                } else {
                    this.bvr.setVisibility(0);
                    gO(biVar.getAuthor().getFansNum());
                }
                if (this.aiC.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aiC.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.btO.setVisibility(8);
                    return;
                } else if (this.bVH) {
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
            int i = ((RelativeLayout.LayoutParams) this.bcb.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.btO.getLayoutParams();
            if (biVar.sJ() != null) {
                layoutParams.topMargin = i + com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds20);
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds40);
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
            this.bvr.setText(String.format(this.ajU.getResources().getString(w.l.fans_default_name_god_user), com.baidu.tbadk.core.util.au.t(i)));
        }
    }
}
