package com.baidu.tieba.ala.frsgamelive.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.n0.v.e.b.a;
import d.a.n0.z.b;
/* loaded from: classes4.dex */
public class AlaFrsLiveListGatherNoDataTitleView extends b<a> {
    public TextView m;
    public TextView n;
    public TbPageContext o;
    public int p;

    /* loaded from: classes4.dex */
    public static class AlaFrsLiveListNoDataViewHolder extends TypeAdapter.ViewHolder {
        public AlaFrsLiveListNoDataViewHolder(AlaFrsLiveListGatherNoDataTitleView alaFrsLiveListGatherNoDataTitleView) {
            super(alaFrsLiveListGatherNoDataTitleView.l());
        }
    }

    public AlaFrsLiveListGatherNoDataTitleView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.p = 3;
        this.o = tbPageContext;
        View l = l();
        this.m = (TextView) l.findViewById(R.id.frs_game_live_recommand1);
        this.n = (TextView) l.findViewById(R.id.frs_game_live_recommand2);
        n(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.n0.z.b
    public int g() {
        return R.layout.ala_frs_game_live_no_data_view;
    }

    @Override // d.a.n0.z.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        if (this.p != i2) {
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0109);
            this.p = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: s */
    public void m(a aVar) {
        n(this.o, TbadkCoreApplication.getInst().getSkinType());
    }
}
