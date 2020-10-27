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
    private static final float[] gwb = new float[8];
    private float[] gwd;
    private float[] gwe;
    private float[] gwf;
    private float[] gwg;
    private float mCurrentFraction;
    private final ValueAnimator gwc = ValueAnimator.ofFloat(0.0f, 1.0f);
    private final Path gwh = new Path();
    private final Path gwi = new Path();
    private final Paint gwj = new Paint(1);
    private IconState gwk = IconState.PLAY_STATE;

    /* loaded from: classes4.dex */
    public enum IconState {
        PLAY_STATE,
        PAUSE_STATE
    }

    public PlayDrawable() {
        this.gwj.setColor(-1);
        this.gwc.setDuration(150L);
        this.gwc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.floating.PlayDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PlayDrawable.this.ao(valueAnimator.getAnimatedFraction());
            }
        });
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        bPW();
    }

    private void bPW() {
        Rect bPX = bPX();
        int width = (int) (0.074f * getWidth());
        this.gwd = new float[]{bPX.left + width, bPX.top, ((int) bPY()) + width, (bPX.height() * 0.25f) + bPX.top, ((int) bPY()) + width, (bPX.height() * 0.75f) + bPX.top, bPX.left + width, bPX.height() + bPX.top};
        this.gwe = new float[]{((int) bPY()) + width, (bPX.height() * 0.25f) + bPX.top, bPX.left + bPX.width() + width, bPZ(), bPX.left + bPX.width() + width, bPZ(), width + ((int) bPY()), (bPX.height() * 0.75f) + bPX.top};
        this.gwf = new float[]{bPX.left, bPX.top, bPX.left + (bPX.width() * 0.285f), bPX.top, bPX.left + (bPX.width() * 0.285f), bPX.top + bPX.height(), bPX.left, bPX.top + bPX.height()};
        this.gwg = new float[]{bPX.left + (bPX.width() * 0.715f), bPX.top, bPX.left + bPX.width(), bPX.top, bPX.left + bPX.width(), bPX.top + bPX.height(), bPX.left + (bPX.width() * 0.715f), bPX.height() + bPX.top};
    }

    private Rect bPX() {
        float width = getWidth();
        float height = getHeight();
        float bQa = bQa();
        float bQb = bQb();
        Rect rect = new Rect();
        rect.left = (int) ((width - bQa) / 2.0f);
        rect.top = (int) ((height - bQb) / 2.0f);
        rect.right = (int) (rect.left + bQa);
        rect.bottom = (int) (rect.top + bQb);
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
        a(gwb, fArr, fArr2, f);
        a(path, gwb);
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
    public void ao(float f) {
        this.mCurrentFraction = f;
        invalidateSelf();
    }

    private float getWidth() {
        return getBounds().width();
    }

    private float getHeight() {
        return getBounds().height();
    }

    private float bPY() {
        return getBounds().exactCenterX();
    }

    private float bPZ() {
        return getBounds().exactCenterY();
    }

    private float bQa() {
        return 0.33f * getWidth();
    }

    private float bQb() {
        return 0.38f * getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        a(canvas, this.gwd, this.gwf, this.mCurrentFraction, this.gwh, this.gwj);
        a(canvas, this.gwe, this.gwg, this.mCurrentFraction, this.gwi, this.gwj);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.gwj.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.gwj.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    private boolean isRunning() {
        return this.gwc.isRunning();
    }

    public void setIconState(IconState iconState) {
        if (isRunning()) {
            this.gwc.cancel();
        }
        this.mCurrentFraction = iconState == IconState.PLAY_STATE ? 0.0f : 1.0f;
        a(iconState);
        invalidateSelf();
    }

    private void a(IconState iconState) {
        this.gwk = iconState;
    }
}
