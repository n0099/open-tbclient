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
public class n extends a<com.baidu.tieba.card.a.h> {
    private View DM;
    private TbPageContext<?> DV;
    public UserLikeButton aOX;
    public ClickableHeaderImageView aOY;
    private TextView aOZ;
    private TextView aPa;
    private TextView aPb;
    private Drawable aPc;
    private MetaData aPd;
    private com.baidu.tieba.card.a.h aPe;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.DV = tbPageContext;
        getView().setOnClickListener(this);
        this.aOY = (ClickableHeaderImageView) getView().findViewById(t.g.god_header_view);
        this.aOY.setGodIconMargin(t.e.ds4);
        this.aOY.setAfterClickListener(this);
        this.aPa = (TextView) getView().findViewById(t.g.god_name);
        this.aPb = (TextView) getView().findViewById(t.g.god_describe);
        this.aOX = (UserLikeButton) getView().findViewById(t.g.god_like_btn);
        this.aOX.setAfterClickListener(this);
        this.DM = getView().findViewById(t.g.bottom_line);
        this.aOZ = (TextView) getView().findViewById(t.g.god_rank);
        this.aPc = this.DV.getResources().getDrawable(t.f.transparent_bg);
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
            com.baidu.tbadk.core.util.at.l(this.DM, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.at.j((View) this.aOZ, t.d.cp_cont_d);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int JN() {
        return t.h.card_god_square_hot_god;
    }

    public void a(com.baidu.tieba.card.a.h hVar) {
        if (hVar != null && hVar.author != null && hVar.author.getGodUserData() != null) {
            this.aPe = hVar;
            this.aPd = hVar.author;
            fv(hVar.rank);
            this.aOY.setData(hVar.author);
            this.aPa.setText(hVar.author.getName_show());
            this.aPb.setText(hVar.author.getGodUserData().getIntro());
            this.aOX.setData(hVar.author);
            d(null, TbadkCoreApplication.m11getInst().getSkinType());
        }
    }

    private void fv(int i) {
        String sb;
        switch (i) {
            case 1:
                this.aOZ.setText("");
                com.baidu.tbadk.core.util.at.k(this.aOZ, t.f.icon_grade_round_no1);
                return;
            case 2:
                this.aOZ.setText("");
                com.baidu.tbadk.core.util.at.k(this.aOZ, t.f.icon_grade_round_no2);
                return;
            case 3:
                this.aOZ.setText("");
                com.baidu.tbadk.core.util.at.k(this.aOZ, t.f.icon_grade_round_no3);
                return;
            default:
                this.aOZ.setBackgroundDrawable(this.aPc);
                if (i < 100) {
                    sb = String.format("%02d", Integer.valueOf(i));
                } else {
                    sb = new StringBuilder(String.valueOf(i)).toString();
                }
                this.aOZ.setText(sb);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (JM() != null) {
            JM().a(view, this.aPe);
        }
        if (view == getView() && this.aPd != null && !StringUtils.isNull(this.aPd.getName_show()) && !StringUtils.isNull(this.aPd.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.DV.getPageActivity(), this.aPd.getUserId(), this.aPd.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
