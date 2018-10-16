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
    private boolean aAb;
    private BdUniqueId aZt;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> bkb;
    private com.baidu.adp.lib.e.b<TbImageView> bkc;
    private b bkd;
    private int bke;
    private double bkf;
    private c bkg;
    private View.OnClickListener bkh;
    private com.baidu.adp.widget.a.b bki;
    private ViewGroup.OnHierarchyChangeListener bkj;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.bkd = new a();
        this.aAb = false;
        this.bkj = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.bkb != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.bkb.t(constrainImageLayout);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bkj);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bkd = new a();
        this.aAb = false;
        this.bkj = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.bkb != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.bkb.t(constrainImageLayout);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bkj);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bkd = new a();
        this.aAb = false;
        this.bkj = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.bkb != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.bkb.t(constrainImageLayout);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bkj);
    }

    public void setFromCDN(boolean z) {
        this.aAb = z;
    }

    public void setSingleImageRatio(double d) {
        this.bkf = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.bkh = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        this.bkb = bVar;
    }

    public void setImageClickListener(c cVar) {
        this.bkg = cVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof ConstrainImageLayout) {
                    ((ConstrainImageLayout) childAt).setImageClickListener(this.bkg);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.bkc = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.bke = i;
        } else {
            this.bke = 0;
        }
    }

    @Deprecated
    public void setImageUrls(List<String> list) {
        if (!v.J(list)) {
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
        if (!v.J(list) && this.bkb != null) {
            gd(v.I(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof ConstrainImageLayout) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) childAt;
                    constrainImageLayout.setImageClickListener(this.bkg);
                    constrainImageLayout.setFromCDN(this.aAb);
                    if (this.bkf > 0.0d) {
                        constrainImageLayout.setSingleImageRatio(this.bkf);
                    }
                    if (this.bkh == null) {
                        constrainImageLayout.setClickable(false);
                    } else {
                        constrainImageLayout.setOnClickListener(this.bkh);
                    }
                    i = this.bkd.a(constrainImageLayout, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void gd(int i) {
        int gc = this.bkd.gc(i);
        int childCount = getChildCount() - gc;
        if (childCount > 0) {
            removeViews(gc, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private ConstrainImageLayout getConstrainImageLayout() {
        ConstrainImageLayout jA = this.bkb.jA();
        jA.setImagePadding(this.bke);
        jA.setImageViewObjectPool(this.bkc);
        jA.setImageMaxChildCount(-1);
        jA.setExtraCenterText(null);
        jA.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        jA.setPageUniqueId(this.aZt);
        jA.setPreloadSizeReadyCallback(this.bki);
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

    public void setImageProcessor(b bVar) {
        if (bVar != null) {
            this.bkd = bVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aZt = bdUniqueId;
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
        this.bki = bVar;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ConstrainImageLayout) {
                ((ConstrainImageLayout) childAt).setPreloadSizeReadyCallback(bVar);
            }
        }
    }
}
