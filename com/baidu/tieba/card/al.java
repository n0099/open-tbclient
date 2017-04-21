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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class al extends x {
    private com.baidu.tbadk.core.data.bi aiC;
    private TbPageContext ajU;
    private CommonUserLikeButton.a btL;
    public EntelechyUserLikeButton btO;
    private com.baidu.tbadk.core.view.userLike.c btP;
    public TextView bvr;
    private com.baidu.tieba.card.data.p bvs;
    private View.OnClickListener bvt;
    private View.OnClickListener bvu;
    private int mSkinType;

    public al(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.btL = new am(this);
        this.bvt = new an(this);
        this.bvu = new ao(this);
        TK();
        this.ajU = tbPageContext;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbZ.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds4);
        this.bbZ.setLayoutParams(layoutParams);
        this.bvr = new TextView(tbPageContext.getPageActivity());
        this.bvr.setIncludeFontPadding(false);
        this.bvr.setTextSize(0, com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds24));
        this.bvr.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.bvr.setOnClickListener(this.bvt);
        this.bca.addView(this.bvr, 1);
        this.btO = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.btP = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.btO);
        this.btO.setFanNumCallBack(this.btL);
        this.btO.setAfterOnClickListener(this.bvu);
        this.btO.setId(w.h.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds56));
        layoutParams2.addRule(11);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds28);
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds32);
        this.btO.setGravity(21);
        this.btO.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.btO);
    }

    @Override // com.baidu.tieba.card.x
    public void a(com.baidu.tieba.card.data.p pVar) {
        super.onBindDataToView(pVar);
        if (pVar != null && pVar.bck != null) {
            this.bvs = pVar;
            this.aiC = pVar.bck;
            pVar.sourceType = 0;
            if (pVar.bck.getAuthor() != null) {
                gO(pVar.bck.getAuthor().getFansNum());
                if (this.aiC.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aiC.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.btO.setVisibility(8);
                    return;
                }
                if (this.aiC.getAuthor().getGodUserData().getIsLike()) {
                    this.btO.setVisibility(8);
                } else {
                    this.btO.setVisibility(0);
                    this.btP.a(this.aiC.getAuthor());
                }
                if (this.aiC.getAuthor().getGodUserData().getType() == 2) {
                    this.bbV.setGodIconMargin(0);
                } else {
                    this.bbV.setGodIconMargin(-1);
                }
            }
        }
    }

    @Override // com.baidu.tieba.card.x, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.i(this.bvr, w.e.cp_cont_d);
            this.btO.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.x
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
