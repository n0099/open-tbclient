package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ConstrainImageGroup extends LinearLayout {
    private boolean ajR;
    private d akr;
    private BdUniqueId eSq;
    private ViewGroup.OnHierarchyChangeListener feA;
    private boolean feB;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> fet;
    private com.baidu.adp.lib.d.b<TbImageView> feu;
    private c fev;
    private int few;
    private double fex;
    private View.OnClickListener fey;
    private com.baidu.adp.widget.a.b fez;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.fev = new b();
        this.ajR = false;
        this.feA = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.fet != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.fet.returnObject(constrainImageLayout);
                }
            }
        };
        this.feB = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.feA);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fev = new b();
        this.ajR = false;
        this.feA = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.fet != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.fet.returnObject(constrainImageLayout);
                }
            }
        };
        this.feB = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.feA);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fev = new b();
        this.ajR = false;
        this.feA = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.fet != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.fet.returnObject(constrainImageLayout);
                }
            }
        };
        this.feB = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.feA);
    }

    public void setFromCDN(boolean z) {
        this.ajR = z;
    }

    public void setSingleImageRatio(double d) {
        this.fex = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.fey = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        this.fet = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.akr = dVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof ConstrainImageLayout) {
                    ((ConstrainImageLayout) childAt).setImageClickListener(this.akr);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        this.feu = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.few = i;
        } else {
            this.few = 0;
        }
    }

    @Deprecated
    public void setImageUrls(List<String> list) {
        if (!y.isEmpty(list)) {
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
        if (!y.isEmpty(list) && this.fet != null) {
            rp(y.getCount(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof ConstrainImageLayout) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) childAt;
                    constrainImageLayout.setImageClickListener(this.akr);
                    constrainImageLayout.setFromCDN(this.ajR);
                    if (this.fex > 0.0d) {
                        constrainImageLayout.setSingleImageRatio(this.fex);
                    }
                    if (this.fey == null) {
                        constrainImageLayout.setClickable(false);
                    } else {
                        constrainImageLayout.setOnClickListener(this.fey);
                    }
                    constrainImageLayout.setSinglePicUseStyleV10(this.feB);
                    i = this.fev.a(constrainImageLayout, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void rp(int i) {
        int ro = this.fev.ro(i);
        int childCount = getChildCount() - ro;
        if (childCount > 0) {
            removeViews(ro, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private ConstrainImageLayout getConstrainImageLayout() {
        ConstrainImageLayout borrowObject = this.fet.borrowObject();
        borrowObject.setImagePadding(this.few);
        borrowObject.setImageViewObjectPool(this.feu);
        borrowObject.setImageMaxChildCount(-1);
        borrowObject.setExtraCenterText(null);
        borrowObject.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        borrowObject.setPageUniqueId(this.eSq);
        borrowObject.setPreloadSizeReadyCallback(this.fez);
        return borrowObject;
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
            this.fev = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.eSq = bdUniqueId;
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
        this.fez = bVar;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ConstrainImageLayout) {
                ((ConstrainImageLayout) childAt).setPreloadSizeReadyCallback(bVar);
            }
        }
    }

    public void setSinglePicUseStyleV10(boolean z) {
        this.feB = z;
    }
}
