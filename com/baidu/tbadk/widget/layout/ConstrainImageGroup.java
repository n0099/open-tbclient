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
    private com.baidu.adp.lib.e.b<c> aKY;
    private com.baidu.adp.lib.e.b<TbImageView> aKZ;
    private f aLa;
    private int aLb;
    private double aLc;
    private g aLd;
    private View.OnClickListener aLe;
    private ViewGroup.OnHierarchyChangeListener aLf;
    private boolean aic;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.aLa = new a();
        this.aic = false;
        this.aLf = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aLf);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aLa = new a();
        this.aic = false;
        this.aLf = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aLf);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aLa = new a();
        this.aic = false;
        this.aLf = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aLf);
    }

    public void setFromCDN(boolean z) {
        this.aic = z;
    }

    public void setSingleImageRatio(double d) {
        this.aLc = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.aLe = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<c> bVar) {
        this.aKY = bVar;
    }

    public void setImageClickListener(g gVar) {
        this.aLd = gVar;
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aKZ = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.aLb = i;
        } else {
            this.aLb = 0;
        }
    }

    public void setImageUrls(List<String> list) {
        int i;
        if (!x.q(list) && this.aKY != null) {
            fp(x.p(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof c) {
                    c cVar = (c) childAt;
                    cVar.setImageClickListener(this.aLd);
                    cVar.setFromCDN(this.aic);
                    if (this.aLc > 0.0d) {
                        cVar.setSingleImageRatio(this.aLc);
                    }
                    cVar.setOnClickListener(this.aLe);
                    i = this.aLa.a(cVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void fp(int i) {
        int fo = this.aLa.fo(i);
        int childCount = getChildCount() - fo;
        if (childCount > 0) {
            removeViews(fo, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private c getConstrainImageLayout() {
        c fJ = this.aKY.fJ();
        fJ.setImagePadding(this.aLb);
        fJ.setImageViewObjectPool(this.aKZ);
        fJ.setImageMaxChildCount(-1);
        fJ.setExtraCenterText(null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aLb;
        fJ.setLayoutParams(layoutParams);
        return fJ;
    }

    public void onChangeSkinType() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof c) {
                ((c) childAt).onChangeSkinType();
            }
        }
    }
}
