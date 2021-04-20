package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.flow.CoverFlowLocalView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.h0.r.w.b.c;
import d.b.h0.r.w.b.d;
import d.b.h0.r.w.b.e;
import d.b.i0.q0.h;
import java.util.List;
/* loaded from: classes4.dex */
public class LocalBannerLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public CoverFlowLocalView<h> f15765e;

    /* renamed from: f  reason: collision with root package name */
    public d<h> f15766f;

    /* renamed from: g  reason: collision with root package name */
    public List<h> f15767g;

    /* renamed from: h  reason: collision with root package name */
    public d<h> f15768h;

    /* loaded from: classes4.dex */
    public class a extends d.b.h0.r.w.b.b {
        public a() {
        }

        @Override // d.b.h0.r.w.b.b, d.b.h0.r.w.a
        public c a() {
            c cVar = new c();
            cVar.c(R.drawable.icon_mask_goods_select8);
            cVar.g(R.drawable.icon_mask_goods_unselect8);
            cVar.d(81);
            cVar.e(R.dimen.tbds36);
            cVar.h(R.dimen.tbds20);
            return cVar;
        }

        @Override // d.b.h0.r.w.b.b, d.b.h0.r.w.a
        public TbImageView c(Context context) {
            TbImageView tbImageView = new TbImageView(context);
            tbImageView.setPlaceHolder(2);
            tbImageView.setLongIconSupport(false);
            tbImageView.setGifIconSupport(false);
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return tbImageView;
        }

        @Override // d.b.h0.r.w.b.b, d.b.h0.r.w.a
        public e d() {
            e eVar = new e();
            eVar.a(l.g(LocalBannerLayout.this.getContext(), R.dimen.tbds690));
            return eVar;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d<h> {
        public b() {
        }

        @Override // d.b.h0.r.w.b.d
        public void b(int i, String str) {
            if (i < 0 || LocalBannerLayout.this.f15767g == null || i > LocalBannerLayout.this.f15767g.size() + 1 || LocalBannerLayout.this.f15766f == null) {
                return;
            }
            LocalBannerLayout.this.f15766f.b(i, str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.r.w.b.d
        /* renamed from: c */
        public void a(int i, h hVar) {
            if (i < 0 || LocalBannerLayout.this.f15767g == null || i > LocalBannerLayout.this.f15767g.size() + 1 || LocalBannerLayout.this.f15766f == null) {
                return;
            }
            LocalBannerLayout.this.f15766f.a(i, hVar);
        }
    }

    public LocalBannerLayout(Context context) {
        this(context, null);
    }

    public final void c() {
        this.f15765e = new CoverFlowLocalView<>(getContext());
        a aVar = new a();
        this.f15765e.setIndicatorNoOffet(false);
        this.f15765e.setDisableParentEvent(false);
        this.f15765e.setCoverFlowFactory(aVar);
        this.f15765e.setIndicatorVisible(0);
        this.f15765e.setIsAutoPlayDragging(false);
        this.f15765e.setAutoPlay(false);
        this.f15765e.setCallback(this.f15768h);
        addView(this.f15765e);
    }

    public void setData(List<h> list) {
        this.f15767g = list;
        this.f15765e.setData(list);
    }

    public void setOnCoverViewCallback(d<h> dVar) {
        this.f15766f = dVar;
    }

    public LocalBannerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LocalBannerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15768h = new b();
        c();
    }
}
