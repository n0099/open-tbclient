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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b extends a {
    private bg We;
    private com.baidu.tbadk.core.view.userLike.c eBX;
    public TextView fDH;
    public EntelechyUserLikeButton fDI;
    private CommonUserLikeButton.a fDJ;
    private View.OnClickListener fDK;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.fDJ = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void jf(int i) {
                b.this.rZ(i);
            }
        };
        this.fDK = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.We != null && b.this.We.aex() != null && !StringUtils.isNull(b.this.We.aex().getName_show()) && !StringUtils.isNull(b.this.We.aex().getUserId()) && b.this.We.aeC() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.We.aex().getUserId(), b.this.We.aex().getName_show(), b.this.We.aeC(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fDH = new TextView(tbPageContext.getPageActivity());
        this.fDH.setIncludeFontPadding(false);
        this.fDH.setTextSize(0, l.g(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.g(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.fDH.setLayoutParams(layoutParams);
        this.fDH.setOnClickListener(this.fDK);
        this.dFz.addView(this.fDH, 1);
        this.fDI = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.fDI.setFanNumCallBack(this.fDJ);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.g(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.g(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.g(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.fDI.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.fDI);
        this.eBX = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.fDI);
        this.eBX.setFromType("1");
        this.eBX.j(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void a(bg bgVar) {
        super.a(bgVar);
        if (bgVar != null) {
            this.We = bgVar;
            if (bgVar.aex() != null) {
                this.eBX.a(bgVar.aex());
                rZ(bgVar.aex().getFansNum());
                if (!this.We.aeA()) {
                    this.fDI.setVisibility(8);
                } else if (this.We.aex().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.We.aex().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.fDI.setVisibility(8);
                    return;
                } else if (this.We.aex().getGodUserData() != null && this.We.aex().getGodUserData().getIsLike()) {
                    if (this.We.aex().getGodUserData().getIsFromNetWork()) {
                        this.fDI.setVisibility(8);
                    } else {
                        this.fDI.setVisibility(0);
                        this.fDI.f(true, 1);
                    }
                } else {
                    this.fDI.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.dFA.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fDI.getLayoutParams();
            if (bgVar.aeS() != null) {
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
            am.j(this.fDH, R.color.cp_cont_d);
            this.fDI.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void l(BdUniqueId bdUniqueId) {
        super.l(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rZ(int i) {
        if (this.fDH != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.We != null && !StringUtils.isNull(this.We.aeC()) && this.We.aeC().equals(this.mForumName)) {
                if (this.We.aeA()) {
                    String format = String.format(string, aq.aH(i));
                    this.fDH.setVisibility(0);
                    this.fDH.setText(format);
                    return;
                }
                this.fDH.setVisibility(8);
                return;
            }
            this.fDH.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
