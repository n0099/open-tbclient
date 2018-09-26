package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes2.dex */
public class ImageOverlayView extends ViewGroup {
    private int dSj;
    private int dSk;
    private int dSl;
    private int dSm;
    private a dSn;
    private List<String> dSo;
    public final View.OnClickListener dSp;
    private int mImageHeight;
    private int mImageWidth;

    /* loaded from: classes2.dex */
    public interface a {
        void aDB();
    }

    public ImageOverlayView(Context context) {
        super(context);
        this.dSp = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.dSn != null) {
                    ImageOverlayView.this.dSn.aDB();
                }
            }
        };
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dSp = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.dSn != null) {
                    ImageOverlayView.this.dSn.aDB();
                }
            }
        };
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dSp = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.dSn != null) {
                    ImageOverlayView.this.dSn.aDB();
                }
            }
        };
    }

    public void h(int i, int i2, int i3, int i4, int i5, int i6) {
        this.dSj = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.dSk = i4;
        this.dSl = i5;
        this.dSm = i6;
        aDA();
    }

    private void aDA() {
        for (int i = 0; i < this.dSj; i++) {
            HeadImageView headImageView = new HeadImageView(getContext());
            headImageView.setIsRound(true);
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.mImageWidth, this.mImageHeight);
            headImageView.setBackgroundResource(e.f.bg_lite_program_icon);
            addView(headImageView, layoutParams);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(resolveSize((this.dSj * this.mImageWidth) - ((this.dSj - 1) * this.dSm), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight, i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt;
        int paddingLeft = ((this.dSj - 1) * (this.mImageWidth - this.dSm)) + getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < this.dSj && i5 < getChildCount() && (childAt = getChildAt(i5)) != null; i5++) {
            childAt.layout(paddingLeft, paddingTop, this.mImageWidth + paddingLeft, this.mImageHeight + paddingTop);
            paddingLeft -= this.mImageWidth - this.dSm;
        }
    }

    public void setData(List<String> list) {
        HeadImageView headImageView;
        if (!v.z(list)) {
            this.dSo = list;
            for (int i = 0; i < this.dSj && (headImageView = (HeadImageView) getChildAt(i)) != null; i++) {
                if (i >= list.size()) {
                    headImageView.setVisibility(8);
                } else {
                    headImageView.setVisibility(0);
                    String str = (String) v.d(list, (list.size() - i) - 1);
                    if (str != null) {
                        headImageView.startLoad(str, 10, this.mImageWidth, this.mImageHeight, false);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void onChangeSkinType() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                View childAt = getChildAt(i2);
                if (childAt instanceof HeadImageView) {
                    al.i((HeadImageView) childAt, e.f.bg_lite_program_icon);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void setImageClickListener(a aVar) {
        this.dSn = aVar;
    }
}
