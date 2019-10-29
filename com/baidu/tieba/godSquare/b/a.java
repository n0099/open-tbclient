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
    private c eMu;
    public ClickableHeaderImageView fYl;
    private TextView gcA;
    private TextView gcB;
    private Drawable gcC;
    private MetaData gcD;
    private f gcE;
    public CommonUserLikeButton gcy;
    private TextView gcz;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.fYl = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.fYl.setGodIconMargin(R.dimen.ds4);
        this.fYl.setAfterClickListener(this);
        this.gcA = (TextView) getView().findViewById(R.id.god_name);
        this.gcB = (TextView) getView().findViewById(R.id.god_describe);
        this.gcy = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.eMu = new c(tbPageContext, this.gcy);
        this.gcy.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
        this.gcz = (TextView) getView().findViewById(R.id.god_rank);
        this.gcC = this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setViewTextColor(this.gcA, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.gcB, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            am.setViewTextColor(this.gcz, (int) R.color.cp_cont_d);
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
        if (fVar != null && fVar.ccm != null && fVar.ccm.getGodUserData() != null) {
            this.gcE = fVar;
            this.gcD = fVar.ccm;
            sE(fVar.rank);
            this.fYl.setData(fVar.ccm);
            this.gcA.setText(fVar.ccm.getName_show());
            this.gcB.setText(fVar.ccm.getGodUserData().getIntro());
            this.eMu.a(fVar.ccm);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void sE(int i) {
        String str;
        switch (i) {
            case 1:
                this.gcz.setText("");
                am.setBackgroundResource(this.gcz, R.drawable.icon_grade_round_no1);
                return;
            case 2:
                this.gcz.setText("");
                am.setBackgroundResource(this.gcz, R.drawable.icon_grade_round_no2);
                return;
            case 3:
                this.gcz.setText("");
                am.setBackgroundResource(this.gcz, R.drawable.icon_grade_round_no3);
                return;
            default:
                this.gcz.setBackgroundDrawable(this.gcC);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.gcz.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZX() != null) {
            aZX().a(view, this.gcE);
        }
        if (view == getView() && this.gcD != null && !StringUtils.isNull(this.gcD.getName_show()) && !StringUtils.isNull(this.gcD.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.toLong(this.gcD.getUserId(), 0L), false, this.gcD.isBigV())));
        }
    }
}
