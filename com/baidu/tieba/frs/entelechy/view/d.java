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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends a {
    private bh ajq;
    private com.baidu.tbadk.core.view.userLike.c bRI;
    private View.OnClickListener bSM;
    public EntelechyUserLikeButton bSP;
    public TextView cFE;
    private CommonUserLikeButton.a cFF;
    private TbPageContext mPageContext;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.cFF = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dG(int i) {
                d.this.jM(i);
            }
        };
        this.bSM = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.ajq != null && d.this.ajq.rt() != null && !StringUtils.isNull(d.this.ajq.rt().getName_show()) && !StringUtils.isNull(d.this.ajq.rt().getUserId()) && d.this.ajq.rz() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.mPageContext.getPageActivity(), d.this.ajq.rt().getUserId(), d.this.ajq.rt().getName_show(), d.this.ajq.rz(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.cFE = new TextView(tbPageContext.getPageActivity());
        this.cFE.setIncludeFontPadding(false);
        this.cFE.setTextSize(0, com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.e.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.e.ds6);
        this.cFE.setLayoutParams(layoutParams);
        this.cFE.setOnClickListener(this.bSM);
        this.boQ.addView(this.cFE, 1);
        this.bSP = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.bSP.setFanNumCallBack(this.cFF);
        this.bSP.setId(d.g.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, d.g.header_divider);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds32);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds24);
        this.bSP.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.bSP);
        this.bRI = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bSP);
        this.bRI.setFromType("1");
        this.bRI.h(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: w */
    public void a(bh bhVar) {
        super.a(bhVar);
        if (bhVar != null) {
            this.ajq = bhVar;
            if (bhVar.rt() != null) {
                this.bRI.a(bhVar.rt());
                jM(bhVar.rt().getFansNum());
                if (!this.ajq.rx()) {
                    this.bSP.setVisibility(8);
                } else if (this.ajq.rt().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.ajq.rt().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bSP.setVisibility(8);
                    return;
                } else if (this.ajq.rt().getGodUserData() != null && this.ajq.rt().getGodUserData().getIsLike()) {
                    if (this.ajq.rt().getGodUserData().getIsFromNetWork()) {
                        this.bSP.setVisibility(8);
                    } else {
                        this.bSP.setVisibility(0);
                        this.bSP.aM(true);
                    }
                } else {
                    this.bSP.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.boR.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bSP.getLayoutParams();
            if (bhVar.rP() != null) {
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
            aj.i(this.cFE, d.C0080d.cp_cont_d);
            this.bSP.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void k(BdUniqueId bdUniqueId) {
        super.k(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jM(int i) {
        if (this.cFE != null) {
            String string = this.mPageContext.getResources().getString(d.j.fans_default_name_god_user);
            if (this.ajq != null && !StringUtils.isNull(this.ajq.rz()) && this.ajq.rz().equals(this.mForumName)) {
                if (this.ajq.rx()) {
                    String format = String.format(string, am.u(i));
                    this.cFE.setVisibility(0);
                    this.cFE.setText(format);
                    return;
                }
                this.cFE.setVisibility(8);
                return;
            }
            this.cFE.setText(this.mPageContext.getResources().getString(d.j.default_personalized_name));
        }
    }
}
