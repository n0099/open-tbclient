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
import d.b.h0.r.q.a2;
import d.b.i0.d3.n0.d;
import d.b.i0.x.b;
/* loaded from: classes4.dex */
public class FrsGameStrategyItemView extends b<d.b.i0.q0.s1.a.a.b> {
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
        public FrsGameStrategyItemView f16015a;

        public FrsGameStrategyItemViewHolder(FrsGameStrategyItemView frsGameStrategyItemView) {
            super(frsGameStrategyItemView.m());
            this.f16015a = frsGameStrategyItemView;
        }
    }

    public FrsGameStrategyItemView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.m = tbPageContext;
        this.n = m();
        u();
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.frs_game_strategy_item_layout;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.s, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(this.n, R.drawable.addresslist_item_bg);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final void u() {
        TbImageView tbImageView = (TbImageView) this.n.findViewById(R.id.frs_game_left_image);
        this.o = tbImageView;
        tbImageView.setDefaultResource(R.drawable.icon_morenpic);
        this.p = (ImageView) this.n.findViewById(R.id.frs_game_video_icon);
        this.q = (TextView) this.n.findViewById(R.id.frs_game_strategy_title);
        this.r = (TextView) this.n.findViewById(R.id.frs_game_strategy_scan_info);
        this.s = (TextView) this.n.findViewById(R.id.frs_game_strategy_info_source);
        o(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: v */
    public void n(d.b.i0.q0.s1.a.a.b bVar) {
        if (bVar == null || bVar.g() == null) {
            return;
        }
        a2 g2 = bVar.g();
        this.q.setText(g2.x1());
        d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.d(g2.o0())) {
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0108);
        } else {
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0105);
        }
        String numberUniformFormat = StringHelper.numberUniformFormat(g2.G1());
        String formatTimeShort = StringHelper.getFormatTimeShort(g2.S());
        if (!StringUtils.isNull(numberUniformFormat) && !StringUtils.isNull(formatTimeShort)) {
            this.r.setText(String.format(this.f63757g.getString(R.string.frs_game_strategy_scan_info), numberUniformFormat, formatTimeShort));
        }
        String str = null;
        if (g2.s1() == 40) {
            this.p.setVisibility(0);
            if (g2.u1() != null) {
                str = g2.u1().thumbnail_url;
            }
        } else {
            this.p.setVisibility(8);
            if (g2.K0() != null && g2.K0().size() >= 1) {
                str = g2.K0().get(0).getOriginalUrl();
            }
        }
        this.o.W(str, 10, false);
        if (!StringUtils.isNull(g2.k0())) {
            this.s.setText(g2.k0());
            this.s.setVisibility(0);
            return;
        }
        this.s.setVisibility(8);
    }
}
