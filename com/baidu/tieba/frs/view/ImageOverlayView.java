package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.List;
/* loaded from: classes4.dex */
public class ImageOverlayView extends ViewGroup {
    private int ern;
    private int fQO;
    private int fQP;
    private int fQQ;
    private int fQR;
    private a fQS;
    private List<String> fQT;
    private boolean fQU;
    public final View.OnClickListener fQV;
    private int mImageHeight;
    private int mImageWidth;

    /* loaded from: classes4.dex */
    public interface a {
        void brC();
    }

    public ImageOverlayView(Context context) {
        super(context);
        this.ern = 10;
        this.fQU = false;
        this.fQV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.fQS != null) {
                    ImageOverlayView.this.fQS.brC();
                }
            }
        };
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ern = 10;
        this.fQU = false;
        this.fQV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.fQS != null) {
                    ImageOverlayView.this.fQS.brC();
                }
            }
        };
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ern = 10;
        this.fQU = false;
        this.fQV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.fQS != null) {
                    ImageOverlayView.this.fQS.brC();
                }
            }
        };
    }

    public void i(int i, int i2, int i3, int i4, int i5, int i6) {
        this.fQO = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.fQP = i4;
        this.fQQ = i5;
        this.fQR = i6;
        brB();
    }

    private void brB() {
        for (int i = 0; i < this.fQO; i++) {
            HeadImageView headImageView = new HeadImageView(getContext());
            headImageView.setLayoutParams(new ViewGroup.LayoutParams(this.mImageWidth, this.mImageHeight));
            headImageView.setIsRound(true);
            headImageView.setBorderSurroundContent(true);
            headImageView.setDrawBorder(true);
            headImageView.setBorderWidth(this.fQP);
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.setBorderColor(al.getColor(this.fQQ));
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(headImageView);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(resolveSize(((getPaddingLeft() + getPaddingRight()) + (this.fQO * this.mImageWidth)) - ((this.fQO - 1) * this.fQR), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight, i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int paddingTop;
        View childAt;
        if (this.fQU) {
            paddingLeft = getPaddingLeft();
            paddingTop = getPaddingTop();
        } else {
            paddingLeft = ((this.fQO - 1) * (this.mImageWidth - this.fQR)) + getPaddingLeft();
            paddingTop = getPaddingTop();
        }
        int i5 = paddingLeft;
        for (int i6 = 0; i6 < this.fQO && i6 < getChildCount() && (childAt = getChildAt(i6)) != null; i6++) {
            if (this.fQU) {
                childAt.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                i5 += this.mImageWidth - this.fQR;
            } else {
                childAt.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                i5 -= this.mImageWidth - this.fQR;
            }
        }
    }

    public void setData(List<String> list) {
        HeadImageView headImageView;
        if (!v.aa(list)) {
            this.fQT = list;
            for (int i = 0; i < this.fQO && (headImageView = (HeadImageView) getChildAt(i)) != null; i++) {
                if (i >= list.size()) {
                    headImageView.setVisibility(8);
                } else {
                    headImageView.setVisibility(0);
                    String str = (String) v.c(list, (list.size() - i) - 1);
                    if (str != null) {
                        if (this.ern == 12) {
                            headImageView.startLoad(str, 12, this.mImageWidth, this.mImageHeight, false);
                        } else {
                            headImageView.startLoad(str, 10, this.mImageWidth, this.mImageHeight, false);
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
                    ((HeadImageView) childAt).setBorderColor(al.getColor(this.fQQ));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void setImageClickListener(a aVar) {
        this.fQS = aVar;
    }

    public void setLoadImageType(int i) {
        this.ern = i;
    }

    public void setOrientation(boolean z) {
        this.fQU = z;
    }
}
