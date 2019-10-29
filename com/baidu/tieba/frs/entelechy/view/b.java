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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b extends a {
    private bh FT;
    private com.baidu.tbadk.core.view.userLike.c eMu;
    public TextView fFB;
    public EntelechyUserLikeButton fFC;
    private CommonUserLikeButton.a fFD;
    private View.OnClickListener fFE;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.fFD = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void iV(int i) {
                b.this.qY(i);
            }
        };
        this.fFE = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.FT != null && b.this.FT.aiG() != null && !StringUtils.isNull(b.this.FT.aiG().getName_show()) && !StringUtils.isNull(b.this.FT.aiG().getUserId()) && b.this.FT.aiL() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.FT.aiG().getUserId(), b.this.FT.aiG().getName_show(), b.this.FT.aiL(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fFB = new TextView(tbPageContext.getPageActivity());
        this.fFB.setIncludeFontPadding(false);
        this.fFB.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.fFB.setLayoutParams(layoutParams);
        this.fFB.setOnClickListener(this.fFE);
        this.dUq.addView(this.fFB, 1);
        this.fFC = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.fFC.setFanNumCallBack(this.fFD);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.fFC.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.fFC);
        this.eMu = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.fFC);
        this.eMu.mX("1");
        this.eMu.j(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void a(bh bhVar) {
        super.a(bhVar);
        if (bhVar != null) {
            this.FT = bhVar;
            if (bhVar.aiG() != null) {
                this.eMu.a(bhVar.aiG());
                qY(bhVar.aiG().getFansNum());
                if (!this.FT.aiJ()) {
                    this.fFC.setVisibility(8);
                } else if (this.FT.aiG().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.FT.aiG().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.fFC.setVisibility(8);
                    return;
                } else if (this.FT.aiG().getGodUserData() != null && this.FT.aiG().getGodUserData().getIsLike()) {
                    if (this.FT.aiG().getGodUserData().getIsFromNetWork()) {
                        this.fFC.setVisibility(8);
                    } else {
                        this.fFC.setVisibility(0);
                        this.fFC.g(true, 1);
                    }
                } else {
                    this.fFC.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.dUr.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fFC.getLayoutParams();
            if (bhVar.ajb() != null) {
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
            am.setViewTextColor(this.fFB, (int) R.color.cp_cont_d);
            this.fFC.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void l(BdUniqueId bdUniqueId) {
        super.l(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qY(int i) {
        if (this.fFB != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.FT != null && !StringUtils.isNull(this.FT.aiL()) && this.FT.aiL().equals(this.mForumName)) {
                if (this.FT.aiJ()) {
                    String format = String.format(string, aq.numberUniformFormat(i));
                    this.fFB.setVisibility(0);
                    this.fFB.setText(format);
                    return;
                }
                this.fFB.setVisibility(8);
                return;
            }
            this.fFB.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
