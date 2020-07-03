package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ConstrainImageGroup extends LinearLayout {
    private d aiH;
    private boolean aik;
    private com.baidu.adp.widget.a.b eKA;
    private ViewGroup.OnHierarchyChangeListener eKB;
    private boolean eKC;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> eKu;
    private com.baidu.adp.lib.d.b<TbImageView> eKv;
    private c eKw;
    private int eKx;
    private double eKy;
    private View.OnClickListener eKz;
    private BdUniqueId eyE;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.eKw = new b();
        this.aik = false;
        this.eKB = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.eKu != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.eKu.returnObject(constrainImageLayout);
                }
            }
        };
        this.eKC = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.eKB);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eKw = new b();
        this.aik = false;
        this.eKB = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.eKu != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.eKu.returnObject(constrainImageLayout);
                }
            }
        };
        this.eKC = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.eKB);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eKw = new b();
        this.aik = false;
        this.eKB = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.eKu != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.eKu.returnObject(constrainImageLayout);
                }
            }
        };
        this.eKC = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.eKB);
    }

    public void setFromCDN(boolean z) {
        this.aik = z;
    }

    public void setSingleImageRatio(double d) {
        this.eKy = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.eKz = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        this.eKu = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.aiH = dVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof ConstrainImageLayout) {
                    ((ConstrainImageLayout) childAt).setImageClickListener(this.aiH);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        this.eKv = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.eKx = i;
        } else {
            this.eKx = 0;
        }
    }

    @Deprecated
    public void setImageUrls(List<String> list) {
        if (!w.isEmpty(list)) {
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
        if (!w.isEmpty(list) && this.eKu != null) {
            ot(w.getCount(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof ConstrainImageLayout) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) childAt;
                    constrainImageLayout.setImageClickListener(this.aiH);
                    constrainImageLayout.setFromCDN(this.aik);
                    if (this.eKy > 0.0d) {
                        constrainImageLayout.setSingleImageRatio(this.eKy);
                    }
                    if (this.eKz == null) {
                        constrainImageLayout.setClickable(false);
                    } else {
                        constrainImageLayout.setOnClickListener(this.eKz);
                    }
                    constrainImageLayout.setSinglePicUseStyleV10(this.eKC);
                    i = this.eKw.a(constrainImageLayout, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void ot(int i) {
        int os = this.eKw.os(i);
        int childCount = getChildCount() - os;
        if (childCount > 0) {
            removeViews(os, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private ConstrainImageLayout getConstrainImageLayout() {
        ConstrainImageLayout borrowObject = this.eKu.borrowObject();
        borrowObject.setImagePadding(this.eKx);
        borrowObject.setImageViewObjectPool(this.eKv);
        borrowObject.setImageMaxChildCount(-1);
        borrowObject.setExtraCenterText(null);
        borrowObject.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        borrowObject.setPageUniqueId(this.eyE);
        borrowObject.setPreloadSizeReadyCallback(this.eKA);
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
            this.eKw = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.eyE = bdUniqueId;
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
        this.eKA = bVar;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ConstrainImageLayout) {
                ((ConstrainImageLayout) childAt).setPreloadSizeReadyCallback(bVar);
            }
        }
    }

    public void setSinglePicUseStyleV10(boolean z) {
        this.eKC = z;
    }
}
