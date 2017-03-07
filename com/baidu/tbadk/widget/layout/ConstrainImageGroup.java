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
    private com.baidu.adp.lib.e.b<c> aKI;
    private com.baidu.adp.lib.e.b<TbImageView> aKJ;
    private f aKK;
    private int aKL;
    private double aKM;
    private h aKN;
    private View.OnClickListener aKO;
    private ViewGroup.OnHierarchyChangeListener aKP;
    private boolean ahO;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.aKK = new a();
        this.ahO = false;
        this.aKP = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aKP);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aKK = new a();
        this.ahO = false;
        this.aKP = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aKP);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aKK = new a();
        this.ahO = false;
        this.aKP = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aKP);
    }

    public void setFromCDN(boolean z) {
        this.ahO = z;
    }

    public void setSingleImageRatio(double d) {
        this.aKM = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.aKO = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<c> bVar) {
        this.aKI = bVar;
    }

    public void setImageClickListener(h hVar) {
        this.aKN = hVar;
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aKJ = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.aKL = i;
        } else {
            this.aKL = 0;
        }
    }

    public void setImageUrls(List<String> list) {
        int i;
        if (!x.q(list) && this.aKI != null) {
            fm(x.p(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof c) {
                    c cVar = (c) childAt;
                    cVar.setImageClickListener(this.aKN);
                    cVar.setFromCDN(this.ahO);
                    if (this.aKM > 0.0d) {
                        cVar.setSingleImageRatio(this.aKM);
                    }
                    cVar.setOnClickListener(this.aKO);
                    i = this.aKK.a(cVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void fm(int i) {
        int fl = this.aKK.fl(i);
        int childCount = getChildCount() - fl;
        if (childCount > 0) {
            removeViews(fl, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private c getConstrainImageLayout() {
        c fE = this.aKI.fE();
        fE.setImagePadding(this.aKL);
        fE.setImageViewObjectPool(this.aKJ);
        fE.setImageMaxChildCount(-1);
        fE.setExtraCenterText(null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aKL;
        fE.setLayoutParams(layoutParams);
        return fE;
    }

    public void tD() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof c) {
                ((c) childAt).tD();
            }
        }
    }
}
