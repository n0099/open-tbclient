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
import d.a.k0.n0.a.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class MyForbiddenFansListAdapter extends RecyclerView.Adapter<FansViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f15029a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f15030b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f15031c = null;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f15032d = null;

    /* loaded from: classes4.dex */
    public static class FansViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f15033a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f15034b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f15035c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15036d;

        /* renamed from: e  reason: collision with root package name */
        public View f15037e;

        public FansViewHolder(View view) {
            super(view);
            this.f15033a = view.findViewById(R.id.container_forbidden_item);
            ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.view_fans_photo);
            this.f15034b = clickableHeaderImageView;
            clickableHeaderImageView.setRadius(l.g(view.getContext(), R.dimen.ds90));
            this.f15034b.setAutoChangeStyle(true);
            this.f15034b.setClickable(false);
            this.f15035c = (TextView) view.findViewById(R.id.view_fans_name);
            this.f15036d = (TextView) view.findViewById(R.id.view_fans_remove);
            this.f15037e = view.findViewById(R.id.line_divider);
        }
    }

    public MyForbiddenFansListAdapter(Context context) {
        this.f15029a = context;
    }

    public final void c(FansViewHolder fansViewHolder) {
        SkinManager.setViewTextColor(fansViewHolder.f15035c, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(fansViewHolder.f15037e, R.color.CAM_X0204);
        SkinManager.setViewTextColor(fansViewHolder.f15036d, R.color.btn_color_remove);
        SkinManager.setBackgroundResource(fansViewHolder.f15036d, R.drawable.btn_transparent_focus_border_bg);
    }

    public boolean d(long j) {
        if (j != 0 && !ListUtils.isEmpty(this.f15030b)) {
            Iterator<a> it = this.f15030b.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next.f57587a == j) {
                    this.f15030b.remove(next);
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<a> e() {
        return this.f15030b;
    }

    public final a f(int i2) {
        return (a) ListUtils.getItem(this.f15030b, i2);
    }

    public boolean g() {
        return ListUtils.isEmpty(this.f15030b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ListUtils.getCount(this.f15030b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public void onBindViewHolder(FansViewHolder fansViewHolder, int i2) {
        a f2;
        if (fansViewHolder == null || (f2 = f(i2)) == null) {
            return;
        }
        fansViewHolder.f15034b.V(f2.f57590d, 12, false);
        fansViewHolder.f15035c.setText(f2.f57589c);
        fansViewHolder.f15036d.setOnClickListener(this.f15031c);
        fansViewHolder.f15036d.setTag(f2);
        fansViewHolder.f15033a.setOnClickListener(this.f15032d);
        fansViewHolder.f15033a.setTag(f2);
        c(fansViewHolder);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public FansViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new FansViewHolder(LayoutInflater.from(this.f15029a).inflate(R.layout.forbidden_fans_item, (ViewGroup) null));
    }

    public void j(ArrayList<a> arrayList) {
        this.f15030b = arrayList;
    }

    public void k(View.OnClickListener onClickListener) {
        this.f15032d = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.f15031c = onClickListener;
    }
}
