package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ConstrainImageGroup extends LinearLayout {
    private BdUniqueId aRC;
    private boolean asS;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> bcr;
    private com.baidu.adp.lib.e.b<TbImageView> bcs;
    private b bct;
    private int bcu;
    private double bcv;
    private c bcw;
    private View.OnClickListener bcx;
    private ViewGroup.OnHierarchyChangeListener bcy;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.bct = new a();
        this.asS = false;
        this.bcy = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.bcr != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.bcr.p(constrainImageLayout);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bcy);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bct = new a();
        this.asS = false;
        this.bcy = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.bcr != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.bcr.p(constrainImageLayout);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bcy);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bct = new a();
        this.asS = false;
        this.bcy = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.bcr != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.bcr.p(constrainImageLayout);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bcy);
    }

    public void setFromCDN(boolean z) {
        this.asS = z;
    }

    public void setSingleImageRatio(double d) {
        this.bcv = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.bcx = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        this.bcr = bVar;
    }

    public void setImageClickListener(c cVar) {
        this.bcw = cVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof ConstrainImageLayout) {
                    ((ConstrainImageLayout) childAt).setImageClickListener(this.bcw);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.bcs = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.bcu = i;
        } else {
            this.bcu = 0;
        }
    }

    @Deprecated
    public void setImageUrls(List<String> list) {
        if (!w.z(list)) {
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
        if (!w.z(list) && this.bcr != null) {
            fI(w.y(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof ConstrainImageLayout) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) childAt;
                    constrainImageLayout.setImageClickListener(this.bcw);
                    constrainImageLayout.setFromCDN(this.asS);
                    if (this.bcv > 0.0d) {
                        constrainImageLayout.setSingleImageRatio(this.bcv);
                    }
                    if (this.bcx == null) {
                        constrainImageLayout.setClickable(false);
                    } else {
                        constrainImageLayout.setOnClickListener(this.bcx);
                    }
                    i = this.bct.a(constrainImageLayout, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void fI(int i) {
        int fH = this.bct.fH(i);
        int childCount = getChildCount() - fH;
        if (childCount > 0) {
            removeViews(fH, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private ConstrainImageLayout getConstrainImageLayout() {
        ConstrainImageLayout m9if = this.bcr.m9if();
        m9if.setImagePadding(this.bcu);
        m9if.setImageViewObjectPool(this.bcs);
        m9if.setImageMaxChildCount(-1);
        m9if.setExtraCenterText(null);
        m9if.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        m9if.setPageUniqueId(this.aRC);
        return m9if;
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
            this.bct = bVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aRC = bdUniqueId;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        if (!z) {
            setImageClickListener(null);
            setChildClickListener(null);
        }
    }
}
