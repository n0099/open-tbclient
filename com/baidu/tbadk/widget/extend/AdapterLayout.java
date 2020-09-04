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
    protected b faf;
    private boolean fag;
    protected DataSetObserver mObserver;

    public AdapterLayout(Context context) {
        this(context, null);
    }

    public AdapterLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdapterLayout(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fag = false;
        if (context instanceof Activity) {
            ((Activity) context).getApplication().registerActivityLifecycleCallbacks(new g() { // from class: com.baidu.tbadk.widget.extend.AdapterLayout.1
                @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    if (activity == context) {
                        if (AdapterLayout.this.faf != null && AdapterLayout.this.mObserver != null) {
                            AdapterLayout.this.faf.unregisterDataSetObserver(AdapterLayout.this.mObserver);
                            AdapterLayout.this.faf = null;
                            AdapterLayout.this.mObserver = null;
                        }
                        ((Activity) context).getApplication().unregisterActivityLifecycleCallbacks(this);
                    }
                }
            });
        }
    }

    public void setAdapter(b bVar) {
        bwL();
        if (bVar == null) {
            throw new NullPointerException("FlowBaseAdapter is null");
        }
        this.faf = bVar;
        this.mObserver = new DataSetObserver() { // from class: com.baidu.tbadk.widget.extend.AdapterLayout.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                AdapterLayout.this.bwN();
            }
        };
        bwM();
        bwN();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        bwL();
        super.onDetachedFromWindow();
    }

    private void bwL() {
        if (this.faf != null && this.mObserver != null && this.fag) {
            this.fag = false;
            this.faf.unregisterDataSetObserver(this.mObserver);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bwM();
    }

    private void bwM() {
        if (this.faf != null && this.mObserver != null && !this.fag) {
            this.faf.registerDataSetObserver(this.mObserver);
            this.fag = true;
        }
    }

    protected void bwN() {
        if (this.faf != null) {
            removeAllViews();
            int count = this.faf.getCount();
            for (int i = 0; i < count; i++) {
                View view = this.faf.getView(i, this);
                view.setFocusable(true);
                addView(view);
            }
        }
    }
}
