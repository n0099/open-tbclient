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
import d.a.o0.o0.a.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class MyForbiddenFansListAdapter extends RecyclerView.Adapter<FansViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f15071a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f15072b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f15073c = null;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f15074d = null;

    /* loaded from: classes4.dex */
    public static class FansViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f15075a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f15076b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f15077c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15078d;

        /* renamed from: e  reason: collision with root package name */
        public View f15079e;

        public FansViewHolder(View view) {
            super(view);
            this.f15075a = view.findViewById(R.id.container_forbidden_item);
            ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.view_fans_photo);
            this.f15076b = clickableHeaderImageView;
            clickableHeaderImageView.setRadius(l.g(view.getContext(), R.dimen.ds90));
            this.f15076b.setAutoChangeStyle(true);
            this.f15076b.setClickable(false);
            this.f15077c = (TextView) view.findViewById(R.id.view_fans_name);
            this.f15078d = (TextView) view.findViewById(R.id.view_fans_remove);
            this.f15079e = view.findViewById(R.id.line_divider);
        }
    }

    public MyForbiddenFansListAdapter(Context context) {
        this.f15071a = context;
    }

    public final void c(FansViewHolder fansViewHolder) {
        SkinManager.setViewTextColor(fansViewHolder.f15077c, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(fansViewHolder.f15079e, R.color.CAM_X0204);
        SkinManager.setViewTextColor(fansViewHolder.f15078d, R.color.btn_color_remove);
        SkinManager.setBackgroundResource(fansViewHolder.f15078d, R.drawable.btn_transparent_focus_border_bg);
    }

    public boolean d(long j) {
        if (j != 0 && !ListUtils.isEmpty(this.f15072b)) {
            Iterator<a> it = this.f15072b.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next.f61573a == j) {
                    this.f15072b.remove(next);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ListUtils.getCount(this.f15072b);
    }

    public ArrayList<a> m() {
        return this.f15072b;
    }

    public final a n(int i2) {
        return (a) ListUtils.getItem(this.f15072b, i2);
    }

    public boolean o() {
        return ListUtils.isEmpty(this.f15072b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public void onBindViewHolder(FansViewHolder fansViewHolder, int i2) {
        a n;
        if (fansViewHolder == null || (n = n(i2)) == null) {
            return;
        }
        fansViewHolder.f15076b.U(n.f61576d, 12, false);
        fansViewHolder.f15077c.setText(n.f61575c);
        fansViewHolder.f15078d.setOnClickListener(this.f15073c);
        fansViewHolder.f15078d.setTag(n);
        fansViewHolder.f15075a.setOnClickListener(this.f15074d);
        fansViewHolder.f15075a.setTag(n);
        c(fansViewHolder);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q */
    public FansViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new FansViewHolder(LayoutInflater.from(this.f15071a).inflate(R.layout.forbidden_fans_item, (ViewGroup) null));
    }

    public void r(ArrayList<a> arrayList) {
        this.f15072b = arrayList;
    }

    public void s(View.OnClickListener onClickListener) {
        this.f15074d = onClickListener;
    }

    public void t(View.OnClickListener onClickListener) {
        this.f15073c = onClickListener;
    }
}
