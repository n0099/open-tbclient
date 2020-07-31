package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class FRSRefreshButton extends ImageView {
    private int color;
    private AlphaAnimation eLA;
    private PorterDuffXfermode eLw;
    private PorterDuffXfermode eLx;
    private boolean eLy;
    private AlphaAnimation eLz;
    private int mHeight;
    private Drawable mIcon;
    private Paint mPaint;
    private int mSkinType;
    private int mWidth;

    public FRSRefreshButton(Context context) {
        this(context, null);
    }

    public FRSRefreshButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FRSRefreshButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.color = R.color.cp_bg_line_k;
        this.eLw = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.eLx = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        this.mSkinType = 3;
        this.eLy = false;
        this.eLz = null;
        this.eLA = null;
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setAntiAlias(true);
        this.mIcon = SvgManager.baR().a(R.drawable.icon_pure_refresh24_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL);
        setLayerType(1, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mWidth > 0 && this.mHeight > 0) {
            int saveCount = canvas.getSaveCount();
            canvas.save();
            B(canvas);
            canvas.rotate(45.0f, this.mWidth / 2, this.mHeight / 2);
            this.mPaint.setShadowLayer(16.0f, 5.0f, 5.0f, com.baidu.tieba.tbadkCore.c.l(R.color.cp_shadow_a, 0.16f));
            this.mPaint.setColor(ao.getColor(this.color));
            canvas.drawCircle(this.mWidth / 2, this.mHeight / 2, (this.mWidth / 2) - 20, this.mPaint);
            A(canvas);
            if (saveCount >= 1 && saveCount <= canvas.getSaveCount()) {
                canvas.restoreToCount(saveCount);
            }
        }
    }

    private void A(Canvas canvas) {
        canvas.save();
        canvas.rotate(-45.0f, canvas.getWidth() / 2, canvas.getHeight() / 2);
        int width = (getWidth() / 2) - (this.mIcon.getIntrinsicWidth() / 2);
        int height = (getHeight() / 2) - (this.mIcon.getIntrinsicHeight() / 2);
        int height2 = (getHeight() / 2) + (this.mIcon.getIntrinsicHeight() / 2);
        this.mIcon.setBounds(width + 3, height + 3, ((getWidth() / 2) + (this.mIcon.getIntrinsicWidth() / 2)) - 3, height2 - 3);
        this.mIcon.draw(canvas);
        canvas.restore();
    }

    private void B(Canvas canvas) {
        this.mPaint.setXfermode(this.eLw);
        canvas.drawPaint(this.mPaint);
        this.mPaint.setXfermode(this.eLx);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.mIcon = SvgManager.baR().a(R.drawable.icon_pure_refresh24_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL);
            invalidate();
        }
    }

    public void hide() {
        if (this.eLy) {
            if (this.eLz != null) {
                this.eLz.cancel();
            }
            this.eLz = new AlphaAnimation(1.0f, 0.0f);
            this.eLz.setDuration(300L);
            this.eLz.setFillAfter(true);
            startAnimation(this.eLz);
            setClickable(false);
            this.eLy = false;
        }
    }

    public void show() {
        if (!this.eLy) {
            setVisibility(0);
            if (this.eLA != null) {
                this.eLA.cancel();
            }
            this.eLA = new AlphaAnimation(0.0f, 1.0f);
            this.eLA.setDuration(300L);
            this.eLA.setFillAfter(true);
            startAnimation(this.eLA);
            setClickable(true);
            this.eLy = true;
        }
    }
}
