package com.baidu.tbadk.widget.extend;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.h.g;
import com.baidu.tbadk.widget.extend.a.b;
/* loaded from: classes2.dex */
public abstract class AdapterLayout extends ViewGroup {
    protected b fab;
    private boolean fac;
    protected DataSetObserver mObserver;

    public AdapterLayout(Context context) {
        this(context, null);
    }

    public AdapterLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdapterLayout(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fac = false;
        if (context instanceof Activity) {
            ((Activity) context).getApplication().registerActivityLifecycleCallbacks(new g() { // from class: com.baidu.tbadk.widget.extend.AdapterLayout.1
                @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    if (activity == context) {
                        if (AdapterLayout.this.fab != null && AdapterLayout.this.mObserver != null) {
                            AdapterLayout.this.fab.unregisterDataSetObserver(AdapterLayout.this.mObserver);
                            AdapterLayout.this.fab = null;
                            AdapterLayout.this.mObserver = null;
                        }
                        ((Activity) context).getApplication().unregisterActivityLifecycleCallbacks(this);
                    }
                }
            });
        }
    }

    public void setAdapter(b bVar) {
        bwK();
        if (bVar == null) {
            throw new NullPointerException("FlowBaseAdapter is null");
        }
        this.fab = bVar;
        this.mObserver = new DataSetObserver() { // from class: com.baidu.tbadk.widget.extend.AdapterLayout.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                AdapterLayout.this.bwM();
            }
        };
        bwL();
        bwM();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        bwK();
        super.onDetachedFromWindow();
    }

    private void bwK() {
        if (this.fab != null && this.mObserver != null && this.fac) {
            this.fac = false;
            this.fab.unregisterDataSetObserver(this.mObserver);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bwL();
    }

    private void bwL() {
        if (this.fab != null && this.mObserver != null && !this.fac) {
            this.fab.registerDataSetObserver(this.mObserver);
            this.fac = true;
        }
    }

    protected void bwM() {
        if (this.fab != null) {
            removeAllViews();
            int count = this.fab.getCount();
            for (int i = 0; i < count; i++) {
                View view = this.fab.getView(i, this);
                view.setFocusable(true);
                addView(view);
            }
        }
    }
}
