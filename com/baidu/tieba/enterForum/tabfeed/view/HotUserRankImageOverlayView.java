package com.baidu.tieba.enterForum.tabfeed.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.ColorRes;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.view.ImageOverlayView;
import java.util.List;
/* loaded from: classes2.dex */
public class HotUserRankImageOverlayView extends ViewGroup {
    private int iPL;
    private int iPM;
    private int iPN;
    private int iPO;
    private ImageOverlayView.a iPP;
    private boolean iPQ;
    private int iPR;
    private int iPS;
    public final View.OnClickListener iPT;
    private int iqT;
    private int mImageHeight;
    private int mImageWidth;
    private Paint mStrokePaint;

    public HotUserRankImageOverlayView(Context context) {
        super(context);
        this.iqT = 10;
        this.iPQ = false;
        this.iPS = 1;
        this.iPT = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.HotUserRankImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotUserRankImageOverlayView.this.iPP != null) {
                    HotUserRankImageOverlayView.this.iPP.dWj();
                }
            }
        };
        rX();
    }

    public HotUserRankImageOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iqT = 10;
        this.iPQ = false;
        this.iPS = 1;
        this.iPT = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.HotUserRankImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotUserRankImageOverlayView.this.iPP != null) {
                    HotUserRankImageOverlayView.this.iPP.dWj();
                }
            }
        };
        rX();
    }

    public HotUserRankImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iqT = 10;
        this.iPQ = false;
        this.iPS = 1;
        this.iPT = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.HotUserRankImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotUserRankImageOverlayView.this.iPP != null) {
                    HotUserRankImageOverlayView.this.iPP.dWj();
                }
            }
        };
        rX();
    }

    public void l(int i, int i2, int i3, int i4, int i5, int i6) {
        this.iPL = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.iPM = i4;
        this.iPN = i5;
        this.iPO = i6;
        cxu();
    }

    public void setFirstImageStrokeColor(@ColorRes int i) {
        this.iPR = i;
    }

    public void setStrokeStyle(int i) {
        this.iPS = i;
    }

    private void rX() {
        this.mStrokePaint = new Paint();
        this.mStrokePaint.setAntiAlias(true);
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
    }

    private void cxu() {
        for (int i = 0; i < this.iPL; i++) {
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
        int i3 = this.iPM;
        if (this.iPS == 1) {
            i3 = this.iPM * 2;
        }
        setMeasuredDimension(resolveSize(((i3 + (getPaddingLeft() + getPaddingRight())) + (this.iPL * this.mImageWidth)) - ((this.iPL - 1) * this.iPO), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight + (this.iPM * 2), i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt;
        int paddingLeft = this.iPM + getPaddingLeft() + ((this.iPL - 1) * (this.mImageWidth - this.iPO));
        int paddingTop = this.iPM + getPaddingTop();
        for (int i5 = 0; i5 < this.iPL && i5 < getChildCount() && (childAt = getChildAt(i5)) != null; i5++) {
            childAt.layout(paddingLeft, paddingTop, this.mImageWidth + paddingLeft, this.mImageHeight + paddingTop);
            paddingLeft -= this.mImageWidth - this.iPO;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.mStrokePaint.setColor(ap.getColor(this.iPN));
        this.mStrokePaint.setStrokeWidth(this.iPM);
        this.iPR = this.iPR <= 0 ? this.iPN : this.iPR;
        float f = this.iPM * 0.5f;
        float f2 = this.mImageWidth / 2.0f;
        float acos = ((float) ((Math.acos((((f2 * 2.0f) - this.iPO) / 2.0f) / f2) / 3.141592653589793d) * 180.0d)) - 180.0f;
        float abs = Math.abs(acos * 2.0f);
        int childCount = this.iPQ ? 0 : getChildCount() - 1;
        int i = 0;
        while (i < getChildCount()) {
            View childAt = getChildAt(i);
            if ((childAt instanceof HeadImageView) && childAt.getVisibility() == 0) {
                float left = childAt.getLeft() - f;
                float top = childAt.getTop() - f;
                float right = childAt.getRight() + f;
                float bottom = childAt.getBottom() + f;
                if (i == childCount) {
                    this.mStrokePaint.setColor(ap.getColor(this.iPR));
                } else {
                    this.mStrokePaint.setColor(ap.getColor(this.iPN));
                }
                canvas.drawArc(left, top, right, bottom, i == childCount ? 0.0f : acos, i == childCount ? 360.0f : abs, false, this.mStrokePaint);
            }
            i++;
        }
    }

    public void setData(List<String> list) {
        boolean z;
        if (!y.isEmpty(list)) {
            for (int i = this.iPL - 1; i >= 0; i--) {
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
                        if (this.iqT == 12) {
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
        this.mStrokePaint.setColor(ap.getColor(this.iPN));
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
        this.iPP = aVar;
    }

    public void setLoadImageType(int i) {
        this.iqT = i;
    }
}
