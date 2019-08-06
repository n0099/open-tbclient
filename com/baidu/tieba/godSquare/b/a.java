package com.baidu.tieba.godSquare.b;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.f;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.a<f> {
    private c eCe;
    public ClickableHeaderImageView fWZ;
    public CommonUserLikeButton gbj;
    private TextView gbk;
    private TextView gbl;
    private TextView gbm;
    private Drawable gbn;
    private MetaData gbo;
    private f gbp;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.fWZ = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.fWZ.setGodIconMargin(R.dimen.ds4);
        this.fWZ.setAfterClickListener(this);
        this.gbl = (TextView) getView().findViewById(R.id.god_name);
        this.gbm = (TextView) getView().findViewById(R.id.god_describe);
        this.gbj = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.eCe = new c(tbPageContext, this.gbj);
        this.gbj.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
        this.gbk = (TextView) getView().findViewById(R.id.god_rank);
        this.gbn = this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(getView(), R.drawable.home_thread_card_item_bg);
            am.j(this.gbl, R.color.cp_cont_b);
            am.j(this.gbm, R.color.cp_cont_d);
            am.l(this.mBottomLine, R.color.cp_bg_line_b);
            am.j(this.gbk, R.color.cp_cont_d);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_god_square_hot_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(f fVar) {
        if (fVar != null && fVar.bKg != null && fVar.bKg.getGodUserData() != null) {
            this.gbp = fVar;
            this.gbo = fVar.bKg;
            tF(fVar.rank);
            this.fWZ.setData(fVar.bKg);
            this.gbl.setText(fVar.bKg.getName_show());
            this.gbm.setText(fVar.bKg.getGodUserData().getIntro());
            this.eCe.a(fVar.bKg);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void tF(int i) {
        String str;
        switch (i) {
            case 1:
                this.gbk.setText("");
                am.k(this.gbk, R.drawable.icon_grade_round_no1);
                return;
            case 2:
                this.gbk.setText("");
                am.k(this.gbk, R.drawable.icon_grade_round_no2);
                return;
            case 3:
                this.gbk.setText("");
                am.k(this.gbk, R.drawable.icon_grade_round_no3);
                return;
            default:
                this.gbk.setBackgroundDrawable(this.gbn);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.gbk.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZq() != null) {
            aZq().a(view, this.gbp);
        }
        if (view == getView() && this.gbo != null && !StringUtils.isNull(this.gbo.getName_show()) && !StringUtils.isNull(this.gbo.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.gbo.getUserId(), 0L), false, this.gbo.isBigV())));
        }
    }
}
