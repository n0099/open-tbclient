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
    private c eBX;
    public ClickableHeaderImageView fWj;
    public CommonUserLikeButton gat;
    private TextView gau;
    private TextView gav;
    private TextView gaw;
    private Drawable gax;
    private MetaData gay;
    private f gaz;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.fWj = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.fWj.setGodIconMargin(R.dimen.ds4);
        this.fWj.setAfterClickListener(this);
        this.gav = (TextView) getView().findViewById(R.id.god_name);
        this.gaw = (TextView) getView().findViewById(R.id.god_describe);
        this.gat = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.eBX = new c(tbPageContext, this.gat);
        this.gat.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
        this.gau = (TextView) getView().findViewById(R.id.god_rank);
        this.gax = this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(getView(), R.drawable.home_thread_card_item_bg);
            am.j(this.gav, R.color.cp_cont_b);
            am.j(this.gaw, R.color.cp_cont_d);
            am.l(this.mBottomLine, R.color.cp_bg_line_b);
            am.j(this.gau, R.color.cp_cont_d);
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
        if (fVar != null && fVar.bKb != null && fVar.bKb.getGodUserData() != null) {
            this.gaz = fVar;
            this.gay = fVar.bKb;
            tD(fVar.rank);
            this.fWj.setData(fVar.bKb);
            this.gav.setText(fVar.bKb.getName_show());
            this.gaw.setText(fVar.bKb.getGodUserData().getIntro());
            this.eBX.a(fVar.bKb);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void tD(int i) {
        String str;
        switch (i) {
            case 1:
                this.gau.setText("");
                am.k(this.gau, R.drawable.icon_grade_round_no1);
                return;
            case 2:
                this.gau.setText("");
                am.k(this.gau, R.drawable.icon_grade_round_no2);
                return;
            case 3:
                this.gau.setText("");
                am.k(this.gau, R.drawable.icon_grade_round_no3);
                return;
            default:
                this.gau.setBackgroundDrawable(this.gax);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.gau.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZo() != null) {
            aZo().a(view, this.gaz);
        }
        if (view == getView() && this.gay != null && !StringUtils.isNull(this.gay.getName_show()) && !StringUtils.isNull(this.gay.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.gay.getUserId(), 0L), false, this.gay.isBigV())));
        }
    }
}
