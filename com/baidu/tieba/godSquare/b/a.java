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
    private c cEg;
    public ClickableHeaderImageView dSy;
    public CommonUserLikeButton dYF;
    private TextView dYG;
    private TextView dYH;
    private TextView dYI;
    private Drawable dYJ;
    private MetaData dYK;
    private f dYL;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.dSy = (ClickableHeaderImageView) getView().findViewById(e.g.god_header_view);
        this.dSy.setGodIconMargin(e.C0141e.ds4);
        this.dSy.setAfterClickListener(this);
        this.dYH = (TextView) getView().findViewById(e.g.god_name);
        this.dYI = (TextView) getView().findViewById(e.g.god_describe);
        this.dYF = (CommonUserLikeButton) getView().findViewById(e.g.god_like_btn);
        this.cEg = new c(tbPageContext, this.dYF);
        this.dYF.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(e.g.bottom_line);
        this.dYG = (TextView) getView().findViewById(e.g.god_rank);
        this.dYJ = this.mPageContext.getResources().getDrawable(e.f.transparent_bg);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.home_thread_card_item_bg);
            al.h(this.dYH, e.d.cp_cont_b);
            al.h(this.dYI, e.d.cp_cont_d);
            al.j(this.mBottomLine, e.d.cp_bg_line_b);
            al.h(this.dYG, e.d.cp_cont_d);
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
        if (fVar != null && fVar.akB != null && fVar.akB.getGodUserData() != null) {
            this.dYL = fVar;
            this.dYK = fVar.akB;
            na(fVar.rank);
            this.dSy.setData(fVar.akB);
            this.dYH.setText(fVar.akB.getName_show());
            this.dYI.setText(fVar.akB.getGodUserData().getIntro());
            this.cEg.a(fVar.akB);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void na(int i) {
        String str;
        switch (i) {
            case 1:
                this.dYG.setText("");
                al.i(this.dYG, e.f.icon_grade_round_no1);
                return;
            case 2:
                this.dYG.setText("");
                al.i(this.dYG, e.f.icon_grade_round_no2);
                return;
            case 3:
                this.dYG.setText("");
                al.i(this.dYG, e.f.icon_grade_round_no3);
                return;
            default:
                this.dYG.setBackgroundDrawable(this.dYJ);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.dYG.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (akm() != null) {
            akm().a(view, this.dYL);
        }
        if (view == getView() && this.dYK != null && !StringUtils.isNull(this.dYK.getName_show()) && !StringUtils.isNull(this.dYK.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(this.dYK.getUserId(), 0L), false, this.dYK.isBigV())));
        }
    }
}
