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
    private bb aAQ;
    private com.baidu.tbadk.core.view.userLike.c cMA;
    public TextView dJG;
    public EntelechyUserLikeButton dJH;
    private CommonUserLikeButton.a dJI;
    private View.OnClickListener dJJ;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.dJI = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void ed(int i) {
                b.this.lV(i);
            }
        };
        this.dJJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aAQ != null && b.this.aAQ.yv() != null && !StringUtils.isNull(b.this.aAQ.yv().getName_show()) && !StringUtils.isNull(b.this.aAQ.yv().getUserId()) && b.this.aAQ.yB() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.aAQ.yv().getUserId(), b.this.aAQ.yv().getName_show(), b.this.aAQ.yB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.dJG = new TextView(tbPageContext.getPageActivity());
        this.dJG.setIncludeFontPadding(false);
        this.dJG.setTextSize(0, l.h(tbPageContext.getPageActivity(), e.C0175e.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.h(tbPageContext.getPageActivity(), e.C0175e.ds6);
        this.dJG.setLayoutParams(layoutParams);
        this.dJG.setOnClickListener(this.dJJ);
        this.bXd.addView(this.dJG, 1);
        this.dJH = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.dJH.setFanNumCallBack(this.dJI);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.h(this.mPageContext.getPageActivity(), e.C0175e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, e.g.header_divider);
        layoutParams2.rightMargin = l.h(this.mPageContext.getPageActivity(), e.C0175e.ds32);
        layoutParams2.topMargin = l.h(this.mPageContext.getPageActivity(), e.C0175e.ds24);
        this.dJH.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.dJH);
        this.cMA = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dJH);
        this.cMA.setFromType("1");
        this.cMA.h(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: F */
    public void a(bb bbVar) {
        super.a(bbVar);
        if (bbVar != null) {
            this.aAQ = bbVar;
            if (bbVar.yv() != null) {
                this.cMA.a(bbVar.yv());
                lV(bbVar.yv().getFansNum());
                if (!this.aAQ.yy()) {
                    this.dJH.setVisibility(8);
                } else if (this.aAQ.yv().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aAQ.yv().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.dJH.setVisibility(8);
                    return;
                } else if (this.aAQ.yv().getGodUserData() != null && this.aAQ.yv().getGodUserData().getIsLike()) {
                    if (this.aAQ.yv().getGodUserData().getIsFromNetWork()) {
                        this.dJH.setVisibility(8);
                    } else {
                        this.dJH.setVisibility(0);
                        this.dJH.d(true, 1);
                    }
                } else {
                    this.dJH.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.bXe.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dJH.getLayoutParams();
            if (bbVar.yR() != null) {
                layoutParams.topMargin = i + l.h(this.mPageContext.getPageActivity(), e.C0175e.ds4);
            } else {
                layoutParams.topMargin = l.h(this.mPageContext.getPageActivity(), e.C0175e.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            al.h(this.dJG, e.d.cp_cont_d);
            this.dJH.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lV(int i) {
        if (this.dJG != null) {
            String string = this.mPageContext.getResources().getString(e.j.fans_default_name_god_user);
            if (this.aAQ != null && !StringUtils.isNull(this.aAQ.yB()) && this.aAQ.yB().equals(this.mForumName)) {
                if (this.aAQ.yy()) {
                    String format = String.format(string, ao.G(i));
                    this.dJG.setVisibility(0);
                    this.dJG.setText(format);
                    return;
                }
                this.dJG.setVisibility(8);
                return;
            }
            this.dJG.setText(this.mPageContext.getResources().getString(e.j.default_personalized_name));
        }
    }
}
