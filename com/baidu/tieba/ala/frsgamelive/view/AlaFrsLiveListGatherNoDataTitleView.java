package com.baidu.tieba.ala.frsgamelive.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.i0.t.e.b.a;
import d.b.i0.x.b;
/* loaded from: classes4.dex */
public class AlaFrsLiveListGatherNoDataTitleView extends b<a> {
    public TextView m;
    public TextView n;
    public TbPageContext o;
    public int p;

    /* loaded from: classes4.dex */
    public static class AlaFrsLiveListNoDataViewHolder extends TypeAdapter.ViewHolder {
        public AlaFrsLiveListNoDataViewHolder(AlaFrsLiveListGatherNoDataTitleView alaFrsLiveListGatherNoDataTitleView) {
            super(alaFrsLiveListGatherNoDataTitleView.m());
        }
    }

    public AlaFrsLiveListGatherNoDataTitleView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.p = 3;
        this.o = tbPageContext;
        View m = m();
        this.m = (TextView) m.findViewById(R.id.frs_game_live_recommand1);
        this.n = (TextView) m.findViewById(R.id.frs_game_live_recommand2);
        o(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.ala_frs_game_live_no_data_view;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.p != i) {
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0109);
            this.p = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: u */
    public void n(a aVar) {
        o(this.o, TbadkCoreApplication.getInst().getSkinType());
    }
}
