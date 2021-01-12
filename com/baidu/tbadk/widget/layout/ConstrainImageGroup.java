package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ConstrainImageGroup extends LinearLayout {
    private boolean akY;
    private d alA;
    private BdUniqueId fEN;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> fRh;
    private com.baidu.adp.lib.d.b<TbImageView> fRi;
    private c fRj;
    private int fRk;
    private double fRl;
    private View.OnClickListener fRm;
    private com.baidu.adp.widget.a.b fRn;
    private ViewGroup.OnHierarchyChangeListener fRo;
    private boolean fRp;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.fRj = new b();
        this.akY = false;
        this.fRo = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.fRh != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.fRh.returnObject(constrainImageLayout);
                }
            }
        };
        this.fRp = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.fRo);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fRj = new b();
        this.akY = false;
        this.fRo = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.fRh != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.fRh.returnObject(constrainImageLayout);
                }
            }
        };
        this.fRp = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.fRo);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fRj = new b();
        this.akY = false;
        this.fRo = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.fRh != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.fRh.returnObject(constrainImageLayout);
                }
            }
        };
        this.fRp = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.fRo);
    }

    public void setFromCDN(boolean z) {
        this.akY = z;
    }

    public void setSingleImageRatio(double d) {
        this.fRl = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.fRm = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        this.fRh = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.alA = dVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof ConstrainImageLayout) {
                    ((ConstrainImageLayout) childAt).setImageClickListener(this.alA);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        this.fRi = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.fRk = i;
        } else {
            this.fRk = 0;
        }
    }

    @Deprecated
    public void setImageUrls(List<String> list) {
        if (!x.isEmpty(list)) {
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
        if (!x.isEmpty(list) && this.fRh != null) {
            rO(x.getCount(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof ConstrainImageLayout) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) childAt;
                    constrainImageLayout.setImageClickListener(this.alA);
                    constrainImageLayout.setFromCDN(this.akY);
                    if (this.fRl > 0.0d) {
                        constrainImageLayout.setSingleImageRatio(this.fRl);
                    }
                    if (this.fRm == null) {
                        constrainImageLayout.setClickable(false);
                    } else {
                        constrainImageLayout.setOnClickListener(this.fRm);
                    }
                    constrainImageLayout.setSinglePicUseStyleV10(this.fRp);
                    i = this.fRj.a(constrainImageLayout, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void rO(int i) {
        int rN = this.fRj.rN(i);
        int childCount = getChildCount() - rN;
        if (childCount > 0) {
            removeViews(rN, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private ConstrainImageLayout getConstrainImageLayout() {
        ConstrainImageLayout borrowObject = this.fRh.borrowObject();
        borrowObject.setImagePadding(this.fRk);
        borrowObject.setImageViewObjectPool(this.fRi);
        borrowObject.setImageMaxChildCount(-1);
        borrowObject.setExtraCenterText(null);
        borrowObject.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        borrowObject.setPageUniqueId(this.fEN);
        borrowObject.setPreloadSizeReadyCallback(this.fRn);
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
            this.fRj = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fEN = bdUniqueId;
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
        this.fRn = bVar;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ConstrainImageLayout) {
                ((ConstrainImageLayout) childAt).setPreloadSizeReadyCallback(bVar);
            }
        }
    }

    public void setSinglePicUseStyleV10(boolean z) {
        this.fRp = z;
    }
}
