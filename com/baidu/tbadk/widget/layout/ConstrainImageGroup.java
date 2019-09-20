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
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> cKi;
    private com.baidu.adp.lib.e.b<TbImageView> cKj;
    private c cKk;
    private int cKl;
    private double cKm;
    private View.OnClickListener cKn;
    private com.baidu.adp.widget.a.b cKo;
    private ViewGroup.OnHierarchyChangeListener cKp;
    private boolean cKq;
    private BdUniqueId cyA;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.cKk = new b();
        this.Yd = false;
        this.cKp = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.cKi != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.cKi.t(constrainImageLayout);
                }
            }
        };
        this.cKq = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.cKp);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cKk = new b();
        this.Yd = false;
        this.cKp = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.cKi != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.cKi.t(constrainImageLayout);
                }
            }
        };
        this.cKq = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.cKp);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cKk = new b();
        this.Yd = false;
        this.cKp = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.cKi != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.cKi.t(constrainImageLayout);
                }
            }
        };
        this.cKq = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.cKp);
    }

    public void setFromCDN(boolean z) {
        this.Yd = z;
    }

    public void setSingleImageRatio(double d) {
        this.cKm = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.cKn = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        this.cKi = bVar;
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
        this.cKj = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.cKl = i;
        } else {
            this.cKl = 0;
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
        if (!v.aa(list) && this.cKi != null) {
            lt(v.Z(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof ConstrainImageLayout) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) childAt;
                    constrainImageLayout.setImageClickListener(this.Yx);
                    constrainImageLayout.setFromCDN(this.Yd);
                    if (this.cKm > 0.0d) {
                        constrainImageLayout.setSingleImageRatio(this.cKm);
                    }
                    if (this.cKn == null) {
                        constrainImageLayout.setClickable(false);
                    } else {
                        constrainImageLayout.setOnClickListener(this.cKn);
                    }
                    constrainImageLayout.setSinglePicUseStyleV10(this.cKq);
                    i = this.cKk.a(constrainImageLayout, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void lt(int i) {
        int ls = this.cKk.ls(i);
        int childCount = getChildCount() - ls;
        if (childCount > 0) {
            removeViews(ls, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private ConstrainImageLayout getConstrainImageLayout() {
        ConstrainImageLayout iD = this.cKi.iD();
        iD.setImagePadding(this.cKl);
        iD.setImageViewObjectPool(this.cKj);
        iD.setImageMaxChildCount(-1);
        iD.setExtraCenterText(null);
        iD.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        iD.setPageUniqueId(this.cyA);
        iD.setPreloadSizeReadyCallback(this.cKo);
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
            this.cKk = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cyA = bdUniqueId;
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
        this.cKo = bVar;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ConstrainImageLayout) {
                ((ConstrainImageLayout) childAt).setPreloadSizeReadyCallback(bVar);
            }
        }
    }

    public void setSinglePicUseStyleV10(boolean z) {
        this.cKq = z;
    }
}
