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
/* loaded from: classes4.dex */
public class ImageOverlayView extends ViewGroup {
    private int eGL;
    private int fXP;
    private int fXQ;
    private int fXR;
    private int fXS;
    private a fXT;
    private List<String> fXU;
    private boolean fXV;
    public final View.OnClickListener fXW;
    private int mImageHeight;
    private int mImageWidth;

    /* loaded from: classes4.dex */
    public interface a {
        void brI();
    }

    public ImageOverlayView(Context context) {
        super(context);
        this.eGL = 10;
        this.fXV = false;
        this.fXW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.fXT != null) {
                    ImageOverlayView.this.fXT.brI();
                }
            }
        };
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eGL = 10;
        this.fXV = false;
        this.fXW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.fXT != null) {
                    ImageOverlayView.this.fXT.brI();
                }
            }
        };
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eGL = 10;
        this.fXV = false;
        this.fXW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.fXT != null) {
                    ImageOverlayView.this.fXT.brI();
                }
            }
        };
    }

    public void j(int i, int i2, int i3, int i4, int i5, int i6) {
        this.fXP = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.fXQ = i4;
        this.fXR = i5;
        this.fXS = i6;
        brH();
    }

    private void brH() {
        for (int i = 0; i < this.fXP; i++) {
            HeadImageView headImageView = new HeadImageView(getContext());
            headImageView.setLayoutParams(new ViewGroup.LayoutParams(this.mImageWidth, this.mImageHeight));
            headImageView.setIsRound(true);
            headImageView.setBorderSurroundContent(true);
            headImageView.setDrawBorder(true);
            headImageView.setAutoChangeStyle(true);
            headImageView.setBorderWidth(this.fXQ);
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.setBorderColor(am.getColor(this.fXR));
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(headImageView);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(resolveSize(((getPaddingLeft() + getPaddingRight()) + (this.fXP * this.mImageWidth)) - ((this.fXP - 1) * this.fXS), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight, i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int paddingTop;
        View childAt;
        if (this.fXV) {
            paddingLeft = getPaddingLeft();
            paddingTop = getPaddingTop();
        } else {
            paddingLeft = ((this.fXP - 1) * (this.mImageWidth - this.fXS)) + getPaddingLeft();
            paddingTop = getPaddingTop();
        }
        int i5 = paddingLeft;
        for (int i6 = 0; i6 < this.fXP && i6 < getChildCount() && (childAt = getChildAt(i6)) != null; i6++) {
            if (this.fXV) {
                childAt.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                i5 += this.mImageWidth - this.fXS;
            } else {
                childAt.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                i5 -= this.mImageWidth - this.fXS;
            }
        }
    }

    public void setData(List<String> list) {
        HeadImageView headImageView;
        if (!v.isEmpty(list)) {
            this.fXU = list;
            for (int i = 0; i < this.fXP && (headImageView = (HeadImageView) getChildAt(i)) != null; i++) {
                if (i >= list.size()) {
                    headImageView.setVisibility(8);
                } else {
                    headImageView.setVisibility(0);
                    String str = (String) v.getItem(list, (list.size() - i) - 1);
                    if (str != null) {
                        if (this.eGL == 12) {
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
                    ((HeadImageView) childAt).setBorderColor(am.getColor(this.fXR));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void setImageClickListener(a aVar) {
        this.fXT = aVar;
    }

    public void setLoadImageType(int i) {
        this.eGL = i;
    }

    public void setOrientation(boolean z) {
        this.fXV = z;
    }
}
