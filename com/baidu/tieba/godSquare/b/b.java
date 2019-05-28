package com.baidu.tieba.godSquare.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.f;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.a<f> {
    private c ewY;
    public ClickableHeaderImageView fRk;
    private f fVA;
    private TextView fVB;
    public CommonUserLikeButton fVu;
    private TextView fVw;
    private TextView fVx;
    private MetaData fVz;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.fRk = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.fRk.setGodIconMargin(R.dimen.ds6);
        this.fRk.setAfterClickListener(this);
        this.fVw = (TextView) getView().findViewById(R.id.god_name);
        this.fVx = (TextView) getView().findViewById(R.id.god_describe);
        this.fVB = (TextView) getView().findViewById(R.id.rec_reason);
        this.fVu = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.ewY = new c(tbPageContext, this.fVu);
        this.fVu.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), R.drawable.home_thread_card_item_bg);
            al.j(this.fVw, R.color.cp_cont_b);
            al.j(this.fVx, R.color.cp_cont_d);
            al.j(this.fVB, R.color.cp_cont_d);
            al.l(this.mBottomLine, R.color.cp_bg_line_b);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_god_square_rec_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(f fVar) {
        if (fVar != null && fVar.bJa != null && fVar.bJa.getGodUserData() != null) {
            this.fVA = fVar;
            this.fVz = fVar.bJa;
            this.fRk.setData(fVar.bJa);
            this.fVw.setText(fVar.bJa.getName_show());
            this.fVx.setText(fVar.bJa.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(R.string.recommend_reason);
            String recommendReason = fVar.bJa.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.fVB.setText("");
            } else {
                this.fVB.setText(String.format(string, recommendReason));
            }
            this.ewY.a(fVar.bJa);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aXr() != null) {
            aXr().a(view, this.fVA);
        }
        if (view == getView() && this.fVz != null && !StringUtils.isNull(this.fVz.getName_show()) && !StringUtils.isNull(this.fVz.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.fVz.getUserId(), this.fVz.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
