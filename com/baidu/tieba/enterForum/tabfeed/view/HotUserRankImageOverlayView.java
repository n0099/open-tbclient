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
/* loaded from: classes22.dex */
public class HotUserRankImageOverlayView extends ViewGroup {
    private int iCk;
    private int iCl;
    private int iCm;
    private int iCn;
    private ImageOverlayView.a iCo;
    private boolean iCp;
    private int iCq;
    private int iCr;
    public final View.OnClickListener iCs;
    private int idh;
    private int mImageHeight;
    private int mImageWidth;
    private Paint mStrokePaint;

    public HotUserRankImageOverlayView(Context context) {
        super(context);
        this.idh = 10;
        this.iCp = false;
        this.iCr = 1;
        this.iCs = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.HotUserRankImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotUserRankImageOverlayView.this.iCo != null) {
                    HotUserRankImageOverlayView.this.iCo.dYb();
                }
            }
        };
        sz();
    }

    public HotUserRankImageOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.idh = 10;
        this.iCp = false;
        this.iCr = 1;
        this.iCs = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.HotUserRankImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotUserRankImageOverlayView.this.iCo != null) {
                    HotUserRankImageOverlayView.this.iCo.dYb();
                }
            }
        };
        sz();
    }

    public HotUserRankImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.idh = 10;
        this.iCp = false;
        this.iCr = 1;
        this.iCs = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.HotUserRankImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotUserRankImageOverlayView.this.iCo != null) {
                    HotUserRankImageOverlayView.this.iCo.dYb();
                }
            }
        };
        sz();
    }

    public void k(int i, int i2, int i3, int i4, int i5, int i6) {
        this.iCk = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.iCl = i4;
        this.iCm = i5;
        this.iCn = i6;
        cwZ();
    }

    public void setFirstImageStrokeColor(@ColorRes int i) {
        this.iCq = i;
    }

    public void setStrokeStyle(int i) {
        this.iCr = i;
    }

    private void sz() {
        this.mStrokePaint = new Paint();
        this.mStrokePaint.setAntiAlias(true);
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
    }

    private void cwZ() {
        for (int i = 0; i < this.iCk; i++) {
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
        int i3 = this.iCl;
        if (this.iCr == 1) {
            i3 = this.iCl * 2;
        }
        setMeasuredDimension(resolveSize(((i3 + (getPaddingLeft() + getPaddingRight())) + (this.iCk * this.mImageWidth)) - ((this.iCk - 1) * this.iCn), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight + (this.iCl * 2), i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt;
        int paddingLeft = this.iCl + getPaddingLeft() + ((this.iCk - 1) * (this.mImageWidth - this.iCn));
        int paddingTop = this.iCl + getPaddingTop();
        for (int i5 = 0; i5 < this.iCk && i5 < getChildCount() && (childAt = getChildAt(i5)) != null; i5++) {
            childAt.layout(paddingLeft, paddingTop, this.mImageWidth + paddingLeft, this.mImageHeight + paddingTop);
            paddingLeft -= this.mImageWidth - this.iCn;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.mStrokePaint.setColor(ap.getColor(this.iCm));
        this.mStrokePaint.setStrokeWidth(this.iCl);
        this.iCq = this.iCq <= 0 ? this.iCm : this.iCq;
        float f = this.iCl * 0.5f;
        float f2 = this.mImageWidth / 2.0f;
        float acos = ((float) ((Math.acos((((f2 * 2.0f) - this.iCn) / 2.0f) / f2) / 3.141592653589793d) * 180.0d)) - 180.0f;
        float abs = Math.abs(acos * 2.0f);
        int childCount = this.iCp ? 0 : getChildCount() - 1;
        int i = 0;
        while (i < getChildCount()) {
            View childAt = getChildAt(i);
            if ((childAt instanceof HeadImageView) && childAt.getVisibility() == 0) {
                float left = childAt.getLeft() - f;
                float top = childAt.getTop() - f;
                float right = childAt.getRight() + f;
                float bottom = childAt.getBottom() + f;
                if (i == childCount) {
                    this.mStrokePaint.setColor(ap.getColor(this.iCq));
                } else {
                    this.mStrokePaint.setColor(ap.getColor(this.iCm));
                }
                canvas.drawArc(left, top, right, bottom, i == childCount ? 0.0f : acos, i == childCount ? 360.0f : abs, false, this.mStrokePaint);
            }
            i++;
        }
    }

    public void setData(List<String> list) {
        boolean z;
        if (!y.isEmpty(list)) {
            for (int i = this.iCk - 1; i >= 0; i--) {
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
                        if (this.idh == 12) {
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
        this.mStrokePaint.setColor(ap.getColor(this.iCm));
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
        this.iCo = aVar;
    }

    public void setLoadImageType(int i) {
        this.idh = i;
    }
}
