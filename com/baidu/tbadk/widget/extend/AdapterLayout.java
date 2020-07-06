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
    protected b eIZ;
    private boolean eJa;
    protected DataSetObserver mObserver;

    public AdapterLayout(Context context) {
        this(context, null);
    }

    public AdapterLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdapterLayout(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eJa = false;
        if (context instanceof Activity) {
            ((Activity) context).getApplication().registerActivityLifecycleCallbacks(new g() { // from class: com.baidu.tbadk.widget.extend.AdapterLayout.1
                @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    if (activity == context) {
                        if (AdapterLayout.this.eIZ != null && AdapterLayout.this.mObserver != null) {
                            AdapterLayout.this.eIZ.unregisterDataSetObserver(AdapterLayout.this.mObserver);
                            AdapterLayout.this.eIZ = null;
                            AdapterLayout.this.mObserver = null;
                        }
                        ((Activity) context).getApplication().unregisterActivityLifecycleCallbacks(this);
                    }
                }
            });
        }
    }

    public void setAdapter(b bVar) {
        bkd();
        if (bVar == null) {
            throw new NullPointerException("FlowBaseAdapter is null");
        }
        this.eIZ = bVar;
        this.mObserver = new DataSetObserver() { // from class: com.baidu.tbadk.widget.extend.AdapterLayout.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                AdapterLayout.this.bkf();
            }
        };
        bke();
        bkf();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        bkd();
        super.onDetachedFromWindow();
    }

    private void bkd() {
        if (this.eIZ != null && this.mObserver != null && this.eJa) {
            this.eJa = false;
            this.eIZ.unregisterDataSetObserver(this.mObserver);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bke();
    }

    private void bke() {
        if (this.eIZ != null && this.mObserver != null && !this.eJa) {
            this.eIZ.registerDataSetObserver(this.mObserver);
            this.eJa = true;
        }
    }

    protected void bkf() {
        if (this.eIZ != null) {
            removeAllViews();
            int count = this.eIZ.getCount();
            for (int i = 0; i < count; i++) {
                View view = this.eIZ.getView(i, this);
                view.setFocusable(true);
                addView(view);
            }
        }
    }
}
