package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.i0.t.d.h.a.b;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaBannerRecyclerAdapter<T> extends RecyclerView.Adapter<AlaBannerViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public List<T> f14613a;

    /* renamed from: b  reason: collision with root package name */
    public Context f14614b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.t.d.h.a.a f14615c;

    /* renamed from: d  reason: collision with root package name */
    public b f14616d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14617e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f14618f = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AlaBannerRecyclerAdapter.this.f14616d != null) {
                AlaBannerRecyclerAdapter.this.f14616d.a(view.getTag());
            }
        }
    }

    public AlaBannerRecyclerAdapter(Context context, d.b.i0.t.d.h.a.a aVar, boolean z) {
        this.f14614b = context;
        this.f14615c = aVar;
        this.f14617e = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (ListUtils.isEmpty(this.f14613a) || ListUtils.getCount(this.f14613a) == 1) {
            return ListUtils.getCount(this.f14613a);
        }
        return this.f14617e ? ListUtils.getCount(this.f14613a) * 3 : ListUtils.getCount(this.f14613a);
    }

    public int m() {
        return ListUtils.getCount(this.f14613a);
    }

    public final int n(int i) {
        return ListUtils.getCount(this.f14613a) != 0 ? i % ListUtils.getCount(this.f14613a) : i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(AlaBannerViewHolder alaBannerViewHolder, int i) {
        if (getItemCount() == 0 || alaBannerViewHolder == 0) {
            return;
        }
        Object item = ListUtils.getItem(this.f14613a, n(i));
        if (item != null) {
            alaBannerViewHolder.a(i, item);
            alaBannerViewHolder.itemView.setTag(item);
            alaBannerViewHolder.c(TbadkCoreApplication.getInst().getSkinType());
            alaBannerViewHolder.itemView.setOnClickListener(this.f14618f);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public AlaBannerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        d.b.i0.t.d.h.a.a aVar = this.f14615c;
        if (aVar != null) {
            return aVar.a(viewGroup, i);
        }
        return null;
    }

    public void q(b bVar) {
        this.f14616d = bVar;
    }

    public void r(d.b.i0.t.d.h.a.a aVar) {
    }

    public void setData(List<T> list) {
        this.f14613a = list;
    }
}
