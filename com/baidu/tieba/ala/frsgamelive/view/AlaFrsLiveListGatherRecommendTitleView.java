package com.baidu.tieba.ala.frsgamelive.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class AlaFrsLiveListGatherRecommendTitleView extends com.baidu.tieba.card.b<com.baidu.tieba.ala.frsgamelive.b.b> {
    private View gWw;
    private TextView gWx;
    private View gWy;
    private int mSkinType;
    private TbPageContext mTbPageContext;

    public AlaFrsLiveListGatherRecommendTitleView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.gWw = view.findViewById(R.id.frs_game_live_recommand_line1);
        this.gWx = (TextView) view.findViewById(R.id.frs_game_live_recommand3);
        this.gWy = view.findViewById(R.id.frs_game_live_recommand_line2);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gWw, R.color.CAM_X0204);
            ap.setViewTextColor(this.gWx, R.color.CAM_X0109);
            ap.setBackgroundResource(this.gWy, R.color.CAM_X0204);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_frs_game_live_recommend_title_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.frsgamelive.b.b bVar) {
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes10.dex */
    public static class AlaFrsLiveListGatherRecommendTitleViewHolder extends TypeAdapter.ViewHolder {
        public AlaFrsLiveListGatherRecommendTitleView gWz;

        public AlaFrsLiveListGatherRecommendTitleViewHolder(AlaFrsLiveListGatherRecommendTitleView alaFrsLiveListGatherRecommendTitleView) {
            super(alaFrsLiveListGatherRecommendTitleView.getView());
            this.gWz = alaFrsLiveListGatherRecommendTitleView;
        }
    }
}
