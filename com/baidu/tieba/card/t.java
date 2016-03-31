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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class t extends a<com.baidu.tieba.card.a.k> {
    private TbPageContext<?> ND;
    private View Nu;
    private TextView aSB;
    private TextView aSC;
    private MetaData aSE;
    private com.baidu.tieba.card.a.k aSF;
    private TextView aSG;
    public UserLikeButton aSy;
    public ClickableHeaderImageView aSz;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ND = tbPageContext;
        getView().setOnClickListener(this);
        this.aSz = (ClickableHeaderImageView) getView().findViewById(t.g.god_header_view);
        this.aSz.setGodIconMargin(t.e.ds6);
        this.aSz.setAfterClickListener(this);
        this.aSB = (TextView) getView().findViewById(t.g.god_name);
        this.aSC = (TextView) getView().findViewById(t.g.god_describe);
        this.aSG = (TextView) getView().findViewById(t.g.rec_reason);
        this.aSy = (UserLikeButton) getView().findViewById(t.g.god_like_btn);
        this.aSy.setAfterClickListener(this);
        this.Nu = getView().findViewById(t.g.bottom_line);
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
            com.baidu.tbadk.core.util.at.j((View) this.aSG, t.d.cp_cont_d);
            com.baidu.tbadk.core.util.at.l(this.Nu, t.d.cp_bg_line_b);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int Le() {
        return t.h.card_god_square_rec_god;
    }

    public void a(com.baidu.tieba.card.a.k kVar) {
        if (kVar != null && kVar.author != null && kVar.author.getGodUserData() != null) {
            this.aSF = kVar;
            this.aSE = kVar.author;
            this.aSz.setData(kVar.author);
            this.aSB.setText(kVar.author.getName_show());
            this.aSC.setText(kVar.author.getGodUserData().getIntro());
            String string = this.ND.getResources().getString(t.j.recommend_reason);
            String recommendReason = kVar.author.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.aSG.setText("");
            } else {
                this.aSG.setText(String.format(string, recommendReason));
            }
            this.aSy.setData(kVar.author);
            d(null, TbadkCoreApplication.m411getInst().getSkinType());
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
