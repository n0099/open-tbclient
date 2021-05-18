package com.baidu.tieba.homepage.concern.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.c.j.e.a;
import d.a.k0.a1.b.f.b;
/* loaded from: classes4.dex */
public class ConcernTipAdapter extends a<b, ConcernTipViewHolder> {
    public static int m;
    public static int n;

    /* loaded from: classes4.dex */
    public static class ConcernTipViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f16273a;

        /* renamed from: b  reason: collision with root package name */
        public View f16274b;

        /* renamed from: c  reason: collision with root package name */
        public int f16275c;

        public ConcernTipViewHolder(View view) {
            super(view);
            this.f16275c = 3;
            this.f16273a = (TextView) view.findViewById(R.id.concern_tip_txt);
            this.f16274b = view.findViewById(R.id.concern_tip_top_line);
        }

        public void b(int i2) {
            if (this.f16275c != i2) {
                SkinManager.setBackgroundColor(a(), R.color.CAM_X0205);
                SkinManager.setViewTextColor(this.f16273a, R.color.CAM_X0109);
                SkinManager.setBackgroundResource(this.f16274b, R.color.CAM_X0205);
            }
        }
    }

    public ConcernTipAdapter(Context context) {
        super(context, b.j);
        m = l.g(context, R.dimen.tbds102);
        n = l.g(context, R.dimen.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public ConcernTipViewHolder P(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), R.layout.concern_tip_layout, null);
        SkinManager.setBackgroundColor(inflate, R.color.CAM_X0205);
        ConcernTipViewHolder concernTipViewHolder = new ConcernTipViewHolder(inflate);
        ViewGroup.LayoutParams t = t(viewGroup);
        t.width = -1;
        t.height = -2;
        inflate.setLayoutParams(t);
        return concernTipViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, b bVar, ConcernTipViewHolder concernTipViewHolder) {
        concernTipViewHolder.f16273a.setText(bVar.f51222f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) concernTipViewHolder.f16273a.getLayoutParams();
        if (bVar.f51223g) {
            layoutParams.height = n;
            concernTipViewHolder.f16274b.setVisibility(0);
        } else if (bVar.f51224h) {
            layoutParams.height = m;
        }
        concernTipViewHolder.f16273a.setLayoutParams(layoutParams);
        concernTipViewHolder.b(TbadkCoreApplication.getInst().getSkinType());
        return concernTipViewHolder.a();
    }
}
