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
public class x extends a {
    private TbPageContext FY;
    private bh acX;
    private CommonUserLikeButton.a bkJ;
    public EntelechyUserLikeButton bkM;
    private com.baidu.tbadk.core.view.userLike.c bkN;
    public TextView bmm;
    private View.OnClickListener bmo;
    private int mSkinType;

    public x(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bkJ = new y(this);
        this.bmo = new z(this);
        this.FY = tbPageContext;
        this.bmm = new TextView(tbPageContext.getPageActivity());
        this.bmm.setIncludeFontPadding(false);
        this.bmm.setTextSize(0, com.baidu.adp.lib.util.k.e(tbPageContext.getPageActivity(), r.f.ds24));
        this.bmm.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.bmm.setOnClickListener(this.bmo);
        this.aUY.addView(this.bmm, 1);
        this.bkM = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.bkM.setFanNumCallBack(this.bkJ);
        this.bkM.setId(r.h.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds56));
        layoutParams.addRule(11);
        layoutParams.addRule(3, r.h.header_divider);
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds32);
        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds24);
        this.bkM.setLayoutParams(layoutParams);
        ((ViewGroup) getView()).addView(this.bkM);
        this.bkN = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bkM);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void k(bh bhVar) {
        super.onBindDataToView(bhVar);
        if (bhVar != null) {
            this.acX = bhVar;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aUX.getLayoutParams();
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (this.acX.getAuthor() == null || this.acX.getAuthor().getPendantData() == null || StringUtils.isNull(this.acX.getAuthor().getPendantData().pL())) {
                if (this.acX.rz()) {
                    this.aUT.setIsGod(true);
                    layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds4);
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds6);
                } else {
                    this.aUT.setIsGod(false);
                }
            } else {
                this.aUT.setIsGod(false);
            }
            this.aUX.setLayoutParams(layoutParams);
            if (bhVar.getAuthor() != null) {
                this.bkN.a(bhVar.getAuthor());
                gI(bhVar.getAuthor().getFansNum());
                if (!this.acX.rz()) {
                    this.bkM.setVisibility(8);
                } else if (this.acX.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.acX.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bkM.setVisibility(8);
                    return;
                } else if (this.acX.getAuthor().getGodUserData() != null && this.acX.getAuthor().getGodUserData().getIsLike()) {
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
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bkM.getLayoutParams();
            if (bhVar.rR() != null) {
                layoutParams2.topMargin = i + com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds4);
            } else {
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds24);
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
            String string = this.FY.getResources().getString(r.l.fans_default_name_god_user);
            if (this.acX != null && !StringUtils.isNull(this.acX.rB()) && this.acX.rB().equals(this.mForumName)) {
                if (this.acX.rz()) {
                    String format = String.format(string, com.baidu.tbadk.core.util.at.u(i));
                    this.bmm.setVisibility(0);
                    this.bmm.setText(format);
                    return;
                }
                this.bmm.setVisibility(8);
                return;
            }
            this.bmm.setText(this.FY.getResources().getString(r.l.default_personalized_name));
        }
    }
}
