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
public class ah extends t {
    private TbPageContext GM;
    private UserLikeButton.a aOm;
    public UserLikeButton aYi;
    public TextView aZG;
    private com.baidu.tieba.card.data.o aZH;
    private View.OnClickListener aZI;
    private View.OnClickListener aZJ;
    private com.baidu.tbadk.core.data.bg adL;
    private int mSkinType;

    public ah(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aOm = new ai(this);
        this.aZI = new aj(this);
        this.aZJ = new ak(this);
        this.GM = tbPageContext;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aZf.getLayoutParams();
        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds4);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds6);
        this.aZf.setLayoutParams(layoutParams);
        this.aZG = new TextView(tbPageContext.getPageActivity());
        this.aZG.setIncludeFontPadding(false);
        this.aZG.setTextSize(0, com.baidu.adp.lib.util.k.e(tbPageContext.getPageActivity(), t.e.ds24));
        this.aZG.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.aZG.setOnClickListener(this.aZI);
        this.aZg.addView(this.aZG, 1);
        this.aYi = new UserLikeButton(tbPageContext.getPageActivity());
        this.aYi.setId(t.g.card_god_feed_like_btn);
        this.aYi.setAfterClickListener(this.aZJ);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds120), com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds24);
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds36);
        this.aYi.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.aYi);
        this.aYi.setFanNumCallBack(this.aOm);
    }

    @Override // com.baidu.tieba.card.t
    public void a(com.baidu.tieba.card.data.o oVar) {
        super.onBindDataToView(oVar);
        if (oVar != null && oVar.bbC != null) {
            this.aZH = oVar;
            this.adL = oVar.bbC;
            if (oVar.bbC.getAuthor() != null) {
                gc(oVar.bbC.getAuthor().getFansNum());
                if (this.adL.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.adL.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.aYi.setVisibility(8);
                    return;
                }
                if (this.adL.getAuthor().getGodUserData().getFollowed() == 1) {
                    this.aYi.setVisibility(8);
                } else {
                    this.aYi.setVisibility(0);
                    this.aYi.setData(this.adL);
                }
                if (this.adL.getAuthor().getGodUserData().getType() == 2) {
                    this.aZc.setGodIconMargin(0);
                } else {
                    this.aZc.setGodIconMargin(-1);
                }
            }
        }
    }

    @Override // com.baidu.tieba.card.t, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.j((View) this.aZG, t.d.cp_cont_d);
            this.aYi.aK(true);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.t
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
        if (this.aYi != null) {
            this.aYi.i(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc(int i) {
        if (this.aZG != null) {
            this.aZG.setText(String.format(this.GM.getResources().getString(t.j.fans_default_name_god_user), com.baidu.tbadk.core.util.ba.w(i)));
        }
    }
}
