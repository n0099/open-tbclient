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
    protected b fSb;
    private boolean fSc;
    protected DataSetObserver mObserver;

    public AdapterLayout(Context context) {
        this(context, null);
    }

    public AdapterLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdapterLayout(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fSc = false;
        if (context instanceof Activity) {
            ((Activity) context).getApplication().registerActivityLifecycleCallbacks(new g() { // from class: com.baidu.tbadk.widget.extend.AdapterLayout.1
                @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    if (activity == context) {
                        if (AdapterLayout.this.fSb != null && AdapterLayout.this.mObserver != null) {
                            AdapterLayout.this.fSb.unregisterDataSetObserver(AdapterLayout.this.mObserver);
                            AdapterLayout.this.fSb = null;
                            AdapterLayout.this.mObserver = null;
                        }
                        ((Activity) context).getApplication().unregisterActivityLifecycleCallbacks(this);
                    }
                }
            });
        }
    }

    public void setAdapter(b bVar) {
        bGN();
        if (bVar == null) {
            throw new NullPointerException("FlowBaseAdapter is null");
        }
        this.fSb = bVar;
        this.mObserver = new DataSetObserver() { // from class: com.baidu.tbadk.widget.extend.AdapterLayout.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                AdapterLayout.this.bGP();
            }
        };
        bGO();
        bGP();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        bGN();
        super.onDetachedFromWindow();
    }

    private void bGN() {
        if (this.fSb != null && this.mObserver != null && this.fSc) {
            this.fSc = false;
            this.fSb.unregisterDataSetObserver(this.mObserver);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bGO();
    }

    private void bGO() {
        if (this.fSb != null && this.mObserver != null && !this.fSc) {
            this.fSb.registerDataSetObserver(this.mObserver);
            this.fSc = true;
        }
    }

    protected void bGP() {
        if (this.fSb != null) {
            removeAllViews();
            int count = this.fSb.getCount();
            for (int i = 0; i < count; i++) {
                View view = this.fSb.getView(i, this);
                view.setFocusable(true);
                addView(view);
            }
        }
    }
}
