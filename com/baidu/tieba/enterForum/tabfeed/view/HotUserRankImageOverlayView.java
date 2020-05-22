package com.baidu.tieba.enterForum.tabfeed.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.ColorRes;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.view.ImageOverlayView;
import java.util.List;
/* loaded from: classes9.dex */
public class HotUserRankImageOverlayView extends ViewGroup {
    private int gWB;
    private int gWC;
    private int gWD;
    private int gWE;
    private ImageOverlayView.a gWF;
    private boolean gWG;
    private int gWH;
    private int gWI;
    public final View.OnClickListener gWJ;
    private int gxZ;
    private int mImageHeight;
    private int mImageWidth;
    private Paint mStrokePaint;

    public HotUserRankImageOverlayView(Context context) {
        super(context);
        this.gxZ = 10;
        this.gWG = false;
        this.gWI = 1;
        this.gWJ = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.HotUserRankImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotUserRankImageOverlayView.this.gWF != null) {
                    HotUserRankImageOverlayView.this.gWF.dlU();
                }
            }
        };
        qy();
    }

    public HotUserRankImageOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gxZ = 10;
        this.gWG = false;
        this.gWI = 1;
        this.gWJ = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.HotUserRankImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotUserRankImageOverlayView.this.gWF != null) {
                    HotUserRankImageOverlayView.this.gWF.dlU();
                }
            }
        };
        qy();
    }

    public HotUserRankImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gxZ = 10;
        this.gWG = false;
        this.gWI = 1;
        this.gWJ = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.HotUserRankImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotUserRankImageOverlayView.this.gWF != null) {
                    HotUserRankImageOverlayView.this.gWF.dlU();
                }
            }
        };
        qy();
    }

    public void k(int i, int i2, int i3, int i4, int i5, int i6) {
        this.gWB = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.gWC = i4;
        this.gWD = i5;
        this.gWE = i6;
        bQc();
    }

    public void setFirstImageStrokeColor(@ColorRes int i) {
        this.gWH = i;
    }

    public void setStrokeStyle(int i) {
        this.gWI = i;
    }

    private void qy() {
        this.mStrokePaint = new Paint();
        this.mStrokePaint.setAntiAlias(true);
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
    }

    private void bQc() {
        for (int i = 0; i < this.gWB; i++) {
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
        int i3 = this.gWC;
        if (this.gWI == 1) {
            i3 = this.gWC * 2;
        }
        setMeasuredDimension(resolveSize(((i3 + (getPaddingLeft() + getPaddingRight())) + (this.gWB * this.mImageWidth)) - ((this.gWB - 1) * this.gWE), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight + (this.gWC * 2), i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt;
        int paddingLeft = this.gWC + getPaddingLeft() + ((this.gWB - 1) * (this.mImageWidth - this.gWE));
        int paddingTop = this.gWC + getPaddingTop();
        for (int i5 = 0; i5 < this.gWB && i5 < getChildCount() && (childAt = getChildAt(i5)) != null; i5++) {
            childAt.layout(paddingLeft, paddingTop, this.mImageWidth + paddingLeft, this.mImageHeight + paddingTop);
            paddingLeft -= this.mImageWidth - this.gWE;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.mStrokePaint.setColor(am.getColor(this.gWD));
        this.mStrokePaint.setStrokeWidth(this.gWC);
        this.gWH = this.gWH <= 0 ? this.gWD : this.gWH;
        float f = this.gWC * 0.5f;
        float f2 = this.mImageWidth / 2.0f;
        float acos = ((float) ((Math.acos((((f2 * 2.0f) - this.gWE) / 2.0f) / f2) / 3.141592653589793d) * 180.0d)) - 180.0f;
        float abs = Math.abs(acos * 2.0f);
        int childCount = this.gWG ? 0 : getChildCount() - 1;
        int i = 0;
        while (i < getChildCount()) {
            View childAt = getChildAt(i);
            if ((childAt instanceof HeadImageView) && childAt.getVisibility() == 0) {
                float left = childAt.getLeft() - f;
                float top2 = childAt.getTop() - f;
                float right = childAt.getRight() + f;
                float bottom = childAt.getBottom() + f;
                if (i == childCount) {
                    this.mStrokePaint.setColor(am.getColor(this.gWH));
                } else {
                    this.mStrokePaint.setColor(am.getColor(this.gWD));
                }
                canvas.drawArc(left, top2, right, bottom, i == childCount ? 0.0f : acos, i == childCount ? 360.0f : abs, false, this.mStrokePaint);
            }
            i++;
        }
    }

    public void setData(List<String> list) {
        boolean z;
        if (!v.isEmpty(list)) {
            for (int i = this.gWB - 1; i >= 0; i--) {
                HeadImageView headImageView = (HeadImageView) getChildAt(i);
                if (headImageView != null) {
                    String str = null;
                    if (list.size() > 0) {
                        z = true;
                        str = list.remove(0);
                    } else {
                        z = false;
                    }
                    if (!z) {
                        headImageView.setVisibility(4);
                    } else {
                        headImageView.setVisibility(0);
                        if (this.gxZ == 12) {
                            headImageView.a(str, 12, this.mImageWidth, this.mImageHeight, false);
                        } else {
                            headImageView.a(str, 10, this.mImageWidth, this.mImageHeight, false);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void onChangeSkinType() {
        this.mStrokePaint.setColor(am.getColor(this.gWD));
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

    public void setImageClickListener(ImageOverlayView.a aVar) {
        this.gWF = aVar;
    }

    public void setLoadImageType(int i) {
        this.gxZ = i;
    }
}
