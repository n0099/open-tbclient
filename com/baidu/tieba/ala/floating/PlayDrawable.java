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
    private static final float[] gBP = new float[8];
    private float[] gBR;
    private float[] gBS;
    private float[] gBT;
    private float[] gBU;
    private float mCurrentFraction;
    private final ValueAnimator gBQ = ValueAnimator.ofFloat(0.0f, 1.0f);
    private final Path gBV = new Path();
    private final Path gBW = new Path();
    private final Paint gBX = new Paint(1);
    private IconState gBY = IconState.PLAY_STATE;

    /* loaded from: classes4.dex */
    public enum IconState {
        PLAY_STATE,
        PAUSE_STATE
    }

    public PlayDrawable() {
        this.gBX.setColor(-1);
        this.gBQ.setDuration(150L);
        this.gBQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.floating.PlayDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PlayDrawable.this.aq(valueAnimator.getAnimatedFraction());
            }
        });
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        bSw();
    }

    private void bSw() {
        Rect bSx = bSx();
        int width = (int) (0.074f * getWidth());
        this.gBR = new float[]{bSx.left + width, bSx.top, ((int) bSy()) + width, (bSx.height() * 0.25f) + bSx.top, ((int) bSy()) + width, (bSx.height() * 0.75f) + bSx.top, bSx.left + width, bSx.height() + bSx.top};
        this.gBS = new float[]{((int) bSy()) + width, (bSx.height() * 0.25f) + bSx.top, bSx.left + bSx.width() + width, bSz(), bSx.left + bSx.width() + width, bSz(), width + ((int) bSy()), (bSx.height() * 0.75f) + bSx.top};
        this.gBT = new float[]{bSx.left, bSx.top, bSx.left + (bSx.width() * 0.285f), bSx.top, bSx.left + (bSx.width() * 0.285f), bSx.top + bSx.height(), bSx.left, bSx.top + bSx.height()};
        this.gBU = new float[]{bSx.left + (bSx.width() * 0.715f), bSx.top, bSx.left + bSx.width(), bSx.top, bSx.left + bSx.width(), bSx.top + bSx.height(), bSx.left + (bSx.width() * 0.715f), bSx.height() + bSx.top};
    }

    private Rect bSx() {
        float width = getWidth();
        float height = getHeight();
        float bSA = bSA();
        float bSB = bSB();
        Rect rect = new Rect();
        rect.left = (int) ((width - bSA) / 2.0f);
        rect.top = (int) ((height - bSB) / 2.0f);
        rect.right = (int) (rect.left + bSA);
        rect.bottom = (int) (rect.top + bSB);
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
        a(gBP, fArr, fArr2, f);
        a(path, gBP);
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
    public void aq(float f) {
        this.mCurrentFraction = f;
        invalidateSelf();
    }

    private float getWidth() {
        return getBounds().width();
    }

    private float getHeight() {
        return getBounds().height();
    }

    private float bSy() {
        return getBounds().exactCenterX();
    }

    private float bSz() {
        return getBounds().exactCenterY();
    }

    private float bSA() {
        return 0.33f * getWidth();
    }

    private float bSB() {
        return 0.38f * getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        a(canvas, this.gBR, this.gBT, this.mCurrentFraction, this.gBV, this.gBX);
        a(canvas, this.gBS, this.gBU, this.mCurrentFraction, this.gBW, this.gBX);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.gBX.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.gBX.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    private boolean isRunning() {
        return this.gBQ.isRunning();
    }

    public void setIconState(IconState iconState) {
        if (isRunning()) {
            this.gBQ.cancel();
        }
        this.mCurrentFraction = iconState == IconState.PLAY_STATE ? 0.0f : 1.0f;
        a(iconState);
        invalidateSelf();
    }

    private void a(IconState iconState) {
        this.gBY = iconState;
    }
}
