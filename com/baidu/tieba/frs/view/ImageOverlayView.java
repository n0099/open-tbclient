package com.baidu.tieba.frs.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.List;
/* loaded from: classes9.dex */
public class ImageOverlayView extends ViewGroup {
    private int fDD;
    private int gQP;
    private int gQQ;
    private int gQR;
    private int gQS;
    private a gQT;
    private List<String> gQU;
    private boolean gQV;
    public final View.OnClickListener gQW;
    private int mImageHeight;
    private int mImageWidth;
    private Paint mStrokePaint;

    /* loaded from: classes9.dex */
    public interface a {
        void bLO();
    }

    public ImageOverlayView(Context context) {
        super(context);
        this.fDD = 10;
        this.gQV = false;
        this.gQW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.gQT != null) {
                    ImageOverlayView.this.gQT.bLO();
                }
            }
        };
        lQ();
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fDD = 10;
        this.gQV = false;
        this.gQW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.gQT != null) {
                    ImageOverlayView.this.gQT.bLO();
                }
            }
        };
        lQ();
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fDD = 10;
        this.gQV = false;
        this.gQW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.gQT != null) {
                    ImageOverlayView.this.gQT.bLO();
                }
            }
        };
        lQ();
    }

    public void k(int i, int i2, int i3, int i4, int i5, int i6) {
        this.gQP = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.gQQ = i4;
        this.gQR = i5;
        this.gQS = i6;
        bLN();
    }

    private void lQ() {
        this.mStrokePaint = new Paint();
        this.mStrokePaint.setAntiAlias(true);
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
    }

    private void bLN() {
        for (int i = 0; i < this.gQP; i++) {
            HeadImageView headImageView = new HeadImageView(getContext());
            headImageView.setLayoutParams(new ViewGroup.LayoutParams(this.mImageWidth, this.mImageHeight));
            headImageView.setIsRound(true);
            headImageView.setBorderSurroundContent(true);
            headImageView.setDrawBorder(true);
            headImageView.setAutoChangeStyle(true);
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.setPlaceHolder(1);
            addView(headImageView);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(resolveSize((((getPaddingLeft() + getPaddingRight()) + this.gQQ) + (this.gQP * this.mImageWidth)) - ((this.gQP - 1) * this.gQS), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight + (this.gQQ * 2), i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int paddingTop;
        View childAt;
        if (this.gQV) {
            paddingLeft = this.gQQ + getPaddingLeft();
            paddingTop = getPaddingTop() + this.gQQ;
        } else {
            paddingLeft = this.gQQ + getPaddingLeft() + ((this.gQP - 1) * (this.mImageWidth - this.gQS));
            paddingTop = getPaddingTop() + this.gQQ;
        }
        int i5 = paddingLeft;
        for (int i6 = 0; i6 < this.gQP && i6 < getChildCount() && (childAt = getChildAt(i6)) != null; i6++) {
            if (this.gQV) {
                childAt.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                i5 += this.mImageWidth - this.gQS;
            } else {
                childAt.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                i5 -= this.mImageWidth - this.gQS;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        View childAt;
        super.dispatchDraw(canvas);
        this.mStrokePaint.setColor(am.getColor(this.gQR));
        this.mStrokePaint.setStrokeWidth(this.gQQ);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 < this.gQP && i2 < getChildCount() && (childAt = getChildAt(i2)) != null) {
                float f = this.gQQ * 0.5f;
                if (childAt instanceof HeadImageView) {
                    canvas.drawArc(childAt.getLeft() - f, childAt.getTop() - f, childAt.getRight() + f, f + childAt.getBottom(), -90.0f, 180.0f, false, this.mStrokePaint);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void setData(List<String> list) {
        HeadImageView headImageView;
        if (!v.isEmpty(list)) {
            this.gQU = list;
            for (int i = 0; i < this.gQP && (headImageView = (HeadImageView) getChildAt(i)) != null; i++) {
                if (i >= list.size()) {
                    headImageView.setVisibility(8);
                } else {
                    headImageView.setVisibility(0);
                    String str = (String) v.getItem(list, (list.size() - i) - 1);
                    if (str != null) {
                        if (this.fDD == 12) {
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
        this.mStrokePaint.setColor(am.getColor(this.gQR));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                View childAt = getChildAt(i2);
                if (childAt instanceof HeadImageView) {
                    ((HeadImageView) childAt).setPlaceHolder(1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void setImageClickListener(a aVar) {
        this.gQT = aVar;
    }

    public void setLoadImageType(int i) {
        this.fDD = i;
    }

    public void setOrientation(boolean z) {
        this.gQV = z;
    }
}
