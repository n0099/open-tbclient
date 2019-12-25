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
import com.baidu.tieba.card.data.h;
/* loaded from: classes8.dex */
public class a extends com.baidu.tieba.card.a<h> {
    private c MX;
    public ClickableHeaderImageView gLS;
    public CommonUserLikeButton gPL;
    private TextView gPM;
    private TextView gPN;
    private TextView gPO;
    private Drawable gPP;
    private MetaData gPQ;
    private h gPR;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.gLS = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.gLS.setGodIconMargin(R.dimen.ds4);
        this.gLS.setAfterClickListener(this);
        this.gPN = (TextView) getView().findViewById(R.id.god_name);
        this.gPO = (TextView) getView().findViewById(R.id.god_describe);
        this.gPL = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.MX = new c(tbPageContext, this.gPL);
        this.gPL.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
        this.gPM = (TextView) getView().findViewById(R.id.god_rank);
        this.gPP = this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setViewTextColor(this.gPN, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.gPO, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            am.setViewTextColor(this.gPM, (int) R.color.cp_cont_d);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_god_square_hot_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(h hVar) {
        if (hVar != null && hVar.cNZ != null && hVar.cNZ.getGodUserData() != null) {
            this.gPR = hVar;
            this.gPQ = hVar.cNZ;
            uJ(hVar.rank);
            this.gLS.setData(hVar.cNZ);
            this.gPN.setText(hVar.cNZ.getName_show());
            this.gPO.setText(hVar.cNZ.getGodUserData().getIntro());
            this.MX.a(hVar.cNZ);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void uJ(int i) {
        String str;
        switch (i) {
            case 1:
                this.gPM.setText("");
                am.setBackgroundResource(this.gPM, R.drawable.icon_grade_round_no1);
                return;
            case 2:
                this.gPM.setText("");
                am.setBackgroundResource(this.gPM, R.drawable.icon_grade_round_no2);
                return;
            case 3:
                this.gPM.setText("");
                am.setBackgroundResource(this.gPM, R.drawable.icon_grade_round_no3);
                return;
            default:
                this.gPM.setBackgroundDrawable(this.gPP);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.gPM.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (brY() != null) {
            brY().a(view, this.gPR);
        }
        if (view == getView() && this.gPQ != null && !StringUtils.isNull(this.gPQ.getName_show()) && !StringUtils.isNull(this.gPQ.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.gPQ.getUserId(), 0L), false, this.gPQ.isBigV())));
        }
    }
}
