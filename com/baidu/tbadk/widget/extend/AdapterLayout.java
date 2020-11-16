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
    protected b fDd;
    private boolean fDe;
    protected DataSetObserver mObserver;

    public AdapterLayout(Context context) {
        this(context, null);
    }

    public AdapterLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdapterLayout(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fDe = false;
        if (context instanceof Activity) {
            ((Activity) context).getApplication().registerActivityLifecycleCallbacks(new g() { // from class: com.baidu.tbadk.widget.extend.AdapterLayout.1
                @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    if (activity == context) {
                        if (AdapterLayout.this.fDd != null && AdapterLayout.this.mObserver != null) {
                            AdapterLayout.this.fDd.unregisterDataSetObserver(AdapterLayout.this.mObserver);
                            AdapterLayout.this.fDd = null;
                            AdapterLayout.this.mObserver = null;
                        }
                        ((Activity) context).getApplication().unregisterActivityLifecycleCallbacks(this);
                    }
                }
            });
        }
    }

    public void setAdapter(b bVar) {
        bEp();
        if (bVar == null) {
            throw new NullPointerException("FlowBaseAdapter is null");
        }
        this.fDd = bVar;
        this.mObserver = new DataSetObserver() { // from class: com.baidu.tbadk.widget.extend.AdapterLayout.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                AdapterLayout.this.bEr();
            }
        };
        bEq();
        bEr();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        bEp();
        super.onDetachedFromWindow();
    }

    private void bEp() {
        if (this.fDd != null && this.mObserver != null && this.fDe) {
            this.fDe = false;
            this.fDd.unregisterDataSetObserver(this.mObserver);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bEq();
    }

    private void bEq() {
        if (this.fDd != null && this.mObserver != null && !this.fDe) {
            this.fDd.registerDataSetObserver(this.mObserver);
            this.fDe = true;
        }
    }

    protected void bEr() {
        if (this.fDd != null) {
            removeAllViews();
            int count = this.fDd.getCount();
            for (int i = 0; i < count; i++) {
                View view = this.fDd.getView(i, this);
                view.setFocusable(true);
                addView(view);
            }
        }
    }
}
