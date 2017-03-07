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
    private com.baidu.tbadk.core.data.bj ain;
    private TbPageContext ajF;
    private CommonUserLikeButton.a brB;
    public EntelechyUserLikeButton brE;
    private com.baidu.tbadk.core.view.userLike.c brF;
    public TextView btg;
    private View.OnClickListener bti;
    private View.OnClickListener btj;
    private com.baidu.tieba.card.data.n btl;
    private int mSkinType;

    public ap(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.brB = new aq(this);
        this.bti = new ar(this);
        this.btj = new as(this);
        this.ajF = tbPageContext;
        this.btt.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.btw.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds4);
        this.btw.setLayoutParams(layoutParams);
        this.btg = new TextView(tbPageContext.getPageActivity());
        this.btg.setId(w.h.fans_num);
        this.btg.setIncludeFontPadding(false);
        this.btg.setTextSize(0, com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds14);
        this.btg.setLayoutParams(layoutParams2);
        this.btg.setOnClickListener(this.bti);
        this.bbl.addView(this.btg, 1);
        this.brE = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.brE.setAfterOnClickListener(this.btj);
        this.brE.setFanNumCallBack(this.brB);
        this.brF = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.brE);
        this.brE.setId(w.h.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds56));
        layoutParams3.addRule(11);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds28);
        layoutParams3.topMargin = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds32);
        this.brE.setGravity(21);
        this.brE.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.brE);
    }

    @Override // com.baidu.tieba.card.au
    public void a(com.baidu.tieba.card.data.n nVar) {
        super.onBindDataToView(nVar);
        if (nVar != null && nVar.threadData != null) {
            this.btl = nVar;
            this.ain = nVar.threadData;
            if (nVar.threadData.getAuthor() != null) {
                gF(nVar.threadData.getAuthor().getFansNum());
                if (this.ain.getAuthor().getGodUserData().getIsLike()) {
                    this.brE.setVisibility(8);
                    return;
                }
                this.brE.setVisibility(0);
                this.brF.a(this.ain.getAuthor());
            }
        }
    }

    @Override // com.baidu.tieba.card.au, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.i((View) this.btg, w.e.cp_cont_d);
            this.brE.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.au
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
        this.brF.i(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gF(int i) {
        if (this.btg != null) {
            this.btg.setText(String.format(this.ajF.getResources().getString(w.l.fans_default_name_god_user), com.baidu.tbadk.core.util.au.t(i)));
        }
    }
}
