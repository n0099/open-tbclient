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
    private com.baidu.adp.lib.f.b<c> aDG;
    private com.baidu.adp.lib.f.b<TbImageView> aDH;
    private f aDI;
    private int aDJ;
    private double aDK;
    private h aDL;
    private View.OnClickListener aDM;
    private ViewGroup.OnHierarchyChangeListener aDN;
    private boolean aav;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.aDI = new a();
        this.aav = false;
        this.aDN = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aDN);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDI = new a();
        this.aav = false;
        this.aDN = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aDN);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDI = new a();
        this.aav = false;
        this.aDN = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aDN);
    }

    public void setFromCDN(boolean z) {
        this.aav = z;
    }

    public void setSingleImageRatio(double d) {
        this.aDK = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.aDM = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.f.b<c> bVar) {
        this.aDG = bVar;
    }

    public void setImageClickListener(h hVar) {
        this.aDL = hVar;
    }

    public void setImageViewPool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        this.aDH = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.aDJ = i;
        } else {
            this.aDJ = 0;
        }
    }

    public void setImageUrls(List<String> list) {
        int i;
        if (!y.t(list) && this.aDG != null) {
            fc(y.s(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof c) {
                    c cVar = (c) childAt;
                    cVar.setImageClickListener(this.aDL);
                    cVar.setFromCDN(this.aav);
                    if (this.aDK > 0.0d && childCount == 1) {
                        cVar.setSingleImageRatio(this.aDK);
                    }
                    cVar.setOnClickListener(this.aDM);
                    i = this.aDI.a(cVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void fc(int i) {
        int fb = this.aDI.fb(i);
        int childCount = getChildCount() - fb;
        if (childCount > 0) {
            removeViews(fb, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private c getConstrainImageLayout() {
        c dD = this.aDG.dD();
        dD.setImagePadding(this.aDJ);
        dD.setImageViewObjectPool(this.aDH);
        dD.setImageMaxChildCount(-1);
        dD.setExtraCenterText(null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aDJ;
        dD.setLayoutParams(layoutParams);
        return dD;
    }

    public void sd() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof c) {
                ((c) childAt).sd();
            }
        }
    }
}
