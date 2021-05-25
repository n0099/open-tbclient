package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.m0.r.q.a2;
import d.a.n0.e3.n0.d;
import d.a.n0.z.b;
/* loaded from: classes4.dex */
public class FrsGameStrategyItemView extends b<d.a.n0.r0.s1.a.a.b> {
    public TbPageContext m;
    public View n;
    public TbImageView o;
    public ImageView p;
    public TextView q;
    public TextView r;
    public TextView s;

    /* loaded from: classes4.dex */
    public static class FrsGameStrategyItemViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public FrsGameStrategyItemView f15442a;

        public FrsGameStrategyItemViewHolder(FrsGameStrategyItemView frsGameStrategyItemView) {
            super(frsGameStrategyItemView.l());
            this.f15442a = frsGameStrategyItemView;
        }
    }

    public FrsGameStrategyItemView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.m = tbPageContext;
        this.n = l();
        s();
    }

    @Override // d.a.n0.z.b
    public int g() {
        return R.layout.frs_game_strategy_item_layout;
    }

    @Override // d.a.n0.z.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.s, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(this.n, R.drawable.addresslist_item_bg);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final void s() {
        TbImageView tbImageView = (TbImageView) this.n.findViewById(R.id.frs_game_left_image);
        this.o = tbImageView;
        tbImageView.setDefaultResource(R.drawable.icon_morenpic);
        this.p = (ImageView) this.n.findViewById(R.id.frs_game_video_icon);
        this.q = (TextView) this.n.findViewById(R.id.frs_game_strategy_title);
        this.r = (TextView) this.n.findViewById(R.id.frs_game_strategy_scan_info);
        this.s = (TextView) this.n.findViewById(R.id.frs_game_strategy_info_source);
        n(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: t */
    public void m(d.a.n0.r0.s1.a.a.b bVar) {
        if (bVar == null || bVar.h() == null) {
            return;
        }
        a2 h2 = bVar.h();
        this.q.setText(h2.z1());
        d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.d(h2.o0())) {
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0108);
        } else {
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0105);
        }
        String numberUniformFormat = StringHelper.numberUniformFormat(h2.I1());
        String formatTimeShort = StringHelper.getFormatTimeShort(h2.S());
        if (!StringUtils.isNull(numberUniformFormat) && !StringUtils.isNull(formatTimeShort)) {
            this.r.setText(String.format(this.f63442g.getString(R.string.frs_game_strategy_scan_info), numberUniformFormat, formatTimeShort));
        }
        String str = null;
        if (h2.u1() == 40) {
            this.p.setVisibility(0);
            if (h2.w1() != null) {
                str = h2.w1().thumbnail_url;
            }
        } else {
            this.p.setVisibility(8);
            if (h2.L0() != null && h2.L0().size() >= 1) {
                str = h2.L0().get(0).getOriginalUrl();
            }
        }
        this.o.V(str, 10, false);
        if (!StringUtils.isNull(h2.k0())) {
            this.s.setText(h2.k0());
            this.s.setVisibility(0);
            return;
        }
        this.s.setVisibility(8);
    }
}
