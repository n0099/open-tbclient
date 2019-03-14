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
    private boolean ZP;
    private d aad;
    private BdUniqueId cnX;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> czE;
    private com.baidu.adp.lib.e.b<TbImageView> czF;
    private c czG;
    private int czH;
    private double czI;
    private View.OnClickListener czJ;
    private com.baidu.adp.widget.a.b czK;
    private ViewGroup.OnHierarchyChangeListener czL;
    private boolean czM;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.czG = new b();
        this.ZP = false;
        this.czL = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.czE != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.czE.t(constrainImageLayout);
                }
            }
        };
        this.czM = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.czL);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.czG = new b();
        this.ZP = false;
        this.czL = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.czE != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.czE.t(constrainImageLayout);
                }
            }
        };
        this.czM = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.czL);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.czG = new b();
        this.ZP = false;
        this.czL = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.czE != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.czE.t(constrainImageLayout);
                }
            }
        };
        this.czM = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.czL);
    }

    public void setFromCDN(boolean z) {
        this.ZP = z;
    }

    public void setSingleImageRatio(double d) {
        this.czI = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.czJ = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        this.czE = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.aad = dVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof ConstrainImageLayout) {
                    ((ConstrainImageLayout) childAt).setImageClickListener(this.aad);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.czF = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.czH = i;
        } else {
            this.czH = 0;
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
        if (!v.T(list) && this.czE != null) {
            ku(v.S(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof ConstrainImageLayout) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) childAt;
                    constrainImageLayout.setImageClickListener(this.aad);
                    constrainImageLayout.setFromCDN(this.ZP);
                    if (this.czI > 0.0d) {
                        constrainImageLayout.setSingleImageRatio(this.czI);
                    }
                    if (this.czJ == null) {
                        constrainImageLayout.setClickable(false);
                    } else {
                        constrainImageLayout.setOnClickListener(this.czJ);
                    }
                    constrainImageLayout.setSinglePicUseStyleV10(this.czM);
                    i = this.czG.a(constrainImageLayout, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void ku(int i) {
        int kt = this.czG.kt(i);
        int childCount = getChildCount() - kt;
        if (childCount > 0) {
            removeViews(kt, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private ConstrainImageLayout getConstrainImageLayout() {
        ConstrainImageLayout jA = this.czE.jA();
        jA.setImagePadding(this.czH);
        jA.setImageViewObjectPool(this.czF);
        jA.setImageMaxChildCount(-1);
        jA.setExtraCenterText(null);
        jA.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        jA.setPageUniqueId(this.cnX);
        jA.setPreloadSizeReadyCallback(this.czK);
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
            this.czG = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cnX = bdUniqueId;
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
        this.czK = bVar;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ConstrainImageLayout) {
                ((ConstrainImageLayout) childAt).setPreloadSizeReadyCallback(bVar);
            }
        }
    }

    public void setSinglePicUseStyleV10(boolean z) {
        this.czM = z;
    }
}
