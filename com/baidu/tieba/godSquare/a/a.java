package com.baidu.tieba.godSquare.a;

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
/* loaded from: classes8.dex */
public class a extends com.baidu.tieba.card.b<h> {
    private c akz;
    public ClickableHeaderImageView jSL;
    public CommonUserLikeButton jXX;
    private TextView jXY;
    private TextView jXZ;
    private TextView jYa;
    private Drawable jYb;
    private MetaData jYc;
    private h jYd;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.jSL = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.jSL.setGodIconMargin(R.dimen.ds4);
        this.jSL.setAfterClickListener(this);
        this.jXZ = (TextView) getView().findViewById(R.id.god_name);
        this.jYa = (TextView) getView().findViewById(R.id.god_describe);
        this.jXX = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.akz = new c(tbPageContext, this.jXX);
        this.jXX.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
        this.jXY = (TextView) getView().findViewById(R.id.god_rank);
        this.jYb = this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setViewTextColor(this.jXZ, R.color.CAM_X0105);
            ap.setViewTextColor(this.jYa, R.color.CAM_X0109);
            ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0204);
            ap.setViewTextColor(this.jXY, R.color.CAM_X0109);
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
        if (hVar != null && hVar.eRz != null && hVar.eRz.getGodUserData() != null) {
            this.jYd = hVar;
            this.jYc = hVar.eRz;
            Bs(hVar.rank);
            this.jSL.setData(hVar.eRz);
            this.jXZ.setText(hVar.eRz.getName_show());
            this.jYa.setText(hVar.eRz.getGodUserData().getIntro());
            this.akz.a(hVar.eRz);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void Bs(int i) {
        String str;
        switch (i) {
            case 1:
                this.jXY.setText("");
                ap.setBackgroundResource(this.jXY, R.drawable.icon_grade_round_no1);
                return;
            case 2:
                this.jXY.setText("");
                ap.setBackgroundResource(this.jXY, R.drawable.icon_grade_round_no2);
                return;
            case 3:
                this.jXY.setText("");
                ap.setBackgroundResource(this.jXY, R.drawable.icon_grade_round_no3);
                return;
            default:
                this.jXY.setBackgroundDrawable(this.jYb);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.jXY.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (csc() != null) {
            csc().a(view, this.jYd);
        }
        if (view == getView() && this.jYc != null && !StringUtils.isNull(this.jYc.getName_show()) && !StringUtils.isNull(this.jYc.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.jYc.getUserId(), 0L), false, this.jYc.isBigV())));
        }
    }
}
