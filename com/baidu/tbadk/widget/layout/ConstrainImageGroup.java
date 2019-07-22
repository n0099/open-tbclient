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
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> cJl;
    private com.baidu.adp.lib.e.b<TbImageView> cJm;
    private c cJn;
    private int cJo;
    private double cJp;
    private View.OnClickListener cJq;
    private com.baidu.adp.widget.a.b cJr;
    private ViewGroup.OnHierarchyChangeListener cJs;
    private boolean cJt;
    private BdUniqueId cxx;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.cJn = new b();
        this.Yd = false;
        this.cJs = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.cJl != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.cJl.t(constrainImageLayout);
                }
            }
        };
        this.cJt = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.cJs);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cJn = new b();
        this.Yd = false;
        this.cJs = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.cJl != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.cJl.t(constrainImageLayout);
                }
            }
        };
        this.cJt = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.cJs);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cJn = new b();
        this.Yd = false;
        this.cJs = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.cJl != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.cJl.t(constrainImageLayout);
                }
            }
        };
        this.cJt = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.cJs);
    }

    public void setFromCDN(boolean z) {
        this.Yd = z;
    }

    public void setSingleImageRatio(double d) {
        this.cJp = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.cJq = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        this.cJl = bVar;
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
        this.cJm = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.cJo = i;
        } else {
            this.cJo = 0;
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
        if (!v.aa(list) && this.cJl != null) {
            lo(v.Z(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof ConstrainImageLayout) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) childAt;
                    constrainImageLayout.setImageClickListener(this.Yx);
                    constrainImageLayout.setFromCDN(this.Yd);
                    if (this.cJp > 0.0d) {
                        constrainImageLayout.setSingleImageRatio(this.cJp);
                    }
                    if (this.cJq == null) {
                        constrainImageLayout.setClickable(false);
                    } else {
                        constrainImageLayout.setOnClickListener(this.cJq);
                    }
                    constrainImageLayout.setSinglePicUseStyleV10(this.cJt);
                    i = this.cJn.a(constrainImageLayout, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void lo(int i) {
        int ln = this.cJn.ln(i);
        int childCount = getChildCount() - ln;
        if (childCount > 0) {
            removeViews(ln, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private ConstrainImageLayout getConstrainImageLayout() {
        ConstrainImageLayout iD = this.cJl.iD();
        iD.setImagePadding(this.cJo);
        iD.setImageViewObjectPool(this.cJm);
        iD.setImageMaxChildCount(-1);
        iD.setExtraCenterText(null);
        iD.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        iD.setPageUniqueId(this.cxx);
        iD.setPreloadSizeReadyCallback(this.cJr);
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
            this.cJn = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cxx = bdUniqueId;
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
        this.cJr = bVar;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ConstrainImageLayout) {
                ((ConstrainImageLayout) childAt).setPreloadSizeReadyCallback(bVar);
            }
        }
    }

    public void setSinglePicUseStyleV10(boolean z) {
        this.cJt = z;
    }
}
