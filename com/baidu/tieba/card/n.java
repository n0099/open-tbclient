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
    private View DO;
    private TbPageContext<?> Ea;
    private com.baidu.tieba.card.a.i aSA;
    public UserLikeButton aSe;
    public ClickableHeaderImageView aSu;
    private TextView aSv;
    private TextView aSw;
    private TextView aSx;
    private Drawable aSy;
    private MetaData aSz;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.Ea = tbPageContext;
        getView().setOnClickListener(this);
        this.aSu = (ClickableHeaderImageView) getView().findViewById(u.g.god_header_view);
        this.aSu.setGodIconMargin(u.e.ds4);
        this.aSu.setAfterClickListener(this);
        this.aSw = (TextView) getView().findViewById(u.g.god_name);
        this.aSx = (TextView) getView().findViewById(u.g.god_describe);
        this.aSe = (UserLikeButton) getView().findViewById(u.g.god_like_btn);
        this.aSe.setAfterClickListener(this);
        this.DO = getView().findViewById(u.g.bottom_line);
        this.aSv = (TextView) getView().findViewById(u.g.god_rank);
        this.aSy = this.Ea.getResources().getDrawable(u.f.transparent_bg);
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
            com.baidu.tbadk.core.util.av.l(this.DO, u.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.av.j((View) this.aSv, u.d.cp_cont_d);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_god_square_hot_god;
    }

    public void a(com.baidu.tieba.card.a.i iVar) {
        if (iVar != null && iVar.author != null && iVar.author.getGodUserData() != null) {
            this.aSA = iVar;
            this.aSz = iVar.author;
            fG(iVar.rank);
            this.aSu.setData(iVar.author);
            this.aSw.setText(iVar.author.getName_show());
            this.aSx.setText(iVar.author.getGodUserData().getIntro());
            this.aSe.setData(iVar.author);
            d(null, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void fG(int i) {
        String sb;
        switch (i) {
            case 1:
                this.aSv.setText("");
                com.baidu.tbadk.core.util.av.k(this.aSv, u.f.icon_grade_round_no1);
                return;
            case 2:
                this.aSv.setText("");
                com.baidu.tbadk.core.util.av.k(this.aSv, u.f.icon_grade_round_no2);
                return;
            case 3:
                this.aSv.setText("");
                com.baidu.tbadk.core.util.av.k(this.aSv, u.f.icon_grade_round_no3);
                return;
            default:
                this.aSv.setBackgroundDrawable(this.aSy);
                if (i < 100) {
                    sb = String.format("%02d", Integer.valueOf(i));
                } else {
                    sb = new StringBuilder(String.valueOf(i)).toString();
                }
                this.aSv.setText(sb);
                return;
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
