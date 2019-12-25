package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.List;
/* loaded from: classes6.dex */
public class ImageOverlayView extends ViewGroup {
    private int fxS;
    private int gLA;
    private int gLB;
    private int gLC;
    private a gLD;
    private List<String> gLE;
    private boolean gLF;
    public final View.OnClickListener gLG;
    private int gLz;
    private int mImageHeight;
    private int mImageWidth;

    /* loaded from: classes6.dex */
    public interface a {
        void bJi();
    }

    public ImageOverlayView(Context context) {
        super(context);
        this.fxS = 10;
        this.gLF = false;
        this.gLG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.gLD != null) {
                    ImageOverlayView.this.gLD.bJi();
                }
            }
        };
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fxS = 10;
        this.gLF = false;
        this.gLG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.gLD != null) {
                    ImageOverlayView.this.gLD.bJi();
                }
            }
        };
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fxS = 10;
        this.gLF = false;
        this.gLG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.gLD != null) {
                    ImageOverlayView.this.gLD.bJi();
                }
            }
        };
    }

    public void k(int i, int i2, int i3, int i4, int i5, int i6) {
        this.gLz = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.gLA = i4;
        this.gLB = i5;
        this.gLC = i6;
        bJh();
    }

    private void bJh() {
        for (int i = 0; i < this.gLz; i++) {
            HeadImageView headImageView = new HeadImageView(getContext());
            headImageView.setLayoutParams(new ViewGroup.LayoutParams(this.mImageWidth, this.mImageHeight));
            headImageView.setIsRound(true);
            headImageView.setBorderSurroundContent(true);
            headImageView.setDrawBorder(true);
            headImageView.setAutoChangeStyle(true);
            headImageView.setBorderWidth(this.gLA);
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.setBorderColor(am.getColor(this.gLB));
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.setPlaceHolder(1);
            addView(headImageView);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(resolveSize(((getPaddingLeft() + getPaddingRight()) + (this.gLz * this.mImageWidth)) - ((this.gLz - 1) * this.gLC), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight, i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int paddingTop;
        View childAt;
        if (this.gLF) {
            paddingLeft = getPaddingLeft();
            paddingTop = getPaddingTop();
        } else {
            paddingLeft = ((this.gLz - 1) * (this.mImageWidth - this.gLC)) + getPaddingLeft();
            paddingTop = getPaddingTop();
        }
        int i5 = paddingLeft;
        for (int i6 = 0; i6 < this.gLz && i6 < getChildCount() && (childAt = getChildAt(i6)) != null; i6++) {
            if (this.gLF) {
                childAt.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                i5 += this.mImageWidth - this.gLC;
            } else {
                childAt.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                i5 -= this.mImageWidth - this.gLC;
            }
        }
    }

    public void setData(List<String> list) {
        HeadImageView headImageView;
        if (!v.isEmpty(list)) {
            this.gLE = list;
            for (int i = 0; i < this.gLz && (headImageView = (HeadImageView) getChildAt(i)) != null; i++) {
                if (i >= list.size()) {
                    headImageView.setVisibility(8);
                } else {
                    headImageView.setVisibility(0);
                    String str = (String) v.getItem(list, (list.size() - i) - 1);
                    if (str != null) {
                        if (this.fxS == 12) {
                            headImageView.a(str, 12, this.mImageWidth, this.mImageHeight, false);
                        } else {
                            headImageView.a(str, 10, this.mImageWidth, this.mImageHeight, false);
                        }
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
                    HeadImageView headImageView = (HeadImageView) childAt;
                    headImageView.setBorderColor(am.getColor(this.gLB));
                    headImageView.setPlaceHolder(1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void setImageClickListener(a aVar) {
        this.gLD = aVar;
    }

    public void setLoadImageType(int i) {
        this.fxS = i;
    }

    public void setOrientation(boolean z) {
        this.gLF = z;
    }
}
