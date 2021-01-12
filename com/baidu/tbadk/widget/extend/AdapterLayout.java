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
    protected b fPO;
    private boolean fPP;
    protected DataSetObserver mObserver;

    public AdapterLayout(Context context) {
        this(context, null);
    }

    public AdapterLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdapterLayout(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fPP = false;
        if (context instanceof Activity) {
            ((Activity) context).getApplication().registerActivityLifecycleCallbacks(new g() { // from class: com.baidu.tbadk.widget.extend.AdapterLayout.1
                @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    if (activity == context) {
                        if (AdapterLayout.this.fPO != null && AdapterLayout.this.mObserver != null) {
                            AdapterLayout.this.fPO.unregisterDataSetObserver(AdapterLayout.this.mObserver);
                            AdapterLayout.this.fPO = null;
                            AdapterLayout.this.mObserver = null;
                        }
                        ((Activity) context).getApplication().unregisterActivityLifecycleCallbacks(this);
                    }
                }
            });
        }
    }

    public void setAdapter(b bVar) {
        bGt();
        if (bVar == null) {
            throw new NullPointerException("FlowBaseAdapter is null");
        }
        this.fPO = bVar;
        this.mObserver = new DataSetObserver() { // from class: com.baidu.tbadk.widget.extend.AdapterLayout.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                AdapterLayout.this.bGv();
            }
        };
        bGu();
        bGv();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        bGt();
        super.onDetachedFromWindow();
    }

    private void bGt() {
        if (this.fPO != null && this.mObserver != null && this.fPP) {
            this.fPP = false;
            this.fPO.unregisterDataSetObserver(this.mObserver);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bGu();
    }

    private void bGu() {
        if (this.fPO != null && this.mObserver != null && !this.fPP) {
            this.fPO.registerDataSetObserver(this.mObserver);
            this.fPP = true;
        }
    }

    protected void bGv() {
        if (this.fPO != null) {
            removeAllViews();
            int count = this.fPO.getCount();
            for (int i = 0; i < count; i++) {
                View view = this.fPO.getView(i, this);
                view.setFocusable(true);
                addView(view);
            }
        }
    }
}
