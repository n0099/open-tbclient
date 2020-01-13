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
    private d NI;
    private boolean Nj;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> dHq;
    private com.baidu.adp.lib.d.b<TbImageView> dHr;
    private c dHs;
    private int dHt;
    private double dHu;
    private View.OnClickListener dHv;
    private com.baidu.adp.widget.a.b dHw;
    private ViewGroup.OnHierarchyChangeListener dHx;
    private boolean dHy;
    private BdUniqueId dxg;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.dHs = new b();
        this.Nj = false;
        this.dHx = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.dHq != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.dHq.returnObject(constrainImageLayout);
                }
            }
        };
        this.dHy = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.dHx);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dHs = new b();
        this.Nj = false;
        this.dHx = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.dHq != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.dHq.returnObject(constrainImageLayout);
                }
            }
        };
        this.dHy = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.dHx);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dHs = new b();
        this.Nj = false;
        this.dHx = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.dHq != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.dHq.returnObject(constrainImageLayout);
                }
            }
        };
        this.dHy = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.dHx);
    }

    public void setFromCDN(boolean z) {
        this.Nj = z;
    }

    public void setSingleImageRatio(double d) {
        this.dHu = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.dHv = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        this.dHq = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.NI = dVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof ConstrainImageLayout) {
                    ((ConstrainImageLayout) childAt).setImageClickListener(this.NI);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        this.dHr = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.dHt = i;
        } else {
            this.dHt = 0;
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
        if (!v.isEmpty(list) && this.dHq != null) {
            mM(v.getCount(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof ConstrainImageLayout) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) childAt;
                    constrainImageLayout.setImageClickListener(this.NI);
                    constrainImageLayout.setFromCDN(this.Nj);
                    if (this.dHu > 0.0d) {
                        constrainImageLayout.setSingleImageRatio(this.dHu);
                    }
                    if (this.dHv == null) {
                        constrainImageLayout.setClickable(false);
                    } else {
                        constrainImageLayout.setOnClickListener(this.dHv);
                    }
                    constrainImageLayout.setSinglePicUseStyleV10(this.dHy);
                    i = this.dHs.a(constrainImageLayout, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void mM(int i) {
        int mL = this.dHs.mL(i);
        int childCount = getChildCount() - mL;
        if (childCount > 0) {
            removeViews(mL, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private ConstrainImageLayout getConstrainImageLayout() {
        ConstrainImageLayout borrowObject = this.dHq.borrowObject();
        borrowObject.setImagePadding(this.dHt);
        borrowObject.setImageViewObjectPool(this.dHr);
        borrowObject.setImageMaxChildCount(-1);
        borrowObject.setExtraCenterText(null);
        borrowObject.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        borrowObject.setPageUniqueId(this.dxg);
        borrowObject.setPreloadSizeReadyCallback(this.dHw);
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
            this.dHs = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dxg = bdUniqueId;
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
        this.dHw = bVar;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ConstrainImageLayout) {
                ((ConstrainImageLayout) childAt).setPreloadSizeReadyCallback(bVar);
            }
        }
    }

    public void setSinglePicUseStyleV10(boolean z) {
        this.dHy = z;
    }
}
