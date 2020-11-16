package com.baidu.tieba.ala.floating;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
/* loaded from: classes4.dex */
public class PlayDrawable extends Drawable {
    private static final float[] gBw = new float[8];
    private float[] gBA;
    private float[] gBB;
    private float[] gBy;
    private float[] gBz;
    private float mCurrentFraction;
    private final ValueAnimator gBx = ValueAnimator.ofFloat(0.0f, 1.0f);
    private final Path gBC = new Path();
    private final Path gBD = new Path();
    private final Paint gBE = new Paint(1);
    private IconState gBF = IconState.PLAY_STATE;

    /* loaded from: classes4.dex */
    public enum IconState {
        PLAY_STATE,
        PAUSE_STATE
    }

    public PlayDrawable() {
        this.gBE.setColor(-1);
        this.gBx.setDuration(150L);
        this.gBx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.floating.PlayDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PlayDrawable.this.as(valueAnimator.getAnimatedFraction());
            }
        });
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        bRP();
    }

    private void bRP() {
        Rect bRQ = bRQ();
        int width = (int) (0.074f * getWidth());
        this.gBy = new float[]{bRQ.left + width, bRQ.top, ((int) bRR()) + width, (bRQ.height() * 0.25f) + bRQ.top, ((int) bRR()) + width, (bRQ.height() * 0.75f) + bRQ.top, bRQ.left + width, bRQ.height() + bRQ.top};
        this.gBz = new float[]{((int) bRR()) + width, (bRQ.height() * 0.25f) + bRQ.top, bRQ.left + bRQ.width() + width, bRS(), bRQ.left + bRQ.width() + width, bRS(), width + ((int) bRR()), (bRQ.height() * 0.75f) + bRQ.top};
        this.gBA = new float[]{bRQ.left, bRQ.top, bRQ.left + (bRQ.width() * 0.285f), bRQ.top, bRQ.left + (bRQ.width() * 0.285f), bRQ.top + bRQ.height(), bRQ.left, bRQ.top + bRQ.height()};
        this.gBB = new float[]{bRQ.left + (bRQ.width() * 0.715f), bRQ.top, bRQ.left + bRQ.width(), bRQ.top, bRQ.left + bRQ.width(), bRQ.top + bRQ.height(), bRQ.left + (bRQ.width() * 0.715f), bRQ.height() + bRQ.top};
    }

    private Rect bRQ() {
        float width = getWidth();
        float height = getHeight();
        float bRT = bRT();
        float bRU = bRU();
        Rect rect = new Rect();
        rect.left = (int) ((width - bRT) / 2.0f);
        rect.top = (int) ((height - bRU) / 2.0f);
        rect.right = (int) (rect.left + bRT);
        rect.bottom = (int) (rect.top + bRU);
        return rect;
    }

    private void a(float[] fArr, float[] fArr2, float[] fArr3, float f) {
        if (fArr != null && fArr2 != null && fArr3 != null && fArr.length == fArr2.length) {
            int length = fArr2.length;
            for (int i = 0; i < length; i++) {
                fArr[i] = g(fArr2[i], fArr3[i], f);
            }
        }
    }

    private void a(Canvas canvas, float[] fArr, float[] fArr2, float f, Path path, Paint paint) {
        a(gBw, fArr, fArr2, f);
        a(path, gBw);
        canvas.drawPath(path, paint);
    }

    private void a(@NonNull Path path, @NonNull float[] fArr) {
        if (!path.isEmpty()) {
            path.rewind();
        }
        path.moveTo(fArr[0], fArr[1]);
        path.lineTo(fArr[2], fArr[3]);
        path.lineTo(fArr[4], fArr[5]);
        path.lineTo(fArr[6], fArr[7]);
    }

    private float g(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(float f) {
        this.mCurrentFraction = f;
        invalidateSelf();
    }

    private float getWidth() {
        return getBounds().width();
    }

    private float getHeight() {
        return getBounds().height();
    }

    private float bRR() {
        return getBounds().exactCenterX();
    }

    private float bRS() {
        return getBounds().exactCenterY();
    }

    private float bRT() {
        return 0.33f * getWidth();
    }

    private float bRU() {
        return 0.38f * getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        a(canvas, this.gBy, this.gBA, this.mCurrentFraction, this.gBC, this.gBE);
        a(canvas, this.gBz, this.gBB, this.mCurrentFraction, this.gBD, this.gBE);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.gBE.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.gBE.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    private boolean isRunning() {
        return this.gBx.isRunning();
    }

    public void setIconState(IconState iconState) {
        if (isRunning()) {
            this.gBx.cancel();
        }
        this.mCurrentFraction = iconState == IconState.PLAY_STATE ? 0.0f : 1.0f;
        a(iconState);
        invalidateSelf();
    }

    private void a(IconState iconState) {
        this.gBF = iconState;
    }
}
