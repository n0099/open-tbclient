package com.baidu.tieba.enterForum.tabfeed.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.ColorRes;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.view.ImageOverlayView;
import java.util.List;
/* loaded from: classes21.dex */
public class HotUserRankImageOverlayView extends ViewGroup {
    private int hJj;
    private int hJk;
    private int hJl;
    private int hJm;
    private ImageOverlayView.a hJn;
    private boolean hJo;
    private int hJp;
    private int hJq;
    public final View.OnClickListener hJr;
    private int hky;
    private int mImageHeight;
    private int mImageWidth;
    private Paint mStrokePaint;

    public HotUserRankImageOverlayView(Context context) {
        super(context);
        this.hky = 10;
        this.hJo = false;
        this.hJq = 1;
        this.hJr = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.HotUserRankImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotUserRankImageOverlayView.this.hJn != null) {
                    HotUserRankImageOverlayView.this.hJn.dJl();
                }
            }
        };
        sw();
    }

    public HotUserRankImageOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hky = 10;
        this.hJo = false;
        this.hJq = 1;
        this.hJr = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.HotUserRankImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotUserRankImageOverlayView.this.hJn != null) {
                    HotUserRankImageOverlayView.this.hJn.dJl();
                }
            }
        };
        sw();
    }

    public HotUserRankImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hky = 10;
        this.hJo = false;
        this.hJq = 1;
        this.hJr = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.HotUserRankImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotUserRankImageOverlayView.this.hJn != null) {
                    HotUserRankImageOverlayView.this.hJn.dJl();
                }
            }
        };
        sw();
    }

    public void j(int i, int i2, int i3, int i4, int i5, int i6) {
        this.hJj = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.hJk = i4;
        this.hJl = i5;
        this.hJm = i6;
        ckc();
    }

    public void setFirstImageStrokeColor(@ColorRes int i) {
        this.hJp = i;
    }

    public void setStrokeStyle(int i) {
        this.hJq = i;
    }

    private void sw() {
        this.mStrokePaint = new Paint();
        this.mStrokePaint.setAntiAlias(true);
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
    }

    private void ckc() {
        for (int i = 0; i < this.hJj; i++) {
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
        int i3 = this.hJk;
        if (this.hJq == 1) {
            i3 = this.hJk * 2;
        }
        setMeasuredDimension(resolveSize(((i3 + (getPaddingLeft() + getPaddingRight())) + (this.hJj * this.mImageWidth)) - ((this.hJj - 1) * this.hJm), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight + (this.hJk * 2), i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt;
        int paddingLeft = this.hJk + getPaddingLeft() + ((this.hJj - 1) * (this.mImageWidth - this.hJm));
        int paddingTop = this.hJk + getPaddingTop();
        for (int i5 = 0; i5 < this.hJj && i5 < getChildCount() && (childAt = getChildAt(i5)) != null; i5++) {
            childAt.layout(paddingLeft, paddingTop, this.mImageWidth + paddingLeft, this.mImageHeight + paddingTop);
            paddingLeft -= this.mImageWidth - this.hJm;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.mStrokePaint.setColor(ap.getColor(this.hJl));
        this.mStrokePaint.setStrokeWidth(this.hJk);
        this.hJp = this.hJp <= 0 ? this.hJl : this.hJp;
        float f = this.hJk * 0.5f;
        float f2 = this.mImageWidth / 2.0f;
        float acos = ((float) ((Math.acos((((f2 * 2.0f) - this.hJm) / 2.0f) / f2) / 3.141592653589793d) * 180.0d)) - 180.0f;
        float abs = Math.abs(acos * 2.0f);
        int childCount = this.hJo ? 0 : getChildCount() - 1;
        int i = 0;
        while (i < getChildCount()) {
            View childAt = getChildAt(i);
            if ((childAt instanceof HeadImageView) && childAt.getVisibility() == 0) {
                float left = childAt.getLeft() - f;
                float top = childAt.getTop() - f;
                float right = childAt.getRight() + f;
                float bottom = childAt.getBottom() + f;
                if (i == childCount) {
                    this.mStrokePaint.setColor(ap.getColor(this.hJp));
                } else {
                    this.mStrokePaint.setColor(ap.getColor(this.hJl));
                }
                canvas.drawArc(left, top, right, bottom, i == childCount ? 0.0f : acos, i == childCount ? 360.0f : abs, false, this.mStrokePaint);
            }
            i++;
        }
    }

    public void setData(List<String> list) {
        boolean z;
        if (!y.isEmpty(list)) {
            for (int i = this.hJj - 1; i >= 0; i--) {
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
                        if (this.hky == 12) {
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
        this.mStrokePaint.setColor(ap.getColor(this.hJl));
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
        this.hJn = aVar;
    }

    public void setLoadImageType(int i) {
        this.hky = i;
    }
}
