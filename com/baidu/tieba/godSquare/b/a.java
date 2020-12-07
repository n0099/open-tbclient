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
/* loaded from: classes24.dex */
public class a extends com.baidu.tieba.card.b<h> {
    private c akZ;
    public ClickableHeaderImageView jDC;
    public CommonUserLikeButton jHs;
    private TextView jHt;
    private TextView jHu;
    private TextView jHv;
    private Drawable jHw;
    private MetaData jHx;
    private h jHy;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.jDC = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.jDC.setGodIconMargin(R.dimen.ds4);
        this.jDC.setAfterClickListener(this);
        this.jHu = (TextView) getView().findViewById(R.id.god_name);
        this.jHv = (TextView) getView().findViewById(R.id.god_describe);
        this.jHs = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.akZ = new c(tbPageContext, this.jHs);
        this.jHs.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
        this.jHt = (TextView) getView().findViewById(R.id.god_rank);
        this.jHw = this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setViewTextColor(this.jHu, R.color.CAM_X0105);
            ap.setViewTextColor(this.jHv, R.color.CAM_X0109);
            ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0204);
            ap.setViewTextColor(this.jHt, R.color.CAM_X0109);
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
        if (hVar != null && hVar.eKe != null && hVar.eKe.getGodUserData() != null) {
            this.jHy = hVar;
            this.jHx = hVar.eKe;
            Cw(hVar.rank);
            this.jDC.setData(hVar.eKe);
            this.jHu.setText(hVar.eKe.getName_show());
            this.jHv.setText(hVar.eKe.getGodUserData().getIntro());
            this.akZ.a(hVar.eKe);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void Cw(int i) {
        String str;
        switch (i) {
            case 1:
                this.jHt.setText("");
                ap.setBackgroundResource(this.jHt, R.drawable.icon_grade_round_no1);
                return;
            case 2:
                this.jHt.setText("");
                ap.setBackgroundResource(this.jHt, R.drawable.icon_grade_round_no2);
                return;
            case 3:
                this.jHt.setText("");
                ap.setBackgroundResource(this.jHt, R.drawable.icon_grade_round_no3);
                return;
            default:
                this.jHt.setBackgroundDrawable(this.jHw);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.jHt.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (crI() != null) {
            crI().a(view, this.jHy);
        }
        if (view == getView() && this.jHx != null && !StringUtils.isNull(this.jHx.getName_show()) && !StringUtils.isNull(this.jHx.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.jHx.getUserId(), 0L), false, this.jHx.isBigV())));
        }
    }
}
