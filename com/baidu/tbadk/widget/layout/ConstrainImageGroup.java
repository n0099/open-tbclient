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
/* loaded from: classes2.dex */
public class ConstrainImageGroup extends LinearLayout {
    private d ajO;
    private boolean ajr;
    private BdUniqueId ePv;
    private double fbA;
    private View.OnClickListener fbB;
    private com.baidu.adp.widget.a.b fbC;
    private ViewGroup.OnHierarchyChangeListener fbD;
    private boolean fbE;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> fbw;
    private com.baidu.adp.lib.d.b<TbImageView> fbx;
    private c fby;
    private int fbz;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.fby = new b();
        this.ajr = false;
        this.fbD = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.fbw != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.fbw.returnObject(constrainImageLayout);
                }
            }
        };
        this.fbE = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.fbD);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fby = new b();
        this.ajr = false;
        this.fbD = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.fbw != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.fbw.returnObject(constrainImageLayout);
                }
            }
        };
        this.fbE = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.fbD);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fby = new b();
        this.ajr = false;
        this.fbD = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.fbw != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.fbw.returnObject(constrainImageLayout);
                }
            }
        };
        this.fbE = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.fbD);
    }

    public void setFromCDN(boolean z) {
        this.ajr = z;
    }

    public void setSingleImageRatio(double d) {
        this.fbA = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.fbB = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        this.fbw = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.ajO = dVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof ConstrainImageLayout) {
                    ((ConstrainImageLayout) childAt).setImageClickListener(this.ajO);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        this.fbx = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.fbz = i;
        } else {
            this.fbz = 0;
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
        if (!y.isEmpty(list) && this.fbw != null) {
            qY(y.getCount(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof ConstrainImageLayout) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) childAt;
                    constrainImageLayout.setImageClickListener(this.ajO);
                    constrainImageLayout.setFromCDN(this.ajr);
                    if (this.fbA > 0.0d) {
                        constrainImageLayout.setSingleImageRatio(this.fbA);
                    }
                    if (this.fbB == null) {
                        constrainImageLayout.setClickable(false);
                    } else {
                        constrainImageLayout.setOnClickListener(this.fbB);
                    }
                    constrainImageLayout.setSinglePicUseStyleV10(this.fbE);
                    i = this.fby.a(constrainImageLayout, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void qY(int i) {
        int qX = this.fby.qX(i);
        int childCount = getChildCount() - qX;
        if (childCount > 0) {
            removeViews(qX, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private ConstrainImageLayout getConstrainImageLayout() {
        ConstrainImageLayout borrowObject = this.fbw.borrowObject();
        borrowObject.setImagePadding(this.fbz);
        borrowObject.setImageViewObjectPool(this.fbx);
        borrowObject.setImageMaxChildCount(-1);
        borrowObject.setExtraCenterText(null);
        borrowObject.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        borrowObject.setPageUniqueId(this.ePv);
        borrowObject.setPreloadSizeReadyCallback(this.fbC);
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
            this.fby = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ePv = bdUniqueId;
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
        this.fbC = bVar;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ConstrainImageLayout) {
                ((ConstrainImageLayout) childAt).setPreloadSizeReadyCallback(bVar);
            }
        }
    }

    public void setSinglePicUseStyleV10(boolean z) {
        this.fbE = z;
    }
}
