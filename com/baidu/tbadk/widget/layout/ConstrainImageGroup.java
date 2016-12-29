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
    private double aGA;
    private h aGB;
    private View.OnClickListener aGC;
    private ViewGroup.OnHierarchyChangeListener aGD;
    private com.baidu.adp.lib.f.b<c> aGw;
    private com.baidu.adp.lib.f.b<TbImageView> aGx;
    private f aGy;
    private int aGz;
    private boolean adn;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.aGy = new a();
        this.adn = false;
        this.aGD = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aGD);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGy = new a();
        this.adn = false;
        this.aGD = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aGD);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGy = new a();
        this.adn = false;
        this.aGD = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aGD);
    }

    public void setFromCDN(boolean z) {
        this.adn = z;
    }

    public void setSingleImageRatio(double d) {
        this.aGA = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.aGC = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.f.b<c> bVar) {
        this.aGw = bVar;
    }

    public void setImageClickListener(h hVar) {
        this.aGB = hVar;
    }

    public void setImageViewPool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        this.aGx = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.aGz = i;
        } else {
            this.aGz = 0;
        }
    }

    public void setImageUrls(List<String> list) {
        int i;
        if (!x.t(list) && this.aGw != null) {
            fs(x.s(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof c) {
                    c cVar = (c) childAt;
                    cVar.setImageClickListener(this.aGB);
                    cVar.setFromCDN(this.adn);
                    if (this.aGA > 0.0d) {
                        cVar.setSingleImageRatio(this.aGA);
                    }
                    cVar.setOnClickListener(this.aGC);
                    i = this.aGy.a(cVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void fs(int i) {
        int fr = this.aGy.fr(i);
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
        c ey = this.aGw.ey();
        ey.setImagePadding(this.aGz);
        ey.setImageViewObjectPool(this.aGx);
        ey.setImageMaxChildCount(-1);
        ey.setExtraCenterText(null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aGz;
        ey.setLayoutParams(layoutParams);
        return ey;
    }

    public void tm() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof c) {
                ((c) childAt).tm();
            }
        }
    }
}
