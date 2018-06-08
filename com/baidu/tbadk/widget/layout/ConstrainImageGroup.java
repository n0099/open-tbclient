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
    private BdUniqueId aQJ;
    private boolean asK;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> bbn;
    private com.baidu.adp.lib.e.b<TbImageView> bbo;
    private b bbp;
    private int bbq;
    private double bbr;
    private c bbs;
    private View.OnClickListener bbt;
    private ViewGroup.OnHierarchyChangeListener bbu;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.bbp = new a();
        this.asK = false;
        this.bbu = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.bbn != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.bbn.p(constrainImageLayout);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bbu);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bbp = new a();
        this.asK = false;
        this.bbu = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.bbn != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.bbn.p(constrainImageLayout);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bbu);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bbp = new a();
        this.asK = false;
        this.bbu = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof ConstrainImageLayout) && ConstrainImageGroup.this.bbn != null) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                    constrainImageLayout.reset();
                    ConstrainImageGroup.this.bbn.p(constrainImageLayout);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bbu);
    }

    public void setFromCDN(boolean z) {
        this.asK = z;
    }

    public void setSingleImageRatio(double d) {
        this.bbr = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.bbt = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        this.bbn = bVar;
    }

    public void setImageClickListener(c cVar) {
        this.bbs = cVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof ConstrainImageLayout) {
                    ((ConstrainImageLayout) childAt).setImageClickListener(this.bbs);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.bbo = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.bbq = i;
        } else {
            this.bbq = 0;
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
        if (!w.z(list) && this.bbn != null) {
            fH(w.y(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof ConstrainImageLayout) {
                    ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) childAt;
                    constrainImageLayout.setImageClickListener(this.bbs);
                    constrainImageLayout.setFromCDN(this.asK);
                    if (this.bbr > 0.0d) {
                        constrainImageLayout.setSingleImageRatio(this.bbr);
                    }
                    if (this.bbt == null) {
                        constrainImageLayout.setClickable(false);
                    } else {
                        constrainImageLayout.setOnClickListener(this.bbt);
                    }
                    i = this.bbp.a(constrainImageLayout, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void fH(int i) {
        int fG = this.bbp.fG(i);
        int childCount = getChildCount() - fG;
        if (childCount > 0) {
            removeViews(fG, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private ConstrainImageLayout getConstrainImageLayout() {
        ConstrainImageLayout ie = this.bbn.ie();
        ie.setImagePadding(this.bbq);
        ie.setImageViewObjectPool(this.bbo);
        ie.setImageMaxChildCount(-1);
        ie.setExtraCenterText(null);
        ie.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ie.setPageUniqueId(this.aQJ);
        return ie;
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
            this.bbp = bVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aQJ = bdUniqueId;
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
