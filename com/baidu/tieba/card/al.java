package com.baidu.tieba.card;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class al extends x {
    private TbPageContext FY;
    private com.baidu.tbadk.core.data.bh acX;
    private CommonUserLikeButton.a bkJ;
    public EntelechyUserLikeButton bkM;
    private com.baidu.tbadk.core.view.userLike.c bkN;
    public TextView bmm;
    private com.baidu.tieba.card.data.p bmn;
    private View.OnClickListener bmo;
    private View.OnClickListener bmp;
    private int mSkinType;

    public al(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bkJ = new am(this);
        this.bmo = new an(this);
        this.bmp = new ao(this);
        Ro();
        this.FY = tbPageContext;
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
        this.bkN = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bkM);
        this.bkM.setFanNumCallBack(this.bkJ);
        this.bkM.setAfterOnClickListener(this.bmp);
        this.bkM.setId(r.h.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds56));
        layoutParams2.addRule(11);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds28);
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds32);
        this.bkM.setGravity(21);
        this.bkM.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.bkM);
    }

    @Override // com.baidu.tieba.card.x
    public void a(com.baidu.tieba.card.data.p pVar) {
        super.onBindDataToView(pVar);
        if (pVar != null && pVar.aVi != null) {
            this.bmn = pVar;
            this.acX = pVar.aVi;
            pVar.sourceType = 0;
            if (pVar.aVi.getAuthor() != null) {
                gI(pVar.aVi.getAuthor().getFansNum());
                if (this.acX.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.acX.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bkM.setVisibility(8);
                    return;
                }
                if (this.acX.getAuthor().getGodUserData().getIsLike()) {
                    this.bkM.setVisibility(8);
                } else {
                    this.bkM.setVisibility(0);
                    this.bkN.a(this.acX.getAuthor());
                }
                if (this.acX.getAuthor().getGodUserData().getType() == 2) {
                    this.aUT.setGodIconMargin(0);
                } else {
                    this.aUT.setGodIconMargin(-1);
                }
            }
        }
    }

    @Override // com.baidu.tieba.card.x, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.i((View) this.bmm, r.e.cp_cont_d);
            this.bkM.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.x
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
        this.bkN.i(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gI(int i) {
        if (this.bmm != null) {
            this.bmm.setText(String.format(this.FY.getResources().getString(r.l.fans_default_name_god_user), com.baidu.tbadk.core.util.at.u(i)));
        }
    }
}
