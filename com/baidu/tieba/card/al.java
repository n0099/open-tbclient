package com.baidu.tieba.card;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class al extends aq {
    private TbPageContext GO;
    private com.baidu.tbadk.core.view.userLike.c aQT;
    private CommonUserLikeButton.a aQX;
    private com.baidu.tbadk.core.data.bg adN;
    public EntelechyUserLikeButton baZ;
    private View.OnClickListener bcA;
    private com.baidu.tieba.card.data.m bcC;
    public TextView bcx;
    private View.OnClickListener bcz;
    private int mSkinType;

    public al(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aQX = new am(this);
        this.bcz = new an(this);
        this.bcA = new ao(this);
        this.GO = tbPageContext;
        this.bcJ.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcM.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds4);
        this.bcM.setLayoutParams(layoutParams);
        this.bcx = new TextView(tbPageContext.getPageActivity());
        this.bcx.setId(r.g.fans_num);
        this.bcx.setIncludeFontPadding(false);
        this.bcx.setTextSize(0, com.baidu.adp.lib.util.k.e(tbPageContext.getPageActivity(), r.e.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.e(tbPageContext.getPageActivity(), r.e.ds14);
        this.bcx.setLayoutParams(layoutParams2);
        this.bcx.setOnClickListener(this.bcz);
        this.bcd.addView(this.bcx, 1);
        this.baZ = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.baZ.setAfterOnClickListener(this.bcA);
        this.baZ.setFanNumCallBack(this.aQX);
        this.aQT = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.baZ);
        this.baZ.setId(r.g.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds56));
        layoutParams3.addRule(11);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds28);
        layoutParams3.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds32);
        this.baZ.setGravity(21);
        this.baZ.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.baZ);
    }

    @Override // com.baidu.tieba.card.aq
    public void a(com.baidu.tieba.card.data.m mVar) {
        super.onBindDataToView(mVar);
        if (mVar != null && mVar.threadData != null) {
            this.bcC = mVar;
            this.adN = mVar.threadData;
            if (mVar.threadData.getAuthor() != null) {
                gg(mVar.threadData.getAuthor().getFansNum());
                if (this.adN.getAuthor().getGodUserData().getIsLike()) {
                    this.baZ.setVisibility(8);
                    return;
                }
                this.baZ.setVisibility(0);
                this.aQT.a(this.adN.getAuthor());
            }
        }
    }

    @Override // com.baidu.tieba.card.aq, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ar.j((View) this.bcx, r.d.cp_cont_d);
            this.baZ.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.aq
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
