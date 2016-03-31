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
public class au extends al {
    private TbPageContext ND;
    public UserLikeButton aSy;
    public TextView aTL;
    private com.baidu.tieba.card.a.v aTM;
    private UserLikeButton.a aTN;
    private View.OnClickListener aTO;
    private View.OnClickListener aTP;
    private com.baidu.tbadk.core.data.as aeC;
    private int mSkinType;

    public au(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aTN = new av(this);
        this.aTO = new aw(this);
        this.aTP = new ax(this);
        this.ND = tbPageContext;
        this.aTo.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aTr.getLayoutParams();
        layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.ND.getPageActivity(), t.e.ds4);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.c(this.ND.getPageActivity(), t.e.ds6);
        this.aTr.setLayoutParams(layoutParams);
        this.aTL = new TextView(tbPageContext.getPageActivity());
        this.aTL.setIncludeFontPadding(false);
        this.aTL.setTextSize(0, com.baidu.adp.lib.util.k.c(tbPageContext.getPageActivity(), t.e.ds24));
        this.aTL.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.aTL.setOnClickListener(this.aTO);
        this.aTs.addView(this.aTL, 1);
        this.aSy = new UserLikeButton(tbPageContext.getPageActivity());
        this.aSy.setId(t.g.card_god_feed_like_btn);
        this.aSy.setAfterClickListener(this.aTP);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.k.c(this.ND.getPageActivity(), t.e.ds120), com.baidu.adp.lib.util.k.c(this.ND.getPageActivity(), t.e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.k.c(this.ND.getPageActivity(), t.e.ds24);
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.c(this.ND.getPageActivity(), t.e.ds36);
        this.aSy.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.aSy);
        this.aSy.setFanNumCallBack(this.aTN);
    }

    @Override // com.baidu.tieba.card.al
    public void a(com.baidu.tieba.card.a.v vVar) {
        super.a(vVar);
        if (vVar != null && vVar.aWf != null) {
            this.aTM = vVar;
            this.aeC = vVar.aWf;
            if (vVar.aWf.getAuthor() != null) {
                fL(vVar.aWf.getAuthor().getFansNum());
                if (this.aeC.getAuthor().getGodUserData().getFollowed() == 1) {
                    this.aSy.setVisibility(8);
                    return;
                }
                this.aSy.setVisibility(0);
                this.aSy.setData(this.aeC);
            }
        }
    }

    @Override // com.baidu.tieba.card.al
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.j((View) this.aTL, t.d.cp_cont_d);
            this.aSy.aD(true);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.al
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
