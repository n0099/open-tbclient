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
    private boolean XJ;
    private d Yd;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> cHQ;
    private com.baidu.adp.lib.e.b<TbImageView> cHR;
    private c cHS;
    private int cHT;
    private double cHU;
    private View.OnClickListener cHV;
    private com.baidu.adp.widget.a.b cHW;
    private ViewGroup.OnHierarchyChangeListener cHX;
    private boolean cHY;
    private BdUniqueId cwh;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.cHS = new b();
        this.XJ = false;
        this.cHX = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.cHQ != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.cHQ.t(constrainImageLayout);
                }
            }
        };
        this.cHY = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.cHX);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cHS = new b();
        this.XJ = false;
        this.cHX = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.cHQ != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.cHQ.t(constrainImageLayout);
                }
            }
        };
        this.cHY = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.cHX);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cHS = new b();
        this.XJ = false;
        this.cHX = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.cHQ != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.cHQ.t(constrainImageLayout);
                }
            }
        };
        this.cHY = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.cHX);
    }

    public void setFromCDN(boolean z) {
        this.XJ = z;
    }

    public void setSingleImageRatio(double d) {
        this.cHU = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.cHV = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        this.cHQ = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.Yd = dVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof ConstrainImageLayout) {
                    ((ConstrainImageLayout) childAt).setImageClickListener(this.Yd);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.cHR = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.cHT = i;
        } else {
            this.cHT = 0;
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
        if (!v.aa(list) && this.cHQ != null) {
            li(v.Z(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof ConstrainImageLayout) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) childAt;
                    constrainImageLayout.setImageClickListener(this.Yd);
                    constrainImageLayout.setFromCDN(this.XJ);
                    if (this.cHU > 0.0d) {
                        constrainImageLayout.setSingleImageRatio(this.cHU);
                    }
                    if (this.cHV == null) {
                        constrainImageLayout.setClickable(false);
                    } else {
                        constrainImageLayout.setOnClickListener(this.cHV);
                    }
                    constrainImageLayout.setSinglePicUseStyleV10(this.cHY);
                    i = this.cHS.a(constrainImageLayout, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void li(int i) {
        int lh = this.cHS.lh(i);
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
        ConstrainImageLayout iu = this.cHQ.iu();
        iu.setImagePadding(this.cHT);
        iu.setImageViewObjectPool(this.cHR);
        iu.setImageMaxChildCount(-1);
        iu.setExtraCenterText(null);
        iu.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        iu.setPageUniqueId(this.cwh);
        iu.setPreloadSizeReadyCallback(this.cHW);
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
            this.cHS = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cwh = bdUniqueId;
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
        this.cHW = bVar;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ConstrainImageLayout) {
                ((ConstrainImageLayout) childAt).setPreloadSizeReadyCallback(bVar);
            }
        }
    }

    public void setSinglePicUseStyleV10(boolean z) {
        this.cHY = z;
    }
}
