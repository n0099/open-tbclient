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
    private c eDN;
    public ClickableHeaderImageView fYQ;
    public CommonUserLikeButton gda;
    private TextView gdb;
    private TextView gdc;
    private TextView gdd;
    private Drawable gde;
    private MetaData gdf;
    private f gdg;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.fYQ = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.fYQ.setGodIconMargin(R.dimen.ds4);
        this.fYQ.setAfterClickListener(this);
        this.gdc = (TextView) getView().findViewById(R.id.god_name);
        this.gdd = (TextView) getView().findViewById(R.id.god_describe);
        this.gda = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.eDN = new c(tbPageContext, this.gda);
        this.gda.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
        this.gdb = (TextView) getView().findViewById(R.id.god_rank);
        this.gde = this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(getView(), R.drawable.home_thread_card_item_bg);
            am.j(this.gdc, R.color.cp_cont_b);
            am.j(this.gdd, R.color.cp_cont_d);
            am.l(this.mBottomLine, R.color.cp_bg_line_c);
            am.j(this.gdb, R.color.cp_cont_d);
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
        if (fVar != null && fVar.bKE != null && fVar.bKE.getGodUserData() != null) {
            this.gdg = fVar;
            this.gdf = fVar.bKE;
            tJ(fVar.rank);
            this.fYQ.setData(fVar.bKE);
            this.gdc.setText(fVar.bKE.getName_show());
            this.gdd.setText(fVar.bKE.getGodUserData().getIntro());
            this.eDN.a(fVar.bKE);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void tJ(int i) {
        String str;
        switch (i) {
            case 1:
                this.gdb.setText("");
                am.k(this.gdb, R.drawable.icon_grade_round_no1);
                return;
            case 2:
                this.gdb.setText("");
                am.k(this.gdb, R.drawable.icon_grade_round_no2);
                return;
            case 3:
                this.gdb.setText("");
                am.k(this.gdb, R.drawable.icon_grade_round_no3);
                return;
            default:
                this.gdb.setBackgroundDrawable(this.gde);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.gdb.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZU() != null) {
            aZU().a(view, this.gdg);
        }
        if (view == getView() && this.gdf != null && !StringUtils.isNull(this.gdf.getName_show()) && !StringUtils.isNull(this.gdf.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.e(this.gdf.getUserId(), 0L), false, this.gdf.isBigV())));
        }
    }
}
