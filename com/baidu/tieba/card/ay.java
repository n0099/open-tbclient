package com.baidu.tieba.card;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.UserLikeButton;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ay extends bd {
    private TbPageContext ND;
    public UserLikeButton aSy;
    public TextView aTL;
    private UserLikeButton.a aTN;
    private View.OnClickListener aTO;
    private View.OnClickListener aTP;
    private com.baidu.tieba.card.a.t aTR;
    private com.baidu.tbadk.core.data.as aeC;
    private int mSkinType;

    public ay(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aTN = new az(this);
        this.aTO = new ba(this);
        this.aTP = new bb(this);
        this.ND = tbPageContext;
        this.aTT.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aTV.getLayoutParams();
        layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.ND.getPageActivity(), t.e.ds4);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.c(this.ND.getPageActivity(), t.e.ds6);
        this.aTV.setLayoutParams(layoutParams);
        this.aTL = new TextView(tbPageContext.getPageActivity());
        this.aTL.setId(t.g.fans_num);
        this.aTL.setIncludeFontPadding(false);
        this.aTL.setTextSize(0, com.baidu.adp.lib.util.k.c(tbPageContext.getPageActivity(), t.e.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.c(tbPageContext.getPageActivity(), t.e.ds14);
        this.aTL.setLayoutParams(layoutParams2);
        this.aTL.setOnClickListener(this.aTO);
        this.aTs.addView(this.aTL, 1);
        this.aSy = new UserLikeButton(tbPageContext.getPageActivity());
        this.aSy.setId(t.g.card_god_feed_like_btn);
        this.aSy.setAfterClickListener(this.aTP);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.k.c(this.ND.getPageActivity(), t.e.ds120), com.baidu.adp.lib.util.k.c(this.ND.getPageActivity(), t.e.ds56));
        layoutParams3.addRule(11);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.c(this.ND.getPageActivity(), t.e.ds24);
        layoutParams3.topMargin = com.baidu.adp.lib.util.k.c(this.ND.getPageActivity(), t.e.ds36);
        this.aSy.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.aSy);
        this.aSy.setFanNumCallBack(this.aTN);
    }

    @Override // com.baidu.tieba.card.bd
    public void a(com.baidu.tieba.card.a.t tVar) {
        super.a(tVar);
        if (tVar != null && tVar.aVJ != null) {
            this.aTR = tVar;
            this.aeC = tVar.aVJ;
            if (tVar.aVJ.getAuthor() != null) {
                fL(tVar.aVJ.getAuthor().getFansNum());
                if (this.aeC.getAuthor().getGodUserData().getFollowed() == 1) {
                    this.aSy.setVisibility(8);
                    return;
                }
                this.aSy.setVisibility(0);
                this.aSy.setData(this.aeC);
            }
        }
    }

    @Override // com.baidu.tieba.card.bd
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.j((View) this.aTL, t.d.cp_cont_d);
            this.aSy.aD(true);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.bd
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
        if (this.aSy != null) {
            this.aSy.i(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fL(int i) {
        if (this.aTL != null) {
            this.aTL.setText(String.format(this.ND.getResources().getString(t.j.fans_default_name_god_user), com.baidu.tbadk.core.util.ay.z(i)));
        }
    }
}
