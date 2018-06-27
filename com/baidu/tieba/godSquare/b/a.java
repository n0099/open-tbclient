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
    private c cvR;
    public ClickableHeaderImageView dIv;
    public CommonUserLikeButton dOF;
    private TextView dOG;
    private TextView dOH;
    private TextView dOI;
    private Drawable dOJ;
    private MetaData dOK;
    private f dOL;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.dIv = (ClickableHeaderImageView) getView().findViewById(d.g.god_header_view);
        this.dIv.setGodIconMargin(d.e.ds4);
        this.dIv.setAfterClickListener(this);
        this.dOH = (TextView) getView().findViewById(d.g.god_name);
        this.dOI = (TextView) getView().findViewById(d.g.god_describe);
        this.dOF = (CommonUserLikeButton) getView().findViewById(d.g.god_like_btn);
        this.cvR = new c(tbPageContext, this.dOF);
        this.dOF.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(d.g.bottom_line);
        this.dOG = (TextView) getView().findViewById(d.g.god_rank);
        this.dOJ = this.mPageContext.getResources().getDrawable(d.f.transparent_bg);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), d.f.home_thread_card_item_bg);
            am.h(this.dOH, d.C0142d.cp_cont_b);
            am.h(this.dOI, d.C0142d.cp_cont_d);
            am.j(this.mBottomLine, d.C0142d.cp_bg_line_b);
            am.h(this.dOG, d.C0142d.cp_cont_d);
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
        if (fVar != null && fVar.aiE != null && fVar.aiE.getGodUserData() != null) {
            this.dOL = fVar;
            this.dOK = fVar.aiE;
            mk(fVar.rank);
            this.dIv.setData(fVar.aiE);
            this.dOH.setText(fVar.aiE.getName_show());
            this.dOI.setText(fVar.aiE.getGodUserData().getIntro());
            this.cvR.a(fVar.aiE);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void mk(int i) {
        String str;
        switch (i) {
            case 1:
                this.dOG.setText("");
                am.i(this.dOG, d.f.icon_grade_round_no1);
                return;
            case 2:
                this.dOG.setText("");
                am.i(this.dOG, d.f.icon_grade_round_no2);
                return;
            case 3:
                this.dOG.setText("");
                am.i(this.dOG, d.f.icon_grade_round_no3);
                return;
            default:
                this.dOG.setBackgroundDrawable(this.dOJ);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.dOG.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aia() != null) {
            aia().a(view, this.dOL);
        }
        if (view == getView() && this.dOK != null && !StringUtils.isNull(this.dOK.getName_show()) && !StringUtils.isNull(this.dOK.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.dOK.getUserId(), 0L), false, this.dOK.isBigV())));
        }
    }
}
