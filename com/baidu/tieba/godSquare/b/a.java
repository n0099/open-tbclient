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
    private c cXO;
    public ClickableHeaderImageView elM;
    public CommonUserLikeButton esk;
    private TextView esl;
    private TextView esm;
    private TextView esn;
    private Drawable eso;
    private MetaData esp;
    private f esq;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.elM = (ClickableHeaderImageView) getView().findViewById(e.g.god_header_view);
        this.elM.setGodIconMargin(e.C0210e.ds4);
        this.elM.setAfterClickListener(this);
        this.esm = (TextView) getView().findViewById(e.g.god_name);
        this.esn = (TextView) getView().findViewById(e.g.god_describe);
        this.esk = (CommonUserLikeButton) getView().findViewById(e.g.god_like_btn);
        this.cXO = new c(tbPageContext, this.esk);
        this.esk.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(e.g.bottom_line);
        this.esl = (TextView) getView().findViewById(e.g.god_rank);
        this.eso = this.mPageContext.getResources().getDrawable(e.f.transparent_bg);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.home_thread_card_item_bg);
            al.h(this.esm, e.d.cp_cont_b);
            al.h(this.esn, e.d.cp_cont_d);
            al.j(this.mBottomLine, e.d.cp_bg_line_b);
            al.h(this.esl, e.d.cp_cont_d);
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
        if (fVar != null && fVar.aum != null && fVar.aum.getGodUserData() != null) {
            this.esq = fVar;
            this.esp = fVar.aum;
            oy(fVar.rank);
            this.elM.setData(fVar.aum);
            this.esm.setText(fVar.aum.getName_show());
            this.esn.setText(fVar.aum.getGodUserData().getIntro());
            this.cXO.a(fVar.aum);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void oy(int i) {
        String str;
        switch (i) {
            case 1:
                this.esl.setText("");
                al.i(this.esl, e.f.icon_grade_round_no1);
                return;
            case 2:
                this.esl.setText("");
                al.i(this.esl, e.f.icon_grade_round_no2);
                return;
            case 3:
                this.esl.setText("");
                al.i(this.esl, e.f.icon_grade_round_no3);
                return;
            default:
                this.esl.setBackgroundDrawable(this.eso);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.esl.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aqp() != null) {
            aqp().a(view, this.esq);
        }
        if (view == getView() && this.esp != null && !StringUtils.isNull(this.esp.getName_show()) && !StringUtils.isNull(this.esp.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(this.esp.getUserId(), 0L), false, this.esp.isBigV())));
        }
    }
}
