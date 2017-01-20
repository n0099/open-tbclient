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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class q extends a {
    private TbPageContext FY;
    private bh acX;
    private CommonUserLikeButton.a bkJ;
    public EntelechyUserLikeButton bkM;
    private com.baidu.tbadk.core.view.userLike.c bkN;
    public TextView bmm;
    private View.OnClickListener bmo;
    private int mSkinType;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bkJ = new r(this);
        this.bmo = new s(this);
        this.FY = tbPageContext;
        this.aUT.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aUX.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds4);
        this.aUX.setLayoutParams(layoutParams);
        this.bmm = new TextView(tbPageContext.getPageActivity());
        this.bmm.setIncludeFontPadding(false);
        this.bmm.setTextSize(0, com.baidu.adp.lib.util.k.e(tbPageContext.getPageActivity(), r.f.ds24));
        this.bmm.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.bmm.setOnClickListener(this.bmo);
        this.aUY.addView(this.bmm, 1);
        this.bkM = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.bkM.setFanNumCallBack(this.bkJ);
        this.bkM.setId(r.h.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, r.h.header_divider);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds36);
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds32);
        this.bkM.setGravity(21);
        this.bkM.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.bkM);
        this.bkN = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bkM);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void k(bh bhVar) {
        super.onBindDataToView(bhVar);
        if (bhVar != null) {
            this.acX = bhVar;
            if (this.acX.getAuthor() == null || this.acX.getAuthor().getPendantData() == null || StringUtils.isNull(this.acX.getAuthor().getPendantData().pL())) {
                this.aUT.setIsGod(true);
            } else {
                this.aUT.setIsGod(false);
            }
            if (bhVar.getAuthor() != null) {
                this.bkN.a(bhVar.getAuthor());
                gI(bhVar.getAuthor().getFansNum());
                if (this.acX.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.acX.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bkM.setVisibility(8);
                    return;
                } else if (this.acX.getAuthor().getGodUserData().getIsLike()) {
                    if (this.acX.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.bkM.setVisibility(8);
                    } else {
                        this.bkM.setVisibility(0);
                        this.bkM.aP(true);
                    }
                } else {
                    this.bkM.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.aUZ.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bkM.getLayoutParams();
            if (bhVar.rR() != null) {
                layoutParams.topMargin = i + com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds20);
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds40);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.i((View) this.bmm, r.e.cp_cont_d);
            this.bkM.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gI(int i) {
        if (this.bmm != null) {
            this.bmm.setText(String.format(this.FY.getResources().getString(r.l.fans_default_name_god_user), com.baidu.tbadk.core.util.at.u(i)));
        }
    }
}
