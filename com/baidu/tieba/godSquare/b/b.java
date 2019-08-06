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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.f;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.a<f> {
    private c eCe;
    public ClickableHeaderImageView fWZ;
    public CommonUserLikeButton gbj;
    private TextView gbl;
    private TextView gbm;
    private MetaData gbo;
    private f gbp;
    private TextView gbq;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.fWZ = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.fWZ.setGodIconMargin(R.dimen.ds6);
        this.fWZ.setAfterClickListener(this);
        this.gbl = (TextView) getView().findViewById(R.id.god_name);
        this.gbm = (TextView) getView().findViewById(R.id.god_describe);
        this.gbq = (TextView) getView().findViewById(R.id.rec_reason);
        this.gbj = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.eCe = new c(tbPageContext, this.gbj);
        this.gbj.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
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
            am.j(this.gbq, R.color.cp_cont_d);
            am.l(this.mBottomLine, R.color.cp_bg_line_b);
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
        if (fVar != null && fVar.bKg != null && fVar.bKg.getGodUserData() != null) {
            this.gbp = fVar;
            this.gbo = fVar.bKg;
            this.fWZ.setData(fVar.bKg);
            this.gbl.setText(fVar.bKg.getName_show());
            this.gbm.setText(fVar.bKg.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(R.string.recommend_reason);
            String recommendReason = fVar.bKg.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.gbq.setText("");
            } else {
                this.gbq.setText(String.format(string, recommendReason));
            }
            this.eCe.a(fVar.bKg);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZq() != null) {
            aZq().a(view, this.gbp);
        }
        if (view == getView() && this.gbo != null && !StringUtils.isNull(this.gbo.getName_show()) && !StringUtils.isNull(this.gbo.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.gbo.getUserId(), this.gbo.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
