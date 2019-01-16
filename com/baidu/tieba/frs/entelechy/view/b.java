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
    private bb aFI;
    private com.baidu.tbadk.core.view.userLike.c cXO;
    public TextView dUK;
    public EntelechyUserLikeButton dUL;
    private CommonUserLikeButton.a dUM;
    private View.OnClickListener dUN;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.dUM = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void eG(int i) {
                b.this.mQ(i);
            }
        };
        this.dUN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aFI != null && b.this.aFI.zT() != null && !StringUtils.isNull(b.this.aFI.zT().getName_show()) && !StringUtils.isNull(b.this.aFI.zT().getUserId()) && b.this.aFI.zZ() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.aFI.zT().getUserId(), b.this.aFI.zT().getName_show(), b.this.aFI.zZ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.dUK = new TextView(tbPageContext.getPageActivity());
        this.dUK.setIncludeFontPadding(false);
        this.dUK.setTextSize(0, l.h(tbPageContext.getPageActivity(), e.C0210e.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.h(tbPageContext.getPageActivity(), e.C0210e.ds6);
        this.dUK.setLayoutParams(layoutParams);
        this.dUK.setOnClickListener(this.dUN);
        this.ccw.addView(this.dUK, 1);
        this.dUL = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.dUL.setFanNumCallBack(this.dUM);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.h(this.mPageContext.getPageActivity(), e.C0210e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, e.g.header_divider);
        layoutParams2.rightMargin = l.h(this.mPageContext.getPageActivity(), e.C0210e.ds32);
        layoutParams2.topMargin = l.h(this.mPageContext.getPageActivity(), e.C0210e.ds24);
        this.dUL.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.dUL);
        this.cXO = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dUL);
        this.cXO.setFromType("1");
        this.cXO.h(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: F */
    public void a(bb bbVar) {
        super.a(bbVar);
        if (bbVar != null) {
            this.aFI = bbVar;
            if (bbVar.zT() != null) {
                this.cXO.a(bbVar.zT());
                mQ(bbVar.zT().getFansNum());
                if (!this.aFI.zW()) {
                    this.dUL.setVisibility(8);
                } else if (this.aFI.zT().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aFI.zT().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.dUL.setVisibility(8);
                    return;
                } else if (this.aFI.zT().getGodUserData() != null && this.aFI.zT().getGodUserData().getIsLike()) {
                    if (this.aFI.zT().getGodUserData().getIsFromNetWork()) {
                        this.dUL.setVisibility(8);
                    } else {
                        this.dUL.setVisibility(0);
                        this.dUL.d(true, 1);
                    }
                } else {
                    this.dUL.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.ccx.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dUL.getLayoutParams();
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
            al.h(this.dUK, e.d.cp_cont_d);
            this.dUL.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mQ(int i) {
        if (this.dUK != null) {
            String string = this.mPageContext.getResources().getString(e.j.fans_default_name_god_user);
            if (this.aFI != null && !StringUtils.isNull(this.aFI.zZ()) && this.aFI.zZ().equals(this.mForumName)) {
                if (this.aFI.zW()) {
                    String format = String.format(string, ao.Q(i));
                    this.dUK.setVisibility(0);
                    this.dUK.setText(format);
                    return;
                }
                this.dUK.setVisibility(8);
                return;
            }
            this.dUK.setText(this.mPageContext.getResources().getString(e.j.default_personalized_name));
        }
    }
}
