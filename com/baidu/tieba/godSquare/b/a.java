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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.card.data.f;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<f> {
    private c cnX;
    public ClickableHeaderImageView duF;
    public CommonUserLikeButton dyX;
    private TextView dyY;
    private TextView dyZ;
    private TextView dza;
    private Drawable dzb;
    private MetaData dzc;
    private f dzd;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.duF = (ClickableHeaderImageView) getView().findViewById(d.g.god_header_view);
        this.duF.setGodIconMargin(d.e.ds4);
        this.duF.setAfterClickListener(this);
        this.dyZ = (TextView) getView().findViewById(d.g.god_name);
        this.dza = (TextView) getView().findViewById(d.g.god_describe);
        this.dyX = (CommonUserLikeButton) getView().findViewById(d.g.god_like_btn);
        this.cnX = new c(tbPageContext, this.dyX);
        this.dyX.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(d.g.bottom_line);
        this.dyY = (TextView) getView().findViewById(d.g.god_rank);
        this.dzb = this.mPageContext.getResources().getDrawable(d.f.transparent_bg);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.f.home_thread_card_item_bg);
            ak.h(this.dyZ, d.C0126d.cp_cont_b);
            ak.h(this.dza, d.C0126d.cp_cont_d);
            ak.j(this.mBottomLine, d.C0126d.cp_bg_line_b);
            ak.h(this.dyY, d.C0126d.cp_cont_d);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_god_square_hot_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(f fVar) {
        if (fVar != null && fVar.aae != null && fVar.aae.getGodUserData() != null) {
            this.dzd = fVar;
            this.dzc = fVar.aae;
            lS(fVar.rank);
            this.duF.setData(fVar.aae);
            this.dyZ.setText(fVar.aae.getName_show());
            this.dza.setText(fVar.aae.getGodUserData().getIntro());
            this.cnX.a(fVar.aae);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void lS(int i) {
        String str;
        switch (i) {
            case 1:
                this.dyY.setText("");
                ak.i(this.dyY, d.f.icon_grade_round_no1);
                return;
            case 2:
                this.dyY.setText("");
                ak.i(this.dyY, d.f.icon_grade_round_no2);
                return;
            case 3:
                this.dyY.setText("");
                ak.i(this.dyY, d.f.icon_grade_round_no3);
                return;
            default:
                this.dyY.setBackgroundDrawable(this.dzb);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.dyY.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (aeZ() != null) {
            aeZ().a(view2, this.dzd);
        }
        if (view2 == getView() && this.dzc != null && !StringUtils.isNull(this.dzc.getName_show()) && !StringUtils.isNull(this.dzc.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.dzc.getUserId(), 0L), false, this.dzc.isBigV())));
        }
    }
}
