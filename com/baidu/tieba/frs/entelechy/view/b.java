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
    private bh Fs;
    private com.baidu.tbadk.core.view.userLike.c eLD;
    public TextView fEK;
    public EntelechyUserLikeButton fEL;
    private CommonUserLikeButton.a fEM;
    private View.OnClickListener fEN;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.fEM = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void iU(int i) {
                b.this.qX(i);
            }
        };
        this.fEN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.Fs != null && b.this.Fs.aiE() != null && !StringUtils.isNull(b.this.Fs.aiE().getName_show()) && !StringUtils.isNull(b.this.Fs.aiE().getUserId()) && b.this.Fs.aiJ() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.Fs.aiE().getUserId(), b.this.Fs.aiE().getName_show(), b.this.Fs.aiJ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fEK = new TextView(tbPageContext.getPageActivity());
        this.fEK.setIncludeFontPadding(false);
        this.fEK.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.fEK.setLayoutParams(layoutParams);
        this.fEK.setOnClickListener(this.fEN);
        this.dTz.addView(this.fEK, 1);
        this.fEL = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.fEL.setFanNumCallBack(this.fEM);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.fEL.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.fEL);
        this.eLD = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.fEL);
        this.eLD.mX("1");
        this.eLD.j(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void a(bh bhVar) {
        super.a(bhVar);
        if (bhVar != null) {
            this.Fs = bhVar;
            if (bhVar.aiE() != null) {
                this.eLD.a(bhVar.aiE());
                qX(bhVar.aiE().getFansNum());
                if (!this.Fs.aiH()) {
                    this.fEL.setVisibility(8);
                } else if (this.Fs.aiE().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.Fs.aiE().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.fEL.setVisibility(8);
                    return;
                } else if (this.Fs.aiE().getGodUserData() != null && this.Fs.aiE().getGodUserData().getIsLike()) {
                    if (this.Fs.aiE().getGodUserData().getIsFromNetWork()) {
                        this.fEL.setVisibility(8);
                    } else {
                        this.fEL.setVisibility(0);
                        this.fEL.g(true, 1);
                    }
                } else {
                    this.fEL.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.dTA.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fEL.getLayoutParams();
            if (bhVar.aiZ() != null) {
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
            am.setViewTextColor(this.fEK, (int) R.color.cp_cont_d);
            this.fEL.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void l(BdUniqueId bdUniqueId) {
        super.l(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qX(int i) {
        if (this.fEK != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.Fs != null && !StringUtils.isNull(this.Fs.aiJ()) && this.Fs.aiJ().equals(this.mForumName)) {
                if (this.Fs.aiH()) {
                    String format = String.format(string, aq.numberUniformFormat(i));
                    this.fEK.setVisibility(0);
                    this.fEK.setText(format);
                    return;
                }
                this.fEK.setVisibility(8);
                return;
            }
            this.fEK.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
