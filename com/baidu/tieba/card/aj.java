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
public class aj extends ao {
    private TbPageContext GO;
    private com.baidu.tbadk.core.view.userLike.c aRC;
    private CommonUserLikeButton.a aRG;
    private com.baidu.tbadk.core.data.bk aeu;
    public EntelechyUserLikeButton bbT;
    public TextView bdf;
    private View.OnClickListener bdh;
    private View.OnClickListener bdi;
    private com.baidu.tieba.card.data.m bdk;
    private int mSkinType;

    public aj(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aRG = new ak(this);
        this.bdh = new al(this);
        this.bdi = new am(this);
        this.GO = tbPageContext;
        this.bdr.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdu.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds4);
        this.bdu.setLayoutParams(layoutParams);
        this.bdf = new TextView(tbPageContext.getPageActivity());
        this.bdf.setId(r.g.fans_num);
        this.bdf.setIncludeFontPadding(false);
        this.bdf.setTextSize(0, com.baidu.adp.lib.util.k.e(tbPageContext.getPageActivity(), r.e.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.e(tbPageContext.getPageActivity(), r.e.ds14);
        this.bdf.setLayoutParams(layoutParams2);
        this.bdf.setOnClickListener(this.bdh);
        this.bcK.addView(this.bdf, 1);
        this.bbT = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.bbT.setAfterOnClickListener(this.bdi);
        this.bbT.setFanNumCallBack(this.aRG);
        this.aRC = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bbT);
        this.bbT.setId(r.g.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds56));
        layoutParams3.addRule(11);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds28);
        layoutParams3.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds32);
        this.bbT.setGravity(21);
        this.bbT.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.bbT);
    }

    @Override // com.baidu.tieba.card.ao
    public void a(com.baidu.tieba.card.data.m mVar) {
        super.onBindDataToView(mVar);
        if (mVar != null && mVar.threadData != null) {
            this.bdk = mVar;
            this.aeu = mVar.threadData;
            if (mVar.threadData.getAuthor() != null) {
                gh(mVar.threadData.getAuthor().getFansNum());
                if (this.aeu.getAuthor().getGodUserData().getIsLike()) {
                    this.bbT.setVisibility(8);
                    return;
                }
                this.bbT.setVisibility(0);
                this.aRC.a(this.aeu.getAuthor());
            }
        }
    }

    @Override // com.baidu.tieba.card.ao, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.j((View) this.bdf, r.d.cp_cont_d);
            this.bbT.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.ao
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
        this.aRC.i(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gh(int i) {
        if (this.bdf != null) {
            this.bdf.setText(String.format(this.GO.getResources().getString(r.j.fans_default_name_god_user), com.baidu.tbadk.core.util.ax.v(i)));
        }
    }
}
