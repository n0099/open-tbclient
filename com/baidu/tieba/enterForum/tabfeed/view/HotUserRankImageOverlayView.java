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
    private int gHK;
    private int gHL;
    private int gHM;
    private int gHN;
    private ImageOverlayView.a gHO;
    private boolean gHP;
    private int gHQ;
    private int gHR;
    public final View.OnClickListener gHS;
    private int gjd;
    private int mImageHeight;
    private int mImageWidth;
    private Paint mStrokePaint;

    public HotUserRankImageOverlayView(Context context) {
        super(context);
        this.gjd = 10;
        this.gHP = false;
        this.gHR = 1;
        this.gHS = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.HotUserRankImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotUserRankImageOverlayView.this.gHO != null) {
                    HotUserRankImageOverlayView.this.gHO.deG();
                }
            }
        };
        qs();
    }

    public HotUserRankImageOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gjd = 10;
        this.gHP = false;
        this.gHR = 1;
        this.gHS = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.HotUserRankImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotUserRankImageOverlayView.this.gHO != null) {
                    HotUserRankImageOverlayView.this.gHO.deG();
                }
            }
        };
        qs();
    }

    public HotUserRankImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gjd = 10;
        this.gHP = false;
        this.gHR = 1;
        this.gHS = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.HotUserRankImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotUserRankImageOverlayView.this.gHO != null) {
                    HotUserRankImageOverlayView.this.gHO.deG();
                }
            }
        };
        qs();
    }

    public void k(int i, int i2, int i3, int i4, int i5, int i6) {
        this.gHK = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.gHL = i4;
        this.gHM = i5;
        this.gHN = i6;
        bJI();
    }

    public void setFirstImageStrokeColor(@ColorRes int i) {
        this.gHQ = i;
    }

    public void setStrokeStyle(int i) {
        this.gHR = i;
    }

    private void qs() {
        this.mStrokePaint = new Paint();
        this.mStrokePaint.setAntiAlias(true);
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
    }

    private void bJI() {
        for (int i = 0; i < this.gHK; i++) {
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
        int i3 = this.gHL;
        if (this.gHR == 1) {
            i3 = this.gHL * 2;
        }
        setMeasuredDimension(resolveSize(((i3 + (getPaddingLeft() + getPaddingRight())) + (this.gHK * this.mImageWidth)) - ((this.gHK - 1) * this.gHN), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight + (this.gHL * 2), i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt;
        int paddingLeft = this.gHL + getPaddingLeft() + ((this.gHK - 1) * (this.mImageWidth - this.gHN));
        int paddingTop = this.gHL + getPaddingTop();
        for (int i5 = 0; i5 < this.gHK && i5 < getChildCount() && (childAt = getChildAt(i5)) != null; i5++) {
            childAt.layout(paddingLeft, paddingTop, this.mImageWidth + paddingLeft, this.mImageHeight + paddingTop);
            paddingLeft -= this.mImageWidth - this.gHN;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.mStrokePaint.setColor(am.getColor(this.gHM));
        this.mStrokePaint.setStrokeWidth(this.gHL);
        this.gHQ = this.gHQ <= 0 ? this.gHM : this.gHQ;
        float f = this.gHL * 0.5f;
        float f2 = this.mImageWidth / 2.0f;
        float acos = ((float) ((Math.acos((((f2 * 2.0f) - this.gHN) / 2.0f) / f2) / 3.141592653589793d) * 180.0d)) - 180.0f;
        float abs = Math.abs(acos * 2.0f);
        int childCount = this.gHP ? 0 : getChildCount() - 1;
        int i = 0;
        while (i < getChildCount()) {
            View childAt = getChildAt(i);
            if ((childAt instanceof HeadImageView) && childAt.getVisibility() == 0) {
                float left = childAt.getLeft() - f;
                float top2 = childAt.getTop() - f;
                float right = childAt.getRight() + f;
                float bottom = childAt.getBottom() + f;
                if (i == childCount) {
                    this.mStrokePaint.setColor(am.getColor(this.gHQ));
                } else {
                    this.mStrokePaint.setColor(am.getColor(this.gHM));
                }
                canvas.drawArc(left, top2, right, bottom, i == childCount ? 0.0f : acos, i == childCount ? 360.0f : abs, false, this.mStrokePaint);
            }
            i++;
        }
    }

    public void setData(List<String> list) {
        boolean z;
        if (!v.isEmpty(list)) {
            for (int i = this.gHK - 1; i >= 0; i--) {
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
                        if (this.gjd == 12) {
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
        this.mStrokePaint.setColor(am.getColor(this.gHM));
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
        this.gHO = aVar;
    }

    public void setLoadImageType(int i) {
        this.gjd = i;
    }
}
