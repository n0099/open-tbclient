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
public class i extends a<com.baidu.tieba.card.data.i> {
    private View GB;
    private TbPageContext<?> GM;
    private TextView aYA;
    private TextView aYB;
    private MetaData aYD;
    private com.baidu.tieba.card.data.i aYE;
    private TextView aYF;
    public UserLikeButton aYi;
    public ClickableHeaderImageView aYy;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.GM = tbPageContext;
        getView().setOnClickListener(this);
        this.aYy = (ClickableHeaderImageView) getView().findViewById(t.g.god_header_view);
        this.aYy.setGodIconMargin(t.e.ds6);
        this.aYy.setAfterClickListener(this);
        this.aYA = (TextView) getView().findViewById(t.g.god_name);
        this.aYB = (TextView) getView().findViewById(t.g.god_describe);
        this.aYF = (TextView) getView().findViewById(t.g.rec_reason);
        this.aYi = (UserLikeButton) getView().findViewById(t.g.god_like_btn);
        this.aYi.setAfterClickListener(this);
        this.GB = getView().findViewById(t.g.bottom_line);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aYi != null) {
            this.aYi.i(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(getView(), t.f.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.av.j((View) this.aYA, t.d.cp_cont_b);
            com.baidu.tbadk.core.util.av.j((View) this.aYB, t.d.cp_cont_d);
            com.baidu.tbadk.core.util.av.j((View) this.aYF, t.d.cp_cont_d);
            com.baidu.tbadk.core.util.av.l(this.GB, t.d.cp_bg_line_b);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return t.h.card_god_square_rec_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.i iVar) {
        if (iVar != null && iVar.author != null && iVar.author.getGodUserData() != null) {
            this.aYE = iVar;
            this.aYD = iVar.author;
            this.aYy.setData(iVar.author);
            this.aYA.setText(iVar.author.getName_show());
            this.aYB.setText(iVar.author.getGodUserData().getIntro());
            String string = this.GM.getResources().getString(t.j.recommend_reason);
            String recommendReason = iVar.author.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.aYF.setText("");
            } else {
                this.aYF.setText(String.format(string, recommendReason));
            }
            this.aYi.setData(iVar.author);
            onChangeSkinType(null, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.aYE);
        }
        if (view == getView() && this.aYD != null && !StringUtils.isNull(this.aYD.getName_show()) && !StringUtils.isNull(this.aYD.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.GM.getPageActivity(), this.aYD.getUserId(), this.aYD.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
