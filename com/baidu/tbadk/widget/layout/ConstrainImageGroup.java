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
    private double aSA;
    private d aSB;
    private View.OnClickListener aSC;
    private ViewGroup.OnHierarchyChangeListener aSD;
    private BdUniqueId aSv;
    private com.baidu.adp.lib.e.b<b> aSw;
    private com.baidu.adp.lib.e.b<TbImageView> aSx;
    private c aSy;
    private int aSz;
    private boolean ajn;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.aSy = new a();
        this.ajn = false;
        this.aSD = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aSw != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.aSw.m(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aSD);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aSy = new a();
        this.ajn = false;
        this.aSD = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aSw != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.aSw.m(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aSD);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aSy = new a();
        this.ajn = false;
        this.aSD = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aSw != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.aSw.m(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aSD);
    }

    public void setFromCDN(boolean z) {
        this.ajn = z;
    }

    public void setSingleImageRatio(double d) {
        this.aSA = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.aSC = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<b> bVar) {
        this.aSw = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.aSB = dVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof b) {
                    ((b) childAt).setImageClickListener(this.aSB);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aSx = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.aSz = i;
        } else {
            this.aSz = 0;
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
        if (!v.w(list) && this.aSw != null) {
            fN(v.v(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof b) {
                    b bVar = (b) childAt;
                    bVar.setImageClickListener(this.aSB);
                    bVar.setFromCDN(this.ajn);
                    if (this.aSA > 0.0d) {
                        bVar.setSingleImageRatio(this.aSA);
                    }
                    bVar.setOnClickListener(this.aSC);
                    i = this.aSy.a(bVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void fN(int i) {
        int fM = this.aSy.fM(i);
        int childCount = getChildCount() - fM;
        if (childCount > 0) {
            removeViews(fM, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private b getConstrainImageLayout() {
        b fH = this.aSw.fH();
        fH.setImagePadding(this.aSz);
        fH.setImageViewObjectPool(this.aSx);
        fH.setImageMaxChildCount(-1);
        fH.setExtraCenterText(null);
        fH.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        fH.setPageUniqueId(this.aSv);
        return fH;
    }

    public void onChangeSkinType() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof b) {
                ((b) childAt).onChangeSkinType();
            }
        }
    }

    public void setImageProcessor(c cVar) {
        if (cVar != null) {
            this.aSy = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aSv = bdUniqueId;
    }
}
