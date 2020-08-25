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
    private c ajc;
    public ClickableHeaderImageView iAH;
    public CommonUserLikeButton iEA;
    private TextView iEB;
    private TextView iEC;
    private TextView iED;
    private Drawable iEE;
    private MetaData iEF;
    private i iEG;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.iAH = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.iAH.setGodIconMargin(R.dimen.ds4);
        this.iAH.setAfterClickListener(this);
        this.iEC = (TextView) getView().findViewById(R.id.god_name);
        this.iED = (TextView) getView().findViewById(R.id.god_describe);
        this.iEA = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.ajc = new c(tbPageContext, this.iEA);
        this.iEA.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
        this.iEB = (TextView) getView().findViewById(R.id.god_rank);
        this.iEE = this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg);
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setViewTextColor(this.iEC, R.color.cp_cont_b);
            ap.setViewTextColor(this.iED, R.color.cp_cont_d);
            ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.iEB, R.color.cp_cont_d);
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
        if (iVar != null && iVar.ecb != null && iVar.ecb.getGodUserData() != null) {
            this.iEG = iVar;
            this.iEF = iVar.ecb;
            zz(iVar.rank);
            this.iAH.setData(iVar.ecb);
            this.iEC.setText(iVar.ecb.getName_show());
            this.iED.setText(iVar.ecb.getGodUserData().getIntro());
            this.ajc.a(iVar.ecb);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void zz(int i) {
        String str;
        switch (i) {
            case 1:
                this.iEB.setText("");
                ap.setBackgroundResource(this.iEB, R.drawable.icon_grade_round_no1);
                return;
            case 2:
                this.iEB.setText("");
                ap.setBackgroundResource(this.iEB, R.drawable.icon_grade_round_no2);
                return;
            case 3:
                this.iEB.setText("");
                ap.setBackgroundResource(this.iEB, R.drawable.icon_grade_round_no3);
                return;
            default:
                this.iEB.setBackgroundDrawable(this.iEE);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.iEB.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cbz() != null) {
            cbz().a(view, this.iEG);
        }
        if (view == getView() && this.iEF != null && !StringUtils.isNull(this.iEF.getName_show()) && !StringUtils.isNull(this.iEF.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.iEF.getUserId(), 0L), false, this.iEF.isBigV())));
        }
    }
}
