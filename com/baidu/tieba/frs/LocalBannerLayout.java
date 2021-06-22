package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.flow.CoverFlowLocalView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.n0.r.w.b.c;
import d.a.n0.r.w.b.d;
import d.a.n0.r.w.b.e;
import d.a.o0.r0.h;
import java.util.List;
/* loaded from: classes4.dex */
public class LocalBannerLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public CoverFlowLocalView<h> f15312e;

    /* renamed from: f  reason: collision with root package name */
    public d<h> f15313f;

    /* renamed from: g  reason: collision with root package name */
    public List<h> f15314g;

    /* renamed from: h  reason: collision with root package name */
    public d<h> f15315h;

    /* loaded from: classes4.dex */
    public class a extends d.a.n0.r.w.b.b {
        public a() {
        }

        @Override // d.a.n0.r.w.b.b, d.a.n0.r.w.a
        public c a() {
            c cVar = new c();
            cVar.c(R.drawable.icon_mask_goods_select8);
            cVar.g(R.drawable.icon_mask_goods_unselect8);
            cVar.d(81);
            cVar.e(R.dimen.tbds36);
            cVar.h(R.dimen.tbds20);
            return cVar;
        }

        @Override // d.a.n0.r.w.b.b, d.a.n0.r.w.a
        public e c() {
            e eVar = new e();
            eVar.a(l.g(LocalBannerLayout.this.getContext(), R.dimen.tbds690));
            return eVar;
        }

        @Override // d.a.n0.r.w.b.b, d.a.n0.r.w.a
        public TbImageView d(Context context) {
            TbImageView tbImageView = new TbImageView(context);
            tbImageView.setPlaceHolder(2);
            tbImageView.setLongIconSupport(false);
            tbImageView.setGifIconSupport(false);
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return tbImageView;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d<h> {
        public b() {
        }

        @Override // d.a.n0.r.w.b.d
        public void b(int i2, String str) {
            if (i2 < 0 || LocalBannerLayout.this.f15314g == null || i2 > LocalBannerLayout.this.f15314g.size() + 1 || LocalBannerLayout.this.f15313f == null) {
                return;
            }
            LocalBannerLayout.this.f15313f.b(i2, str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.r.w.b.d
        /* renamed from: c */
        public void a(int i2, h hVar) {
            if (i2 < 0 || LocalBannerLayout.this.f15314g == null || i2 > LocalBannerLayout.this.f15314g.size() + 1 || LocalBannerLayout.this.f15313f == null) {
                return;
            }
            LocalBannerLayout.this.f15313f.a(i2, hVar);
        }
    }

    public LocalBannerLayout(Context context) {
        this(context, null);
    }

    public final void c() {
        this.f15312e = new CoverFlowLocalView<>(getContext());
        a aVar = new a();
        this.f15312e.setIndicatorNoOffet(false);
        this.f15312e.setDisableParentEvent(false);
        this.f15312e.setCoverFlowFactory(aVar);
        this.f15312e.setIndicatorVisible(0);
        this.f15312e.setIsAutoPlayDragging(false);
        this.f15312e.setAutoPlay(false);
        this.f15312e.setCallback(this.f15315h);
        addView(this.f15312e);
    }

    public void setData(List<h> list) {
        this.f15314g = list;
        this.f15312e.setData(list);
    }

    public void setOnCoverViewCallback(d<h> dVar) {
        this.f15313f = dVar;
    }

    public LocalBannerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LocalBannerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f15315h = new b();
        c();
    }
}
