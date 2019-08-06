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
    private bh We;
    private com.baidu.tbadk.core.view.userLike.c eCe;
    public TextView fEv;
    public EntelechyUserLikeButton fEw;
    private CommonUserLikeButton.a fEx;
    private View.OnClickListener fEy;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.fEx = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void jg(int i) {
                b.this.sb(i);
            }
        };
        this.fEy = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.We != null && b.this.We.aey() != null && !StringUtils.isNull(b.this.We.aey().getName_show()) && !StringUtils.isNull(b.this.We.aey().getUserId()) && b.this.We.aeD() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.We.aey().getUserId(), b.this.We.aey().getName_show(), b.this.We.aeD(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fEv = new TextView(tbPageContext.getPageActivity());
        this.fEv.setIncludeFontPadding(false);
        this.fEv.setTextSize(0, l.g(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.g(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.fEv.setLayoutParams(layoutParams);
        this.fEv.setOnClickListener(this.fEy);
        this.dFG.addView(this.fEv, 1);
        this.fEw = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.fEw.setFanNumCallBack(this.fEx);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.g(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.g(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.g(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.fEw.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.fEw);
        this.eCe = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.fEw);
        this.eCe.setFromType("1");
        this.eCe.j(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void a(bh bhVar) {
        super.a(bhVar);
        if (bhVar != null) {
            this.We = bhVar;
            if (bhVar.aey() != null) {
                this.eCe.a(bhVar.aey());
                sb(bhVar.aey().getFansNum());
                if (!this.We.aeB()) {
                    this.fEw.setVisibility(8);
                } else if (this.We.aey().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.We.aey().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.fEw.setVisibility(8);
                    return;
                } else if (this.We.aey().getGodUserData() != null && this.We.aey().getGodUserData().getIsLike()) {
                    if (this.We.aey().getGodUserData().getIsFromNetWork()) {
                        this.fEw.setVisibility(8);
                    } else {
                        this.fEw.setVisibility(0);
                        this.fEw.f(true, 1);
                    }
                } else {
                    this.fEw.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.dFH.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fEw.getLayoutParams();
            if (bhVar.aeT() != null) {
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
            am.j(this.fEv, R.color.cp_cont_d);
            this.fEw.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void l(BdUniqueId bdUniqueId) {
        super.l(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sb(int i) {
        if (this.fEv != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.We != null && !StringUtils.isNull(this.We.aeD()) && this.We.aeD().equals(this.mForumName)) {
                if (this.We.aeB()) {
                    String format = String.format(string, aq.aH(i));
                    this.fEv.setVisibility(0);
                    this.fEv.setText(format);
                    return;
                }
                this.fEv.setVisibility(8);
                return;
            }
            this.fEv.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
