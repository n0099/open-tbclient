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
    private d HS;
    private boolean Hx;
    private BdUniqueId cJo;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> cSR;
    private com.baidu.adp.lib.e.b<TbImageView> cSS;
    private c cST;
    private int cSU;
    private double cSV;
    private View.OnClickListener cSW;
    private com.baidu.adp.widget.a.b cSX;
    private ViewGroup.OnHierarchyChangeListener cSY;
    private boolean cSZ;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.cST = new b();
        this.Hx = false;
        this.cSY = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.cSR != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.cSR.returnObject(constrainImageLayout);
                }
            }
        };
        this.cSZ = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.cSY);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cST = new b();
        this.Hx = false;
        this.cSY = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.cSR != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.cSR.returnObject(constrainImageLayout);
                }
            }
        };
        this.cSZ = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.cSY);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cST = new b();
        this.Hx = false;
        this.cSY = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.cSR != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.cSR.returnObject(constrainImageLayout);
                }
            }
        };
        this.cSZ = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.cSY);
    }

    public void setFromCDN(boolean z) {
        this.Hx = z;
    }

    public void setSingleImageRatio(double d) {
        this.cSV = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.cSW = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        this.cSR = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.HS = dVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof ConstrainImageLayout) {
                    ((ConstrainImageLayout) childAt).setImageClickListener(this.HS);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.cSS = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.cSU = i;
        } else {
            this.cSU = 0;
        }
    }

    @Deprecated
    public void setImageUrls(List<String> list) {
        if (!v.isEmpty(list)) {
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
        if (!v.isEmpty(list) && this.cSR != null) {
            kx(v.getCount(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof ConstrainImageLayout) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) childAt;
                    constrainImageLayout.setImageClickListener(this.HS);
                    constrainImageLayout.setFromCDN(this.Hx);
                    if (this.cSV > 0.0d) {
                        constrainImageLayout.setSingleImageRatio(this.cSV);
                    }
                    if (this.cSW == null) {
                        constrainImageLayout.setClickable(false);
                    } else {
                        constrainImageLayout.setOnClickListener(this.cSW);
                    }
                    constrainImageLayout.setSinglePicUseStyleV10(this.cSZ);
                    i = this.cST.a(constrainImageLayout, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void kx(int i) {
        int kw = this.cST.kw(i);
        int childCount = getChildCount() - kw;
        if (childCount > 0) {
            removeViews(kw, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private ConstrainImageLayout getConstrainImageLayout() {
        ConstrainImageLayout borrowObject = this.cSR.borrowObject();
        borrowObject.setImagePadding(this.cSU);
        borrowObject.setImageViewObjectPool(this.cSS);
        borrowObject.setImageMaxChildCount(-1);
        borrowObject.setExtraCenterText(null);
        borrowObject.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        borrowObject.setPageUniqueId(this.cJo);
        borrowObject.setPreloadSizeReadyCallback(this.cSX);
        return borrowObject;
    }

    public void onChangeSkinType() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ConstrainImageLayout) {
                ((ConstrainImageLayout) childAt).onChangeSkinType();
            }
        }
    }

    public void setImageProcessor(c cVar) {
        if (cVar != null) {
            this.cST = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cJo = bdUniqueId;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        if (!z) {
            setImageClickListener(null);
            setChildClickListener(null);
        }
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.cSX = bVar;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ConstrainImageLayout) {
                ((ConstrainImageLayout) childAt).setPreloadSizeReadyCallback(bVar);
            }
        }
    }

    public void setSinglePicUseStyleV10(boolean z) {
        this.cSZ = z;
    }
}
