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
    public TextView gyp;
    public EntelechyUserLikeButton gyq;
    private CommonUserLikeButton.a gyr;
    private View.OnClickListener gys;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.gyr = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void ly(int i) {
                b.this.to(i);
            }
        };
        this.gys = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.KJ != null && b.this.KJ.aCo() != null && !StringUtils.isNull(b.this.KJ.aCo().getName_show()) && !StringUtils.isNull(b.this.KJ.aCo().getUserId()) && b.this.KJ.aCt() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.KJ.aCo().getUserId(), b.this.KJ.aCo().getName_show(), b.this.KJ.aCt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.gyp = new TextView(tbPageContext.getPageActivity());
        this.gyp.setIncludeFontPadding(false);
        this.gyp.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.gyp.setLayoutParams(layoutParams);
        this.gyp.setOnClickListener(this.gys);
        this.egG.addView(this.gyp, 1);
        this.gyq = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.gyq.setFanNumCallBack(this.gyr);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.gyq.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.gyq);
        this.NB = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.gyq);
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
                    this.gyq.setVisibility(8);
                } else if (this.KJ.aCo().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.KJ.aCo().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.gyq.setVisibility(8);
                    return;
                } else if (this.KJ.aCo().getGodUserData() != null && this.KJ.aCo().getGodUserData().getIsLike()) {
                    if (this.KJ.aCo().getGodUserData().getIsFromNetWork()) {
                        this.gyq.setVisibility(8);
                    } else {
                        this.gyq.setVisibility(0);
                        this.gyq.m(true, 1);
                    }
                } else {
                    this.gyq.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.eOj.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gyq.getLayoutParams();
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
            am.setViewTextColor(this.gyp, (int) R.color.cp_cont_d);
            this.gyq.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void m(BdUniqueId bdUniqueId) {
        super.m(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void to(int i) {
        if (this.gyp != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.KJ != null && !StringUtils.isNull(this.KJ.aCt()) && this.KJ.aCt().equals(this.mForumName)) {
                if (this.KJ.aCr()) {
                    String format = String.format(string, aq.numberUniformFormat(i));
                    this.gyp.setVisibility(0);
                    this.gyp.setText(format);
                    return;
                }
                this.gyp.setVisibility(8);
                return;
            }
            this.gyp.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
