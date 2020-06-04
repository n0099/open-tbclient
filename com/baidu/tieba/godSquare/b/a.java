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
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.card.b<h> {
    private c agS;
    public ClickableHeaderImageView hSd;
    public CommonUserLikeButton hVW;
    private TextView hVX;
    private TextView hVY;
    private TextView hVZ;
    private Drawable hWa;
    private MetaData hWb;
    private h hWc;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.hSd = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.hSd.setGodIconMargin(R.dimen.ds4);
        this.hSd.setAfterClickListener(this);
        this.hVY = (TextView) getView().findViewById(R.id.god_name);
        this.hVZ = (TextView) getView().findViewById(R.id.god_describe);
        this.hVW = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.agS = new c(tbPageContext, this.hVW);
        this.hVW.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
        this.hVX = (TextView) getView().findViewById(R.id.god_rank);
        this.hWa = this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setViewTextColor(this.hVY, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hVZ, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            am.setViewTextColor(this.hVX, (int) R.color.cp_cont_d);
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
        if (hVar != null && hVar.dFJ != null && hVar.dFJ.getGodUserData() != null) {
            this.hWc = hVar;
            this.hWb = hVar.dFJ;
            wh(hVar.rank);
            this.hSd.setData(hVar.dFJ);
            this.hVY.setText(hVar.dFJ.getName_show());
            this.hVZ.setText(hVar.dFJ.getGodUserData().getIntro());
            this.agS.a(hVar.dFJ);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void wh(int i) {
        String str;
        switch (i) {
            case 1:
                this.hVX.setText("");
                am.setBackgroundResource(this.hVX, R.drawable.icon_grade_round_no1);
                return;
            case 2:
                this.hVX.setText("");
                am.setBackgroundResource(this.hVX, R.drawable.icon_grade_round_no2);
                return;
            case 3:
                this.hVX.setText("");
                am.setBackgroundResource(this.hVX, R.drawable.icon_grade_round_no3);
                return;
            default:
                this.hVX.setBackgroundDrawable(this.hWa);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.hVX.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bKU() != null) {
            bKU().a(view, this.hWc);
        }
        if (view == getView() && this.hWb != null && !StringUtils.isNull(this.hWb.getName_show()) && !StringUtils.isNull(this.hWb.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.hWb.getUserId(), 0L), false, this.hWb.isBigV())));
        }
    }
}
