package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
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
public class n extends a<com.baidu.tieba.card.a.i> {
    private TbPageContext<?> EA;
    private View Eo;
    public UserLikeButton aTa;
    public ClickableHeaderImageView aTq;
    private TextView aTr;
    private TextView aTs;
    private TextView aTt;
    private Drawable aTu;
    private MetaData aTv;
    private com.baidu.tieba.card.a.i aTw;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.EA = tbPageContext;
        getView().setOnClickListener(this);
        this.aTq = (ClickableHeaderImageView) getView().findViewById(u.g.god_header_view);
        this.aTq.setGodIconMargin(u.e.ds4);
        this.aTq.setAfterClickListener(this);
        this.aTs = (TextView) getView().findViewById(u.g.god_name);
        this.aTt = (TextView) getView().findViewById(u.g.god_describe);
        this.aTa = (UserLikeButton) getView().findViewById(u.g.god_like_btn);
        this.aTa.setAfterClickListener(this);
        this.Eo = getView().findViewById(u.g.bottom_line);
        this.aTr = (TextView) getView().findViewById(u.g.god_rank);
        this.aTu = this.EA.getResources().getDrawable(u.f.transparent_bg);
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
            com.baidu.tbadk.core.util.av.l(this.Eo, u.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.av.j((View) this.aTr, u.d.cp_cont_d);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_god_square_hot_god;
    }

    public void a(com.baidu.tieba.card.a.i iVar) {
        if (iVar != null && iVar.author != null && iVar.author.getGodUserData() != null) {
            this.aTw = iVar;
            this.aTv = iVar.author;
            fF(iVar.rank);
            this.aTq.setData(iVar.author);
            this.aTs.setText(iVar.author.getName_show());
            this.aTt.setText(iVar.author.getGodUserData().getIntro());
            this.aTa.setData(iVar.author);
            d(null, TbadkCoreApplication.m10getInst().getSkinType());
        }
    }

    private void fF(int i) {
        String sb;
        switch (i) {
            case 1:
                this.aTr.setText("");
                com.baidu.tbadk.core.util.av.k(this.aTr, u.f.icon_grade_round_no1);
                return;
            case 2:
                this.aTr.setText("");
                com.baidu.tbadk.core.util.av.k(this.aTr, u.f.icon_grade_round_no2);
                return;
            case 3:
                this.aTr.setText("");
                com.baidu.tbadk.core.util.av.k(this.aTr, u.f.icon_grade_round_no3);
                return;
            default:
                this.aTr.setBackgroundDrawable(this.aTu);
                if (i < 100) {
                    sb = String.format("%02d", Integer.valueOf(i));
                } else {
                    sb = new StringBuilder(String.valueOf(i)).toString();
                }
                this.aTr.setText(sb);
                return;
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
