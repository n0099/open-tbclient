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
    private c cWj;
    public ClickableHeaderImageView dZU;
    public CommonUserLikeButton eeq;
    private TextView eer;
    private TextView ees;
    private TextView eet;
    private Drawable eeu;
    private MetaData eev;
    private f eew;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.dZU = (ClickableHeaderImageView) getView().findViewById(d.g.god_header_view);
        this.dZU.setGodIconMargin(d.e.ds4);
        this.dZU.setAfterClickListener(this);
        this.ees = (TextView) getView().findViewById(d.g.god_name);
        this.eet = (TextView) getView().findViewById(d.g.god_describe);
        this.eeq = (CommonUserLikeButton) getView().findViewById(d.g.god_like_btn);
        this.cWj = new c(tbPageContext, this.eeq);
        this.eeq.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(d.g.bottom_line);
        this.eer = (TextView) getView().findViewById(d.g.god_rank);
        this.eeu = this.mPageContext.getResources().getDrawable(d.f.transparent_bg);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.home_thread_card_item_bg);
            aj.r(this.ees, d.C0140d.cp_cont_b);
            aj.r(this.eet, d.C0140d.cp_cont_d);
            aj.t(this.mBottomLine, d.C0140d.cp_bg_line_b);
            aj.r(this.eer, d.C0140d.cp_cont_d);
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
        if (fVar != null && fVar.aOQ != null && fVar.aOQ.getGodUserData() != null) {
            this.eew = fVar;
            this.eev = fVar.aOQ;
            os(fVar.rank);
            this.dZU.setData(fVar.aOQ);
            this.ees.setText(fVar.aOQ.getName_show());
            this.eet.setText(fVar.aOQ.getGodUserData().getIntro());
            this.cWj.a(fVar.aOQ);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void os(int i) {
        String str;
        switch (i) {
            case 1:
                this.eer.setText("");
                aj.s(this.eer, d.f.icon_grade_round_no1);
                return;
            case 2:
                this.eer.setText("");
                aj.s(this.eer, d.f.icon_grade_round_no2);
                return;
            case 3:
                this.eer.setText("");
                aj.s(this.eer, d.f.icon_grade_round_no3);
                return;
            default:
                this.eer.setBackgroundDrawable(this.eeu);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.eer.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (akP() != null) {
            akP().a(view, this.eew);
        }
        if (view == getView() && this.eev != null && !StringUtils.isNull(this.eev.getName_show()) && !StringUtils.isNull(this.eev.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.eev.getUserId(), 0L), false, this.eev.isBigV())));
        }
    }
}
