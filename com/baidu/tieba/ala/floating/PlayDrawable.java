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
    private static final float[] gWh = new float[8];
    private float[] gWj;
    private float[] gWk;
    private float[] gWl;
    private float[] gWm;
    private float mCurrentFraction;
    private final ValueAnimator gWi = ValueAnimator.ofFloat(0.0f, 1.0f);
    private final Path gWn = new Path();
    private final Path gWo = new Path();
    private final Paint gWp = new Paint(1);
    private IconState gWq = IconState.PLAY_STATE;

    /* loaded from: classes11.dex */
    public enum IconState {
        PLAY_STATE,
        PAUSE_STATE
    }

    public PlayDrawable() {
        this.gWp.setColor(-1);
        this.gWi.setDuration(150L);
        this.gWi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.floating.PlayDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PlayDrawable.this.av(valueAnimator.getAnimatedFraction());
            }
        });
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        bYf();
    }

    private void bYf() {
        Rect bYg = bYg();
        int width = (int) (0.074f * getWidth());
        this.gWj = new float[]{bYg.left + width, bYg.top, ((int) bYh()) + width, (bYg.height() * 0.25f) + bYg.top, ((int) bYh()) + width, (bYg.height() * 0.75f) + bYg.top, bYg.left + width, bYg.height() + bYg.top};
        this.gWk = new float[]{((int) bYh()) + width, (bYg.height() * 0.25f) + bYg.top, bYg.left + bYg.width() + width, bYi(), bYg.left + bYg.width() + width, bYi(), width + ((int) bYh()), (bYg.height() * 0.75f) + bYg.top};
        this.gWl = new float[]{bYg.left, bYg.top, bYg.left + (bYg.width() * 0.285f), bYg.top, bYg.left + (bYg.width() * 0.285f), bYg.top + bYg.height(), bYg.left, bYg.top + bYg.height()};
        this.gWm = new float[]{bYg.left + (bYg.width() * 0.715f), bYg.top, bYg.left + bYg.width(), bYg.top, bYg.left + bYg.width(), bYg.top + bYg.height(), bYg.left + (bYg.width() * 0.715f), bYg.height() + bYg.top};
    }

    private Rect bYg() {
        float width = getWidth();
        float height = getHeight();
        float bYj = bYj();
        float bYk = bYk();
        Rect rect = new Rect();
        rect.left = (int) ((width - bYj) / 2.0f);
        rect.top = (int) ((height - bYk) / 2.0f);
        rect.right = (int) (rect.left + bYj);
        rect.bottom = (int) (rect.top + bYk);
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
        a(gWh, fArr, fArr2, f);
        a(path, gWh);
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

    private float bYh() {
        return getBounds().exactCenterX();
    }

    private float bYi() {
        return getBounds().exactCenterY();
    }

    private float bYj() {
        return 0.33f * getWidth();
    }

    private float bYk() {
        return 0.38f * getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        a(canvas, this.gWj, this.gWl, this.mCurrentFraction, this.gWn, this.gWp);
        a(canvas, this.gWk, this.gWm, this.mCurrentFraction, this.gWo, this.gWp);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.gWp.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.gWp.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    private boolean isRunning() {
        return this.gWi.isRunning();
    }

    public void setIconState(IconState iconState) {
        if (isRunning()) {
            this.gWi.cancel();
        }
        this.mCurrentFraction = iconState == IconState.PLAY_STATE ? 0.0f : 1.0f;
        a(iconState);
        invalidateSelf();
    }

    private void a(IconState iconState) {
        this.gWq = iconState;
    }
}
