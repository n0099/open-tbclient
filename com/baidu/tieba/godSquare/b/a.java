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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.card.data.f;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.a<f> {
    private c ehj;
    public ClickableHeaderImageView fAm;
    private Drawable fEA;
    private MetaData fEB;
    private f fEC;
    public CommonUserLikeButton fEw;
    private TextView fEx;
    private TextView fEy;
    private TextView fEz;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.fAm = (ClickableHeaderImageView) getView().findViewById(d.g.god_header_view);
        this.fAm.setGodIconMargin(d.e.ds4);
        this.fAm.setAfterClickListener(this);
        this.fEy = (TextView) getView().findViewById(d.g.god_name);
        this.fEz = (TextView) getView().findViewById(d.g.god_describe);
        this.fEw = (CommonUserLikeButton) getView().findViewById(d.g.god_like_btn);
        this.ehj = new c(tbPageContext, this.fEw);
        this.fEw.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(d.g.bottom_line);
        this.fEx = (TextView) getView().findViewById(d.g.god_rank);
        this.fEA = this.mPageContext.getResources().getDrawable(d.f.transparent_bg);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.f.home_thread_card_item_bg);
            al.j(this.fEy, d.C0277d.cp_cont_b);
            al.j(this.fEz, d.C0277d.cp_cont_d);
            al.l(this.mBottomLine, d.C0277d.cp_bg_line_b);
            al.j(this.fEx, d.C0277d.cp_cont_d);
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
        if (fVar != null && fVar.bBJ != null && fVar.bBJ.getGodUserData() != null) {
            this.fEC = fVar;
            this.fEB = fVar.bBJ;
            sd(fVar.rank);
            this.fAm.setData(fVar.bBJ);
            this.fEy.setText(fVar.bBJ.getName_show());
            this.fEz.setText(fVar.bBJ.getGodUserData().getIntro());
            this.ehj.a(fVar.bBJ);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void sd(int i) {
        String str;
        switch (i) {
            case 1:
                this.fEx.setText("");
                al.k(this.fEx, d.f.icon_grade_round_no1);
                return;
            case 2:
                this.fEx.setText("");
                al.k(this.fEx, d.f.icon_grade_round_no2);
                return;
            case 3:
                this.fEx.setText("");
                al.k(this.fEx, d.f.icon_grade_round_no3);
                return;
            default:
                this.fEx.setBackgroundDrawable(this.fEA);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.fEx.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aQf() != null) {
            aQf().a(view, this.fEC);
        }
        if (view == getView() && this.fEB != null && !StringUtils.isNull(this.fEB.getName_show()) && !StringUtils.isNull(this.fEB.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(this.fEB.getUserId(), 0L), false, this.fEB.isBigV())));
        }
    }
}
