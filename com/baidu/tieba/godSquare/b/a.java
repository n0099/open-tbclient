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
    public ClickableHeaderImageView jDE;
    private h jHA;
    public CommonUserLikeButton jHu;
    private TextView jHv;
    private TextView jHw;
    private TextView jHx;
    private Drawable jHy;
    private MetaData jHz;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.jDE = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.jDE.setGodIconMargin(R.dimen.ds4);
        this.jDE.setAfterClickListener(this);
        this.jHw = (TextView) getView().findViewById(R.id.god_name);
        this.jHx = (TextView) getView().findViewById(R.id.god_describe);
        this.jHu = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.akZ = new c(tbPageContext, this.jHu);
        this.jHu.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
        this.jHv = (TextView) getView().findViewById(R.id.god_rank);
        this.jHy = this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setViewTextColor(this.jHw, R.color.CAM_X0105);
            ap.setViewTextColor(this.jHx, R.color.CAM_X0109);
            ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0204);
            ap.setViewTextColor(this.jHv, R.color.CAM_X0109);
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
            this.jHA = hVar;
            this.jHz = hVar.eKe;
            Cw(hVar.rank);
            this.jDE.setData(hVar.eKe);
            this.jHw.setText(hVar.eKe.getName_show());
            this.jHx.setText(hVar.eKe.getGodUserData().getIntro());
            this.akZ.a(hVar.eKe);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void Cw(int i) {
        String str;
        switch (i) {
            case 1:
                this.jHv.setText("");
                ap.setBackgroundResource(this.jHv, R.drawable.icon_grade_round_no1);
                return;
            case 2:
                this.jHv.setText("");
                ap.setBackgroundResource(this.jHv, R.drawable.icon_grade_round_no2);
                return;
            case 3:
                this.jHv.setText("");
                ap.setBackgroundResource(this.jHv, R.drawable.icon_grade_round_no3);
                return;
            default:
                this.jHv.setBackgroundDrawable(this.jHy);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.jHv.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (crJ() != null) {
            crJ().a(view, this.jHA);
        }
        if (view == getView() && this.jHz != null && !StringUtils.isNull(this.jHz.getName_show()) && !StringUtils.isNull(this.jHz.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.jHz.getUserId(), 0L), false, this.jHz.isBigV())));
        }
    }
}
