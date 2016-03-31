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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class s extends a<com.baidu.tieba.card.a.k> {
    private TbPageContext<?> ND;
    private View Nu;
    private TextView aSA;
    private TextView aSB;
    private TextView aSC;
    private Drawable aSD;
    private MetaData aSE;
    private com.baidu.tieba.card.a.k aSF;
    public UserLikeButton aSy;
    public ClickableHeaderImageView aSz;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ND = tbPageContext;
        getView().setOnClickListener(this);
        this.aSz = (ClickableHeaderImageView) getView().findViewById(t.g.god_header_view);
        this.aSz.setGodIconMargin(t.e.ds4);
        this.aSz.setAfterClickListener(this);
        this.aSB = (TextView) getView().findViewById(t.g.god_name);
        this.aSC = (TextView) getView().findViewById(t.g.god_describe);
        this.aSy = (UserLikeButton) getView().findViewById(t.g.god_like_btn);
        this.aSy.setAfterClickListener(this);
        this.Nu = getView().findViewById(t.g.bottom_line);
        this.aSA = (TextView) getView().findViewById(t.g.god_rank);
        this.aSD = this.ND.getResources().getDrawable(t.f.transparent_bg);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aSy != null) {
            this.aSy.i(bdUniqueId);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.k(getView(), t.f.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.at.j((View) this.aSB, t.d.cp_cont_b);
            com.baidu.tbadk.core.util.at.j((View) this.aSC, t.d.cp_cont_d);
            com.baidu.tbadk.core.util.at.l(this.Nu, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.at.j((View) this.aSA, t.d.cp_cont_d);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int Le() {
        return t.h.card_god_square_hot_god;
    }

    public void a(com.baidu.tieba.card.a.k kVar) {
        if (kVar != null && kVar.author != null && kVar.author.getGodUserData() != null) {
            this.aSF = kVar;
            this.aSE = kVar.author;
            fM(kVar.rank);
            this.aSz.setData(kVar.author);
            this.aSB.setText(kVar.author.getName_show());
            this.aSC.setText(kVar.author.getGodUserData().getIntro());
            this.aSy.setData(kVar.author);
            d(null, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    private void fM(int i) {
        String sb;
        switch (i) {
            case 1:
                this.aSA.setText("");
                com.baidu.tbadk.core.util.at.k(this.aSA, t.f.icon_grade_round_no1);
                return;
            case 2:
                this.aSA.setText("");
                com.baidu.tbadk.core.util.at.k(this.aSA, t.f.icon_grade_round_no2);
                return;
            case 3:
                this.aSA.setText("");
                com.baidu.tbadk.core.util.at.k(this.aSA, t.f.icon_grade_round_no3);
                return;
            default:
                this.aSA.setBackgroundDrawable(this.aSD);
                if (i < 100) {
                    sb = String.format("%02d", Integer.valueOf(i));
                } else {
                    sb = new StringBuilder(String.valueOf(i)).toString();
                }
                this.aSA.setText(sb);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (Ld() != null) {
            Ld().a(view, this.aSF);
        }
        if (view == getView() && this.aSE != null && !StringUtils.isNull(this.aSE.getName_show()) && !StringUtils.isNull(this.aSE.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.ND.getPageActivity(), this.aSE.getUserId(), this.aSE.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
