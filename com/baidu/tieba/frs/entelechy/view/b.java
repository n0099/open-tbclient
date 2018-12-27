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
    private bb aFg;
    private com.baidu.tbadk.core.view.userLike.c cXd;
    public TextView dUe;
    public EntelechyUserLikeButton dUf;
    private CommonUserLikeButton.a dUg;
    private View.OnClickListener dUh;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.dUg = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void eG(int i) {
                b.this.mP(i);
            }
        };
        this.dUh = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aFg != null && b.this.aFg.zG() != null && !StringUtils.isNull(b.this.aFg.zG().getName_show()) && !StringUtils.isNull(b.this.aFg.zG().getUserId()) && b.this.aFg.zM() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.aFg.zG().getUserId(), b.this.aFg.zG().getName_show(), b.this.aFg.zM(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.dUe = new TextView(tbPageContext.getPageActivity());
        this.dUe.setIncludeFontPadding(false);
        this.dUe.setTextSize(0, l.h(tbPageContext.getPageActivity(), e.C0210e.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.h(tbPageContext.getPageActivity(), e.C0210e.ds6);
        this.dUe.setLayoutParams(layoutParams);
        this.dUe.setOnClickListener(this.dUh);
        this.cbK.addView(this.dUe, 1);
        this.dUf = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.dUf.setFanNumCallBack(this.dUg);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.h(this.mPageContext.getPageActivity(), e.C0210e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, e.g.header_divider);
        layoutParams2.rightMargin = l.h(this.mPageContext.getPageActivity(), e.C0210e.ds32);
        layoutParams2.topMargin = l.h(this.mPageContext.getPageActivity(), e.C0210e.ds24);
        this.dUf.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.dUf);
        this.cXd = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dUf);
        this.cXd.setFromType("1");
        this.cXd.h(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: F */
    public void a(bb bbVar) {
        super.a(bbVar);
        if (bbVar != null) {
            this.aFg = bbVar;
            if (bbVar.zG() != null) {
                this.cXd.a(bbVar.zG());
                mP(bbVar.zG().getFansNum());
                if (!this.aFg.zJ()) {
                    this.dUf.setVisibility(8);
                } else if (this.aFg.zG().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aFg.zG().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.dUf.setVisibility(8);
                    return;
                } else if (this.aFg.zG().getGodUserData() != null && this.aFg.zG().getGodUserData().getIsLike()) {
                    if (this.aFg.zG().getGodUserData().getIsFromNetWork()) {
                        this.dUf.setVisibility(8);
                    } else {
                        this.dUf.setVisibility(0);
                        this.dUf.d(true, 1);
                    }
                } else {
                    this.dUf.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.cbL.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dUf.getLayoutParams();
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
            al.h(this.dUe, e.d.cp_cont_d);
            this.dUf.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mP(int i) {
        if (this.dUe != null) {
            String string = this.mPageContext.getResources().getString(e.j.fans_default_name_god_user);
            if (this.aFg != null && !StringUtils.isNull(this.aFg.zM()) && this.aFg.zM().equals(this.mForumName)) {
                if (this.aFg.zJ()) {
                    String format = String.format(string, ao.Q(i));
                    this.dUe.setVisibility(0);
                    this.dUe.setText(format);
                    return;
                }
                this.dUe.setVisibility(8);
                return;
            }
            this.dUe.setText(this.mPageContext.getResources().getString(e.j.default_personalized_name));
        }
    }
}
