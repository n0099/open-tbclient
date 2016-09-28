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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class af extends r {
    private TbPageContext GM;
    private UserLikeButton.a aPz;
    public UserLikeButton aYK;
    public TextView aZX;
    private com.baidu.tieba.card.data.o aZY;
    private View.OnClickListener aZZ;
    private com.baidu.tbadk.core.data.bi adW;
    private View.OnClickListener baa;
    private int mSkinType;

    public af(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aPz = new ag(this);
        this.aZZ = new ah(this);
        this.baa = new ai(this);
        this.GM = tbPageContext;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aZz.getLayoutParams();
        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds4);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds6);
        this.aZz.setLayoutParams(layoutParams);
        this.aZX = new TextView(tbPageContext.getPageActivity());
        this.aZX.setIncludeFontPadding(false);
        this.aZX.setTextSize(0, com.baidu.adp.lib.util.k.e(tbPageContext.getPageActivity(), r.e.ds24));
        this.aZX.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.aZX.setOnClickListener(this.aZZ);
        this.aZA.addView(this.aZX, 1);
        this.aYK = new UserLikeButton(tbPageContext.getPageActivity());
        this.aYK.setId(r.g.card_god_feed_like_btn);
        this.aYK.setAfterClickListener(this.baa);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds120), com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds24);
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds36);
        this.aYK.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.aYK);
        this.aYK.setFanNumCallBack(this.aPz);
    }

    @Override // com.baidu.tieba.card.r
    public void a(com.baidu.tieba.card.data.o oVar) {
        super.onBindDataToView(oVar);
        if (oVar != null && oVar.bbU != null) {
            this.aZY = oVar;
            this.adW = oVar.bbU;
            if (oVar.bbU.getAuthor() != null) {
                gh(oVar.bbU.getAuthor().getFansNum());
                if (this.adW.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.adW.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.aYK.setVisibility(8);
                    return;
                }
                if (this.adW.getAuthor().getGodUserData().getFollowed() == 1) {
                    this.aYK.setVisibility(8);
                } else {
                    this.aYK.setVisibility(0);
                    this.aYK.setData(this.adW);
                }
                if (this.adW.getAuthor().getGodUserData().getType() == 2) {
                    this.aZw.setGodIconMargin(0);
                } else {
                    this.aZw.setGodIconMargin(-1);
                }
            }
        }
    }

    @Override // com.baidu.tieba.card.r, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.j((View) this.aZX, r.d.cp_cont_d);
            this.aYK.aK(true);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.r
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
        if (this.aYK != null) {
            this.aYK.i(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gh(int i) {
        if (this.aZX != null) {
            this.aZX.setText(String.format(this.GM.getResources().getString(r.j.fans_default_name_god_user), com.baidu.tbadk.core.util.az.w(i)));
        }
    }
}
