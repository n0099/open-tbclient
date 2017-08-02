package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes.dex */
public class ConstrainImageGroup extends LinearLayout {
    private com.baidu.adp.lib.e.b<TbImageView> aNA;
    private c aNB;
    private int aNC;
    private double aND;
    private d aNE;
    private View.OnClickListener aNF;
    private ViewGroup.OnHierarchyChangeListener aNG;
    private BdUniqueId aNy;
    private com.baidu.adp.lib.e.b<b> aNz;
    private boolean aiq;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.aNB = new a();
        this.aiq = false;
        this.aNG = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aNz != null) {
                    ConstrainImageGroup.this.aNz.n((b) view2);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aNG);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aNB = new a();
        this.aiq = false;
        this.aNG = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aNz != null) {
                    ConstrainImageGroup.this.aNz.n((b) view2);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aNG);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aNB = new a();
        this.aiq = false;
        this.aNG = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aNz != null) {
                    ConstrainImageGroup.this.aNz.n((b) view2);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aNG);
    }

    public void setFromCDN(boolean z) {
        this.aiq = z;
    }

    public void setSingleImageRatio(double d) {
        this.aND = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.aNF = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<b> bVar) {
        this.aNz = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.aNE = dVar;
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aNA = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.aNC = i;
        } else {
            this.aNC = 0;
        }
    }

    public void setImageUrls(List<String> list) {
        int i;
        if (!u.v(list) && this.aNz != null) {
            fr(u.u(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof b) {
                    b bVar = (b) childAt;
                    bVar.setImageClickListener(this.aNE);
                    bVar.setFromCDN(this.aiq);
                    if (this.aND > 0.0d) {
                        bVar.setSingleImageRatio(this.aND);
                    }
                    bVar.setOnClickListener(this.aNF);
                    i = this.aNB.a(bVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void fr(int i) {
        int fq = this.aNB.fq(i);
        int childCount = getChildCount() - fq;
        if (childCount > 0) {
            removeViews(fq, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private b getConstrainImageLayout() {
        b fH = this.aNz.fH();
        fH.setImagePadding(this.aNC);
        fH.setImageViewObjectPool(this.aNA);
        fH.setImageMaxChildCount(-1);
        fH.setExtraCenterText(null);
        fH.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        fH.setPageUniqueId(this.aNy);
        return fH;
    }

    public void onChangeSkinType() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof b) {
                ((b) childAt).onChangeSkinType();
            }
        }
    }

    public void setImageProcessor(c cVar) {
        if (cVar != null) {
            this.aNB = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aNy = bdUniqueId;
    }
}
