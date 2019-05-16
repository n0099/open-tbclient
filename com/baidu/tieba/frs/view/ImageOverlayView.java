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
    private int erm;
    private int fQN;
    private int fQO;
    private int fQP;
    private int fQQ;
    private a fQR;
    private List<String> fQS;
    private boolean fQT;
    public final View.OnClickListener fQU;
    private int mImageHeight;
    private int mImageWidth;

    /* loaded from: classes4.dex */
    public interface a {
        void brz();
    }

    public ImageOverlayView(Context context) {
        super(context);
        this.erm = 10;
        this.fQT = false;
        this.fQU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.fQR != null) {
                    ImageOverlayView.this.fQR.brz();
                }
            }
        };
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.erm = 10;
        this.fQT = false;
        this.fQU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.fQR != null) {
                    ImageOverlayView.this.fQR.brz();
                }
            }
        };
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.erm = 10;
        this.fQT = false;
        this.fQU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.fQR != null) {
                    ImageOverlayView.this.fQR.brz();
                }
            }
        };
    }

    public void i(int i, int i2, int i3, int i4, int i5, int i6) {
        this.fQN = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.fQO = i4;
        this.fQP = i5;
        this.fQQ = i6;
        bry();
    }

    private void bry() {
        for (int i = 0; i < this.fQN; i++) {
            HeadImageView headImageView = new HeadImageView(getContext());
            headImageView.setLayoutParams(new ViewGroup.LayoutParams(this.mImageWidth, this.mImageHeight));
            headImageView.setIsRound(true);
            headImageView.setBorderSurroundContent(true);
            headImageView.setDrawBorder(true);
            headImageView.setBorderWidth(this.fQO);
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.setBorderColor(al.getColor(this.fQP));
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(headImageView);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(resolveSize(((getPaddingLeft() + getPaddingRight()) + (this.fQN * this.mImageWidth)) - ((this.fQN - 1) * this.fQQ), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight, i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int paddingTop;
        View childAt;
        if (this.fQT) {
            paddingLeft = getPaddingLeft();
            paddingTop = getPaddingTop();
        } else {
            paddingLeft = ((this.fQN - 1) * (this.mImageWidth - this.fQQ)) + getPaddingLeft();
            paddingTop = getPaddingTop();
        }
        int i5 = paddingLeft;
        for (int i6 = 0; i6 < this.fQN && i6 < getChildCount() && (childAt = getChildAt(i6)) != null; i6++) {
            if (this.fQT) {
                childAt.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                i5 += this.mImageWidth - this.fQQ;
            } else {
                childAt.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                i5 -= this.mImageWidth - this.fQQ;
            }
        }
    }

    public void setData(List<String> list) {
        HeadImageView headImageView;
        if (!v.aa(list)) {
            this.fQS = list;
            for (int i = 0; i < this.fQN && (headImageView = (HeadImageView) getChildAt(i)) != null; i++) {
                if (i >= list.size()) {
                    headImageView.setVisibility(8);
                } else {
                    headImageView.setVisibility(0);
                    String str = (String) v.c(list, (list.size() - i) - 1);
                    if (str != null) {
                        if (this.erm == 12) {
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
                    ((HeadImageView) childAt).setBorderColor(al.getColor(this.fQP));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void setImageClickListener(a aVar) {
        this.fQR = aVar;
    }

    public void setLoadImageType(int i) {
        this.erm = i;
    }

    public void setOrientation(boolean z) {
        this.fQT = z;
    }
}
