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
    protected b fDA;
    private boolean fDB;
    protected DataSetObserver mObserver;

    public AdapterLayout(Context context) {
        this(context, null);
    }

    public AdapterLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdapterLayout(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fDB = false;
        if (context instanceof Activity) {
            ((Activity) context).getApplication().registerActivityLifecycleCallbacks(new g() { // from class: com.baidu.tbadk.widget.extend.AdapterLayout.1
                @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    if (activity == context) {
                        if (AdapterLayout.this.fDA != null && AdapterLayout.this.mObserver != null) {
                            AdapterLayout.this.fDA.unregisterDataSetObserver(AdapterLayout.this.mObserver);
                            AdapterLayout.this.fDA = null;
                            AdapterLayout.this.mObserver = null;
                        }
                        ((Activity) context).getApplication().unregisterActivityLifecycleCallbacks(this);
                    }
                }
            });
        }
    }

    public void setAdapter(b bVar) {
        bEW();
        if (bVar == null) {
            throw new NullPointerException("FlowBaseAdapter is null");
        }
        this.fDA = bVar;
        this.mObserver = new DataSetObserver() { // from class: com.baidu.tbadk.widget.extend.AdapterLayout.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                AdapterLayout.this.bEY();
            }
        };
        bEX();
        bEY();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        bEW();
        super.onDetachedFromWindow();
    }

    private void bEW() {
        if (this.fDA != null && this.mObserver != null && this.fDB) {
            this.fDB = false;
            this.fDA.unregisterDataSetObserver(this.mObserver);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bEX();
    }

    private void bEX() {
        if (this.fDA != null && this.mObserver != null && !this.fDB) {
            this.fDA.registerDataSetObserver(this.mObserver);
            this.fDB = true;
        }
    }

    protected void bEY() {
        if (this.fDA != null) {
            removeAllViews();
            int count = this.fDA.getCount();
            for (int i = 0; i < count; i++) {
                View view = this.fDA.getView(i, this);
                view.setFocusable(true);
                addView(view);
            }
        }
    }
}
