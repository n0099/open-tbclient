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
import d.a.c.a.j;
import d.a.m0.m.c;
import d.a.m0.m.d;
/* loaded from: classes3.dex */
public class BannerGifView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public GifView f12678e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f12679f;

    /* renamed from: g  reason: collision with root package name */
    public View f12680g;

    /* renamed from: h  reason: collision with root package name */
    public float f12681h;

    /* renamed from: i  reason: collision with root package name */
    public String f12682i;
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

        @Override // d.a.m0.m.d
        public boolean a(View view) {
            if (BannerGifView.this.m == null || !BannerGifView.this.m.a(view)) {
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
            if (view == BannerGifView.this.f12679f) {
                BannerGifView.this.setCloseVisibility(false);
            }
        }
    }

    public BannerGifView(Context context) {
        super(context);
        this.f12681h = 5.744f;
        this.k = false;
        this.n = new a();
        this.o = new b();
        f();
    }

    public final void d(int i2) {
        int i3 = 0;
        boolean z = true;
        if (i2 != 1 && i2 != 4) {
            z = false;
        }
        this.f12680g.setVisibility((this.k && z) ? 8 : 8);
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
        this.f12679f = (ImageView) inflate.findViewById(R.id.btn_close);
        this.f12680g = inflate.findViewById(R.id.image_mask);
        GifView gifView = (GifView) inflate.findViewById(R.id.image_gif);
        this.f12678e = gifView;
        gifView.setShowStaticDrawable(false);
        this.f12678e.setSupportNoImage(false);
        this.f12678e.setAutoPlay(true);
        this.f12679f.setOnClickListener(this.o);
        this.f12678e.setOnInterceptClickListener(this.n);
        g(TbadkCoreApplication.getInst().getSkinType());
    }

    public void g(int i2) {
        SkinManager.setBackgroundColor(this.f12680g, R.color.black_alpha30, i2);
        d(i2);
    }

    public GifView getGifView() {
        return this.f12678e;
    }

    public String getUrl() {
        return this.f12682i;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getMode(i3);
        int size = (View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight();
        View.MeasureSpec.getSize(i3);
        getPaddingBottom();
        getPaddingTop();
        float f2 = this.f12681h;
        if (f2 > 0.0f) {
            i3 = View.MeasureSpec.makeMeasureSpec((int) ((size / f2) + 0.5f), 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (this.l != null) {
            this.l.a(this, i2 == 0, this.f12682i);
        }
    }

    public void setCloseVisibility(boolean z) {
        this.f12679f.setVisibility(z ? 0 : 8);
    }

    public void setDefaultResid(int i2) {
        SkinManager.setImageResource(this.f12678e, i2);
    }

    public void setErrorResid(int i2) {
        this.f12678e.setErrorResid(i2);
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
        this.f12681h = f2;
        invalidate();
    }
}
