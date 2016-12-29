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
public class ah extends t {
    private TbPageContext GO;
    private com.baidu.tbadk.core.view.userLike.c aQT;
    private CommonUserLikeButton.a aQX;
    private com.baidu.tbadk.core.data.bg adN;
    public EntelechyUserLikeButton baZ;
    private View.OnClickListener bcA;
    public TextView bcx;
    private com.baidu.tieba.card.data.o bcy;
    private View.OnClickListener bcz;
    private int mSkinType;

    public ah(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aQX = new ai(this);
        this.bcz = new aj(this);
        this.bcA = new ak(this);
        Ov();
        this.GO = tbPageContext;
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
        this.aQT = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.baZ);
        this.baZ.setFanNumCallBack(this.aQX);
        this.baZ.setAfterOnClickListener(this.bcA);
        this.baZ.setId(r.g.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds28);
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds32);
        this.baZ.setGravity(21);
        this.baZ.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.baZ);
    }

    @Override // com.baidu.tieba.card.t
    public void a(com.baidu.tieba.card.data.o oVar) {
        super.onBindDataToView(oVar);
        if (oVar != null && oVar.beB != null) {
            this.bcy = oVar;
            this.adN = oVar.beB;
            oVar.sourceType = 0;
            if (oVar.beB.getAuthor() != null) {
                gg(oVar.beB.getAuthor().getFansNum());
                if (this.adN.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.adN.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.baZ.setVisibility(8);
                    return;
                }
                if (this.adN.getAuthor().getGodUserData().getIsLike()) {
                    this.baZ.setVisibility(8);
                } else {
                    this.baZ.setVisibility(0);
                    this.aQT.a(this.adN.getAuthor());
                }
                if (this.adN.getAuthor().getGodUserData().getType() == 2) {
                    this.bbY.setGodIconMargin(0);
                } else {
                    this.bbY.setGodIconMargin(-1);
                }
            }
        }
    }

    @Override // com.baidu.tieba.card.t, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ar.j((View) this.bcx, r.d.cp_cont_d);
            this.baZ.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.t
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
        this.aQT.i(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gg(int i) {
        if (this.bcx != null) {
            this.bcx.setText(String.format(this.GO.getResources().getString(r.j.fans_default_name_god_user), com.baidu.tbadk.core.util.av.v(i)));
        }
    }
}
