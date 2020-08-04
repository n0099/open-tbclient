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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.h;
/* loaded from: classes18.dex */
public class a extends com.baidu.tieba.card.b<h> {
    private c ahO;
    public ClickableHeaderImageView imD;
    private Drawable iqA;
    private MetaData iqB;
    private h iqC;
    public CommonUserLikeButton iqw;
    private TextView iqx;
    private TextView iqy;
    private TextView iqz;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.imD = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.imD.setGodIconMargin(R.dimen.ds4);
        this.imD.setAfterClickListener(this);
        this.iqy = (TextView) getView().findViewById(R.id.god_name);
        this.iqz = (TextView) getView().findViewById(R.id.god_describe);
        this.iqw = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.ahO = new c(tbPageContext, this.iqw);
        this.iqw.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
        this.iqx = (TextView) getView().findViewById(R.id.god_rank);
        this.iqA = this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg);
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ao.setViewTextColor(this.iqy, R.color.cp_cont_b);
            ao.setViewTextColor(this.iqz, R.color.cp_cont_d);
            ao.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            ao.setViewTextColor(this.iqx, R.color.cp_cont_d);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_god_square_hot_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(h hVar) {
        if (hVar != null && hVar.dSF != null && hVar.dSF.getGodUserData() != null) {
            this.iqC = hVar;
            this.iqB = hVar.dSF;
            xf(hVar.rank);
            this.imD.setData(hVar.dSF);
            this.iqy.setText(hVar.dSF.getName_show());
            this.iqz.setText(hVar.dSF.getGodUserData().getIntro());
            this.ahO.a(hVar.dSF);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void xf(int i) {
        String str;
        switch (i) {
            case 1:
                this.iqx.setText("");
                ao.setBackgroundResource(this.iqx, R.drawable.icon_grade_round_no1);
                return;
            case 2:
                this.iqx.setText("");
                ao.setBackgroundResource(this.iqx, R.drawable.icon_grade_round_no2);
                return;
            case 3:
                this.iqx.setText("");
                ao.setBackgroundResource(this.iqx, R.drawable.icon_grade_round_no3);
                return;
            default:
                this.iqx.setBackgroundDrawable(this.iqA);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.iqx.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bRn() != null) {
            bRn().a(view, this.iqC);
        }
        if (view == getView() && this.iqB != null && !StringUtils.isNull(this.iqB.getName_show()) && !StringUtils.isNull(this.iqB.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.iqB.getUserId(), 0L), false, this.iqB.isBigV())));
        }
    }
}
