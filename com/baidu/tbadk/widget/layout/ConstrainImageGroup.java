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
    private BdUniqueId aON;
    private com.baidu.adp.lib.e.b<b> aOO;
    private com.baidu.adp.lib.e.b<TbImageView> aOP;
    private c aOQ;
    private int aOR;
    private double aOS;
    private d aOT;
    private View.OnClickListener aOU;
    private ViewGroup.OnHierarchyChangeListener aOV;
    private boolean ajL;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.aOQ = new a();
        this.ajL = false;
        this.aOV = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aOO != null) {
                    ConstrainImageGroup.this.aOO.n((b) view2);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aOV);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOQ = new a();
        this.ajL = false;
        this.aOV = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aOO != null) {
                    ConstrainImageGroup.this.aOO.n((b) view2);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aOV);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOQ = new a();
        this.ajL = false;
        this.aOV = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aOO != null) {
                    ConstrainImageGroup.this.aOO.n((b) view2);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aOV);
    }

    public void setFromCDN(boolean z) {
        this.ajL = z;
    }

    public void setSingleImageRatio(double d) {
        this.aOS = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.aOU = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<b> bVar) {
        this.aOO = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.aOT = dVar;
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aOP = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.aOR = i;
        } else {
            this.aOR = 0;
        }
    }

    public void setImageUrls(List<String> list) {
        int i;
        if (!u.v(list) && this.aOO != null) {
            ft(u.u(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof b) {
                    b bVar = (b) childAt;
                    bVar.setImageClickListener(this.aOT);
                    bVar.setFromCDN(this.ajL);
                    if (this.aOS > 0.0d) {
                        bVar.setSingleImageRatio(this.aOS);
                    }
                    bVar.setOnClickListener(this.aOU);
                    i = this.aOQ.a(bVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void ft(int i) {
        int fs = this.aOQ.fs(i);
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
        b fS = this.aOO.fS();
        fS.setImagePadding(this.aOR);
        fS.setImageViewObjectPool(this.aOP);
        fS.setImageMaxChildCount(-1);
        fS.setExtraCenterText(null);
        fS.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        fS.setPageUniqueId(this.aON);
        return fS;
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
            this.aOQ = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aON = bdUniqueId;
    }
}
