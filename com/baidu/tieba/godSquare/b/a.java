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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.f;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.a<f> {
    private c ewX;
    public ClickableHeaderImageView fRj;
    public CommonUserLikeButton fVt;
    private TextView fVu;
    private TextView fVv;
    private TextView fVw;
    private Drawable fVx;
    private MetaData fVy;
    private f fVz;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.fRj = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.fRj.setGodIconMargin(R.dimen.ds4);
        this.fRj.setAfterClickListener(this);
        this.fVv = (TextView) getView().findViewById(R.id.god_name);
        this.fVw = (TextView) getView().findViewById(R.id.god_describe);
        this.fVt = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.ewX = new c(tbPageContext, this.fVt);
        this.fVt.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
        this.fVu = (TextView) getView().findViewById(R.id.god_rank);
        this.fVx = this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), R.drawable.home_thread_card_item_bg);
            al.j(this.fVv, R.color.cp_cont_b);
            al.j(this.fVw, R.color.cp_cont_d);
            al.l(this.mBottomLine, R.color.cp_bg_line_b);
            al.j(this.fVu, R.color.cp_cont_d);
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
        if (fVar != null && fVar.bJa != null && fVar.bJa.getGodUserData() != null) {
            this.fVz = fVar;
            this.fVy = fVar.bJa;
            tl(fVar.rank);
            this.fRj.setData(fVar.bJa);
            this.fVv.setText(fVar.bJa.getName_show());
            this.fVw.setText(fVar.bJa.getGodUserData().getIntro());
            this.ewX.a(fVar.bJa);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void tl(int i) {
        String str;
        switch (i) {
            case 1:
                this.fVu.setText("");
                al.k(this.fVu, R.drawable.icon_grade_round_no1);
                return;
            case 2:
                this.fVu.setText("");
                al.k(this.fVu, R.drawable.icon_grade_round_no2);
                return;
            case 3:
                this.fVu.setText("");
                al.k(this.fVu, R.drawable.icon_grade_round_no3);
                return;
            default:
                this.fVu.setBackgroundDrawable(this.fVx);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.fVu.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aXo() != null) {
            aXo().a(view, this.fVz);
        }
        if (view == getView() && this.fVy != null && !StringUtils.isNull(this.fVy.getName_show()) && !StringUtils.isNull(this.fVy.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.fVy.getUserId(), 0L), false, this.fVy.isBigV())));
        }
    }
}
