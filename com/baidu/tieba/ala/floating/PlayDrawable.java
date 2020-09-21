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
    private static final float[] fZE = new float[8];
    private float[] fZG;
    private float[] fZH;
    private float[] fZI;
    private float[] fZJ;
    private float mCurrentFraction;
    private final ValueAnimator fZF = ValueAnimator.ofFloat(0.0f, 1.0f);
    private final Path fZK = new Path();
    private final Path fZL = new Path();
    private final Paint fZM = new Paint(1);
    private IconState fZN = IconState.PLAY_STATE;

    /* loaded from: classes4.dex */
    public enum IconState {
        PLAY_STATE,
        PAUSE_STATE
    }

    public PlayDrawable() {
        this.fZM.setColor(-1);
        this.fZF.setDuration(150L);
        this.fZF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.floating.PlayDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PlayDrawable.this.ak(valueAnimator.getAnimatedFraction());
            }
        });
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        bKH();
    }

    private void bKH() {
        Rect bKI = bKI();
        int width = (int) (0.074f * getWidth());
        this.fZG = new float[]{bKI.left + width, bKI.top, ((int) bKJ()) + width, (bKI.height() * 0.25f) + bKI.top, ((int) bKJ()) + width, (bKI.height() * 0.75f) + bKI.top, bKI.left + width, bKI.height() + bKI.top};
        this.fZH = new float[]{((int) bKJ()) + width, (bKI.height() * 0.25f) + bKI.top, bKI.left + bKI.width() + width, bKK(), bKI.left + bKI.width() + width, bKK(), width + ((int) bKJ()), (bKI.height() * 0.75f) + bKI.top};
        this.fZI = new float[]{bKI.left, bKI.top, bKI.left + (bKI.width() * 0.285f), bKI.top, bKI.left + (bKI.width() * 0.285f), bKI.top + bKI.height(), bKI.left, bKI.top + bKI.height()};
        this.fZJ = new float[]{bKI.left + (bKI.width() * 0.715f), bKI.top, bKI.left + bKI.width(), bKI.top, bKI.left + bKI.width(), bKI.top + bKI.height(), bKI.left + (bKI.width() * 0.715f), bKI.height() + bKI.top};
    }

    private Rect bKI() {
        float width = getWidth();
        float height = getHeight();
        float bKL = bKL();
        float bKM = bKM();
        Rect rect = new Rect();
        rect.left = (int) ((width - bKL) / 2.0f);
        rect.top = (int) ((height - bKM) / 2.0f);
        rect.right = (int) (rect.left + bKL);
        rect.bottom = (int) (rect.top + bKM);
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
        a(fZE, fArr, fArr2, f);
        a(path, fZE);
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
    public void ak(float f) {
        this.mCurrentFraction = f;
        invalidateSelf();
    }

    private float getWidth() {
        return getBounds().width();
    }

    private float getHeight() {
        return getBounds().height();
    }

    private float bKJ() {
        return getBounds().exactCenterX();
    }

    private float bKK() {
        return getBounds().exactCenterY();
    }

    private float bKL() {
        return 0.33f * getWidth();
    }

    private float bKM() {
        return 0.38f * getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        a(canvas, this.fZG, this.fZI, this.mCurrentFraction, this.fZK, this.fZM);
        a(canvas, this.fZH, this.fZJ, this.mCurrentFraction, this.fZL, this.fZM);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.fZM.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.fZM.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    private boolean isRunning() {
        return this.fZF.isRunning();
    }

    public void setIconState(IconState iconState) {
        if (isRunning()) {
            this.fZF.cancel();
        }
        this.mCurrentFraction = iconState == IconState.PLAY_STATE ? 0.0f : 1.0f;
        a(iconState);
        invalidateSelf();
    }

    private void a(IconState iconState) {
        this.fZN = iconState;
    }
}
