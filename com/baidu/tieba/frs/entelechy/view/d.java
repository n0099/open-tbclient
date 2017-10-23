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
    private bh aiU;
    private com.baidu.tbadk.core.view.userLike.c bJP;
    private View.OnClickListener bKS;
    public TextView bKV;
    public EntelechyUserLikeButton bKW;
    private CommonUserLikeButton.a bKY;
    private TbPageContext mH;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.bKY = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dG(int i) {
                d.this.hO(i);
            }
        };
        this.bKS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aiU != null && d.this.aiU.getAuthor() != null && !StringUtils.isNull(d.this.aiU.getAuthor().getName_show()) && !StringUtils.isNull(d.this.aiU.getAuthor().getUserId()) && d.this.aiU.rt() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.mH.getPageActivity(), d.this.aiU.getAuthor().getUserId(), d.this.aiU.getAuthor().getName_show(), d.this.aiU.rt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mH = tbPageContext;
        this.bKV = new TextView(tbPageContext.getPageActivity());
        this.bKV.setIncludeFontPadding(false);
        this.bKV.setTextSize(0, com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.f.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.f.ds6);
        this.bKV.setLayoutParams(layoutParams);
        this.bKV.setOnClickListener(this.bKS);
        this.bmZ.addView(this.bKV, 1);
        this.bKW = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.bKW.setFanNumCallBack(this.bKY);
        this.bKW.setId(d.h.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, d.h.header_divider);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds32);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds24);
        this.bKW.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.bKW);
        this.bJP = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bKW);
        this.bJP.setFromType("1");
        this.bJP.h(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: w */
    public void a(bh bhVar) {
        super.a(bhVar);
        if (bhVar != null) {
            this.aiU = bhVar;
            if (bhVar.getAuthor() != null) {
                this.bJP.a(bhVar.getAuthor());
                hO(bhVar.getAuthor().getFansNum());
                if (!this.aiU.rr()) {
                    this.bKW.setVisibility(8);
                } else if (this.aiU.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aiU.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bKW.setVisibility(8);
                    return;
                } else if (this.aiU.getAuthor().getGodUserData() != null && this.aiU.getAuthor().getGodUserData().getIsLike()) {
                    if (this.aiU.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.bKW.setVisibility(8);
                    } else {
                        this.bKW.setVisibility(0);
                        this.bKW.aO(true);
                    }
                } else {
                    this.bKW.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.bna.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bKW.getLayoutParams();
            if (bhVar.rJ() != null) {
                layoutParams.topMargin = i + com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds4);
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            aj.i(this.bKV, d.e.cp_cont_d);
            this.bKW.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void k(BdUniqueId bdUniqueId) {
        super.k(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hO(int i) {
        if (this.bKV != null) {
            String string = this.mH.getResources().getString(d.l.fans_default_name_god_user);
            if (this.aiU != null && !StringUtils.isNull(this.aiU.rt()) && this.aiU.rt().equals(this.mForumName)) {
                if (this.aiU.rr()) {
                    String format = String.format(string, am.u(i));
                    this.bKV.setVisibility(0);
                    this.bKV.setText(format);
                    return;
                }
                this.bKV.setVisibility(8);
                return;
            }
            this.bKV.setText(this.mH.getResources().getString(d.l.default_personalized_name));
        }
    }
}
