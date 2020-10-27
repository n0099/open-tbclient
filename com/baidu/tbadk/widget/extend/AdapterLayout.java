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
    protected b fxK;
    private boolean fxL;
    protected DataSetObserver mObserver;

    public AdapterLayout(Context context) {
        this(context, null);
    }

    public AdapterLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdapterLayout(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fxL = false;
        if (context instanceof Activity) {
            ((Activity) context).getApplication().registerActivityLifecycleCallbacks(new g() { // from class: com.baidu.tbadk.widget.extend.AdapterLayout.1
                @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    if (activity == context) {
                        if (AdapterLayout.this.fxK != null && AdapterLayout.this.mObserver != null) {
                            AdapterLayout.this.fxK.unregisterDataSetObserver(AdapterLayout.this.mObserver);
                            AdapterLayout.this.fxK = null;
                            AdapterLayout.this.mObserver = null;
                        }
                        ((Activity) context).getApplication().unregisterActivityLifecycleCallbacks(this);
                    }
                }
            });
        }
    }

    public void setAdapter(b bVar) {
        bCx();
        if (bVar == null) {
            throw new NullPointerException("FlowBaseAdapter is null");
        }
        this.fxK = bVar;
        this.mObserver = new DataSetObserver() { // from class: com.baidu.tbadk.widget.extend.AdapterLayout.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                AdapterLayout.this.bCz();
            }
        };
        bCy();
        bCz();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        bCx();
        super.onDetachedFromWindow();
    }

    private void bCx() {
        if (this.fxK != null && this.mObserver != null && this.fxL) {
            this.fxL = false;
            this.fxK.unregisterDataSetObserver(this.mObserver);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bCy();
    }

    private void bCy() {
        if (this.fxK != null && this.mObserver != null && !this.fxL) {
            this.fxK.registerDataSetObserver(this.mObserver);
            this.fxL = true;
        }
    }

    protected void bCz() {
        if (this.fxK != null) {
            removeAllViews();
            int count = this.fxK.getCount();
            for (int i = 0; i < count; i++) {
                View view = this.fxK.getView(i, this);
                view.setFocusable(true);
                addView(view);
            }
        }
    }
}
