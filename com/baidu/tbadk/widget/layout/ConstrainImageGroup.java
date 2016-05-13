package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes.dex */
public class ConstrainImageGroup extends LinearLayout {
    private boolean Zv;
    private com.baidu.adp.lib.f.b<c> aCq;
    private com.baidu.adp.lib.f.b<TbImageView> aCr;
    private f aCs;
    private int aCt;
    private g aCu;
    private View.OnClickListener aCv;
    private ViewGroup.OnHierarchyChangeListener aCw;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.aCs = new a();
        this.Zv = false;
        this.aCw = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aCw);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aCs = new a();
        this.Zv = false;
        this.aCw = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aCw);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aCs = new a();
        this.Zv = false;
        this.aCw = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aCw);
    }

    public void setFromCDN(boolean z) {
        this.Zv = z;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.aCv = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.f.b<c> bVar) {
        this.aCq = bVar;
    }

    public void setImageClickListener(g gVar) {
        this.aCu = gVar;
    }

    public void setImageViewPool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        this.aCr = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.aCt = i;
        } else {
            this.aCt = 0;
        }
    }

    public void setImageUrls(List<String> list) {
        int i;
        if (!y.s(list) && this.aCq != null) {
            eW(y.r(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof c) {
                    c cVar = (c) childAt;
                    cVar.setImageClickListener(this.aCu);
                    cVar.setFromCDN(this.Zv);
                    cVar.setOnClickListener(this.aCv);
                    i = this.aCs.a(cVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void eW(int i) {
        int eV = this.aCs.eV(i);
        int childCount = getChildCount() - eV;
        if (childCount > 0) {
            removeViews(eV, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private c getConstrainImageLayout() {
        c dD = this.aCq.dD();
        dD.setImagePadding(this.aCt);
        dD.setImageViewObjectPool(this.aCr);
        dD.setImageMaxChildCount(-1);
        dD.setExtraCenterText(null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aCt;
        dD.setLayoutParams(layoutParams);
        return dD;
    }

    public void sg() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof c) {
                ((c) childAt).sg();
            }
        }
    }
}
