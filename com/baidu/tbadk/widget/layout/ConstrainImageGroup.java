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
    private com.baidu.adp.lib.f.b<c> aGN;
    private com.baidu.adp.lib.f.b<TbImageView> aGO;
    private f aGP;
    private int aGQ;
    private double aGR;
    private h aGS;
    private View.OnClickListener aGT;
    private ViewGroup.OnHierarchyChangeListener aGU;
    private boolean adl;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.aGP = new a();
        this.adl = false;
        this.aGU = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aGU);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGP = new a();
        this.adl = false;
        this.aGU = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aGU);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGP = new a();
        this.adl = false;
        this.aGU = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aGU);
    }

    public void setFromCDN(boolean z) {
        this.adl = z;
    }

    public void setSingleImageRatio(double d) {
        this.aGR = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.aGT = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.f.b<c> bVar) {
        this.aGN = bVar;
    }

    public void setImageClickListener(h hVar) {
        this.aGS = hVar;
    }

    public void setImageViewPool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        this.aGO = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.aGQ = i;
        } else {
            this.aGQ = 0;
        }
    }

    public void setImageUrls(List<String> list) {
        int i;
        if (!y.t(list) && this.aGN != null) {
            fq(y.s(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof c) {
                    c cVar = (c) childAt;
                    cVar.setImageClickListener(this.aGS);
                    cVar.setFromCDN(this.adl);
                    if (this.aGR > 0.0d && childCount == 1) {
                        cVar.setSingleImageRatio(this.aGR);
                    }
                    cVar.setOnClickListener(this.aGT);
                    i = this.aGP.a(cVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void fq(int i) {
        int fp = this.aGP.fp(i);
        int childCount = getChildCount() - fp;
        if (childCount > 0) {
            removeViews(fp, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private c getConstrainImageLayout() {
        c ey = this.aGN.ey();
        ey.setImagePadding(this.aGQ);
        ey.setImageViewObjectPool(this.aGO);
        ey.setImageMaxChildCount(-1);
        ey.setExtraCenterText(null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aGQ;
        ey.setLayoutParams(layoutParams);
        return ey;
    }

    public void ti() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof c) {
                ((c) childAt).ti();
            }
        }
    }
}
