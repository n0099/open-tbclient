package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes.dex */
public class ConstrainImageGroup extends LinearLayout {
    private BdUniqueId aMp;
    private com.baidu.adp.lib.e.b<c> aMq;
    private com.baidu.adp.lib.e.b<TbImageView> aMr;
    private f aMs;
    private int aMt;
    private double aMu;
    private g aMv;
    private View.OnClickListener aMw;
    private ViewGroup.OnHierarchyChangeListener aMx;
    private boolean ahU;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.aMs = new a();
        this.ahU = false;
        this.aMx = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aMx);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aMs = new a();
        this.ahU = false;
        this.aMx = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aMx);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aMs = new a();
        this.ahU = false;
        this.aMx = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aMx);
    }

    public void setFromCDN(boolean z) {
        this.ahU = z;
    }

    public void setSingleImageRatio(double d) {
        this.aMu = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.aMw = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<c> bVar) {
        this.aMq = bVar;
    }

    public void setImageClickListener(g gVar) {
        this.aMv = gVar;
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aMr = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.aMt = i;
        } else {
            this.aMt = 0;
        }
    }

    public void setImageUrls(List<String> list) {
        int i;
        if (!z.t(list) && this.aMq != null) {
            fo(z.s(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof c) {
                    c cVar = (c) childAt;
                    cVar.setImageClickListener(this.aMv);
                    cVar.setFromCDN(this.ahU);
                    if (this.aMu > 0.0d) {
                        cVar.setSingleImageRatio(this.aMu);
                    }
                    cVar.setOnClickListener(this.aMw);
                    i = this.aMs.a(cVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void fo(int i) {
        int fn = this.aMs.fn(i);
        int childCount = getChildCount() - fn;
        if (childCount > 0) {
            removeViews(fn, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private c getConstrainImageLayout() {
        c fJ = this.aMq.fJ();
        fJ.setImagePadding(this.aMt);
        fJ.setImageViewObjectPool(this.aMr);
        fJ.setImageMaxChildCount(-1);
        fJ.setExtraCenterText(null);
        fJ.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        fJ.setPageUniqueId(this.aMp);
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

    public void setImageProcessor(f fVar) {
        if (fVar != null) {
            this.aMs = fVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aMp = bdUniqueId;
    }
}
