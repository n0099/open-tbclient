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
    private boolean aXt;
    private BdUniqueId bGo;
    private com.baidu.adp.lib.e.b<b> bGp;
    private com.baidu.adp.lib.e.b<TbImageView> bGq;
    private c bGr;
    private int bGs;
    private double bGt;
    private d bGu;
    private View.OnClickListener bGv;
    private ViewGroup.OnHierarchyChangeListener bGw;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.bGr = new a();
        this.aXt = false;
        this.bGw = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.bGp != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.bGp.ar(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bGw);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGr = new a();
        this.aXt = false;
        this.bGw = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.bGp != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.bGp.ar(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bGw);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bGr = new a();
        this.aXt = false;
        this.bGw = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.bGp != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.bGp.ar(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bGw);
    }

    public void setFromCDN(boolean z) {
        this.aXt = z;
    }

    public void setSingleImageRatio(double d) {
        this.bGt = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.bGv = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<b> bVar) {
        this.bGp = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.bGu = dVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof b) {
                    ((b) childAt).setImageClickListener(this.bGu);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.bGq = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.bGs = i;
        } else {
            this.bGs = 0;
        }
    }

    @Deprecated
    public void setImageUrls(List<String> list) {
        if (!v.G(list)) {
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
        if (!v.G(list) && this.bGp != null) {
            iM(v.F(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof b) {
                    b bVar = (b) childAt;
                    bVar.setImageClickListener(this.bGu);
                    bVar.setFromCDN(this.aXt);
                    if (this.bGt > 0.0d) {
                        bVar.setSingleImageRatio(this.bGt);
                    }
                    bVar.setOnClickListener(this.bGv);
                    i = this.bGr.a(bVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void iM(int i) {
        int iL = this.bGr.iL(i);
        int childCount = getChildCount() - iL;
        if (childCount > 0) {
            removeViews(iL, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private b getConstrainImageLayout() {
        b nj = this.bGp.nj();
        nj.setImagePadding(this.bGs);
        nj.setImageViewObjectPool(this.bGq);
        nj.setImageMaxChildCount(-1);
        nj.setExtraCenterText(null);
        nj.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        nj.setPageUniqueId(this.bGo);
        return nj;
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
            this.bGr = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.bGo = bdUniqueId;
    }
}
