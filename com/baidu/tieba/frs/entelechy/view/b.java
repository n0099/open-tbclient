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
    private bh Wd;
    private com.baidu.tbadk.core.view.userLike.c eDN;
    public TextView fGk;
    public EntelechyUserLikeButton fGl;
    private CommonUserLikeButton.a fGm;
    private View.OnClickListener fGn;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.fGm = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void jj(int i) {
                b.this.sf(i);
            }
        };
        this.fGn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.Wd != null && b.this.Wd.aeC() != null && !StringUtils.isNull(b.this.Wd.aeC().getName_show()) && !StringUtils.isNull(b.this.Wd.aeC().getUserId()) && b.this.Wd.aeH() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.Wd.aeC().getUserId(), b.this.Wd.aeC().getName_show(), b.this.Wd.aeH(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fGk = new TextView(tbPageContext.getPageActivity());
        this.fGk.setIncludeFontPadding(false);
        this.fGk.setTextSize(0, l.g(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.g(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.fGk.setLayoutParams(layoutParams);
        this.fGk.setOnClickListener(this.fGn);
        this.dHr.addView(this.fGk, 1);
        this.fGl = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.fGl.setFanNumCallBack(this.fGm);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.g(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.g(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.g(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.fGl.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.fGl);
        this.eDN = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.fGl);
        this.eDN.setFromType("1");
        this.eDN.j(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void a(bh bhVar) {
        super.a(bhVar);
        if (bhVar != null) {
            this.Wd = bhVar;
            if (bhVar.aeC() != null) {
                this.eDN.a(bhVar.aeC());
                sf(bhVar.aeC().getFansNum());
                if (!this.Wd.aeF()) {
                    this.fGl.setVisibility(8);
                } else if (this.Wd.aeC().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.Wd.aeC().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.fGl.setVisibility(8);
                    return;
                } else if (this.Wd.aeC().getGodUserData() != null && this.Wd.aeC().getGodUserData().getIsLike()) {
                    if (this.Wd.aeC().getGodUserData().getIsFromNetWork()) {
                        this.fGl.setVisibility(8);
                    } else {
                        this.fGl.setVisibility(0);
                        this.fGl.f(true, 1);
                    }
                } else {
                    this.fGl.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.dHs.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fGl.getLayoutParams();
            if (bhVar.aeX() != null) {
                layoutParams.topMargin = i + l.g(this.mPageContext.getPageActivity(), R.dimen.ds4);
            } else {
                layoutParams.topMargin = l.g(this.mPageContext.getPageActivity(), R.dimen.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            am.j(this.fGk, R.color.cp_cont_d);
            this.fGl.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void l(BdUniqueId bdUniqueId) {
        super.l(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sf(int i) {
        if (this.fGk != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.Wd != null && !StringUtils.isNull(this.Wd.aeH()) && this.Wd.aeH().equals(this.mForumName)) {
                if (this.Wd.aeF()) {
                    String format = String.format(string, aq.aH(i));
                    this.fGk.setVisibility(0);
                    this.fGk.setText(format);
                    return;
                }
                this.fGk.setVisibility(8);
                return;
            }
            this.fGk.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
