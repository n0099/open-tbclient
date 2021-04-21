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
import d.b.c.e.p.l;
import d.b.c.j.e.a;
import d.b.j0.a1.b.f.b;
/* loaded from: classes4.dex */
public class ConcernTipAdapter extends a<b, ConcernTipViewHolder> {
    public static int m;
    public static int n;

    /* loaded from: classes4.dex */
    public static class ConcernTipViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f16706a;

        /* renamed from: b  reason: collision with root package name */
        public View f16707b;

        /* renamed from: c  reason: collision with root package name */
        public int f16708c;

        public ConcernTipViewHolder(View view) {
            super(view);
            this.f16708c = 3;
            this.f16706a = (TextView) view.findViewById(R.id.concern_tip_txt);
            this.f16707b = view.findViewById(R.id.concern_tip_top_line);
        }

        public void b(int i) {
            if (this.f16708c != i) {
                SkinManager.setBackgroundColor(a(), R.color.CAM_X0205);
                SkinManager.setViewTextColor(this.f16706a, R.color.CAM_X0109);
                SkinManager.setBackgroundResource(this.f16707b, R.color.CAM_X0205);
            }
        }
    }

    public ConcernTipAdapter(Context context) {
        super(context, b.j);
        m = l.g(context, R.dimen.tbds102);
        n = l.g(context, R.dimen.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public ConcernTipViewHolder R(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), R.layout.concern_tip_layout, null);
        SkinManager.setBackgroundColor(inflate, R.color.CAM_X0205);
        ConcernTipViewHolder concernTipViewHolder = new ConcernTipViewHolder(inflate);
        ViewGroup.LayoutParams u = u(viewGroup);
        u.width = -1;
        u.height = -2;
        inflate.setLayoutParams(u);
        return concernTipViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, b bVar, ConcernTipViewHolder concernTipViewHolder) {
        concernTipViewHolder.f16706a.setText(bVar.f52831f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) concernTipViewHolder.f16706a.getLayoutParams();
        if (bVar.f52832g) {
            layoutParams.height = n;
            concernTipViewHolder.f16707b.setVisibility(0);
        } else if (bVar.f52833h) {
            layoutParams.height = m;
        }
        concernTipViewHolder.f16706a.setLayoutParams(layoutParams);
        concernTipViewHolder.b(TbadkCoreApplication.getInst().getSkinType());
        return concernTipViewHolder.a();
    }
}
