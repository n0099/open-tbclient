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
/* loaded from: classes10.dex */
public class PlayDrawable extends Drawable {
    private static final float[] gRB = new float[8];
    private float[] gRD;
    private float[] gRE;
    private float[] gRF;
    private float[] gRG;
    private float mCurrentFraction;
    private final ValueAnimator gRC = ValueAnimator.ofFloat(0.0f, 1.0f);
    private final Path gRH = new Path();
    private final Path gRI = new Path();
    private final Paint gRJ = new Paint(1);
    private IconState gRK = IconState.PLAY_STATE;

    /* loaded from: classes10.dex */
    public enum IconState {
        PLAY_STATE,
        PAUSE_STATE
    }

    public PlayDrawable() {
        this.gRJ.setColor(-1);
        this.gRC.setDuration(150L);
        this.gRC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.floating.PlayDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PlayDrawable.this.av(valueAnimator.getAnimatedFraction());
            }
        });
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        bUo();
    }

    private void bUo() {
        Rect bUp = bUp();
        int width = (int) (0.074f * getWidth());
        this.gRD = new float[]{bUp.left + width, bUp.top, ((int) bUq()) + width, (bUp.height() * 0.25f) + bUp.top, ((int) bUq()) + width, (bUp.height() * 0.75f) + bUp.top, bUp.left + width, bUp.height() + bUp.top};
        this.gRE = new float[]{((int) bUq()) + width, (bUp.height() * 0.25f) + bUp.top, bUp.left + bUp.width() + width, bUr(), bUp.left + bUp.width() + width, bUr(), width + ((int) bUq()), (bUp.height() * 0.75f) + bUp.top};
        this.gRF = new float[]{bUp.left, bUp.top, bUp.left + (bUp.width() * 0.285f), bUp.top, bUp.left + (bUp.width() * 0.285f), bUp.top + bUp.height(), bUp.left, bUp.top + bUp.height()};
        this.gRG = new float[]{bUp.left + (bUp.width() * 0.715f), bUp.top, bUp.left + bUp.width(), bUp.top, bUp.left + bUp.width(), bUp.top + bUp.height(), bUp.left + (bUp.width() * 0.715f), bUp.height() + bUp.top};
    }

    private Rect bUp() {
        float width = getWidth();
        float height = getHeight();
        float bUs = bUs();
        float bUt = bUt();
        Rect rect = new Rect();
        rect.left = (int) ((width - bUs) / 2.0f);
        rect.top = (int) ((height - bUt) / 2.0f);
        rect.right = (int) (rect.left + bUs);
        rect.bottom = (int) (rect.top + bUt);
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
        a(gRB, fArr, fArr2, f);
        a(path, gRB);
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
    public void av(float f) {
        this.mCurrentFraction = f;
        invalidateSelf();
    }

    private float getWidth() {
        return getBounds().width();
    }

    private float getHeight() {
        return getBounds().height();
    }

    private float bUq() {
        return getBounds().exactCenterX();
    }

    private float bUr() {
        return getBounds().exactCenterY();
    }

    private float bUs() {
        return 0.33f * getWidth();
    }

    private float bUt() {
        return 0.38f * getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        a(canvas, this.gRD, this.gRF, this.mCurrentFraction, this.gRH, this.gRJ);
        a(canvas, this.gRE, this.gRG, this.mCurrentFraction, this.gRI, this.gRJ);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.gRJ.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.gRJ.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    private boolean isRunning() {
        return this.gRC.isRunning();
    }

    public void setIconState(IconState iconState) {
        if (isRunning()) {
            this.gRC.cancel();
        }
        this.mCurrentFraction = iconState == IconState.PLAY_STATE ? 0.0f : 1.0f;
        a(iconState);
        invalidateSelf();
    }

    private void a(IconState iconState) {
        this.gRK = iconState;
    }
}
