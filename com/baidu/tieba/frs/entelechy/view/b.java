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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class b extends a {
    private bw afL;
    private com.baidu.tbadk.core.view.userLike.c aje;
    public TextView ifn;
    public EntelechyUserLikeButton ifo;
    private CommonUserLikeButton.a ifp;
    private View.OnClickListener ifq;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.ifp = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void pl(int i) {
                b.this.xP(i);
            }
        };
        this.ifq = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.afL != null && b.this.afL.beE() != null && !StringUtils.isNull(b.this.afL.beE().getName_show()) && !StringUtils.isNull(b.this.afL.beE().getUserId()) && b.this.afL.beI() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.afL.beE().getUserId(), b.this.afL.beE().getName_show(), b.this.afL.beI(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.ifn = new TextView(tbPageContext.getPageActivity());
        this.ifn.setIncludeFontPadding(false);
        this.ifn.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.ifn.setLayoutParams(layoutParams);
        this.ifn.setOnClickListener(this.ifq);
        this.fuq.addView(this.ifn, 1);
        this.ifo = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.ifo.setFanNumCallBack(this.ifp);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.ifo.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.ifo);
        this.aje = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.ifo);
        this.aje.zm("1");
        this.aje.m(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.b
    public void a(bw bwVar) {
        super.a(bwVar);
        if (bwVar != null) {
            this.afL = bwVar;
            if (bwVar.beE() != null) {
                this.aje.a(bwVar.beE());
                xP(bwVar.beE().getFansNum());
                if (!this.afL.beH()) {
                    this.ifo.setVisibility(8);
                } else if (this.afL.beE().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.afL.beE().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.ifo.setVisibility(8);
                    return;
                } else if (this.afL.beE().getGodUserData() != null && this.afL.beE().getGodUserData().getIsLike()) {
                    if (this.afL.beE().getGodUserData().getIsFromNetWork()) {
                        this.ifo.setVisibility(8);
                    } else {
                        this.ifo.setVisibility(0);
                        this.ifo.r(true, 1);
                    }
                } else {
                    this.ifo.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.gkb.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ifo.getLayoutParams();
            if (bwVar.bfa() != null) {
                layoutParams.topMargin = i + l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds4);
            } else {
                layoutParams.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.ifn, R.color.cp_cont_d);
            this.ifo.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void p(BdUniqueId bdUniqueId) {
        super.p(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xP(int i) {
        if (this.ifn != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.afL != null && !StringUtils.isNull(this.afL.beI()) && this.afL.beI().equals(this.mForumName)) {
                if (this.afL.beH()) {
                    String format = String.format(string, at.numberUniformFormat(i));
                    this.ifn.setVisibility(0);
                    this.ifn.setText(format);
                    return;
                }
                this.ifn.setVisibility(8);
                return;
            }
            this.ifn.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
