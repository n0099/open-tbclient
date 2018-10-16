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
    private c cMA;
    public ClickableHeaderImageView eas;
    private TextView egA;
    private TextView egB;
    private Drawable egC;
    private MetaData egD;
    private f egE;
    public CommonUserLikeButton egy;
    private TextView egz;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.eas = (ClickableHeaderImageView) getView().findViewById(e.g.god_header_view);
        this.eas.setGodIconMargin(e.C0175e.ds4);
        this.eas.setAfterClickListener(this);
        this.egA = (TextView) getView().findViewById(e.g.god_name);
        this.egB = (TextView) getView().findViewById(e.g.god_describe);
        this.egy = (CommonUserLikeButton) getView().findViewById(e.g.god_like_btn);
        this.cMA = new c(tbPageContext, this.egy);
        this.egy.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(e.g.bottom_line);
        this.egz = (TextView) getView().findViewById(e.g.god_rank);
        this.egC = this.mPageContext.getResources().getDrawable(e.f.transparent_bg);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.home_thread_card_item_bg);
            al.h(this.egA, e.d.cp_cont_b);
            al.h(this.egB, e.d.cp_cont_d);
            al.j(this.mBottomLine, e.d.cp_bg_line_b);
            al.h(this.egz, e.d.cp_cont_d);
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
        if (fVar != null && fVar.apx != null && fVar.apx.getGodUserData() != null) {
            this.egE = fVar;
            this.egD = fVar.apx;
            ny(fVar.rank);
            this.eas.setData(fVar.apx);
            this.egA.setText(fVar.apx.getName_show());
            this.egB.setText(fVar.apx.getGodUserData().getIntro());
            this.cMA.a(fVar.apx);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void ny(int i) {
        String str;
        switch (i) {
            case 1:
                this.egz.setText("");
                al.i(this.egz, e.f.icon_grade_round_no1);
                return;
            case 2:
                this.egz.setText("");
                al.i(this.egz, e.f.icon_grade_round_no2);
                return;
            case 3:
                this.egz.setText("");
                al.i(this.egz, e.f.icon_grade_round_no3);
                return;
            default:
                this.egz.setBackgroundDrawable(this.egC);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.egz.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (anO() != null) {
            anO().a(view, this.egE);
        }
        if (view == getView() && this.egD != null && !StringUtils.isNull(this.egD.getName_show()) && !StringUtils.isNull(this.egD.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(this.egD.getUserId(), 0L), false, this.egD.isBigV())));
        }
    }
}
