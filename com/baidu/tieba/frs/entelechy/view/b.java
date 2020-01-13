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
/* loaded from: classes7.dex */
public class b extends a {
    private bj Kn;
    private com.baidu.tbadk.core.view.userLike.c Nb;
    public TextView gwm;
    public EntelechyUserLikeButton gwn;
    private CommonUserLikeButton.a gwo;
    private View.OnClickListener gwp;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.gwo = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void lh(int i) {
                b.this.ti(i);
            }
        };
        this.gwp = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.Kn != null && b.this.Kn.azX() != null && !StringUtils.isNull(b.this.Kn.azX().getName_show()) && !StringUtils.isNull(b.this.Kn.azX().getUserId()) && b.this.Kn.aAc() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.Kn.azX().getUserId(), b.this.Kn.azX().getName_show(), b.this.Kn.aAc(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.gwm = new TextView(tbPageContext.getPageActivity());
        this.gwm.setIncludeFontPadding(false);
        this.gwm.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.gwm.setLayoutParams(layoutParams);
        this.gwm.setOnClickListener(this.gwp);
        this.ecC.addView(this.gwm, 1);
        this.gwn = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.gwn.setFanNumCallBack(this.gwo);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.gwn.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.gwn);
        this.Nb = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.gwn);
        this.Nb.sn("1");
        this.Nb.j(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void a(bj bjVar) {
        super.a(bjVar);
        if (bjVar != null) {
            this.Kn = bjVar;
            if (bjVar.azX() != null) {
                this.Nb.a(bjVar.azX());
                ti(bjVar.azX().getFansNum());
                if (!this.Kn.aAa()) {
                    this.gwn.setVisibility(8);
                } else if (this.Kn.azX().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.Kn.azX().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.gwn.setVisibility(8);
                    return;
                } else if (this.Kn.azX().getGodUserData() != null && this.Kn.azX().getGodUserData().getIsLike()) {
                    if (this.Kn.azX().getGodUserData().getIsFromNetWork()) {
                        this.gwn.setVisibility(8);
                    } else {
                        this.gwn.setVisibility(0);
                        this.gwn.l(true, 1);
                    }
                } else {
                    this.gwn.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.eKp.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gwn.getLayoutParams();
            if (bjVar.aAs() != null) {
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
            am.setViewTextColor(this.gwm, (int) R.color.cp_cont_d);
            this.gwn.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void m(BdUniqueId bdUniqueId) {
        super.m(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ti(int i) {
        if (this.gwm != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.Kn != null && !StringUtils.isNull(this.Kn.aAc()) && this.Kn.aAc().equals(this.mForumName)) {
                if (this.Kn.aAa()) {
                    String format = String.format(string, aq.numberUniformFormat(i));
                    this.gwm.setVisibility(0);
                    this.gwm.setText(format);
                    return;
                }
                this.gwm.setVisibility(8);
                return;
            }
            this.gwm.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
