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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b extends a {
    private bd alf;
    private com.baidu.tbadk.core.view.userLike.c coa;
    public TextView deL;
    public EntelechyUserLikeButton deM;
    private CommonUserLikeButton.a deN;
    private View.OnClickListener deO;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.deN = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dC(int i) {
                b.this.kz(i);
            }
        };
        this.deO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.alf != null && b.this.alf.rQ() != null && !StringUtils.isNull(b.this.alf.rQ().getName_show()) && !StringUtils.isNull(b.this.alf.rQ().getUserId()) && b.this.alf.rV() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.alf.rQ().getUserId(), b.this.alf.rQ().getName_show(), b.this.alf.rV(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.deL = new TextView(tbPageContext.getPageActivity());
        this.deL.setIncludeFontPadding(false);
        this.deL.setTextSize(0, l.e(tbPageContext.getPageActivity(), d.e.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.e(tbPageContext.getPageActivity(), d.e.ds6);
        this.deL.setLayoutParams(layoutParams);
        this.deL.setOnClickListener(this.deO);
        this.bxk.addView(this.deL, 1);
        this.deM = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.deM.setFanNumCallBack(this.deN);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.e(this.mPageContext.getPageActivity(), d.e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, d.g.header_divider);
        layoutParams2.rightMargin = l.e(this.mPageContext.getPageActivity(), d.e.ds32);
        layoutParams2.topMargin = l.e(this.mPageContext.getPageActivity(), d.e.ds24);
        this.deM.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.deM);
        this.coa = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.deM);
        this.coa.setFromType("1");
        this.coa.h(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(bd bdVar) {
        super.a(bdVar);
        if (bdVar != null) {
            this.alf = bdVar;
            if (bdVar.rQ() != null) {
                this.coa.a(bdVar.rQ());
                kz(bdVar.rQ().getFansNum());
                if (!this.alf.rT()) {
                    this.deM.setVisibility(8);
                } else if (this.alf.rQ().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.alf.rQ().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.deM.setVisibility(8);
                    return;
                } else if (this.alf.rQ().getGodUserData() != null && this.alf.rQ().getGodUserData().getIsLike()) {
                    if (this.alf.rQ().getGodUserData().getIsFromNetWork()) {
                        this.deM.setVisibility(8);
                    } else {
                        this.deM.setVisibility(0);
                        this.deM.d(true, 1);
                    }
                } else {
                    this.deM.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.bxl.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.deM.getLayoutParams();
            if (bdVar.sk() != null) {
                layoutParams.topMargin = i + l.e(this.mPageContext.getPageActivity(), d.e.ds4);
            } else {
                layoutParams.topMargin = l.e(this.mPageContext.getPageActivity(), d.e.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            ak.h(this.deL, d.C0126d.cp_cont_d);
            this.deM.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kz(int i) {
        if (this.deL != null) {
            String string = this.mPageContext.getResources().getString(d.k.fans_default_name_god_user);
            if (this.alf != null && !StringUtils.isNull(this.alf.rV()) && this.alf.rV().equals(this.mForumName)) {
                if (this.alf.rT()) {
                    String format = String.format(string, an.v(i));
                    this.deL.setVisibility(0);
                    this.deL.setText(format);
                    return;
                }
                this.deL.setVisibility(8);
                return;
            }
            this.deL.setText(this.mPageContext.getResources().getString(d.k.default_personalized_name));
        }
    }
}
