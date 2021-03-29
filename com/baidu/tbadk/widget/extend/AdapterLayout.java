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
    public d.b.h0.b1.f.a.b f14120e;

    /* renamed from: f  reason: collision with root package name */
    public DataSetObserver f14121f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14122g;

    /* loaded from: classes3.dex */
    public class a extends g {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f14123e;

        public a(Context context) {
            this.f14123e = context;
        }

        @Override // d.b.h0.m.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            DataSetObserver dataSetObserver;
            if (activity == this.f14123e) {
                AdapterLayout adapterLayout = AdapterLayout.this;
                d.b.h0.b1.f.a.b bVar = adapterLayout.f14120e;
                if (bVar != null && (dataSetObserver = adapterLayout.f14121f) != null) {
                    bVar.e(dataSetObserver);
                    AdapterLayout adapterLayout2 = AdapterLayout.this;
                    adapterLayout2.f14120e = null;
                    adapterLayout2.f14121f = null;
                }
                ((Activity) this.f14123e).getApplication().unregisterActivityLifecycleCallbacks(this);
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
        d.b.h0.b1.f.a.b bVar = this.f14120e;
        if (bVar == null || (dataSetObserver = this.f14121f) == null || this.f14122g) {
            return;
        }
        bVar.d(dataSetObserver);
        this.f14122g = true;
    }

    public void b() {
        if (this.f14120e == null) {
            return;
        }
        removeAllViews();
        int a2 = this.f14120e.a();
        for (int i = 0; i < a2; i++) {
            View b2 = this.f14120e.b(i, this);
            b2.setFocusable(true);
            addView(b2);
        }
    }

    public final void c() {
        DataSetObserver dataSetObserver;
        d.b.h0.b1.f.a.b bVar = this.f14120e;
        if (bVar == null || (dataSetObserver = this.f14121f) == null || !this.f14122g) {
            return;
        }
        this.f14122g = false;
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
            this.f14120e = bVar;
            this.f14121f = new b();
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
        this.f14122g = false;
        if (context instanceof Activity) {
            ((Activity) context).getApplication().registerActivityLifecycleCallbacks(new a(context));
        }
    }
}
