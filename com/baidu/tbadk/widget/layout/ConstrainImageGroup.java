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
    private boolean aAQ;
    private BdUniqueId bag;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> bkM;
    private com.baidu.adp.lib.e.b<TbImageView> bkN;
    private b bkO;
    private int bkP;
    private double bkQ;
    private c bkR;
    private View.OnClickListener bkS;
    private com.baidu.adp.widget.a.b bkT;
    private ViewGroup.OnHierarchyChangeListener bkU;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.bkO = new a();
        this.aAQ = false;
        this.bkU = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.bkM != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.bkM.t(constrainImageLayout);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bkU);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bkO = new a();
        this.aAQ = false;
        this.bkU = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.bkM != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.bkM.t(constrainImageLayout);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bkU);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bkO = new a();
        this.aAQ = false;
        this.bkU = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.bkM != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.bkM.t(constrainImageLayout);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bkU);
    }

    public void setFromCDN(boolean z) {
        this.aAQ = z;
    }

    public void setSingleImageRatio(double d) {
        this.bkQ = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.bkS = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        this.bkM = bVar;
    }

    public void setImageClickListener(c cVar) {
        this.bkR = cVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof ConstrainImageLayout) {
                    ((ConstrainImageLayout) childAt).setImageClickListener(this.bkR);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.bkN = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.bkP = i;
        } else {
            this.bkP = 0;
        }
    }

    @Deprecated
    public void setImageUrls(List<String> list) {
        if (!v.I(list)) {
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
        if (!v.I(list) && this.bkM != null) {
            gr(v.H(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof ConstrainImageLayout) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) childAt;
                    constrainImageLayout.setImageClickListener(this.bkR);
                    constrainImageLayout.setFromCDN(this.aAQ);
                    if (this.bkQ > 0.0d) {
                        constrainImageLayout.setSingleImageRatio(this.bkQ);
                    }
                    if (this.bkS == null) {
                        constrainImageLayout.setClickable(false);
                    } else {
                        constrainImageLayout.setOnClickListener(this.bkS);
                    }
                    i = this.bkO.a(constrainImageLayout, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void gr(int i) {
        int gq = this.bkO.gq(i);
        int childCount = getChildCount() - gq;
        if (childCount > 0) {
            removeViews(gq, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private ConstrainImageLayout getConstrainImageLayout() {
        ConstrainImageLayout jy = this.bkM.jy();
        jy.setImagePadding(this.bkP);
        jy.setImageViewObjectPool(this.bkN);
        jy.setImageMaxChildCount(-1);
        jy.setExtraCenterText(null);
        jy.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        jy.setPageUniqueId(this.bag);
        jy.setPreloadSizeReadyCallback(this.bkT);
        return jy;
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

    public void setImageProcessor(b bVar) {
        if (bVar != null) {
            this.bkO = bVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.bag = bdUniqueId;
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
        this.bkT = bVar;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ConstrainImageLayout) {
                ((ConstrainImageLayout) childAt).setPreloadSizeReadyCallback(bVar);
            }
        }
    }
}
