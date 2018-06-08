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
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<f> {
    private c cxK;
    public ClickableHeaderImageView dFa;
    public CommonUserLikeButton dLo;
    private TextView dLp;
    private TextView dLq;
    private TextView dLr;
    private Drawable dLs;
    private MetaData dLt;
    private f dLu;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.dFa = (ClickableHeaderImageView) getView().findViewById(d.g.god_header_view);
        this.dFa.setGodIconMargin(d.e.ds4);
        this.dFa.setAfterClickListener(this);
        this.dLq = (TextView) getView().findViewById(d.g.god_name);
        this.dLr = (TextView) getView().findViewById(d.g.god_describe);
        this.dLo = (CommonUserLikeButton) getView().findViewById(d.g.god_like_btn);
        this.cxK = new c(tbPageContext, this.dLo);
        this.dLo.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(d.g.bottom_line);
        this.dLp = (TextView) getView().findViewById(d.g.god_rank);
        this.dLs = this.mPageContext.getResources().getDrawable(d.f.transparent_bg);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), d.f.home_thread_card_item_bg);
            al.h(this.dLq, d.C0141d.cp_cont_b);
            al.h(this.dLr, d.C0141d.cp_cont_d);
            al.j(this.mBottomLine, d.C0141d.cp_bg_line_b);
            al.h(this.dLp, d.C0141d.cp_cont_d);
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
        if (fVar != null && fVar.aik != null && fVar.aik.getGodUserData() != null) {
            this.dLu = fVar;
            this.dLt = fVar.aik;
            md(fVar.rank);
            this.dFa.setData(fVar.aik);
            this.dLq.setText(fVar.aik.getName_show());
            this.dLr.setText(fVar.aik.getGodUserData().getIntro());
            this.cxK.a(fVar.aik);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void md(int i) {
        String str;
        switch (i) {
            case 1:
                this.dLp.setText("");
                al.i(this.dLp, d.f.icon_grade_round_no1);
                return;
            case 2:
                this.dLp.setText("");
                al.i(this.dLp, d.f.icon_grade_round_no2);
                return;
            case 3:
                this.dLp.setText("");
                al.i(this.dLp, d.f.icon_grade_round_no3);
                return;
            default:
                this.dLp.setBackgroundDrawable(this.dLs);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.dLp.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aiI() != null) {
            aiI().a(view, this.dLu);
        }
        if (view == getView() && this.dLt != null && !StringUtils.isNull(this.dLt.getName_show()) && !StringUtils.isNull(this.dLt.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.dLt.getUserId(), 0L), false, this.dLt.isBigV())));
        }
    }
}
