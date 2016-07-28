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
    private TbPageContext<?> EA;
    private View Eo;
    public UserLikeButton aTa;
    public ClickableHeaderImageView aTq;
    private TextView aTs;
    private TextView aTt;
    private MetaData aTv;
    private com.baidu.tieba.card.a.i aTw;
    private TextView aTx;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.EA = tbPageContext;
        getView().setOnClickListener(this);
        this.aTq = (ClickableHeaderImageView) getView().findViewById(u.g.god_header_view);
        this.aTq.setGodIconMargin(u.e.ds6);
        this.aTq.setAfterClickListener(this);
        this.aTs = (TextView) getView().findViewById(u.g.god_name);
        this.aTt = (TextView) getView().findViewById(u.g.god_describe);
        this.aTx = (TextView) getView().findViewById(u.g.rec_reason);
        this.aTa = (UserLikeButton) getView().findViewById(u.g.god_like_btn);
        this.aTa.setAfterClickListener(this);
        this.Eo = getView().findViewById(u.g.bottom_line);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aTa != null) {
            this.aTa.i(bdUniqueId);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(getView(), u.f.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.av.j((View) this.aTs, u.d.cp_cont_b);
            com.baidu.tbadk.core.util.av.j((View) this.aTt, u.d.cp_cont_d);
            com.baidu.tbadk.core.util.av.j((View) this.aTx, u.d.cp_cont_d);
            com.baidu.tbadk.core.util.av.l(this.Eo, u.d.cp_bg_line_b);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_god_square_rec_god;
    }

    public void a(com.baidu.tieba.card.a.i iVar) {
        if (iVar != null && iVar.author != null && iVar.author.getGodUserData() != null) {
            this.aTw = iVar;
            this.aTv = iVar.author;
            this.aTq.setData(iVar.author);
            this.aTs.setText(iVar.author.getName_show());
            this.aTt.setText(iVar.author.getGodUserData().getIntro());
            String string = this.EA.getResources().getString(u.j.recommend_reason);
            String recommendReason = iVar.author.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.aTx.setText("");
            } else {
                this.aTx.setText(String.format(string, recommendReason));
            }
            this.aTa.setData(iVar.author);
            d(null, TbadkCoreApplication.m10getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (KN() != null) {
            KN().a(view, this.aTw);
        }
        if (view == getView() && this.aTv != null && !StringUtils.isNull(this.aTv.getName_show()) && !StringUtils.isNull(this.aTv.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.EA.getPageActivity(), this.aTv.getUserId(), this.aTv.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
