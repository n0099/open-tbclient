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
    protected b fcY;
    private boolean fcZ;
    protected DataSetObserver mObserver;

    public AdapterLayout(Context context) {
        this(context, null);
    }

    public AdapterLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdapterLayout(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fcZ = false;
        if (context instanceof Activity) {
            ((Activity) context).getApplication().registerActivityLifecycleCallbacks(new g() { // from class: com.baidu.tbadk.widget.extend.AdapterLayout.1
                @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    if (activity == context) {
                        if (AdapterLayout.this.fcY != null && AdapterLayout.this.mObserver != null) {
                            AdapterLayout.this.fcY.unregisterDataSetObserver(AdapterLayout.this.mObserver);
                            AdapterLayout.this.fcY = null;
                            AdapterLayout.this.mObserver = null;
                        }
                        ((Activity) context).getApplication().unregisterActivityLifecycleCallbacks(this);
                    }
                }
            });
        }
    }

    public void setAdapter(b bVar) {
        bxU();
        if (bVar == null) {
            throw new NullPointerException("FlowBaseAdapter is null");
        }
        this.fcY = bVar;
        this.mObserver = new DataSetObserver() { // from class: com.baidu.tbadk.widget.extend.AdapterLayout.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                AdapterLayout.this.bxW();
            }
        };
        bxV();
        bxW();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        bxU();
        super.onDetachedFromWindow();
    }

    private void bxU() {
        if (this.fcY != null && this.mObserver != null && this.fcZ) {
            this.fcZ = false;
            this.fcY.unregisterDataSetObserver(this.mObserver);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bxV();
    }

    private void bxV() {
        if (this.fcY != null && this.mObserver != null && !this.fcZ) {
            this.fcY.registerDataSetObserver(this.mObserver);
            this.fcZ = true;
        }
    }

    protected void bxW() {
        if (this.fcY != null) {
            removeAllViews();
            int count = this.fcY.getCount();
            for (int i = 0; i < count; i++) {
                View view = this.fcY.getView(i, this);
                view.setFocusable(true);
                addView(view);
            }
        }
    }
}
