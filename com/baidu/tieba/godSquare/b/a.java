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
    private c coa;
    public ClickableHeaderImageView duI;
    public CommonUserLikeButton dza;
    private TextView dzb;
    private TextView dzc;
    private TextView dzd;
    private Drawable dze;
    private MetaData dzf;
    private f dzg;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.duI = (ClickableHeaderImageView) getView().findViewById(d.g.god_header_view);
        this.duI.setGodIconMargin(d.e.ds4);
        this.duI.setAfterClickListener(this);
        this.dzc = (TextView) getView().findViewById(d.g.god_name);
        this.dzd = (TextView) getView().findViewById(d.g.god_describe);
        this.dza = (CommonUserLikeButton) getView().findViewById(d.g.god_like_btn);
        this.coa = new c(tbPageContext, this.dza);
        this.dza.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(d.g.bottom_line);
        this.dzb = (TextView) getView().findViewById(d.g.god_rank);
        this.dze = this.mPageContext.getResources().getDrawable(d.f.transparent_bg);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.f.home_thread_card_item_bg);
            ak.h(this.dzc, d.C0126d.cp_cont_b);
            ak.h(this.dzd, d.C0126d.cp_cont_d);
            ak.j(this.mBottomLine, d.C0126d.cp_bg_line_b);
            ak.h(this.dzb, d.C0126d.cp_cont_d);
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
            this.dzg = fVar;
            this.dzf = fVar.aae;
            lS(fVar.rank);
            this.duI.setData(fVar.aae);
            this.dzc.setText(fVar.aae.getName_show());
            this.dzd.setText(fVar.aae.getGodUserData().getIntro());
            this.coa.a(fVar.aae);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void lS(int i) {
        String str;
        switch (i) {
            case 1:
                this.dzb.setText("");
                ak.i(this.dzb, d.f.icon_grade_round_no1);
                return;
            case 2:
                this.dzb.setText("");
                ak.i(this.dzb, d.f.icon_grade_round_no2);
                return;
            case 3:
                this.dzb.setText("");
                ak.i(this.dzb, d.f.icon_grade_round_no3);
                return;
            default:
                this.dzb.setBackgroundDrawable(this.dze);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.dzb.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (aeZ() != null) {
            aeZ().a(view2, this.dzg);
        }
        if (view2 == getView() && this.dzf != null && !StringUtils.isNull(this.dzf.getName_show()) && !StringUtils.isNull(this.dzf.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.dzf.getUserId(), 0L), false, this.dzf.isBigV())));
        }
    }
}
