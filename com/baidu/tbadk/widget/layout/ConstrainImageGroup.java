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
    private boolean aib;
    private d aiz;
    private BdUniqueId eEU;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> eQQ;
    private com.baidu.adp.lib.d.b<TbImageView> eQR;
    private c eQS;
    private int eQT;
    private double eQU;
    private View.OnClickListener eQV;
    private com.baidu.adp.widget.a.b eQW;
    private ViewGroup.OnHierarchyChangeListener eQX;
    private boolean eQY;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.eQS = new b();
        this.aib = false;
        this.eQX = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.eQQ != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.eQQ.returnObject(constrainImageLayout);
                }
            }
        };
        this.eQY = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.eQX);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eQS = new b();
        this.aib = false;
        this.eQX = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.eQQ != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.eQQ.returnObject(constrainImageLayout);
                }
            }
        };
        this.eQY = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.eQX);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eQS = new b();
        this.aib = false;
        this.eQX = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.eQQ != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.eQQ.returnObject(constrainImageLayout);
                }
            }
        };
        this.eQY = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.eQX);
    }

    public void setFromCDN(boolean z) {
        this.aib = z;
    }

    public void setSingleImageRatio(double d) {
        this.eQU = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.eQV = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        this.eQQ = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.aiz = dVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof ConstrainImageLayout) {
                    ((ConstrainImageLayout) childAt).setImageClickListener(this.aiz);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        this.eQR = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.eQT = i;
        } else {
            this.eQT = 0;
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
        if (!x.isEmpty(list) && this.eQQ != null) {
            oM(x.getCount(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof ConstrainImageLayout) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) childAt;
                    constrainImageLayout.setImageClickListener(this.aiz);
                    constrainImageLayout.setFromCDN(this.aib);
                    if (this.eQU > 0.0d) {
                        constrainImageLayout.setSingleImageRatio(this.eQU);
                    }
                    if (this.eQV == null) {
                        constrainImageLayout.setClickable(false);
                    } else {
                        constrainImageLayout.setOnClickListener(this.eQV);
                    }
                    constrainImageLayout.setSinglePicUseStyleV10(this.eQY);
                    i = this.eQS.a(constrainImageLayout, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void oM(int i) {
        int oL = this.eQS.oL(i);
        int childCount = getChildCount() - oL;
        if (childCount > 0) {
            removeViews(oL, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private ConstrainImageLayout getConstrainImageLayout() {
        ConstrainImageLayout borrowObject = this.eQQ.borrowObject();
        borrowObject.setImagePadding(this.eQT);
        borrowObject.setImageViewObjectPool(this.eQR);
        borrowObject.setImageMaxChildCount(-1);
        borrowObject.setExtraCenterText(null);
        borrowObject.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        borrowObject.setPageUniqueId(this.eEU);
        borrowObject.setPreloadSizeReadyCallback(this.eQW);
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
            this.eQS = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.eEU = bdUniqueId;
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
        this.eQW = bVar;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ConstrainImageLayout) {
                ((ConstrainImageLayout) childAt).setPreloadSizeReadyCallback(bVar);
            }
        }
    }

    public void setSinglePicUseStyleV10(boolean z) {
        this.eQY = z;
    }
}
