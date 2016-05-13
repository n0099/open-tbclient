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
public class aq extends av {
    private TbPageContext DV;
    public UserLikeButton aOX;
    public TextView aQf;
    private UserLikeButton.a aQh;
    private View.OnClickListener aQi;
    private View.OnClickListener aQj;
    private com.baidu.tieba.card.a.l aQl;
    private com.baidu.tbadk.core.data.ax aab;
    private int mSkinType;

    public aq(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aQh = new ar(this);
        this.aQi = new as(this);
        this.aQj = new at(this);
        this.DV = tbPageContext;
        this.aQn.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aQp.getLayoutParams();
        layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.DV.getPageActivity(), t.e.ds4);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.c(this.DV.getPageActivity(), t.e.ds6);
        this.aQp.setLayoutParams(layoutParams);
        this.aQf = new TextView(tbPageContext.getPageActivity());
        this.aQf.setId(t.g.fans_num);
        this.aQf.setIncludeFontPadding(false);
        this.aQf.setTextSize(0, com.baidu.adp.lib.util.k.c(tbPageContext.getPageActivity(), t.e.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.c(tbPageContext.getPageActivity(), t.e.ds14);
        this.aQf.setLayoutParams(layoutParams2);
        this.aQf.setOnClickListener(this.aQi);
        this.aPG.addView(this.aQf, 1);
        this.aOX = new UserLikeButton(tbPageContext.getPageActivity());
        this.aOX.setId(t.g.card_god_feed_like_btn);
        this.aOX.setAfterClickListener(this.aQj);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.k.c(this.DV.getPageActivity(), t.e.ds120), com.baidu.adp.lib.util.k.c(this.DV.getPageActivity(), t.e.ds56));
        layoutParams3.addRule(11);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.c(this.DV.getPageActivity(), t.e.ds24);
        layoutParams3.topMargin = com.baidu.adp.lib.util.k.c(this.DV.getPageActivity(), t.e.ds36);
        this.aOX.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.aOX);
        this.aOX.setFanNumCallBack(this.aQh);
    }

    @Override // com.baidu.tieba.card.av
    public void a(com.baidu.tieba.card.a.l lVar) {
        super.a(lVar);
        if (lVar != null && lVar.aRG != null) {
            this.aQl = lVar;
            this.aab = lVar.aRG;
            if (lVar.aRG.getAuthor() != null) {
                ft(lVar.aRG.getAuthor().getFansNum());
                if (this.aab.getAuthor().getGodUserData().getFollowed() == 1) {
                    this.aOX.setVisibility(8);
                    return;
                }
                this.aOX.setVisibility(0);
                this.aOX.setData(this.aab);
            }
        }
    }

    @Override // com.baidu.tieba.card.av
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.j((View) this.aQf, t.d.cp_cont_d);
            this.aOX.aI(true);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.av
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
        if (this.aOX != null) {
            this.aOX.i(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ft(int i) {
        if (this.aQf != null) {
            this.aQf.setText(String.format(this.DV.getResources().getString(t.j.fans_default_name_god_user), com.baidu.tbadk.core.util.ay.A(i)));
        }
    }
}
