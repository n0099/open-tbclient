package com.baidu.tieba.ala.frsgamelive.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.i0.x.b;
/* loaded from: classes4.dex */
public class AlaFrsLiveListGatherRecommendTitleView extends b<d.b.i0.t.e.b.b> {
    public View m;
    public TextView n;
    public View o;
    public TbPageContext p;
    public int q;

    /* loaded from: classes4.dex */
    public static class AlaFrsLiveListGatherRecommendTitleViewHolder extends TypeAdapter.ViewHolder {
        public AlaFrsLiveListGatherRecommendTitleViewHolder(AlaFrsLiveListGatherRecommendTitleView alaFrsLiveListGatherRecommendTitleView) {
            super(alaFrsLiveListGatherRecommendTitleView.m());
        }
    }

    public AlaFrsLiveListGatherRecommendTitleView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.q = 3;
        View m = m();
        this.m = m.findViewById(R.id.frs_game_live_recommand_line1);
        this.n = (TextView) m.findViewById(R.id.frs_game_live_recommand3);
        this.o = m.findViewById(R.id.frs_game_live_recommand_line2);
        o(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.ala_frs_game_live_recommend_title_view;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.q != i) {
            SkinManager.setBackgroundResource(this.m, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.o, R.color.CAM_X0204);
            this.q = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: u */
    public void n(d.b.i0.t.e.b.b bVar) {
        o(this.p, TbadkCoreApplication.getInst().getSkinType());
    }
}
