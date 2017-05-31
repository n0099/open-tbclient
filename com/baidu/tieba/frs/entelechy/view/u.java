package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class u extends a {
    private bl ahM;
    private TbPageContext ajh;
    private com.baidu.tbadk.core.view.userLike.c bAk;
    private View.OnClickListener bBd;
    public TextView bBg;
    public EntelechyUserLikeButton bBh;
    private CommonUserLikeButton.a bBj;
    private int mSkinType;

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.bBj = new v(this);
        this.bBd = new w(this);
        this.ajh = tbPageContext;
        this.bBg = new TextView(tbPageContext.getPageActivity());
        this.bBg.setIncludeFontPadding(false);
        this.bBg.setTextSize(0, com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds6);
        this.bBg.setLayoutParams(layoutParams);
        this.bBg.setOnClickListener(this.bBd);
        this.bdK.addView(this.bBg, 1);
        this.bBh = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.bBh.setFanNumCallBack(this.bBj);
        this.bBh.setId(w.h.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, w.h.header_divider);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds32);
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds24);
        this.bBh.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.bBh);
        this.bAk = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bBh);
        this.bAk.i(bdUniqueId);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void r(bl blVar) {
        super.a(blVar);
        if (blVar != null) {
            this.ahM = blVar;
            if (blVar.getAuthor() != null) {
                this.bAk.a(blVar.getAuthor());
                hj(blVar.getAuthor().getFansNum());
                if (!this.ahM.rx()) {
                    this.bBh.setVisibility(8);
                } else if (this.ahM.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.ahM.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bBh.setVisibility(8);
                    return;
                } else if (this.ahM.getAuthor().getGodUserData() != null && this.ahM.getAuthor().getGodUserData().getIsLike()) {
                    if (this.ahM.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.bBh.setVisibility(8);
                    } else {
                        this.bBh.setVisibility(0);
                        this.bBh.aO(true);
                    }
                } else {
                    this.bBh.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.bdL.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bBh.getLayoutParams();
            if (blVar.rP() != null) {
                layoutParams.topMargin = i + com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds4);
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.i(this.bBg, w.e.cp_cont_d);
            this.bBh.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hj(int i) {
        if (this.bBg != null) {
            String string = this.ajh.getResources().getString(w.l.fans_default_name_god_user);
            if (this.ahM != null && !StringUtils.isNull(this.ahM.rz()) && this.ahM.rz().equals(this.mForumName)) {
                if (this.ahM.rx()) {
                    String format = String.format(string, com.baidu.tbadk.core.util.au.t(i));
                    this.bBg.setVisibility(0);
                    this.bBg.setText(format);
                    return;
                }
                this.bBg.setVisibility(8);
                return;
            }
            this.bBg.setText(this.ajh.getResources().getString(w.l.default_personalized_name));
        }
    }
}
