package com.baidu.tbadk.widget.extend;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import d.b.h0.m.g;
/* loaded from: classes3.dex */
public abstract class AdapterLayout extends ViewGroup {

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.b1.f.a.b f14119e;

    /* renamed from: f  reason: collision with root package name */
    public DataSetObserver f14120f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14121g;

    /* loaded from: classes3.dex */
    public class a extends g {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f14122e;

        public a(Context context) {
            this.f14122e = context;
        }

        @Override // d.b.h0.m.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            DataSetObserver dataSetObserver;
            if (activity == this.f14122e) {
                AdapterLayout adapterLayout = AdapterLayout.this;
                d.b.h0.b1.f.a.b bVar = adapterLayout.f14119e;
                if (bVar != null && (dataSetObserver = adapterLayout.f14120f) != null) {
                    bVar.e(dataSetObserver);
                    AdapterLayout adapterLayout2 = AdapterLayout.this;
                    adapterLayout2.f14119e = null;
                    adapterLayout2.f14120f = null;
                }
                ((Activity) this.f14122e).getApplication().unregisterActivityLifecycleCallbacks(this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends DataSetObserver {
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            AdapterLayout.this.b();
        }
    }

    public AdapterLayout(Context context) {
        this(context, null);
    }

    public final void a() {
        DataSetObserver dataSetObserver;
        d.b.h0.b1.f.a.b bVar = this.f14119e;
        if (bVar == null || (dataSetObserver = this.f14120f) == null || this.f14121g) {
            return;
        }
        bVar.d(dataSetObserver);
        this.f14121g = true;
    }

    public void b() {
        if (this.f14119e == null) {
            return;
        }
        removeAllViews();
        int a2 = this.f14119e.a();
        for (int i = 0; i < a2; i++) {
            View b2 = this.f14119e.b(i, this);
            b2.setFocusable(true);
            addView(b2);
        }
    }

    public final void c() {
        DataSetObserver dataSetObserver;
        d.b.h0.b1.f.a.b bVar = this.f14119e;
        if (bVar == null || (dataSetObserver = this.f14120f) == null || !this.f14121g) {
            return;
        }
        this.f14121g = false;
        bVar.e(dataSetObserver);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        c();
        super.onDetachedFromWindow();
    }

    public void setAdapter(d.b.h0.b1.f.a.b bVar) {
        c();
        if (bVar != null) {
            this.f14119e = bVar;
            this.f14120f = new b();
            a();
            b();
            return;
        }
        throw new NullPointerException("FlowBaseAdapter is null");
    }

    public AdapterLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdapterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14121g = false;
        if (context instanceof Activity) {
            ((Activity) context).getApplication().registerActivityLifecycleCallbacks(new a(context));
        }
    }
}
