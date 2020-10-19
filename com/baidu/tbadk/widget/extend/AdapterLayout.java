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
    protected b fpk;
    private boolean fpl;
    protected DataSetObserver mObserver;

    public AdapterLayout(Context context) {
        this(context, null);
    }

    public AdapterLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdapterLayout(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fpl = false;
        if (context instanceof Activity) {
            ((Activity) context).getApplication().registerActivityLifecycleCallbacks(new g() { // from class: com.baidu.tbadk.widget.extend.AdapterLayout.1
                @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    if (activity == context) {
                        if (AdapterLayout.this.fpk != null && AdapterLayout.this.mObserver != null) {
                            AdapterLayout.this.fpk.unregisterDataSetObserver(AdapterLayout.this.mObserver);
                            AdapterLayout.this.fpk = null;
                            AdapterLayout.this.mObserver = null;
                        }
                        ((Activity) context).getApplication().unregisterActivityLifecycleCallbacks(this);
                    }
                }
            });
        }
    }

    public void setAdapter(b bVar) {
        bAE();
        if (bVar == null) {
            throw new NullPointerException("FlowBaseAdapter is null");
        }
        this.fpk = bVar;
        this.mObserver = new DataSetObserver() { // from class: com.baidu.tbadk.widget.extend.AdapterLayout.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                AdapterLayout.this.bAG();
            }
        };
        bAF();
        bAG();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        bAE();
        super.onDetachedFromWindow();
    }

    private void bAE() {
        if (this.fpk != null && this.mObserver != null && this.fpl) {
            this.fpl = false;
            this.fpk.unregisterDataSetObserver(this.mObserver);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bAF();
    }

    private void bAF() {
        if (this.fpk != null && this.mObserver != null && !this.fpl) {
            this.fpk.registerDataSetObserver(this.mObserver);
            this.fpl = true;
        }
    }

    protected void bAG() {
        if (this.fpk != null) {
            removeAllViews();
            int count = this.fpk.getCount();
            for (int i = 0; i < count; i++) {
                View view = this.fpk.getView(i, this);
                view.setFocusable(true);
                addView(view);
            }
        }
    }
}
