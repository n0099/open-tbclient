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
/* loaded from: classes24.dex */
public class a extends com.baidu.tieba.card.b<i> {
    private c ajV;
    public ClickableHeaderImageView iXa;
    public CommonUserLikeButton jaT;
    private TextView jaU;
    private TextView jaV;
    private TextView jaW;
    private Drawable jaX;
    private MetaData jaY;
    private i jaZ;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.iXa = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.iXa.setGodIconMargin(R.dimen.ds4);
        this.iXa.setAfterClickListener(this);
        this.jaV = (TextView) getView().findViewById(R.id.god_name);
        this.jaW = (TextView) getView().findViewById(R.id.god_describe);
        this.jaT = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.ajV = new c(tbPageContext, this.jaT);
        this.jaT.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
        this.jaU = (TextView) getView().findViewById(R.id.god_rank);
        this.jaX = this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setViewTextColor(this.jaV, R.color.cp_cont_b);
            ap.setViewTextColor(this.jaW, R.color.cp_cont_d);
            ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.jaU, R.color.cp_cont_d);
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
        if (iVar != null && iVar.equ != null && iVar.equ.getGodUserData() != null) {
            this.jaZ = iVar;
            this.jaY = iVar.equ;
            AD(iVar.rank);
            this.iXa.setData(iVar.equ);
            this.jaV.setText(iVar.equ.getName_show());
            this.jaW.setText(iVar.equ.getGodUserData().getIntro());
            this.ajV.a(iVar.equ);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void AD(int i) {
        String str;
        switch (i) {
            case 1:
                this.jaU.setText("");
                ap.setBackgroundResource(this.jaU, R.drawable.icon_grade_round_no1);
                return;
            case 2:
                this.jaU.setText("");
                ap.setBackgroundResource(this.jaU, R.drawable.icon_grade_round_no2);
                return;
            case 3:
                this.jaU.setText("");
                ap.setBackgroundResource(this.jaU, R.drawable.icon_grade_round_no3);
                return;
            default:
                this.jaU.setBackgroundDrawable(this.jaX);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.jaU.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cil() != null) {
            cil().a(view, this.jaZ);
        }
        if (view == getView() && this.jaY != null && !StringUtils.isNull(this.jaY.getName_show()) && !StringUtils.isNull(this.jaY.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.jaY.getUserId(), 0L), false, this.jaY.isBigV())));
        }
    }
}
