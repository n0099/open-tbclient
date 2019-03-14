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
    private c ehx;
    public ClickableHeaderImageView fAy;
    public CommonUserLikeButton fEI;
    private TextView fEJ;
    private TextView fEK;
    private TextView fEL;
    private Drawable fEM;
    private MetaData fEN;
    private f fEO;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.fAy = (ClickableHeaderImageView) getView().findViewById(d.g.god_header_view);
        this.fAy.setGodIconMargin(d.e.ds4);
        this.fAy.setAfterClickListener(this);
        this.fEK = (TextView) getView().findViewById(d.g.god_name);
        this.fEL = (TextView) getView().findViewById(d.g.god_describe);
        this.fEI = (CommonUserLikeButton) getView().findViewById(d.g.god_like_btn);
        this.ehx = new c(tbPageContext, this.fEI);
        this.fEI.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(d.g.bottom_line);
        this.fEJ = (TextView) getView().findViewById(d.g.god_rank);
        this.fEM = this.mPageContext.getResources().getDrawable(d.f.transparent_bg);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.f.home_thread_card_item_bg);
            al.j(this.fEK, d.C0277d.cp_cont_b);
            al.j(this.fEL, d.C0277d.cp_cont_d);
            al.l(this.mBottomLine, d.C0277d.cp_bg_line_b);
            al.j(this.fEJ, d.C0277d.cp_cont_d);
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
        if (fVar != null && fVar.bBG != null && fVar.bBG.getGodUserData() != null) {
            this.fEO = fVar;
            this.fEN = fVar.bBG;
            sh(fVar.rank);
            this.fAy.setData(fVar.bBG);
            this.fEK.setText(fVar.bBG.getName_show());
            this.fEL.setText(fVar.bBG.getGodUserData().getIntro());
            this.ehx.a(fVar.bBG);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void sh(int i) {
        String str;
        switch (i) {
            case 1:
                this.fEJ.setText("");
                al.k(this.fEJ, d.f.icon_grade_round_no1);
                return;
            case 2:
                this.fEJ.setText("");
                al.k(this.fEJ, d.f.icon_grade_round_no2);
                return;
            case 3:
                this.fEJ.setText("");
                al.k(this.fEJ, d.f.icon_grade_round_no3);
                return;
            default:
                this.fEJ.setBackgroundDrawable(this.fEM);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.fEJ.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aQh() != null) {
            aQh().a(view, this.fEO);
        }
        if (view == getView() && this.fEN != null && !StringUtils.isNull(this.fEN.getName_show()) && !StringUtils.isNull(this.fEN.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(this.fEN.getUserId(), 0L), false, this.fEN.isBigV())));
        }
    }
}
