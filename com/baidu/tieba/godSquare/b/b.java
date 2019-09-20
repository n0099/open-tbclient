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
    private c eDN;
    public ClickableHeaderImageView fYQ;
    public CommonUserLikeButton gda;
    private TextView gdc;
    private TextView gdd;
    private MetaData gdf;
    private f gdg;
    private TextView gdh;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.fYQ = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.fYQ.setGodIconMargin(R.dimen.ds6);
        this.fYQ.setAfterClickListener(this);
        this.gdc = (TextView) getView().findViewById(R.id.god_name);
        this.gdd = (TextView) getView().findViewById(R.id.god_describe);
        this.gdh = (TextView) getView().findViewById(R.id.rec_reason);
        this.gda = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.eDN = new c(tbPageContext, this.gda);
        this.gda.setAfterOnClickListener(this);
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
            am.j(this.gdc, R.color.cp_cont_b);
            am.j(this.gdd, R.color.cp_cont_d);
            am.j(this.gdh, R.color.cp_cont_d);
            am.l(this.mBottomLine, R.color.cp_bg_line_c);
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
        if (fVar != null && fVar.bKE != null && fVar.bKE.getGodUserData() != null) {
            this.gdg = fVar;
            this.gdf = fVar.bKE;
            this.fYQ.setData(fVar.bKE);
            this.gdc.setText(fVar.bKE.getName_show());
            this.gdd.setText(fVar.bKE.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(R.string.recommend_reason);
            String recommendReason = fVar.bKE.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.gdh.setText("");
            } else {
                this.gdh.setText(String.format(string, recommendReason));
            }
            this.eDN.a(fVar.bKE);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZU() != null) {
            aZU().a(view, this.gdg);
        }
        if (view == getView() && this.gdf != null && !StringUtils.isNull(this.gdf.getName_show()) && !StringUtils.isNull(this.gdf.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.gdf.getUserId(), this.gdf.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
