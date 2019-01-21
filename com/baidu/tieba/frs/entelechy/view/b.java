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
    private bb aFJ;
    private com.baidu.tbadk.core.view.userLike.c cXP;
    public TextView dUL;
    public EntelechyUserLikeButton dUM;
    private CommonUserLikeButton.a dUN;
    private View.OnClickListener dUO;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.dUN = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void eG(int i) {
                b.this.mQ(i);
            }
        };
        this.dUO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aFJ != null && b.this.aFJ.zT() != null && !StringUtils.isNull(b.this.aFJ.zT().getName_show()) && !StringUtils.isNull(b.this.aFJ.zT().getUserId()) && b.this.aFJ.zZ() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.aFJ.zT().getUserId(), b.this.aFJ.zT().getName_show(), b.this.aFJ.zZ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.dUL = new TextView(tbPageContext.getPageActivity());
        this.dUL.setIncludeFontPadding(false);
        this.dUL.setTextSize(0, l.h(tbPageContext.getPageActivity(), e.C0210e.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.h(tbPageContext.getPageActivity(), e.C0210e.ds6);
        this.dUL.setLayoutParams(layoutParams);
        this.dUL.setOnClickListener(this.dUO);
        this.ccx.addView(this.dUL, 1);
        this.dUM = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.dUM.setFanNumCallBack(this.dUN);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.h(this.mPageContext.getPageActivity(), e.C0210e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, e.g.header_divider);
        layoutParams2.rightMargin = l.h(this.mPageContext.getPageActivity(), e.C0210e.ds32);
        layoutParams2.topMargin = l.h(this.mPageContext.getPageActivity(), e.C0210e.ds24);
        this.dUM.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.dUM);
        this.cXP = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dUM);
        this.cXP.setFromType("1");
        this.cXP.h(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: F */
    public void a(bb bbVar) {
        super.a(bbVar);
        if (bbVar != null) {
            this.aFJ = bbVar;
            if (bbVar.zT() != null) {
                this.cXP.a(bbVar.zT());
                mQ(bbVar.zT().getFansNum());
                if (!this.aFJ.zW()) {
                    this.dUM.setVisibility(8);
                } else if (this.aFJ.zT().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aFJ.zT().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.dUM.setVisibility(8);
                    return;
                } else if (this.aFJ.zT().getGodUserData() != null && this.aFJ.zT().getGodUserData().getIsLike()) {
                    if (this.aFJ.zT().getGodUserData().getIsFromNetWork()) {
                        this.dUM.setVisibility(8);
                    } else {
                        this.dUM.setVisibility(0);
                        this.dUM.d(true, 1);
                    }
                } else {
                    this.dUM.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.ccy.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dUM.getLayoutParams();
            if (bbVar.Ap() != null) {
                layoutParams.topMargin = i + l.h(this.mPageContext.getPageActivity(), e.C0210e.ds4);
            } else {
                layoutParams.topMargin = l.h(this.mPageContext.getPageActivity(), e.C0210e.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            al.h(this.dUL, e.d.cp_cont_d);
            this.dUM.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mQ(int i) {
        if (this.dUL != null) {
            String string = this.mPageContext.getResources().getString(e.j.fans_default_name_god_user);
            if (this.aFJ != null && !StringUtils.isNull(this.aFJ.zZ()) && this.aFJ.zZ().equals(this.mForumName)) {
                if (this.aFJ.zW()) {
                    String format = String.format(string, ao.Q(i));
                    this.dUL.setVisibility(0);
                    this.dUL.setText(format);
                    return;
                }
                this.dUL.setVisibility(8);
                return;
            }
            this.dUL.setText(this.mPageContext.getResources().getString(e.j.default_personalized_name));
        }
    }
}
