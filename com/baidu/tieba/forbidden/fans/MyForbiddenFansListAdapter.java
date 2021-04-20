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
import d.b.c.e.p.l;
import d.b.i0.n0.a.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class MyForbiddenFansListAdapter extends RecyclerView.Adapter<FansViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f15546a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f15547b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f15548c = null;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f15549d = null;

    /* loaded from: classes4.dex */
    public static class FansViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f15550a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f15551b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f15552c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15553d;

        /* renamed from: e  reason: collision with root package name */
        public View f15554e;

        public FansViewHolder(View view) {
            super(view);
            this.f15550a = view.findViewById(R.id.container_forbidden_item);
            ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.view_fans_photo);
            this.f15551b = clickableHeaderImageView;
            clickableHeaderImageView.setRadius(l.g(view.getContext(), R.dimen.ds90));
            this.f15551b.setAutoChangeStyle(true);
            this.f15551b.setClickable(false);
            this.f15552c = (TextView) view.findViewById(R.id.view_fans_name);
            this.f15553d = (TextView) view.findViewById(R.id.view_fans_remove);
            this.f15554e = view.findViewById(R.id.line_divider);
        }
    }

    public MyForbiddenFansListAdapter(Context context) {
        this.f15546a = context;
    }

    public final void c(FansViewHolder fansViewHolder) {
        SkinManager.setViewTextColor(fansViewHolder.f15552c, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(fansViewHolder.f15554e, R.color.CAM_X0204);
        SkinManager.setViewTextColor(fansViewHolder.f15553d, R.color.btn_color_remove);
        SkinManager.setBackgroundResource(fansViewHolder.f15553d, R.drawable.btn_transparent_focus_border_bg);
    }

    public boolean d(long j) {
        if (j != 0 && !ListUtils.isEmpty(this.f15547b)) {
            Iterator<a> it = this.f15547b.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next.f58444a == j) {
                    this.f15547b.remove(next);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ListUtils.getCount(this.f15547b);
    }

    public ArrayList<a> m() {
        return this.f15547b;
    }

    public final a n(int i) {
        return (a) ListUtils.getItem(this.f15547b, i);
    }

    public boolean o() {
        return ListUtils.isEmpty(this.f15547b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public void onBindViewHolder(FansViewHolder fansViewHolder, int i) {
        a n;
        if (fansViewHolder == null || (n = n(i)) == null) {
            return;
        }
        fansViewHolder.f15551b.W(n.f58447d, 12, false);
        fansViewHolder.f15552c.setText(n.f58446c);
        fansViewHolder.f15553d.setOnClickListener(this.f15548c);
        fansViewHolder.f15553d.setTag(n);
        fansViewHolder.f15550a.setOnClickListener(this.f15549d);
        fansViewHolder.f15550a.setTag(n);
        c(fansViewHolder);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q */
    public FansViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new FansViewHolder(LayoutInflater.from(this.f15546a).inflate(R.layout.forbidden_fans_item, (ViewGroup) null));
    }

    public void r(ArrayList<a> arrayList) {
        this.f15547b = arrayList;
    }

    public void s(View.OnClickListener onClickListener) {
        this.f15549d = onClickListener;
    }

    public void u(View.OnClickListener onClickListener) {
        this.f15548c = onClickListener;
    }
}
