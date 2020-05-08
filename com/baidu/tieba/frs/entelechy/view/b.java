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
/* loaded from: classes9.dex */
public class b extends a {
    private bj adJ;
    private com.baidu.tbadk.core.view.userLike.c agp;
    public TextView hjb;
    public EntelechyUserLikeButton hjc;
    private CommonUserLikeButton.a hjd;
    private View.OnClickListener hje;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.hjd = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void lM(int i) {
                b.this.tS(i);
            }
        };
        this.hje = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.adJ != null && b.this.adJ.aKC() != null && !StringUtils.isNull(b.this.adJ.aKC().getName_show()) && !StringUtils.isNull(b.this.adJ.aKC().getUserId()) && b.this.adJ.aKH() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.adJ.aKC().getUserId(), b.this.adJ.aKC().getName_show(), b.this.adJ.aKH(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.hjb = new TextView(tbPageContext.getPageActivity());
        this.hjb.setIncludeFontPadding(false);
        this.hjb.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.hjb.setLayoutParams(layoutParams);
        this.hjb.setOnClickListener(this.hje);
        this.eHe.addView(this.hjb, 1);
        this.hjc = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.hjc.setFanNumCallBack(this.hjd);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.hjc.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.hjc);
        this.agp = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.hjc);
        this.agp.tU("1");
        this.agp.j(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void a(bj bjVar) {
        super.a(bjVar);
        if (bjVar != null) {
            this.adJ = bjVar;
            if (bjVar.aKC() != null) {
                this.agp.a(bjVar.aKC());
                tS(bjVar.aKC().getFansNum());
                if (!this.adJ.aKF()) {
                    this.hjc.setVisibility(8);
                } else if (this.adJ.aKC().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.adJ.aKC().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.hjc.setVisibility(8);
                    return;
                } else if (this.adJ.aKC().getGodUserData() != null && this.adJ.aKC().getGodUserData().getIsLike()) {
                    if (this.adJ.aKC().getGodUserData().getIsFromNetWork()) {
                        this.hjc.setVisibility(8);
                    } else {
                        this.hjc.setVisibility(0);
                        this.hjc.n(true, 1);
                    }
                } else {
                    this.hjc.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.ftt.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hjc.getLayoutParams();
            if (bjVar.aKX() != null) {
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
            am.setViewTextColor(this.hjb, (int) R.color.cp_cont_d);
            this.hjc.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void m(BdUniqueId bdUniqueId) {
        super.m(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tS(int i) {
        if (this.hjb != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.adJ != null && !StringUtils.isNull(this.adJ.aKH()) && this.adJ.aKH().equals(this.mForumName)) {
                if (this.adJ.aKF()) {
                    String format = String.format(string, aq.numberUniformFormat(i));
                    this.hjb.setVisibility(0);
                    this.hjb.setText(format);
                    return;
                }
                this.hjb.setVisibility(8);
                return;
            }
            this.hjb.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
