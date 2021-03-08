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
    protected b fTB;
    private boolean fTC;
    protected DataSetObserver mObserver;

    public AdapterLayout(Context context) {
        this(context, null);
    }

    public AdapterLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdapterLayout(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fTC = false;
        if (context instanceof Activity) {
            ((Activity) context).getApplication().registerActivityLifecycleCallbacks(new g() { // from class: com.baidu.tbadk.widget.extend.AdapterLayout.1
                @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    if (activity == context) {
                        if (AdapterLayout.this.fTB != null && AdapterLayout.this.mObserver != null) {
                            AdapterLayout.this.fTB.unregisterDataSetObserver(AdapterLayout.this.mObserver);
                            AdapterLayout.this.fTB = null;
                            AdapterLayout.this.mObserver = null;
                        }
                        ((Activity) context).getApplication().unregisterActivityLifecycleCallbacks(this);
                    }
                }
            });
        }
    }

    public void setAdapter(b bVar) {
        bGR();
        if (bVar == null) {
            throw new NullPointerException("FlowBaseAdapter is null");
        }
        this.fTB = bVar;
        this.mObserver = new DataSetObserver() { // from class: com.baidu.tbadk.widget.extend.AdapterLayout.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                AdapterLayout.this.bGT();
            }
        };
        bGS();
        bGT();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        bGR();
        super.onDetachedFromWindow();
    }

    private void bGR() {
        if (this.fTB != null && this.mObserver != null && this.fTC) {
            this.fTC = false;
            this.fTB.unregisterDataSetObserver(this.mObserver);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bGS();
    }

    private void bGS() {
        if (this.fTB != null && this.mObserver != null && !this.fTC) {
            this.fTB.registerDataSetObserver(this.mObserver);
            this.fTC = true;
        }
    }

    protected void bGT() {
        if (this.fTB != null) {
            removeAllViews();
            int count = this.fTB.getCount();
            for (int i = 0; i < count; i++) {
                View view = this.fTB.getView(i, this);
                view.setFocusable(true);
                addView(view);
            }
        }
    }
}
