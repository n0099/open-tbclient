package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes.dex */
public class ConstrainImageGroup extends LinearLayout {
    private BdUniqueId aLk;
    private com.baidu.adp.lib.e.b<c> aLl;
    private com.baidu.adp.lib.e.b<TbImageView> aLm;
    private f aLn;
    private int aLo;
    private double aLp;
    private g aLq;
    private View.OnClickListener aLr;
    private ViewGroup.OnHierarchyChangeListener aLs;
    private boolean ahv;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.aLn = new a();
        this.ahv = false;
        this.aLs = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aLs);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aLn = new a();
        this.ahv = false;
        this.aLs = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aLs);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aLn = new a();
        this.ahv = false;
        this.aLs = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aLs);
    }

    public void setFromCDN(boolean z) {
        this.ahv = z;
    }

    public void setSingleImageRatio(double d) {
        this.aLp = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.aLr = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<c> bVar) {
        this.aLl = bVar;
    }

    public void setImageClickListener(g gVar) {
        this.aLq = gVar;
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aLm = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.aLo = i;
        } else {
            this.aLo = 0;
        }
    }

    public void setImageUrls(List<String> list) {
        int i;
        if (!x.r(list) && this.aLl != null) {
            fl(x.q(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof c) {
                    c cVar = (c) childAt;
                    cVar.setImageClickListener(this.aLq);
                    cVar.setFromCDN(this.ahv);
                    if (this.aLp > 0.0d) {
                        cVar.setSingleImageRatio(this.aLp);
                    }
                    cVar.setOnClickListener(this.aLr);
                    i = this.aLn.a(cVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void fl(int i) {
        int fk = this.aLn.fk(i);
        int childCount = getChildCount() - fk;
        if (childCount > 0) {
            removeViews(fk, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private c getConstrainImageLayout() {
        c fK = this.aLl.fK();
        fK.setImagePadding(this.aLo);
        fK.setImageViewObjectPool(this.aLm);
        fK.setImageMaxChildCount(-1);
        fK.setExtraCenterText(null);
        fK.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        fK.setPageUniqueId(this.aLk);
        return fK;
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
            this.aLn = fVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aLk = bdUniqueId;
    }
}
