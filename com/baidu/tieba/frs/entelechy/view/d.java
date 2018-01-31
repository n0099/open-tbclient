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
    private bd aYc;
    private com.baidu.tbadk.core.view.userLike.c cTp;
    public TextView dIL;
    public EntelechyUserLikeButton dIM;
    private CommonUserLikeButton.a dIN;
    private View.OnClickListener dIO;
    private TbPageContext mPageContext;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.dIN = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void gC(int i) {
                d.this.nn(i);
            }
        };
        this.dIO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aYc != null && d.this.aYc.yT() != null && !StringUtils.isNull(d.this.aYc.yT().getName_show()) && !StringUtils.isNull(d.this.aYc.yT().getUserId()) && d.this.aYc.yZ() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.mPageContext.getPageActivity(), d.this.aYc.yT().getUserId(), d.this.aYc.yT().getName_show(), d.this.aYc.yZ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.dIL = new TextView(tbPageContext.getPageActivity());
        this.dIL.setIncludeFontPadding(false);
        this.dIL.setTextSize(0, com.baidu.adp.lib.util.l.s(tbPageContext.getPageActivity(), d.e.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.s(tbPageContext.getPageActivity(), d.e.ds6);
        this.dIL.setLayoutParams(layoutParams);
        this.dIL.setOnClickListener(this.dIO);
        this.cjQ.addView(this.dIL, 1);
        this.dIM = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.dIM.setFanNumCallBack(this.dIN);
        this.dIM.setId(d.g.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, d.g.header_divider);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds32);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds24);
        this.dIM.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.dIM);
        this.cTp = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dIM);
        this.cTp.setFromType("1");
        this.cTp.h(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: B */
    public void a(bd bdVar) {
        super.a(bdVar);
        if (bdVar != null) {
            this.aYc = bdVar;
            if (bdVar.yT() != null) {
                this.cTp.a(bdVar.yT());
                nn(bdVar.yT().getFansNum());
                if (!this.aYc.yX()) {
                    this.dIM.setVisibility(8);
                } else if (this.aYc.yT().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aYc.yT().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.dIM.setVisibility(8);
                    return;
                } else if (this.aYc.yT().getGodUserData() != null && this.aYc.yT().getGodUserData().getIsLike()) {
                    if (this.aYc.yT().getGodUserData().getIsFromNetWork()) {
                        this.dIM.setVisibility(8);
                    } else {
                        this.dIM.setVisibility(0);
                        this.dIM.f(true, 1);
                    }
                } else {
                    this.dIM.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.cjR.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dIM.getLayoutParams();
            if (bdVar.zp() != null) {
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
            aj.r(this.dIL, d.C0108d.cp_cont_d);
            this.dIM.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nn(int i) {
        if (this.dIL != null) {
            String string = this.mPageContext.getResources().getString(d.j.fans_default_name_god_user);
            if (this.aYc != null && !StringUtils.isNull(this.aYc.yZ()) && this.aYc.yZ().equals(this.mForumName)) {
                if (this.aYc.yX()) {
                    String format = String.format(string, am.C(i));
                    this.dIL.setVisibility(0);
                    this.dIL.setText(format);
                    return;
                }
                this.dIL.setVisibility(8);
                return;
            }
            this.dIL.setText(this.mPageContext.getResources().getString(d.j.default_personalized_name));
        }
    }
}
