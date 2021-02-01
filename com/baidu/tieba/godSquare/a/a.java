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
    public ClickableHeaderImageView jSx;
    public CommonUserLikeButton jXJ;
    private TextView jXK;
    private TextView jXL;
    private TextView jXM;
    private Drawable jXN;
    private MetaData jXO;
    private h jXP;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.jSx = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.jSx.setGodIconMargin(R.dimen.ds4);
        this.jSx.setAfterClickListener(this);
        this.jXL = (TextView) getView().findViewById(R.id.god_name);
        this.jXM = (TextView) getView().findViewById(R.id.god_describe);
        this.jXJ = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.akz = new c(tbPageContext, this.jXJ);
        this.jXJ.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
        this.jXK = (TextView) getView().findViewById(R.id.god_rank);
        this.jXN = this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setViewTextColor(this.jXL, R.color.CAM_X0105);
            ap.setViewTextColor(this.jXM, R.color.CAM_X0109);
            ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0204);
            ap.setViewTextColor(this.jXK, R.color.CAM_X0109);
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
            this.jXP = hVar;
            this.jXO = hVar.eRz;
            Bs(hVar.rank);
            this.jSx.setData(hVar.eRz);
            this.jXL.setText(hVar.eRz.getName_show());
            this.jXM.setText(hVar.eRz.getGodUserData().getIntro());
            this.akz.a(hVar.eRz);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void Bs(int i) {
        String str;
        switch (i) {
            case 1:
                this.jXK.setText("");
                ap.setBackgroundResource(this.jXK, R.drawable.icon_grade_round_no1);
                return;
            case 2:
                this.jXK.setText("");
                ap.setBackgroundResource(this.jXK, R.drawable.icon_grade_round_no2);
                return;
            case 3:
                this.jXK.setText("");
                ap.setBackgroundResource(this.jXK, R.drawable.icon_grade_round_no3);
                return;
            default:
                this.jXK.setBackgroundDrawable(this.jXN);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.jXK.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (crV() != null) {
            crV().a(view, this.jXP);
        }
        if (view == getView() && this.jXO != null && !StringUtils.isNull(this.jXO.getName_show()) && !StringUtils.isNull(this.jXO.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.jXO.getUserId(), 0L), false, this.jXO.isBigV())));
        }
    }
}
