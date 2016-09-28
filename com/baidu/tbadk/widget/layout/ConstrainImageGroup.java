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
    private com.baidu.adp.lib.f.b<c> aGm;
    private com.baidu.adp.lib.f.b<TbImageView> aGn;
    private f aGo;
    private int aGp;
    private double aGq;
    private h aGr;
    private View.OnClickListener aGs;
    private ViewGroup.OnHierarchyChangeListener aGt;
    private boolean adw;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.aGo = new a();
        this.adw = false;
        this.aGt = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aGt);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGo = new a();
        this.adw = false;
        this.aGt = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aGt);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGo = new a();
        this.adw = false;
        this.aGt = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aGt);
    }

    public void setFromCDN(boolean z) {
        this.adw = z;
    }

    public void setSingleImageRatio(double d) {
        this.aGq = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.aGs = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.f.b<c> bVar) {
        this.aGm = bVar;
    }

    public void setImageClickListener(h hVar) {
        this.aGr = hVar;
    }

    public void setImageViewPool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        this.aGn = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.aGp = i;
        } else {
            this.aGp = 0;
        }
    }

    public void setImageUrls(List<String> list) {
        int i;
        if (!y.t(list) && this.aGm != null) {
            fp(y.s(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof c) {
                    c cVar = (c) childAt;
                    cVar.setImageClickListener(this.aGr);
                    cVar.setFromCDN(this.adw);
                    if (this.aGq > 0.0d && childCount == 1) {
                        cVar.setSingleImageRatio(this.aGq);
                    }
                    cVar.setOnClickListener(this.aGs);
                    i = this.aGo.a(cVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void fp(int i) {
        int fo = this.aGo.fo(i);
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
        c ey = this.aGm.ey();
        ey.setImagePadding(this.aGp);
        ey.setImageViewObjectPool(this.aGn);
        ey.setImageMaxChildCount(-1);
        ey.setExtraCenterText(null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aGp;
        ey.setLayoutParams(layoutParams);
        return ey;
    }

    public void tx() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof c) {
                ((c) childAt).tx();
            }
        }
    }
}
