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
    public TextView hya;
    public EntelechyUserLikeButton hyb;
    private CommonUserLikeButton.a hyc;
    private View.OnClickListener hyd;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.hyc = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void mr(int i) {
                b.this.uz(i);
            }
        };
        this.hyd = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aee != null && b.this.aee.aQx() != null && !StringUtils.isNull(b.this.aee.aQx().getName_show()) && !StringUtils.isNull(b.this.aee.aQx().getUserId()) && b.this.aee.aQC() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.aee.aQx().getUserId(), b.this.aee.aQx().getName_show(), b.this.aee.aQC(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.hya = new TextView(tbPageContext.getPageActivity());
        this.hya.setIncludeFontPadding(false);
        this.hya.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.hya.setLayoutParams(layoutParams);
        this.hya.setOnClickListener(this.hyd);
        this.eTM.addView(this.hya, 1);
        this.hyb = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.hyb.setFanNumCallBack(this.hyc);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.hyb.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.hyb);
        this.agS = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.hyb);
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
                uz(bkVar.aQx().getFansNum());
                if (!this.aee.aQA()) {
                    this.hyb.setVisibility(8);
                } else if (this.aee.aQx().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aee.aQx().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.hyb.setVisibility(8);
                    return;
                } else if (this.aee.aQx().getGodUserData() != null && this.aee.aQx().getGodUserData().getIsLike()) {
                    if (this.aee.aQx().getGodUserData().getIsFromNetWork()) {
                        this.hyb.setVisibility(8);
                    } else {
                        this.hyb.setVisibility(0);
                        this.hyb.r(true, 1);
                    }
                } else {
                    this.hyb.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.fHw.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hyb.getLayoutParams();
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
            am.setViewTextColor(this.hya, (int) R.color.cp_cont_d);
            this.hyb.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void o(BdUniqueId bdUniqueId) {
        super.o(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uz(int i) {
        if (this.hya != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.aee != null && !StringUtils.isNull(this.aee.aQC()) && this.aee.aQC().equals(this.mForumName)) {
                if (this.aee.aQA()) {
                    String format = String.format(string, aq.numberUniformFormat(i));
                    this.hya.setVisibility(0);
                    this.hya.setText(format);
                    return;
                }
                this.hya.setVisibility(8);
                return;
            }
            this.hya.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
