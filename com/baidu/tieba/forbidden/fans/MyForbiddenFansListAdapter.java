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
import d.b.b.e.p.l;
import d.b.i0.m0.a.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class MyForbiddenFansListAdapter extends RecyclerView.Adapter<FansViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f15885a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f15886b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f15887c = null;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f15888d = null;

    /* loaded from: classes4.dex */
    public static class FansViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f15889a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f15890b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f15891c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15892d;

        /* renamed from: e  reason: collision with root package name */
        public View f15893e;

        public FansViewHolder(View view) {
            super(view);
            this.f15889a = view.findViewById(R.id.container_forbidden_item);
            ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.view_fans_photo);
            this.f15890b = clickableHeaderImageView;
            clickableHeaderImageView.setRadius(l.g(view.getContext(), R.dimen.ds90));
            this.f15890b.setAutoChangeStyle(true);
            this.f15890b.setClickable(false);
            this.f15891c = (TextView) view.findViewById(R.id.view_fans_name);
            this.f15892d = (TextView) view.findViewById(R.id.view_fans_remove);
            this.f15893e = view.findViewById(R.id.line_divider);
        }
    }

    public MyForbiddenFansListAdapter(Context context) {
        this.f15885a = context;
    }

    public final void c(FansViewHolder fansViewHolder) {
        SkinManager.setViewTextColor(fansViewHolder.f15891c, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(fansViewHolder.f15893e, R.color.CAM_X0204);
        SkinManager.setViewTextColor(fansViewHolder.f15892d, R.color.btn_color_remove);
        SkinManager.setBackgroundResource(fansViewHolder.f15892d, R.drawable.btn_transparent_focus_border_bg);
    }

    public boolean d(long j) {
        if (j != 0 && !ListUtils.isEmpty(this.f15886b)) {
            Iterator<a> it = this.f15886b.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next.f56807a == j) {
                    this.f15886b.remove(next);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ListUtils.getCount(this.f15886b);
    }

    public ArrayList<a> m() {
        return this.f15886b;
    }

    public final a n(int i) {
        return (a) ListUtils.getItem(this.f15886b, i);
    }

    public boolean o() {
        return ListUtils.isEmpty(this.f15886b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public void onBindViewHolder(FansViewHolder fansViewHolder, int i) {
        a n;
        if (fansViewHolder == null || (n = n(i)) == null) {
            return;
        }
        fansViewHolder.f15890b.W(n.f56810d, 12, false);
        fansViewHolder.f15891c.setText(n.f56809c);
        fansViewHolder.f15892d.setOnClickListener(this.f15887c);
        fansViewHolder.f15892d.setTag(n);
        fansViewHolder.f15889a.setOnClickListener(this.f15888d);
        fansViewHolder.f15889a.setTag(n);
        c(fansViewHolder);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q */
    public FansViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new FansViewHolder(LayoutInflater.from(this.f15885a).inflate(R.layout.forbidden_fans_item, (ViewGroup) null));
    }

    public void r(ArrayList<a> arrayList) {
        this.f15886b = arrayList;
    }

    public void s(View.OnClickListener onClickListener) {
        this.f15888d = onClickListener;
    }

    public void u(View.OnClickListener onClickListener) {
        this.f15887c = onClickListener;
    }
}
