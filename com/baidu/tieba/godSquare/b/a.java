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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<f> {
    private c cNG;
    public ClickableHeaderImageView ebN;
    public CommonUserLikeButton ehT;
    private TextView ehU;
    private TextView ehV;
    private TextView ehW;
    private Drawable ehX;
    private MetaData ehY;
    private f ehZ;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.ebN = (ClickableHeaderImageView) getView().findViewById(e.g.god_header_view);
        this.ebN.setGodIconMargin(e.C0200e.ds4);
        this.ebN.setAfterClickListener(this);
        this.ehV = (TextView) getView().findViewById(e.g.god_name);
        this.ehW = (TextView) getView().findViewById(e.g.god_describe);
        this.ehT = (CommonUserLikeButton) getView().findViewById(e.g.god_like_btn);
        this.cNG = new c(tbPageContext, this.ehT);
        this.ehT.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(e.g.bottom_line);
        this.ehU = (TextView) getView().findViewById(e.g.god_rank);
        this.ehX = this.mPageContext.getResources().getDrawable(e.f.transparent_bg);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.home_thread_card_item_bg);
            al.h(this.ehV, e.d.cp_cont_b);
            al.h(this.ehW, e.d.cp_cont_d);
            al.j(this.mBottomLine, e.d.cp_bg_line_b);
            al.h(this.ehU, e.d.cp_cont_d);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_god_square_hot_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(f fVar) {
        if (fVar != null && fVar.aqk != null && fVar.aqk.getGodUserData() != null) {
            this.ehZ = fVar;
            this.ehY = fVar.aqk;
            nQ(fVar.rank);
            this.ebN.setData(fVar.aqk);
            this.ehV.setText(fVar.aqk.getName_show());
            this.ehW.setText(fVar.aqk.getGodUserData().getIntro());
            this.cNG.a(fVar.aqk);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void nQ(int i) {
        String str;
        switch (i) {
            case 1:
                this.ehU.setText("");
                al.i(this.ehU, e.f.icon_grade_round_no1);
                return;
            case 2:
                this.ehU.setText("");
                al.i(this.ehU, e.f.icon_grade_round_no2);
                return;
            case 3:
                this.ehU.setText("");
                al.i(this.ehU, e.f.icon_grade_round_no3);
                return;
            default:
                this.ehU.setBackgroundDrawable(this.ehX);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.ehU.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (anq() != null) {
            anq().a(view, this.ehZ);
        }
        if (view == getView() && this.ehY != null && !StringUtils.isNull(this.ehY.getName_show()) && !StringUtils.isNull(this.ehY.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(this.ehY.getUserId(), 0L), false, this.ehY.isBigV())));
        }
    }
}
