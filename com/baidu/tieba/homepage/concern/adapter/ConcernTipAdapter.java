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
import d.b.b.e.p.l;
import d.b.b.j.e.a;
import d.b.i0.z0.b.f.b;
/* loaded from: classes4.dex */
public class ConcernTipAdapter extends a<b, ConcernTipViewHolder> {
    public static int m;
    public static int n;

    /* loaded from: classes4.dex */
    public static class ConcernTipViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f17024a;

        /* renamed from: b  reason: collision with root package name */
        public View f17025b;

        /* renamed from: c  reason: collision with root package name */
        public int f17026c;

        public ConcernTipViewHolder(View view) {
            super(view);
            this.f17026c = 3;
            this.f17024a = (TextView) view.findViewById(R.id.concern_tip_txt);
            this.f17025b = view.findViewById(R.id.concern_tip_top_line);
        }

        public void b(int i) {
            if (this.f17026c != i) {
                SkinManager.setBackgroundColor(a(), R.color.CAM_X0205);
                SkinManager.setViewTextColor(this.f17024a, R.color.CAM_X0109);
                SkinManager.setBackgroundResource(this.f17025b, R.color.CAM_X0205);
            }
        }
    }

    public ConcernTipAdapter(Context context) {
        super(context, b.j);
        m = l.g(context, R.dimen.tbds102);
        n = l.g(context, R.dimen.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
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
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, b bVar, ConcernTipViewHolder concernTipViewHolder) {
        concernTipViewHolder.f17024a.setText(bVar.f62790f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) concernTipViewHolder.f17024a.getLayoutParams();
        if (bVar.f62791g) {
            layoutParams.height = n;
            concernTipViewHolder.f17025b.setVisibility(0);
        } else if (bVar.f62792h) {
            layoutParams.height = m;
        }
        concernTipViewHolder.f17024a.setLayoutParams(layoutParams);
        concernTipViewHolder.b(TbadkCoreApplication.getInst().getSkinType());
        return concernTipViewHolder.a();
    }
}
