package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes.dex */
public class ConstrainImageGroup extends LinearLayout {
    private com.baidu.adp.lib.e.b<c> aFl;
    private com.baidu.adp.lib.e.b<TbImageView> aFm;
    private f aFn;
    private int aFo;
    private double aFp;
    private h aFq;
    private View.OnClickListener aFr;
    private ViewGroup.OnHierarchyChangeListener aFs;
    private boolean acy;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.aFn = new a();
        this.acy = false;
        this.aFs = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aFs);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aFn = new a();
        this.acy = false;
        this.aFs = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aFs);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aFn = new a();
        this.acy = false;
        this.aFs = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aFs);
    }

    public void setFromCDN(boolean z) {
        this.acy = z;
    }

    public void setSingleImageRatio(double d) {
        this.aFp = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.aFr = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<c> bVar) {
        this.aFl = bVar;
    }

    public void setImageClickListener(h hVar) {
        this.aFq = hVar;
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aFm = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.aFo = i;
        } else {
            this.aFo = 0;
        }
    }

    public void setImageUrls(List<String> list) {
        int i;
        if (!w.s(list) && this.aFl != null) {
            ft(w.r(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof c) {
                    c cVar = (c) childAt;
                    cVar.setImageClickListener(this.aFq);
                    cVar.setFromCDN(this.acy);
                    if (this.aFp > 0.0d) {
                        cVar.setSingleImageRatio(this.aFp);
                    }
                    cVar.setOnClickListener(this.aFr);
                    i = this.aFn.a(cVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void ft(int i) {
        int fs = this.aFn.fs(i);
        int childCount = getChildCount() - fs;
        if (childCount > 0) {
            removeViews(fs, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private c getConstrainImageLayout() {
        c ew = this.aFl.ew();
        ew.setImagePadding(this.aFo);
        ew.setImageViewObjectPool(this.aFm);
        ew.setImageMaxChildCount(-1);
        ew.setExtraCenterText(null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aFo;
        ew.setLayoutParams(layoutParams);
        return ew;
    }

    public void tg() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof c) {
                ((c) childAt).tg();
            }
        }
    }
}
