package com.baidu.tbadk.widget.extend;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.h.g;
import com.baidu.tbadk.widget.extend.a.b;
/* loaded from: classes.dex */
public abstract class AdapterLayout extends ViewGroup {
    protected b fUv;
    private boolean fUw;
    protected DataSetObserver mObserver;

    public AdapterLayout(Context context) {
        this(context, null);
    }

    public AdapterLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdapterLayout(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fUw = false;
        if (context instanceof Activity) {
            ((Activity) context).getApplication().registerActivityLifecycleCallbacks(new g() { // from class: com.baidu.tbadk.widget.extend.AdapterLayout.1
                @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    if (activity == context) {
                        if (AdapterLayout.this.fUv != null && AdapterLayout.this.mObserver != null) {
                            AdapterLayout.this.fUv.unregisterDataSetObserver(AdapterLayout.this.mObserver);
                            AdapterLayout.this.fUv = null;
                            AdapterLayout.this.mObserver = null;
                        }
                        ((Activity) context).getApplication().unregisterActivityLifecycleCallbacks(this);
                    }
                }
            });
        }
    }

    public void setAdapter(b bVar) {
        bKk();
        if (bVar == null) {
            throw new NullPointerException("FlowBaseAdapter is null");
        }
        this.fUv = bVar;
        this.mObserver = new DataSetObserver() { // from class: com.baidu.tbadk.widget.extend.AdapterLayout.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                AdapterLayout.this.bKm();
            }
        };
        bKl();
        bKm();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        bKk();
        super.onDetachedFromWindow();
    }

    private void bKk() {
        if (this.fUv != null && this.mObserver != null && this.fUw) {
            this.fUw = false;
            this.fUv.unregisterDataSetObserver(this.mObserver);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bKl();
    }

    private void bKl() {
        if (this.fUv != null && this.mObserver != null && !this.fUw) {
            this.fUv.registerDataSetObserver(this.mObserver);
            this.fUw = true;
        }
    }

    protected void bKm() {
        if (this.fUv != null) {
            removeAllViews();
            int count = this.fUv.getCount();
            for (int i = 0; i < count; i++) {
                View view = this.fUv.getView(i, this);
                view.setFocusable(true);
                addView(view);
            }
        }
    }
}
