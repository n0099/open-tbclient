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
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class u extends a {
    private bm aiu;
    private TbPageContext ajP;
    private View.OnClickListener bBW;
    public TextView bBZ;
    private com.baidu.tbadk.core.view.userLike.c bBd;
    public EntelechyUserLikeButton bCa;
    private CommonUserLikeButton.a bCc;
    private int mSkinType;

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.bCc = new v(this);
        this.bBW = new w(this);
        this.ajP = tbPageContext;
        this.bBZ = new TextView(tbPageContext.getPageActivity());
        this.bBZ.setIncludeFontPadding(false);
        this.bBZ.setTextSize(0, com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds6);
        this.bBZ.setLayoutParams(layoutParams);
        this.bBZ.setOnClickListener(this.bBW);
        this.bgH.addView(this.bBZ, 1);
        this.bCa = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.bCa.setFanNumCallBack(this.bCc);
        this.bCa.setId(w.h.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, w.h.header_divider);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds32);
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds24);
        this.bCa.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.bCa);
        this.bBd = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bCa);
        this.bBd.i(bdUniqueId);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void t(bm bmVar) {
        super.a(bmVar);
        if (bmVar != null) {
            this.aiu = bmVar;
            if (bmVar.getAuthor() != null) {
                this.bBd.a(bmVar.getAuthor());
                hm(bmVar.getAuthor().getFansNum());
                if (!this.aiu.ru()) {
                    this.bCa.setVisibility(8);
                } else if (this.aiu.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aiu.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bCa.setVisibility(8);
                    return;
                } else if (this.aiu.getAuthor().getGodUserData() != null && this.aiu.getAuthor().getGodUserData().getIsLike()) {
                    if (this.aiu.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.bCa.setVisibility(8);
                    } else {
                        this.bCa.setVisibility(0);
                        this.bCa.aP(true);
                    }
                } else {
                    this.bCa.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.bgI.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bCa.getLayoutParams();
            if (bmVar.rM() != null) {
                layoutParams.topMargin = i + com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds4);
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.as.i(this.bBZ, w.e.cp_cont_d);
            this.bCa.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hm(int i) {
        if (this.bBZ != null) {
            String string = this.ajP.getResources().getString(w.l.fans_default_name_god_user);
            if (this.aiu != null && !StringUtils.isNull(this.aiu.rw()) && this.aiu.rw().equals(this.mForumName)) {
                if (this.aiu.ru()) {
                    String format = String.format(string, com.baidu.tbadk.core.util.aw.t(i));
                    this.bBZ.setVisibility(0);
                    this.bBZ.setText(format);
                    return;
                }
                this.bBZ.setVisibility(8);
                return;
            }
            this.bBZ.setText(this.ajP.getResources().getString(w.l.default_personalized_name));
        }
    }
}
