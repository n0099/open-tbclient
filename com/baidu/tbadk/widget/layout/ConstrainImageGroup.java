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
    private BdUniqueId aTr;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> aTs;
    private com.baidu.adp.lib.e.b<TbImageView> aTt;
    private b aTu;
    private int aTv;
    private double aTw;
    private c aTx;
    private View.OnClickListener aTy;
    private ViewGroup.OnHierarchyChangeListener aTz;
    private boolean akC;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.aTu = new a();
        this.akC = false;
        this.aTz = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view2, View view3) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view2, View view3) {
                if ((view3 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.aTs != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view3;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.aTs.m(constrainImageLayout);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aTz);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aTu = new a();
        this.akC = false;
        this.aTz = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view2, View view3) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view2, View view3) {
                if ((view3 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.aTs != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view3;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.aTs.m(constrainImageLayout);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aTz);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aTu = new a();
        this.akC = false;
        this.aTz = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view2, View view3) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view2, View view3) {
                if ((view3 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.aTs != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view3;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.aTs.m(constrainImageLayout);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aTz);
    }

    public void setFromCDN(boolean z) {
        this.akC = z;
    }

    public void setSingleImageRatio(double d) {
        this.aTw = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.aTy = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        this.aTs = bVar;
    }

    public void setImageClickListener(c cVar) {
        this.aTx = cVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof ConstrainImageLayout) {
                    ((ConstrainImageLayout) childAt).setImageClickListener(this.aTx);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aTt = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.aTv = i;
        } else {
            this.aTv = 0;
        }
    }

    @Deprecated
    public void setImageUrls(List<String> list) {
        if (!v.w(list)) {
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
        if (!v.w(list) && this.aTs != null) {
            fF(v.v(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof ConstrainImageLayout) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) childAt;
                    constrainImageLayout.setImageClickListener(this.aTx);
                    constrainImageLayout.setFromCDN(this.akC);
                    if (this.aTw > 0.0d) {
                        constrainImageLayout.setSingleImageRatio(this.aTw);
                    }
                    if (this.aTy == null) {
                        constrainImageLayout.setClickable(false);
                    } else {
                        constrainImageLayout.setOnClickListener(this.aTy);
                    }
                    i = this.aTu.a(constrainImageLayout, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void fF(int i) {
        int fE = this.aTu.fE(i);
        int childCount = getChildCount() - fE;
        if (childCount > 0) {
            removeViews(fE, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private ConstrainImageLayout getConstrainImageLayout() {
        ConstrainImageLayout fn = this.aTs.fn();
        fn.setImagePadding(this.aTv);
        fn.setImageViewObjectPool(this.aTt);
        fn.setImageMaxChildCount(-1);
        fn.setExtraCenterText(null);
        fn.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        fn.setPageUniqueId(this.aTr);
        return fn;
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
            this.aTu = bVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aTr = bdUniqueId;
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
