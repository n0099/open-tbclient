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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class q extends a {
    private TbPageContext GO;
    private com.baidu.tbadk.core.view.userLike.c aQT;
    private CommonUserLikeButton.a aQX;
    private bg adN;
    public EntelechyUserLikeButton baZ;
    public TextView bcx;
    private View.OnClickListener bcz;
    private int mSkinType;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aQX = new r(this);
        this.bcz = new s(this);
        this.GO = tbPageContext;
        this.bbY.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcc.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds4);
        this.bcc.setLayoutParams(layoutParams);
        this.bcx = new TextView(tbPageContext.getPageActivity());
        this.bcx.setIncludeFontPadding(false);
        this.bcx.setTextSize(0, com.baidu.adp.lib.util.k.e(tbPageContext.getPageActivity(), r.e.ds24));
        this.bcx.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.bcx.setOnClickListener(this.bcz);
        this.bcd.addView(this.bcx, 1);
        this.baZ = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.baZ.setFanNumCallBack(this.aQX);
        this.baZ.setId(r.g.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, r.g.header_divider);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds36);
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds32);
        this.baZ.setGravity(21);
        this.baZ.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.baZ);
        this.aQT = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.baZ);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void o(bg bgVar) {
        super.onBindDataToView(bgVar);
        if (bgVar != null) {
            this.adN = bgVar;
            if (this.adN.getAuthor() == null || this.adN.getAuthor().getPendantData() == null || StringUtils.isNull(this.adN.getAuthor().getPendantData().pS())) {
                this.bbY.setIsGod(true);
            } else {
                this.bbY.setIsGod(false);
            }
            if (bgVar.getAuthor() != null) {
                this.aQT.a(bgVar.getAuthor());
                gg(bgVar.getAuthor().getFansNum());
                if (this.adN.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.adN.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.baZ.setVisibility(8);
                    return;
                } else if (this.adN.getAuthor().getGodUserData().getIsLike()) {
                    if (this.adN.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.baZ.setVisibility(8);
                    } else {
                        this.baZ.setVisibility(0);
                        this.baZ.aP(true);
                    }
                } else {
                    this.baZ.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.bAV.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.baZ.getLayoutParams();
            if (bgVar.rZ() != null) {
                layoutParams.topMargin = i + com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds20);
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds40);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ar.j((View) this.bcx, r.d.cp_cont_d);
            this.baZ.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gg(int i) {
        if (this.bcx != null) {
            this.bcx.setText(String.format(this.GO.getResources().getString(r.j.fans_default_name_god_user), com.baidu.tbadk.core.util.av.v(i)));
        }
    }
}
