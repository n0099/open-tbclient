package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ConstrainImageGroup extends LinearLayout {
    private boolean aXs;
    private int bGA;
    private double bGB;
    private d bGC;
    private View.OnClickListener bGD;
    private ViewGroup.OnHierarchyChangeListener bGE;
    private BdUniqueId bGw;
    private com.baidu.adp.lib.e.b<b> bGx;
    private com.baidu.adp.lib.e.b<TbImageView> bGy;
    private c bGz;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.bGz = new a();
        this.aXs = false;
        this.bGE = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.bGx != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.bGx.ar(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bGE);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGz = new a();
        this.aXs = false;
        this.bGE = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.bGx != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.bGx.ar(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bGE);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bGz = new a();
        this.aXs = false;
        this.bGE = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.bGx != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.bGx.ar(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bGE);
    }

    public void setFromCDN(boolean z) {
        this.aXs = z;
    }

    public void setSingleImageRatio(double d) {
        this.bGB = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.bGD = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<b> bVar) {
        this.bGx = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.bGC = dVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof b) {
                    ((b) childAt).setImageClickListener(this.bGC);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.bGy = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.bGA = i;
        } else {
            this.bGA = 0;
        }
    }

    @Deprecated
    public void setImageUrls(List<String> list) {
        if (!v.E(list)) {
            LinkedList linkedList = new LinkedList();
            for (String str : list) {
                MediaData mediaData = new MediaData();
                mediaData.setPic(str);
                mediaData.setThumbnails_url(str);
                linkedList.add(mediaData);
            }
            setImageMediaList(linkedList);
        }
    }

    public void setImageMediaList(List<MediaData> list) {
        int i;
        if (!v.E(list) && this.bGx != null) {
            iI(v.D(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof b) {
                    b bVar = (b) childAt;
                    bVar.setImageClickListener(this.bGC);
                    bVar.setFromCDN(this.aXs);
                    if (this.bGB > 0.0d) {
                        bVar.setSingleImageRatio(this.bGB);
                    }
                    bVar.setOnClickListener(this.bGD);
                    i = this.bGz.a(bVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void iI(int i) {
        int iH = this.bGz.iH(i);
        int childCount = getChildCount() - iH;
        if (childCount > 0) {
            removeViews(iH, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private b getConstrainImageLayout() {
        b nj = this.bGx.nj();
        nj.setImagePadding(this.bGA);
        nj.setImageViewObjectPool(this.bGy);
        nj.setImageMaxChildCount(-1);
        nj.setExtraCenterText(null);
        nj.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        nj.setPageUniqueId(this.bGw);
        return nj;
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
            this.bGz = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.bGw = bdUniqueId;
    }
}
