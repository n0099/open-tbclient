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
/* loaded from: classes2.dex */
public class d extends a {
    private bd aXU;
    private com.baidu.tbadk.core.view.userLike.c cSU;
    public TextView dIq;
    public EntelechyUserLikeButton dIr;
    private CommonUserLikeButton.a dIs;
    private View.OnClickListener dIt;
    private TbPageContext mPageContext;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.dIs = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void gC(int i) {
                d.this.nn(i);
            }
        };
        this.dIt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aXU != null && d.this.aXU.yS() != null && !StringUtils.isNull(d.this.aXU.yS().getName_show()) && !StringUtils.isNull(d.this.aXU.yS().getUserId()) && d.this.aXU.yY() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.mPageContext.getPageActivity(), d.this.aXU.yS().getUserId(), d.this.aXU.yS().getName_show(), d.this.aXU.yY(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.dIq = new TextView(tbPageContext.getPageActivity());
        this.dIq.setIncludeFontPadding(false);
        this.dIq.setTextSize(0, com.baidu.adp.lib.util.l.s(tbPageContext.getPageActivity(), d.e.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.s(tbPageContext.getPageActivity(), d.e.ds6);
        this.dIq.setLayoutParams(layoutParams);
        this.dIq.setOnClickListener(this.dIt);
        this.cjI.addView(this.dIq, 1);
        this.dIr = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.dIr.setFanNumCallBack(this.dIs);
        this.dIr.setId(d.g.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, d.g.header_divider);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds32);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds24);
        this.dIr.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.dIr);
        this.cSU = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dIr);
        this.cSU.setFromType("1");
        this.cSU.h(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: B */
    public void a(bd bdVar) {
        super.a(bdVar);
        if (bdVar != null) {
            this.aXU = bdVar;
            if (bdVar.yS() != null) {
                this.cSU.a(bdVar.yS());
                nn(bdVar.yS().getFansNum());
                if (!this.aXU.yW()) {
                    this.dIr.setVisibility(8);
                } else if (this.aXU.yS().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aXU.yS().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.dIr.setVisibility(8);
                    return;
                } else if (this.aXU.yS().getGodUserData() != null && this.aXU.yS().getGodUserData().getIsLike()) {
                    if (this.aXU.yS().getGodUserData().getIsFromNetWork()) {
                        this.dIr.setVisibility(8);
                    } else {
                        this.dIr.setVisibility(0);
                        this.dIr.f(true, 1);
                    }
                } else {
                    this.dIr.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.cjJ.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dIr.getLayoutParams();
            if (bdVar.zo() != null) {
                layoutParams.topMargin = i + com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds4);
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            aj.r(this.dIq, d.C0107d.cp_cont_d);
            this.dIr.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nn(int i) {
        if (this.dIq != null) {
            String string = this.mPageContext.getResources().getString(d.j.fans_default_name_god_user);
            if (this.aXU != null && !StringUtils.isNull(this.aXU.yY()) && this.aXU.yY().equals(this.mForumName)) {
                if (this.aXU.yW()) {
                    String format = String.format(string, am.C(i));
                    this.dIq.setVisibility(0);
                    this.dIq.setText(format);
                    return;
                }
                this.dIq.setVisibility(8);
                return;
            }
            this.dIq.setText(this.mPageContext.getResources().getString(d.j.default_personalized_name));
        }
    }
}
