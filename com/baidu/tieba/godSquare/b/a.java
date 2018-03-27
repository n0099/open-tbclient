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
    private c cWa;
    public ClickableHeaderImageView dZY;
    private f eeA;
    public CommonUserLikeButton eeu;
    private TextView eev;
    private TextView eew;
    private TextView eex;
    private Drawable eey;
    private MetaData eez;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.dZY = (ClickableHeaderImageView) getView().findViewById(d.g.god_header_view);
        this.dZY.setGodIconMargin(d.e.ds4);
        this.dZY.setAfterClickListener(this);
        this.eew = (TextView) getView().findViewById(d.g.god_name);
        this.eex = (TextView) getView().findViewById(d.g.god_describe);
        this.eeu = (CommonUserLikeButton) getView().findViewById(d.g.god_like_btn);
        this.cWa = new c(tbPageContext, this.eeu);
        this.eeu.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(d.g.bottom_line);
        this.eev = (TextView) getView().findViewById(d.g.god_rank);
        this.eey = this.mPageContext.getResources().getDrawable(d.f.transparent_bg);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.home_thread_card_item_bg);
            aj.r(this.eew, d.C0141d.cp_cont_b);
            aj.r(this.eex, d.C0141d.cp_cont_d);
            aj.t(this.mBottomLine, d.C0141d.cp_bg_line_b);
            aj.r(this.eev, d.C0141d.cp_cont_d);
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
        if (fVar != null && fVar.aOG != null && fVar.aOG.getGodUserData() != null) {
            this.eeA = fVar;
            this.eez = fVar.aOG;
            ot(fVar.rank);
            this.dZY.setData(fVar.aOG);
            this.eew.setText(fVar.aOG.getName_show());
            this.eex.setText(fVar.aOG.getGodUserData().getIntro());
            this.cWa.a(fVar.aOG);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void ot(int i) {
        String str;
        switch (i) {
            case 1:
                this.eev.setText("");
                aj.s(this.eev, d.f.icon_grade_round_no1);
                return;
            case 2:
                this.eev.setText("");
                aj.s(this.eev, d.f.icon_grade_round_no2);
                return;
            case 3:
                this.eev.setText("");
                aj.s(this.eev, d.f.icon_grade_round_no3);
                return;
            default:
                this.eev.setBackgroundDrawable(this.eey);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.eev.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (akP() != null) {
            akP().a(view, this.eeA);
        }
        if (view == getView() && this.eez != null && !StringUtils.isNull(this.eez.getName_show()) && !StringUtils.isNull(this.eez.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.eez.getUserId(), 0L), false, this.eez.isBigV())));
        }
    }
}
