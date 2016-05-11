package com.baidu.tieba.card;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.UserLikeButton;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class am extends z {
    private TbPageContext DV;
    public UserLikeButton aOX;
    public TextView aQf;
    private com.baidu.tieba.card.a.n aQg;
    private UserLikeButton.a aQh;
    private View.OnClickListener aQi;
    private View.OnClickListener aQj;
    private com.baidu.tbadk.core.data.ax aab;
    private int mSkinType;

    public am(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aQh = new an(this);
        this.aQi = new ao(this);
        this.aQj = new ap(this);
        this.DV = tbPageContext;
        this.aPC.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aPF.getLayoutParams();
        layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.DV.getPageActivity(), t.e.ds4);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.c(this.DV.getPageActivity(), t.e.ds6);
        this.aPF.setLayoutParams(layoutParams);
        this.aQf = new TextView(tbPageContext.getPageActivity());
        this.aQf.setIncludeFontPadding(false);
        this.aQf.setTextSize(0, com.baidu.adp.lib.util.k.c(tbPageContext.getPageActivity(), t.e.ds24));
        this.aQf.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.aQf.setOnClickListener(this.aQi);
        this.aPG.addView(this.aQf, 1);
        this.aOX = new UserLikeButton(tbPageContext.getPageActivity());
        this.aOX.setId(t.g.card_god_feed_like_btn);
        this.aOX.setAfterClickListener(this.aQj);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.k.c(this.DV.getPageActivity(), t.e.ds120), com.baidu.adp.lib.util.k.c(this.DV.getPageActivity(), t.e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.k.c(this.DV.getPageActivity(), t.e.ds24);
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.c(this.DV.getPageActivity(), t.e.ds36);
        this.aOX.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.aOX);
        this.aOX.setFanNumCallBack(this.aQh);
    }

    @Override // com.baidu.tieba.card.z
    public void a(com.baidu.tieba.card.a.n nVar) {
        super.a(nVar);
        if (nVar != null && nVar.aRZ != null) {
            this.aQg = nVar;
            this.aab = nVar.aRZ;
            if (nVar.aRZ.getAuthor() != null) {
                fu(nVar.aRZ.getAuthor().getFansNum());
                if (this.aab.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aab.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.aOX.setVisibility(8);
                } else if (this.aab.getAuthor().getGodUserData().getFollowed() == 1) {
                    this.aOX.setVisibility(8);
                } else {
                    this.aOX.setVisibility(0);
                    this.aOX.setData(this.aab);
                }
            }
        }
    }

    @Override // com.baidu.tieba.card.z
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.j((View) this.aQf, t.d.cp_cont_d);
            this.aOX.aI(true);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.z
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
        if (this.aOX != null) {
            this.aOX.i(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fu(int i) {
        if (this.aQf != null) {
            this.aQf.setText(String.format(this.DV.getResources().getString(t.j.fans_default_name_god_user), com.baidu.tbadk.core.util.ay.A(i)));
        }
    }
}
