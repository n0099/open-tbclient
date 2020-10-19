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
    private static final float[] glW = new float[8];
    private float[] glY;
    private float[] glZ;
    private float[] gma;
    private float[] gmb;
    private float mCurrentFraction;
    private final ValueAnimator glX = ValueAnimator.ofFloat(0.0f, 1.0f);
    private final Path gmc = new Path();
    private final Path gmd = new Path();
    private final Paint gme = new Paint(1);
    private IconState gmf = IconState.PLAY_STATE;

    /* loaded from: classes4.dex */
    public enum IconState {
        PLAY_STATE,
        PAUSE_STATE
    }

    public PlayDrawable() {
        this.gme.setColor(-1);
        this.glX.setDuration(150L);
        this.glX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.floating.PlayDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PlayDrawable.this.am(valueAnimator.getAnimatedFraction());
            }
        });
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        bNr();
    }

    private void bNr() {
        Rect bNs = bNs();
        int width = (int) (0.074f * getWidth());
        this.glY = new float[]{bNs.left + width, bNs.top, ((int) bNt()) + width, (bNs.height() * 0.25f) + bNs.top, ((int) bNt()) + width, (bNs.height() * 0.75f) + bNs.top, bNs.left + width, bNs.height() + bNs.top};
        this.glZ = new float[]{((int) bNt()) + width, (bNs.height() * 0.25f) + bNs.top, bNs.left + bNs.width() + width, bNu(), bNs.left + bNs.width() + width, bNu(), width + ((int) bNt()), (bNs.height() * 0.75f) + bNs.top};
        this.gma = new float[]{bNs.left, bNs.top, bNs.left + (bNs.width() * 0.285f), bNs.top, bNs.left + (bNs.width() * 0.285f), bNs.top + bNs.height(), bNs.left, bNs.top + bNs.height()};
        this.gmb = new float[]{bNs.left + (bNs.width() * 0.715f), bNs.top, bNs.left + bNs.width(), bNs.top, bNs.left + bNs.width(), bNs.top + bNs.height(), bNs.left + (bNs.width() * 0.715f), bNs.height() + bNs.top};
    }

    private Rect bNs() {
        float width = getWidth();
        float height = getHeight();
        float bNv = bNv();
        float bNw = bNw();
        Rect rect = new Rect();
        rect.left = (int) ((width - bNv) / 2.0f);
        rect.top = (int) ((height - bNw) / 2.0f);
        rect.right = (int) (rect.left + bNv);
        rect.bottom = (int) (rect.top + bNw);
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
        a(glW, fArr, fArr2, f);
        a(path, glW);
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
    public void am(float f) {
        this.mCurrentFraction = f;
        invalidateSelf();
    }

    private float getWidth() {
        return getBounds().width();
    }

    private float getHeight() {
        return getBounds().height();
    }

    private float bNt() {
        return getBounds().exactCenterX();
    }

    private float bNu() {
        return getBounds().exactCenterY();
    }

    private float bNv() {
        return 0.33f * getWidth();
    }

    private float bNw() {
        return 0.38f * getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        a(canvas, this.glY, this.gma, this.mCurrentFraction, this.gmc, this.gme);
        a(canvas, this.glZ, this.gmb, this.mCurrentFraction, this.gmd, this.gme);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.gme.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.gme.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    private boolean isRunning() {
        return this.glX.isRunning();
    }

    public void setIconState(IconState iconState) {
        if (isRunning()) {
            this.glX.cancel();
        }
        this.mCurrentFraction = iconState == IconState.PLAY_STATE ? 0.0f : 1.0f;
        a(iconState);
        invalidateSelf();
    }

    private void a(IconState iconState) {
        this.gmf = iconState;
    }
}
