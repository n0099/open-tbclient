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
    private PorterDuffXfermode fLH;
    private PorterDuffXfermode fLI;
    private boolean fLJ;
    private AlphaAnimation fLK;
    private AlphaAnimation fLL;
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
        this.color = R.color.CAM_X0211;
        this.fLH = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.fLI = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        this.mSkinType = 3;
        this.fLJ = false;
        this.fLK = null;
        this.fLL = null;
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setAntiAlias(true);
        this.mIcon = SvgManager.bsx().a(R.drawable.icon_pure_refresh24_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL);
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
            clear(canvas);
            canvas.rotate(45.0f, this.mWidth / 2, this.mHeight / 2);
            this.mPaint.setShadowLayer(16.0f, 5.0f, 5.0f, ao.getColor(R.color.CAM_X0804));
            this.mPaint.setColor(ao.getColor(this.color));
            canvas.drawCircle(this.mWidth / 2, this.mHeight / 2, (this.mWidth / 2) - 20, this.mPaint);
            N(canvas);
            if (saveCount >= 1 && saveCount <= canvas.getSaveCount()) {
                canvas.restoreToCount(saveCount);
            }
        }
    }

    private void N(Canvas canvas) {
        canvas.save();
        canvas.rotate(-45.0f, canvas.getWidth() / 2, canvas.getHeight() / 2);
        int width = (getWidth() / 2) - (this.mIcon.getIntrinsicWidth() / 2);
        int height = (getHeight() / 2) - (this.mIcon.getIntrinsicHeight() / 2);
        int height2 = (getHeight() / 2) + (this.mIcon.getIntrinsicHeight() / 2);
        this.mIcon.setBounds(width + 3, height + 3, ((getWidth() / 2) + (this.mIcon.getIntrinsicWidth() / 2)) - 3, height2 - 3);
        this.mIcon.draw(canvas);
        canvas.restore();
    }

    private void clear(Canvas canvas) {
        this.mPaint.setXfermode(this.fLH);
        canvas.drawPaint(this.mPaint);
        this.mPaint.setXfermode(this.fLI);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.mIcon = SvgManager.bsx().a(R.drawable.icon_pure_refresh24_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL);
            invalidate();
        }
    }

    public void hide() {
        if (this.fLJ) {
            if (this.fLK != null) {
                this.fLK.cancel();
            }
            this.fLK = new AlphaAnimation(1.0f, 0.0f);
            this.fLK.setDuration(300L);
            this.fLK.setFillAfter(true);
            startAnimation(this.fLK);
            setClickable(false);
            this.fLJ = false;
        }
    }

    public void show() {
        if (!this.fLJ) {
            setVisibility(0);
            if (this.fLL != null) {
                this.fLL.cancel();
            }
            this.fLL = new AlphaAnimation(0.0f, 1.0f);
            this.fLL.setDuration(300L);
            this.fLL.setFillAfter(true);
            startAnimation(this.fLL);
            setClickable(true);
            this.fLJ = true;
        }
    }
}
