package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes.dex */
public class ConstrainImageGroup extends LinearLayout {
    private c aOA;
    private int aOB;
    private double aOC;
    private d aOD;
    private View.OnClickListener aOE;
    private ViewGroup.OnHierarchyChangeListener aOF;
    private BdUniqueId aOx;
    private com.baidu.adp.lib.e.b<b> aOy;
    private com.baidu.adp.lib.e.b<TbImageView> aOz;
    private boolean ajf;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.aOA = new a();
        this.ajf = false;
        this.aOF = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aOy != null) {
                    ConstrainImageGroup.this.aOy.m((b) view2);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aOF);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOA = new a();
        this.ajf = false;
        this.aOF = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aOy != null) {
                    ConstrainImageGroup.this.aOy.m((b) view2);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aOF);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOA = new a();
        this.ajf = false;
        this.aOF = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aOy != null) {
                    ConstrainImageGroup.this.aOy.m((b) view2);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aOF);
    }

    public void setFromCDN(boolean z) {
        this.ajf = z;
    }

    public void setSingleImageRatio(double d) {
        this.aOC = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.aOE = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<b> bVar) {
        this.aOy = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.aOD = dVar;
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aOz = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.aOB = i;
        } else {
            this.aOB = 0;
        }
    }

    public void setImageUrls(List<String> list) {
        int i;
        if (!v.v(list) && this.aOy != null) {
            ft(v.u(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof b) {
                    b bVar = (b) childAt;
                    bVar.setImageClickListener(this.aOD);
                    bVar.setFromCDN(this.ajf);
                    if (this.aOC > 0.0d) {
                        bVar.setSingleImageRatio(this.aOC);
                    }
                    bVar.setOnClickListener(this.aOE);
                    i = this.aOA.a(bVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void ft(int i) {
        int fs = this.aOA.fs(i);
        int childCount = getChildCount() - fs;
        if (childCount > 0) {
            removeViews(fs, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private b getConstrainImageLayout() {
        b fI = this.aOy.fI();
        fI.setImagePadding(this.aOB);
        fI.setImageViewObjectPool(this.aOz);
        fI.setImageMaxChildCount(-1);
        fI.setExtraCenterText(null);
        fI.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        fI.setPageUniqueId(this.aOx);
        return fI;
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
            this.aOA = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aOx = bdUniqueId;
    }
}
