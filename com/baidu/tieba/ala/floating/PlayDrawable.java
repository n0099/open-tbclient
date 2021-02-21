package com.baidu.tieba.ala.floating;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes11.dex */
public class PlayDrawable extends Drawable {
    private static final float[] gUz = new float[8];
    private float[] gUB;
    private float[] gUC;
    private float[] gUD;
    private float[] gUE;
    private float mCurrentFraction;
    private final ValueAnimator gUA = ValueAnimator.ofFloat(0.0f, 1.0f);
    private final Path gUF = new Path();
    private final Path gUG = new Path();
    private final Paint gUH = new Paint(1);
    private IconState gUI = IconState.PLAY_STATE;

    /* loaded from: classes11.dex */
    public enum IconState {
        PLAY_STATE,
        PAUSE_STATE
    }

    public PlayDrawable() {
        this.gUH.setColor(-1);
        this.gUA.setDuration(150L);
        this.gUA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.floating.PlayDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PlayDrawable.this.aw(valueAnimator.getAnimatedFraction());
            }
        });
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        bVa();
    }

    private void bVa() {
        Rect bVb = bVb();
        int width = (int) (0.074f * getWidth());
        this.gUB = new float[]{bVb.left + width, bVb.top, ((int) bVc()) + width, (bVb.height() * 0.25f) + bVb.top, ((int) bVc()) + width, (bVb.height() * 0.75f) + bVb.top, bVb.left + width, bVb.height() + bVb.top};
        this.gUC = new float[]{((int) bVc()) + width, (bVb.height() * 0.25f) + bVb.top, bVb.left + bVb.width() + width, bVd(), bVb.left + bVb.width() + width, bVd(), width + ((int) bVc()), (bVb.height() * 0.75f) + bVb.top};
        this.gUD = new float[]{bVb.left, bVb.top, bVb.left + (bVb.width() * 0.285f), bVb.top, bVb.left + (bVb.width() * 0.285f), bVb.top + bVb.height(), bVb.left, bVb.top + bVb.height()};
        this.gUE = new float[]{bVb.left + (bVb.width() * 0.715f), bVb.top, bVb.left + bVb.width(), bVb.top, bVb.left + bVb.width(), bVb.top + bVb.height(), bVb.left + (bVb.width() * 0.715f), bVb.height() + bVb.top};
    }

    private Rect bVb() {
        float width = getWidth();
        float height = getHeight();
        float bVe = bVe();
        float bVf = bVf();
        Rect rect = new Rect();
        rect.left = (int) ((width - bVe) / 2.0f);
        rect.top = (int) ((height - bVf) / 2.0f);
        rect.right = (int) (rect.left + bVe);
        rect.bottom = (int) (rect.top + bVf);
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
        a(gUz, fArr, fArr2, f);
        a(path, gUz);
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
    public void aw(float f) {
        this.mCurrentFraction = f;
        invalidateSelf();
    }

    private float getWidth() {
        return getBounds().width();
    }

    private float getHeight() {
        return getBounds().height();
    }

    private float bVc() {
        return getBounds().exactCenterX();
    }

    private float bVd() {
        return getBounds().exactCenterY();
    }

    private float bVe() {
        return 0.33f * getWidth();
    }

    private float bVf() {
        return 0.38f * getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        a(canvas, this.gUB, this.gUD, this.mCurrentFraction, this.gUF, this.gUH);
        a(canvas, this.gUC, this.gUE, this.mCurrentFraction, this.gUG, this.gUH);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.gUH.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.gUH.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    private boolean isRunning() {
        return this.gUA.isRunning();
    }

    public void setIconState(IconState iconState) {
        if (isRunning()) {
            this.gUA.cancel();
        }
        this.mCurrentFraction = iconState == IconState.PLAY_STATE ? 0.0f : 1.0f;
        a(iconState);
        invalidateSelf();
    }

    private void a(IconState iconState) {
        this.gUI = iconState;
    }
}
