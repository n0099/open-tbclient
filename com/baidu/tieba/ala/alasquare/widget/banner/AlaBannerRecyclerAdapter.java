package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.j0.t.d.h.a.b;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaBannerRecyclerAdapter<T> extends RecyclerView.Adapter<AlaBannerViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public List<T> f14696a;

    /* renamed from: b  reason: collision with root package name */
    public Context f14697b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.j0.t.d.h.a.a f14698c;

    /* renamed from: d  reason: collision with root package name */
    public b f14699d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14700e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f14701f = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AlaBannerRecyclerAdapter.this.f14699d != null) {
                AlaBannerRecyclerAdapter.this.f14699d.a(view.getTag());
            }
        }
    }

    public AlaBannerRecyclerAdapter(Context context, d.a.j0.t.d.h.a.a aVar, boolean z) {
        this.f14697b = context;
        this.f14698c = aVar;
        this.f14700e = z;
    }

    public int d() {
        return ListUtils.getCount(this.f14696a);
    }

    public final int e(int i2) {
        return ListUtils.getCount(this.f14696a) != 0 ? i2 % ListUtils.getCount(this.f14696a) : i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public void onBindViewHolder(AlaBannerViewHolder alaBannerViewHolder, int i2) {
        if (getItemCount() == 0 || alaBannerViewHolder == 0) {
            return;
        }
        Object item = ListUtils.getItem(this.f14696a, e(i2));
        if (item != null) {
            alaBannerViewHolder.a(i2, item);
            alaBannerViewHolder.itemView.setTag(item);
            alaBannerViewHolder.c(TbadkCoreApplication.getInst().getSkinType());
            alaBannerViewHolder.itemView.setOnClickListener(this.f14701f);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public AlaBannerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        d.a.j0.t.d.h.a.a aVar = this.f14698c;
        if (aVar != null) {
            return aVar.a(viewGroup, i2);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (ListUtils.isEmpty(this.f14696a) || ListUtils.getCount(this.f14696a) == 1) {
            return ListUtils.getCount(this.f14696a);
        }
        return this.f14700e ? ListUtils.getCount(this.f14696a) * 3 : ListUtils.getCount(this.f14696a);
    }

    public void h(b bVar) {
        this.f14699d = bVar;
    }

    public void i(d.a.j0.t.d.h.a.a aVar) {
    }

    public void setData(List<T> list) {
        this.f14696a = list;
    }
}
