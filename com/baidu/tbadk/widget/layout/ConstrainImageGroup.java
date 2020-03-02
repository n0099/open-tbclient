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
    private boolean NJ;
    private d Ok;
    private BdUniqueId dBk;
    private double dLA;
    private View.OnClickListener dLB;
    private com.baidu.adp.widget.a.b dLC;
    private ViewGroup.OnHierarchyChangeListener dLD;
    private boolean dLE;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> dLw;
    private com.baidu.adp.lib.d.b<TbImageView> dLx;
    private c dLy;
    private int dLz;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.dLy = new b();
        this.NJ = false;
        this.dLD = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.dLw != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.dLw.returnObject(constrainImageLayout);
                }
            }
        };
        this.dLE = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.dLD);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dLy = new b();
        this.NJ = false;
        this.dLD = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.dLw != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.dLw.returnObject(constrainImageLayout);
                }
            }
        };
        this.dLE = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.dLD);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dLy = new b();
        this.NJ = false;
        this.dLD = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.dLw != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.dLw.returnObject(constrainImageLayout);
                }
            }
        };
        this.dLE = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.dLD);
    }

    public void setFromCDN(boolean z) {
        this.NJ = z;
    }

    public void setSingleImageRatio(double d) {
        this.dLA = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.dLB = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        this.dLw = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.Ok = dVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof ConstrainImageLayout) {
                    ((ConstrainImageLayout) childAt).setImageClickListener(this.Ok);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        this.dLx = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.dLz = i;
        } else {
            this.dLz = 0;
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
        if (!v.isEmpty(list) && this.dLw != null) {
            nd(v.getCount(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof ConstrainImageLayout) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) childAt;
                    constrainImageLayout.setImageClickListener(this.Ok);
                    constrainImageLayout.setFromCDN(this.NJ);
                    if (this.dLA > 0.0d) {
                        constrainImageLayout.setSingleImageRatio(this.dLA);
                    }
                    if (this.dLB == null) {
                        constrainImageLayout.setClickable(false);
                    } else {
                        constrainImageLayout.setOnClickListener(this.dLB);
                    }
                    constrainImageLayout.setSinglePicUseStyleV10(this.dLE);
                    i = this.dLy.a(constrainImageLayout, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void nd(int i) {
        int nc = this.dLy.nc(i);
        int childCount = getChildCount() - nc;
        if (childCount > 0) {
            removeViews(nc, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private ConstrainImageLayout getConstrainImageLayout() {
        ConstrainImageLayout borrowObject = this.dLw.borrowObject();
        borrowObject.setImagePadding(this.dLz);
        borrowObject.setImageViewObjectPool(this.dLx);
        borrowObject.setImageMaxChildCount(-1);
        borrowObject.setExtraCenterText(null);
        borrowObject.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        borrowObject.setPageUniqueId(this.dBk);
        borrowObject.setPreloadSizeReadyCallback(this.dLC);
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
            this.dLy = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dBk = bdUniqueId;
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
        this.dLC = bVar;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ConstrainImageLayout) {
                ((ConstrainImageLayout) childAt).setPreloadSizeReadyCallback(bVar);
            }
        }
    }

    public void setSinglePicUseStyleV10(boolean z) {
        this.dLE = z;
    }
}
