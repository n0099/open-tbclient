package com.baidu.tieba.ala.frsgamelive.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class AlaFrsLiveListGatherNoDataTitleView extends com.baidu.tieba.card.b<com.baidu.tieba.ala.frsgamelive.b.a> {
    private TextView gTv;
    private TextView gTw;
    private int mSkinType;
    private TbPageContext mTbPageContext;

    public AlaFrsLiveListGatherNoDataTitleView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mTbPageContext = tbPageContext;
        View view = getView();
        this.gTv = (TextView) view.findViewById(R.id.frs_game_live_recommand1);
        this.gTw = (TextView) view.findViewById(R.id.frs_game_live_recommand2);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.gTv, R.color.CAM_X0109);
            ao.setViewTextColor(this.gTw, R.color.CAM_X0109);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_frs_game_live_no_data_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.frsgamelive.b.a aVar) {
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes9.dex */
    public static class AlaFrsLiveListNoDataViewHolder extends TypeAdapter.ViewHolder {
        public AlaFrsLiveListGatherNoDataTitleView gTx;

        public AlaFrsLiveListNoDataViewHolder(AlaFrsLiveListGatherNoDataTitleView alaFrsLiveListGatherNoDataTitleView) {
            super(alaFrsLiveListGatherNoDataTitleView.getView());
            this.gTx = alaFrsLiveListGatherNoDataTitleView;
        }
    }
}
