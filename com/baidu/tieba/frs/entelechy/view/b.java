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
    public TextView gyn;
    public EntelechyUserLikeButton gyo;
    private CommonUserLikeButton.a gyp;
    private View.OnClickListener gyq;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.gyp = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void ly(int i) {
                b.this.to(i);
            }
        };
        this.gyq = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.KJ != null && b.this.KJ.aCm() != null && !StringUtils.isNull(b.this.KJ.aCm().getName_show()) && !StringUtils.isNull(b.this.KJ.aCm().getUserId()) && b.this.KJ.aCr() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.KJ.aCm().getUserId(), b.this.KJ.aCm().getName_show(), b.this.KJ.aCr(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.gyn = new TextView(tbPageContext.getPageActivity());
        this.gyn.setIncludeFontPadding(false);
        this.gyn.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.gyn.setLayoutParams(layoutParams);
        this.gyn.setOnClickListener(this.gyq);
        this.egF.addView(this.gyn, 1);
        this.gyo = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.gyo.setFanNumCallBack(this.gyp);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.gyo.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.gyo);
        this.NB = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.gyo);
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
            if (bjVar.aCm() != null) {
                this.NB.a(bjVar.aCm());
                to(bjVar.aCm().getFansNum());
                if (!this.KJ.aCp()) {
                    this.gyo.setVisibility(8);
                } else if (this.KJ.aCm().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.KJ.aCm().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.gyo.setVisibility(8);
                    return;
                } else if (this.KJ.aCm().getGodUserData() != null && this.KJ.aCm().getGodUserData().getIsLike()) {
                    if (this.KJ.aCm().getGodUserData().getIsFromNetWork()) {
                        this.gyo.setVisibility(8);
                    } else {
                        this.gyo.setVisibility(0);
                        this.gyo.m(true, 1);
                    }
                } else {
                    this.gyo.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.eOi.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gyo.getLayoutParams();
            if (bjVar.aCH() != null) {
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
            am.setViewTextColor(this.gyn, (int) R.color.cp_cont_d);
            this.gyo.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void m(BdUniqueId bdUniqueId) {
        super.m(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void to(int i) {
        if (this.gyn != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.KJ != null && !StringUtils.isNull(this.KJ.aCr()) && this.KJ.aCr().equals(this.mForumName)) {
                if (this.KJ.aCp()) {
                    String format = String.format(string, aq.numberUniformFormat(i));
                    this.gyn.setVisibility(0);
                    this.gyn.setText(format);
                    return;
                }
                this.gyn.setVisibility(8);
                return;
            }
            this.gyn.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
