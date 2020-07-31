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
    protected b ePv;
    private boolean ePw;
    protected DataSetObserver mObserver;

    public AdapterLayout(Context context) {
        this(context, null);
    }

    public AdapterLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdapterLayout(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ePw = false;
        if (context instanceof Activity) {
            ((Activity) context).getApplication().registerActivityLifecycleCallbacks(new g() { // from class: com.baidu.tbadk.widget.extend.AdapterLayout.1
                @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    if (activity == context) {
                        if (AdapterLayout.this.ePv != null && AdapterLayout.this.mObserver != null) {
                            AdapterLayout.this.ePv.unregisterDataSetObserver(AdapterLayout.this.mObserver);
                            AdapterLayout.this.ePv = null;
                            AdapterLayout.this.mObserver = null;
                        }
                        ((Activity) context).getApplication().unregisterActivityLifecycleCallbacks(this);
                    }
                }
            });
        }
    }

    public void setAdapter(b bVar) {
        bnW();
        if (bVar == null) {
            throw new NullPointerException("FlowBaseAdapter is null");
        }
        this.ePv = bVar;
        this.mObserver = new DataSetObserver() { // from class: com.baidu.tbadk.widget.extend.AdapterLayout.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                AdapterLayout.this.bnY();
            }
        };
        bnX();
        bnY();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        bnW();
        super.onDetachedFromWindow();
    }

    private void bnW() {
        if (this.ePv != null && this.mObserver != null && this.ePw) {
            this.ePw = false;
            this.ePv.unregisterDataSetObserver(this.mObserver);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bnX();
    }

    private void bnX() {
        if (this.ePv != null && this.mObserver != null && !this.ePw) {
            this.ePv.registerDataSetObserver(this.mObserver);
            this.ePw = true;
        }
    }

    protected void bnY() {
        if (this.ePv != null) {
            removeAllViews();
            int count = this.ePv.getCount();
            for (int i = 0; i < count; i++) {
                View view = this.ePv.getView(i, this);
                view.setFocusable(true);
                addView(view);
            }
        }
    }
}
