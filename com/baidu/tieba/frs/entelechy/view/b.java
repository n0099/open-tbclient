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
    private bb aFf;
    private com.baidu.tbadk.core.view.userLike.c cUn;
    public TextView dRn;
    public EntelechyUserLikeButton dRo;
    private CommonUserLikeButton.a dRp;
    private View.OnClickListener dRq;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.dRp = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void eF(int i) {
                b.this.mC(i);
            }
        };
        this.dRq = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aFf != null && b.this.aFf.zG() != null && !StringUtils.isNull(b.this.aFf.zG().getName_show()) && !StringUtils.isNull(b.this.aFf.zG().getUserId()) && b.this.aFf.zM() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.aFf.zG().getUserId(), b.this.aFf.zG().getName_show(), b.this.aFf.zM(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.dRn = new TextView(tbPageContext.getPageActivity());
        this.dRn.setIncludeFontPadding(false);
        this.dRn.setTextSize(0, l.h(tbPageContext.getPageActivity(), e.C0210e.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.h(tbPageContext.getPageActivity(), e.C0210e.ds6);
        this.dRn.setLayoutParams(layoutParams);
        this.dRn.setOnClickListener(this.dRq);
        this.cbH.addView(this.dRn, 1);
        this.dRo = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.dRo.setFanNumCallBack(this.dRp);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.h(this.mPageContext.getPageActivity(), e.C0210e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, e.g.header_divider);
        layoutParams2.rightMargin = l.h(this.mPageContext.getPageActivity(), e.C0210e.ds32);
        layoutParams2.topMargin = l.h(this.mPageContext.getPageActivity(), e.C0210e.ds24);
        this.dRo.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.dRo);
        this.cUn = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dRo);
        this.cUn.setFromType("1");
        this.cUn.h(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: F */
    public void a(bb bbVar) {
        super.a(bbVar);
        if (bbVar != null) {
            this.aFf = bbVar;
            if (bbVar.zG() != null) {
                this.cUn.a(bbVar.zG());
                mC(bbVar.zG().getFansNum());
                if (!this.aFf.zJ()) {
                    this.dRo.setVisibility(8);
                } else if (this.aFf.zG().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aFf.zG().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.dRo.setVisibility(8);
                    return;
                } else if (this.aFf.zG().getGodUserData() != null && this.aFf.zG().getGodUserData().getIsLike()) {
                    if (this.aFf.zG().getGodUserData().getIsFromNetWork()) {
                        this.dRo.setVisibility(8);
                    } else {
                        this.dRo.setVisibility(0);
                        this.dRo.d(true, 1);
                    }
                } else {
                    this.dRo.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.cbI.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dRo.getLayoutParams();
            if (bbVar.Ac() != null) {
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
            al.h(this.dRn, e.d.cp_cont_d);
            this.dRo.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mC(int i) {
        if (this.dRn != null) {
            String string = this.mPageContext.getResources().getString(e.j.fans_default_name_god_user);
            if (this.aFf != null && !StringUtils.isNull(this.aFf.zM()) && this.aFf.zM().equals(this.mForumName)) {
                if (this.aFf.zJ()) {
                    String format = String.format(string, ao.P(i));
                    this.dRn.setVisibility(0);
                    this.dRn.setText(format);
                    return;
                }
                this.dRn.setVisibility(8);
                return;
            }
            this.dRn.setText(this.mPageContext.getResources().getString(e.j.default_personalized_name));
        }
    }
}
