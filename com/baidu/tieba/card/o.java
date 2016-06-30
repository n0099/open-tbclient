package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.UserLikeButton;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class o extends a<com.baidu.tieba.card.a.i> {
    private View DO;
    private TbPageContext<?> Ea;
    private com.baidu.tieba.card.a.i aSA;
    private TextView aSB;
    public UserLikeButton aSe;
    public ClickableHeaderImageView aSu;
    private TextView aSw;
    private TextView aSx;
    private MetaData aSz;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.Ea = tbPageContext;
        getView().setOnClickListener(this);
        this.aSu = (ClickableHeaderImageView) getView().findViewById(u.g.god_header_view);
        this.aSu.setGodIconMargin(u.e.ds6);
        this.aSu.setAfterClickListener(this);
        this.aSw = (TextView) getView().findViewById(u.g.god_name);
        this.aSx = (TextView) getView().findViewById(u.g.god_describe);
        this.aSB = (TextView) getView().findViewById(u.g.rec_reason);
        this.aSe = (UserLikeButton) getView().findViewById(u.g.god_like_btn);
        this.aSe.setAfterClickListener(this);
        this.DO = getView().findViewById(u.g.bottom_line);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aSe != null) {
            this.aSe.i(bdUniqueId);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(getView(), u.f.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.av.j((View) this.aSw, u.d.cp_cont_b);
            com.baidu.tbadk.core.util.av.j((View) this.aSx, u.d.cp_cont_d);
            com.baidu.tbadk.core.util.av.j((View) this.aSB, u.d.cp_cont_d);
            com.baidu.tbadk.core.util.av.l(this.DO, u.d.cp_bg_line_b);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_god_square_rec_god;
    }

    public void a(com.baidu.tieba.card.a.i iVar) {
        if (iVar != null && iVar.author != null && iVar.author.getGodUserData() != null) {
            this.aSA = iVar;
            this.aSz = iVar.author;
            this.aSu.setData(iVar.author);
            this.aSw.setText(iVar.author.getName_show());
            this.aSx.setText(iVar.author.getGodUserData().getIntro());
            String string = this.Ea.getResources().getString(u.j.recommend_reason);
            String recommendReason = iVar.author.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.aSB.setText("");
            } else {
                this.aSB.setText(String.format(string, recommendReason));
            }
            this.aSe.setData(iVar.author);
            d(null, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (KO() != null) {
            KO().a(view, this.aSA);
        }
        if (view == getView() && this.aSz != null && !StringUtils.isNull(this.aSz.getName_show()) && !StringUtils.isNull(this.aSz.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.Ea.getPageActivity(), this.aSz.getUserId(), this.aSz.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
