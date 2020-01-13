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
/* loaded from: classes7.dex */
public class ImageOverlayView extends ViewGroup {
    private int fBd;
    private int gON;
    private int gOO;
    private int gOP;
    private int gOQ;
    private a gOR;
    private List<String> gOS;
    private boolean gOT;
    public final View.OnClickListener gOU;
    private int mImageHeight;
    private int mImageWidth;
    private Paint mStrokePaint;

    /* loaded from: classes7.dex */
    public interface a {
        void bKk();
    }

    public ImageOverlayView(Context context) {
        super(context);
        this.fBd = 10;
        this.gOT = false;
        this.gOU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.gOR != null) {
                    ImageOverlayView.this.gOR.bKk();
                }
            }
        };
        lB();
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fBd = 10;
        this.gOT = false;
        this.gOU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.gOR != null) {
                    ImageOverlayView.this.gOR.bKk();
                }
            }
        };
        lB();
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fBd = 10;
        this.gOT = false;
        this.gOU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.gOR != null) {
                    ImageOverlayView.this.gOR.bKk();
                }
            }
        };
        lB();
    }

    public void k(int i, int i2, int i3, int i4, int i5, int i6) {
        this.gON = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.gOO = i4;
        this.gOP = i5;
        this.gOQ = i6;
        bKj();
    }

    private void lB() {
        this.mStrokePaint = new Paint();
        this.mStrokePaint.setAntiAlias(true);
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
    }

    private void bKj() {
        for (int i = 0; i < this.gON; i++) {
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
        setMeasuredDimension(resolveSize((((getPaddingLeft() + getPaddingRight()) + this.gOO) + (this.gON * this.mImageWidth)) - ((this.gON - 1) * this.gOQ), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight + (this.gOO * 2), i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int paddingTop;
        View childAt;
        if (this.gOT) {
            paddingLeft = this.gOO + getPaddingLeft();
            paddingTop = getPaddingTop() + this.gOO;
        } else {
            paddingLeft = this.gOO + getPaddingLeft() + ((this.gON - 1) * (this.mImageWidth - this.gOQ));
            paddingTop = getPaddingTop() + this.gOO;
        }
        int i5 = paddingLeft;
        for (int i6 = 0; i6 < this.gON && i6 < getChildCount() && (childAt = getChildAt(i6)) != null; i6++) {
            if (this.gOT) {
                childAt.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                i5 += this.mImageWidth - this.gOQ;
            } else {
                childAt.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                i5 -= this.mImageWidth - this.gOQ;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        View childAt;
        super.dispatchDraw(canvas);
        this.mStrokePaint.setColor(am.getColor(this.gOP));
        this.mStrokePaint.setStrokeWidth(this.gOO);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 < this.gON && i2 < getChildCount() && (childAt = getChildAt(i2)) != null) {
                float f = this.gOO * 0.5f;
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
            this.gOS = list;
            for (int i = 0; i < this.gON && (headImageView = (HeadImageView) getChildAt(i)) != null; i++) {
                if (i >= list.size()) {
                    headImageView.setVisibility(8);
                } else {
                    headImageView.setVisibility(0);
                    String str = (String) v.getItem(list, (list.size() - i) - 1);
                    if (str != null) {
                        if (this.fBd == 12) {
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
        this.mStrokePaint.setColor(am.getColor(this.gOP));
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
        this.gOR = aVar;
    }

    public void setLoadImageType(int i) {
        this.fBd = i;
    }

    public void setOrientation(boolean z) {
        this.gOT = z;
    }
}
