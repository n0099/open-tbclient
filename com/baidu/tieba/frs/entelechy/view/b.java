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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class b extends a {
    private bz aim;
    private com.baidu.tbadk.core.view.userLike.c alC;
    public TextView jrK;
    public EntelechyUserLikeButton jrL;
    private CommonUserLikeButton.a jrM;
    private View.OnClickListener jrN;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.jrM = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void rD(int i) {
                b.this.AP(i);
            }
        };
        this.jrN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aim != null && b.this.aim.brq() != null && !StringUtils.isNull(b.this.aim.brq().getName_show()) && !StringUtils.isNull(b.this.aim.brq().getUserId()) && b.this.aim.bru() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.aim.brq().getUserId(), b.this.aim.brq().getName_show(), b.this.aim.bru(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.jrK = new TextView(tbPageContext.getPageActivity());
        this.jrK.setIncludeFontPadding(false);
        this.jrK.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.jrK.setLayoutParams(layoutParams);
        this.jrK.setOnClickListener(this.jrN);
        this.gpU.addView(this.jrK, 1);
        this.jrL = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.jrL.setFanNumCallBack(this.jrM);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.jrL.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.jrL);
        this.alC = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.jrL);
        this.alC.Bb("1");
        this.alC.l(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.b
    public void a(bz bzVar) {
        super.a(bzVar);
        if (bzVar != null) {
            this.aim = bzVar;
            if (bzVar.brq() != null) {
                this.alC.a(bzVar.brq());
                AP(bzVar.brq().getFansNum());
                if (!this.aim.brt()) {
                    this.jrL.setVisibility(8);
                } else if (this.aim.brq().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aim.brq().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.jrL.setVisibility(8);
                    return;
                } else if (this.aim.brq().getGodUserData() != null && this.aim.brq().getGodUserData().getIsLike()) {
                    if (this.aim.brq().getGodUserData().getIsFromNetWork()) {
                        this.jrL.setVisibility(8);
                    } else {
                        this.jrL.setVisibility(0);
                        this.jrL.r(true, 1);
                    }
                } else {
                    this.jrL.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.hox.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jrL.getLayoutParams();
            if (bzVar.brL() != null) {
                layoutParams.topMargin = i + l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds4);
            } else {
                layoutParams.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.jrK, R.color.CAM_X0109);
            this.jrL.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void o(BdUniqueId bdUniqueId) {
        super.o(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AP(int i) {
        if (this.jrK != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.aim != null && !StringUtils.isNull(this.aim.bru()) && this.aim.bru().equals(this.mForumName)) {
                if (this.aim.brt()) {
                    String format = String.format(string, at.numberUniformFormat(i));
                    this.jrK.setVisibility(0);
                    this.jrK.setText(format);
                    return;
                }
                this.jrK.setVisibility(8);
                return;
            }
            this.jrK.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
