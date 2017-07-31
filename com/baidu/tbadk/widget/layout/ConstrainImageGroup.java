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
    private BdUniqueId aOM;
    private com.baidu.adp.lib.e.b<b> aON;
    private com.baidu.adp.lib.e.b<TbImageView> aOO;
    private c aOP;
    private int aOQ;
    private double aOR;
    private d aOS;
    private View.OnClickListener aOT;
    private ViewGroup.OnHierarchyChangeListener aOU;
    private boolean ajJ;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.aOP = new a();
        this.ajJ = false;
        this.aOU = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aON != null) {
                    ConstrainImageGroup.this.aON.n((b) view2);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aOU);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOP = new a();
        this.ajJ = false;
        this.aOU = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aON != null) {
                    ConstrainImageGroup.this.aON.n((b) view2);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aOU);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOP = new a();
        this.ajJ = false;
        this.aOU = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aON != null) {
                    ConstrainImageGroup.this.aON.n((b) view2);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aOU);
    }

    public void setFromCDN(boolean z) {
        this.ajJ = z;
    }

    public void setSingleImageRatio(double d) {
        this.aOR = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.aOT = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<b> bVar) {
        this.aON = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.aOS = dVar;
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aOO = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.aOQ = i;
        } else {
            this.aOQ = 0;
        }
    }

    public void setImageUrls(List<String> list) {
        int i;
        if (!u.v(list) && this.aON != null) {
            ft(u.u(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof b) {
                    b bVar = (b) childAt;
                    bVar.setImageClickListener(this.aOS);
                    bVar.setFromCDN(this.ajJ);
                    if (this.aOR > 0.0d) {
                        bVar.setSingleImageRatio(this.aOR);
                    }
                    bVar.setOnClickListener(this.aOT);
                    i = this.aOP.a(bVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void ft(int i) {
        int fs = this.aOP.fs(i);
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
        b fS = this.aON.fS();
        fS.setImagePadding(this.aOQ);
        fS.setImageViewObjectPool(this.aOO);
        fS.setImageMaxChildCount(-1);
        fS.setExtraCenterText(null);
        fS.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        fS.setPageUniqueId(this.aOM);
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
            this.aOP = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aOM = bdUniqueId;
    }
}
