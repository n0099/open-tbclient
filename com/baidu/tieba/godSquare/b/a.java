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
    private c cpg;
    public CommonUserLikeButton dAe;
    private TextView dAf;
    private TextView dAg;
    private TextView dAh;
    private Drawable dAi;
    private MetaData dAj;
    private f dAk;
    public ClickableHeaderImageView dvN;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.dvN = (ClickableHeaderImageView) getView().findViewById(d.g.god_header_view);
        this.dvN.setGodIconMargin(d.e.ds4);
        this.dvN.setAfterClickListener(this);
        this.dAg = (TextView) getView().findViewById(d.g.god_name);
        this.dAh = (TextView) getView().findViewById(d.g.god_describe);
        this.dAe = (CommonUserLikeButton) getView().findViewById(d.g.god_like_btn);
        this.cpg = new c(tbPageContext, this.dAe);
        this.dAe.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(d.g.bottom_line);
        this.dAf = (TextView) getView().findViewById(d.g.god_rank);
        this.dAi = this.mPageContext.getResources().getDrawable(d.f.transparent_bg);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.f.home_thread_card_item_bg);
            ak.h(this.dAg, d.C0126d.cp_cont_b);
            ak.h(this.dAh, d.C0126d.cp_cont_d);
            ak.j(this.mBottomLine, d.C0126d.cp_bg_line_b);
            ak.h(this.dAf, d.C0126d.cp_cont_d);
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
        if (fVar != null && fVar.aaf != null && fVar.aaf.getGodUserData() != null) {
            this.dAk = fVar;
            this.dAj = fVar.aaf;
            lR(fVar.rank);
            this.dvN.setData(fVar.aaf);
            this.dAg.setText(fVar.aaf.getName_show());
            this.dAh.setText(fVar.aaf.getGodUserData().getIntro());
            this.cpg.a(fVar.aaf);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void lR(int i) {
        String str;
        switch (i) {
            case 1:
                this.dAf.setText("");
                ak.i(this.dAf, d.f.icon_grade_round_no1);
                return;
            case 2:
                this.dAf.setText("");
                ak.i(this.dAf, d.f.icon_grade_round_no2);
                return;
            case 3:
                this.dAf.setText("");
                ak.i(this.dAf, d.f.icon_grade_round_no3);
                return;
            default:
                this.dAf.setBackgroundDrawable(this.dAi);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.dAf.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (aeZ() != null) {
            aeZ().a(view2, this.dAk);
        }
        if (view2 == getView() && this.dAj != null && !StringUtils.isNull(this.dAj.getName_show()) && !StringUtils.isNull(this.dAj.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.dAj.getUserId(), 0L), false, this.dAj.isBigV())));
        }
    }
}
