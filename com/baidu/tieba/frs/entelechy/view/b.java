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
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class b extends a {
    private bj Ki;
    private com.baidu.tbadk.core.view.userLike.c MX;
    public TextView gtd;
    public EntelechyUserLikeButton gte;
    private CommonUserLikeButton.a gtf;
    private View.OnClickListener gtg;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.gtf = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void lh(int i) {
                b.this.td(i);
            }
        };
        this.gtg = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.Ki != null && b.this.Ki.azE() != null && !StringUtils.isNull(b.this.Ki.azE().getName_show()) && !StringUtils.isNull(b.this.Ki.azE().getUserId()) && b.this.Ki.azJ() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.Ki.azE().getUserId(), b.this.Ki.azE().getName_show(), b.this.Ki.azJ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.gtd = new TextView(tbPageContext.getPageActivity());
        this.gtd.setIncludeFontPadding(false);
        this.gtd.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.gtd.setLayoutParams(layoutParams);
        this.gtd.setOnClickListener(this.gtg);
        this.ect.addView(this.gtd, 1);
        this.gte = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.gte.setFanNumCallBack(this.gtf);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.gte.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.gte);
        this.MX = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.gte);
        this.MX.sk("1");
        this.MX.j(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void a(bj bjVar) {
        super.a(bjVar);
        if (bjVar != null) {
            this.Ki = bjVar;
            if (bjVar.azE() != null) {
                this.MX.a(bjVar.azE());
                td(bjVar.azE().getFansNum());
                if (!this.Ki.azH()) {
                    this.gte.setVisibility(8);
                } else if (this.Ki.azE().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.Ki.azE().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.gte.setVisibility(8);
                    return;
                } else if (this.Ki.azE().getGodUserData() != null && this.Ki.azE().getGodUserData().getIsLike()) {
                    if (this.Ki.azE().getGodUserData().getIsFromNetWork()) {
                        this.gte.setVisibility(8);
                    } else {
                        this.gte.setVisibility(0);
                        this.gte.k(true, 1);
                    }
                } else {
                    this.gte.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.eJf.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gte.getLayoutParams();
            if (bjVar.azZ() != null) {
                layoutParams.topMargin = i + l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds4);
            } else {
                layoutParams.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            am.setViewTextColor(this.gtd, (int) R.color.cp_cont_d);
            this.gte.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void m(BdUniqueId bdUniqueId) {
        super.m(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void td(int i) {
        if (this.gtd != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.Ki != null && !StringUtils.isNull(this.Ki.azJ()) && this.Ki.azJ().equals(this.mForumName)) {
                if (this.Ki.azH()) {
                    String format = String.format(string, aq.numberUniformFormat(i));
                    this.gtd.setVisibility(0);
                    this.gtd.setText(format);
                    return;
                }
                this.gtd.setVisibility(8);
                return;
            }
            this.gtd.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
