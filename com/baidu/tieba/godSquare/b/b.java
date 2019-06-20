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
    public ClickableHeaderImageView fRm;
    private MetaData fVB;
    private f fVC;
    private TextView fVD;
    public CommonUserLikeButton fVw;
    private TextView fVy;
    private TextView fVz;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.fRm = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.fRm.setGodIconMargin(R.dimen.ds6);
        this.fRm.setAfterClickListener(this);
        this.fVy = (TextView) getView().findViewById(R.id.god_name);
        this.fVz = (TextView) getView().findViewById(R.id.god_describe);
        this.fVD = (TextView) getView().findViewById(R.id.rec_reason);
        this.fVw = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.ewY = new c(tbPageContext, this.fVw);
        this.fVw.setAfterOnClickListener(this);
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
            al.j(this.fVy, R.color.cp_cont_b);
            al.j(this.fVz, R.color.cp_cont_d);
            al.j(this.fVD, R.color.cp_cont_d);
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
        if (fVar != null && fVar.bJb != null && fVar.bJb.getGodUserData() != null) {
            this.fVC = fVar;
            this.fVB = fVar.bJb;
            this.fRm.setData(fVar.bJb);
            this.fVy.setText(fVar.bJb.getName_show());
            this.fVz.setText(fVar.bJb.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(R.string.recommend_reason);
            String recommendReason = fVar.bJb.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.fVD.setText("");
            } else {
                this.fVD.setText(String.format(string, recommendReason));
            }
            this.ewY.a(fVar.bJb);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aXr() != null) {
            aXr().a(view, this.fVC);
        }
        if (view == getView() && this.fVB != null && !StringUtils.isNull(this.fVB.getName_show()) && !StringUtils.isNull(this.fVB.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.fVB.getUserId(), this.fVB.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
