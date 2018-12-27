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
    private c cXd;
    public ClickableHeaderImageView elg;
    public CommonUserLikeButton erE;
    private TextView erF;
    private TextView erG;
    private TextView erH;
    private Drawable erI;
    private MetaData erJ;
    private f erK;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.elg = (ClickableHeaderImageView) getView().findViewById(e.g.god_header_view);
        this.elg.setGodIconMargin(e.C0210e.ds4);
        this.elg.setAfterClickListener(this);
        this.erG = (TextView) getView().findViewById(e.g.god_name);
        this.erH = (TextView) getView().findViewById(e.g.god_describe);
        this.erE = (CommonUserLikeButton) getView().findViewById(e.g.god_like_btn);
        this.cXd = new c(tbPageContext, this.erE);
        this.erE.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(e.g.bottom_line);
        this.erF = (TextView) getView().findViewById(e.g.god_rank);
        this.erI = this.mPageContext.getResources().getDrawable(e.f.transparent_bg);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.home_thread_card_item_bg);
            al.h(this.erG, e.d.cp_cont_b);
            al.h(this.erH, e.d.cp_cont_d);
            al.j(this.mBottomLine, e.d.cp_bg_line_b);
            al.h(this.erF, e.d.cp_cont_d);
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
        if (fVar != null && fVar.atK != null && fVar.atK.getGodUserData() != null) {
            this.erK = fVar;
            this.erJ = fVar.atK;
            ox(fVar.rank);
            this.elg.setData(fVar.atK);
            this.erG.setText(fVar.atK.getName_show());
            this.erH.setText(fVar.atK.getGodUserData().getIntro());
            this.cXd.a(fVar.atK);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void ox(int i) {
        String str;
        switch (i) {
            case 1:
                this.erF.setText("");
                al.i(this.erF, e.f.icon_grade_round_no1);
                return;
            case 2:
                this.erF.setText("");
                al.i(this.erF, e.f.icon_grade_round_no2);
                return;
            case 3:
                this.erF.setText("");
                al.i(this.erF, e.f.icon_grade_round_no3);
                return;
            default:
                this.erF.setBackgroundDrawable(this.erI);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.erF.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (apS() != null) {
            apS().a(view, this.erK);
        }
        if (view == getView() && this.erJ != null && !StringUtils.isNull(this.erJ.getName_show()) && !StringUtils.isNull(this.erJ.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(this.erJ.getUserId(), 0L), false, this.erJ.isBigV())));
        }
    }
}
