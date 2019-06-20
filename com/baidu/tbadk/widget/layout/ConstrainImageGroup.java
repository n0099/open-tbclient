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
    private boolean XI;
    private d Yc;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> cHR;
    private com.baidu.adp.lib.e.b<TbImageView> cHS;
    private c cHT;
    private int cHU;
    private double cHV;
    private View.OnClickListener cHW;
    private com.baidu.adp.widget.a.b cHX;
    private ViewGroup.OnHierarchyChangeListener cHY;
    private boolean cHZ;
    private BdUniqueId cwi;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.cHT = new b();
        this.XI = false;
        this.cHY = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.cHR != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.cHR.t(constrainImageLayout);
                }
            }
        };
        this.cHZ = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.cHY);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cHT = new b();
        this.XI = false;
        this.cHY = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.cHR != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.cHR.t(constrainImageLayout);
                }
            }
        };
        this.cHZ = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.cHY);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cHT = new b();
        this.XI = false;
        this.cHY = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.cHR != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.cHR.t(constrainImageLayout);
                }
            }
        };
        this.cHZ = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.cHY);
    }

    public void setFromCDN(boolean z) {
        this.XI = z;
    }

    public void setSingleImageRatio(double d) {
        this.cHV = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.cHW = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        this.cHR = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.Yc = dVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof ConstrainImageLayout) {
                    ((ConstrainImageLayout) childAt).setImageClickListener(this.Yc);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.cHS = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.cHU = i;
        } else {
            this.cHU = 0;
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
        if (!v.aa(list) && this.cHR != null) {
            li(v.Z(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof ConstrainImageLayout) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) childAt;
                    constrainImageLayout.setImageClickListener(this.Yc);
                    constrainImageLayout.setFromCDN(this.XI);
                    if (this.cHV > 0.0d) {
                        constrainImageLayout.setSingleImageRatio(this.cHV);
                    }
                    if (this.cHW == null) {
                        constrainImageLayout.setClickable(false);
                    } else {
                        constrainImageLayout.setOnClickListener(this.cHW);
                    }
                    constrainImageLayout.setSinglePicUseStyleV10(this.cHZ);
                    i = this.cHT.a(constrainImageLayout, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void li(int i) {
        int lh = this.cHT.lh(i);
        int childCount = getChildCount() - lh;
        if (childCount > 0) {
            removeViews(lh, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private ConstrainImageLayout getConstrainImageLayout() {
        ConstrainImageLayout iu = this.cHR.iu();
        iu.setImagePadding(this.cHU);
        iu.setImageViewObjectPool(this.cHS);
        iu.setImageMaxChildCount(-1);
        iu.setExtraCenterText(null);
        iu.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        iu.setPageUniqueId(this.cwi);
        iu.setPreloadSizeReadyCallback(this.cHX);
        return iu;
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
            this.cHT = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cwi = bdUniqueId;
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
        this.cHX = bVar;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ConstrainImageLayout) {
                ((ConstrainImageLayout) childAt).setPreloadSizeReadyCallback(bVar);
            }
        }
    }

    public void setSinglePicUseStyleV10(boolean z) {
        this.cHZ = z;
    }
}
