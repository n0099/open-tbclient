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
    private static final float[] fWr = new float[8];
    private float[] fWt;
    private float[] fWu;
    private float[] fWv;
    private float[] fWw;
    private float mCurrentFraction;
    private final ValueAnimator fWs = ValueAnimator.ofFloat(0.0f, 1.0f);
    private final Path fWx = new Path();
    private final Path fWy = new Path();
    private final Paint fWz = new Paint(1);
    private IconState fWA = IconState.PLAY_STATE;

    /* loaded from: classes7.dex */
    public enum IconState {
        PLAY_STATE,
        PAUSE_STATE
    }

    public PlayDrawable() {
        this.fWz.setColor(-1);
        this.fWs.setDuration(150L);
        this.fWs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.floating.PlayDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PlayDrawable.this.ak(valueAnimator.getAnimatedFraction());
            }
        });
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        bJx();
    }

    private void bJx() {
        Rect bJy = bJy();
        int width = (int) (0.074f * getWidth());
        this.fWt = new float[]{bJy.left + width, bJy.top, ((int) bJz()) + width, (bJy.height() * 0.25f) + bJy.top, ((int) bJz()) + width, (bJy.height() * 0.75f) + bJy.top, bJy.left + width, bJy.height() + bJy.top};
        this.fWu = new float[]{((int) bJz()) + width, (bJy.height() * 0.25f) + bJy.top, bJy.left + bJy.width() + width, bJA(), bJy.left + bJy.width() + width, bJA(), width + ((int) bJz()), (bJy.height() * 0.75f) + bJy.top};
        this.fWv = new float[]{bJy.left, bJy.top, bJy.left + (bJy.width() * 0.285f), bJy.top, bJy.left + (bJy.width() * 0.285f), bJy.top + bJy.height(), bJy.left, bJy.top + bJy.height()};
        this.fWw = new float[]{bJy.left + (bJy.width() * 0.715f), bJy.top, bJy.left + bJy.width(), bJy.top, bJy.left + bJy.width(), bJy.top + bJy.height(), bJy.left + (bJy.width() * 0.715f), bJy.height() + bJy.top};
    }

    private Rect bJy() {
        float width = getWidth();
        float height = getHeight();
        float bJB = bJB();
        float bJC = bJC();
        Rect rect = new Rect();
        rect.left = (int) ((width - bJB) / 2.0f);
        rect.top = (int) ((height - bJC) / 2.0f);
        rect.right = (int) (rect.left + bJB);
        rect.bottom = (int) (rect.top + bJC);
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
        a(fWr, fArr, fArr2, f);
        a(path, fWr);
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

    private float bJz() {
        return getBounds().exactCenterX();
    }

    private float bJA() {
        return getBounds().exactCenterY();
    }

    private float bJB() {
        return 0.33f * getWidth();
    }

    private float bJC() {
        return 0.38f * getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        a(canvas, this.fWt, this.fWv, this.mCurrentFraction, this.fWx, this.fWz);
        a(canvas, this.fWu, this.fWw, this.mCurrentFraction, this.fWy, this.fWz);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.fWz.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.fWz.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    private boolean isRunning() {
        return this.fWs.isRunning();
    }

    public void setIconState(IconState iconState) {
        if (isRunning()) {
            this.fWs.cancel();
        }
        this.mCurrentFraction = iconState == IconState.PLAY_STATE ? 0.0f : 1.0f;
        a(iconState);
        invalidateSelf();
    }

    private void a(IconState iconState) {
        this.fWA = iconState;
    }
}
