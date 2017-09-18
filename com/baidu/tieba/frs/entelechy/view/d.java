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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends a {
    private bj ajE;
    private com.baidu.tbadk.core.view.userLike.c bKO;
    private View.OnClickListener bLI;
    public TextView bLL;
    public EntelechyUserLikeButton bLM;
    private CommonUserLikeButton.a bLO;
    private TbPageContext mF;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.bLO = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dx(int i) {
                d.this.hH(i);
            }
        };
        this.bLI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.ajE != null && d.this.ajE.getAuthor() != null && !StringUtils.isNull(d.this.ajE.getAuthor().getName_show()) && !StringUtils.isNull(d.this.ajE.getAuthor().getUserId()) && d.this.ajE.rG() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.mF.getPageActivity(), d.this.ajE.getAuthor().getUserId(), d.this.ajE.getAuthor().getName_show(), d.this.ajE.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mF = tbPageContext;
        this.bLL = new TextView(tbPageContext.getPageActivity());
        this.bLL.setIncludeFontPadding(false);
        this.bLL.setTextSize(0, com.baidu.adp.lib.util.k.f(tbPageContext.getPageActivity(), d.f.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.baidu.adp.lib.util.k.f(tbPageContext.getPageActivity(), d.f.ds6);
        this.bLL.setLayoutParams(layoutParams);
        this.bLL.setOnClickListener(this.bLI);
        this.blC.addView(this.bLL, 1);
        this.bLM = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.bLM.setFanNumCallBack(this.bLO);
        this.bLM.setId(d.h.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, d.h.header_divider);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds32);
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds24);
        this.bLM.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.bLM);
        this.bKO = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bLM);
        this.bKO.i(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(bj bjVar) {
        super.a(bjVar);
        if (bjVar != null) {
            this.ajE = bjVar;
            if (bjVar.getAuthor() != null) {
                this.bKO.a(bjVar.getAuthor());
                hH(bjVar.getAuthor().getFansNum());
                if (!this.ajE.rE()) {
                    this.bLM.setVisibility(8);
                } else if (this.ajE.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.ajE.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bLM.setVisibility(8);
                    return;
                } else if (this.ajE.getAuthor().getGodUserData() != null && this.ajE.getAuthor().getGodUserData().getIsLike()) {
                    if (this.ajE.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.bLM.setVisibility(8);
                    } else {
                        this.bLM.setVisibility(0);
                        this.bLM.aQ(true);
                    }
                } else {
                    this.bLM.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.blD.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bLM.getLayoutParams();
            if (bjVar.rW() != null) {
                layoutParams.topMargin = i + com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds4);
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            aj.i(this.bLL, d.e.cp_cont_d);
            this.bLM.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void l(BdUniqueId bdUniqueId) {
        super.l(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hH(int i) {
        if (this.bLL != null) {
            String string = this.mF.getResources().getString(d.l.fans_default_name_god_user);
            if (this.ajE != null && !StringUtils.isNull(this.ajE.rG()) && this.ajE.rG().equals(this.mForumName)) {
                if (this.ajE.rE()) {
                    String format = String.format(string, am.u(i));
                    this.bLL.setVisibility(0);
                    this.bLL.setText(format);
                    return;
                }
                this.bLL.setVisibility(8);
                return;
            }
            this.bLL.setText(this.mF.getResources().getString(d.l.default_personalized_name));
        }
    }
}
