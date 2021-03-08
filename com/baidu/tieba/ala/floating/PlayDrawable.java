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
    private static final float[] gWi = new float[8];
    private float[] gWk;
    private float[] gWl;
    private float[] gWm;
    private float[] gWn;
    private float mCurrentFraction;
    private final ValueAnimator gWj = ValueAnimator.ofFloat(0.0f, 1.0f);
    private final Path gWo = new Path();
    private final Path gWp = new Path();
    private final Paint gWq = new Paint(1);
    private IconState gWr = IconState.PLAY_STATE;

    /* loaded from: classes10.dex */
    public enum IconState {
        PLAY_STATE,
        PAUSE_STATE
    }

    public PlayDrawable() {
        this.gWq.setColor(-1);
        this.gWj.setDuration(150L);
        this.gWj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.floating.PlayDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PlayDrawable.this.aA(valueAnimator.getAnimatedFraction());
            }
        });
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        bVg();
    }

    private void bVg() {
        Rect bVh = bVh();
        int width = (int) (0.074f * getWidth());
        this.gWk = new float[]{bVh.left + width, bVh.top, ((int) bVi()) + width, (bVh.height() * 0.25f) + bVh.top, ((int) bVi()) + width, (bVh.height() * 0.75f) + bVh.top, bVh.left + width, bVh.height() + bVh.top};
        this.gWl = new float[]{((int) bVi()) + width, (bVh.height() * 0.25f) + bVh.top, bVh.left + bVh.width() + width, bVj(), bVh.left + bVh.width() + width, bVj(), width + ((int) bVi()), (bVh.height() * 0.75f) + bVh.top};
        this.gWm = new float[]{bVh.left, bVh.top, bVh.left + (bVh.width() * 0.285f), bVh.top, bVh.left + (bVh.width() * 0.285f), bVh.top + bVh.height(), bVh.left, bVh.top + bVh.height()};
        this.gWn = new float[]{bVh.left + (bVh.width() * 0.715f), bVh.top, bVh.left + bVh.width(), bVh.top, bVh.left + bVh.width(), bVh.top + bVh.height(), bVh.left + (bVh.width() * 0.715f), bVh.height() + bVh.top};
    }

    private Rect bVh() {
        float width = getWidth();
        float height = getHeight();
        float bVk = bVk();
        float bVl = bVl();
        Rect rect = new Rect();
        rect.left = (int) ((width - bVk) / 2.0f);
        rect.top = (int) ((height - bVl) / 2.0f);
        rect.right = (int) (rect.left + bVk);
        rect.bottom = (int) (rect.top + bVl);
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
        a(gWi, fArr, fArr2, f);
        a(path, gWi);
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
    public void aA(float f) {
        this.mCurrentFraction = f;
        invalidateSelf();
    }

    private float getWidth() {
        return getBounds().width();
    }

    private float getHeight() {
        return getBounds().height();
    }

    private float bVi() {
        return getBounds().exactCenterX();
    }

    private float bVj() {
        return getBounds().exactCenterY();
    }

    private float bVk() {
        return 0.33f * getWidth();
    }

    private float bVl() {
        return 0.38f * getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        a(canvas, this.gWk, this.gWm, this.mCurrentFraction, this.gWo, this.gWq);
        a(canvas, this.gWl, this.gWn, this.mCurrentFraction, this.gWp, this.gWq);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.gWq.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.gWq.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    private boolean isRunning() {
        return this.gWj.isRunning();
    }

    public void setIconState(IconState iconState) {
        if (isRunning()) {
            this.gWj.cancel();
        }
        this.mCurrentFraction = iconState == IconState.PLAY_STATE ? 0.0f : 1.0f;
        a(iconState);
        invalidateSelf();
    }

    private void a(IconState iconState) {
        this.gWr = iconState;
    }
}
