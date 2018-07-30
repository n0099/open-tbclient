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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b extends a {
    private bb atD;
    private com.baidu.tbadk.core.view.userLike.c cyt;
    public TextView dva;
    public EntelechyUserLikeButton dvb;
    private CommonUserLikeButton.a dvc;
    private View.OnClickListener dvd;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.dvc = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dJ(int i) {
                b.this.kV(i);
            }
        };
        this.dvd = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.atD != null && b.this.atD.vk() != null && !StringUtils.isNull(b.this.atD.vk().getName_show()) && !StringUtils.isNull(b.this.atD.vk().getUserId()) && b.this.atD.vq() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.atD.vk().getUserId(), b.this.atD.vk().getName_show(), b.this.atD.vq(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.dva = new TextView(tbPageContext.getPageActivity());
        this.dva.setIncludeFontPadding(false);
        this.dva.setTextSize(0, l.f(tbPageContext.getPageActivity(), d.e.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.f(tbPageContext.getPageActivity(), d.e.ds6);
        this.dva.setLayoutParams(layoutParams);
        this.dva.setOnClickListener(this.dvd);
        this.bIN.addView(this.dva, 1);
        this.dvb = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.dvb.setFanNumCallBack(this.dvc);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.f(this.mPageContext.getPageActivity(), d.e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, d.g.header_divider);
        layoutParams2.rightMargin = l.f(this.mPageContext.getPageActivity(), d.e.ds32);
        layoutParams2.topMargin = l.f(this.mPageContext.getPageActivity(), d.e.ds24);
        this.dvb.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.dvb);
        this.cyt = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dvb);
        this.cyt.setFromType("1");
        this.cyt.h(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: E */
    public void a(bb bbVar) {
        super.a(bbVar);
        if (bbVar != null) {
            this.atD = bbVar;
            if (bbVar.vk() != null) {
                this.cyt.a(bbVar.vk());
                kV(bbVar.vk().getFansNum());
                if (!this.atD.vn()) {
                    this.dvb.setVisibility(8);
                } else if (this.atD.vk().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.atD.vk().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.dvb.setVisibility(8);
                    return;
                } else if (this.atD.vk().getGodUserData() != null && this.atD.vk().getGodUserData().getIsLike()) {
                    if (this.atD.vk().getGodUserData().getIsFromNetWork()) {
                        this.dvb.setVisibility(8);
                    } else {
                        this.dvb.setVisibility(0);
                        this.dvb.d(true, 1);
                    }
                } else {
                    this.dvb.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.bIO.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dvb.getLayoutParams();
            if (bbVar.vF() != null) {
                layoutParams.topMargin = i + l.f(this.mPageContext.getPageActivity(), d.e.ds4);
            } else {
                layoutParams.topMargin = l.f(this.mPageContext.getPageActivity(), d.e.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            am.h(this.dva, d.C0140d.cp_cont_d);
            this.dvb.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kV(int i) {
        if (this.dva != null) {
            String string = this.mPageContext.getResources().getString(d.j.fans_default_name_god_user);
            if (this.atD != null && !StringUtils.isNull(this.atD.vq()) && this.atD.vq().equals(this.mForumName)) {
                if (this.atD.vn()) {
                    String format = String.format(string, ap.A(i));
                    this.dva.setVisibility(0);
                    this.dva.setText(format);
                    return;
                }
                this.dva.setVisibility(8);
                return;
            }
            this.dva.setText(this.mPageContext.getResources().getString(d.j.default_personalized_name));
        }
    }
}
