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
    private d aOA;
    private View.OnClickListener aOB;
    private ViewGroup.OnHierarchyChangeListener aOC;
    private BdUniqueId aOu;
    private com.baidu.adp.lib.e.b<b> aOv;
    private com.baidu.adp.lib.e.b<TbImageView> aOw;
    private c aOx;
    private int aOy;
    private double aOz;
    private boolean aje;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.aOx = new a();
        this.aje = false;
        this.aOC = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aOv != null) {
                    ConstrainImageGroup.this.aOv.m((b) view2);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aOC);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOx = new a();
        this.aje = false;
        this.aOC = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aOv != null) {
                    ConstrainImageGroup.this.aOv.m((b) view2);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aOC);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOx = new a();
        this.aje = false;
        this.aOC = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aOv != null) {
                    ConstrainImageGroup.this.aOv.m((b) view2);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aOC);
    }

    public void setFromCDN(boolean z) {
        this.aje = z;
    }

    public void setSingleImageRatio(double d) {
        this.aOz = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.aOB = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<b> bVar) {
        this.aOv = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.aOA = dVar;
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aOw = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.aOy = i;
        } else {
            this.aOy = 0;
        }
    }

    public void setImageUrls(List<String> list) {
        int i;
        if (!v.v(list) && this.aOv != null) {
            ft(v.u(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof b) {
                    b bVar = (b) childAt;
                    bVar.setImageClickListener(this.aOA);
                    bVar.setFromCDN(this.aje);
                    if (this.aOz > 0.0d) {
                        bVar.setSingleImageRatio(this.aOz);
                    }
                    bVar.setOnClickListener(this.aOB);
                    i = this.aOx.a(bVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void ft(int i) {
        int fs = this.aOx.fs(i);
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
        b fI = this.aOv.fI();
        fI.setImagePadding(this.aOy);
        fI.setImageViewObjectPool(this.aOw);
        fI.setImageMaxChildCount(-1);
        fI.setExtraCenterText(null);
        fI.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        fI.setPageUniqueId(this.aOu);
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
            this.aOx = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aOu = bdUniqueId;
    }
}
