package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.R;
import d.b.b.a.j;
import d.b.h0.m.c;
import d.b.h0.m.d;
/* loaded from: classes3.dex */
public class BannerGifView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public GifView f13729e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f13730f;

    /* renamed from: g  reason: collision with root package name */
    public View f13731g;

    /* renamed from: h  reason: collision with root package name */
    public float f13732h;
    public String i;
    public String j;
    public boolean k;
    public c l;
    public d m;
    public final d n;
    public final View.OnClickListener o;

    /* loaded from: classes3.dex */
    public class a implements d {
        public a() {
        }

        @Override // d.b.h0.m.d
        public boolean b(View view) {
            if (BannerGifView.this.m == null || !BannerGifView.this.m.b(view)) {
                BannerGifView.this.e();
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == BannerGifView.this.f13730f) {
                BannerGifView.this.setCloseVisibility(false);
            }
        }
    }

    public BannerGifView(Context context) {
        super(context);
        this.f13732h = 5.744f;
        this.k = false;
        this.n = new a();
        this.o = new b();
        f();
    }

    public final void d(int i) {
        int i2 = 0;
        boolean z = true;
        if (i != 1 && i != 4) {
            z = false;
        }
        this.f13731g.setVisibility((this.k && z) ? 8 : 8);
    }

    public final void e() {
        try {
            if (TextUtils.isEmpty(this.j)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) j.a(getContext()), new String[]{this.j});
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void f() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.gif_banner_view, this);
        this.f13730f = (ImageView) inflate.findViewById(R.id.btn_close);
        this.f13731g = inflate.findViewById(R.id.image_mask);
        GifView gifView = (GifView) inflate.findViewById(R.id.image_gif);
        this.f13729e = gifView;
        gifView.setShowStaticDrawable(false);
        this.f13729e.setSupportNoImage(false);
        this.f13729e.setAutoPlay(true);
        this.f13730f.setOnClickListener(this.o);
        this.f13729e.setOnInterceptClickListener(this.n);
        g(TbadkCoreApplication.getInst().getSkinType());
    }

    public void g(int i) {
        SkinManager.setBackgroundColor(this.f13731g, R.color.black_alpha30, i);
        d(i);
    }

    public GifView getGifView() {
        return this.f13729e;
    }

    public String getUrl() {
        return this.i;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        View.MeasureSpec.getMode(i);
        View.MeasureSpec.getMode(i2);
        int size = (View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        View.MeasureSpec.getSize(i2);
        getPaddingBottom();
        getPaddingTop();
        float f2 = this.f13732h;
        if (f2 > 0.0f) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) ((size / f2) + 0.5f), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.l != null) {
            this.l.a(this, i == 0, this.i);
        }
    }

    public void setCloseVisibility(boolean z) {
        this.f13730f.setVisibility(z ? 0 : 8);
    }

    public void setDefaultResid(int i) {
        SkinManager.setImageResource(this.f13729e, i);
    }

    public void setErrorResid(int i) {
        this.f13729e.setErrorResid(i);
    }

    public void setIWindowChangedListener(c cVar) {
        this.l = cVar;
    }

    public void setNeedNightMask(boolean z) {
        this.k = z;
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setOnClickEventListener(d dVar) {
        this.m = dVar;
    }

    public void setRatio(float f2) {
        this.f13732h = f2;
        invalidate();
    }
}
