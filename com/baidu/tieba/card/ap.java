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
    private com.baidu.tbadk.core.data.bi aiC;
    private TbPageContext ajU;
    private CommonUserLikeButton.a btL;
    public EntelechyUserLikeButton btO;
    private com.baidu.tbadk.core.view.userLike.c btP;
    public TextView bvr;
    private View.OnClickListener bvt;
    private View.OnClickListener bvu;
    private com.baidu.tieba.card.data.n bvw;
    private int mSkinType;

    public ap(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.btL = new aq(this);
        this.bvt = new ar(this);
        this.bvu = new as(this);
        this.ajU = tbPageContext;
        this.bvD.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvG.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds4);
        this.bvG.setLayoutParams(layoutParams);
        this.bvr = new TextView(tbPageContext.getPageActivity());
        this.bvr.setId(w.h.fans_num);
        this.bvr.setIncludeFontPadding(false);
        this.bvr.setTextSize(0, com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds14);
        this.bvr.setLayoutParams(layoutParams2);
        this.bvr.setOnClickListener(this.bvt);
        this.bca.addView(this.bvr, 1);
        this.btO = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.btO.setAfterOnClickListener(this.bvu);
        this.btO.setFanNumCallBack(this.btL);
        this.btP = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.btO);
        this.btO.setId(w.h.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds56));
        layoutParams3.addRule(11);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds28);
        layoutParams3.topMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds32);
        this.btO.setGravity(21);
        this.btO.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.btO);
    }

    @Override // com.baidu.tieba.card.au
    public void a(com.baidu.tieba.card.data.n nVar) {
        super.onBindDataToView(nVar);
        if (nVar != null && nVar.threadData != null) {
            this.bvw = nVar;
            this.aiC = nVar.threadData;
            if (nVar.threadData.getAuthor() != null) {
                gO(nVar.threadData.getAuthor().getFansNum());
                if (this.aiC.getAuthor().getGodUserData().getIsLike()) {
                    this.btO.setVisibility(8);
                    return;
                }
                this.btO.setVisibility(0);
                this.btP.a(this.aiC.getAuthor());
            }
        }
    }

    @Override // com.baidu.tieba.card.au, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.i(this.bvr, w.e.cp_cont_d);
            this.btO.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.au
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
        this.btP.i(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gO(int i) {
        if (this.bvr != null) {
            this.bvr.setText(String.format(this.ajU.getResources().getString(w.l.fans_default_name_god_user), com.baidu.tbadk.core.util.au.t(i)));
        }
    }
}
