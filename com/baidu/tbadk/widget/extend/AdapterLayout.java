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
    protected b fKP;
    private boolean fKQ;
    protected DataSetObserver mObserver;

    public AdapterLayout(Context context) {
        this(context, null);
    }

    public AdapterLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdapterLayout(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fKQ = false;
        if (context instanceof Activity) {
            ((Activity) context).getApplication().registerActivityLifecycleCallbacks(new g() { // from class: com.baidu.tbadk.widget.extend.AdapterLayout.1
                @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    if (activity == context) {
                        if (AdapterLayout.this.fKP != null && AdapterLayout.this.mObserver != null) {
                            AdapterLayout.this.fKP.unregisterDataSetObserver(AdapterLayout.this.mObserver);
                            AdapterLayout.this.fKP = null;
                            AdapterLayout.this.mObserver = null;
                        }
                        ((Activity) context).getApplication().unregisterActivityLifecycleCallbacks(this);
                    }
                }
            });
        }
    }

    public void setAdapter(b bVar) {
        bHQ();
        if (bVar == null) {
            throw new NullPointerException("FlowBaseAdapter is null");
        }
        this.fKP = bVar;
        this.mObserver = new DataSetObserver() { // from class: com.baidu.tbadk.widget.extend.AdapterLayout.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                AdapterLayout.this.bHS();
            }
        };
        bHR();
        bHS();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        bHQ();
        super.onDetachedFromWindow();
    }

    private void bHQ() {
        if (this.fKP != null && this.mObserver != null && this.fKQ) {
            this.fKQ = false;
            this.fKP.unregisterDataSetObserver(this.mObserver);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bHR();
    }

    private void bHR() {
        if (this.fKP != null && this.mObserver != null && !this.fKQ) {
            this.fKP.registerDataSetObserver(this.mObserver);
            this.fKQ = true;
        }
    }

    protected void bHS() {
        if (this.fKP != null) {
            removeAllViews();
            int count = this.fKP.getCount();
            for (int i = 0; i < count; i++) {
                View view = this.fKP.getView(i, this);
                view.setFocusable(true);
                addView(view);
            }
        }
    }
}
