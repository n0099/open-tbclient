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
    private bj KJ;
    private com.baidu.tbadk.core.view.userLike.c NB;
    public TextView gyB;
    public EntelechyUserLikeButton gyC;
    private CommonUserLikeButton.a gyD;
    private View.OnClickListener gyE;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.gyD = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void ly(int i) {
                b.this.to(i);
            }
        };
        this.gyE = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.KJ != null && b.this.KJ.aCo() != null && !StringUtils.isNull(b.this.KJ.aCo().getName_show()) && !StringUtils.isNull(b.this.KJ.aCo().getUserId()) && b.this.KJ.aCt() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.KJ.aCo().getUserId(), b.this.KJ.aCo().getName_show(), b.this.KJ.aCt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.gyB = new TextView(tbPageContext.getPageActivity());
        this.gyB.setIncludeFontPadding(false);
        this.gyB.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.gyB.setLayoutParams(layoutParams);
        this.gyB.setOnClickListener(this.gyE);
        this.egT.addView(this.gyB, 1);
        this.gyC = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.gyC.setFanNumCallBack(this.gyD);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.gyC.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.gyC);
        this.NB = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.gyC);
        this.NB.sE("1");
        this.NB.j(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void a(bj bjVar) {
        super.a(bjVar);
        if (bjVar != null) {
            this.KJ = bjVar;
            if (bjVar.aCo() != null) {
                this.NB.a(bjVar.aCo());
                to(bjVar.aCo().getFansNum());
                if (!this.KJ.aCr()) {
                    this.gyC.setVisibility(8);
                } else if (this.KJ.aCo().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.KJ.aCo().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.gyC.setVisibility(8);
                    return;
                } else if (this.KJ.aCo().getGodUserData() != null && this.KJ.aCo().getGodUserData().getIsLike()) {
                    if (this.KJ.aCo().getGodUserData().getIsFromNetWork()) {
                        this.gyC.setVisibility(8);
                    } else {
                        this.gyC.setVisibility(0);
                        this.gyC.m(true, 1);
                    }
                } else {
                    this.gyC.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.eOw.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gyC.getLayoutParams();
            if (bjVar.aCJ() != null) {
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
            am.setViewTextColor(this.gyB, (int) R.color.cp_cont_d);
            this.gyC.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void m(BdUniqueId bdUniqueId) {
        super.m(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void to(int i) {
        if (this.gyB != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.KJ != null && !StringUtils.isNull(this.KJ.aCt()) && this.KJ.aCt().equals(this.mForumName)) {
                if (this.KJ.aCr()) {
                    String format = String.format(string, aq.numberUniformFormat(i));
                    this.gyB.setVisibility(0);
                    this.gyB.setText(format);
                    return;
                }
                this.gyB.setVisibility(8);
                return;
            }
            this.gyB.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
