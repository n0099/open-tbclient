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
    private static final float[] gKt = new float[8];
    private float[] gKv;
    private float[] gKw;
    private float[] gKx;
    private float[] gKy;
    private float mCurrentFraction;
    private final ValueAnimator gKu = ValueAnimator.ofFloat(0.0f, 1.0f);
    private final Path gKz = new Path();
    private final Path gKA = new Path();
    private final Paint gKB = new Paint(1);
    private IconState gKC = IconState.PLAY_STATE;

    /* loaded from: classes4.dex */
    public enum IconState {
        PLAY_STATE,
        PAUSE_STATE
    }

    public PlayDrawable() {
        this.gKB.setColor(-1);
        this.gKu.setDuration(150L);
        this.gKu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.floating.PlayDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PlayDrawable.this.at(valueAnimator.getAnimatedFraction());
            }
        });
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        bVz();
    }

    private void bVz() {
        Rect bVA = bVA();
        int width = (int) (0.074f * getWidth());
        this.gKv = new float[]{bVA.left + width, bVA.top, ((int) bVB()) + width, (bVA.height() * 0.25f) + bVA.top, ((int) bVB()) + width, (bVA.height() * 0.75f) + bVA.top, bVA.left + width, bVA.height() + bVA.top};
        this.gKw = new float[]{((int) bVB()) + width, (bVA.height() * 0.25f) + bVA.top, bVA.left + bVA.width() + width, bVC(), bVA.left + bVA.width() + width, bVC(), width + ((int) bVB()), (bVA.height() * 0.75f) + bVA.top};
        this.gKx = new float[]{bVA.left, bVA.top, bVA.left + (bVA.width() * 0.285f), bVA.top, bVA.left + (bVA.width() * 0.285f), bVA.top + bVA.height(), bVA.left, bVA.top + bVA.height()};
        this.gKy = new float[]{bVA.left + (bVA.width() * 0.715f), bVA.top, bVA.left + bVA.width(), bVA.top, bVA.left + bVA.width(), bVA.top + bVA.height(), bVA.left + (bVA.width() * 0.715f), bVA.height() + bVA.top};
    }

    private Rect bVA() {
        float width = getWidth();
        float height = getHeight();
        float bVD = bVD();
        float bVE = bVE();
        Rect rect = new Rect();
        rect.left = (int) ((width - bVD) / 2.0f);
        rect.top = (int) ((height - bVE) / 2.0f);
        rect.right = (int) (rect.left + bVD);
        rect.bottom = (int) (rect.top + bVE);
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
        a(gKt, fArr, fArr2, f);
        a(path, gKt);
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

    private float bVB() {
        return getBounds().exactCenterX();
    }

    private float bVC() {
        return getBounds().exactCenterY();
    }

    private float bVD() {
        return 0.33f * getWidth();
    }

    private float bVE() {
        return 0.38f * getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        a(canvas, this.gKv, this.gKx, this.mCurrentFraction, this.gKz, this.gKB);
        a(canvas, this.gKw, this.gKy, this.mCurrentFraction, this.gKA, this.gKB);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.gKB.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.gKB.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    private boolean isRunning() {
        return this.gKu.isRunning();
    }

    public void setIconState(IconState iconState) {
        if (isRunning()) {
            this.gKu.cancel();
        }
        this.mCurrentFraction = iconState == IconState.PLAY_STATE ? 0.0f : 1.0f;
        a(iconState);
        invalidateSelf();
    }

    private void a(IconState iconState) {
        this.gKC = iconState;
    }
}
