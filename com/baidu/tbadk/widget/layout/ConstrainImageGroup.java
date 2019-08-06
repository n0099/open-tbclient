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
    private boolean Yd;
    private d Yx;
    private boolean cJA;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> cJs;
    private com.baidu.adp.lib.e.b<TbImageView> cJt;
    private c cJu;
    private int cJv;
    private double cJw;
    private View.OnClickListener cJx;
    private com.baidu.adp.widget.a.b cJy;
    private ViewGroup.OnHierarchyChangeListener cJz;
    private BdUniqueId cxE;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.cJu = new b();
        this.Yd = false;
        this.cJz = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.cJs != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.cJs.t(constrainImageLayout);
                }
            }
        };
        this.cJA = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.cJz);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cJu = new b();
        this.Yd = false;
        this.cJz = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.cJs != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.cJs.t(constrainImageLayout);
                }
            }
        };
        this.cJA = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.cJz);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cJu = new b();
        this.Yd = false;
        this.cJz = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.cJs != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.cJs.t(constrainImageLayout);
                }
            }
        };
        this.cJA = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.cJz);
    }

    public void setFromCDN(boolean z) {
        this.Yd = z;
    }

    public void setSingleImageRatio(double d) {
        this.cJw = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.cJx = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        this.cJs = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.Yx = dVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof ConstrainImageLayout) {
                    ((ConstrainImageLayout) childAt).setImageClickListener(this.Yx);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.cJt = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.cJv = i;
        } else {
            this.cJv = 0;
        }
    }

    @Deprecated
    public void setImageUrls(List<String> list) {
        if (!v.aa(list)) {
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
        if (!v.aa(list) && this.cJs != null) {
            lp(v.Z(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof ConstrainImageLayout) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) childAt;
                    constrainImageLayout.setImageClickListener(this.Yx);
                    constrainImageLayout.setFromCDN(this.Yd);
                    if (this.cJw > 0.0d) {
                        constrainImageLayout.setSingleImageRatio(this.cJw);
                    }
                    if (this.cJx == null) {
                        constrainImageLayout.setClickable(false);
                    } else {
                        constrainImageLayout.setOnClickListener(this.cJx);
                    }
                    constrainImageLayout.setSinglePicUseStyleV10(this.cJA);
                    i = this.cJu.a(constrainImageLayout, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void lp(int i) {
        int lo = this.cJu.lo(i);
        int childCount = getChildCount() - lo;
        if (childCount > 0) {
            removeViews(lo, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private ConstrainImageLayout getConstrainImageLayout() {
        ConstrainImageLayout iD = this.cJs.iD();
        iD.setImagePadding(this.cJv);
        iD.setImageViewObjectPool(this.cJt);
        iD.setImageMaxChildCount(-1);
        iD.setExtraCenterText(null);
        iD.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        iD.setPageUniqueId(this.cxE);
        iD.setPreloadSizeReadyCallback(this.cJy);
        return iD;
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
            this.cJu = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cxE = bdUniqueId;
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
        this.cJy = bVar;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ConstrainImageLayout) {
                ((ConstrainImageLayout) childAt).setPreloadSizeReadyCallback(bVar);
            }
        }
    }

    public void setSinglePicUseStyleV10(boolean z) {
        this.cJA = z;
    }
}
