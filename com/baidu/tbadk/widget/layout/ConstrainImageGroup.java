package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes.dex */
public class ConstrainImageGroup extends LinearLayout {
    private com.baidu.adp.lib.f.b<c> aHc;
    private com.baidu.adp.lib.f.b<TbImageView> aHd;
    private f aHe;
    private int aHf;
    private double aHg;
    private h aHh;
    private View.OnClickListener aHi;
    private ViewGroup.OnHierarchyChangeListener aHj;
    private boolean adU;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.aHe = new a();
        this.adU = false;
        this.aHj = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aHj);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aHe = new a();
        this.adU = false;
        this.aHj = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aHj);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aHe = new a();
        this.adU = false;
        this.aHj = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aHj);
    }

    public void setFromCDN(boolean z) {
        this.adU = z;
    }

    public void setSingleImageRatio(double d) {
        this.aHg = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.aHi = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.f.b<c> bVar) {
        this.aHc = bVar;
    }

    public void setImageClickListener(h hVar) {
        this.aHh = hVar;
    }

    public void setImageViewPool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        this.aHd = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.aHf = i;
        } else {
            this.aHf = 0;
        }
    }

    public void setImageUrls(List<String> list) {
        int i;
        if (!x.t(list) && this.aHc != null) {
            fs(x.s(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof c) {
                    c cVar = (c) childAt;
                    cVar.setImageClickListener(this.aHh);
                    cVar.setFromCDN(this.adU);
                    if (this.aHg > 0.0d) {
                        cVar.setSingleImageRatio(this.aHg);
                    }
                    cVar.setOnClickListener(this.aHi);
                    i = this.aHe.a(cVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void fs(int i) {
        int fr = this.aHe.fr(i);
        int childCount = getChildCount() - fr;
        if (childCount > 0) {
            removeViews(fr, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private c getConstrainImageLayout() {
        c ey = this.aHc.ey();
        ey.setImagePadding(this.aHf);
        ey.setImageViewObjectPool(this.aHd);
        ey.setImageMaxChildCount(-1);
        ey.setExtraCenterText(null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aHf;
        ey.setLayoutParams(layoutParams);
        return ey;
    }

    public void tB() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof c) {
                ((c) childAt).tB();
            }
        }
    }
}
