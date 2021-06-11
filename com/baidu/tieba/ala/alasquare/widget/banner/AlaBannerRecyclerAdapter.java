package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.n0.v.d.h.a.b;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaBannerRecyclerAdapter<T> extends RecyclerView.Adapter<AlaBannerViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public List<T> f13971a;

    /* renamed from: b  reason: collision with root package name */
    public Context f13972b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.v.d.h.a.a f13973c;

    /* renamed from: d  reason: collision with root package name */
    public b f13974d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f13975e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f13976f = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AlaBannerRecyclerAdapter.this.f13974d != null) {
                AlaBannerRecyclerAdapter.this.f13974d.a(view.getTag());
            }
        }
    }

    public AlaBannerRecyclerAdapter(Context context, d.a.n0.v.d.h.a.a aVar, boolean z) {
        this.f13972b = context;
        this.f13973c = aVar;
        this.f13975e = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (ListUtils.isEmpty(this.f13971a) || ListUtils.getCount(this.f13971a) == 1) {
            return ListUtils.getCount(this.f13971a);
        }
        return this.f13975e ? ListUtils.getCount(this.f13971a) * 3 : ListUtils.getCount(this.f13971a);
    }

    public int m() {
        return ListUtils.getCount(this.f13971a);
    }

    public final int n(int i2) {
        return ListUtils.getCount(this.f13971a) != 0 ? i2 % ListUtils.getCount(this.f13971a) : i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(AlaBannerViewHolder alaBannerViewHolder, int i2) {
        if (getItemCount() == 0 || alaBannerViewHolder == 0) {
            return;
        }
        Object item = ListUtils.getItem(this.f13971a, n(i2));
        if (item != null) {
            alaBannerViewHolder.a(i2, item);
            alaBannerViewHolder.itemView.setTag(item);
            alaBannerViewHolder.c(TbadkCoreApplication.getInst().getSkinType());
            alaBannerViewHolder.itemView.setOnClickListener(this.f13976f);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public AlaBannerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        d.a.n0.v.d.h.a.a aVar = this.f13973c;
        if (aVar != null) {
            return aVar.a(viewGroup, i2);
        }
        return null;
    }

    public void q(b bVar) {
        this.f13974d = bVar;
    }

    public void r(d.a.n0.v.d.h.a.a aVar) {
    }

    public void setData(List<T> list) {
        this.f13971a = list;
    }
}
