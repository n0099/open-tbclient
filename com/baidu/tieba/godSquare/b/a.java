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
import com.baidu.tieba.card.data.h;
/* loaded from: classes23.dex */
public class a extends com.baidu.tieba.card.b<h> {
    private c ajZ;
    public ClickableHeaderImageView jqc;
    public CommonUserLikeButton jtS;
    private TextView jtT;
    private TextView jtU;
    private TextView jtV;
    private Drawable jtW;
    private MetaData jtX;
    private h jtY;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.jqc = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.jqc.setGodIconMargin(R.dimen.ds4);
        this.jqc.setAfterClickListener(this);
        this.jtU = (TextView) getView().findViewById(R.id.god_name);
        this.jtV = (TextView) getView().findViewById(R.id.god_describe);
        this.jtS = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.ajZ = new c(tbPageContext, this.jtS);
        this.jtS.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
        this.jtT = (TextView) getView().findViewById(R.id.god_rank);
        this.jtW = this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setViewTextColor(this.jtU, R.color.CAM_X0105);
            ap.setViewTextColor(this.jtV, R.color.CAM_X0109);
            ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0204);
            ap.setViewTextColor(this.jtT, R.color.CAM_X0109);
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
        if (hVar != null && hVar.eDc != null && hVar.eDc.getGodUserData() != null) {
            this.jtY = hVar;
            this.jtX = hVar.eDc;
            BH(hVar.rank);
            this.jqc.setData(hVar.eDc);
            this.jtU.setText(hVar.eDc.getName_show());
            this.jtV.setText(hVar.eDc.getGodUserData().getIntro());
            this.ajZ.a(hVar.eDc);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void BH(int i) {
        String str;
        switch (i) {
            case 1:
                this.jtT.setText("");
                ap.setBackgroundResource(this.jtT, R.drawable.icon_grade_round_no1);
                return;
            case 2:
                this.jtT.setText("");
                ap.setBackgroundResource(this.jtT, R.drawable.icon_grade_round_no2);
                return;
            case 3:
                this.jtT.setText("");
                ap.setBackgroundResource(this.jtT, R.drawable.icon_grade_round_no3);
                return;
            default:
                this.jtT.setBackgroundDrawable(this.jtW);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.jtT.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cnv() != null) {
            cnv().a(view, this.jtY);
        }
        if (view == getView() && this.jtX != null && !StringUtils.isNull(this.jtX.getName_show()) && !StringUtils.isNull(this.jtX.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.jtX.getUserId(), 0L), false, this.jtX.isBigV())));
        }
    }
}
