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
    private boolean ZQ;
    private d aae;
    private BdUniqueId cnZ;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> czG;
    private com.baidu.adp.lib.e.b<TbImageView> czH;
    private c czI;
    private int czJ;
    private double czK;
    private View.OnClickListener czL;
    private com.baidu.adp.widget.a.b czM;
    private ViewGroup.OnHierarchyChangeListener czN;
    private boolean czO;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.czI = new b();
        this.ZQ = false;
        this.czN = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.czG != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.czG.t(constrainImageLayout);
                }
            }
        };
        this.czO = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.czN);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.czI = new b();
        this.ZQ = false;
        this.czN = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.czG != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.czG.t(constrainImageLayout);
                }
            }
        };
        this.czO = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.czN);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.czI = new b();
        this.ZQ = false;
        this.czN = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.czG != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.czG.t(constrainImageLayout);
                }
            }
        };
        this.czO = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.czN);
    }

    public void setFromCDN(boolean z) {
        this.ZQ = z;
    }

    public void setSingleImageRatio(double d) {
        this.czK = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.czL = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        this.czG = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.aae = dVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof ConstrainImageLayout) {
                    ((ConstrainImageLayout) childAt).setImageClickListener(this.aae);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.czH = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.czJ = i;
        } else {
            this.czJ = 0;
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
        if (!v.T(list) && this.czG != null) {
            kt(v.S(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof ConstrainImageLayout) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) childAt;
                    constrainImageLayout.setImageClickListener(this.aae);
                    constrainImageLayout.setFromCDN(this.ZQ);
                    if (this.czK > 0.0d) {
                        constrainImageLayout.setSingleImageRatio(this.czK);
                    }
                    if (this.czL == null) {
                        constrainImageLayout.setClickable(false);
                    } else {
                        constrainImageLayout.setOnClickListener(this.czL);
                    }
                    constrainImageLayout.setSinglePicUseStyleV10(this.czO);
                    i = this.czI.a(constrainImageLayout, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void kt(int i) {
        int ks = this.czI.ks(i);
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
        ConstrainImageLayout jA = this.czG.jA();
        jA.setImagePadding(this.czJ);
        jA.setImageViewObjectPool(this.czH);
        jA.setImageMaxChildCount(-1);
        jA.setExtraCenterText(null);
        jA.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        jA.setPageUniqueId(this.cnZ);
        jA.setPreloadSizeReadyCallback(this.czM);
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
            this.czI = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cnZ = bdUniqueId;
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
        this.czM = bVar;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ConstrainImageLayout) {
                ((ConstrainImageLayout) childAt).setPreloadSizeReadyCallback(bVar);
            }
        }
    }

    public void setSinglePicUseStyleV10(boolean z) {
        this.czO = z;
    }
}
