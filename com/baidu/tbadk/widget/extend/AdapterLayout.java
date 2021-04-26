package com.baidu.tbadk.widget.extend;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import d.a.i0.m.g;
/* loaded from: classes3.dex */
public abstract class AdapterLayout extends ViewGroup {

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.b1.f.a.b f13819e;

    /* renamed from: f  reason: collision with root package name */
    public DataSetObserver f13820f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13821g;

    /* loaded from: classes3.dex */
    public class a extends g {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f13822e;

        public a(Context context) {
            this.f13822e = context;
        }

        @Override // d.a.i0.m.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            DataSetObserver dataSetObserver;
            if (activity == this.f13822e) {
                AdapterLayout adapterLayout = AdapterLayout.this;
                d.a.i0.b1.f.a.b bVar = adapterLayout.f13819e;
                if (bVar != null && (dataSetObserver = adapterLayout.f13820f) != null) {
                    bVar.e(dataSetObserver);
                    AdapterLayout adapterLayout2 = AdapterLayout.this;
                    adapterLayout2.f13819e = null;
                    adapterLayout2.f13820f = null;
                }
                ((Activity) this.f13822e).getApplication().unregisterActivityLifecycleCallbacks(this);
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
        d.a.i0.b1.f.a.b bVar = this.f13819e;
        if (bVar == null || (dataSetObserver = this.f13820f) == null || this.f13821g) {
            return;
        }
        bVar.d(dataSetObserver);
        this.f13821g = true;
    }

    public void b() {
        if (this.f13819e == null) {
            return;
        }
        removeAllViews();
        int a2 = this.f13819e.a();
        for (int i2 = 0; i2 < a2; i2++) {
            View b2 = this.f13819e.b(i2, this);
            b2.setFocusable(true);
            addView(b2);
        }
    }

    public final void c() {
        DataSetObserver dataSetObserver;
        d.a.i0.b1.f.a.b bVar = this.f13819e;
        if (bVar == null || (dataSetObserver = this.f13820f) == null || !this.f13821g) {
            return;
        }
        this.f13821g = false;
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

    public void setAdapter(d.a.i0.b1.f.a.b bVar) {
        c();
        if (bVar != null) {
            this.f13819e = bVar;
            this.f13820f = new b();
            a();
            b();
            return;
        }
        throw new NullPointerException("FlowBaseAdapter is null");
    }

    public AdapterLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdapterLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13821g = false;
        if (context instanceof Activity) {
            ((Activity) context).getApplication().registerActivityLifecycleCallbacks(new a(context));
        }
    }
}
