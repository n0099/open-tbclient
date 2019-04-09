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
    private boolean ZR;
    private d aaf;
    private BdUniqueId coa;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> czH;
    private com.baidu.adp.lib.e.b<TbImageView> czI;
    private c czJ;
    private int czK;
    private double czL;
    private View.OnClickListener czM;
    private com.baidu.adp.widget.a.b czN;
    private ViewGroup.OnHierarchyChangeListener czO;
    private boolean czP;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.czJ = new b();
        this.ZR = false;
        this.czO = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.czH != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.czH.t(constrainImageLayout);
                }
            }
        };
        this.czP = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.czO);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.czJ = new b();
        this.ZR = false;
        this.czO = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.czH != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.czH.t(constrainImageLayout);
                }
            }
        };
        this.czP = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.czO);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.czJ = new b();
        this.ZR = false;
        this.czO = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.czH != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.czH.t(constrainImageLayout);
                }
            }
        };
        this.czP = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.czO);
    }

    public void setFromCDN(boolean z) {
        this.ZR = z;
    }

    public void setSingleImageRatio(double d) {
        this.czL = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.czM = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        this.czH = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.aaf = dVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof ConstrainImageLayout) {
                    ((ConstrainImageLayout) childAt).setImageClickListener(this.aaf);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.czI = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.czK = i;
        } else {
            this.czK = 0;
        }
    }

    @Deprecated
    public void setImageUrls(List<String> list) {
        if (!v.T(list)) {
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
        if (!v.T(list) && this.czH != null) {
            kt(v.S(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof ConstrainImageLayout) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) childAt;
                    constrainImageLayout.setImageClickListener(this.aaf);
                    constrainImageLayout.setFromCDN(this.ZR);
                    if (this.czL > 0.0d) {
                        constrainImageLayout.setSingleImageRatio(this.czL);
                    }
                    if (this.czM == null) {
                        constrainImageLayout.setClickable(false);
                    } else {
                        constrainImageLayout.setOnClickListener(this.czM);
                    }
                    constrainImageLayout.setSinglePicUseStyleV10(this.czP);
                    i = this.czJ.a(constrainImageLayout, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void kt(int i) {
        int ks = this.czJ.ks(i);
        int childCount = getChildCount() - ks;
        if (childCount > 0) {
            removeViews(ks, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private ConstrainImageLayout getConstrainImageLayout() {
        ConstrainImageLayout jA = this.czH.jA();
        jA.setImagePadding(this.czK);
        jA.setImageViewObjectPool(this.czI);
        jA.setImageMaxChildCount(-1);
        jA.setExtraCenterText(null);
        jA.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        jA.setPageUniqueId(this.coa);
        jA.setPreloadSizeReadyCallback(this.czN);
        return jA;
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
            this.czJ = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.coa = bdUniqueId;
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
        this.czN = bVar;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ConstrainImageLayout) {
                ((ConstrainImageLayout) childAt).setPreloadSizeReadyCallback(bVar);
            }
        }
    }

    public void setSinglePicUseStyleV10(boolean z) {
        this.czP = z;
    }
}
