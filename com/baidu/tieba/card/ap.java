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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ap extends au {
    private com.baidu.tbadk.core.data.bi aiB;
    private TbPageContext ajT;
    private CommonUserLikeButton.a brt;
    public EntelechyUserLikeButton brw;
    private com.baidu.tbadk.core.view.userLike.c brx;
    public TextView bsY;
    private View.OnClickListener bta;
    private View.OnClickListener btb;
    private com.baidu.tieba.card.data.n btd;
    private int mSkinType;

    public ap(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.brt = new aq(this);
        this.bta = new ar(this);
        this.btb = new as(this);
        this.ajT = tbPageContext;
        this.btk.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bto.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds4);
        this.bto.setLayoutParams(layoutParams);
        this.bsY = new TextView(tbPageContext.getPageActivity());
        this.bsY.setId(w.h.fans_num);
        this.bsY.setIncludeFontPadding(false);
        this.bsY.setTextSize(0, com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds14);
        this.bsY.setLayoutParams(layoutParams2);
        this.bsY.setOnClickListener(this.bta);
        this.bbe.addView(this.bsY, 1);
        this.brw = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.brw.setAfterOnClickListener(this.btb);
        this.brw.setFanNumCallBack(this.brt);
        this.brx = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.brw);
        this.brw.setId(w.h.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds56));
        layoutParams3.addRule(11);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds28);
        layoutParams3.topMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds32);
        this.brw.setGravity(21);
        this.brw.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.brw);
    }

    @Override // com.baidu.tieba.card.au
    public void a(com.baidu.tieba.card.data.n nVar) {
        super.onBindDataToView(nVar);
        if (nVar != null && nVar.threadData != null) {
            this.btd = nVar;
            this.aiB = nVar.threadData;
            if (nVar.threadData.getAuthor() != null) {
                gI(nVar.threadData.getAuthor().getFansNum());
                if (this.aiB.getAuthor().getGodUserData().getIsLike()) {
                    this.brw.setVisibility(8);
                    return;
                }
                this.brw.setVisibility(0);
                this.brx.a(this.aiB.getAuthor());
            }
        }
    }

    @Override // com.baidu.tieba.card.au, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.i(this.bsY, w.e.cp_cont_d);
            this.brw.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.au
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
        this.brx.i(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gI(int i) {
        if (this.bsY != null) {
            this.bsY.setText(String.format(this.ajT.getResources().getString(w.l.fans_default_name_god_user), com.baidu.tbadk.core.util.au.t(i)));
        }
    }
}
