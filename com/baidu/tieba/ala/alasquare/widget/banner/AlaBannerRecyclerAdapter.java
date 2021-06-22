package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.o0.v.d.h.a.b;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaBannerRecyclerAdapter<T> extends RecyclerView.Adapter<AlaBannerViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public List<T> f14053a;

    /* renamed from: b  reason: collision with root package name */
    public Context f14054b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.v.d.h.a.a f14055c;

    /* renamed from: d  reason: collision with root package name */
    public b f14056d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14057e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f14058f = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AlaBannerRecyclerAdapter.this.f14056d != null) {
                AlaBannerRecyclerAdapter.this.f14056d.a(view.getTag());
            }
        }
    }

    public AlaBannerRecyclerAdapter(Context context, d.a.o0.v.d.h.a.a aVar, boolean z) {
        this.f14054b = context;
        this.f14055c = aVar;
        this.f14057e = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (ListUtils.isEmpty(this.f14053a) || ListUtils.getCount(this.f14053a) == 1) {
            return ListUtils.getCount(this.f14053a);
        }
        return this.f14057e ? ListUtils.getCount(this.f14053a) * 3 : ListUtils.getCount(this.f14053a);
    }

    public int m() {
        return ListUtils.getCount(this.f14053a);
    }

    public final int n(int i2) {
        return ListUtils.getCount(this.f14053a) != 0 ? i2 % ListUtils.getCount(this.f14053a) : i2;
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
        Object item = ListUtils.getItem(this.f14053a, n(i2));
        if (item != null) {
            alaBannerViewHolder.a(i2, item);
            alaBannerViewHolder.itemView.setTag(item);
            alaBannerViewHolder.c(TbadkCoreApplication.getInst().getSkinType());
            alaBannerViewHolder.itemView.setOnClickListener(this.f14058f);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public AlaBannerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        d.a.o0.v.d.h.a.a aVar = this.f14055c;
        if (aVar != null) {
            return aVar.a(viewGroup, i2);
        }
        return null;
    }

    public void q(b bVar) {
        this.f14056d = bVar;
    }

    public void r(d.a.o0.v.d.h.a.a aVar) {
    }

    public void setData(List<T> list) {
        this.f14053a = list;
    }
}
