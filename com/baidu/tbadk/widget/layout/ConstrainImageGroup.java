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
    private d akK;
    private boolean akk;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> fEV;
    private com.baidu.adp.lib.d.b<TbImageView> fEW;
    private c fEX;
    private int fEY;
    private double fEZ;
    private View.OnClickListener fFa;
    private com.baidu.adp.widget.a.b fFb;
    private ViewGroup.OnHierarchyChangeListener fFc;
    private boolean fFd;
    private BdUniqueId fsQ;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.fEX = new b();
        this.akk = false;
        this.fFc = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.fEV != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.fEV.returnObject(constrainImageLayout);
                }
            }
        };
        this.fFd = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.fFc);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fEX = new b();
        this.akk = false;
        this.fFc = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.fEV != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.fEV.returnObject(constrainImageLayout);
                }
            }
        };
        this.fFd = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.fFc);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fEX = new b();
        this.akk = false;
        this.fFc = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.fEV != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.fEV.returnObject(constrainImageLayout);
                }
            }
        };
        this.fFd = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.fFc);
    }

    public void setFromCDN(boolean z) {
        this.akk = z;
    }

    public void setSingleImageRatio(double d) {
        this.fEZ = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.fFa = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        this.fEV = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.akK = dVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof ConstrainImageLayout) {
                    ((ConstrainImageLayout) childAt).setImageClickListener(this.akK);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        this.fEW = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.fEY = i;
        } else {
            this.fEY = 0;
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
        if (!y.isEmpty(list) && this.fEV != null) {
            si(y.getCount(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof ConstrainImageLayout) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) childAt;
                    constrainImageLayout.setImageClickListener(this.akK);
                    constrainImageLayout.setFromCDN(this.akk);
                    if (this.fEZ > 0.0d) {
                        constrainImageLayout.setSingleImageRatio(this.fEZ);
                    }
                    if (this.fFa == null) {
                        constrainImageLayout.setClickable(false);
                    } else {
                        constrainImageLayout.setOnClickListener(this.fFa);
                    }
                    constrainImageLayout.setSinglePicUseStyleV10(this.fFd);
                    i = this.fEX.a(constrainImageLayout, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void si(int i) {
        int sh = this.fEX.sh(i);
        int childCount = getChildCount() - sh;
        if (childCount > 0) {
            removeViews(sh, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private ConstrainImageLayout getConstrainImageLayout() {
        ConstrainImageLayout borrowObject = this.fEV.borrowObject();
        borrowObject.setImagePadding(this.fEY);
        borrowObject.setImageViewObjectPool(this.fEW);
        borrowObject.setImageMaxChildCount(-1);
        borrowObject.setExtraCenterText(null);
        borrowObject.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        borrowObject.setPageUniqueId(this.fsQ);
        borrowObject.setPreloadSizeReadyCallback(this.fFb);
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
            this.fEX = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fsQ = bdUniqueId;
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
        this.fFb = bVar;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ConstrainImageLayout) {
                ((ConstrainImageLayout) childAt).setPreloadSizeReadyCallback(bVar);
            }
        }
    }

    public void setSinglePicUseStyleV10(boolean z) {
        this.fFd = z;
    }
}
