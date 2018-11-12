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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class b extends a {
    private bb aBF;
    private com.baidu.tbadk.core.view.userLike.c cNG;
    public TextView dKK;
    public EntelechyUserLikeButton dKL;
    private CommonUserLikeButton.a dKM;
    private View.OnClickListener dKN;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.dKM = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void er(int i) {
                b.this.mm(i);
            }
        };
        this.dKN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aBF != null && b.this.aBF.yC() != null && !StringUtils.isNull(b.this.aBF.yC().getName_show()) && !StringUtils.isNull(b.this.aBF.yC().getUserId()) && b.this.aBF.yI() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.aBF.yC().getUserId(), b.this.aBF.yC().getName_show(), b.this.aBF.yI(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.dKK = new TextView(tbPageContext.getPageActivity());
        this.dKK.setIncludeFontPadding(false);
        this.dKK.setTextSize(0, l.h(tbPageContext.getPageActivity(), e.C0200e.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.h(tbPageContext.getPageActivity(), e.C0200e.ds6);
        this.dKK.setLayoutParams(layoutParams);
        this.dKK.setOnClickListener(this.dKN);
        this.bXP.addView(this.dKK, 1);
        this.dKL = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.dKL.setFanNumCallBack(this.dKM);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.h(this.mPageContext.getPageActivity(), e.C0200e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, e.g.header_divider);
        layoutParams2.rightMargin = l.h(this.mPageContext.getPageActivity(), e.C0200e.ds32);
        layoutParams2.topMargin = l.h(this.mPageContext.getPageActivity(), e.C0200e.ds24);
        this.dKL.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.dKL);
        this.cNG = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dKL);
        this.cNG.setFromType("1");
        this.cNG.h(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: F */
    public void a(bb bbVar) {
        super.a(bbVar);
        if (bbVar != null) {
            this.aBF = bbVar;
            if (bbVar.yC() != null) {
                this.cNG.a(bbVar.yC());
                mm(bbVar.yC().getFansNum());
                if (!this.aBF.yF()) {
                    this.dKL.setVisibility(8);
                } else if (this.aBF.yC().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aBF.yC().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.dKL.setVisibility(8);
                    return;
                } else if (this.aBF.yC().getGodUserData() != null && this.aBF.yC().getGodUserData().getIsLike()) {
                    if (this.aBF.yC().getGodUserData().getIsFromNetWork()) {
                        this.dKL.setVisibility(8);
                    } else {
                        this.dKL.setVisibility(0);
                        this.dKL.d(true, 1);
                    }
                } else {
                    this.dKL.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.bXQ.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dKL.getLayoutParams();
            if (bbVar.yY() != null) {
                layoutParams.topMargin = i + l.h(this.mPageContext.getPageActivity(), e.C0200e.ds4);
            } else {
                layoutParams.topMargin = l.h(this.mPageContext.getPageActivity(), e.C0200e.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            al.h(this.dKK, e.d.cp_cont_d);
            this.dKL.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mm(int i) {
        if (this.dKK != null) {
            String string = this.mPageContext.getResources().getString(e.j.fans_default_name_god_user);
            if (this.aBF != null && !StringUtils.isNull(this.aBF.yI()) && this.aBF.yI().equals(this.mForumName)) {
                if (this.aBF.yF()) {
                    String format = String.format(string, ao.I(i));
                    this.dKK.setVisibility(0);
                    this.dKK.setText(format);
                    return;
                }
                this.dKK.setVisibility(8);
                return;
            }
            this.dKK.setText(this.mPageContext.getResources().getString(e.j.default_personalized_name));
        }
    }
}
