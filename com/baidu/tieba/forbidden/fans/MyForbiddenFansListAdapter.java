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
    public Context f14932a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f14933b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f14934c = null;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f14935d = null;

    /* loaded from: classes4.dex */
    public static class FansViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f14936a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f14937b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14938c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14939d;

        /* renamed from: e  reason: collision with root package name */
        public View f14940e;

        public FansViewHolder(View view) {
            super(view);
            this.f14936a = view.findViewById(R.id.container_forbidden_item);
            ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.view_fans_photo);
            this.f14937b = clickableHeaderImageView;
            clickableHeaderImageView.setRadius(l.g(view.getContext(), R.dimen.ds90));
            this.f14937b.setAutoChangeStyle(true);
            this.f14937b.setClickable(false);
            this.f14938c = (TextView) view.findViewById(R.id.view_fans_name);
            this.f14939d = (TextView) view.findViewById(R.id.view_fans_remove);
            this.f14940e = view.findViewById(R.id.line_divider);
        }
    }

    public MyForbiddenFansListAdapter(Context context) {
        this.f14932a = context;
    }

    public final void c(FansViewHolder fansViewHolder) {
        SkinManager.setViewTextColor(fansViewHolder.f14938c, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(fansViewHolder.f14940e, R.color.CAM_X0204);
        SkinManager.setViewTextColor(fansViewHolder.f14939d, R.color.btn_color_remove);
        SkinManager.setBackgroundResource(fansViewHolder.f14939d, R.drawable.btn_transparent_focus_border_bg);
    }

    public boolean d(long j) {
        if (j != 0 && !ListUtils.isEmpty(this.f14933b)) {
            Iterator<a> it = this.f14933b.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next.f57759a == j) {
                    this.f14933b.remove(next);
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<a> e() {
        return this.f14933b;
    }

    public final a f(int i2) {
        return (a) ListUtils.getItem(this.f14933b, i2);
    }

    public boolean g() {
        return ListUtils.isEmpty(this.f14933b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ListUtils.getCount(this.f14933b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public void onBindViewHolder(FansViewHolder fansViewHolder, int i2) {
        a f2;
        if (fansViewHolder == null || (f2 = f(i2)) == null) {
            return;
        }
        fansViewHolder.f14937b.V(f2.f57762d, 12, false);
        fansViewHolder.f14938c.setText(f2.f57761c);
        fansViewHolder.f14939d.setOnClickListener(this.f14934c);
        fansViewHolder.f14939d.setTag(f2);
        fansViewHolder.f14936a.setOnClickListener(this.f14935d);
        fansViewHolder.f14936a.setTag(f2);
        c(fansViewHolder);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public FansViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new FansViewHolder(LayoutInflater.from(this.f14932a).inflate(R.layout.forbidden_fans_item, (ViewGroup) null));
    }

    public void j(ArrayList<a> arrayList) {
        this.f14933b = arrayList;
    }

    public void k(View.OnClickListener onClickListener) {
        this.f14935d = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.f14934c = onClickListener;
    }
}
