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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b extends a {
    private bk aee;
    private com.baidu.tbadk.core.view.userLike.c agS;
    public TextView hxP;
    public EntelechyUserLikeButton hxQ;
    private CommonUserLikeButton.a hxR;
    private View.OnClickListener hxS;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.hxR = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void mp(int i) {
                b.this.ux(i);
            }
        };
        this.hxS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aee != null && b.this.aee.aQx() != null && !StringUtils.isNull(b.this.aee.aQx().getName_show()) && !StringUtils.isNull(b.this.aee.aQx().getUserId()) && b.this.aee.aQC() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.aee.aQx().getUserId(), b.this.aee.aQx().getName_show(), b.this.aee.aQC(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.hxP = new TextView(tbPageContext.getPageActivity());
        this.hxP.setIncludeFontPadding(false);
        this.hxP.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.hxP.setLayoutParams(layoutParams);
        this.hxP.setOnClickListener(this.hxS);
        this.eTB.addView(this.hxP, 1);
        this.hxQ = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.hxQ.setFanNumCallBack(this.hxR);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.hxQ.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.hxQ);
        this.agS = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.hxQ);
        this.agS.vA("1");
        this.agS.l(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.b
    public void a(bk bkVar) {
        super.a(bkVar);
        if (bkVar != null) {
            this.aee = bkVar;
            if (bkVar.aQx() != null) {
                this.agS.a(bkVar.aQx());
                ux(bkVar.aQx().getFansNum());
                if (!this.aee.aQA()) {
                    this.hxQ.setVisibility(8);
                } else if (this.aee.aQx().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aee.aQx().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.hxQ.setVisibility(8);
                    return;
                } else if (this.aee.aQx().getGodUserData() != null && this.aee.aQx().getGodUserData().getIsLike()) {
                    if (this.aee.aQx().getGodUserData().getIsFromNetWork()) {
                        this.hxQ.setVisibility(8);
                    } else {
                        this.hxQ.setVisibility(0);
                        this.hxQ.r(true, 1);
                    }
                } else {
                    this.hxQ.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.fHl.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hxQ.getLayoutParams();
            if (bkVar.aQU() != null) {
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
            am.setViewTextColor(this.hxP, (int) R.color.cp_cont_d);
            this.hxQ.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void o(BdUniqueId bdUniqueId) {
        super.o(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ux(int i) {
        if (this.hxP != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.aee != null && !StringUtils.isNull(this.aee.aQC()) && this.aee.aQC().equals(this.mForumName)) {
                if (this.aee.aQA()) {
                    String format = String.format(string, aq.numberUniformFormat(i));
                    this.hxP.setVisibility(0);
                    this.hxP.setText(format);
                    return;
                }
                this.hxP.setVisibility(8);
                return;
            }
            this.hxP.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
