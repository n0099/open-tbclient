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
    public List<T> f13914a;

    /* renamed from: b  reason: collision with root package name */
    public Context f13915b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.v.d.h.a.a f13916c;

    /* renamed from: d  reason: collision with root package name */
    public b f13917d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f13918e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f13919f = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AlaBannerRecyclerAdapter.this.f13917d != null) {
                AlaBannerRecyclerAdapter.this.f13917d.a(view.getTag());
            }
        }
    }

    public AlaBannerRecyclerAdapter(Context context, d.a.n0.v.d.h.a.a aVar, boolean z) {
        this.f13915b = context;
        this.f13916c = aVar;
        this.f13918e = z;
    }

    public int d() {
        return ListUtils.getCount(this.f13914a);
    }

    public final int e(int i2) {
        return ListUtils.getCount(this.f13914a) != 0 ? i2 % ListUtils.getCount(this.f13914a) : i2;
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
        Object item = ListUtils.getItem(this.f13914a, e(i2));
        if (item != null) {
            alaBannerViewHolder.a(i2, item);
            alaBannerViewHolder.itemView.setTag(item);
            alaBannerViewHolder.c(TbadkCoreApplication.getInst().getSkinType());
            alaBannerViewHolder.itemView.setOnClickListener(this.f13919f);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public AlaBannerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        d.a.n0.v.d.h.a.a aVar = this.f13916c;
        if (aVar != null) {
            return aVar.a(viewGroup, i2);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (ListUtils.isEmpty(this.f13914a) || ListUtils.getCount(this.f13914a) == 1) {
            return ListUtils.getCount(this.f13914a);
        }
        return this.f13918e ? ListUtils.getCount(this.f13914a) * 3 : ListUtils.getCount(this.f13914a);
    }

    public void h(b bVar) {
        this.f13917d = bVar;
    }

    public void i(d.a.n0.v.d.h.a.a aVar) {
    }

    public void setData(List<T> list) {
        this.f13914a = list;
    }
}
