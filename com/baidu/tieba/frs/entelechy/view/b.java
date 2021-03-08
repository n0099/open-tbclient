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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class b extends a {
    private cb aiB;
    private com.baidu.tbadk.core.view.userLike.c alS;
    public TextView juH;
    public EntelechyUserLikeButton juI;
    private CommonUserLikeButton.a juJ;
    private View.OnClickListener juK;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.juJ = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void qd(int i) {
                b.this.zu(i);
            }
        };
        this.juK = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aiB != null && b.this.aiB.bnS() != null && !StringUtils.isNull(b.this.aiB.bnS().getName_show()) && !StringUtils.isNull(b.this.aiB.bnS().getUserId()) && b.this.aiB.bnW() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.aiB.bnS().getUserId(), b.this.aiB.bnS().getName_show(), b.this.aiB.bnW(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.juH = new TextView(tbPageContext.getPageActivity());
        this.juH.setIncludeFontPadding(false);
        this.juH.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.juH.setLayoutParams(layoutParams);
        this.juH.setOnClickListener(this.juK);
        this.gpQ.addView(this.juH, 1);
        this.juI = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.juI.setFanNumCallBack(this.juJ);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.juI.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.juI);
        this.alS = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.juI);
        this.alS.An("1");
        this.alS.l(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.b
    public void a(cb cbVar) {
        super.a(cbVar);
        if (cbVar != null) {
            this.aiB = cbVar;
            if (cbVar.bnS() != null) {
                this.alS.a(cbVar.bnS());
                zu(cbVar.bnS().getFansNum());
                if (!this.aiB.bnV()) {
                    this.juI.setVisibility(8);
                } else if (this.aiB.bnS().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aiB.bnS().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.juI.setVisibility(8);
                    return;
                } else if (this.aiB.bnS().getGodUserData() != null && this.aiB.bnS().getGodUserData().getIsLike()) {
                    if (this.aiB.bnS().getGodUserData().getIsFromNetWork()) {
                        this.juI.setVisibility(8);
                    } else {
                        this.juI.setVisibility(0);
                        this.juI.r(true, 1);
                    }
                } else {
                    this.juI.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.hqb.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.juI.getLayoutParams();
            if (cbVar.bon() != null) {
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
            ap.setViewTextColor(this.juH, R.color.CAM_X0109);
            this.juI.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void o(BdUniqueId bdUniqueId) {
        super.o(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zu(int i) {
        if (this.juH != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.aiB != null && !StringUtils.isNull(this.aiB.bnW()) && this.aiB.bnW().equals(this.mForumName)) {
                if (this.aiB.bnV()) {
                    String format = String.format(string, au.numberUniformFormat(i));
                    this.juH.setVisibility(0);
                    this.juH.setText(format);
                    return;
                }
                this.juH.setVisibility(8);
                return;
            }
            this.juH.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
