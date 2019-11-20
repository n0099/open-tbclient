package com.baidu.tieba.godSquare.b;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.f;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.a<f> {
    private c eLD;
    public ClickableHeaderImageView fXu;
    public CommonUserLikeButton gbH;
    private TextView gbI;
    private TextView gbJ;
    private TextView gbK;
    private Drawable gbL;
    private MetaData gbM;
    private f gbN;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.fXu = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.fXu.setGodIconMargin(R.dimen.ds4);
        this.fXu.setAfterClickListener(this);
        this.gbJ = (TextView) getView().findViewById(R.id.god_name);
        this.gbK = (TextView) getView().findViewById(R.id.god_describe);
        this.gbH = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.eLD = new c(tbPageContext, this.gbH);
        this.gbH.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
        this.gbI = (TextView) getView().findViewById(R.id.god_rank);
        this.gbL = this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setViewTextColor(this.gbJ, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.gbK, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            am.setViewTextColor(this.gbI, (int) R.color.cp_cont_d);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_god_square_hot_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(f fVar) {
        if (fVar != null && fVar.cbv != null && fVar.cbv.getGodUserData() != null) {
            this.gbN = fVar;
            this.gbM = fVar.cbv;
            sD(fVar.rank);
            this.fXu.setData(fVar.cbv);
            this.gbJ.setText(fVar.cbv.getName_show());
            this.gbK.setText(fVar.cbv.getGodUserData().getIntro());
            this.eLD.a(fVar.cbv);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void sD(int i) {
        String str;
        switch (i) {
            case 1:
                this.gbI.setText("");
                am.setBackgroundResource(this.gbI, R.drawable.icon_grade_round_no1);
                return;
            case 2:
                this.gbI.setText("");
                am.setBackgroundResource(this.gbI, R.drawable.icon_grade_round_no2);
                return;
            case 3:
                this.gbI.setText("");
                am.setBackgroundResource(this.gbI, R.drawable.icon_grade_round_no3);
                return;
            default:
                this.gbI.setBackgroundDrawable(this.gbL);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.gbI.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZV() != null) {
            aZV().a(view, this.gbN);
        }
        if (view == getView() && this.gbM != null && !StringUtils.isNull(this.gbM.getName_show()) && !StringUtils.isNull(this.gbM.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.toLong(this.gbM.getUserId(), 0L), false, this.gbM.isBigV())));
        }
    }
}
