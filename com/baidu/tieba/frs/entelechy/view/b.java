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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class b extends a {
    private bg XS;
    private com.baidu.tbadk.core.view.userLike.c ehx;
    public TextView fiD;
    public EntelechyUserLikeButton fiE;
    private CommonUserLikeButton.a fiF;
    private View.OnClickListener fiG;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.fiF = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void im(int i) {
                b.this.qD(i);
            }
        };
        this.fiG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.XS != null && b.this.XS.YR() != null && !StringUtils.isNull(b.this.XS.YR().getName_show()) && !StringUtils.isNull(b.this.XS.YR().getUserId()) && b.this.XS.YW() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.XS.YR().getUserId(), b.this.XS.YR().getName_show(), b.this.XS.YW(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fiD = new TextView(tbPageContext.getPageActivity());
        this.fiD.setIncludeFontPadding(false);
        this.fiD.setTextSize(0, l.h(tbPageContext.getPageActivity(), d.e.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.h(tbPageContext.getPageActivity(), d.e.ds6);
        this.fiD.setLayoutParams(layoutParams);
        this.fiD.setOnClickListener(this.fiG);
        this.drv.addView(this.fiD, 1);
        this.fiE = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.fiE.setFanNumCallBack(this.fiF);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.h(this.mPageContext.getPageActivity(), d.e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, d.g.header_divider);
        layoutParams2.rightMargin = l.h(this.mPageContext.getPageActivity(), d.e.ds32);
        layoutParams2.topMargin = l.h(this.mPageContext.getPageActivity(), d.e.ds24);
        this.fiE.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.fiE);
        this.ehx = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.fiE);
        this.ehx.setFromType("1");
        this.ehx.i(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void a(bg bgVar) {
        super.a(bgVar);
        if (bgVar != null) {
            this.XS = bgVar;
            if (bgVar.YR() != null) {
                this.ehx.a(bgVar.YR());
                qD(bgVar.YR().getFansNum());
                if (!this.XS.YU()) {
                    this.fiE.setVisibility(8);
                } else if (this.XS.YR().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.XS.YR().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.fiE.setVisibility(8);
                    return;
                } else if (this.XS.YR().getGodUserData() != null && this.XS.YR().getGodUserData().getIsLike()) {
                    if (this.XS.YR().getGodUserData().getIsFromNetWork()) {
                        this.fiE.setVisibility(8);
                    } else {
                        this.fiE.setVisibility(0);
                        this.fiE.f(true, 1);
                    }
                } else {
                    this.fiE.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.drw.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fiE.getLayoutParams();
            if (bgVar.Zm() != null) {
                layoutParams.topMargin = i + l.h(this.mPageContext.getPageActivity(), d.e.ds4);
            } else {
                layoutParams.topMargin = l.h(this.mPageContext.getPageActivity(), d.e.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            al.j(this.fiD, d.C0277d.cp_cont_d);
            this.fiE.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void k(BdUniqueId bdUniqueId) {
        super.k(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qD(int i) {
        if (this.fiD != null) {
            String string = this.mPageContext.getResources().getString(d.j.fans_default_name_god_user);
            if (this.XS != null && !StringUtils.isNull(this.XS.YW()) && this.XS.YW().equals(this.mForumName)) {
                if (this.XS.YU()) {
                    String format = String.format(string, ap.as(i));
                    this.fiD.setVisibility(0);
                    this.fiD.setText(format);
                    return;
                }
                this.fiD.setVisibility(8);
                return;
            }
            this.fiD.setText(this.mPageContext.getResources().getString(d.j.default_personalized_name));
        }
    }
}
