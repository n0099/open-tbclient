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
/* loaded from: classes7.dex */
public class PlayDrawable extends Drawable {
    private static final float[] fWn = new float[8];
    private float[] fWp;
    private float[] fWq;
    private float[] fWr;
    private float[] fWs;
    private float mCurrentFraction;
    private final ValueAnimator fWo = ValueAnimator.ofFloat(0.0f, 1.0f);
    private final Path fWt = new Path();
    private final Path fWu = new Path();
    private final Paint fWv = new Paint(1);
    private IconState fWw = IconState.PLAY_STATE;

    /* loaded from: classes7.dex */
    public enum IconState {
        PLAY_STATE,
        PAUSE_STATE
    }

    public PlayDrawable() {
        this.fWv.setColor(-1);
        this.fWo.setDuration(150L);
        this.fWo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.floating.PlayDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PlayDrawable.this.ak(valueAnimator.getAnimatedFraction());
            }
        });
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        bJw();
    }

    private void bJw() {
        Rect bJx = bJx();
        int width = (int) (0.074f * getWidth());
        this.fWp = new float[]{bJx.left + width, bJx.top, ((int) bJy()) + width, (bJx.height() * 0.25f) + bJx.top, ((int) bJy()) + width, (bJx.height() * 0.75f) + bJx.top, bJx.left + width, bJx.height() + bJx.top};
        this.fWq = new float[]{((int) bJy()) + width, (bJx.height() * 0.25f) + bJx.top, bJx.left + bJx.width() + width, bJz(), bJx.left + bJx.width() + width, bJz(), width + ((int) bJy()), (bJx.height() * 0.75f) + bJx.top};
        this.fWr = new float[]{bJx.left, bJx.top, bJx.left + (bJx.width() * 0.285f), bJx.top, bJx.left + (bJx.width() * 0.285f), bJx.top + bJx.height(), bJx.left, bJx.top + bJx.height()};
        this.fWs = new float[]{bJx.left + (bJx.width() * 0.715f), bJx.top, bJx.left + bJx.width(), bJx.top, bJx.left + bJx.width(), bJx.top + bJx.height(), bJx.left + (bJx.width() * 0.715f), bJx.height() + bJx.top};
    }

    private Rect bJx() {
        float width = getWidth();
        float height = getHeight();
        float bJA = bJA();
        float bJB = bJB();
        Rect rect = new Rect();
        rect.left = (int) ((width - bJA) / 2.0f);
        rect.top = (int) ((height - bJB) / 2.0f);
        rect.right = (int) (rect.left + bJA);
        rect.bottom = (int) (rect.top + bJB);
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
        a(fWn, fArr, fArr2, f);
        a(path, fWn);
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

    private float bJy() {
        return getBounds().exactCenterX();
    }

    private float bJz() {
        return getBounds().exactCenterY();
    }

    private float bJA() {
        return 0.33f * getWidth();
    }

    private float bJB() {
        return 0.38f * getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        a(canvas, this.fWp, this.fWr, this.mCurrentFraction, this.fWt, this.fWv);
        a(canvas, this.fWq, this.fWs, this.mCurrentFraction, this.fWu, this.fWv);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.fWv.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.fWv.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    private boolean isRunning() {
        return this.fWo.isRunning();
    }

    public void setIconState(IconState iconState) {
        if (isRunning()) {
            this.fWo.cancel();
        }
        this.mCurrentFraction = iconState == IconState.PLAY_STATE ? 0.0f : 1.0f;
        a(iconState);
        invalidateSelf();
    }

    private void a(IconState iconState) {
        this.fWw = iconState;
    }
}
