package com.baidu.tieba.forbidden.fans;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.n0.o0.a.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class MyForbiddenFansListAdapter extends RecyclerView.Adapter<FansViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f14989a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f14990b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f14991c = null;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f14992d = null;

    /* loaded from: classes4.dex */
    public static class FansViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f14993a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f14994b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14995c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14996d;

        /* renamed from: e  reason: collision with root package name */
        public View f14997e;

        public FansViewHolder(View view) {
            super(view);
            this.f14993a = view.findViewById(R.id.container_forbidden_item);
            ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.view_fans_photo);
            this.f14994b = clickableHeaderImageView;
            clickableHeaderImageView.setRadius(l.g(view.getContext(), R.dimen.ds90));
            this.f14994b.setAutoChangeStyle(true);
            this.f14994b.setClickable(false);
            this.f14995c = (TextView) view.findViewById(R.id.view_fans_name);
            this.f14996d = (TextView) view.findViewById(R.id.view_fans_remove);
            this.f14997e = view.findViewById(R.id.line_divider);
        }
    }

    public MyForbiddenFansListAdapter(Context context) {
        this.f14989a = context;
    }

    public final void c(FansViewHolder fansViewHolder) {
        SkinManager.setViewTextColor(fansViewHolder.f14995c, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(fansViewHolder.f14997e, R.color.CAM_X0204);
        SkinManager.setViewTextColor(fansViewHolder.f14996d, R.color.btn_color_remove);
        SkinManager.setBackgroundResource(fansViewHolder.f14996d, R.drawable.btn_transparent_focus_border_bg);
    }

    public boolean d(long j) {
        if (j != 0 && !ListUtils.isEmpty(this.f14990b)) {
            Iterator<a> it = this.f14990b.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next.f61448a == j) {
                    this.f14990b.remove(next);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ListUtils.getCount(this.f14990b);
    }

    public ArrayList<a> m() {
        return this.f14990b;
    }

    public final a n(int i2) {
        return (a) ListUtils.getItem(this.f14990b, i2);
    }

    public boolean o() {
        return ListUtils.isEmpty(this.f14990b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public void onBindViewHolder(FansViewHolder fansViewHolder, int i2) {
        a n;
        if (fansViewHolder == null || (n = n(i2)) == null) {
            return;
        }
        fansViewHolder.f14994b.U(n.f61451d, 12, false);
        fansViewHolder.f14995c.setText(n.f61450c);
        fansViewHolder.f14996d.setOnClickListener(this.f14991c);
        fansViewHolder.f14996d.setTag(n);
        fansViewHolder.f14993a.setOnClickListener(this.f14992d);
        fansViewHolder.f14993a.setTag(n);
        c(fansViewHolder);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q */
    public FansViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new FansViewHolder(LayoutInflater.from(this.f14989a).inflate(R.layout.forbidden_fans_item, (ViewGroup) null));
    }

    public void r(ArrayList<a> arrayList) {
        this.f14990b = arrayList;
    }

    public void s(View.OnClickListener onClickListener) {
        this.f14992d = onClickListener;
    }

    public void t(View.OnClickListener onClickListener) {
        this.f14991c = onClickListener;
    }
}
