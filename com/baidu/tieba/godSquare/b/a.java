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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.i;
/* loaded from: classes18.dex */
public class a extends com.baidu.tieba.card.b<i> {
    private c aje;
    public ClickableHeaderImageView iAN;
    public CommonUserLikeButton iEG;
    private TextView iEH;
    private TextView iEI;
    private TextView iEJ;
    private Drawable iEK;
    private MetaData iEL;
    private i iEM;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.iAN = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.iAN.setGodIconMargin(R.dimen.ds4);
        this.iAN.setAfterClickListener(this);
        this.iEI = (TextView) getView().findViewById(R.id.god_name);
        this.iEJ = (TextView) getView().findViewById(R.id.god_describe);
        this.iEG = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.aje = new c(tbPageContext, this.iEG);
        this.iEG.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
        this.iEH = (TextView) getView().findViewById(R.id.god_rank);
        this.iEK = this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg);
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setViewTextColor(this.iEI, R.color.cp_cont_b);
            ap.setViewTextColor(this.iEJ, R.color.cp_cont_d);
            ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.iEH, R.color.cp_cont_d);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_god_square_hot_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(i iVar) {
        if (iVar != null && iVar.ecf != null && iVar.ecf.getGodUserData() != null) {
            this.iEM = iVar;
            this.iEL = iVar.ecf;
            zz(iVar.rank);
            this.iAN.setData(iVar.ecf);
            this.iEI.setText(iVar.ecf.getName_show());
            this.iEJ.setText(iVar.ecf.getGodUserData().getIntro());
            this.aje.a(iVar.ecf);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void zz(int i) {
        String str;
        switch (i) {
            case 1:
                this.iEH.setText("");
                ap.setBackgroundResource(this.iEH, R.drawable.icon_grade_round_no1);
                return;
            case 2:
                this.iEH.setText("");
                ap.setBackgroundResource(this.iEH, R.drawable.icon_grade_round_no2);
                return;
            case 3:
                this.iEH.setText("");
                ap.setBackgroundResource(this.iEH, R.drawable.icon_grade_round_no3);
                return;
            default:
                this.iEH.setBackgroundDrawable(this.iEK);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.iEH.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cbA() != null) {
            cbA().a(view, this.iEM);
        }
        if (view == getView() && this.iEL != null && !StringUtils.isNull(this.iEL.getName_show()) && !StringUtils.isNull(this.iEL.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.iEL.getUserId(), 0L), false, this.iEL.isBigV())));
        }
    }
}
