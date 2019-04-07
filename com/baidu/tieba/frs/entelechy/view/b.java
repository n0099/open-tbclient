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
    private com.baidu.tbadk.core.view.userLike.c ehj;
    public TextView fio;
    public EntelechyUserLikeButton fip;
    private CommonUserLikeButton.a fiq;
    private View.OnClickListener fir;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.fiq = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void il(int i) {
                b.this.qz(i);
            }
        };
        this.fir = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.XS != null && b.this.XS.YO() != null && !StringUtils.isNull(b.this.XS.YO().getName_show()) && !StringUtils.isNull(b.this.XS.YO().getUserId()) && b.this.XS.YT() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.XS.YO().getUserId(), b.this.XS.YO().getName_show(), b.this.XS.YT(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fio = new TextView(tbPageContext.getPageActivity());
        this.fio.setIncludeFontPadding(false);
        this.fio.setTextSize(0, l.h(tbPageContext.getPageActivity(), d.e.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.h(tbPageContext.getPageActivity(), d.e.ds6);
        this.fio.setLayoutParams(layoutParams);
        this.fio.setOnClickListener(this.fir);
        this.dry.addView(this.fio, 1);
        this.fip = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.fip.setFanNumCallBack(this.fiq);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.h(this.mPageContext.getPageActivity(), d.e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, d.g.header_divider);
        layoutParams2.rightMargin = l.h(this.mPageContext.getPageActivity(), d.e.ds32);
        layoutParams2.topMargin = l.h(this.mPageContext.getPageActivity(), d.e.ds24);
        this.fip.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.fip);
        this.ehj = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.fip);
        this.ehj.setFromType("1");
        this.ehj.i(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void a(bg bgVar) {
        super.a(bgVar);
        if (bgVar != null) {
            this.XS = bgVar;
            if (bgVar.YO() != null) {
                this.ehj.a(bgVar.YO());
                qz(bgVar.YO().getFansNum());
                if (!this.XS.YR()) {
                    this.fip.setVisibility(8);
                } else if (this.XS.YO().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.XS.YO().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.fip.setVisibility(8);
                    return;
                } else if (this.XS.YO().getGodUserData() != null && this.XS.YO().getGodUserData().getIsLike()) {
                    if (this.XS.YO().getGodUserData().getIsFromNetWork()) {
                        this.fip.setVisibility(8);
                    } else {
                        this.fip.setVisibility(0);
                        this.fip.f(true, 1);
                    }
                } else {
                    this.fip.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.drz.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fip.getLayoutParams();
            if (bgVar.Zj() != null) {
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
            al.j(this.fio, d.C0277d.cp_cont_d);
            this.fip.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void k(BdUniqueId bdUniqueId) {
        super.k(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qz(int i) {
        if (this.fio != null) {
            String string = this.mPageContext.getResources().getString(d.j.fans_default_name_god_user);
            if (this.XS != null && !StringUtils.isNull(this.XS.YT()) && this.XS.YT().equals(this.mForumName)) {
                if (this.XS.YR()) {
                    String format = String.format(string, ap.as(i));
                    this.fio.setVisibility(0);
                    this.fio.setText(format);
                    return;
                }
                this.fio.setVisibility(8);
                return;
            }
            this.fio.setText(this.mPageContext.getResources().getString(d.j.default_personalized_name));
        }
    }
}
