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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.card.data.f;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<f> {
    private c cyq;
    public ClickableHeaderImageView dLg;
    public CommonUserLikeButton dRn;
    private TextView dRo;
    private TextView dRp;
    private TextView dRq;
    private Drawable dRr;
    private MetaData dRs;
    private f dRt;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.dLg = (ClickableHeaderImageView) getView().findViewById(f.g.god_header_view);
        this.dLg.setGodIconMargin(f.e.ds4);
        this.dLg.setAfterClickListener(this);
        this.dRp = (TextView) getView().findViewById(f.g.god_name);
        this.dRq = (TextView) getView().findViewById(f.g.god_describe);
        this.dRn = (CommonUserLikeButton) getView().findViewById(f.g.god_like_btn);
        this.cyq = new c(tbPageContext, this.dRn);
        this.dRn.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(f.g.bottom_line);
        this.dRo = (TextView) getView().findViewById(f.g.god_rank);
        this.dRr = this.mPageContext.getResources().getDrawable(f.C0146f.transparent_bg);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), f.C0146f.home_thread_card_item_bg);
            am.h(this.dRp, f.d.cp_cont_b);
            am.h(this.dRq, f.d.cp_cont_d);
            am.j(this.mBottomLine, f.d.cp_bg_line_b);
            am.h(this.dRo, f.d.cp_cont_d);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_god_square_hot_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.f fVar) {
        if (fVar != null && fVar.aib != null && fVar.aib.getGodUserData() != null) {
            this.dRt = fVar;
            this.dRs = fVar.aib;
            mw(fVar.rank);
            this.dLg.setData(fVar.aib);
            this.dRp.setText(fVar.aib.getName_show());
            this.dRq.setText(fVar.aib.getGodUserData().getIntro());
            this.cyq.a(fVar.aib);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void mw(int i) {
        String str;
        switch (i) {
            case 1:
                this.dRo.setText("");
                am.i(this.dRo, f.C0146f.icon_grade_round_no1);
                return;
            case 2:
                this.dRo.setText("");
                am.i(this.dRo, f.C0146f.icon_grade_round_no2);
                return;
            case 3:
                this.dRo.setText("");
                am.i(this.dRo, f.C0146f.icon_grade_round_no3);
                return;
            default:
                this.dRo.setBackgroundDrawable(this.dRr);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.dRo.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aiC() != null) {
            aiC().a(view, this.dRt);
        }
        if (view == getView() && this.dRs != null && !StringUtils.isNull(this.dRs.getName_show()) && !StringUtils.isNull(this.dRs.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.dRs.getUserId(), 0L), false, this.dRs.isBigV())));
        }
    }
}
