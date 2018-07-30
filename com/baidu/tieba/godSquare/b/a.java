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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<f> {
    private c cyt;
    public ClickableHeaderImageView dLk;
    public CommonUserLikeButton dRs;
    private TextView dRt;
    private TextView dRu;
    private TextView dRv;
    private Drawable dRw;
    private MetaData dRx;
    private f dRy;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.dLk = (ClickableHeaderImageView) getView().findViewById(d.g.god_header_view);
        this.dLk.setGodIconMargin(d.e.ds4);
        this.dLk.setAfterClickListener(this);
        this.dRu = (TextView) getView().findViewById(d.g.god_name);
        this.dRv = (TextView) getView().findViewById(d.g.god_describe);
        this.dRs = (CommonUserLikeButton) getView().findViewById(d.g.god_like_btn);
        this.cyt = new c(tbPageContext, this.dRs);
        this.dRs.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(d.g.bottom_line);
        this.dRt = (TextView) getView().findViewById(d.g.god_rank);
        this.dRw = this.mPageContext.getResources().getDrawable(d.f.transparent_bg);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), d.f.home_thread_card_item_bg);
            am.h(this.dRu, d.C0140d.cp_cont_b);
            am.h(this.dRv, d.C0140d.cp_cont_d);
            am.j(this.mBottomLine, d.C0140d.cp_bg_line_b);
            am.h(this.dRt, d.C0140d.cp_cont_d);
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
        if (fVar != null && fVar.aib != null && fVar.aib.getGodUserData() != null) {
            this.dRy = fVar;
            this.dRx = fVar.aib;
            mw(fVar.rank);
            this.dLk.setData(fVar.aib);
            this.dRu.setText(fVar.aib.getName_show());
            this.dRv.setText(fVar.aib.getGodUserData().getIntro());
            this.cyt.a(fVar.aib);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void mw(int i) {
        String str;
        switch (i) {
            case 1:
                this.dRt.setText("");
                am.i(this.dRt, d.f.icon_grade_round_no1);
                return;
            case 2:
                this.dRt.setText("");
                am.i(this.dRt, d.f.icon_grade_round_no2);
                return;
            case 3:
                this.dRt.setText("");
                am.i(this.dRt, d.f.icon_grade_round_no3);
                return;
            default:
                this.dRt.setBackgroundDrawable(this.dRw);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.dRt.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aiz() != null) {
            aiz().a(view, this.dRy);
        }
        if (view == getView() && this.dRx != null && !StringUtils.isNull(this.dRx.getName_show()) && !StringUtils.isNull(this.dRx.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.dRx.getUserId(), 0L), false, this.dRx.isBigV())));
        }
    }
}
