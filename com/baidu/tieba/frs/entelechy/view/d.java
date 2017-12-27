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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends a {
    private be aXV;
    private com.baidu.tbadk.core.view.userLike.c cOt;
    public TextView dDP;
    public EntelechyUserLikeButton dDQ;
    private CommonUserLikeButton.a dDR;
    private View.OnClickListener dDS;
    private TbPageContext mPageContext;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.dDR = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void gF(int i) {
                d.this.nk(i);
            }
        };
        this.dDS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aXV != null && d.this.aXV.yX() != null && !StringUtils.isNull(d.this.aXV.yX().getName_show()) && !StringUtils.isNull(d.this.aXV.yX().getUserId()) && d.this.aXV.zd() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.mPageContext.getPageActivity(), d.this.aXV.yX().getUserId(), d.this.aXV.yX().getName_show(), d.this.aXV.zd(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.dDP = new TextView(tbPageContext.getPageActivity());
        this.dDP.setIncludeFontPadding(false);
        this.dDP.setTextSize(0, com.baidu.adp.lib.util.l.s(tbPageContext.getPageActivity(), d.e.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.s(tbPageContext.getPageActivity(), d.e.ds6);
        this.dDP.setLayoutParams(layoutParams);
        this.dDP.setOnClickListener(this.dDS);
        this.cjA.addView(this.dDP, 1);
        this.dDQ = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.dDQ.setFanNumCallBack(this.dDR);
        this.dDQ.setId(d.g.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, d.g.header_divider);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds32);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds24);
        this.dDQ.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.dDQ);
        this.cOt = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dDQ);
        this.cOt.setFromType("1");
        this.cOt.h(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: B */
    public void a(be beVar) {
        super.a(beVar);
        if (beVar != null) {
            this.aXV = beVar;
            if (beVar.yX() != null) {
                this.cOt.a(beVar.yX());
                nk(beVar.yX().getFansNum());
                if (!this.aXV.zb()) {
                    this.dDQ.setVisibility(8);
                } else if (this.aXV.yX().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aXV.yX().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.dDQ.setVisibility(8);
                    return;
                } else if (this.aXV.yX().getGodUserData() != null && this.aXV.yX().getGodUserData().getIsLike()) {
                    if (this.aXV.yX().getGodUserData().getIsFromNetWork()) {
                        this.dDQ.setVisibility(8);
                    } else {
                        this.dDQ.setVisibility(0);
                        this.dDQ.f(true, 1);
                    }
                } else {
                    this.dDQ.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.cjB.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dDQ.getLayoutParams();
            if (beVar.zt() != null) {
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
            aj.r(this.dDP, d.C0108d.cp_cont_d);
            this.dDQ.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nk(int i) {
        if (this.dDP != null) {
            String string = this.mPageContext.getResources().getString(d.j.fans_default_name_god_user);
            if (this.aXV != null && !StringUtils.isNull(this.aXV.zd()) && this.aXV.zd().equals(this.mForumName)) {
                if (this.aXV.zb()) {
                    String format = String.format(string, am.C(i));
                    this.dDP.setVisibility(0);
                    this.dDP.setText(format);
                    return;
                }
                this.dDP.setVisibility(8);
                return;
            }
            this.dDP.setText(this.mPageContext.getResources().getString(d.j.default_personalized_name));
        }
    }
}
