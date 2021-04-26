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
import d.a.j0.n0.a.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class MyForbiddenFansListAdapter extends RecyclerView.Adapter<FansViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f15714a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f15715b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f15716c = null;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f15717d = null;

    /* loaded from: classes4.dex */
    public static class FansViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f15718a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f15719b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f15720c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15721d;

        /* renamed from: e  reason: collision with root package name */
        public View f15722e;

        public FansViewHolder(View view) {
            super(view);
            this.f15718a = view.findViewById(R.id.container_forbidden_item);
            ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.view_fans_photo);
            this.f15719b = clickableHeaderImageView;
            clickableHeaderImageView.setRadius(l.g(view.getContext(), R.dimen.ds90));
            this.f15719b.setAutoChangeStyle(true);
            this.f15719b.setClickable(false);
            this.f15720c = (TextView) view.findViewById(R.id.view_fans_name);
            this.f15721d = (TextView) view.findViewById(R.id.view_fans_remove);
            this.f15722e = view.findViewById(R.id.line_divider);
        }
    }

    public MyForbiddenFansListAdapter(Context context) {
        this.f15714a = context;
    }

    public final void c(FansViewHolder fansViewHolder) {
        SkinManager.setViewTextColor(fansViewHolder.f15720c, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(fansViewHolder.f15722e, R.color.CAM_X0204);
        SkinManager.setViewTextColor(fansViewHolder.f15721d, R.color.btn_color_remove);
        SkinManager.setBackgroundResource(fansViewHolder.f15721d, R.drawable.btn_transparent_focus_border_bg);
    }

    public boolean d(long j) {
        if (j != 0 && !ListUtils.isEmpty(this.f15715b)) {
            Iterator<a> it = this.f15715b.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next.f56880a == j) {
                    this.f15715b.remove(next);
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<a> e() {
        return this.f15715b;
    }

    public final a f(int i2) {
        return (a) ListUtils.getItem(this.f15715b, i2);
    }

    public boolean g() {
        return ListUtils.isEmpty(this.f15715b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ListUtils.getCount(this.f15715b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public void onBindViewHolder(FansViewHolder fansViewHolder, int i2) {
        a f2;
        if (fansViewHolder == null || (f2 = f(i2)) == null) {
            return;
        }
        fansViewHolder.f15719b.V(f2.f56883d, 12, false);
        fansViewHolder.f15720c.setText(f2.f56882c);
        fansViewHolder.f15721d.setOnClickListener(this.f15716c);
        fansViewHolder.f15721d.setTag(f2);
        fansViewHolder.f15718a.setOnClickListener(this.f15717d);
        fansViewHolder.f15718a.setTag(f2);
        c(fansViewHolder);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public FansViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new FansViewHolder(LayoutInflater.from(this.f15714a).inflate(R.layout.forbidden_fans_item, (ViewGroup) null));
    }

    public void j(ArrayList<a> arrayList) {
        this.f15715b = arrayList;
    }

    public void k(View.OnClickListener onClickListener) {
        this.f15717d = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.f15716c = onClickListener;
    }
}
