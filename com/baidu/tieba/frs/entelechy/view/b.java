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
    private com.baidu.tbadk.core.view.userLike.c NC;
    public EntelechyUserLikeButton gzA;
    private CommonUserLikeButton.a gzB;
    private View.OnClickListener gzC;
    public TextView gzz;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.gzB = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void lA(int i) {
                b.this.tu(i);
            }
        };
        this.gzC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.KJ != null && b.this.KJ.aCr() != null && !StringUtils.isNull(b.this.KJ.aCr().getName_show()) && !StringUtils.isNull(b.this.KJ.aCr().getUserId()) && b.this.KJ.aCw() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.KJ.aCr().getUserId(), b.this.KJ.aCr().getName_show(), b.this.KJ.aCw(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.gzz = new TextView(tbPageContext.getPageActivity());
        this.gzz.setIncludeFontPadding(false);
        this.gzz.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.gzz.setLayoutParams(layoutParams);
        this.gzz.setOnClickListener(this.gzC);
        this.ehj.addView(this.gzz, 1);
        this.gzA = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.gzA.setFanNumCallBack(this.gzB);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.gzA.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.gzA);
        this.NC = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.gzA);
        this.NC.sE("1");
        this.NC.j(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void a(bj bjVar) {
        super.a(bjVar);
        if (bjVar != null) {
            this.KJ = bjVar;
            if (bjVar.aCr() != null) {
                this.NC.a(bjVar.aCr());
                tu(bjVar.aCr().getFansNum());
                if (!this.KJ.aCu()) {
                    this.gzA.setVisibility(8);
                } else if (this.KJ.aCr().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.KJ.aCr().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.gzA.setVisibility(8);
                    return;
                } else if (this.KJ.aCr().getGodUserData() != null && this.KJ.aCr().getGodUserData().getIsLike()) {
                    if (this.KJ.aCr().getGodUserData().getIsFromNetWork()) {
                        this.gzA.setVisibility(8);
                    } else {
                        this.gzA.setVisibility(0);
                        this.gzA.m(true, 1);
                    }
                } else {
                    this.gzA.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.eOU.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gzA.getLayoutParams();
            if (bjVar.aCM() != null) {
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
            am.setViewTextColor(this.gzz, (int) R.color.cp_cont_d);
            this.gzA.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void m(BdUniqueId bdUniqueId) {
        super.m(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tu(int i) {
        if (this.gzz != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.KJ != null && !StringUtils.isNull(this.KJ.aCw()) && this.KJ.aCw().equals(this.mForumName)) {
                if (this.KJ.aCu()) {
                    String format = String.format(string, aq.numberUniformFormat(i));
                    this.gzz.setVisibility(0);
                    this.gzz.setText(format);
                    return;
                }
                this.gzz.setVisibility(8);
                return;
            }
            this.gzz.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
