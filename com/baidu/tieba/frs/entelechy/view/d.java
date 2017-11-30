package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends a {
    private bd ajM;
    private com.baidu.tbadk.core.view.userLike.c bZG;
    public TextView cOK;
    public EntelechyUserLikeButton cOL;
    private CommonUserLikeButton.a cOM;
    private View.OnClickListener cON;
    private TbPageContext mPageContext;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.cOM = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dH(int i) {
                d.this.kk(i);
            }
        };
        this.cON = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.ajM != null && d.this.ajM.rx() != null && !StringUtils.isNull(d.this.ajM.rx().getName_show()) && !StringUtils.isNull(d.this.ajM.rx().getUserId()) && d.this.ajM.rD() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.mPageContext.getPageActivity(), d.this.ajM.rx().getUserId(), d.this.ajM.rx().getName_show(), d.this.ajM.rD(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.cOK = new TextView(tbPageContext.getPageActivity());
        this.cOK.setIncludeFontPadding(false);
        this.cOK.setTextSize(0, com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.e.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.e.ds6);
        this.cOK.setLayoutParams(layoutParams);
        this.cOK.setOnClickListener(this.cON);
        this.bvK.addView(this.cOK, 1);
        this.cOL = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.cOL.setFanNumCallBack(this.cOM);
        this.cOL.setId(d.g.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, d.g.header_divider);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds32);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds24);
        this.cOL.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.cOL);
        this.bZG = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.cOL);
        this.bZG.setFromType("1");
        this.bZG.h(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: y */
    public void a(bd bdVar) {
        super.a(bdVar);
        if (bdVar != null) {
            this.ajM = bdVar;
            if (bdVar.rx() != null) {
                this.bZG.a(bdVar.rx());
                kk(bdVar.rx().getFansNum());
                if (!this.ajM.rB()) {
                    this.cOL.setVisibility(8);
                } else if (this.ajM.rx().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.ajM.rx().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.cOL.setVisibility(8);
                    return;
                } else if (this.ajM.rx().getGodUserData() != null && this.ajM.rx().getGodUserData().getIsLike()) {
                    if (this.ajM.rx().getGodUserData().getIsFromNetWork()) {
                        this.cOL.setVisibility(8);
                    } else {
                        this.cOL.setVisibility(0);
                        this.cOL.aM(true);
                    }
                } else {
                    this.cOL.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.bvL.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cOL.getLayoutParams();
            if (bdVar.rT() != null) {
                layoutParams.topMargin = i + com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds4);
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            aj.i(this.cOK, d.C0082d.cp_cont_d);
            this.cOL.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void k(BdUniqueId bdUniqueId) {
        super.k(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kk(int i) {
        if (this.cOK != null) {
            String string = this.mPageContext.getResources().getString(d.j.fans_default_name_god_user);
            if (this.ajM != null && !StringUtils.isNull(this.ajM.rD()) && this.ajM.rD().equals(this.mForumName)) {
                if (this.ajM.rB()) {
                    String format = String.format(string, am.u(i));
                    this.cOK.setVisibility(0);
                    this.cOK.setText(format);
                    return;
                }
                this.cOK.setVisibility(8);
                return;
            }
            this.cOK.setText(this.mPageContext.getResources().getString(d.j.default_personalized_name));
        }
    }
}
