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
public class o extends a<com.baidu.tieba.card.a.h> {
    private View DM;
    private TbPageContext<?> DV;
    public UserLikeButton aOX;
    public ClickableHeaderImageView aOY;
    private TextView aPa;
    private TextView aPb;
    private MetaData aPd;
    private com.baidu.tieba.card.a.h aPe;
    private TextView aPf;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.DV = tbPageContext;
        getView().setOnClickListener(this);
        this.aOY = (ClickableHeaderImageView) getView().findViewById(t.g.god_header_view);
        this.aOY.setGodIconMargin(t.e.ds6);
        this.aOY.setAfterClickListener(this);
        this.aPa = (TextView) getView().findViewById(t.g.god_name);
        this.aPb = (TextView) getView().findViewById(t.g.god_describe);
        this.aPf = (TextView) getView().findViewById(t.g.rec_reason);
        this.aOX = (UserLikeButton) getView().findViewById(t.g.god_like_btn);
        this.aOX.setAfterClickListener(this);
        this.DM = getView().findViewById(t.g.bottom_line);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aOX != null) {
            this.aOX.i(bdUniqueId);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.k(getView(), t.f.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.at.j((View) this.aPa, t.d.cp_cont_b);
            com.baidu.tbadk.core.util.at.j((View) this.aPb, t.d.cp_cont_d);
            com.baidu.tbadk.core.util.at.j((View) this.aPf, t.d.cp_cont_d);
            com.baidu.tbadk.core.util.at.l(this.DM, t.d.cp_bg_line_b);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int JP() {
        return t.h.card_god_square_rec_god;
    }

    public void a(com.baidu.tieba.card.a.h hVar) {
        if (hVar != null && hVar.author != null && hVar.author.getGodUserData() != null) {
            this.aPe = hVar;
            this.aPd = hVar.author;
            this.aOY.setData(hVar.author);
            this.aPa.setText(hVar.author.getName_show());
            this.aPb.setText(hVar.author.getGodUserData().getIntro());
            String string = this.DV.getResources().getString(t.j.recommend_reason);
            String recommendReason = hVar.author.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.aPf.setText("");
            } else {
                this.aPf.setText(String.format(string, recommendReason));
            }
            this.aOX.setData(hVar.author);
            d(null, TbadkCoreApplication.m11getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (JO() != null) {
            JO().a(view, this.aPe);
        }
        if (view == getView() && this.aPd != null && !StringUtils.isNull(this.aPd.getName_show()) && !StringUtils.isNull(this.aPd.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.DV.getPageActivity(), this.aPd.getUserId(), this.aPd.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
