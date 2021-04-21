package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.j0.t.d.h.a.b;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaBannerRecyclerAdapter<T> extends RecyclerView.Adapter<AlaBannerViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public List<T> f14621a;

    /* renamed from: b  reason: collision with root package name */
    public Context f14622b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.j0.t.d.h.a.a f14623c;

    /* renamed from: d  reason: collision with root package name */
    public b f14624d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14625e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f14626f = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AlaBannerRecyclerAdapter.this.f14624d != null) {
                AlaBannerRecyclerAdapter.this.f14624d.a(view.getTag());
            }
        }
    }

    public AlaBannerRecyclerAdapter(Context context, d.b.j0.t.d.h.a.a aVar, boolean z) {
        this.f14622b = context;
        this.f14623c = aVar;
        this.f14625e = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (ListUtils.isEmpty(this.f14621a) || ListUtils.getCount(this.f14621a) == 1) {
            return ListUtils.getCount(this.f14621a);
        }
        return this.f14625e ? ListUtils.getCount(this.f14621a) * 3 : ListUtils.getCount(this.f14621a);
    }

    public int m() {
        return ListUtils.getCount(this.f14621a);
    }

    public final int n(int i) {
        return ListUtils.getCount(this.f14621a) != 0 ? i % ListUtils.getCount(this.f14621a) : i;
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
        Object item = ListUtils.getItem(this.f14621a, n(i));
        if (item != null) {
            alaBannerViewHolder.a(i, item);
            alaBannerViewHolder.itemView.setTag(item);
            alaBannerViewHolder.c(TbadkCoreApplication.getInst().getSkinType());
            alaBannerViewHolder.itemView.setOnClickListener(this.f14626f);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public AlaBannerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        d.b.j0.t.d.h.a.a aVar = this.f14623c;
        if (aVar != null) {
            return aVar.a(viewGroup, i);
        }
        return null;
    }

    public void q(b bVar) {
        this.f14624d = bVar;
    }

    public void r(d.b.j0.t.d.h.a.a aVar) {
    }

    public void setData(List<T> list) {
        this.f14621a = list;
    }
}
