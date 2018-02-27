package com.baidu.tieba.godSquare.b;

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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.card.data.f;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<f> {
    private c cVX;
    public ClickableHeaderImageView dZI;
    public CommonUserLikeButton eee;
    private TextView eef;
    private TextView eeg;
    private TextView eeh;
    private Drawable eei;
    private MetaData eej;
    private f eek;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.dZI = (ClickableHeaderImageView) getView().findViewById(d.g.god_header_view);
        this.dZI.setGodIconMargin(d.e.ds4);
        this.dZI.setAfterClickListener(this);
        this.eeg = (TextView) getView().findViewById(d.g.god_name);
        this.eeh = (TextView) getView().findViewById(d.g.god_describe);
        this.eee = (CommonUserLikeButton) getView().findViewById(d.g.god_like_btn);
        this.cVX = new c(tbPageContext, this.eee);
        this.eee.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(d.g.bottom_line);
        this.eef = (TextView) getView().findViewById(d.g.god_rank);
        this.eei = this.mPageContext.getResources().getDrawable(d.f.transparent_bg);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.home_thread_card_item_bg);
            aj.r(this.eeg, d.C0141d.cp_cont_b);
            aj.r(this.eeh, d.C0141d.cp_cont_d);
            aj.t(this.mBottomLine, d.C0141d.cp_bg_line_b);
            aj.r(this.eef, d.C0141d.cp_cont_d);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_god_square_hot_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(f fVar) {
        if (fVar != null && fVar.aOF != null && fVar.aOF.getGodUserData() != null) {
            this.eek = fVar;
            this.eej = fVar.aOF;
            os(fVar.rank);
            this.dZI.setData(fVar.aOF);
            this.eeg.setText(fVar.aOF.getName_show());
            this.eeh.setText(fVar.aOF.getGodUserData().getIntro());
            this.cVX.a(fVar.aOF);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void os(int i) {
        String str;
        switch (i) {
            case 1:
                this.eef.setText("");
                aj.s(this.eef, d.f.icon_grade_round_no1);
                return;
            case 2:
                this.eef.setText("");
                aj.s(this.eef, d.f.icon_grade_round_no2);
                return;
            case 3:
                this.eef.setText("");
                aj.s(this.eef, d.f.icon_grade_round_no3);
                return;
            default:
                this.eef.setBackgroundDrawable(this.eei);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.eef.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (akO() != null) {
            akO().a(view, this.eek);
        }
        if (view == getView() && this.eej != null && !StringUtils.isNull(this.eej.getName_show()) && !StringUtils.isNull(this.eej.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.eej.getUserId(), 0L), false, this.eej.isBigV())));
        }
    }
}
