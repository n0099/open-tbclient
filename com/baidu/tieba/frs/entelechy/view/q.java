package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.UserLikeButton;
import com.baidu.tieba.u;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class q extends u {
    private TbPageContext Ea;
    private UserLikeButton.a aIT;
    public UserLikeButton aSe;
    private View.OnClickListener aTB;
    private View.OnClickListener aTC;
    public TextView aTz;
    private az aas;
    private int mSkinType;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aIT = new r(this);
        this.aTB = new s(this);
        this.aTC = new t(this);
        this.Ea = tbPageContext;
        this.aTK.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aTM.getLayoutParams();
        layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds4);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds6);
        this.aTM.setLayoutParams(layoutParams);
        this.aTz = new TextView(tbPageContext.getPageActivity());
        this.aTz.setId(u.g.fans_num);
        this.aTz.setIncludeFontPadding(false);
        this.aTz.setTextSize(0, com.baidu.adp.lib.util.k.c(tbPageContext.getPageActivity(), u.e.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.c(tbPageContext.getPageActivity(), u.e.ds14);
        this.aTz.setLayoutParams(layoutParams2);
        this.aTz.setOnClickListener(this.aTB);
        this.aTc.addView(this.aTz, 1);
        this.aSe = new UserLikeButton(tbPageContext.getPageActivity());
        this.aSe.setId(u.g.card_god_feed_like_btn);
        this.aSe.setAfterClickListener(this.aTC);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds120), com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds56));
        layoutParams3.addRule(11);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds24);
        layoutParams3.topMargin = com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds36);
        this.aSe.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.aSe);
        this.aSe.setFanNumCallBack(this.aIT);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.u
    public void h(az azVar) {
        super.h(azVar);
        if (azVar != null) {
            this.aas = azVar;
            if (azVar.getAuthor() != null) {
                fF(azVar.getAuthor().getFansNum());
                if (this.aas.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aas.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.aSe.setVisibility(8);
                    return;
                } else if (this.aas.getAuthor().getGodUserData().getFollowed() == 1) {
                    if (this.aas.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.aSe.setVisibility(8);
                    } else {
                        this.aSe.aG(true);
                    }
                } else {
                    this.aSe.setVisibility(0);
                    this.aSe.setData(this.aas);
                }
            }
            SkinInfo qZ = azVar.qZ();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aTK.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aTc.getLayoutParams();
            if (qZ != null) {
                this.bGc.a(this.Ea, qZ, com.baidu.tieba.tbadkCore.d.a.a("FRS", "c0131", String.valueOf(azVar.getFid()), azVar.getForum_name(), azVar.getTid(), null));
                layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds16);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds16);
            } else {
                this.bGc.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds30);
            }
            this.aTK.setLayoutParams(layoutParams);
            this.aTc.setLayoutParams(layoutParams2);
            int i = ((RelativeLayout.LayoutParams) this.bGc.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.aSe.getLayoutParams();
            if (azVar.qZ() != null) {
                layoutParams3.topMargin = i + com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds16);
            } else {
                layoutParams3.topMargin = com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds36);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.u
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            av.j((View) this.aTz, u.d.cp_cont_d);
            this.aSe.aG(true);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.u
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
        if (this.aSe != null) {
            this.aSe.i(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fF(int i) {
        if (this.aTz != null) {
            this.aTz.setText(String.format(this.Ea.getResources().getString(u.j.fans_default_name_god_user), ba.B(i)));
        }
    }
}
