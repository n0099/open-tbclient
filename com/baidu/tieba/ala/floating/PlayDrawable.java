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
    private static final float[] gUl = new float[8];
    private float[] gUn;
    private float[] gUo;
    private float[] gUp;
    private float[] gUq;
    private float mCurrentFraction;
    private final ValueAnimator gUm = ValueAnimator.ofFloat(0.0f, 1.0f);
    private final Path gUr = new Path();
    private final Path gUs = new Path();
    private final Paint gUt = new Paint(1);
    private IconState gUu = IconState.PLAY_STATE;

    /* loaded from: classes11.dex */
    public enum IconState {
        PLAY_STATE,
        PAUSE_STATE
    }

    public PlayDrawable() {
        this.gUt.setColor(-1);
        this.gUm.setDuration(150L);
        this.gUm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.floating.PlayDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PlayDrawable.this.aw(valueAnimator.getAnimatedFraction());
            }
        });
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        bUT();
    }

    private void bUT() {
        Rect bUU = bUU();
        int width = (int) (0.074f * getWidth());
        this.gUn = new float[]{bUU.left + width, bUU.top, ((int) bUV()) + width, (bUU.height() * 0.25f) + bUU.top, ((int) bUV()) + width, (bUU.height() * 0.75f) + bUU.top, bUU.left + width, bUU.height() + bUU.top};
        this.gUo = new float[]{((int) bUV()) + width, (bUU.height() * 0.25f) + bUU.top, bUU.left + bUU.width() + width, bUW(), bUU.left + bUU.width() + width, bUW(), width + ((int) bUV()), (bUU.height() * 0.75f) + bUU.top};
        this.gUp = new float[]{bUU.left, bUU.top, bUU.left + (bUU.width() * 0.285f), bUU.top, bUU.left + (bUU.width() * 0.285f), bUU.top + bUU.height(), bUU.left, bUU.top + bUU.height()};
        this.gUq = new float[]{bUU.left + (bUU.width() * 0.715f), bUU.top, bUU.left + bUU.width(), bUU.top, bUU.left + bUU.width(), bUU.top + bUU.height(), bUU.left + (bUU.width() * 0.715f), bUU.height() + bUU.top};
    }

    private Rect bUU() {
        float width = getWidth();
        float height = getHeight();
        float bUX = bUX();
        float bUY = bUY();
        Rect rect = new Rect();
        rect.left = (int) ((width - bUX) / 2.0f);
        rect.top = (int) ((height - bUY) / 2.0f);
        rect.right = (int) (rect.left + bUX);
        rect.bottom = (int) (rect.top + bUY);
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
        a(gUl, fArr, fArr2, f);
        a(path, gUl);
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

    private float bUV() {
        return getBounds().exactCenterX();
    }

    private float bUW() {
        return getBounds().exactCenterY();
    }

    private float bUX() {
        return 0.33f * getWidth();
    }

    private float bUY() {
        return 0.38f * getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        a(canvas, this.gUn, this.gUp, this.mCurrentFraction, this.gUr, this.gUt);
        a(canvas, this.gUo, this.gUq, this.mCurrentFraction, this.gUs, this.gUt);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.gUt.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.gUt.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    private boolean isRunning() {
        return this.gUm.isRunning();
    }

    public void setIconState(IconState iconState) {
        if (isRunning()) {
            this.gUm.cancel();
        }
        this.mCurrentFraction = iconState == IconState.PLAY_STATE ? 0.0f : 1.0f;
        a(iconState);
        invalidateSelf();
    }

    private void a(IconState iconState) {
        this.gUu = iconState;
    }
}
