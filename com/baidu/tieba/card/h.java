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
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.UserLikeButton;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class h extends a<com.baidu.tieba.card.data.i> {
    private View GB;
    private TbPageContext<?> GM;
    private TextView aYA;
    private TextView aYB;
    private Drawable aYC;
    private MetaData aYD;
    private com.baidu.tieba.card.data.i aYE;
    public UserLikeButton aYi;
    public ClickableHeaderImageView aYy;
    private TextView aYz;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.GM = tbPageContext;
        getView().setOnClickListener(this);
        this.aYy = (ClickableHeaderImageView) getView().findViewById(t.g.god_header_view);
        this.aYy.setGodIconMargin(t.e.ds4);
        this.aYy.setAfterClickListener(this);
        this.aYA = (TextView) getView().findViewById(t.g.god_name);
        this.aYB = (TextView) getView().findViewById(t.g.god_describe);
        this.aYi = (UserLikeButton) getView().findViewById(t.g.god_like_btn);
        this.aYi.setAfterClickListener(this);
        this.GB = getView().findViewById(t.g.bottom_line);
        this.aYz = (TextView) getView().findViewById(t.g.god_rank);
        this.aYC = this.GM.getResources().getDrawable(t.f.transparent_bg);
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
            com.baidu.tbadk.core.util.av.l(this.GB, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.av.j((View) this.aYz, t.d.cp_cont_d);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return t.h.card_god_square_hot_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.i iVar) {
        if (iVar != null && iVar.author != null && iVar.author.getGodUserData() != null) {
            this.aYE = iVar;
            this.aYD = iVar.author;
            gd(iVar.rank);
            this.aYy.setData(iVar.author);
            this.aYA.setText(iVar.author.getName_show());
            this.aYB.setText(iVar.author.getGodUserData().getIntro());
            this.aYi.setData(iVar.author);
            onChangeSkinType(null, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void gd(int i) {
        String sb;
        switch (i) {
            case 1:
                this.aYz.setText("");
                com.baidu.tbadk.core.util.av.k(this.aYz, t.f.icon_grade_round_no1);
                return;
            case 2:
                this.aYz.setText("");
                com.baidu.tbadk.core.util.av.k(this.aYz, t.f.icon_grade_round_no2);
                return;
            case 3:
                this.aYz.setText("");
                com.baidu.tbadk.core.util.av.k(this.aYz, t.f.icon_grade_round_no3);
                return;
            default:
                this.aYz.setBackgroundDrawable(this.aYC);
                if (i < 100) {
                    sb = String.format("%02d", Integer.valueOf(i));
                } else {
                    sb = new StringBuilder(String.valueOf(i)).toString();
                }
                this.aYz.setText(sb);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.aYE);
        }
        if (view == getView() && this.aYD != null && !StringUtils.isNull(this.aYD.getName_show()) && !StringUtils.isNull(this.aYD.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.GM.getPageActivity()).createNormalConfig(com.baidu.adp.lib.h.b.c(this.aYD.getUserId(), 0L), false)));
        }
    }
}
