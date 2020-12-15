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
    private static final float[] gKv = new float[8];
    private float[] gKA;
    private float[] gKx;
    private float[] gKy;
    private float[] gKz;
    private float mCurrentFraction;
    private final ValueAnimator gKw = ValueAnimator.ofFloat(0.0f, 1.0f);
    private final Path gKB = new Path();
    private final Path gKC = new Path();
    private final Paint gKD = new Paint(1);
    private IconState gKE = IconState.PLAY_STATE;

    /* loaded from: classes4.dex */
    public enum IconState {
        PLAY_STATE,
        PAUSE_STATE
    }

    public PlayDrawable() {
        this.gKD.setColor(-1);
        this.gKw.setDuration(150L);
        this.gKw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.floating.PlayDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PlayDrawable.this.at(valueAnimator.getAnimatedFraction());
            }
        });
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        bVA();
    }

    private void bVA() {
        Rect bVB = bVB();
        int width = (int) (0.074f * getWidth());
        this.gKx = new float[]{bVB.left + width, bVB.top, ((int) bVC()) + width, (bVB.height() * 0.25f) + bVB.top, ((int) bVC()) + width, (bVB.height() * 0.75f) + bVB.top, bVB.left + width, bVB.height() + bVB.top};
        this.gKy = new float[]{((int) bVC()) + width, (bVB.height() * 0.25f) + bVB.top, bVB.left + bVB.width() + width, bVD(), bVB.left + bVB.width() + width, bVD(), width + ((int) bVC()), (bVB.height() * 0.75f) + bVB.top};
        this.gKz = new float[]{bVB.left, bVB.top, bVB.left + (bVB.width() * 0.285f), bVB.top, bVB.left + (bVB.width() * 0.285f), bVB.top + bVB.height(), bVB.left, bVB.top + bVB.height()};
        this.gKA = new float[]{bVB.left + (bVB.width() * 0.715f), bVB.top, bVB.left + bVB.width(), bVB.top, bVB.left + bVB.width(), bVB.top + bVB.height(), bVB.left + (bVB.width() * 0.715f), bVB.height() + bVB.top};
    }

    private Rect bVB() {
        float width = getWidth();
        float height = getHeight();
        float bVE = bVE();
        float bVF = bVF();
        Rect rect = new Rect();
        rect.left = (int) ((width - bVE) / 2.0f);
        rect.top = (int) ((height - bVF) / 2.0f);
        rect.right = (int) (rect.left + bVE);
        rect.bottom = (int) (rect.top + bVF);
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
        a(gKv, fArr, fArr2, f);
        a(path, gKv);
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
    public void at(float f) {
        this.mCurrentFraction = f;
        invalidateSelf();
    }

    private float getWidth() {
        return getBounds().width();
    }

    private float getHeight() {
        return getBounds().height();
    }

    private float bVC() {
        return getBounds().exactCenterX();
    }

    private float bVD() {
        return getBounds().exactCenterY();
    }

    private float bVE() {
        return 0.33f * getWidth();
    }

    private float bVF() {
        return 0.38f * getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        a(canvas, this.gKx, this.gKz, this.mCurrentFraction, this.gKB, this.gKD);
        a(canvas, this.gKy, this.gKA, this.mCurrentFraction, this.gKC, this.gKD);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.gKD.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.gKD.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    private boolean isRunning() {
        return this.gKw.isRunning();
    }

    public void setIconState(IconState iconState) {
        if (isRunning()) {
            this.gKw.cancel();
        }
        this.mCurrentFraction = iconState == IconState.PLAY_STATE ? 0.0f : 1.0f;
        a(iconState);
        invalidateSelf();
    }

    private void a(IconState iconState) {
        this.gKE = iconState;
    }
}
